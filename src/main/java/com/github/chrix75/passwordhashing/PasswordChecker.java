package com.github.chrix75.passwordhashing;

import java.util.Base64;

public class PasswordChecker {

    private final Hash hash;
    private final String clearPassword;
    private final Salt salt;

    public PasswordChecker(String encodedHash, String clearPassword, String encodedSalt) {
        this.hash = new Hash(Base64.getDecoder().decode(encodedHash));
        this.clearPassword = clearPassword;
        this.salt = new Salt(Base64.getDecoder().decode(encodedSalt));
    }

    public boolean isCorrect() {
        Hash tested = new Hash(clearPassword, salt);
        return tested.equals(hash);
    }
}
