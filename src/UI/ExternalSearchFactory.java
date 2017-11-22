package UI;

public class ExternalSearchFactory {
	
	public ExternalSearch getExternalSearch(String title) {
		
		switch (title) {
		case "RETURN ITEM":
			return new ReturnItem(title);
		case "SERVICE WORKER":
			return new ServiceWorker(title);
		case "CHANGE":
			return new SelectCustomer(title);
		default:
			return null;
	
		}
		
	}
	
}
