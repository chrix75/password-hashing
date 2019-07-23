package com.github.chrix75.passwordhashing;

import org.junit.Test;

import static org.junit.Assert.*;

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
        Hash h1 = new Hash("PASSWORD", salt);
        Hash h2 = new Hash("OTHER", salt);

        System.out.println("Hash1: " + h1);
        System.out.println("Hash2: " + h2);
        assertNotEquals(h2, h1);
    }

    @Test
    public void same_password_with_same_salt() {
        Salt salt = new Salt(16);
        Hash h1 = new Hash("PASSWORD", salt);
        Hash h2 = new Hash("PASSWORD", salt);

        System.out.println("Hash1: " + h1);
        System.out.println("Hash2: " + h2);
        assertEquals(h2, h1);
    }
}