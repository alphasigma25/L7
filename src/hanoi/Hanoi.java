package hanoi;

import util.Pile;

/**
 *
 */
public class Hanoi {
    private final Pile[] piles = new Pile[3];
    private final int disks;
    private HanoiDisplayer displayer;
    private int turns = 0;
    private boolean isFinished = false;

    public Hanoi(int disks) {
        this(disks, new HanoiDisplayer());
    }

    public Hanoi(int disks, HanoiDisplayer displayer) {
        this.disks = disks;
        for (int i = 0; i < piles.length; ++i) {
            piles[i] = new Pile();
        }
        for (int i = 0; i < disks; ++i) {
            piles[0].empiler(disks - i);
        }
        this.displayer = displayer;
    }

    public void getEtat() {
        System.out.println("-- Turn : " + turns);
        int i = 1;
        for (Pile p : piles) {
            System.out.println(i++ + ": " + p);
        }
    }

    public boolean finished() {
        return isFinished;
    }

    public int[][] status() {
        int[][] t = new int[piles.length][];
        for (int i = 0; i < piles.length; ++i) {
            Object[] p = piles[i].tab();
            t[i] = new int[p.length];
            for (int j = 0; j < p.length; ++j) {
                t[i][j] = (int) p[p.length - 1 - j];
            }
        }
        return t;
    }

    public int turn() {
        return turns;
    }

    public void solve() {
        if (displayer != null) displayer.display(this);
        run(disks, piles[0], piles[1], piles[2]);
        isFinished = true;
    }

    private void run(int n, Pile orig, Pile inter, Pile dest) {
        if (n > 0) {
            run(n - 1, orig, dest, inter);
            dest.empiler(orig.desempiler());
            ++turns;
            if (displayer != null) displayer.display(this);
            run(n - 1, inter, orig, dest);
        }
    }
}
