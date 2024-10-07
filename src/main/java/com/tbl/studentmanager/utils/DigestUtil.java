package com.tbl.studentmanager.utils;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtil {
    public static String getSHA256Hex(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes());

            return DatatypeConverter.printHexBinary(hash).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not generate SHA-256 hash", e);
        }
    }
}
