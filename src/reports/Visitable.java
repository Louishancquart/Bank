package reports;

public interface Visitable {
	public void accept(Visitor visitor);
}