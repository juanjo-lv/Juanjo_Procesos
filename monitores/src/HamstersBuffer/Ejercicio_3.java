package HamstersBuffer;

public class Ejercicio_3 {

  public static void main(String[] args) {
    var jaula = new Jaula();
    var hamsters = 5;

    for (int i = 0; i < hamsters; i++) {
      new Hamster(i, jaula).start();
    }
  }
}
