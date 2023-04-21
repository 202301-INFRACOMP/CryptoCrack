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
}
//     public static void main(String[] args) throws IOException {
//         String ruta = "src/main/java/cryptocrack/data/permutations.txt";
//         File archivo = new File(ruta);
//         FileWriter fw = new FileWriter(archivo);
//         BufferedWriter bw;
//         bw = new BufferedWriter(fw);
//         PrintWriter pw = new PrintWriter(bw);
//         Generator iter = new Generator("abcdefghijklmnopqrstuvwxyz", 7);
//         try {
//             while (iter.hasNext()) {    
//                 pw.write(iter.next());
//                 pw.write("\n");
//                 System.out.println("Imprimiendo...");
//             }
//             pw.close();
//             bw.close();
//         } catch (IOException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }
//     }
// }
