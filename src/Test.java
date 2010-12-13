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
	Device extHdDev, cardReader;
	
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
				cf1, usb1, usb2, extHdDev, cardReader);
	}
	

	public void printComputer() {
		info("Current Volumes:");
		for (Device d : computer.volumes()) {
			info("--> " + d);
		}
	}
	
			
	public static void main(String[] args) {
		new Test().testBase();
		new Test().testEjectable();
		new Test().testCards();
		new Test().testOptical();
		// ...
	}
	private void testBase() {
		info("Testing Optical Drives");
		SD m = new SD("Babz' Nacktfotos");
		assertConnect(sd, m, true);
		assertInserted(sd, m);
		sd.eject();
		assertEmpty(sd);
		error("TODO: No test defined");
	}
	private void testEjectable() {
		info("Testing Optical Drives");
		error("TODO: No test defined");
	}
	private void testCards() {
		info("Testing Optical Drives");
		error("TODO: No test defined");		
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
		assert_(false, "Please define tests");
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
