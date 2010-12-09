
public class MemoryStickSlot extends Slot {

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToMemoryStickSlot(this);
	}

	@Override
	public String getName() {
		return "Memory Stick Slot";
	}

}
