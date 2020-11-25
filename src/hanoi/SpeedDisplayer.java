package hanoi;

public class SpeedDisplayer extends HanoiDisplayer {
    @Override
    public void display(Hanoi h) {
        if((h.turn()%80000000) == 0) super.display(h);
    }
}
