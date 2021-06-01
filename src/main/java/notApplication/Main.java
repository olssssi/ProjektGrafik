package notApplication;

import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
static GrafikMiesieczny grafikMiesieczny = new GrafikMiesieczny();
static Pracownik[] pracownicy = new Pracownik[5];

    public static void main(String[] args) throws FileNotFoundException {

        Pracownik pracownik1 = new Pracownik(1);
        Pracownik pracownik2 = new Pracownik(2);
        Pracownik pracownik3 = new Pracownik(3);
        Pracownik pracownik4 = new Pracownik(4);
        System.out.println("id1: "+pracownik1.idPracownika);
        System.out.println("id2: "+pracownik2.idPracownika);
        System.out.println("id3: "+pracownik3.idPracownika);
        System.out.println("id4: "+pracownik4.idPracownika);
        pracownik1.wpiszDostepnosc();
        pracownik2.wpiszDostepnosc();
        pracownik3.wpiszDostepnosc();
        pracownik4.wpiszDostepnosc();
        pracownicy[1] = pracownik1;
        pracownicy[2] = pracownik2;
        pracownicy[3] = pracownik3;
        pracownicy[4] = pracownik4;
        grafikMiesieczny.uzupelnijGrafik(pracownicy);
        grafikMiesieczny.wypisz();




    //TODO Trzeba jeszcze sprawdzać, czy pracownik pracuje odpowiednia ilosc h w miesiacu
    //Specjalnie nie robiłam tego na razie, bo nasz algorytm jeszcze nie znajduje tak dobrego rozwiazania

}}
