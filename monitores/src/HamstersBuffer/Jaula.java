package HamstersBuffer;

import java.util.ArrayList;
import java.util.List;

public class Jaula {

  private final int NUM_RUEDAS = 2;
  private final List<Rueda> ruedas = new ArrayList<>();

  private final int NUM_PLATOS = 2;
  private final List<Plato> platos = new ArrayList<>();

  public Jaula() {
    for (int i = 0; i < NUM_RUEDAS; i++) {
      ruedas.add(new Rueda());
    }

    for (int i = 0; i < NUM_PLATOS; i++) {
      platos.add(new Plato());
    }
  }

  //*****************************************getRueda*****************************************
  
  public synchronized Rueda getRueda(Hamster hamster) {
    System.out.println(String.format("El hamster numero %d intenta usar una rueda", hamster.getNum()));

    while (ruedas.isEmpty()) {
      try {
        System.out.println(String.format("El hamster numero %d no tiene ninguna rueda disponible. Esperara a que haya alguna", hamster.getNum()));
        wait();
        System.out.println(String.format("El hamster numero %d ha dejado de esperar a que haya una rueda disponible", hamster.getNum()));
      } catch (InterruptedException e) {
        System.err.println("Interrupcion del hilo...");
      }
    }

    System.out.println(String.format("El hamster %d utiliza la rueda", hamster.getNum()));
    var rueda = ruedas.remove(0);

    System.out.println(String.format("El hamster %d notifica que esta utilizando una rueda", hamster.getNum()));
    notifyAll();

    System.out.println(String.format("El hamster %d ha terminado de empezar a utilizar la rueda", hamster.getNum()));
    return rueda;
  }

  //*****************************************putRueda*****************************************
  
  public synchronized void putRueda(Hamster hamster, Rueda rueda) {
    System.out.println(String.format("El hamster numero %d deja de utilizar una rueda", hamster.getNum()));
    ruedas.add(rueda);

    System.out.println(String.format("El hamster numero %d notifica que ha terminado de utilizar una rueda", hamster.getNum()));
    notifyAll();

    System.out.println(String.format("El hamster numero %d ha terminado de dejar la rueda", hamster.getNum()));
  }

  //*****************************************getPlato*****************************************
  
  public synchronized Plato getPlato(Hamster hamster) {
    System.out.println(String.format("El hamster numero %d intenta usar un plato", hamster.getNum()));

    while (platos.isEmpty()) {
      try {
        System.out.println(String.format("El hamster numero %d no tiene ningun plato disponible. Esperara a que haya alguno", hamster.getNum()));
        wait();
        System.out.println(String.format("El hamster numero %d ha dejado de esperar a que haya un plato disponible", hamster.getNum()));
      } catch (InterruptedException e) {
        System.err.println("Interrupcion del hilo...");
      }
    }

    System.out.println(String.format("El hamster %d utiliza el plato", hamster.getNum()));
    var plato = platos.remove(0);

    System.out.println(String.format("El hamster %d notifica que esta utilizando un plato", hamster.getNum()));
    notifyAll();

    System.out.println(String.format("El hamster %d ha terminado de empezar a utilizar el plato", hamster.getNum()));
    return plato;
  }

  //*****************************************putPlato*****************************************
  
  public synchronized void putPlato(Hamster hamster, Plato plato) {
    System.out.println(String.format("El hamster numero %d deja de utilizar un plato", hamster.getNum()));
    platos.add(plato);

    System.out.println(String.format("El hamster numero %d notifica que ha terminado de utilizar un plato", hamster.getNum()));
    notifyAll();

    System.out.println(String.format("El hamster numero %d ha terminado de dejar el plato", hamster.getNum()));
  }
}
