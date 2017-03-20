import java.util.ArrayList;

/**
 * Created by Silver on 15-Mar-17.
 */
public class Tabou extends MOptimisation {
    private ArrayList<Couple> T;
    int Tsize;

    public Tabou(int size, int iterationMax, int Tsize, ArrayList<Integer> queens) {
        super(size, iterationMax, queens);
        this.Tsize = Tsize;
        this.T = new ArrayList<Couple>();
    }
    public void opimisation(){
        ArrayList<ArrayList<Integer>> C = new ArrayList<>();
        int newF;
        ArrayList<Integer> newQ;

        do{
            C = super.voisins();
            for (Couple m : T){
                C.remove(voisin(m.getVal1(),m.getVal2()));
            }
            if (C.size() > 0){
                //choix du meilleur voisin
                newQ = C.get(0);
                newF = this.fitness(newQ);
                for (int i = 1; i < C.size(); i++){
                    if (this.fitness(C.get(i)) < newF){
                        newQ = C.get(i);
                        newF = this.fitness(newQ);
                    }
                }

                if (newF > this.getfMin()){
//                    this.T.add PB recup couple echange
                }

                if (newF < this.getfMin()){
                    this.setfMin(newF);
                    this.setqMin(newQ);
                }
                this.setQueens(newQ);
            }
            this.setIteration(this.getIteration() + 1);
        }while ((C.size() > 0) && (this.getIteration() < this.getIterationMax()) && (this.getfMin() > 0));
    }
}
