

import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {

	private final List<Item> items = new ArrayList<>();


	public Item add(Item item) {
		item.setId(this.generateId());
		this.items.add(item);
		return item;
	}

	public boolean replace(String id, Item item) {
		boolean result = false;
		item.setId(id);
		int count = 0;
		for (Item i : items) {
			if (i.getId().equals(id)) {
				this.items.set(count, item);
				result = true;
				break;
			}
			count++;
		}
		return result;
	}

	public boolean delete(String id) {
		boolean result = false;
		int count = 0;
		for (Item item : items) {
			if (item.getId().contains(id)) {
				items.remove(count);
				result = true;
				break;
			}
			count++;
		}
		return result;
	}

	public List<Item> findAll() {
		return this.items;
	}

	public ArrayList<Item> findByName(String key) {
		ArrayList<Item> result = new ArrayList<>();
		for (Item item : items) {
			if (item.getName().contains(key)) {
				result.add(item);
			}
		}
		return result;
	}

	public Item findById(String id) {
		Item result = null;
		for (Item item : this.items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}

	private String generateId() {
		Random rm = new Random();
		return String.valueOf(rm.nextLong() + System.currentTimeMillis());
	}
}
