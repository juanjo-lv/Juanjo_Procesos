package Hamsters3;

public class Main {
    public static void main(String[] args) {

        ColaRecursos c = new ColaRecursos(5, 3);
        for (int i = 0; i < 16; i++) {
            Hamster h = new Hamster(c, i);
            h.start();
        }

    }
}
