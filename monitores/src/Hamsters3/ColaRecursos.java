package Hamsters3;

import java.util.ArrayList;

public class ColaRecursos {
    private ArrayList<Integer> ruedas = new ArrayList<Integer>();
    private ArrayList<Integer> platos = new ArrayList<Integer>();

    // Constructor para crear las ruedas y los platos
    public ColaRecursos(int ruedas, int platos) {
        for (int i = 0; i < ruedas; i++) {
            this.ruedas.add(i);
        }
        for (int i = 0; i < platos; i++) {
            this.platos.add(i);
        }
    }

    /**
     * Getter para que el hamster use una rueda
     * @return rueda
     */
    public synchronized int getRueda() {
        while (ruedas.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int rueda = ruedas.remove(0);
        notifyAll();
        return rueda;
    }

    /**
     * Getter para que el hamster use un plato
     * @return
     */
    public synchronized int getPlato() {
        while (platos.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int plato = platos.remove(0);
        notifyAll();
        return plato;
    }

    public synchronized void putRueda(int rueda) {
        ruedas.add(rueda);
        notifyAll();
    }

    public synchronized void putPlato(int plato) {
        ruedas.add(plato);
        notifyAll();
    }



}
