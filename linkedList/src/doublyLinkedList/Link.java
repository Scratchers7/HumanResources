package doublyLinkedList;
//Journey Allison
public class Link implements DoublyLinkedSortedListInterface{
	private Object data;
	private Link prev;
	private Link next;
	
	public Link(Object d)
	{
		data = d;
		prev = next = null;
	}
	
	public Link()
	{
		data = null;
		prev = next = null;
	}
	
	public Object getValue()
	{
		return data;
	}
	
	public void setNext(Link next)
	{
		this.next = next;
		next.setPreviousSingle(this);
	}
	
	public void setNextSingle(Link next)
	{
		this.next = next;
	}
	
	public void setPrevious(Link prev)
	{
		this.prev = prev;
		prev.setNextSingle(this);
	}
	
	public void setPreviousSingle(Link prev)
	{
		this.prev = prev;
	}
	
	public Link getNext()
	{
		return next;
	}
	public boolean hasNext()
	{
		return this.next !=null;
	}
	
	public boolean hasPrevious()
	{
		return this.prev !=null;
	}
	public Link getPrevious()
	{
		return prev;
	}
	
	public Link getFirst()
	{
		if(prev == null)
		{
			return this;
		}
		else
		{
			return this.prev.getFirst();
		}
	}
	
	public Link removeThis()
	{
		prev.setNext(next);
		return this;
	}
	
	public void insert(Object newValue)
	{
		getFirst().insertLoop(newValue);
	}
	
	protected void insertLoop(Object newValue)
	{
		HurricaneRowData newVal = (HurricaneRowData) newValue;
		if(newVal.compareTo((HurricaneRowData)this.getValue()) == 1)
		{
			next.insert(newValue);
		}
		else if(newVal.compareTo((HurricaneRowData)this.getValue()) == -1)
		{
			this.setPrevious(new Link(newVal));
		}
		else
		{
			this.setPrevious(new Link(newVal));
		}
	}
	
	public Link remove(Object toRemove)
	{
		return getFirst().removeLoop(toRemove);
	}
	
	protected Link removeLoop(Object toRemove)
	{
		if(this.getValue().equals(toRemove))
		{
			return this.removeThis();
		}
		else
		{
			return next.remove(toRemove);
		}
	}
	
	public Link getLast()
	{
		if(next == null)
		{
			return this;
		}
		else
		{
			return this.next.getLast();
		}
	}
	
	public void addFirst(Object data)
	{
		Link temp = new Link(data);
		getFirst().setPrevious(temp);
	}
	
	public void addLast(Object data)
	{
		Link temp  = new Link(data);
		getLast().setNext(temp);
	}
	
	
}
