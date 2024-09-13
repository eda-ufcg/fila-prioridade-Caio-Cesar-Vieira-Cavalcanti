public class HeapFilaPrioridade implements FilaPrioridade {

  private Heap heap;

  public HeapFilaPrioridade(int capacidade) {
    this.heap = new Heap(capacidade);
  }

  // adicionar o pair no heap
  public void add(String elemento, int prioridade) {
    Pair newPair = new Pair(elemento, prioridade);
    this.heap.add(newPair);
  }

  // recuperar a raiz
  public String removeNext() {
    return this.heap.remove();
  }

}
