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
    /*public void opimisation(){
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
    }*/

    public void optimisation(){
        ArrayList<Couple> C = new ArrayList<>();
        int newF;
        ArrayList<Integer> newQ;
        ArrayList<Integer> voisin;
        Couple c;

        do{
//            System.out.println("\n"+ this.getQueens()+"\n");
//            System.out.println(this.getqMin());
//            System.out.println(this.getfMin() +"\n");
            for (int i = 0; i < getSize(); i++){
                for (int j = i+1; j < this.getSize(); j++){
                    C.add(new Couple(i, j));
                }
            }

            for (Couple m : T){
                C.remove(m);
            }

            if (C.size() > 0){
                //choix du meilleur voisin
                newQ = this.voisin(C.get(0).getVal1(),C.get(0).getVal2());
                newF = this.fitness(newQ);
                c = C.get(0);
                for (int i = 0; i < C.size(); i++){
                    voisin = this.voisin(C.get(i).getVal1(),C.get(i).getVal2());
//                    System.out.println(this.getQueens());
//                    System.out.println(C.get(i).getVal1() +" "+ C.get(i).getVal2() +" "+ voisin);
                    if (this.fitness(voisin) < newF){
                        newQ = voisin;
                        newF = this.fitness(newQ);
                        c = C.get(i);
//                        System.out.println(newQ);
//                        System.out.println(newF);
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
            int iter = this.getIteration() +1;
            this.setIteration(iter);
            if (iter%1 == 0){
                System.out.println(iter + " " + this.getfMin() + " " + this.fitness() + this.getQueens());
            }
//            System.out.println((C.size()));
//            System.out.println(this.getIteration());
//            System.out.println(this.getfMin());
        }while ((C.size() > 0) && (this.getIteration() < this.getIterationMax()) && (this.getfMin() > 0));
    }
}
