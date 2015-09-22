package tijd.voor.inhoud;

import javax.inject.Inject;


import tijd.voor.inhoud.producers.Counter;
import tijd.voor.inhoud.producers.CounterScope;
import tijd.voor.inhoud.producers.Scope;

class ApplicationScopedCounterLabel extends AbstractCounterLabel
{
	private static final long serialVersionUID = 1L;

	public ApplicationScopedCounterLabel(String id) 
	{
		super(id);
	}
	
	@Override
	@Inject
	void setCounter(@CounterScope(Scope.Application) Counter counter) 
	{
		super.setCounter(counter);
	}
	
	@Override
	String getLabel() 
	{
		return "ApplicationScoped";
	}
}