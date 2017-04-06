package test;

public class AbstractClassUsage extends AbstractClassTest {
    public void doSomething() {
	System.out.println("I am doing something");
    }
    
    public static void main(String[] args) {
	AbstractClassTest hshfhdi = new AbstractClassUsage();
	hshfhdi.doSomething();
    }
}