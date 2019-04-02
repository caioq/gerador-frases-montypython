package challenge;

public class Quote {

	private String actor;

	private String quote;

	public Quote() {
	}

	public Quote(String actor, String quote) {
		this.actor = actor;
		this.quote = quote;
	}

	public String getActor() {
		return actor;
	}

	public String getQuote() {
		return quote;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}


	public String toJsonString() {
		return "{" +
				"\"actor\":\"" + actor + '\"' +
				", \"quote\":\"" + quote + '\"' +
				'}';
	}
}
