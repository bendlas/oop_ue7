
public class MicroSD extends Medium {

	private String name;

	public MicroSD (String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	@Override
	protected boolean insertToMicroSDSlot(MicroSDSlot slot) {
		return doInsert(slot);
	}
	@Override
	protected boolean insertToMiniSDSlot(MiniSDSlot slot) {
		return doInsert(slot);
	}
	@Override
	protected boolean insertToSDSlot(SDSlot slot) {
		return doInsert(slot);
	}
	
}
