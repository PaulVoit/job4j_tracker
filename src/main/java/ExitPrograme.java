import java.util.function.Consumer;

public class ExitPrograme extends BaseAction {

	protected ExitPrograme(int key, String name) {
		super(key, name);
	}

	@Override
	public String name() {
		return "=== Exit programme ===";
	}

	@Override
	public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
		return false;
	}
}
