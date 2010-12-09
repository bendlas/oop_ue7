
public class MemoryStickSlot extends Slot {

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToMemoryStick(this);
	}

	@Override
	public String getName() {
		return "Memory Stick Slot";
	}

}
