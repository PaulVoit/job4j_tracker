

import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class StartUI implements UserAction {

	private final Input input;
	private final Tracker tracker;
	private ExitAction exitAction = new ExitAction(this);
	private final Consumer<String> output;

	public StartUI(Input input, Tracker tracker, Consumer<String> output) {
		this.input = input;
		this.tracker = tracker;
		this.output = output;
	}

	public void init(Input input, Tracker tracker, ArrayList<UserAction> actions, Consumer<String> output) {
		boolean run = true;
		while (run) {
			this.showMenu(actions, output);
			int select = input.askInt("Select: ", actions.size());
			UserAction action = actions.get(select);
		//	exitAction.exit(input, tracker, output);
			run = action.execute(input, tracker, output);

		}
	}

	private void showMenu(ArrayList<UserAction> actions, Consumer<String> output) {
		output.accept("Menu.");
		for (UserAction i : actions) {
			output.accept(i.name());
		}
	}

	public static void createItem(Input input, Tracker tracker) {
		System.out.println("=== Create a new Item ====");
		System.out.print("Enter name: ");
		String name = input.askStr("");
		Item item = new Item(name);
		tracker.add(item);
	}

	public static void showAllItems(Tracker tracker) {
		System.out.print("=== Show all Items ====");
		List<Item> allItems = tracker.findAll();
		for (Item allItem : allItems) {
			System.out.println("Name: " + allItem.getName());
		}
	}

	public static void replaceItem(Input input, Tracker tracker) {
		System.out.print("=== Edit Item ====");
		System.out.print("Enter Item id: ");
		String id = input.askStr("");
		System.out.print("Enter New Item Name: ");
		String name = input.askStr("");
		Item item2 = new Item(name);
		if (tracker.replace(id, item2)) {
			System.out.println("Item: " + id + " replaced");
		} else {
			System.out.println("Item with ID: " + id + " doesn't exist");
		}
	}

	public static void deleteItem(Input input, Tracker tracker) {
		System.out.println("=== Delete Item ====");
		System.out.print("Enter Item id: ");
		String id = input.askStr("");
		if (tracker.delete(id)) {
			System.out.println("Item " + id + "deleted");
		}
	}

	public static void findItemById(Input input, Tracker tracker) {
		System.out.println("=== Find Item by Id ====");
		System.out.print("Enter Item Id: ");
		String id = input.askStr("");
		Item item = tracker.findById(id);
		if (item != null) {
			System.out.println("Item ID " + item.getId());
			System.out.println("Item Name " + item.getName());
		}
	}

	public static void findItemByName(Input input, Tracker tracker) {
		System.out.println("=== Find Item by Name ====");
		System.out.print("Enter name: ");
		String name = input.askStr("");
		List<Item> items = tracker.findByName(name);
		for (Item item : items) {
			System.out.println("Item ID " + item.getId());
			System.out.println("Item Name " + item.getName());
		}
	}

	public static void main(String[] args) {
		Input input = new ConsoleInput();
		Input validate = new ValidateInput(input);
		Tracker tracker = new Tracker();
		ArrayList<UserAction> actions = new ArrayList<>();
		actions.add(new CreateAction(0, "Create new Item"));
		actions.add(new ShowAllItemsAction(1, "Show all Items"));
		actions.add(new ReplaceAction(2, "Edit Item"));
		actions.add(new DeleteAction(3, "Delete Item"));
		actions.add(new FindItemByIdAction(4, "Find Item by ID"));
		actions.add(new FindItemByNameAction(5, "Find Item by Name"));
		actions.add(new ExitPrograme(6, "Exit programme"));
		new StartUI(new StubInput(new String[]{"6"}), new Tracker(), System.out::println)
				.init(validate, tracker, actions, System.out::println);
	}


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
		return null;
	}

	@Override
	public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
		System.out.println("Вызов метода обратного вызова");
		return false;
	}
}
