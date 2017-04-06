package stack;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class InfixToPostfix {
    public static int evaluatePostfixExp(String s) throws ScriptException {
	int result = 0;
	ArrayStack data = new ArrayStack(s.length());
	Scanner in = new Scanner(s);
	while(in.hasNext()) {
	    if(in.hasNextInt()) {
		data.pushElement(in.nextInt());
		continue;
	    }
	    int num2 = data.popElement();
	    int num1 = data.popElement();
	    String op = in.next();
	    switch (op) {
	    case "+":
		data.pushElement(num1+num2);
		break;
	    case "-":
		data.pushElement(num1-num2);
		break;
	    case "*":
		data.pushElement(num1*num2);
		break;
	    case "/":
		data.pushElement(num1/num2);
		break;
	    default:
		break;
	    }
	}
	return data.popElement();
    }
    public static String infixToPostfix(String s) {
	StringBuilder result = new StringBuilder();
	int stringSize = s.length();
	ArrayStack data = new ArrayStack(stringSize);
	for(int i=0; i<stringSize; i++) {
	    char c = s.charAt(i);
	    char temp;
	    switch (c) {
	    case '(':
		data.pushElement(c);
		break;
	    case ')':
		temp = (char)data.popElement();
		while(temp != '(') {
		    result.append(temp);
		    temp = (char)data.popElement();
		}
		break;
	    case '+':
	    case '-':
	    case '*':
	    case '/':
	    case '^':
		if(data.getSize() > 0) {
		    temp = (char)data.getTopElement();
		    if(isOperator(temp)) {
			while(isHigherOrEqualPrec(temp, c)) {
			    result.append((char)data.popElement());
			    temp = (char)data.getTopElement();
			}
		    }
		}
		data.pushElement(c);
		break;
	    default:
		result.append(c);
		break;
	    }
	}
	while(!data.isEmpty())
	    result.append((char)data.popElement());
	return result.toString();
    }
    private static boolean isHigherOrEqualPrec(char a, char b) {
	if(a == '^')
	    return true;
	if(b == '^')
	    return false;
	if(a == '*' || a=='/')
	    return true;
	if(b == '*' || b == '/')
	    return false;
	if(a == '+' || a=='-')
	    return true;
	if(b == '+' || b == '-')
	    return false;
	return true;
    }
    private static boolean isOperator(char c) {
	if(c =='+' || c =='-' || c == '*' || c == '/' || c == '^')
	    return true;
	return false;
    }
}
