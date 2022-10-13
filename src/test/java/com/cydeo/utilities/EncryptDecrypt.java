package com.cydeo.utilities;

import java.util.Base64;

public class EncryptDecrypt {
    public static void main(String[] args) {
        String password = "HsnAkd";
        System.out.println("Password = " + password);

        byte[] encrypt = Base64.getEncoder().encode(password.getBytes());
        System.out.println("Encrypted password is : " + new String(encrypt));

        byte[] decrypt = Base64.getDecoder().decode(encrypt);
        System.out.println("Decrypted password is : " + new String(decrypt));
    }
}
