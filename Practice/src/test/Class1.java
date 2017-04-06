package test;

public class Class1 {
    int i = 10;
    static int j;
    public void method1() {
	
    }
    public int method1(int a) {
	System.out.println(a);
	return a;
    }
    
    public static void main(String[] args) {
	Class1 vijay = new Class1();
	vijay.method1();
	vijay.method1(10);
    }
}
