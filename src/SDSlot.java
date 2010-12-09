
public class SDSlot extends Slot {

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToSDSlot(this);
	}

	@Override
	public String getName() {
		return "SD Slot";
	}

}
