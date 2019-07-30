# password-hashing

This Java library provides a way for password hashing.

## Usage

The uage of this library rests on 2 classes.
The first one is the `Salt` that returns a random salt. 

The second one is `Hash` that uses the previously computed salt to process the password hashing.

## Examples

### Getting a salt

```
Salt salt = new Salt(16);
String encodedSalt = salt.toString();
```

The `toString` method returns the salut value into a base 64 encoded string. It's useful for saving the salt value.

### Hashing a password

```
Hash hash = new Hash("PASSWORD", salt);
String encodedPassword = hash.toString();
```

The `toString` method returns the hashed password into a base 64 encoded string.

### Checking password correctness

```
PasswordChecker checker = new PasswordChecker(encodedPassword, "PASSWORD", encodedSalt);
assertTrue(checker.isCorrect());
```
