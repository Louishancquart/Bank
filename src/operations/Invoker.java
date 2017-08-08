package operations;

public class Invoker {
	private CommandOperations command;
	public void setCommand(CommandOperations command)
	{
		this.command=command;
	}
	public boolean doOperation()
	{
		return command.execute();
	}
}
