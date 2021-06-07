package notApplication;

import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        double najlepszy=0,najgorszy=0;
        Pracownik[] pracownicy = new Pracownik[5];
        Pracownik pracownik1 = new Pracownik(1);
        Pracownik pracownik2 = new Pracownik(2);
        Pracownik pracownik3 = new Pracownik(3);
        Pracownik pracownik4 = new Pracownik(4);

        pracownik1.wpiszDostepnosc();
        pracownik2.wpiszDostepnosc();
        pracownik3.wpiszDostepnosc();
        pracownik4.wpiszDostepnosc();

        pracownicy[1] = pracownik1;
        pracownicy[2] = pracownik2;
        pracownicy[3] = pracownik3;
        pracownicy[4] = pracownik4;


        GrafikMiesieczny grafikMiesieczny0 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny1 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny2 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny3 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny4 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny5 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny6 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny7 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny8 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny9 = new GrafikMiesieczny();
        GrafikMiesieczny grafikMiesieczny10 = new GrafikMiesieczny();

        grafikMiesieczny0.uzupelnijGrafik(pracownicy);
        grafikMiesieczny1.uzupelnijGrafik(pracownicy);
        grafikMiesieczny2.uzupelnijGrafik(pracownicy);
        grafikMiesieczny3.uzupelnijGrafik(pracownicy);
        grafikMiesieczny4.uzupelnijGrafik(pracownicy);
        grafikMiesieczny5.uzupelnijGrafik(pracownicy);
        grafikMiesieczny6.uzupelnijGrafik(pracownicy);
        grafikMiesieczny7.uzupelnijGrafik(pracownicy);
        grafikMiesieczny8.uzupelnijGrafik(pracownicy);
        grafikMiesieczny9.uzupelnijGrafik(pracownicy);
        grafikMiesieczny10.uzupelnijGrafik(pracownicy);

        // Stworzenie populacji
        Populacja populacja = new Populacja();
        populacja.grafiki[0]=grafikMiesieczny0;
        populacja.grafiki[1]=grafikMiesieczny1;
        populacja.grafiki[2]=grafikMiesieczny2;
        populacja.grafiki[3]=grafikMiesieczny3;
        populacja.grafiki[4]=grafikMiesieczny4;
        populacja.grafiki[5]=grafikMiesieczny5;
        populacja.grafiki[6]=grafikMiesieczny6;
        populacja.grafiki[7]=grafikMiesieczny7;
        populacja.grafiki[8]=grafikMiesieczny8;
        populacja.grafiki[9]=grafikMiesieczny9;
        populacja.grafiki[10]=grafikMiesieczny10;
        populacja.sortuj();

        System.out.println("\n_______________________FAZA TWORZENIA POPULACJI:_______________________________________");
        System.out.println("W sposób losowy zostaje stworzonych 11 grafików.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("\n. . .\n");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("_______________________WYNIKI PO LOSOWANIU:____________________________________________");
        System.out.println("Poprawność aktualnie najlepszego grafiku: "+populacja.grafiki[0].ocena+"/30");
        System.out.println("Poprawność aktualnie najgorszego grafiku: "+populacja.grafiki[10].ocena+"/30\n\n\n");
        TimeUnit.SECONDS.sleep(4);



        // Selekcja
        System.out.println("\n\n_______________________FAZA SELEKCJI___________________________________________________");
        System.out.println("Rozpoczynana jest selekcja. Zostanie przeprowadzonych 100 iteracji. " +
                            "\nW każdej z nich zostanie odrzucone 20% najsłabszych grafików miesięcznych." +
                            "\nNa ich miejsce zostaną wylosowane nowe.");
        populacja.dokonajSelekcji(100,20,pracownicy);
        TimeUnit.SECONDS.sleep(6);
        System.out.println("\n. . .\n");
        TimeUnit.SECONDS.sleep(6);
        System.out.println("_______________________WYNIKI PO SELEKCJI:_____________________________________________");
        System.out.println("Poprawność aktualnie najlepszego grafiku: "+populacja.grafiki[0].ocena+"/30");
        System.out.println("Poprawność aktualnie najgorszego grafiku: "+populacja.grafiki[10].ocena+"/30\n\n\n");
        TimeUnit.SECONDS.sleep(4);



        // Krzyżowanie
        System.out.println("\n\n_______________________FAZA KRZYŻOWANIA________________________________________________");
        System.out.println("Rozpoczynana jest faza krzyżowania. 60% grafików miesięcznych zostanie skrzyżowanych między sobą." +
                            "\nOznacza to, że 50% dni każdego z nich zostanie wymienione na tą samą ilość dni z innego krzyżowanego miesiąca.");
        populacja.krzyzuj(60,50,pracownicy);
        populacja.sortuj();
        TimeUnit.SECONDS.sleep(6);
        System.out.println("\n. . .\n");
        TimeUnit.SECONDS.sleep(6);
        System.out.println("_______________________WYNIKI PO KRZYŻOWANIU:__________________________________________");
        System.out.println("Poprawność aktualnie najlepszego grafiku: "+populacja.grafiki[0].ocena+"/30");
        System.out.println("Poprawność aktualnie najgorszego grafiku: "+populacja.grafiki[10].ocena+"/30\n\n\n");
        TimeUnit.SECONDS.sleep(4);



        // Mutacja
        System.out.println("\n\n_______________________FAZA MUTACJI____________________________________________________");
        System.out.println("Rozpoczynana jest faza mutacji. 20% grafików miesięcznych zostanie zmutowanych." +
                            "\nOznacza to, że 20% dni każdego z grafików zostanie na nowo wylosowane.");
        populacja.mutuj(20,20,pracownicy);
        TimeUnit.SECONDS.sleep(6);
        System.out.println("\n. . .\n");
        TimeUnit.SECONDS.sleep(6);
        System.out.println("_______________________WYNIKI PO MUTACJI:______________________________________________");
        System.out.println("Poprawność aktualnie najlepszego grafiku: "+populacja.grafiki[0].ocena+"/30");
        System.out.println("Poprawność aktualnie najgorszego grafiku: "+populacja.grafiki[10].ocena+"/30\n\n\n");
        TimeUnit.SECONDS.sleep(4);


        //wyswietlanie najlepszego grafiku

        System.out.println("_______________________________________________________________________________________");
        System.out.println("_______________________RAPORT KOŃCOWY:_________________________________________________");
        System.out.println("\n\nWidok najlepszego grafiku:\n");
        TimeUnit.SECONDS.sleep(3);
        populacja.grafiki[0].wypisz();

        System.out.println("\n\n\nSprawdzam najlepszy grafik:\n\n");
        populacja.grafiki[0].sprawdzPoprawnosc();
//        for(int x=0;x<=10;x++){
//            System.out.println("\nGrafik nr "+x+"\n");
//            populacja.grafiki[x].sprawdzPoprawnosc();
//        }

    }
}
