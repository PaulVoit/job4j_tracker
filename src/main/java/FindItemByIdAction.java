

import model.Item;

import java.util.function.Consumer;

public class FindItemByIdAction extends BaseAction {
	public FindItemByIdAction(int key, String name) {
		super(key, name);
	}

	@Override
	public String name() {
		return "=== Find Item by Id ====";
	}

	@Override
	public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
		output.accept("Enter Item Id: ");
		String id = input.askStr("");
		Item item = tracker.findById(id);
		if (item != null) {
			output.accept("Item ID " + item.getId());
			output.accept("Item Name " + item.getName());
		}
		return true;
	}
}
