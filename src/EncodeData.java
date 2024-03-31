import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class EncodeData {
    public static void main(String[] args) throws IOException {
        String path = "";
        String data = "";

        //Set path variable from arguments passed as parameters
        int index = 0;
        for(int i=0; i<args[i].length(); i++){
            if(args[i].equals("Password")){
                index = i;
                path = path.substring(0, path.length() - 1);
                break;
            } else
                path += args[i] + " ";
        }

        //Set data from the rest of the arguments
        for (int i = index; i < args.length; i++){
            if(i == args.length-1)
                data += args[i];
            else
                data += args[i] + " ";
        }

        // Create a unique key by generating secure random bytes and convert it to a string representation.
        int keyLength = 32;
        SecureRandom random = new SecureRandom();
        byte[] keyBytes = new byte[keyLength];
        random.nextBytes(keyBytes);
        String key = Base64.getEncoder().encodeToString(keyBytes);

        EncryptData enc = new EncryptData(key);
        String encodedData = enc.encodeDataOnExcel(path, data);
        if(encodedData != null){
            System.out.println("Your password is correctly encrypted in your Excel File");

            PrintWriter writer = new PrintWriter("Key.txt", StandardCharsets.UTF_8);
            writer.println("Your key to decode your password is: " + key);
            writer.println("Please, don't loose this key, without this key, it's impossible to get back the decoded password.");
            writer.close();
            System.out.println("File 'Key' is created and contains your key to decode your encrypted data (important to keep)");
        }
    }
}
