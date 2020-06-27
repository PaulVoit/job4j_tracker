import model.Item;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class TrackerTest {

	@Test
	public void whenAddNewItemThenTrackerHasSameItem() {
		Tracker tracker = new Tracker();
		Item item = new Item("test1");
		tracker.add(item);
		Item result = tracker.findById(item.getId());
		assertThat(result.getName(), is(item.getName()));
	}

	@Test
	public void whenItemIdEqualsOurId() {
		Tracker tracker = new Tracker();
		Item item = new Item("test1");
		tracker.add(item);
		Item result = tracker.findById(item.getId());
		assertThat(result.getId(), is(item.getId()));
	}

	@Test
	public void whenFindAllItemsWithoutNull() {
		Tracker tracker = new Tracker();
		Item item = new Item("test1");
		Item item1 = new Item("test2");
		tracker.add(item);
		tracker.add(item1);
		List<Item> result = tracker.findAll();
		assertThat(result.size(), is(2));
	}

	@Test
	public void whenItemDeleted() {
		Tracker tracker = new Tracker();
		Item item = new Item("test1");
		Item item1 = new Item("test2");
		tracker.add(item);
		tracker.add(item1);
		tracker.delete(item.getId());
		List<Item> result = tracker.findAll();
		assertThat(result.get(0), is(item1));
	}

	@Test
	public void whenReplaceNameThenReturnNewName() {
		Tracker tracker = new Tracker();
		Item previous = new Item("test1");
		tracker.add(previous);
		Item next = new Item("test2");
		next.setId(previous.getId());
		tracker.replace(previous.getId(), next);
		assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
	}

	@Test
	public void whenFindByName() {
		Tracker tracker = new Tracker();
		Item first = new Item("test1");
		tracker.add(first);
		ArrayList <Item> expected = new ArrayList<Item>();
		expected.add(first);
		assertThat(tracker.findByName(first.getName()), is(expected));
	}
}