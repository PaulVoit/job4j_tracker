

import model.Item;

import java.util.List;
import java.util.function.Consumer;

public class FindItemByNameAction extends BaseAction {
	public FindItemByNameAction(int key, String name) {
		super(key, name);
	}

	@Override
	public String name() {
		return "=== Find Item by Name ====";
	}

	@Override
	public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
		output.accept("Enter name: ");
		String name = input.askStr("");
		List<Item> items = tracker.findByName(name);
		for (Item item : items) {
			output.accept("Item ID " + item.getId());
			output.accept("Item Name " + item.getName());
		}
		return true;
	}
}
