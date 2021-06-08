import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class GrafikMiesieczny implements Comparator<GrafikMiesieczny> {
    ArrayList<GrafikDzienny> grafik;
    int ocena;
    ArrayList<Integer> iloscHPracownikow;

    public GrafikMiesieczny() {
        grafik = new ArrayList<GrafikDzienny>(31);
        ocena = 0;
        grafik.add(null);
        iloscHPracownikow = new ArrayList<Integer>(4);
    }

    public void uzupelnijGrafik(Pracownik[] pracownicy) {
        int rand1 = 0, rand2 = 0, m = -1, n = -1;
        for (int i = 1; i <= 30; i++) {
            // m jako zmienna stopująca wyszukiwanie pracownika. Tak samo n niżej
            for (m = 0; m < 10; m++) {
                rand1 = ThreadLocalRandom.current().nextInt(1, 5);
                if (pracownicy[rand1].tabDostepnosci[i] == 1) {
                    m = -1;
                    break;
                }
            }

            if ((i + 2) % 7 == 0) {
                n = 1;
            } else {
                for (n = 0; n < 10; n++) {
                    rand2 = ThreadLocalRandom.current().nextInt(1, 5);
                    if ((pracownicy[rand1] != pracownicy[rand2]) && pracownicy[rand2].tabDostepnosci[i] == 1) {
                        n = -1;
                        break;
                    }
                }
            }

            // Znaleziono osobę na ranną i wieczorną zmianę
            if (m == -1 && n == -1) {
                GrafikDzienny grafikDzienny = new GrafikDzienny(i, pracownicy[rand1], pracownicy[rand2]);
                grafik.add(grafikDzienny);

            }
            // Znaleziono osobę na ranną zmianę
            else if (m == -1 && n != -1) {
                GrafikDzienny grafikDzienny = new GrafikDzienny(i, pracownicy[rand1], null);
                grafik.add(grafikDzienny);
            }
            // Znaleziono osobę na wieczorną zmianę
            else if (m != -1 && n == -1) {
                GrafikDzienny grafikDzienny = new GrafikDzienny(i, null, pracownicy[rand2]);
                grafik.add(grafikDzienny);
            }
            // Nie znaleziono osób ani na ranną ani na wieczorną zmianę
            else {
                GrafikDzienny grafikDzienny = new GrafikDzienny(i, null, null);
                grafik.add(grafikDzienny);
            }

        }

        // Po stworzeniu grafiku od razu obliczamy jego ocenę
        zliczPoprawneDni();

        // Tak samo ilość przepracowanych przez pracownika godzin
        zliczIloscH(pracownicy);
    }

    public void losowoZmienGrafikDzienny(int numerDnia, Pracownik[] pracownicy) {
        int rand1 = 0, rand2 = 0, m = -1, n = -1;
        GrafikDzienny grafikDzienny = grafik.get(numerDnia);
        for (m = 0; m < 10; m++) {
            rand1 = ThreadLocalRandom.current().nextInt(1, 5);
            if (pracownicy[rand1].tabDostepnosci[numerDnia] == 1) {
                m = -1;
                break;
            }
        }
        if ((numerDnia + 2) % 7 == 0) {
            n = 1;
        } else {
            for (n = 0; n < 10; n++) {
                rand2 = ThreadLocalRandom.current().nextInt(1, 5);
                if (pracownicy[rand2].tabDostepnosci[numerDnia] == 1) {
                    n = -1;
                    break;
                }
            }
        }
        // Znaleziono osobę na ranną i wieczorną zmianę
        if (m == -1 && n == -1) {
            grafikDzienny.porannaZmiana = pracownicy[rand1];
            grafikDzienny.wieczornaZmiana = pracownicy[rand2];

        }
        // Znaleziono osobę na ranną zmianę
        else if (m == -1 && n != -1) {
            grafikDzienny.porannaZmiana = pracownicy[rand1];
            grafikDzienny.wieczornaZmiana = null;
        }
        // Znaleziono osobę na wieczorną zmianę
        else if (m != -1 && n == -1) {
            grafikDzienny.porannaZmiana = null;
            grafikDzienny.wieczornaZmiana = pracownicy[rand2];
        }

        // Nie znaleziono osób ani na ranną ani na wieczorną zmianę
        else {
            grafikDzienny.porannaZmiana = null;
            grafikDzienny.wieczornaZmiana = null;
        }
    }

    public void wypisz(Pracownik[] pracownicy) throws InterruptedException {
        System.out.println("|__________PON___________|___________WT___________|___________ŚR___________|__________CZW___________|__________PT____________|__________SB____________|__________NDZ___________|");
        System.out.println("|________________________|________________________|________________________|________________________|________________________|________________________|________________________|");
        System.out.println("|                        |           1            |           2            |           3            |           4            |           5            |           6            |");
        System.out.println("|                        |" + grafik.get(1).porannaZmiana + "                    |" + grafik.get(2).porannaZmiana + "                    |" + grafik.get(3).porannaZmiana + "                    |" + grafik.get(4).porannaZmiana + "                    |" + grafik.get(5).porannaZmiana + "                    |" + grafik.get(6).porannaZmiana + "                    |");
        System.out.println("|                        |" + grafik.get(1).wieczornaZmiana + "                    |" + grafik.get(2).wieczornaZmiana + "                    |" + grafik.get(3).wieczornaZmiana + "                    |" + grafik.get(4).wieczornaZmiana + "                    |" + grafik.get(5).wieczornaZmiana + "                    |" + grafik.get(6).wieczornaZmiana + "                    |");
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("|           7            |           8            |           9            |           10           |           11           |           12           |           13           |");
        System.out.println("|" + grafik.get(7).porannaZmiana + "                    |" + grafik.get(8).porannaZmiana + "                    |" + grafik.get(9).porannaZmiana + "                    |" + grafik.get(10).porannaZmiana + "                    |" + grafik.get(11).porannaZmiana + "                    |" + grafik.get(12).porannaZmiana + "                    |" + grafik.get(13).porannaZmiana + "                    |");
        System.out.println("|" + grafik.get(7).wieczornaZmiana + "                    |" + grafik.get(8).wieczornaZmiana + "                    |" + grafik.get(9).wieczornaZmiana + "                    |" + grafik.get(10).wieczornaZmiana + "                    |" + grafik.get(11).wieczornaZmiana + "                    |" + grafik.get(12).wieczornaZmiana + "                    |" + grafik.get(13).wieczornaZmiana + "                    |");
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("|           14           |           15           |           16           |           17           |           18           |           19           |           20           |");
        System.out.println("|" + grafik.get(14).porannaZmiana + "                    |" + grafik.get(15).porannaZmiana + "                    |" + grafik.get(16).porannaZmiana + "                    |" + grafik.get(17).porannaZmiana + "                    |" + grafik.get(18).porannaZmiana + "                    |" + grafik.get(19).porannaZmiana + "                    |" + grafik.get(20).porannaZmiana + "                    |");
        System.out.println("|" + grafik.get(14).wieczornaZmiana + "                    |" + grafik.get(15).wieczornaZmiana + "                    |" + grafik.get(16).wieczornaZmiana + "                    |" + grafik.get(17).wieczornaZmiana + "                    |" + grafik.get(18).wieczornaZmiana + "                    |" + grafik.get(19).wieczornaZmiana + "                    |" + grafik.get(20).wieczornaZmiana + "                    |");
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("|           21           |           22           |           23           |           24           |           25           |           26           |           27           |");
        System.out.println("|" + grafik.get(21).porannaZmiana + "                    |" + grafik.get(22).porannaZmiana + "                    |" + grafik.get(23).porannaZmiana + "                    |" + grafik.get(24).porannaZmiana + "                    |" + grafik.get(25).porannaZmiana + "                    |" + grafik.get(26).porannaZmiana + "                    |" + grafik.get(27).porannaZmiana + "                    |");
        System.out.println("|" + grafik.get(21).wieczornaZmiana + "                    |" + grafik.get(22).wieczornaZmiana + "                    |" + grafik.get(23).wieczornaZmiana + "                    |" + grafik.get(24).wieczornaZmiana + "                    |" + grafik.get(25).wieczornaZmiana + "                    |" + grafik.get(26).wieczornaZmiana + "                    |" + grafik.get(27).wieczornaZmiana + "                    |");
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("|           28           |           29           |           30           |                        |                        |                        |                        |");
        System.out.println("|" + grafik.get(28).porannaZmiana + "                    |" + grafik.get(29).porannaZmiana + "                    |" + grafik.get(30).porannaZmiana + "                    |                        |                        |                        |                        |");
        System.out.println("|" + grafik.get(28).wieczornaZmiana + "                    |" + grafik.get(29).wieczornaZmiana + "                    |" + grafik.get(30).wieczornaZmiana + "                    |                        |                        |                        |                        |");
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");

        TimeUnit.SECONDS.sleep(4);

        wypiszIloscH(pracownicy);

        TimeUnit.SECONDS.sleep(4);
        System.out.println("\nPOPRAWNOŚĆ ("+ocena+"/30):\n");
        TimeUnit.SECONDS.sleep(2);
        wypiszBledy(pracownicy);

    }

    void wypiszBledy(Pracownik[] pracownicy) throws InterruptedException {
        System.out.println("     ID DNIA     |     OPIS BŁĘDU");
        for (int i = 1; i <= 30; i++){
            grafik.get(i).wypiszBledy(i, grafik.get(i - 1), pracownicy);}

        TimeUnit.SECONDS.sleep(2);
    }


    public void zliczIloscH(Pracownik[] pracownicy) {
        for (int i = 1; i < pracownicy.length; i++) {
            pracownicy[i].iloscH = 0;
        }

        for (int j = 1; j <= 30; j++) {
            if (grafik.get(j).porannaZmiana != null)
                grafik.get(j).porannaZmiana.iloscH += 8;
            if (grafik.get(j).wieczornaZmiana != null)
                grafik.get(j).wieczornaZmiana.iloscH += 8;
        }
        for (int j = 1; j < pracownicy.length; j++) {
            iloscHPracownikow.add(pracownicy[j].iloscH);
        }

    }

    public boolean wypiszIloscH(Pracownik[] pracownicy) throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\nILOŚĆ GODZIN PRZEPRACOWANYCH PRZEZ POSZCZEGÓLNYCH PRACOWNIKÓW:\n");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("ID PRACOWNIKA    |   ILOŚĆ GODZIN");
        for (int j = 1; j < pracownicy.length; j++) {
            System.out.println("      " + j + "          |        " + pracownicy[j].iloscH);
        }
        return true;
    }

    //Specjalnie nie robiłam tego na razie, bo nasz algorytm jeszcze nie znajduje tak dobrego rozwiazania
    public boolean sprawdzPoprawnosc() {
        for (int i = 1; i <= 30; i++) {
            if (!grafik.get(i).sprawdzPoprawnosc(grafik.get(i - 1))) {
//                System.out.printf("Pierwszy napotkany niepoprawny dzień: " + i + "\n");
                return false;
            }
        }
        return true;
    }

    public int zliczPoprawneDni() {
        int iloscPoprawnychDni = 0;
        for (int i = 1; i <= 30; i++) {
            if (grafik.get(i).sprawdzPoprawnosc(grafik.get(i - 1))) {
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

    public GrafikDzienny getGrafik(int dzien) {
        return grafik.get(dzien);
    }

    @Override
    public int compare(GrafikMiesieczny o1, GrafikMiesieczny o2) {
        int ocena1, ocena2;
        if (o1 == null) ocena1 = 0;
        else ocena1 = o1.ocena;
        if (o2 == null) ocena2 = 0;
        else ocena2 = o2.ocena;
        return ocena2 - ocena1;
    }

}