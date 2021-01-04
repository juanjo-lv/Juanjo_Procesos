package HamstersBuffer;

import java.util.Random;

public class Hamster extends Thread {

  private int num;
  private Jaula jaula; // Es el recurso compartido... más bien sus elementos

  public Hamster(int num, Jaula jaula) {
    this.num = num;
    this.jaula = jaula;
  }

  @Override
  public void run() {
    for (int i = 0; i < 3; i++) {
      var rueda = new Random().nextInt(2) < 1;

      if (rueda) {
        usarRueda();
      } else {
        usarPlato();
      }
    }
  }

  public int getNum() {
    return num;
  }

  private void usarRueda() {
    System.out.println(String.format("El hamster numero %d va a usar una rueda", num));
    var rueda = jaula.getRueda(this);
    System.out.println(String.format("El hamster numero %d esta utilizando una rueda", num));

    try {
      // El hamster utiliza la rueda entre 200 y 400 milisegundos
      sleep(new Random().nextInt(200) + 200L);
    } catch (InterruptedException e) {
      System.err.println("Interrupcion del hilo...");
    }

    System.out.println(String.format("El hamster numero %d va a dejar de utilizar una rueda", num));
    jaula.putRueda(this, rueda);
    System.out.println(String.format("El hamster numero %d ha dejado de utilizar una rueda", num));
  }

  private void usarPlato() {
    System.out.println(String.format("El hamster numero %d va a usar un plato", num));
    var plato = jaula.getPlato(this);
    System.out.println(String.format("El hamster numero %d esta utilizando un plato", num));

    try {
      // El hamster utiliza el plato entre 200 y 400 milisegundos
      sleep(new Random().nextInt(200) + 200L);
    } catch (InterruptedException e) {
      System.err.println("Interrupcion del hilo...");
    }

    System.out.println(String.format("El hamster numero %d va a dejar de utilizar un plato", num));
    jaula.putPlato(this, plato);
    System.out.println(String.format("El hamster numero %d ha dejado de utilizar un plato", num));
  }
}
