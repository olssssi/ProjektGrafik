package notApplication;

import java.util.ArrayList;

public class GrafikMiesieczny {
    ArrayList<GrafikDzienny> grafik;

    public GrafikMiesieczny() {
        grafik = new ArrayList<GrafikDzienny>(31);
        grafik.add(null);

    }

    public ArrayList<GrafikDzienny> getGrafik() {
        return grafik;
    }

}
