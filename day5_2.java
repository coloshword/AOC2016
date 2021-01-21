import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.ArrayList;

public class day5_2 {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String key = "abbhdwsy";
        //int end = 1;
        int end = 1;
        String password = "00000000";
        int length = 0;
        ArrayList<Integer> invalidIndices = new ArrayList<>();
        while(length < 8) {
            String md5 = getMD5(key + end);
            if(md5.substring(0, 5).equals("00000")){
                try{
                    int index = Integer.parseInt("" + md5.charAt(5));
                    if(index < 8 && (!invalidIndices.contains(index))) {
                        invalidIndices.add(index);
                        password = changePW(password, Integer.parseInt("" + md5.charAt(5)), md5.charAt(6));
                        System.out.println(password);
                        length++;
                    }
                }
                catch (Exception e) {
                    end++;
                    continue;
                }
            }
            end++;
        }
        System.out.println(password);
    }

    public static String changePW(String original, int index, char replace) {
        return original.substring(0, index) + replace + original.substring(index + 1, original.length());
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
