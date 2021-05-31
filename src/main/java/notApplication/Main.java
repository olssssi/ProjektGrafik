package notApplication;

public class Main {
    static int[][] idPracownika = new int[31][2];

    public Main(){
        for(int i=1; i<=30; i++){
            idPracownika[i][0]= 0;
            idPracownika[i][1]= 0;
        }
    }
    public static void main(String[] args) {
        Pracownik pracownik1 = new Pracownik(1);
        Pracownik pracownik2 = new Pracownik(2);
        System.out.println("id1: "+pracownik1.idPracownika);
        System.out.println("id2: "+pracownik2.idPracownika);
        pracownik1.wpiszDostepnosc();
        pracownik2.wpiszDostepnosc();

        //tutaj powinna być strategia przeszukiwań
        for(int i=1; i<=30; i++){
            if(pracownik1.tabDostepnosci[i]==1){
                idPracownika[i][0]= pracownik1.idPracownika;
            }
            else if(pracownik2.tabDostepnosci[i]==1){
                idPracownika[i][0]= pracownik2.idPracownika;
            }
            else{
                idPracownika[i][0] = -1;
            }
            //jeszcze nie wiem czy grafik potrzebny czy robimy wszystko na zasadzie tabeli dwuwymiarowej
            //GrafikNaDzien grafik = new GrafikNaDzien(i,idPracownika[i][0], idPracownika[i][1] );
        }

        //wyswietlanie tabelki
            //sout +TAB  -skrot do system out
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|                        |           1            |           2            |           3            |           4            |           5            |           6            |");
            System.out.println("|                        |  Pracownik "+idPracownika[1][0]+"           |  Pracownik "+idPracownika[2][0]+"           |  Pracownik "+idPracownika[3][0]+"           |  Pracownik "+idPracownika[4][0]+"           |  Pracownik "+idPracownika[5][0]+"           |                        |");
            System.out.println("|                        |  Pracownik "+idPracownika[1][1]+"           |  Pracownik "+idPracownika[2][1]+"           |  Pracownik "+idPracownika[3][1]+"           |  Pracownik "+idPracownika[4][1]+"           |  Pracownik "+idPracownika[5][1]+"           |                        |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|           7            |           8            |           9            |           10           |           11           |           12           |           13           |");
            System.out.println("|  Pracownik "+idPracownika[7][0]+"           |  Pracownik "+idPracownika[8][0]+"           |  Pracownik "+idPracownika[9][0]+"           |  Pracownik "+idPracownika[10][0]+"           |  Pracownik "+idPracownika[11][0]+"           |  Pracownik "+idPracownika[12][0]+"           |                        |");
            System.out.println("|  Pracownik "+idPracownika[7][1]+"           |  Pracownik "+idPracownika[8][1]+"           |  Pracownik "+idPracownika[9][1]+"           |  Pracownik "+idPracownika[10][1]+"           |  Pracownik "+idPracownika[11][1]+"           |  Pracownik "+idPracownika[12][1]+"           |                        |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|           14           |           15           |           16           |           17           |           18           |           19           |           20           |");
            System.out.println("|  Pracownik "+idPracownika[14][0]+"           |  Pracownik "+idPracownika[15][0]+"           |  Pracownik "+idPracownika[16][0]+"           |  Pracownik "+idPracownika[17][0]+"           |  Pracownik "+idPracownika[18][0]+"           |  Pracownik "+idPracownika[19][0]+"           |                        |");
            System.out.println("|  Pracownik "+idPracownika[14][1]+"           |  Pracownik "+idPracownika[15][1]+"           |  Pracownik "+idPracownika[16][1]+"           |  Pracownik "+idPracownika[17][1]+"           |  Pracownik "+idPracownika[18][1]+"           |  Pracownik "+idPracownika[19][1]+"           |                        |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|           21           |           22           |           23           |           24           |           25           |           26           |           27           |");
            System.out.println("|  Pracownik "+idPracownika[21][0]+"           |  Pracownik "+idPracownika[22][0]+"           |  Pracownik "+idPracownika[23][0]+"           |  Pracownik "+idPracownika[24][0]+"           |  Pracownik "+idPracownika[25][0]+"           |  Pracownik "+idPracownika[26][0]+"           |                        |");
            System.out.println("|  Pracownik "+idPracownika[21][1]+"           |  Pracownik "+idPracownika[22][1]+"           |  Pracownik "+idPracownika[23][1]+"           |  Pracownik "+idPracownika[24][1]+"           |  Pracownik "+idPracownika[25][1]+"           |  Pracownik "+idPracownika[26][1]+"           |                        |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("|           28           |           29           |           30           |                        |                        |                        |                        |");
            System.out.println("|  Pracownik "+idPracownika[28][0]+"           |  Pracownik "+idPracownika[29][0]+"           |  Pracownik "+idPracownika[30][0]+"           |                        |                        |                        |                        |");
            System.out.println("|  Pracownik "+idPracownika[28][1]+"           |  Pracownik "+idPracownika[29][1]+"           |  Pracownik "+idPracownika[30][1]+"           |                        |                        |                        |                        |");
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________");



    }

}
