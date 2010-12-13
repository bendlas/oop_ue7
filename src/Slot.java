
public abstract class Slot implements Device {
	private Medium enclosed;
	
	abstract protected boolean doInsert(Medium medium);
	
	public boolean insert(Medium medium) {
		while (enclosed == null && doInsert(medium)) {
			// while nicht vermeidbar, da seiteneffekt
			enclosed = medium;
			return true;
		}
		return false;
	}
	
	public void eject() {
		while (enclosed != null) {
			Medium in = enclosed;
			enclosed = null;
			in.eject();
		}
	}
	

	@Override
	public String toString() {
		return getName() + "{" + enclosed + "}";
	}
}
