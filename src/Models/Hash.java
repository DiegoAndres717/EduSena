package Models;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class Hash {

    /* Retorna un Hash a partir de un tipo y un texto */
    public static String getHash(String txt, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /* Retorna un Hash MD5 a partir de un texto */
    public static String md5(String txt) {
        return Hash.getHash(txt, "MD5");
    }

    /* Retorna un Hash SHA1 a partir de un texto */
    public static String sha1(String txt) {
        return Hash.getHash(txt, "SHA1");
    }

    public static String encryptPassword(String password) {
        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
        }
        return sha1;
    }

    public static String byteToHex(final byte[] hash) {
        String result;
        try (Formatter formatter = new Formatter()) {
            for (byte b : hash) {
                formatter.format("%02x", b);
            }   result = formatter.toString();
        }
        return result;
    }
}
