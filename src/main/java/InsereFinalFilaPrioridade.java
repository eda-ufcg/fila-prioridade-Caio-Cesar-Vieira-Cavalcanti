import java.util.ArrayList;
import java.util.NoSuchElementException;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

  private ArrayList<Pair> fila;

  public InsereFinalFilaPrioridade(int capacidade) {
    this.fila = new ArrayList<Pair>(capacidade);
  }

  // criar um Pair e adicionar no fim da fila
  public void add(String elemento, int prioridade) {
    Pair newPair = new Pair(elemento, prioridade);
    this.fila.add(newPair);
  }

  // buscar pelo elemento de maior prioridade na fila.
  public String removeNext() {
    if (this.fila.isEmpty())
      throw new NoSuchElementException();

    Pair maxPair = this.fila.get(0);
    int indexRemove = 0;
    int end = this.fila.size();

    for (int i = 1; i < end; i++) {
      Pair currentPair = this.fila.get(i);
      if (currentPair.getPrioridade() > maxPair.getPrioridade()) {
        maxPair = currentPair;
        indexRemove = i;
      }
    }

    this.fila.remove(indexRemove);

    return maxPair.getElemento();
  }

}
