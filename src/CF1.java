
public class CF1 extends Medium {

	private String name;
	
	public CF1 (String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	protected boolean insertToCF1Slot(CF1Slot slot) {
		return doInsert(slot);
	}
	@Override
	protected boolean insertToCF2Slot(CF2Slot slot) {
		return doInsert(slot);
	}
}
