
public class BlueRaySlot extends Slot {

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToBlueRaySlot(this);
	}

	@Override
	public String getName() {
		return "BlueRay Slot";
	}

}
