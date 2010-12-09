
public class MiniSDSlot extends Slot {

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToMiniSD(this);
	}

	@Override
	public String getName() {
		return "Mini SD  Slot";
	}

}
