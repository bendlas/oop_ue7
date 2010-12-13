
public class CF2 extends Medium {

	private String name;
	
	public CF2 (String name){
		this.name = name;
	}
	
	// FOR ALL INSERT-METHODS
	/*
	 * post: inserts medium into slot only if medium isnt inserted anywhere else
	 * 		 and return true if insert successful
	 */
	public String getName(){
		return name;
	}
	@Override
	protected boolean insertToCF2Slot(CF2Slot slot) {
		return doInsert(slot);
	}
}
