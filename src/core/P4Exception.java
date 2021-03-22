package core;
public class P4Exception extends RuntimeException{
	private static final long serialVersionUID = 8973906100907547481L;
	
	public P4Exception() {
		super();
	}
	
	public P4Exception(String s) {
		super(s);
	}
	
	public P4Exception(Throwable s) {
		super(s);
	}
	
	public P4Exception(String s1, Throwable s2) {
		super(s1, s2);
	}
}
