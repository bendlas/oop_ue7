
public class CF2 extends Medium {

	private String name;
	
	public CF2 (String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	@Override
	protected boolean insertToCF2Slot(CF2Slot slot) {
		return doInsert(slot);
	}
}
