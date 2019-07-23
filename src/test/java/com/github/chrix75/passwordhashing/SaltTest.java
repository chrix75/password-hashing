package com.github.chrix75.passwordhashing;

import org.junit.Test;

import static org.junit.Assert.*;

public class SaltTest {

    @Test
    public void show_salt() {
        Salt salt = new Salt(16);
        System.out.println("Salt:" + salt);
    }
}