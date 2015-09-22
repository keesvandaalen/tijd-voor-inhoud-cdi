package tijd.voor.inhoud;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

import tijd.voor.inhoud.producers.Counter;

abstract class AbstractCounterLabel extends Label
{
	private static final long serialVersionUID = 1L;

	private Counter counter;
	
	public AbstractCounterLabel(String id) 
	{
		super(id);
	}
	
	void setCounter(Counter counter)
	{
		this.counter = counter;
	}
	
	abstract String getLabel();
	
	@Override
	protected void onInitialize() 
	{
		super.onInitialize();
		setDefaultModel(new PropertyModel<>(counter, "count"));
	}
}