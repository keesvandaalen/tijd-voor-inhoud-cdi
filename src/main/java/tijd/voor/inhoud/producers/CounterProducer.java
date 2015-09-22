package tijd.voor.inhoud.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class CounterProducer 
{
	private Counter applicationScopedCounter;
	
	private Counter requestScopedCounter;
	
	private Counter dependentCounter;
	
	public CounterProducer() 
	{
		applicationScopedCounter = new Counter();
		requestScopedCounter = new Counter();
		dependentCounter = new Counter();
	}
	
	@Produces 
	@CounterScope(Scope.Application)
	@ApplicationScoped
	public Counter produceApplicationScopedCounter()
	{
		return applicationScopedCounter.increment();
	}
	
	@Produces 
	@CounterScope(Scope.Request) 
	@RequestScoped
	public Counter produceRequestScopedCounter()
	{
		return requestScopedCounter.increment();
	}
	
	@Produces
	@CounterScope(Scope.Dependent)
	public Counter produceDependendScopedCounter()
	{
		return dependentCounter.increment();
	}
}
