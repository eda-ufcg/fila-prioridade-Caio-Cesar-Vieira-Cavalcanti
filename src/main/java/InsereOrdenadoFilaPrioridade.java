import java.util.NoSuchElementException;

public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

  private Pair[] fila;
  private int head;
  private int last;

  public InsereOrdenadoFilaPrioridade(int capacidade) {
    this.fila = new Pair[capacidade];
    this.last = -1;
    this.head = -1;
  }

  public boolean isEmpty() {
    return this.head == -1 && this.last == -1;
  }

  public boolean isFull() {
    return (this.last + 1) % this.fila.length == this.head;
  }

  // criar um Pair e inserir de forma ordenada decrescente no array.
  public void add(String elemento, int prioridade) {
    if (isFull())
      resize();

    if (isEmpty())
      this.head = 0;

    Pair newPair = new Pair(elemento, prioridade);

    this.last = (this.last + 1) % this.fila.length;
    this.fila[this.last] = newPair;

    int index = this.last;
    while (index > 0 && this.fila[index].getPrioridade() > this.fila[index - 1].getPrioridade()) {
      swap(index, index - 1);
      index -= 1;
    }
  }

  // remover e retornar o primeiro elemento do array, que é o de maior prioridade.
  // lembrar manipular head e tail
  // para ser uma fila circular. assim a remoção fica O(1)
  public String removeNext() {
    if (isEmpty())
      throw new NoSuchElementException();

    String element = this.fila[this.head].getElemento();

    if (this.head == this.last) {
      this.head = -1;
      this.last = -1;
    } else {
      this.head = (this.head + 1) % this.fila.length;
    }

    return element;
  }

  private void swap(int i, int j) {
    Pair auxPair = this.fila[i];
    this.fila[i] = this.fila[j];
    this.fila[j] = auxPair;
  }

  private void resize() {
    Pair[] newFila = new Pair[this.fila.length * 2];
    for (int i = 0; i < this.fila.length; i++) {
      newFila[i] = this.fila[i];
    }

    this.fila = newFila;
  }
}
