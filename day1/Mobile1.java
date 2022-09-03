package week1.day1;

public class Mobile1 {
	public void makeCall() {
		System.out.println("Make a call to a friend");
		String mobileModel="OPPO";
		float mobileWeight=175.32f;

}
	public void sendMsg() {
		System.out.println("Send message to a friend");
		boolean fullCharged=true;
		int mobileCost=19000;
				
	}
	public static void main(String[] args) {
		Mobile1 obj=new Mobile1();
		obj.makeCall();
		obj.sendMsg();
	System.out.println("This is my mobile");
	}
}