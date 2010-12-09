
abstract public class Medium implements Device {
	protected Slot holder;
	
	/**
	 * package visible for Slot
	 */
	void eject() {
		while (holder != null) {
			holder.eject();
			holder = null;
		}
	}

	/**
	 * Call this to actually insert the Medium
	 */
	protected boolean doInsert(Slot slot) {
		while ( holder == null) {
			holder = slot;
			return true;
		}
		return false;
	}

	protected boolean insertToCF1(CF1Slot slot) {
		return false;
	}
	
	protected boolean insertToUSB(USBPort port) {
		return false;
	}
}
