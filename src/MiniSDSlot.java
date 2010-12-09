
public class MiniSDSlot extends Slot {

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToMiniSDSlot(this);
	}

	@Override
	public String getName() {
		return "Mini SD  Slot";
	}

}
