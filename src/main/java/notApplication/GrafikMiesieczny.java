package notApplication;

import java.util.ArrayList;

public class GrafikMiesieczny {
    ArrayList<GrafikDzienny> grafik;

    public GrafikMiesieczny() {
        grafik = new ArrayList<GrafikDzienny>(31);
        grafik.add(null);

    }

    public ArrayList<GrafikDzienny> getGrafik() {
        return grafik;
    }

    //TODO Trzeba jeszcze sprawdzać, czy pracownik pracuje odpowiednia ilosc h w miesiacu
    //Specjalnie nie robiłam tego na razie, bo nasz algorytm jeszcze nie znajduje tak dobrego rozwiazania
    public boolean sprawdzPoprawnosc(){
        for(int i=0; i<=30; i++){
            if(!grafik.get(i).sprawdzPoprawnosc()) return false;
        }
        return true;
    }

}
