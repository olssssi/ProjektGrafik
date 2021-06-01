package notApplication;

import java.util.Arrays;

public class Populacja {
    GrafikMiesieczny grafiki[] = new GrafikMiesieczny[11];

    @Override
    public String toString() {
        String r="\nAKTUALNA POPULACJA:\n";
        for(int i=1; i<grafiki.length; i++){
            r=r+i+": "+grafiki[i].ocena+"\n";
        }
        return r;
    }
}
