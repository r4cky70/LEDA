package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new CircularQueue<>(4);
		queue2 = new CircularQueue<>(2);
		queue3 = new CircularQueue<>(8);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));

		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue1.enqueue(new Integer(5));
		queue1.enqueue(new Integer(5));
		queue1.enqueue(new Integer(5));
		queue1.enqueue(new Integer(5));
		queue1.enqueue(new Integer(5));
		queue1.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		queue1.dequeue();
		queue1.dequeue();
		queue1.dequeue();
		queue1.dequeue();
		assertEquals(new Integer(1), queue1.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}
	@Test
	public void notUselessTest() {
		try{
			queue3.enqueue(new Integer(2));
			queue3.enqueue(new Integer(4));
			queue3.enqueue(new Integer(5));
			queue3.enqueue(new Integer(1));
			queue3.enqueue(new Integer(6));
			queue3.enqueue(new Integer(3));
			queue3.enqueue(new Integer(2));
			queue3.enqueue(new Integer(7));
		}catch (QueueOverflowException e){
			e.printStackTrace();
		}
		try{
			queue3.enqueue(new Integer(2));
		}catch (QueueOverflowException e){
			System.out.println("caraiooooo");
			e.printStackTrace();
		}

		try{
			assertEquals(new Integer(2), queue3.dequeue());
			assertEquals(new Integer(4), queue3.dequeue());
		} catch (QueueUnderflowException e){
			e.printStackTrace();
		}
		// 5 1 6 3 2 7
		
		try{
			queue3.enqueue(new Integer(1));
		} catch (QueueOverflowException e){
			System.out.println("yo");
			e.printStackTrace();
		}
		System.out.println(queue3.head());
		assertEquals(queue3.head(), new Integer(1));
	}
}