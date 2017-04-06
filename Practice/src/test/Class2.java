package test;
import test.Class1;

public class Class2 extends Class1 {
    int i;
    public void method1() {
	
    }
    public int method1(int a) {
	System.out.println("Class2");
	return a;
    }
    public void method(int a, int b) {
	
    }
    public static void main(String[] args) {
	int x = Class2.j;
	Class2 class2 = new Class2();
	class2.method1(15);
	System.out.println(class2.i);
	
	Class2 class1 = new Class2();
	class1.method1(10);
	System.out.println("j: " + class1.j);
    }
}
