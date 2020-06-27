

import model.Item;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class ShowAllItemsActionTest {

	@Test
	public void whenCheckOutput() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream def = System.out;
		System.setOut(new PrintStream(out));
		Tracker tracker = new Tracker();
		Item item = new Item("fix bug");
		tracker.add(item);
		ShowAllItemsAction act = new ShowAllItemsAction(1, "Show all Items");
		act.execute(new StubInput(new String[]{}), tracker, System.out::println);
		String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
				.add(item.getId() + " " + item.getName())
				.toString();
		assertThat(new String(out.toByteArray()), is(expect));
		System.setOut(def);
	}


}


