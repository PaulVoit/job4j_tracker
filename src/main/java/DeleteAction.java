import java.util.function.Consumer;

public class DeleteAction extends BaseAction {
	public DeleteAction(int key, String name) {
		super(key, name);
	}

	@Override
	public String name() {
		return "=== Delete Item ====";
	}

	@Override
	public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
		output.accept("Enter Item id: ");
		String id = input.askStr("");
		if (tracker.delete(id)) {
			output.accept("Item " + id + "deleted");
		}
		return true;
	}
}
