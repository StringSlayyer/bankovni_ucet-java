import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CislaUctu {
    private List<Integer> cisla = new ArrayList<Integer>();


    public int cisloU(){
        Random r = new Random();
        int min = 1000000;
        int max = 9999999;

        int genCislo = r.nextInt((max - min)+1) + min;
        if(cisla.contains(genCislo)){
            cisloU();
        }else {
            cisla.add(genCislo);
        }
        return genCislo;
    }

    public List<Integer> getList() {
        return cisla;
    }
}
