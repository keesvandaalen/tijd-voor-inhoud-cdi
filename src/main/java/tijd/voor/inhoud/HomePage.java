package tijd.voor.inhoud;

import java.util.Arrays;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import tijd.voor.inhoud.producers.Counter;

public class HomePage extends WebPage 
{
	private static final long serialVersionUID = 1L;
	
	public HomePage(final PageParameters parameters) 
	{
		super(parameters);
    }
	
	@Override
	protected void onInitialize() 
	{
		super.onInitialize();
		
		add(new ListView<AbstractCounterLabel>("demo1", Arrays.asList(new ApplicationScopedCounterLabel("scope_counter"), 
				new RequestScopedCounterLabel("scope_counter"))) 
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<AbstractCounterLabel> item) 
			{
				Label scopeLabel = new Label("scope", item.getModelObject().getLabel());
				Component scopeCounterLabel = item.getModelObject().setOutputMarkupId(true);
				Counter clicks = new Counter();
				Component clickLabel = new Label("clicks", new PropertyModel<>(clicks, "count"))
					.setOutputMarkupId(true);
				item.add(scopeLabel, scopeCounterLabel, clickLabel, new AjaxFallbackLink<Void>("link") 
				{
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick(AjaxRequestTarget target) 
					{
						clicks.increment();
						target.add(scopeCounterLabel, clickLabel);
					}
				});
			}
		}, new ListView<Integer>("demo2", Arrays.asList(1,2,3)) 
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Integer> item) 
			{
				item.add(new Label("num", item.getModel()), 
						new RequestScopedCounterLabel("request"), 
						new DependentScopedCounterLabel("dependent"));
			}
		});
	}
}
