
public class DVDSlot extends Slot {

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToDVDSlot(this);
	}

	@Override
	public String getName() {
		return "DVD Slot";
	}

}
