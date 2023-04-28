package cryptocrack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Generator implements Iterator<String> {
  private final String alfabeto;
  private final int maxLongitud;
  private int longitudActual;
  private long index;

  public Generator(String alfabeto, int maxLongitud) {
    this.alfabeto = alfabeto;
    this.maxLongitud = maxLongitud;
    this.longitudActual = 1;
    this.index = 0;
  }

  @Override
  public boolean hasNext() {
    return longitudActual <= maxLongitud && index < Math.pow(alfabeto.length(), longitudActual);
  }

  @Override
  public String next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }

    final StringBuilder sb = new StringBuilder();
    for (int i = longitudActual - 1; i >= 0; i--) {
      int idx = (int) (index / Math.pow(alfabeto.length(), i)) % alfabeto.length();
      sb.append(alfabeto.charAt(idx));
    }

    index++;
    if (index >= Math.pow(alfabeto.length(), longitudActual)) {
      index = 0;
      longitudActual++;
    }

    return sb.reverse().toString();
  }

  public int getLongitudActual() {
    return longitudActual;
  }

  public static void main(String[] args) throws IOException {
    Generator iter = new Generator("abcdefghijklmnopqrstuvwxyz", 7);
    String ruta = "src/main/java/cryptocrack/data/a.txt";
    File archivo = new File(ruta);
    FileWriter fw = new FileWriter(archivo);
    BufferedWriter bw;
    bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(bw);

    String ruta2 = "src/main/java/cryptocrack/data/b.txt";
    File archivo2 = new File(ruta2);
    FileWriter fw2 = new FileWriter(archivo2);
    BufferedWriter bw2;
    bw2 = new BufferedWriter(fw2);
    PrintWriter pw2 = new PrintWriter(bw2);

    String ruta3 = "src/main/java/cryptocrack/data/c.txt";
    File archivo3 = new File(ruta3);
    FileWriter fw3 = new FileWriter(archivo3);
    BufferedWriter bw3;
    bw3 = new BufferedWriter(fw3);
    PrintWriter pw3 = new PrintWriter(bw3);

    try {
      while (iter.hasNext()) {
        if (iter.longitudActual <= 5) {
          System.out.println("Entro a A");
          pw.write(iter.next());
          pw.write("\n");  
        }
        if (iter.longitudActual == 6) {
          System.out.println("Entro a B");
          pw2.write(iter.next());
          pw2.write("\n");  
        }
        if (iter.longitudActual == 7) {
          System.out.println("Entro a C");
          pw3.write(iter.next());
          pw3.write("\n");  
        }
      }
      pw.close();
      bw.close();
      pw2.close();
      bw2.close();
      pw3.close();
      bw3.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("Terminó...");
  }
}
