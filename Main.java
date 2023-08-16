import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static String SPACE = ",";

    public static void main(String[] args) throws IOException {
        BufferedReader cadena = null;
        try {
            cadena = new BufferedReader(new FileReader("C:/Users/uziel/Downloads/codigos_postales_hmo"));
            String rline = cadena.readLine();
            HashMap<String, Integer> count = new HashMap<>();
            while (rline != null) {
                String[] celdas = rline.split(SPACE);

                for (String s : celdas) {
                    String seisCarac = s.substring(0, Math.min(6, s.length()));
                    count.put(seisCarac, count.getOrDefault(seisCarac, 0) + 1);
                }
                rline = cadena.readLine();
            }
            for (String s : count.keySet()) {
                int repeticiones = count.get(s);
                if (repeticiones > 1) {
                    System.out.println("Codigo postal:" + s + "Repeticiones:" + repeticiones);
                }
            }
        } finally {
                if (cadena != null) {
                    try {
                        cadena.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
