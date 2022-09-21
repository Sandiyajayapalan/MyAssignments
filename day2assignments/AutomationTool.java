package week3.day2assignments;

public class AutomationTool extends MultipleLanguage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutomationTool obj = new AutomationTool();
		obj.Java();
		obj.Selenium();
		obj.python();
		obj.ruby();
		

	}

	public void Selenium() {
		// TODO Auto-generated method stub
		System.out.println("Selenium from TestTool Interface");
	}

	public void Java() {
		// TODO Auto-generated method stub
		System.out.println("Java from Language Interface");
	}

	@Override
	public void ruby() {
		// TODO Auto-generated method stub
		System.out.println("Ruby from unimplemented MultipleLanguage abstract class");
	}

}
