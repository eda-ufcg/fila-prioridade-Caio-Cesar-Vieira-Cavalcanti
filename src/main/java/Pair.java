public class Pair {

  private String elemento;
  private int prioridade;

  public Pair(String elemento, int prioridade) {
    this.elemento = elemento;
    this.prioridade = prioridade;
  }

  public String getElemento() {
    return elemento;
  }

  public int getPrioridade() {
    return this.prioridade;
  }

  public String toString() {
    return "<" + this.elemento + ", " + String.valueOf(this.prioridade) + ">";
  }
}
