package com.github.chrix75.passwordhashing;

import org.junit.Test;

import java.util.Base64;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HashTest {
    @Test
    public void same_password_different_salts() {
        Hash h1 = new Hash("PASSWORD", new Salt(16));
        Hash h2 = new Hash("PASSWORD", new Salt(16));

        System.out.println("Hash1: " + h1);
        System.out.println("Hash2: " + h2);
        assertNotEquals(h2, h1);
    }

    @Test
    public void different_password_same_salt() {
        Salt salt = new Salt(16);
        Salt sameSalt = new Salt(Base64.getDecoder().decode(salt.toString()));
        Hash h1 = new Hash("PASSWORD", salt);
        Hash h2 = new Hash("OTHER", sameSalt);

        System.out.println("Hash1: " + h1);
        System.out.println("Hash2: " + h2);
        assertNotEquals(h2, h1);
    }

    @Test
    public void same_password_with_same_salt() {
        Salt salt = new Salt(16);
        Salt sameSalt = new Salt(Base64.getDecoder().decode(salt.toString()));
        Hash h1 = new Hash("PASSWORD", salt);
        Hash h2 = new Hash("PASSWORD", sameSalt);

        System.out.println("Hash1: " + h1);
        System.out.println("Hash2: " + h2);
        assertEquals(h2, h1);
    }
}