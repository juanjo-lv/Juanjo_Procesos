package Hamsters3;

public class Hamster extends Thread{

    private ColaRecursos colaRecursos;
    private int idHamster;

    public Hamster(ColaRecursos c, int id) {
        colaRecursos = c;
        idHamster = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            if (Math.round(Math.random()) == 0) {
                int rueda = colaRecursos.getRueda();
                System.out.println( "El hamster " + idHamster + " esta usando  la rueda " + rueda);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                colaRecursos.putRueda(rueda);
                System.out.println( "El hamster " + idHamster +" ha terminado  con la rueda " + rueda );
            } else {
                int plato = colaRecursos.getPlato();
                System.out.println( "El hamster " + idHamster + " esta usando el plato " + plato);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                colaRecursos.putPlato(plato);
                System.out.println("El hamster " + idHamster + " ha terminado " + "con el plato " + plato);
            }
        }
    }
}
