
public class BluRay extends Medium {

	private String name;

	public BluRay (String name){
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
	protected boolean insertToBlueRaySlot(BlueRaySlot slot) {
		return doInsert(slot);
	}
}
