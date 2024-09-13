public interface FilaPrioridade {

  /**
   * Adiciona um elemento na fila com a prioridade passada como parâmetro.
   */
  public void add(String elemento, int prioridade);

  /**
   * Remove o elemento de maior prioridade da fila.
   */
  public String removeNext();

}
