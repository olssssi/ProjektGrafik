package notApplication;

import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Pracownik[] pracownicy = new Pracownik[5];
        Pracownik pracownik1 = new Pracownik(1);
        Pracownik pracownik2 = new Pracownik(2);
        Pracownik pracownik3 = new Pracownik(3);
        Pracownik pracownik4 = new Pracownik(4);

        pracownik1.wpiszDostepnosc();
        pracownik2.wpiszDostepnosc();
        pracownik3.wpiszDostepnosc();
        pracownik4.wpiszDostepnosc();

        pracownicy[1] = pracownik1;
        pracownicy[2] = pracownik2;
        pracownicy[3] = pracownik3;
        pracownicy[4] = pracownik4;


        GrafikMiesieczny grafikMiesieczny1 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny2 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny3 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny4 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny5 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny6 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny7 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny8 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny9 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny10 = new GrafikMiesieczny();

        grafikMiesieczny1.uzupelnijGrafik(pracownicy);
        grafikMiesieczny2.uzupelnijGrafik(pracownicy);
        grafikMiesieczny3.uzupelnijGrafik(pracownicy);
        grafikMiesieczny4.uzupelnijGrafik(pracownicy);
        grafikMiesieczny5.uzupelnijGrafik(pracownicy);
        grafikMiesieczny6.uzupelnijGrafik(pracownicy);
        grafikMiesieczny7.uzupelnijGrafik(pracownicy);
        grafikMiesieczny8.uzupelnijGrafik(pracownicy);
        grafikMiesieczny9.uzupelnijGrafik(pracownicy);
        grafikMiesieczny10.uzupelnijGrafik(pracownicy);

        // Stworzenie populacji
        Populacja populacja = new Populacja();
        populacja.grafiki[1]=grafikMiesieczny1;
        populacja.grafiki[2]=grafikMiesieczny2;
        populacja.grafiki[3]=grafikMiesieczny3;
        populacja.grafiki[4]=grafikMiesieczny4;
        populacja.grafiki[5]=grafikMiesieczny5;
        populacja.grafiki[6]=grafikMiesieczny6;
        populacja.grafiki[7]=grafikMiesieczny7;
        populacja.grafiki[8]=grafikMiesieczny8;
        populacja.grafiki[9]=grafikMiesieczny9;
        populacja.grafiki[10]=grafikMiesieczny10;
        System.out.println(populacja);

    }
}
