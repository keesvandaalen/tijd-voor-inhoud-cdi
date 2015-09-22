package tijd.voor.inhoud;

import javax.inject.Inject;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

import tijd.voor.inhoud.producers.Counter;
import tijd.voor.inhoud.producers.CounterScope;
import tijd.voor.inhoud.producers.Scope;

class RequestScopedCounterLabel extends Label
{
	private static final long serialVersionUID = 1L;

	@Inject @CounterScope(Scope.Request)
	private Counter counter;
	
	public RequestScopedCounterLabel(String id) 
	{
		super(id);
	}
	
	@Override
	protected void onInitialize() 
	{
		super.onInitialize();
		setDefaultModel(new PropertyModel<>(counter, "count"));
	}
}