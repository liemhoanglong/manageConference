/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferenceproject;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author LONG LIN
 */
public class hash {
    public static String encode​Ceasar(String text, int n) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if ((int) text.charAt(i) > 64 && (int) text.charAt(i) < 91) {
                result += (char) (((int) text.charAt(i) + n - 65) % 26 + 65);
            } else if ((int) text.charAt(i) > 96 && (int) text.charAt(i) < 123) {
                result += (char) (((int) text.charAt(i) + n - 97) % 26 + 97);
            } else
                result += text.charAt(i);
        }
        return result;
    }
    public static String getMd5(String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
