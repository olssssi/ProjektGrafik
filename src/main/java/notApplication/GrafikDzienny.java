package notApplication;

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


    public boolean sprawdzPoprawnosc(){
        if(dzienTygodnia.equals("Sobota"))
            if(!sprawdzSobote()) return false;
            else if(dzienTygodnia.equals("Niedziela"))
                if(!sprawdzNiedziele()) return false;
                else{
                    if(porannaZmiana == null)
                        return false;
                    if(wieczornaZmiana == null)
                        return false;
                    if(!sprawdzPodwojneZmiany())
                        return false;
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
}
