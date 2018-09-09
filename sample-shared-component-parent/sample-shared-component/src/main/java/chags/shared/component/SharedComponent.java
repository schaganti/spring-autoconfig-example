package chags.shared.component;

public class SharedComponent {

	SharedComponentConfiguration config;

	public SharedComponent(SharedComponentConfiguration config) {
		this.config = config;
	}

	public String printConfig() {
		return "Hi, I am "+ this.getClass().getName() +" initialized with " + this.config;
	}
}
