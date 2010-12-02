
public class Test {
	public static void main(String[] args) {
		testBase();
		testEjectable();
		testCards();
		testOptical();
		// ...
	}
	private static void testBase() {
		info("Testing Optical Drives");
		error("TODO: No test defined");
	}
	private static void testEjectable() {
		info("Testing Optical Drives");
		error("TODO: No test defined");
	}
	private static void testCards() {
		info("Testing Optical Drives");
		error("TODO: No test defined");		
	}
	private static void testOptical() {
		info("Testing Optical Drives");
		error("TODO: No test defined");
		assert_(false, "Please define tests");
	}
	
	public static void out(String...out) {
		for (String s : out) {
			System.out.print(s);
		}
		System.out.println();		
	}
	public static void info(String...out) {
		System.out.print("INFO: ");
		Test.out(out);
	}
	public static void error(String...out) {
		System.out.print("ERROR: ");
		Test.out(out);
	}
	
	public static void assert_(boolean cond, String out) {
		while(!cond) {
			error(out);
			throw new AssertionError(out);
		}
	}
}
