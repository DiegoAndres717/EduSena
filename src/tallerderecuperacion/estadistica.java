package tallerderecuperacion;

  import java.util.Scanner;
  import java.util.Arrays;

public class estadistica {
  
     int elementos[];
    int Tama;
   Scanner leer = new Scanner(System.in);

    public estadistica() {
        leerTama();

    }

    public final void leerTama() {
        System.out.println("Ingrese el tamaño del vector");
        this.Tama = leer.nextInt();
        this.elementos = new int[10];

    }

    public void llenarElementos() {
        for (int i = 0; i < elementos.length; i++) {
            System.out.println("Digite un numero en la Posicion " + i);
          Tama = leer.nextInt();
            elementos[i] = (int) (Math.random() * 10 + 1);
        }
    }

    public int sumatoria() {
        int suma = 0;
        for (int i = 0; i < elementos.length; i++) {
            suma = suma + elementos[i];
        }
        return suma;
    }

    public int elementoMaximo() {
        int maxNum = elementos[0];
        for (int j : elementos) {
            if (j > maxNum) {
                maxNum = j;
            }
        }
        return maxNum;
    }

    public int elementoMinimo() {
        int minNum = elementos[0];
        for (int j : elementos) {
            if (j < minNum) {
                minNum = j;
            }
        }
        return minNum;
    }

    public float promedioElemen() {
        int promedio = 0;
        for (int i = 0; i < elementos.length; i++) {
            promedio += elementos[i];

        }
        float pm = promedio;
        return pm / elementos.length;
    }

    public double DesviacionT() {
        double acum = 0;
        for (int i = 0; i < elementos.length; i++) {
            double desv = Math.pow((elementos[i] - promedioElemen()), 2);
            acum += desv;
        }
        return Math.sqrt(acum / elementos.length);
    }

    @Override
    public String toString() {
        return "elementos=" + Arrays.toString(elementos);
    }

}