package cryptocrack;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // final var tmp = new Generator();
    final var sc = new Scanner(System.in);

    System.out.println("Welcome to CryptoHack!!!");
    System.out.print(
        """
                Select the hashing algorithm
                1) SHA-256
                2) SHA-512
                """);
    final var opHash = sc.nextInt();
    final var hashingAlgorithm =
        switch (opHash) {
          case 1 -> "SHA-256";
          case 2 -> "SHA-512";
          default -> throw new RuntimeException("The option is incorrect.");
        };

    System.out.print("Enter the hash: ");
    final var hash = sc.next();

    System.out.print("Enter the salt: ");
    final var salt = sc.next();

    System.out.print("Enter the number of threads: ");
    final var threadNumber = sc.nextInt();

    final var program = new CryptoHack(hashingAlgorithm, hash, salt, threadNumber);
    program.run();
  }
}
