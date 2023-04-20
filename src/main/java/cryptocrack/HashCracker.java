package cryptocrack;

import java.security.MessageDigest;

public class HashCracker implements Runnable {
    private final MessageDigest hasher;

    private final String hash;

    private final String salt;

    private final CompleteFlag flag;

    private final Result result;

    public HashCracker(MessageDigest hasher, String hash, String salt, CompleteFlag flag, Result result) {
        this.hasher = hasher;
        this.hash = hash;
        this.salt = salt;
        this.flag = flag;
        this.result = result;
    }

    @Override
    public void run() {
        while (true) {
            // hasher.digest()
            // if coincide .. then
        }
    }
}
