package tijd.voor.inhoud;

import javax.inject.Inject;

import tijd.voor.inhoud.producers.Counter;
import tijd.voor.inhoud.producers.CounterScope;
import tijd.voor.inhoud.producers.Scope;

class RequestScopedCounterLabel extends AbstractCounterLabel
{
	private static final long serialVersionUID = 1L;

	public RequestScopedCounterLabel(String id) 
	{
		super(id);
	}
	
	@Override
	@Inject
	void setCounter(@CounterScope(Scope.Request) Counter counter) 
	{
		super.setCounter(counter);
	}
	
	String getLabel() 
	{
		return "RequestScoped";
	}
}