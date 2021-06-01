package notApplication;
import java.util.*;

public class Populacja {
    GrafikMiesieczny grafiki[] = new GrafikMiesieczny[11];
    Comparator comparator = new GrafikMiesieczny();
    public void sortuj(){
        Arrays.sort(grafiki, comparator);
    }

    @Override
    public String toString() {
        String r="\nAKTUALNA POPULACJA:\n";
        for(int i=0; i< grafiki.length; i++){
            r=r+i+": "+grafiki[i].ocena+" "+grafiki[i].toString()+"\n";
        }
        return r;
    }



}
