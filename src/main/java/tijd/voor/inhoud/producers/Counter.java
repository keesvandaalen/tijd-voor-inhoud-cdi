package tijd.voor.inhoud.producers;

import java.io.Serializable;

public class Counter implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int count;
	
	public Counter increment()
	{
		count++;
		return this;
	}

	public int getCount() 
	{
		return count;
	}

	public void setCount(int count) 
	{
		this.count = count;
	}
}
