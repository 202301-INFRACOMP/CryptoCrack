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
        var startTime = System.nanoTime();

        MessageDigest hasher;
        try {
            hasher = MessageDigest.getInstance(hashingAlgorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        final var flag = new CompleteFlag();
        final var result = new Result();
        executor.execute(new HashCracker(hasher, hash, salt, flag, result));

        while (!flag.isCompleted()) {}

        var endTime = System.nanoTime();

        var elapsedTime = endTime - startTime;
        var timeInSeconds = elapsedTime * (long)1e6;

        System.out.printf("The string used to generate %s is %s. With salt %s.\n", hash, result.getMessage(), salt);
        System.out.printf("It took %d seconds to brute-force the hash.", timeInSeconds);

        executor.shutdown();
    }
}
