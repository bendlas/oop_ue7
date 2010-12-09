
public class CD extends Medium {

	private String name;

	public CD (String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	@Override
	protected boolean insertToCDSlot(CDSlot slot) {
		return doInsert(slot);
	}
	@Override
	protected boolean insertToDVDSlot(DVDSlot slot) {
		return doInsert(slot);
	}
	@Override
	protected boolean insertToBlueRaySlot(BlueRaySlot slot) {
		return doInsert(slot);
	}
}
