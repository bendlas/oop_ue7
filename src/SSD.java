
public class SSD implements Device {

	private String name;

	public SSD (String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}
}
