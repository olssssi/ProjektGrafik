package consoleApplication;

public class GrafikDzienny {
    int dzien;
    Pracownik porannaZmiana;
    Pracownik wieczornaZmiana;

    public GrafikDzienny(int dzien,
                         Pracownik porannaZmiana, Pracownik wieczornaZmiana) {
        this.dzien = dzien;
        this.porannaZmiana = porannaZmiana;
        this.wieczornaZmiana = wieczornaZmiana;
    }

    public boolean sprawdzPoprawnosc(GrafikDzienny poprzedniDzien){
        // Soboty
        if(dzien==5 || dzien==12 || dzien==19 || dzien==26) {
            return sprawdzSobote();
        }else
            // Niedziele
            if(dzien==6 || dzien==13 || dzien==20 || dzien==27) {
                return sprawdzNiedziele();
        }else{
            if(porannaZmiana == null){
                return false;
            }
            if(wieczornaZmiana == null){
                return false;
            }
            if(!sprawdzZmianyRW(poprzedniDzien)){
                return false;
            }
            if(!sprawdzIloscH()){
                return false;
            }
        }
        return true;
    }

    // Sprawdza, czy w sobotę na wieczorną zmianę nikt nie pracuje
    public boolean sprawdzSobote(){
        return porannaZmiana != null && wieczornaZmiana == null;
    }

    // Sprawdza, czy w niedzielę nikt nie pracuje
    public boolean sprawdzNiedziele(){
        return porannaZmiana == null && wieczornaZmiana == null;
    }

    //Sprawdza, czy osoba pracująca na wieczór nie pracuje następnego dnia rano
    public boolean sprawdzZmianyRW(GrafikDzienny poprzedniDzien){
        if(poprzedniDzien==null) return true;
        return porannaZmiana != poprzedniDzien.wieczornaZmiana;
    }

    //Sprawdza, czy pracownik nie przekroczyl
    // albo 96h (384h/4 = 96) - wszystkie godziny na 4 pracownikow - daje najslabsze wyniki
    // albo 120h albo 112h bo czasami zdarzają się takie wyniki czyli to jest jakiś nadmiar
    public boolean sprawdzIloscH(){
        return (porannaZmiana != null && porannaZmiana.iloscH<=120) && (wieczornaZmiana != null && wieczornaZmiana.iloscH<=120);
    }

    public Pracownik znajdzPracoholika(){
        if(porannaZmiana != null && porannaZmiana.iloscH>120) return porannaZmiana;
        else if (wieczornaZmiana != null && wieczornaZmiana.iloscH>120) return wieczornaZmiana;
        return null;
    }

    public void wypiszBledy(int id, GrafikDzienny poprzedniDzien, Pracownik[] pracownicy) {
        // Soboty
        if(dzien==5 || dzien==12 || dzien==19 || dzien==26) {
            if (!sprawdzSobote()) {
                if(id>=10)
                    System.out.println("      " +id+ "         |     pracujące sobotnie popołudnie");
                else
                    System.out.println("       " +id+ "         |     pracujące sobotnie popołudnie");
            }
        // Niedziele
        }else if(dzien==6 || dzien==13 || dzien==20 || dzien==27) {
            if (!sprawdzNiedziele()) {
                if(id>=10)
                    System.out.println("      " +id+ "         |     pracująca niedziela");
                else
                    System.out.println("       " +id+ "         |     pracująca niedziela");
            }
        }else{
            if(porannaZmiana == null){
                if(id>=10)
                    System.out.println("      " +id+ "         |     brak osoby na poranną zmianę");
                else
                    System.out.println("       " +id+ "         |     brak osoby na poranną zmianę");
                return;
            }
            if(wieczornaZmiana == null){
                if(id>=10)
                    System.out.println("      " +id+ "         |     brak osoby na wieczorną zmianę");
                else
                    System.out.println("       " +id+ "         |     brak osoby na wieczorną zmianę");
                return;
            }
            if(!sprawdzZmianyRW(poprzedniDzien)){
                if(id>=10)
                    System.out.println("      " +id+ "         |     zmiana ranna taka sama jak wieczorna poprzedniego dnia");
                else
                    System.out.println("       " +id+ "         |     zmiana ranna taka sama jak wieczorna poprzedniego dnia");
                return;
            }
            if(znajdzPracoholika()!=null){
                Pracownik pracownik=znajdzPracoholika();
                if(!pracownik.flaga && id>=10){
                    System.out.println("      " +id+ "         |     osoba "+pracownik.idPracownika+" przekroczyla 120h");
                    pracownicy[pracownik.idPracownika].flaga=true;
                }

                else if(!pracownik.flaga){
                    System.out.println("       " +id+ "         |     osoba "+pracownik.idPracownika+" przekroczyla 120h");
                    pracownicy[pracownik.idPracownika].flaga=true;
                }
            }
        }
    }
}
