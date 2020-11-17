package util;

public class TestPile {
    public static void main(String[] args) {
        Pile p = new Pile();

        p.empiler("coucou");
        p.empiler("hey 1");
        p.empiler("hey 2");
        p.empiler("hey 3");
        p.empiler("Guten Morgen");

        System.out.println(p);

        p.desempiler();

        System.out.println(p);

        for (Object value : p.tab()) {
            System.out.println("v: "+value);
        }

    }
}
