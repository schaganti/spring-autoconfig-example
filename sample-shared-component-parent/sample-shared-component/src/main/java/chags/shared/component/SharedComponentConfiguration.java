package chags.shared.component;

public class SharedComponentConfiguration {

	String url;
	String port;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "SharedComponentConfiguration [url=" + url + ", port=" + port + "]";
	}
	

}
