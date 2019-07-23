package com.github.chrix75.passwordhashing;

import java.security.SecureRandom;
import java.util.Base64;

final public class Salt {

    private final int length;
    private byte[] value;

    public Salt(int length) {
        this.length = length;
    }

    public Salt(byte[] value) {
        this.length = -1;
        this.value = value;
    }


    public byte[] value() {
        if (value == null) {
            SecureRandom random = new SecureRandom();
            value = new byte[length];
            random.nextBytes(value);
        }

        return value;
    }

    @Override
    public String toString() {
        return Base64.getEncoder().encodeToString(value());
    }
}
