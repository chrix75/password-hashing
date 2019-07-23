package com.github.chrix75.passwordhashing;

final public class HashedPassword {
    private final Salt salt;
    private final Hash hash;

    public HashedPassword(Salt salt, Hash hash) {
        this.salt = salt;
        this.hash = hash;
    }
}
