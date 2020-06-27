import java.util.function.Consumer;

public class StubAction implements UserAction {
	private boolean call = false;


	@Override
	public int key() {
		return 0;
	}

	@Override
	public String info() {
		return null;
	}


	@Override
	public String name() {
		return "0. Stub action";
	}

	@Override
	public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
		call = true;
		return false;
	}

	public boolean isCall() {
		return call;
	}
}
