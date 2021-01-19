import java.io.UnsupportedEncodingException;
import java.security.*;

public class day5 {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String key = "abbhdwsy";
        int end = 1;
        String password = "";
        while(password.length() < 8) {
            String md5 = getMD5(key + end);
            if(md5.substring(0, 5).equals("00000")) {
                password += md5.charAt(5);
                System.out.println(password);
            }
            end++;
        }
        System.out.println(password);
    }
    
    public static String getMD5(String id) throws UnsupportedEncodingException, NoSuchAlgorithmException {
            byte[] bytesOfMessage = id.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digested = md.digest(bytesOfMessage);
            String hash = "";
            for (byte b : digested) {
                hash +=  String.format("%02X", b);
            }
            return hash;
        }
}
