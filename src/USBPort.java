
public class USBPort extends SimpleSlot {

	@Override
	public String getName() {
		return "USB Port";
	}

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToUSB(this);
	}
}
