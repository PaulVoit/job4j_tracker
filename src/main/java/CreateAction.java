

import model.Item;

import java.util.function.Consumer;

public class CreateAction extends BaseAction {
	public CreateAction(int key, String name) {
		super(key, name);
	}

	@Override
	public String name() {
		return "=== Create a new Item ====";
	}

	@Override
	public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
		output.accept("Enter name: ");
		String name = input.askStr("");
		Item item = new Item(name);
		tracker.add(item);
		return true;
	}
}
