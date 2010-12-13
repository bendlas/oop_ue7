
public abstract class Slot implements Device {
	private Medium enclosed;
	
	//pre: is called if Slot is empty
	//post: returns whether insert worked 
	//post: checks if medium fits into slot, and inserts if so
	//this method is overridden to call a appropriate Visitor Method in the Medium (emulated Multimethod)
	abstract protected boolean doInsert(Medium medium);
	
	//post: inserts Medium in to Slot if this Slot is empty & Medium would fit into it
	public boolean insert(Medium medium) {
		while (enclosed == null && doInsert(medium)) {
			// while nicht vermeidbar, da seiteneffekt
			enclosed = medium;
			return true;
		}
		return false;
	}
	
	//post: removes Medium from Slot if there's one plugged
	public void eject() {
		while (enclosed != null) {
			Medium in = enclosed;
			enclosed = null;
			in.eject();
		}
	}
	
	public Medium getInserted() {
		return enclosed;
	}

	@Override
	public String toString() {
		return getName() + "{" + enclosed + "}";
	}
}
