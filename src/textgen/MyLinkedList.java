package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 *
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>();
		head.next = tail;
		tail = new LLNode<E>();
		tail.prev = head;		
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	@Override
	public boolean add(E element )
	{
		// TODO: Implement this method
		LLNode<E> n = new LLNode<E>(element); 
		n.prev = tail.prev;
		n.next = tail;
		tail.prev.next = n;
		tail.prev = n;
		size++;
		
		
		return false;
	}

	/** Get the element at position index
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	@Override
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method.
		if(index >= this.size || index < 0 )
		{
			throw new IndexOutOfBoundsException("Out of bounds index!");
		}
		LLNode<E> find = head.next;
		for(int x = 0; x<index; x++)
		{
			find = find.next;
		}
		return find.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	@Override
	public void add(int index, E element )
	{
		// TODO: Implement this method
		if(index > this.size || index < 0 )
		{
			throw new IndexOutOfBoundsException("Out of bounds index!");
		}
		if(element == null)
		{
			throw new NullPointerException("Null Element");
		}
		
		LLNode<E> n = new LLNode<E>(element);
		
		if(size == 0)
		{
			n.prev = tail.prev;
			n.next = tail;
			tail.prev.next = n;
			tail.prev = n;
			size++;
		}
		else
		{
			if(index == 0)
			{
				n.next = head.next;
				n.prev = head;
				head.next.prev = n;		
				head.next = n;
				size++;
			}
			
			else if(index == size)
			{
				n.prev = tail.prev;
				n.next = tail;
				tail.prev.next = n;
				tail.prev = n;
				size++;
			}
			
			else
			{
				LLNode<E> c = head.next;
				for(int x =0; x<index; x++)
				{
					c = c.next;
				}
				n.next = c;
				n.prev = c.prev;
				c.prev.next = n;
				c.prev = n;
			}
			size++;
			
			
		}
		
	}


	/** Return the size of the list */
	@Override
	public int size()
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 *
	 */
	@Override
	public E remove(int index)
	{
		// TODO: Implement this method
		if(index >= this.size || index < 0 )
		{
			throw new IndexOutOfBoundsException("Out of bounds index!");
		}
		
		LLNode<E> r = head.next;
		if(index == 0)
		{
			head.next = head.next.next;
			head.next.prev = head;
			r.next = null;
			r.prev = null;
			size--;
		}
		else if (index == size)
		{
			r = tail.prev;
			r.prev.next = tail;
			tail.prev = r.prev;
			r.prev = null;
			r.next = null;
			size--;			
		}
		else
		{
			for(int x = 0; x<index; x++)
			{
				r = r.next;
			}
			r.prev.next = r.next;
			r.next.prev = r.prev;
			r.next = null;
			r.prev = null;
			size--;
		}
		
		
		return r.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	@Override
	public E set(int index, E element)
	{
		// TODO: Implement this method
		if(index > this.size || index < 0 )
		{
			throw new IndexOutOfBoundsException("Out of bounds index!");
		}
		
		if(element == null)
		{
			throw new NullPointerException("Null Element");
		}
		add(index,element);
		if(size == 0)
		
		{
		return remove(index);
		
		}
		else if(index == size)
		{
			return remove(index);
		}
		else
		 return null;
		}
}

class LLNode<E>
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	 public LLNode(){
         this.data = null;
         this.prev = null;
         this.next = null;
     }
	 
	public LLNode(E e)
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
