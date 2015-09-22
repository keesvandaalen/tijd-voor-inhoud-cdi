package tijd.voor.inhoud;

import javax.inject.Inject;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

import tijd.voor.inhoud.producers.Counter;
import tijd.voor.inhoud.producers.CounterScope;
import tijd.voor.inhoud.producers.Scope;

class DependentScopedCounterLabel extends Label
{
	private static final long serialVersionUID = 1L;

	@Inject @CounterScope(Scope.Dependent)
	private Counter counter;
	
	public DependentScopedCounterLabel(String id) 
	{
		super(id);
	}
	
	@Override
	protected void onInitialize() 
	{
		super.onInitialize();
		setDefaultModel(Model.of(counter.getCount()));
	}
}