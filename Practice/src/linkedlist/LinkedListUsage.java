package linkedlist;

import java.io.Console;
import java.util.Scanner;

import linkedlist.LinkedList.Node;

public class LinkedListUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,3,4,5,2,6,7,8,9};
		int[] arr2 = {2,3,20};
		LinkedList list1 = new LinkedList(arr1);
		LinkedList list2 = new LinkedList(arr2);
		list1.getHead();
		list1.printList();
		list1.zigZagList();
		list1.printList();
	}

}
