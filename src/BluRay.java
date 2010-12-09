
public class BluRay extends Medium {

	private String name;

	public BluRay (String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	@Override
	protected boolean insertToBlueRaySlot(BlueRaySlot slot) {
		return doInsert(slot);
	}
}
