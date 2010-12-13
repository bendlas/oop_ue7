
abstract public class Medium implements Device {
	private Slot holder;
	
	/*
	 * post: ejects medium from slot (if not empty) and marks slot empty
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
	/*
	 * pre: inserts medium into slot only if slot is empty
	 * post: return true if insert successful
	 */
	protected boolean doInsert(Slot slot) {
		while ( holder == null) {
			holder = slot;
			return true;
		}
		return false;
	}
	
	/*
	 * pre: inserts medium into slot only if slot is empty
	 * post: inserts medium into USBSlot and return false;
	 * 		 if insert is successful, Slot.insert returns true
	 */
	protected boolean insertToUSBSlot(USBSlot port) {
		return false;
	}
	
	/*
	 * pre: inserts medium into slot only if slot is empty
	 * post: inserts medium into BlueRaySlot and return false;
	 * 		 if insert is successful, Slot.insert returns true
	 */
	protected boolean insertToBlueRaySlot(BlueRaySlot slot){
		return false;
	}
	
	/*
	 * pre: inserts medium into slot only if slot is empty
	 * post: inserts medium into CDSlot and return false;
	 * 		 if insert is successful, Slot.insert returns true
	 */
	protected boolean insertToCDSlot(CDSlot slot){
		return false;
	}
	
	/*
	 * pre: inserts medium into slot only if slot is empty
	 * post: inserts medium into CF1Slot and return false;
	 * 		 if insert is successful, Slot.insert returns true
	 */
	protected boolean insertToCF1Slot(CF1Slot slot){
		return false;
	}
	
	/*
	 * pre: inserts medium into slot only if slot is empty
	 * post: inserts medium into CF2Slot and return false;
	 * 		 if insert is successful, Slot.insert returns true
	 */
	protected boolean insertToCF2Slot(CF2Slot slot){
		return false;
	}
	
	/*
	 * pre: inserts medium into slot only if slot is empty
	 * post: inserts medium into DVDSlot and return false;
	 * 		 if insert is successful, Slot.insert returns true
	 */
	protected boolean insertToDVDSlot(DVDSlot slot){
		return false;
	}
	
	/*
	 * pre: inserts medium into slot only if slot is empty
	 * post: inserts medium into MemoryStickSlot and return false;
	 * 		 if insert is successful, Slot.insert returns true
	 */
	protected boolean insertToMemoryStickSlot(MemoryStickSlot slot){
		return false;
	}
	
	/*
	 * pre: inserts medium into slot only if slot is empty
	 * post: inserts medium into MicroSDSlot and return false;
	 * 		 if insert is successful, Slot.insert returns true
	 */
	protected boolean insertToMicroSDSlot(MicroSDSlot slot){
		return false;
	}
	
	/*
	 * pre: inserts medium into slot only if slot is empty
	 * post: inserts medium into MiniSDSlot and return false;
	 * 		 if insert is successful, Slot.insert returns true
	 */
	protected boolean insertToMiniSDSlot(MiniSDSlot slot){
		return false;
	}
	
	/*
	 * pre: inserts medium into slot only if slot is empty
	 * post: inserts medium into SDSlot and return false;
	 * 		 if insert is successful, Slot.insert returns true
	 */
	protected boolean insertToSDSlot(SDSlot slot){
		return false;
	}
}
