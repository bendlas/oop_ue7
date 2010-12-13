import java.util.Arrays;
import java.util.Collection;


public class Computer implements DeviceHolder {
	
	private Device[] devices;
	
	//beliebig viele Args vom typ device
	public Computer(Device ...devices){
		this.devices = devices;
	}
	
	@Override
	public Collection<Device> volumes() {
		return Arrays.asList(devices);
	}
}
