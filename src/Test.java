import java.util.Arrays;
import java.util.Collection;


public class Test {
	Slot cd;
	Slot dvd;
	Slot bd;
	
	Slot sd;
	Slot mSd;
	Slot muSd;
	
	Slot cf1;
	Slot cf2;
	
	Slot usb1;
	Slot usb2;
	Slot usb3;
	
	Device hd, extHd, ssd;
	USBDevice extHdDev, cardReader;
	
	Computer computer;
	
	private Test() {
		hd = new HD("C:");
		ssd = new SSD("E:");
		extHd = new HD("D:");
		
		cd = new CDSlot();
		dvd = new DVDSlot();
		bd = new BlueRaySlot();

		sd = new SDSlot();
		mSd = new MiniSDSlot();
		muSd = new MicroSDSlot();

		cf1 = new CF1Slot();
		cf2 = new CF2Slot();

		usb1 = new USBSlot();
		usb2 = new USBSlot();
		usb3 = new USBSlot();

		extHdDev = new USBDevice() {
			@Override
			public String getName() {
				return "Externe Festplatte";
			}
			@Override
			public Collection<Device> volumes() {
				return Arrays.asList(extHd);
			}
		};
		cardReader = new USBDevice() {
			@Override
			public String getName() {
				return "CardReader";
			}
			@Override
			public Collection<Device> volumes() {
				return Arrays.asList((Device) muSd, cf1, cf2, usb3, bd);
			}
		};
		
		computer = new Computer(
				hd, ssd, cd, dvd, sd, mSd,
				cf1, usb1, usb2, cardReader);
	}
	

	public void printComputer() {
		info("Current Volumes:");
		for (Device d : computer.volumes()) {
			info("--> " + d);
		}
	}
	
			
	public static void main(String[] args) {
		new Test().testBase();
		new Test().testCards();
		new Test().testOptical();
		new Test().testUSBDev();

	}
	private void testBase() {
		info("Testing Computer ...");
		assertInserted(computer, hd, ssd);
		info("... success!\n");
	}

	private void testCards() {
		info("Testing Cardreader");
		SD SDCard = new SD("Hama SD Card");
		MicroSD microSDCard = new MicroSD("Hama MicroSD Card");
		MiniSD miniSDCard = new MiniSD("Hama MiniSD Card");
		CF1 CF1Card = new CF1("Hama CompactFlash Card");
		CF2 CF2Card = new CF2("Hama CompactFlash II Card");
		MemoryStick MStick = new MemoryStick("Sony MemoryStick");
		
		//SD Card in SD Slot
		assertConnect(sd, SDCard, true);
		sd.eject();
		
		//MicroSD passt in SD Slot
		assertConnect(sd, microSDCard, true);
		sd.eject();
		
		//MiniSD passt in SD Slot
		assertConnect(sd, miniSDCard, true);

		//wenn schon eine MiniSD im SD slot ist kann keine weitere SD Karte hinzugef�gt werden
		assertConnect(sd, SDCard, false);
		sd.eject();
		
		//MemoryStick passt nicht in den SD Slot
		assertConnect(sd, MStick, false);
		sd.eject();
		
		//microSDCard in miniSD Slot
		assertConnect(mSd,miniSDCard, true);
		mSd.eject();
		
		//CF1Card in CF2Slot 
		assertConnect(cf2, CF1Card, true);
		
		//CF2Card in CF1Slot
		assertConnect(cf1, CF2Card, false);
		
		//plug Hama MiniSDCard in SDSlot, and then try to plug it into MiniSDSlot without eject
		assertConnect(sd, miniSDCard, true);
		//sollte nicht m�glich sein
		assertConnect(mSd, miniSDCard, false);
		info("... sucess!" + "\n");

		
	}
	private void testOptical() {
		info("Testing Optical Drives");
		CD cd1 = new CD("Sex Pistols");
		CD cd2 = new CD("The Clash");
		CD cd3 = new CD("The Ramones");
		DVD dvd1 = new DVD("Sex Pistols in Concert");
		DVD dvd2 = new DVD("The Clash in Concert");
		DVD dvd3 = new DVD("The Ramones in Concert");
		BluRay bd1 = new BluRay("Sex Pistols in Concert SPECIAL");
		BluRay bd2 = new BluRay("The Clash in Concert SPECIAL");
		BluRay bd3 = new BluRay("The Ramones in Concert SPECIAL");
		
		assertConnect(cd, cd1, true);
		cd.eject();
		assertConnect(cd, dvd1, false);
		assertConnect(cd, bd1, false);
		
		assertConnect(dvd, cd2, true);
		dvd.eject();
		assertConnect(dvd, dvd2, true);
		dvd.eject();
		dvd.eject();
		assertConnect(dvd, bd2, false);
		
		assertConnect(bd, cd3, true);
		bd.eject();
		assertConnect(bd, dvd3, true);
		bd.eject();
		assertConnect(bd, bd3, true);
		bd.eject();
		info("...sucess!");
	}
	
	private void testUSBDev(){
		info("Testing USB Devices...");
		//insert external Harddisk to USB Port 1
		assertConnect(usb1, extHdDev, true);
		
		//insert external Harddisk to USB Port 2 without ejecting from Port 1
		//should not work
		assertConnect(usb2, extHdDev, false);

		//eject External Harddisk from Port 1 & plug to Port 2
		usb1.eject();
		assertConnect(usb2, extHdDev, true);
		
		//plug cardreader to USB Port 1
		assertConnect(usb1, cardReader, true);
		
		info("... sucess!"  + "\n");
		
	}
	
	public static void out(String...out) {
		for (String s : out) {
			System.out.print(s);
		}
		System.out.println();		
	}
	public static void info(String...out) {
		System.out.print("INFO: ");
		Test.out(out);
	}
	public static void error(String...out) {
		System.out.print("ERROR: ");
		Test.out(out);
	}
	
	public static void assert_(boolean cond, String out) {
		while(!cond) {
			error(out);
			throw new AssertionError(out);
		}
	}
	
	public static void assertConnect(Slot slot, Medium medium, boolean connects) {
		assert_(slot.insert(medium) == connects, String.format("When inserting %s to %s, connected %b", medium, slot, !connects));
		assert_(medium.equals(slot.getInserted()) == connects, String.format("Slot %s doesn't contain %s", slot, medium));
	}
	
	public static void assertInserted(Slot slot, Medium medium) {
		assert_(medium.equals(slot.getInserted()), String.format("Slot %s doesn't contain %s", slot, medium));
	}
	
	public static void assertInserted(DeviceHolder holder, Device...dev) {
		assert_(holder.volumes().containsAll(Arrays.asList(dev)), String.format("DeviceHolder %s doesn't contain %s", holder, dev));
	}
	public static void assertEmpty(Slot slot) {
		assert_(slot.getInserted() == null, String.format("Slot %s not empty", slot));
	}
}
