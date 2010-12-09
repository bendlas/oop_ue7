
public class MiniSD extends Medium {

	private String name;

	public MiniSD (String name){
		this.name = name;
	}

	public String getName(){
		return name;
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
