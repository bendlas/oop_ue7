
public abstract class SimpleSlot implements Slot {
	protected Medium enclosed;
	
	abstract protected boolean doInsert(Medium medium);
	
	@Override
	public boolean insert(Medium medium) {
		while (enclosed == null && doInsert(medium)) {
			// while nicht vermeidbar, da seiteneffekt
			enclosed = medium;
			return true;
		}
		return false;
	}
	
	@Override
	public void eject() {
		while (enclosed != null) {
			enclosed.eject();
			enclosed = null;
		}
	}
}
