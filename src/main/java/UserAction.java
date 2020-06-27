import java.util.function.Consumer;

public interface UserAction {
	int key();

	String info();

	String name();

	boolean execute(Input input, Tracker tracker, Consumer<String> output);
}
