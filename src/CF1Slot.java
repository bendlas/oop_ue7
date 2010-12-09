
public class CF1Slot extends SimpleSlot {

	@Override
	public String getName() {
		return "CF I Slot";
	}

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToCF1(this);
	}
}
