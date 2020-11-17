package hanoi;

import util.*;

public class Hanoi {
    private Pile[] piles = new Pile[3];
    private int disks;
    private HanoiDisplayer displayer;
    private int states = 0;
    private boolean isFinished = false;

    public Hanoi(int disks) {
        this.disks = disks;
        init();
    }

    public Hanoi(int disks, HanoiDisplayer displayer) {
        this(disks);
        this.displayer = displayer;
    }

    private void init(){
        for(int i = 0; i < piles.length; ++i) {
            piles[i] = new Pile();
        }
        for(int i = 0; i < disks; ++i) {
            piles[0].empiler(i);
        }
        states = 0;
        isFinished = false;
    }
    public void getEtat(){
        System.out.println("");
        for(Pile p : piles) {
            System.out.println(p);
        }
    }

    public boolean finished(){
        //TODo

        return isFinished;
    }

    public int[][] status(){
        int[][] t = new int[piles.length][disks];
        for(int i = 0; i < piles.length; ++i){
            Object[] p = piles[i].tab();
            for(int j = 0; j < disks; ++j){
                t[i][j] = (int) p[j];
            }
        }

        return t;
    }

    public int turn(){
        return states;
    }

    public void solve(){
        displayer.display(this);
        run(disks,piles[0],piles[1],piles[2]);
        isFinished = true;
    }
    private void run(int n, Pile orig, Pile inter, Pile dest) {

        if(n > 0){
            run(n-1,orig,dest,inter);
            dest.empiler(orig.desempiler());
            ++states;
            displayer.display(this);
            run(n-1,inter, orig, dest);
        }
    }

    public static void main(String[] args) {
        //new hanoi.gui.JHanoi();
        Hanoi tour = new Hanoi(15, new HanoiDisplayer());
        tour.solve();
    }
}
