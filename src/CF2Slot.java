
public class CF2Slot extends Slot {

	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToCF2(this);
	}

	@Override
	public String getName() {
		return "CF II Slot";
	}

}
