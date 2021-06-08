import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pracownik {
    int idPracownika;
    int tabDostepnosci[] = new int[31];
    int iloscH = 0;
    boolean flaga=false;

    public Pracownik(int id){
        this.idPracownika = id;
        this.flaga=false;
    }

    void wpiszDostepnosc() throws FileNotFoundException {
        File plik = new File("test"+idPracownika+".txt");
        Scanner in = new Scanner( plik );
        // Wczytywanie dostepnosci: 1-dostepny, 0-niedostepny
        int dostepnosc;

        for(int i=1; i<=30; i++){
            if((i+1)%7==0){
                // Niedziela
                tabDostepnosci[i] = -1;
            }else{
//                System.out.println(i + ": ");
                dostepnosc = in.nextInt();
                if(dostepnosc==1 || dostepnosc==0) {
                    tabDostepnosci[i] = dostepnosc;
                }else{
                    // Podano złą wartość
                    i--;
                }
            }

        }
    }

    @Override
    public String toString() {
        return "id:"+idPracownika;
    }
}