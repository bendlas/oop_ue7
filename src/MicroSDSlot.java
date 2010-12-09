
public class MicroSDSlot extends Slot {

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToMicroSDSlot(this);
	}

	@Override
	public String getName() {
		return "Micro SD Slot";
	}

}
