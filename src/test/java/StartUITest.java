import model.Item;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class StartUITest {
	@Test
	public void whenAddItem() {
		String[] answers = {"Fix PC"};
		Input input = new StubInput(answers);
		Tracker tracker = new Tracker();
		StartUI.createItem(input, tracker);
		Item created = tracker.findAll().get(0);
		Item expected = new Item("Fix PC");
		assertThat(created.getName(), is(expected.getName()));
	}

	@Test
	public void whenReplaceItem() {
		Tracker tracker = new Tracker();
		Item item = new Item("new item");
		tracker.add(item);
		String[] answers = {
				item.getId(),
				"replaced item"
		};
		StartUI.replaceItem(new StubInput(answers), tracker);
		Item replaced = tracker.findById(item.getId());
		assertThat(replaced.getName(), is("replaced item"));
	}

	@Test
	public void whenDeleteItem() {
		Tracker tracker = new Tracker();
		Item item = new Item("new item");
		tracker.add(item);
		String[] answers = {item.getId()};

		StartUI.deleteItem(new StubInput(answers), tracker);
		List<Item> result = tracker.findAll();
		Item[] expected = {};
		assertThat(result.toArray(), is(expected));
	}


	@Test

	public void whenPrtMenu() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream def = System.out;
		System.setOut(new PrintStream(out));
		ArrayList<UserAction> action = new ArrayList<>();
		action.add(new StubAction());
		StubInput input = new StubInput(
				new String[]{"0"}
		);
		new StartUI(new StubInput(new String[]{"6"}), new Tracker(), System.out::println)
				.init(input, new Tracker(), action, System.out::println);
		String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
				.add("Menu.")
				.add("0. Stub action")
				.toString();
		assertThat(new String(out.toByteArray()), is(expect));
		System.setOut(def);
	}


}
