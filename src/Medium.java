
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
	
	protected boolean insertToUSB(USBPort port) {
		return false;
	}
	protected boolean insertToBlueRay(BlueRaySlot slot){
		return false;
	}
	protected boolean insertToCD(CDSlot slot){
		return false;
	}
	protected boolean insertToCF1(CF1Slot slot){
		return false;
	}
	protected boolean insertToCF2(CF2Slot slot){
		return false;
	}
	protected boolean insertToDVD(DVDSlot slot){
		return false;
	}
	protected boolean insertToMemoryStick(MemoryStickSlot slot){
		return false;
	}
	protected boolean insertToMicroSD(MicroSDSlot slot){
		return false;
	}
	protected boolean insertToMiniSD(MiniSDSlot slot){
		return false;
	}
	protected boolean insertToSD(SDSlot slot){
		return false;
	}
}
