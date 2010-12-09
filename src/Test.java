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
		sd.insert(new SD("Babz' Nacktfotos"));
		printComputer();
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
		error("TODO: No test defined");
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
}
