
public class DVD extends Medium {

	private String name;

	public DVD (String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	// FOR ALL INSERT-METHODS
	/*
	 * post: inserts medium into slot only if medium isnt inserted anywhere else
	 * 		 and return true if insert successful
	 */
	@Override
	protected boolean insertToDVDSlot(DVDSlot slot) {
		return doInsert(slot);
	}
	@Override
	protected boolean insertToBlueRaySlot(BlueRaySlot slot) {
		return doInsert(slot);
	}
}
