package notApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pracownik {
    private Object Pracownik;

    @Override
    public String toString() {
        return "id:"+idPracownika;
    }

    int idPracownika;
    int tabDostepnosci[] = new int[31];

    public Pracownik(int id){
        this.idPracownika = id;
    }

    void wpiszDostepnosc() throws FileNotFoundException {
        File plik = new File("test"+idPracownika+".txt");
        Scanner in = new Scanner( plik );
        //System.out.println("Wpisz swoją dostępność w danym dniu (1-dostepny, 0-nie): ");
        int dostepnosc;

        for(int i=1; i<=30; i++){
            if((i+1)%7==0){
                //System.out.println("Dzien: "+ i + " jest niedzielą, tego dnia nie pracujemy ");
                tabDostepnosci[i] = -1;
            }else{
                System.out.println(i + ": ");
                dostepnosc = in.nextInt();
                if(dostepnosc==1 || dostepnosc==0) {
                    tabDostepnosci[i] = dostepnosc;
                }else{
                    //System.out.println("Podano złą wartość, wpisz 1 lub 0: ");
                    i--;
                }
            }

        }
    }
}