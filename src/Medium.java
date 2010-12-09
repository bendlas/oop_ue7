
public interface Medium extends Device{
	void eject();
	boolean insertToCF1(CF1Slot slot);
	boolean insertToUSB(USBPort port);
}
