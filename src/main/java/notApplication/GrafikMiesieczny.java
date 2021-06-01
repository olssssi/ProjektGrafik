package notApplication;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GrafikMiesieczny {
    ArrayList<GrafikDzienny> grafik;
    int ocena;

    public GrafikMiesieczny() {
        grafik = new ArrayList<GrafikDzienny>(31);
        ocena=0;
        grafik.add(null);

    }

    public void uzupelnijGrafikDanegoDnia(Pracownik[] pracownicy, int dzien){

    }

    public void uzupelnijGrafik (Pracownik[] pracownicy){
        int rand1=0, rand2=0, m=-1, n=-1;
        for(int i=1; i<=30; i++) {
            // Te m wprowadziłam po to, żeby pętla nie wykonywała się w nieskończoność. 10 razy szuka randomowej osoby i sprawdza,
            // Czy ma dyspozycyjność danego dnia. Jeżeli 10 razy nie trafi na taką osobę, to później wprowadza null
            // Czyli, że na tą ranną zmianę nie ma komu pracować. Tak samo robię z n i wieczorną zmianą
            for (m = 0; m < 10; m++) {
                rand1 = ThreadLocalRandom.current().nextInt(1, 5);
                if (pracownicy[rand1].tabDostepnosci[i] == 1) {
//                    System.out.println("Znaleziono osobe na ranna zmiane w dniu nr " + i + "\n");
                    m = -1;
                    break;
                }
            }

            if((i+2)%7==0){ n=1;}
            else{
                for (n = 0; n < 10; n++) {
                    rand2 = ThreadLocalRandom.current().nextInt(1, 5);
                    if (pracownicy[rand2].tabDostepnosci[i] == 1) {
//                        System.out.println("Znaleziono osobe na wieczorna zmiane w dniu nr " + i + "\n");
                        n = -1;
                        break;
                    }
                }}

            // Znaleziono osobę na ranną i wieczorną zmianę
            if (m == -1 && n == -1) {
                GrafikDzienny grafikDzienny = new GrafikDzienny(i, "poniedzialek", pracownicy[rand1], pracownicy[rand2]);
                grafik.add(grafikDzienny);

            }
            // Znaleziono osobę na ranną zmianę
            else if (m == -1 && n != -1) {
                GrafikDzienny grafikDzienny = new GrafikDzienny(i, "poniedzialek", pracownicy[rand1], null);
                grafik.add(grafikDzienny);
            }
            // Znaleziono osobę na wieczorną zmianę
            else if (m != -1 && n == -1) {
                GrafikDzienny grafikDzienny = new GrafikDzienny(i, "poniedzialek", null, pracownicy[rand2]);
                grafik.add(grafikDzienny);
            }
            // Nie znaleziono osób ani na ranną ani na wieczorną zmianę
            else {
                GrafikDzienny grafikDzienny = new GrafikDzienny(i, "poniedzialek", null, null);
                grafik.add(grafikDzienny);
            }

        }

        // Po stworzeniu grafiku od razu obliczamy jego ocenę
        zliczPoprawneDni();

    }

    public void wypisz(){
        //wyswietlanie tabelki
        //sout +TAB  -skrot do system out
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("|                        |           1            |           2            |           3            |           4            |           5            |           6            |");
        System.out.println("|                        |"+grafik.get(1).porannaZmiana+"                    |"+grafik.get(2).porannaZmiana+"                    |"+grafik.get(3).porannaZmiana+"                    |"+grafik.get(4).porannaZmiana+"                    |"+grafik.get(5).porannaZmiana+"                    |"+grafik.get(6).porannaZmiana+"                    |");
        System.out.println("|                        |"+grafik.get(1).wieczornaZmiana+"                    |"+grafik.get(2).wieczornaZmiana+"                    |"+grafik.get(3).wieczornaZmiana+"                    |"+grafik.get(4).wieczornaZmiana+"                    |"+grafik.get(5).wieczornaZmiana+"                    |"+grafik.get(6).wieczornaZmiana+"                    |");
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("|           7            |           8            |           9            |           10           |           11           |           12           |           13           |");
        System.out.println("|"+grafik.get(7).porannaZmiana+"                    |"+grafik.get(8).porannaZmiana+"                    |"+grafik.get(9).porannaZmiana+"                    |"+grafik.get(10).porannaZmiana+"                    |"+grafik.get(11).porannaZmiana+"                    |"+grafik.get(12).porannaZmiana+"                    |"+grafik.get(13).porannaZmiana+"                    |");
        System.out.println("|"+grafik.get(7).wieczornaZmiana+"                    |"+grafik.get(8).wieczornaZmiana+"                    |"+grafik.get(9).wieczornaZmiana+"                    |"+grafik.get(10).wieczornaZmiana+"                    |"+grafik.get(11).wieczornaZmiana+"                    |"+grafik.get(12).wieczornaZmiana+"                    |"+grafik.get(13).wieczornaZmiana+"                    |");
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("|           14           |           15           |           16           |           17           |           18           |           19           |           20           |");
        System.out.println("|"+grafik.get(14).porannaZmiana+"                    |"+grafik.get(15).porannaZmiana+"                    |"+grafik.get(16).porannaZmiana+"                    |"+grafik.get(17).porannaZmiana+"                    |"+grafik.get(18).porannaZmiana+"                    |"+grafik.get(19).porannaZmiana+"                    |"+grafik.get(20).porannaZmiana+"                    |");
        System.out.println("|"+grafik.get(14).wieczornaZmiana+"                    |"+grafik.get(15).wieczornaZmiana+"                    |"+grafik.get(16).wieczornaZmiana+"                    |"+grafik.get(17).wieczornaZmiana+"                    |"+grafik.get(18).wieczornaZmiana+"                    |"+grafik.get(19).wieczornaZmiana+"                    |"+grafik.get(20).wieczornaZmiana+"                    |");
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("|           21           |           22           |           23           |           24           |           25           |           26           |           27           |");
        System.out.println("|"+grafik.get(21).porannaZmiana+"                    |"+grafik.get(22).porannaZmiana+"                    |"+grafik.get(23).porannaZmiana+"                    |"+grafik.get(24).porannaZmiana+"                    |"+grafik.get(25).porannaZmiana+"                    |"+grafik.get(26).porannaZmiana+"                    |"+grafik.get(27).porannaZmiana+"                    |");
        System.out.println("|"+grafik.get(21).wieczornaZmiana+"                    |"+grafik.get(22).wieczornaZmiana+"                    |"+grafik.get(23).wieczornaZmiana+"                    |"+grafik.get(24).wieczornaZmiana+"                    |"+grafik.get(25).wieczornaZmiana+"                    |"+grafik.get(26).wieczornaZmiana+"                    |"+grafik.get(27).wieczornaZmiana+"                    |");
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("|           28           |           29           |           30           |                        |                        |                        |                        |");
        System.out.println("|"+grafik.get(28).porannaZmiana+"                    |"+grafik.get(29).porannaZmiana+"                    |"+grafik.get(30).porannaZmiana+"                    |                        |                        |                        |                        |");
        System.out.println("|"+grafik.get(28).wieczornaZmiana+"                    |"+grafik.get(29).wieczornaZmiana+"                    |"+grafik.get(30).wieczornaZmiana+"                    |                        |                        |                        |                        |");
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");

        if(sprawdzPoprawnosc()) System.out.println("Stworzono poprawny grafik");
        else    System.out.println("Nie stworzono poprawnego grafiku");

    }


    //TODO Trzeba jeszcze sprawdzać, czy pracownik pracuje odpowiednia ilosc h w miesiacu
    //Specjalnie nie robiłam tego na razie, bo nasz algorytm jeszcze nie znajduje tak dobrego rozwiazania
    public boolean sprawdzPoprawnosc(){
        for(int i=1; i<=30; i++){
            if(!grafik.get(i).sprawdzPoprawnosc()) {
                System.out.printf("Pierwszy napotkany niepoprawny dzień: "+i+"\n");
                return false;
            }
        }
        return true;
    }

    public int zliczPoprawneDni(){
        int iloscPoprawnychDni = 0;
        for(int i=1; i<=30; i++){
            if(grafik.get(i).sprawdzPoprawnosc()) {
                iloscPoprawnychDni++;
            }
        }
        // Uptade oceny
        this.ocena = iloscPoprawnychDni;
        return iloscPoprawnychDni;
    }

    public ArrayList<GrafikDzienny> getGrafik() {
        return grafik;
    }

}
