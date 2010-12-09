
public class SD extends Medium {

	private String name;

	public SD (String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	@Override
	protected boolean insertToSDSlot(SDSlot slot) {
		return doInsert(slot);
	}
}
