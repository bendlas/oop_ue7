
abstract public class SimpleMedium implements Medium {
	protected Slot holder;
	
	protected boolean doInsert(Slot slot) {
		while ( holder == null) {
			holder = slot;
			return true;
		}
		return false;
	}

	@Override
	public void eject() {
		while (holder != null) {
			holder.eject();
			holder = null;
		}
	}

	@Override
	public boolean insertToCF1(CF1Slot slot) {
		return false;
	}
	
	@Override
	public boolean insertToUSB(USBPort port) {
		return false;
	}
}
