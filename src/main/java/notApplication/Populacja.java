package notApplication;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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

    // Selekcjonowanie metodą rankingową
    // procent odrzuconych wyrażony w procentach, np 20 - w domyśle 20%
    // sortowanie jest już zawarte w selekcji
    public void dokonajSelekcji(int iloscIteracji, int procentOdrzuconych, Pracownik[] pracownicy){
        int liczbaOdrzuconych= (int) (grafiki.length*procentOdrzuconych*0.01);
        int licznik;
        for(int j=0;j<iloscIteracji;j++){
            sortuj();
            licznik=grafiki.length-1;
            for(int i=0; i<liczbaOdrzuconych; i++, licznik--){
                GrafikMiesieczny grafik = new GrafikMiesieczny();
                grafik.uzupelnijGrafik(pracownicy);
                grafiki[licznik] = grafik;
            }
        }
        sortuj();
    }

    //procentMutowanychGrafikow to procent grafików spośród całej populacji, który będzie mutowany
    //procentMutowanychDni to procent dni, które mają zostać zmutowane w każdym z mutowanych grafików
    public void mutuj(int procentMutowanychGrafikow, int procentMutowanychDni, Pracownik[] pracownicy){
        int liczbaMutowanychGrafikow = (int) (grafiki.length*procentMutowanychGrafikow*0.01);
        int liczbaMutowanychDni = (int)(30*procentMutowanychDni*0.01);
        int random1,random2;
        for(int i=0; i<liczbaMutowanychGrafikow; i++){
            random1 = ThreadLocalRandom.current().nextInt(1, grafiki.length);
            for(int k=0; k<liczbaMutowanychDni; k++){
                random2 = ThreadLocalRandom.current().nextInt(1, 31);
                grafiki[random1].losowoZmienGrafikDzienny(random2,pracownicy);
            }
            grafiki[random1].zliczPoprawneDni();
        }
        sortuj();
    }
}
