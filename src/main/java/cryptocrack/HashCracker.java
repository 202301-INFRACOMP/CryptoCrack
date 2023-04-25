package cryptocrack;

import java.security.MessageDigest;

public class HashCracker implements Runnable {
  private final MessageDigest hasher;

  private final String hash;

  private final String salt;

  private final CompleteFlag flag;

  private final Result result;

  public HashCracker(
      MessageDigest hasher, String hash, String salt, CompleteFlag flag, Result result) {
    this.hasher = hasher;
    this.hash = hash;
    this.salt = salt;
    this.flag = flag;
    this.result = result;
  }

  @Override
  public void run() {
    while (!flag.isCompleted()) {
      String searchWord = "hola";

      var payload = (salt + searchWord).getBytes();
      var bytes = hasher.digest(payload);

      var searchHash = bytesToHex(bytes);

      if (searchHash.equals(hash)) {
        result.setResult(searchWord);
        flag.complete();
      }
    }
  }

  private static String bytesToHex(byte[] hash) {
    StringBuilder hexString = new StringBuilder(2 * hash.length);
    for (int i = 0; i < hash.length; i++) {
      String hex = Integer.toHexString(0xff & hash[i]);
      if (hex.length() == 1) {
        hexString.append('0');
      }
      hexString.append(hex);
    }
    return hexString.toString().toUpperCase();
  }
}
