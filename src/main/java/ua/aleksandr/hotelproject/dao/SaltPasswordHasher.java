package ua.aleksandr.hotelproject.dao;

import java.security.NoSuchAlgorithmException;

public interface SaltPasswordHasher {

    String hash(String password, byte[] salt);

    byte[] getSalt() throws NoSuchAlgorithmException;

}
