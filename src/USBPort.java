
public class USBPort extends Slot {

	@Override
	public String getName() {
		return "USB Port";
	}

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToUSB(this);
	}
}
