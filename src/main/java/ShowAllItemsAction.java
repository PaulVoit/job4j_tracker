

import model.Item;

import java.util.List;
import java.util.function.Consumer;

public class ShowAllItemsAction extends BaseAction {
	public ShowAllItemsAction(int key, String name) {
		super(key, name);
	}

	@Override
	public String name() {
		return "=== Show all Items ====";
	}

	@Override
	public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
		List<Item> allItems = tracker.findAll();
		for (Item allItem : allItems) {
			output.accept(allItem.getId() + " " + allItem.getName());
		}
		return true;
	}
}
