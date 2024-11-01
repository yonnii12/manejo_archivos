import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String ruta = "D:/TallerLectura/test.txt";

        List<Integer> notas = new ArrayList<>();

        try (BufferedReader lectura = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = lectura.readLine()) != null) {

                try {
                    int nota = Integer.parseInt(linea);
                    notas.add(nota);
                } catch (NumberFormatException e) {

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("La ruta del archivo es incorrecta: " + e.getMessage());
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        int mayor = notas.get(0);
        for (int nota : notas) {
            if (nota > mayor) {
                mayor = nota;
            }
        }

        int menor = notas.get(0);
        for (int nota : notas) {
            if (nota < menor) {
                menor = nota;
            }
        }
        double suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        double promedio = suma / notas.size();

        System.out.println("El promedio: " + promedio);
        System.out.println("El número mayor: " + mayor);
        System.out.println("El número menor: " + menor);
    }
}