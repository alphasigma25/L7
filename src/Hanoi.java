public class Hanoi {
    Pile A = new Pile();
    Pile B = new Pile();
    Pile C = new Pile();

    public Hanoi(int n) {
        for(int i = 0; i < n; ++i){
            A.empiler(i);
        }
        System.out.println("");
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        run(n,A,B,C);
    }

    private void run(int n, Pile orig, Pile inter, Pile dest) {

        if(n > 0){
            run(n-1,orig,dest,inter);
            dest.empiler(orig.desempiler());
            System.out.println("");
            System.out.println(A);
            System.out.println(B);
            System.out.println(C);
            run(n-1,inter, orig, dest);
        }
    }

    public static void main(String[] args) {
        Hanoi tour = new Hanoi(30);
    }
}
