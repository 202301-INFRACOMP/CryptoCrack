package cryptocrack;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CryptoHack implements Runnable {

    private final String hashingAlgorithm;

    private final String hash;

    private final String salt;

    private final ExecutorService executor;

    public CryptoHack(String hashingAlgorithm, String hash, String salt, int threadNumber) {
        this.hashingAlgorithm = hashingAlgorithm;
        this.hash = hash;
        this.salt = salt;
        this.executor = Executors.newFixedThreadPool(threadNumber);
    }

    @Override
    public void run() {
        MessageDigest hasher;
        try {
            hasher = MessageDigest.getInstance(hashingAlgorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        final var flag = new CompleteFlag();
        final var result = new Result();
        executor.execute(new HashCracker(hasher, hash, salt, flag, result));

        executor.shutdown();
    }
}
