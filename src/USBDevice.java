import java.util.Collection;


abstract public class USBDevice extends Medium implements DeviceHolder {
	@Override
	public Collection<Device> volumes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean insertToUSBSlot(USBSlot port) {
		return doInsert(port);
	}
}
