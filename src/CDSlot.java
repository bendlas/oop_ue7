
public class CDSlot extends Slot {

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToCD(this);
	}

	@Override
	public String getName() {
		return "CD Slot";
	}

}
