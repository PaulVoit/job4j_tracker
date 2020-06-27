

import model.Item;

import java.util.function.Consumer;

public class ReplaceAction extends BaseAction {

	public ReplaceAction(int key, String name) {
		super(key, name);
	}

	@Override
	public String name() {
		return "=== Edit Item ====";
	}

	@Override
	public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
		output.accept("Enter Item id: ");
		String id = input.askStr("");
		output.accept("Enter New Item Name: ");
		String name = input.askStr("");
		Item item2 = new Item(name);
		if (tracker.replace(id, item2)) {
			output.accept("Item: " + id + " replaced");
		} else {
			output.accept("Item with ID: " + id + " doesn't exist");
		}
		return true;
	}
}
