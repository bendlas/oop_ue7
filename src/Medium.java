
abstract public class Medium implements Device {
	protected Slot holder;
	
	/**
	 * package visible for Slot
	 */
	protected void eject() {
		while (holder != null) {
			holder.eject();
			holder = null;
		}
	}

	@Override
	public String toString() {
		return getName();
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
	
	protected boolean insertToUSBSlot(USBSlot port) {
		return false;
	}
	protected boolean insertToBlueRaySlot(BlueRaySlot slot){
		return false;
	}
	protected boolean insertToCDSlot(CDSlot slot){
		return false;
	}
	protected boolean insertToCF1Slot(CF1Slot slot){
		return false;
	}
	protected boolean insertToCF2Slot(CF2Slot slot){
		return false;
	}
	protected boolean insertToDVDSlot(DVDSlot slot){
		return false;
	}
	protected boolean insertToMemoryStickSlot(MemoryStickSlot slot){
		return false;
	}
	protected boolean insertToMicroSDSlot(MicroSDSlot slot){
		return false;
	}
	protected boolean insertToMiniSDSlot(MiniSDSlot slot){
		return false;
	}
	protected boolean insertToSDSlot(SDSlot slot){
		return false;
	}
}
