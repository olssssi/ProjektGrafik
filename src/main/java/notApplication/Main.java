package notApplication;

public class Main {
//    static int[][] idPracownika = new int[31][2];
static GrafikMiesieczny grafikMiesieczny = new GrafikMiesieczny();


//    public Main(){
//        for(int i=1; i<=30; i++){
//            idPracownika[i][0]= 0;
//            idPracownika[i][1]= 0;
//        }
//    }
    public static void main(String[] args) {
        Pracownik pracownik1 = new Pracownik(1);
        Pracownik pracownik2 = new Pracownik(2);
        System.out.println("id1: "+pracownik1.idPracownika);
        System.out.println("id2: "+pracownik2.idPracownika);
        pracownik1.wpiszDostepnosc();
        pracownik2.wpiszDostepnosc();

        //tutaj powinna być strategia przeszukiwań
        // Nie wiem na razie jak dodawać poranną a jak wieczorną zmianę xd
        for(int i=1; i<=30; i++){
            if((i+1)%7==0){
                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"niedziela", null, null);
                grafikMiesieczny.grafik.add(grafikDzienny);
            }
            else if(pracownik1.tabDostepnosci[i]==1 && pracownik2.tabDostepnosci[i]==1){
                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"wtorek", pracownik1, pracownik2);
                grafikMiesieczny.grafik.add(grafikDzienny);
            }
            else if(pracownik1.tabDostepnosci[i]==1){
                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"wtorek", pracownik1, null);
                grafikMiesieczny.grafik.add(grafikDzienny);
            }
            else if(pracownik2.tabDostepnosci[i]==1){
                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"wtorek", pracownik2, null);
                grafikMiesieczny.grafik.add(grafikDzienny);
            }
            else{
                GrafikDzienny grafikDzienny = new GrafikDzienny(i,"wtorek", null, null);
                grafikMiesieczny.grafik.add(grafikDzienny);
            }
            //jeszcze nie wiem czy grafik potrzebny czy robimy wszystko na zasadzie tabeli dwuwymiarowej
            //GrafikNaDzien grafik = new GrafikNaDzien(i,idPracownika[i][0], idPracownika[i][1] );
        }

        //wyswietlanie tabelki
            //sout +TAB  -skrot do system out
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|                        |           1            |           2            |           3            |           4            |           5            |           6            |");
            System.out.println("|                        |"+grafikMiesieczny.grafik.get(1).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(2).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(3).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(4).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(5).porannaZmiana+"                    |                        |");
            System.out.println("|                        |"+grafikMiesieczny.grafik.get(1).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(2).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(3).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(4).wieczornaZmiana+"                    |                        |                        |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|           7            |           8            |           9            |           10           |           11           |           12           |           13           |");
            System.out.println("|"+grafikMiesieczny.grafik.get(7).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(8).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(9).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(10).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(11).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(12).porannaZmiana+"                    |                        |");
            System.out.println("|"+grafikMiesieczny.grafik.get(7).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(8).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(9).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(10).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(11).wieczornaZmiana+"                    |                        |                        |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|           14           |           15           |           16           |           17           |           18           |           19           |           20           |");
            System.out.println("|"+grafikMiesieczny.grafik.get(14).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(15).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(16).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(17).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(18).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(19).porannaZmiana+"                    |                        |");
            System.out.println("|"+grafikMiesieczny.grafik.get(14).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(15).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(16).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(17).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(18).wieczornaZmiana+"                    |                        |                        |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|           21           |           22           |           23           |           24           |           25           |           26           |           27           |");
            System.out.println("|"+grafikMiesieczny.grafik.get(21).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(22).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(23).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(24).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(25).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(26).porannaZmiana+"                    |                        |");
            System.out.println("|"+grafikMiesieczny.grafik.get(21).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(22).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(23).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(24).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(25).wieczornaZmiana+"                    |                        |                        |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|           28           |           29           |           30           |                        |                        |                        |                        |");
            System.out.println("|"+grafikMiesieczny.grafik.get(28).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(29).porannaZmiana+"                    |"+grafikMiesieczny.grafik.get(30).porannaZmiana+"                    |                        |                        |                        |                        |");
            System.out.println("|"+grafikMiesieczny.grafik.get(28).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(29).wieczornaZmiana+"                    |"+grafikMiesieczny.grafik.get(30).wieczornaZmiana+"                    |                        |                        |                        |                        |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");



    }

}
