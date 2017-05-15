import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Silver on 15-Mar-17.
 */
public class Contexte {
    private int size;
    private MOptimisation Mopti;

    public Contexte(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
       Tabou tabou = new Tabou(8, 1000000000, 3,
                new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7)));
        tabou.opimisation();
        System.out.println(tabou.getfMin());
        System.out.println((tabou.getQueens()));

    }
}
