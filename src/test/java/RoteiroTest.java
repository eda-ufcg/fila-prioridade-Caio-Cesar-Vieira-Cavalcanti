import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RoteiroTest {
    
    @Test
	public void test() {
		FilaPrioridade heap = new HeapFilaPrioridade(5);
		FilaPrioridade insereFinal = new InsereFinalFilaPrioridade(5);
		FilaPrioridade insertion = new InsereOrdenadoFilaPrioridade(5);
		FilaPrioridade[] estrategias = new FilaPrioridade[3];
		estrategias[0] = heap;
		estrategias[1] = insereFinal;
		estrategias[2] = insertion;


		// 1, 2, 3, 4, 5
		for (FilaPrioridade fila : estrategias) {
			fila.add("a", 1);
			fila.add("b", 2);
			fila.add("c", 3);
			fila.add("d", 4);
			fila.add("e", 5);
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "e");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "d");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "c");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "b");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "a");
		}		

		// 5, 4, 3, 2, 1
		for (FilaPrioridade fila : estrategias) {
			fila.add("a", 5);
			fila.add("b", 4);
			fila.add("c", 3);
			fila.add("d", 2);
			fila.add("e", 1);
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "a");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "b");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "c");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "d");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "e");
		}


		// 7, 2, 1, 9, -1 (valores de prioridade iguais segue fifo)
		for (FilaPrioridade fila : estrategias) {
			fila.add("a", 7);
			fila.add("b", 2);
			fila.add("c", 1);
			fila.add("d", 9);
			fila.add("e", -1);
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "d");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "a");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "b");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "c");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "e");
		}

	}

	@Test
	public void TestHeap(){
		HeapFilaPrioridade heap = new HeapFilaPrioridade(5);

		try{
			heap.removeNext();
			fail("this line cannot execute");
		}catch(RuntimeException r){
			assertEquals("Empty heap", r.getMessage());
		}
			
		heap.add("a", 1);
		heap.add("b", 2);
		heap.add("c", 3);
		heap.add("d", 4);
		heap.add("e", 5);

		assertEquals("e", heap.removeNext());
		assertEquals("d", heap.removeNext());
		assertEquals("c", heap.removeNext());
		assertEquals("b", heap.removeNext());
		assertEquals("a", heap.removeNext());

		//Insering in a different order
		heap.add("a", 0);
		heap.add("b", 5);
		heap.add("c", 1);
		heap.add("d", 3);
		heap.add("e", 2);

		assertEquals("b", heap.removeNext());
		assertEquals("d", heap.removeNext());
		assertEquals("e", heap.removeNext());
		assertEquals("c", heap.removeNext());
		assertEquals("a", heap.removeNext());

		//Checking resize
		heap.add("a", 1);
		heap.add("b", 2);
		heap.add("c", 3);
		heap.add("d", 4);
		heap.add("e", 5);
		heap.add("f", 6);
		heap.add("g", 7);

		assertEquals("g", heap.removeNext());
		assertEquals("f", heap.removeNext());
		assertEquals("e", heap.removeNext());
		assertEquals("d", heap.removeNext());
		assertEquals("c", heap.removeNext());
		assertEquals("b", heap.removeNext());
		assertEquals("a", heap.removeNext());
	}

	@Test
	public void TestInsereFinal(){
		InsereFinalFilaPrioridade fila = new InsereFinalFilaPrioridade(5);
			
		fila.add("a", 1);
		fila.add("b", 2);
		fila.add("c", 3);
		fila.add("d", 4);
		fila.add("e", 5);

		assertEquals("e", fila.removeNext());
		assertEquals("d", fila.removeNext());
		assertEquals("c", fila.removeNext());
		assertEquals("b", fila.removeNext());
		assertEquals("a", fila.removeNext());

		//Insering in a different order
		fila.add("a", 0);
		fila.add("b", 5);
		fila.add("c", 1);
		fila.add("d", 3);
		fila.add("e", 2);

		assertEquals("b", fila.removeNext());
		assertEquals("d", fila.removeNext());
		assertEquals("e", fila.removeNext());
		assertEquals("c", fila.removeNext());
		assertEquals("a", fila.removeNext());

	}

	@Test
	public void TestInsereOrdenado(){
		InsereOrdenadoFilaPrioridade fila = new InsereOrdenadoFilaPrioridade(5);
			
		fila.add("a", 1);
		fila.add("b", 2);
		fila.add("c", 3);
		fila.add("d", 4);
		fila.add("e", 5);

		assertEquals("e", fila.removeNext());
		assertEquals("d", fila.removeNext());
		assertEquals("c", fila.removeNext());
		assertEquals("b", fila.removeNext());
		assertEquals("a", fila.removeNext());

		//Insering in a different order
		fila.add("a", 0);
		fila.add("b", 5);
		fila.add("c", 1);
		fila.add("d", 3);
		fila.add("e", 2);

		assertEquals("b", fila.removeNext());
		assertEquals("d", fila.removeNext());
		assertEquals("e", fila.removeNext());
		assertEquals("c", fila.removeNext());
		assertEquals("a", fila.removeNext());

		//Checking resize
		fila.add("a", 1);
		fila.add("b", 2);
		fila.add("c", 3);
		fila.add("d", 4);
		fila.add("e", 5);
		fila.add("f", 6);
		fila.add("g", 7);
		
		assertEquals(7, fila.size());
		
		assertEquals("g", fila.removeNext());
		assertEquals("f", fila.removeNext());
		assertEquals("e", fila.removeNext());
		assertEquals("d", fila.removeNext());
		assertEquals("c", fila.removeNext());
		assertEquals("b", fila.removeNext());
		assertEquals("a", fila.removeNext());

		// Head and Tail tests (resize test)
		fila = new InsereOrdenadoFilaPrioridade(5);
		
		fila.add("a", 1);
		fila.add("b", 2);
		fila.add("c", 3);
		fila.add("d", 4);
		fila.add("e", 5);

		assertTrue(fila.isFull());
		
		assertEquals("e", fila.removeNext());

		fila.add("f", 1);

		assertTrue(fila.isFull());

		fila.add("g", 1);

		assertEquals("d", fila.removeNext());
	}
}