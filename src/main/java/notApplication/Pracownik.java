package notApplication;

import java.util.Scanner;
public class Pracownik {
    int idPracownika;
    int tabDostepnosci[] = new int[31];

    void wpiszDostepnosc(){
        Scanner in = new Scanner( System.in );
        System.out.println("Wpisz swoją dostępność w danym dniu (1-dostepny, 0-nie): ");
        int dostepnosc;

        for(int i=1; i<=31; i++){
            if((i+5)%7==0){
                System.out.println("Dzien: "+ i + " jest niedzielą, tego dnia nie pracujemy ");
            }else{
                System.out.println(i + ": ");
                dostepnosc = in.nextInt();
                if(dostepnosc==1 || dostepnosc==0) {
                    tabDostepnosci[i] = dostepnosc;
                }else{
                    System.out.println("Podano złą wartość, wpisz 1 lub 0: ");
                    i--;
                }
            }

        }
    }
}