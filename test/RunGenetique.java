import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Silver on 21-May-17.
 */
public class RunGenetique {
    public static void main(String[] args){
        int n = 20;
        int nbSolutions = 100;
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < nbSolutions; i++){
            ArrayList<Integer> solution = new ArrayList<>();
            for (int j = 0; j < n; j++){
                solution.add(random.nextInt(n));
            }
            solutions.add(solution);
        }
        Genetique gen = new Genetique(n, 1000000, solutions,
                1,1,1,
                12,5,3);

        long timeStart = System.nanoTime();
        gen.optimisation();
        long timeEnd = System.nanoTime();
        System.out.println(gen.getIteration() + " itérations");
        System.out.println(Math.round((timeEnd - timeStart)*Math.pow(10, -6)) +"ms");
//        System.out.println(Math.round((timeEnd - timeStart)*Math.pow(10, -9)) +"s");
        System.out.println(gen.getqMin());
        System.out.println(gen.getfMin());
    }

}
