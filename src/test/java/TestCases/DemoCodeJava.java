package TestCases;

interface Student {

	public void show();


	}
	
	class Code implements Student {
		public void show() {
			
			System.out.println("code complected");
		}
		
	}

public class DemoCodeJava {
	 public static void main(String[] args) {
		 
		 Student s =new Code();
		 s.show();
		 
	 }
}