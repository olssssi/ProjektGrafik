package notApplication;
import java.util.*;

public class Populacja {
    GrafikMiesieczny grafiki[] = new GrafikMiesieczny[11];
    Comparator comparator = new GrafikMiesieczny();
    public void sortuj(){
        Arrays.sort(grafiki, comparator);
    }

    @Override
    public String toString() {
        String r="\nAKTUALNA POPULACJA:\n";
        for(int i=0; i< grafiki.length; i++){
            r=r+i+": "+grafiki[i].ocena+" "+grafiki[i].toString()+"\n";
        }
        return r;
    }

    // procent odrzuconych wyrażony w procentach, np 20 - w domyśle 20%
    public void dokonajSelekcji(int procentOdrzuconych, Pracownik[] pracownicy){
        int liczbaOdrzuconych= (int) (grafiki.length*procentOdrzuconych*0.01);
        int licznik= grafiki.length-1;
        for(int i=0; i<liczbaOdrzuconych; i++, licznik--){
            GrafikMiesieczny grafik = new GrafikMiesieczny();
            grafik.uzupelnijGrafik(pracownicy);
            grafiki[licznik] = grafik;
        }
    }

}
