package doublyLinkedList;
//Journey Allison
public class Link {
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
	
	public Link getPrev()
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
	
	public Link remove()
	{
		prev.setNext(next);
		return this;
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
