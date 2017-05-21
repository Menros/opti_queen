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
        ArrayList<Couple> C = new ArrayList<>();
        int newF;
        ArrayList<Integer> newQ;
        ArrayList<Integer> voisin;
        Couple c;

        do{
            for (int i = 0; i < getSize(); i++){
                for (int j = i+1; j < this.getSize(); j++){
                    C.add(new Couple(i, j));
                }
            }
            C.removeAll(T);

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

                if (newF < this.getfMin()){
                    this.setfMin(newF);
                    this.setqMin(newQ);
                }
                this.setQueens(newQ);
            }

            this.setIteration(this.getIteration() +1);

        }while ((C.size() > 0) && (this.getIteration() < this.getIterationMax()) && (this.getfMin() > 0));
    }
}
