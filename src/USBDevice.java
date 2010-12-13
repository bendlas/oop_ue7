import java.util.Collection;


abstract public class USBDevice extends Medium implements DeviceHolder {
	@Override
	public boolean insertToUSBSlot(USBSlot port) {
		return doInsert(port);
	}
	

	//post: returns "volume()" of all Devices Plugged to 
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder(getName()).append('{');
		for (Device d : volumes()) {
			buf.append(d.toString()).append(',');
		}
		return buf.append('}').toString();
	}
}
