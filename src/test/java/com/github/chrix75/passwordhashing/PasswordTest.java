package com.github.chrix75.passwordhashing;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordTest {

    @Test
    public void same_password() {
        Salt salt = new Salt(16);
        String encodedSalt = salt.toString();

        Hash hash = new Hash("PASSWORD", salt);
        String encodedPassword = hash.toString();

        PasswordChecker checker = new PasswordChecker(encodedPassword, "PASSWORD", encodedSalt);
        assertTrue(checker.isCorrect());
    }

    @Test
    public void different_passwords() {
        Salt salt = new Salt(16);
        String encodedSalt = salt.toString();

        Hash hash = new Hash("PASSWORD", salt);
        String encodedPassword = hash.toString();

        PasswordChecker checker = new PasswordChecker(encodedPassword, "OTHER_PASSWORD", encodedSalt);
        assertFalse(checker.isCorrect());
    }

    @Test
    public void different_salt() {
        Salt salt = new Salt(16);
        String encodedSalt = salt.toString();

        Hash hash = new Hash("PASSWORD", new Salt(16));
        String encodedPassword = hash.toString();

        PasswordChecker checker = new PasswordChecker(encodedPassword, "PASSWORD", encodedSalt);
        assertFalse(checker.isCorrect());
    }
}