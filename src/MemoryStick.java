
public class MemoryStick extends Medium {

	private String name;

	public MemoryStick (String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	@Override
	protected boolean insertToMemoryStickSlot(MemoryStickSlot slot) {
		return doInsert(slot);
	}
}
