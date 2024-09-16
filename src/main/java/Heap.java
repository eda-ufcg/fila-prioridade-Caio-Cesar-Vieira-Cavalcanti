import java.util.Arrays;

public class Heap {

  private Pair[] heap;
  private int tail;

  public Heap(int capacidade) {
    this.heap = new Pair[capacidade];
    this.tail = -1;
  }

  public Heap(Pair[] heap) {
    this.heap = heap;
    this.tail = this.heap.length - 1;
    this.buildHeap();
  }

  private void buildHeap() {
    for (int i = parent(this.tail); i >= 0; i--)
      heapify(i);
  }

  public boolean isEmpty() {
    return this.tail == -1;
  }

  public int left(int i) {
    return 2 * i + 1;
  }

  public int right(int i) {
    return (i + 1) * 2;
  }

  public int parent(int i) {
    return (i - 1) / 2;
  }

  public void add(Pair n) {
    if (tail >= (heap.length - 1))
      resize();

    this.tail += 1;
    this.heap[tail] = n;

    int i = tail;
    while (i > 0 && this.heap[parent(i)].getPrioridade() < this.heap[i].getPrioridade()) {
      swap(i, parent(i));

      i = parent(i);
    }
  }

  public String remove() {
    if (isEmpty())
      throw new RuntimeException("Empty heap");
    String element = this.heap[0].getElemento();
    this.heap[0] = this.heap[tail];
    this.tail -= 1;

    this.heapify(0);

    return element;
  }

  private void heapify(int index) {
    if (isLeaf(index) || !isValidIndex(index))
      return;

    // compares index, left and right to find max
    int index_max = max_index(index, left(index), right(index));

    // if current index is not greater than its children,
    // swap and keep heapifying.
    if (index_max != index) {
      swap(index, index_max);
      heapify(index_max);
    }
  }

  private int max_index(int index, int left, int right) {
    if (this.heap[index].getPrioridade() > this.heap[left].getPrioridade()) {
      if (isValidIndex(right)) {
        if (this.heap[index].getPrioridade() < this.heap[right].getPrioridade())
          return right;
      }
      return index;

    } else {
      if (isValidIndex(right)) {
        if (this.heap[left].getPrioridade() < this.heap[right].getPrioridade())
          return right;
      }

      return left;
    }
  }

  private boolean isValidIndex(int index) {
    return index >= 0 && index <= tail;
  }

  private boolean isLeaf(int index) {
    return index > parent(tail) && index <= tail;
  }

  private void swap(int i, int j) {
    Pair aux = this.heap[i];
    this.heap[i] = this.heap[j];
    this.heap[j] = aux;
  }

  private void resize() {
    Pair[] novoHeap = new Pair[this.heap.length * 2];
    for (int i = 0; i <= tail; i++)
      novoHeap[i] = this.heap[i];

    this.heap = novoHeap;
  }

  public int size() {
    return this.tail + 1;
  }

  public String toString() {
    return Arrays.toString(this.heap);
  }

}
