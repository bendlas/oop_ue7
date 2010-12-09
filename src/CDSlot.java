
public class CDSlot extends Slot {

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToCDSlot(this);
	}

	@Override
	public String getName() {
		return "CD Slot";
	}

}
