
public class CDSlot extends Slot {

	//pre: is called if Slot is empty
	//post: returns whether insert worked 
	//post: checks if medium fits into slot, and inserts if so
	//this method is overridden to call a appropriate Visitor Method in the Medium (emulated Multimethod)
	@Override
	protected boolean doInsert(Medium medium) {
		return medium.insertToCDSlot(this);
	}

	@Override
	public String getName() {
		return "CD Slot";
	}

}
