
public class DVDSlot extends Slot {

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToDVD(this);
	}

	@Override
	public String getName() {
		return "DVD Slot";
	}

}
