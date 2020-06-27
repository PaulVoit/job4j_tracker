import java.util.function.Consumer;

public class ExitAction {
	private final UserAction userAction;
	private final boolean exitCount = false;

	public ExitAction(UserAction userAction) {
		this.userAction = userAction;
	}



	public void exit(Input input, Tracker tracker, Consumer<String> output) {
		System.out.print("Exit... ");
		userAction.execute(input, tracker, output);
	}



}
