
public class DVD extends Medium {

	private String name;

	public DVD (String name){
		this.name = name;
	}

	public String getName(){
		return name;
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
