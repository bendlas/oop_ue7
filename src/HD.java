
public class HD implements Device {

	private String name;

	public HD (String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	/*
	 * returns name of device
	 */
	@Override
	public String toString() {
		return getName();
	}
}
