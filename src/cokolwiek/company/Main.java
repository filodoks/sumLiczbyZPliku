package cokolwiek.company;

import java.io.*;

/*

Nazwa pliku do sumowania powinna byc podana w wierszu polecen jako
argument wywolania aplikacji

 */
public class Main {
    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Wywołanie programu: Suma nazwa_pliku");
            return;
        }

        StreamTokenizer strTok = null;
        try{
            strTok = new StreamTokenizer(
                    new BufferedReader(
                            new FileReader(args[0])
                    )
            );
        }
        catch(FileNotFoundException e){
            System.out.println("Nie mogę otworzyć pliku: " + args[0]);
            return;
        }
        double suma = 0;
        try{
            while(strTok.nextToken() != StreamTokenizer.TT_EOF){
                if(strTok.ttype == StreamTokenizer.TT_NUMBER)
                    suma += strTok.nval;
            }
        }
        catch(IOException e){
            System.out.println("Błąd I/O podczas odczytu pliku.");
            return;
        }
        System.out.println("Wynik: " + suma);
    }
}