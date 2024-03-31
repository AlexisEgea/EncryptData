
import org.jasypt.util.text.BasicTextEncryptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EncryptData {

    //This variable is only here to put a print of my work (Alx = Alexis (my name) and enc = encode)
    private final String enc_prefix = "Alx_enc(";
    private final BasicTextEncryptor textEncryptor;

    public EncryptData(String key){
        this.textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPasswordCharArray(key.toCharArray());
    }

    public String encodeData(String privateData){
        if(!privateData.contains(this.enc_prefix))
        return this.enc_prefix + this.textEncryptor.encrypt(privateData) + ")";
        else
            System.err.println("Already encoded data");
        return null;
    }

    public String decodeData(String encodeData){
        if(encodeData.contains(this.enc_prefix))
            return this.textEncryptor.decrypt(encodeData.substring(this.enc_prefix.length(), encodeData.length() - 1));
        else{
            System.err.println("Invalid or not encoded data");
            return null;
        }
    }

    /**
     * Encode and Update Excel File by replacing previous value on the same row of nameToEncode by the encoded one
     * Example: Excel File -> First Column = nameToEncode = "Password", Second Column = value of nameToEncode = "My password"
     * @param fileLocation: Path to the Excel File
     * @param nameToEncode: First Column to indicate where to find the value to get (Basically the next column & same row)
     * @return the encoded data and replacing the not encoded data in the Excel File
     * @throws IOException
     */
    public String encodeDataOnExcel(String fileLocation, String nameToEncode) throws IOException {
        Map<String, String> tab_map = ExcelData.getStringValueFromExcel(fileLocation);
        List<String> listWithEncData = new ArrayList<>();
        listWithEncData.add(nameToEncode);
        String encodeData = this.encodeData(tab_map.get(nameToEncode));
        if(encodeData != null){
            listWithEncData.add(encodeData);
            ExcelData.update(fileLocation, listWithEncData);
        }
        return encodeData;
    }

    /**
     * Get the value to decode and return it without update the Excel File
     * @param fileLocation: Path to the Excel File
     * @param nameToDecode: First Column to indicate where to find the value to get (Basically the next column & same row)
     * @return the decoded value from Excel File
     */
    public String decodeDataFromExcel(String fileLocation, String nameToDecode) throws IOException {
        Map<String, String> tab_map = ExcelData.getStringValueFromExcel(fileLocation);
        String decodeData = this.decodeData(tab_map.get(nameToDecode));
        if(decodeData != null)
            tab_map.put(nameToDecode, decodeData);
        else
            System.err.println(nameToDecode + " value already decoded or null");
        return decodeData;
    }
}
