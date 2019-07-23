package com.github.chrix75.passwordhashing;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

/**
 * Computes the hash of a password.
 */
final public class Hash {

    private final String password;
    private final Salt salt;
    private byte[] value;

    /**
     * Configure the hash by a password and a {@link Salt}.
     *
     * @param password
     * @param salt
     */
    public Hash(String password, Salt salt) {
        this.password = password;
        this.salt = salt;
    }

    /**
     * Builds a hash from a previously compute hashing.
     *
     * @param value
     */
    public Hash(byte[] value) {
        this.password = null;
        this.salt = null;
        this.value = value;
    }

    public Salt getSalt() {
        return salt;
    }

    /**
     * Returns the hash value of the password
     *
     * @return The hash value in a binary format.
     * @throws RuntimeException raised if hashing fails.
     */
    public byte[] value() throws RuntimeException {
        if (value == null) {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.value(), 65536, 128);
            try {
                SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                value = factory.generateSecret(spec).getEncoded();
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                throw new RuntimeException("Can't build SecretKeyFactory.", e);
            }
        }

        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Hash && Arrays.equals(value(), ((Hash) obj).value());
    }

    /**
     * Returns the hash of the password in a string.
     * <p>
     * The string is a base 64 encoded.
     *
     * @return A base 64 encoded string.
     */
    @Override
    public String toString() {
        return Base64.getEncoder().encodeToString(value());
    }
}
