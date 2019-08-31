package cokolwiek.company;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Wywolanie programu: Suma nazwa_pliku");
            return;
        }

        StreamTokenizer strTok = null;
        try {
            strTok = new StreamTokenizer(
                    new BufferedReader(
                            new FileReader(args[0])
                    )
            );
        } catch (FileNotFoundException e) {
            System.out.println("Nie moge otworzyc pliku: " + args[0]);
            return;
        }

        double suma = 0;
        try {
            while (strTok.nextToken() != StreamTokenizer.TT_EOF) {
                if(strTok.ttype == StreamTokenizer.TT_NUMBER)
                    suma += strTok.nval;
            }
        } catch (IOException e) {
            System.out.println("Blad I/O podczas odczytu pliku.");
            return;
        }
        System.out.println("Wynik: " + suma);
    }
}
