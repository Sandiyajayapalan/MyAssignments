package org.system;

public class Desktop extends Computer {
	public void desktopSize() {
		System.out.println("The size Of desktop is 32 inch");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Desktop size = new Desktop();
		size.desktopSize();
		size.computerModel();
	}

}
