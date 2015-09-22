package tijd.voor.inhoud;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
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
		
		ApplicationScopedCounterLabel app = new ApplicationScopedCounterLabel("app_counter");
		app.setOutputMarkupId(true);
		add(app);
		Counter appClicks = new Counter();
		Label appClickLabel = new Label("app_clicks", new PropertyModel<>(appClicks, "count"));
		appClickLabel.setOutputMarkupId(true);
		add(appClickLabel);
		add(new AjaxFallbackLink<Void>("app_link") 
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) 
			{
				appClicks.increment();
				target.add(app, appClickLabel);
			}
		});
		
		RequestScopedCounterLabel req = new RequestScopedCounterLabel("req_counter");
		req.setOutputMarkupId(true);
		add(req);
		Counter reqClicks = new Counter();
		Label reqClickLabel = new Label("req_clicks", new PropertyModel<>(reqClicks, "count"));
		reqClickLabel.setOutputMarkupId(true);
		add(reqClickLabel);
		add(new AjaxFallbackLink<Void>("req_link") 
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) 
			{
				reqClicks.increment();
				target.add(req, reqClickLabel);
			}
		});
	}
}
