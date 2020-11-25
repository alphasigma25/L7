package hanoi;

import util.Pile;

/**
 * classe implémentant la résolution d'un problème de tour de Hanoi
 */
public class Hanoi {
    private final Pile[] piles = new Pile[3];
    private final int disks;
    private HanoiDisplayer displayer;
    private int turns = 0;
    private boolean isFinished = false;

    /**
     * @param disks nombre de disques à placer
     */
    public Hanoi(int disks) {
        this(disks, new HanoiDisplayer());
    }

    /**
     * @param disks     nombre de disques à placer
     * @param displayer affichage
     */
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

    /**
     *
     */
    public void getEtat() {
        System.out.println("-- Turn : " + turns);
        int i = 1;
        for (Pile p : piles) {
            System.out.println(i++ + ": " + p);
        }
    }

    /**
     * @return si on a fini le transfer des disques
     */
    public boolean finished() {
        return isFinished;
    }

    /**
     * @return tableau contenant l'état actuel des piles avec les disques placés dessus
     */
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

    /**
     * @return le nombre d'itérations effectuées
     */
    public int turn() {
        return turns;
    }

    /**
     * résoud le problème de transfer des disques
     */
    public void solve() {
        if (displayer != null) displayer.display(this);
        run(disks, piles[0], piles[1], piles[2]);
        isFinished = true;
    }

    /**
     *
     * @param n     nombre de d'itérations restantes / de disques à traiter
     * @param orig  pile de départ
     * @param inter pile de transition
     * @param dest  pile d'arrivée
     */
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
