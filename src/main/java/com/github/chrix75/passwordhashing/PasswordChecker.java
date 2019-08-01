package com.github.chrix75.passwordhashing;

import java.util.Base64;

/**
 * Checks if a clear password matches with a hashed password.
 */
public class PasswordChecker {

    private final Hash hash;
    private final String clearPassword;
    private final Salt salt;

    /**
     * Builds an object to check if a clear password  matches with a hashed password.
     * <p>
     * The encoded String are base 64 encoded.
     *
     * @param encodedHash Hashed password
     * @param clearPassword Password will be compared with the hashed password
     * @param encodedSalt The used salt for password hashing
     */
    public PasswordChecker(String encodedHash, String clearPassword, String encodedSalt) {
        this.salt = new Salt(Base64.getDecoder().decode(encodedSalt));
        this.hash = new Hash(Base64.getDecoder().decode(encodedHash), salt);
        this.clearPassword = clearPassword;
    }

    /**
     * Checks the clear password matches with a hashed password.
     *
     * @return true if the clear password matches.
     */
    public boolean isCorrect() {
        Hash tested = new Hash(clearPassword, salt);
        return tested.equals(hash);
    }
}
