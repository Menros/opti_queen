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

    public void optimisation(){
        ArrayList<Couple> C = new ArrayList<>();
        int newF;
        ArrayList<Integer> newQ;
        ArrayList<Integer> voisin;
        Couple c;

        do{
            C = new ArrayList<>();
            for (int i = 0; i < getSize(); i++){
                for (int j = i+1; j < this.getSize(); j++){
                    Couple cp = new Couple(i, j);
                    boolean test = false;
                    if(!T.isEmpty()) {
                        for (Couple m : T) {
                            if (cp.equals(m)){
                                test = true;
                            }
                        }
                        if(!test) C.add(cp);
                    }
                    else C.add(cp);
                }
            }

            if (C.size() > 0){
                //choix du meilleur voisin
                newQ = this.voisin(C.get(0).getVal1(),C.get(0).getVal2());
                newF = this.fitness(newQ);
                c = C.get(0);

                for (Couple cple : C){
                    voisin = this.voisin(cple.getVal1(),cple.getVal2());

                    int fitness = this.fitness(voisin);
                    if (fitness < newF){
                        newQ = voisin;
                        newF = fitness;
                        c = cple;
                        if(fitness == 0) break;
                    }
                }

                if (newF >= this.getfMin()){
                    T.add(c);
                    if (T.size() > Tsize)
                        T.remove(0);
                }
                else{
                    this.setfMin(newF);
                    this.setqMin(newQ);
                }
                this.setQueens(newQ);
            }

            this.setIteration(this.getIteration() +1);

        }while ((C.size() > 0) && (this.getIteration() < this.getIterationMax()) && (this.getfMin() > 0));
    }
}
