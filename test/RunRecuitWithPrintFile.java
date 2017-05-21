import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Menros on 20/05/2017.
 */
public class RunRecuitWithPrintFile {
    public static void main(String[] args) {
        int testMoy = 1000;
        int n = 100;
//        double p = 0.9;
        int n1 = n*2;
        int n2 = n*8;
        double temperatureInitiale = 0.1;
        int gamma = 1; // /100
        ArrayList<Integer> queens;

        queens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queens.add(i);
        }
        RecuitSimule recuit;

        long timeStart = 0;
        long timeEnd = 0;

        long timeMoy = 0;
        int iterMoy = 0;
        int fitnessMoy = 0;

        try{
            PrintWriter writer = new PrintWriter("test.csv", "UTF-8");
            writer.println("n2;temps d'execution;nombre d'iterations;fitness minimum");
            for(int q = 10 ; q <= 200 ; q+=10){
                n2 = q;
//                n2 = n*8;
//                queens = new ArrayList<>();
//                for (int i = 0; i < n; i++) {
//                    queens.add(i);
//                }
                System.out.println("n = " + n);
                System.out.println("t0 = " + temperatureInitiale);
                for(int c = 0 ; c < testMoy ; c++){
                    timeStart = System.currentTimeMillis();
                    recuit = new RecuitSimule(n, queens, n1, n2, temperatureInitiale, (double)gamma/100);
                    recuit.optimisation();
                    timeEnd = System.currentTimeMillis();
                    timeMoy += (timeEnd - timeStart);
                    iterMoy += recuit.getIteration();
                    fitnessMoy += recuit.getfMin();
                }
                timeMoy = timeMoy/testMoy;
                iterMoy = iterMoy/testMoy;
                fitnessMoy = fitnessMoy/testMoy;

                System.out.println("time = " + timeMoy);
                System.out.println(iterMoy + " itérations");
                writer.println(n2 + ";" + timeMoy + ";" + iterMoy + ";" + fitnessMoy);
                System.out.println("");
            }
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }
}
