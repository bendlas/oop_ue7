
public class USBSlot extends Slot {

	@Override
	public String getName() {
		return "USB Port";
	}

	//pre: is called if Slot is empty
	//post: returns whether insert worked 
	//post: checks if medium fits into slot, and inserts if so
	//this method is overridden to call a appropriate Visitor Method in the Medium (emulated Multimethod)
	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToUSBSlot(this);
	}
}
