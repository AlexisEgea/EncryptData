import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DecodeData {
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

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter your key to get your password: ");
        String key = scanner.nextLine();

        EncryptData enc = new EncryptData(key);
        String decodeData = enc.decodeDataFromExcel(path, data);

        PrintWriter writer = new PrintWriter("getYourPwd.txt", "UTF-8");
        writer.println("Your Password is: " + decodeData);
        writer.println("Please, don't forget to remove this file after recovering your password");
        writer.close();
        System.out.println("File 'getYourPwd' is created and contains your decoded password");
    }
}
