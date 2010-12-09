
public class SDSlot extends Slot {

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToSD(this);
	}

	@Override
	public String getName() {
		return "SD Slot";
	}

}
