package notApplication;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
static GrafikMiesieczny grafikMiesieczny = new GrafikMiesieczny();
static Pracownik[] pracownicy = new Pracownik[5];

    public static void main(String[] args) {
        int rand1=0, rand2=0, m, n;
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

        System.out.println("Dyspozycyjnosc:\n");
        for(int j=0; j<31; j++){
            System.out.println(pracownik1.tabDostepnosci[j]+"\n");
        }

        System.out.println("\n\n");

        //tutaj powinna być strategia przeszukiwań
        // Nie wiem na razie jak dodawać poranną a jak wieczorną zmianę

        // counter odpowiadać będzie za to, żeby pętla wykonywała się tylko określoną ilość razy. Później zakładamy, że takiego pracownika nie ma.
        for(int i=1; i<=30; i++) {
            for(m=0; m<10; m++){
                rand1 = ThreadLocalRandom.current().nextInt(1, 5);
                System.out.println("Szukam1. Rand="+rand1+"\n");
                if(pracownicy[rand1].tabDostepnosci[i]==1) {
                    System.out.println("Znaleziono osobe na ranna zmiane w dniu nr "+i+"\n");
                    m=-1;
                    break;
                }
            }

            for(n=0; n<10; n++){
                rand2 = ThreadLocalRandom.current().nextInt(1, 5);
                System.out.println("Szukam2. Rand="+rand2+"\n");
                if(pracownicy[rand2].tabDostepnosci[i]==1) {
                    System.out.println("Znaleziono osobe na wieczorna zmiane w dniu nr "+i+"\n");
                    n=-1;
                    break;
                }
            }

//            Ten sposob nie sprawdza dyspozycyjnosci
//            while (true) {
//                rand1 = ThreadLocalRandom.current().nextInt(1, 5);
//                if (pracownicy[rand1] != null) {
////                    grafikMiesieczny.grafik.get(i).setPorannaZmiana(pracownicy[rand1]);
//                    break;
//                }
//            }
//            while (true) {
//                rand2 = ThreadLocalRandom.current().nextInt(1, 5);
//                if (pracownicy[rand2] != null) {
//                    grafikMiesieczny.grafik.get(i).setWieczornaZmiana(pracownicy[rand2]);
//                    break;
//                }
//            }
            if(m==-1 && n==-1){
                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"poniedzialek", pracownicy[rand1], pracownicy[rand2]);
                grafikMiesieczny.grafik.add(grafikDzienny);
            }
            else if(m==-1 && n!=-1){
                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"poniedzialek", pracownicy[rand1], null);
                grafikMiesieczny.grafik.add(grafikDzienny);
            }
            else if(m!=-1 && n==-1){
                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"poniedzialek", null, pracownicy[rand2]);
                grafikMiesieczny.grafik.add(grafikDzienny);
            }
            else{
                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"poniedzialek", null, null);
                grafikMiesieczny.grafik.add(grafikDzienny);
            }

        }

//            if((i+1)%7==0){
//                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"niedziela", null, null);
//                grafikMiesieczny.grafik.add(grafikDzienny);
//            }
//            else if(pracownik1.tabDostepnosci[i]==1 && pracownik2.tabDostepnosci[i]==1){
//                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"wtorek", pracownik1, pracownik2);
//                grafikMiesieczny.grafik.add(grafikDzienny);
//            }
//            else if(pracownik1.tabDostepnosci[i]==1){
//                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"wtorek", pracownik1, null);
//                grafikMiesieczny.grafik.add(grafikDzienny);
//            }
//            else if(pracownik2.tabDostepnosci[i]==1){
//                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"wtorek", pracownik2, null);
//                grafikMiesieczny.grafik.add(grafikDzienny);
//            }
//            else{
//                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"wtorek", null, null);
//                grafikMiesieczny.grafik.add(grafikDzienny);
//            }
//        }

        //wyswietlanie tabelki
            //sout +TAB  -skrot do system out
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|                        |           1            |           2            |           3            |           4            |           5            |           6            |");
            System.out.println("|                        |"+grafikMiesieczny.grafik.get(1).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(2).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(3).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(4).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(5).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(6).porannaZmiana+"                    |");
            System.out.println("|                        |"+grafikMiesieczny.grafik.get(1).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(2).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(3).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(4).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(5).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(6).wieczornaZmiana+"                    |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|           7            |           8            |           9            |           10           |           11           |           12           |           13           |");
            System.out.println("|"+grafikMiesieczny.grafik.get(7).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(8).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(9).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(10).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(11).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(12).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(13).porannaZmiana+"                    |");
            System.out.println("|"+grafikMiesieczny.grafik.get(7).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(8).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(9).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(10).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(11).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(12).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(13).wieczornaZmiana+"                    |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|           14           |           15           |           16           |           17           |           18           |           19           |           20           |");
            System.out.println("|"+grafikMiesieczny.grafik.get(14).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(15).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(16).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(17).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(18).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(19).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(20).porannaZmiana+"                    |");
            System.out.println("|"+grafikMiesieczny.grafik.get(14).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(15).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(16).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(17).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(18).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(19).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(20).wieczornaZmiana+"                    |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|           21           |           22           |           23           |           24           |           25           |           26           |           27           |");
            System.out.println("|"+grafikMiesieczny.grafik.get(21).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(22).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(23).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(24).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(25).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(26).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(27).porannaZmiana+"                    |");
            System.out.println("|"+grafikMiesieczny.grafik.get(21).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(22).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(23).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(24).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(25).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(26).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(27).wieczornaZmiana+"                    |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|           28           |           29           |           30           |                        |                        |                        |                        |");
            System.out.println("|"+grafikMiesieczny.grafik.get(28).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(29).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(30).porannaZmiana+"                    |                        |                        |                        |                        |");
            System.out.println("|"+grafikMiesieczny.grafik.get(28).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(29).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(30).wieczornaZmiana+"                    |                        |                        |                        |                        |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");

            if(sprawdzPoprawnosc()) System.out.println("Stworzono poprawny grafik");
            else    System.out.println("Nie stworzono poprawnego grafiku");

    }
    //TODO Trzeba jeszcze sprawdzać, czy pracownik pracuje odpowiednia ilosc h w miesiacu
    //Specjalnie nie robiłam tego na razie, bo nasz algorytm jeszcze nie znajduje tak dobrego rozwiazania
    public static boolean sprawdzPoprawnosc(){
        for(int i=1; i<=30; i++){
            if(!grafikMiesieczny.grafik.get(i).sprawdzPoprawnosc()) {
                System.out.printf("Pierwszy napotkany niepoprawny dzień: "+i+"\n");
                return false;
            }
        }
        return true;
    }
}
