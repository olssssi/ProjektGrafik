package notApplication;

import java.sql.SQLOutput;

public class GrafikDzienny {
    int dzien;
    String dzienTygodnia;
    Pracownik porannaZmiana;
    Pracownik wieczornaZmiana;

    public GrafikDzienny(int dzien, String dzienTygodnia) {
        this.dzien = dzien;
        this.dzienTygodnia = dzienTygodnia;
        this.porannaZmiana = null;
        this.wieczornaZmiana = null;
    }

    public GrafikDzienny(int dzien, String dzienTygodnia,
                         Pracownik porannaZmiana, Pracownik wieczornaZmiana) {
        this.dzien = dzien;
        this.dzienTygodnia = dzienTygodnia;
        this.porannaZmiana = porannaZmiana;
        this.wieczornaZmiana = wieczornaZmiana;
    }

    public Pracownik getPorannaZmiana() {
        return porannaZmiana;
    }

    public void setPorannaZmiana(Pracownik porannaZmiana) {
        this.porannaZmiana = porannaZmiana;
    }

    public Pracownik getWieczornaZmiana() {
        return wieczornaZmiana;
    }

    public void setWieczornaZmiana(Pracownik wieczornaZmiana) {
        this.wieczornaZmiana = wieczornaZmiana;
    }


    public boolean sprawdzPoprawnosc(GrafikDzienny poprzedniDzien){
//        if(dzienTygodnia.equals("Sobota"))
//        Na razie na sztywno sprawdzam te soboty i niedziele
        if(dzien==5 || dzien==12 || dzien==19 || dzien==26) {
            if (!sprawdzSobote()) {
                System.out.println("Powód: Sobotnie popołudnie powinno być niepracujące\n");
                return false;
            }
//            else if(dzienTygodnia.equals("Niedziela"))
        }else if(dzien==6 || dzien==13 || dzien==20 || dzien==27) {
            if (!sprawdzNiedziele()) {
                System.out.println("Powód: Niedziela powinna być niepracująca\n");
                return false;
            }
        }else{
            if(porannaZmiana == null){
                System.out.println("Powód: Brak osoby na poranną zmianę w ciągu tygodnia\n");
                return false;
            }
            if(wieczornaZmiana == null){
                System.out.println("Powód: Brak osoby na wieczorną zmianę w ciągu tygodnia\n");
                return false;
            }

            if(!sprawdzPodwojneZmiany()){
                System.out.println("Powód: Napotkano podwojne zmiany\n");
                return false;
            }

            if(!sprawdzZmianyRW(poprzedniDzien)){
                System.out.println("Powód: Nie można pracowac dwie zmiany pod rzad\n");
                return false;
            }

            if(!sprawdzIloscH()){
                System.out.println("Powód: Zbyt wiele przepracowanych godzin\n");
                return false;
            }

        }
        return true;
    }

    // Sprawdza, czy nie ma tej samej osoby na dzień, co na wieczór
    public boolean sprawdzPodwojneZmiany(){
        return wieczornaZmiana != porannaZmiana;
    }

    // Sprawdza, czy w dzien roboczy jest pracownik na ranną i na wieczorną zmianę
    public boolean sprawdzDzien(){
        if(porannaZmiana == null)
            return false;
        if(wieczornaZmiana == null)
            return false;
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
        return porannaZmiana.iloscH<=120 && wieczornaZmiana.iloscH<=120;
    }

}
