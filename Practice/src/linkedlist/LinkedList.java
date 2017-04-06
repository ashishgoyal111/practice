package linkedlist;

public class LinkedList {
    public class Node {
	int data;
	Node next = null;
	public int getData() {
		return data;
	}
	public Node getNext() {
		return next;
	}
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList()
    {
	head = tail = null;
	size = 0;
    }

    public LinkedList(int[] arr)
    {
	for (int i : arr) {
	    addNodeAtLast(i);
	}
    }

    public Node getHead()
    {
	if (head != null)
	    return head;
	return null;
    }
    
    public void setHead(Node head) {
    	this.head = head;
    }

    public Node getTail()
    {
	if (tail != null)
	    return tail;
	return null;
    }

    public int addNode(int a)
    {
	if (head == null) {
	    head = new Node();
	    head.data = a;
	    tail = head;
	    size++;
	    return 1;
	}
	Node newNode = new Node();
	newNode.data = a;
	newNode.next = head;
	head = newNode;
	size++;
	return 1;
    }

    public int addNodeAtLast(int a)
    {
	if (head == null) {
	    addNode(a);
	    return 1;
	}
	Node newNode = new Node();
	newNode.data = a;
	tail.next = newNode;
	tail = newNode;
	size++;
	return 1;
    }

    public int addNodeAfter(int curVal, int newVal)
    {
	if (head == null) {
	    System.out.println("List is empty");
	    return -1;
	}
	Node temp = head;
	while (temp != null && temp.data != curVal)
	    temp = temp.next;
	if (temp == null) {
	    System.out.println("Node not found");
	    return -1;
	}
	System.out.println("Node found");
	Node newNode = new Node();
	newNode.data = newVal;
	newNode.next = temp.next;
	temp.next = newNode;
	size++;
	return 1;
    }

    public int deleteNode(int curVal)
    {
	if (head == null) {
	    System.out.println("Empty list");
	    return -1;
	}
	if (head.data == curVal) {
	    head = head.next;
	    System.out.println("Node deleted successfully");
	    size--;
	    return 1;
	}
	Node temp = head.next;
	Node prev = head;
	while (temp != null && temp.data != curVal) {
	    prev = temp;
	    temp = temp.next;
	}
	if (temp == null) {
	    System.out.println("Node not found");
	    return -1;
	}
	prev.next = temp.next;
	size--;
	System.out.println("Node deleted successfully");
	return 1;
    }

    public int deleteNodeAt(int pos)
    {
	int count = 0;
	if (head == null) {
	    System.out.println("Empty list");
	    return -1;
	}
	if (pos == 0) {
	    head = head.next;
	    size--;
	    System.out.println("Node deleted successfully");
	    return 1;
	}
	Node temp = head.next;
	Node prev = head;
	while (temp != null && ++count < pos) {
	    prev = temp;
	    temp = temp.next;
	}
	if (temp == null) {
	    System.out.println("Positions passed is greater than size of list");
	    return -1;
	}
	prev.next = temp.next;
	size--;
	System.out.println("Node deleted successfully");
	return 1;
    }

    public boolean checkIfKeyExists(int a)
    {
	if (head == null)
	    return false;
	Node temp = head;
	while (temp != null && temp.data != a) {
	    temp = temp.next;
	}
	if (temp == null)
	    return false;
	return true;
    }

    public boolean isEmpty()
    {
	return head == null;
    }

    public Node getMiddleOfList()
    {
	Node slow, fast;
	slow = fast = head;
	while (fast.next != null && fast.next.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	}
	return slow;
    }

    public int findNthNodeFromEnd(int n)
    {
	if (n > size) {
	    System.out.println("N is more that size of the linked list");
	    return -1;
	}
	Node fast = head;
	Node slow = head;

	while (n-- > 0) {
	    fast = fast.next;
	}
	while (fast != null) {
	    slow = slow.next;
	    fast = fast.next;
	}
	return slow.data;
    }

    public int getCountOf(int n)
    {
	Node temp = head;
	int count = 0;
	while (temp != null) {
	    if (temp.data == n)
		count++;
	    temp = temp.next;
	}
	return count;
    }

    public int getSize()
    {
	return size;
    }

    public int getSizeiterative()
    {
	Node temp = head;
	int size = 0;
	while (temp != null) {
	    temp = temp.next;
	    size++;
	}
	return size;
    }

    public int getSizeRecursive()
    {
	Node temp = head;
	if (temp == null)
	    return 0;
	return countNodesAfterNode(temp);
    }

    private int countNodesAfterNode(Node head)
    {
	if (head == null)
	    return 0;
	return 1 + countNodesAfterNode(head.next);
    }

    public void printList()
    {
	Node temp = head;
	while (temp != null) {
	    System.out.print(temp.data + " --> ");
	    temp = temp.next;
	}
	System.out.println("null");
	return;
    }

    public void printListRecursive()
    {
	printListRecursive(head);
	System.out.println("null");
    }

    private void printListRecursive(Node node)
    {
	if (node.next != null)
	    printListRecursive(node.next);
	System.out.print(node.data + " --> ");
    }

    public static void removeDunplicatesFromSortedList(LinkedList list)
    {
	Node node = list.head;
	if (node == null)
	    return;
	int maxValueByNow = node.data;
	while (node.next != null) {
	    if (node.data < maxValueByNow) {
		System.out.println("List is not sorted");
	    }
	    maxValueByNow = node.data;
	    if (node.data == node.next.data) {
		node.next = node.next.next;
		continue;
	    }
	    if (node.next != null)
		node = node.next;
	}
    }

    public static boolean isLinkedListSorted(LinkedList list)
    {
	Node node = list.head;
	if (node == null) {
	    System.out.println("Empty list");
	    return true;
	}
	while (node.next != null) {
	    if (node.data > node.next.data)
		return false;
	    node = node.next;
	}
	return true;
    }

    public static void reverseList(LinkedList list)
    {
	Node node = list.head;
	if (node == null || node.next == null)
	    return;
	Node prev = null;
	Node curr = node;
	Node next = curr.next;
	while (curr != null) {
	    next = curr.next;
	    curr.next = prev;
	    prev = curr;
	    curr = next;
	}
	list.head = prev;
    }

    public void reverseList()
    {
	reverseList(this);
    }

    public boolean checkIfListIsPalindromeRecursive()
    {
	if (head == null || head.next == null) {
	    return true;
	}
	Node temp = checkIfListIsPalindromeRecursive(head);
	return temp != null;
    }

    public Node checkIfListIsPalindromeRecursive(Node second)
    {
	Node first = head;
	if (second == null) {
	    return first;
	}
	first = checkIfListIsPalindromeRecursive(second.next);
	if (first == null) {
	    return null;
	}
	if (second.data == first.data) {
	    // first.next will be null when first and last nodes are compared
	    return first.next == null ? first : first.next;
	} else {
	    return null;
	}
    }

    public void deleteAlternateNodes()
    {
	Node node = head;
	while (node != null && node.next != null) {
	    node.next = node.next.next;
	    node = node.next;
	}
    }

    private void deleteAlternateNodesRecursive(Node node)
    {
	if (node == null || node.next == null)
	    return;
	node.next = node.next.next;
	deleteAlternateNodesRecursive(node.next);
    }

    public void deleteAlternateNodesRecursive()
    {
	deleteAlternateNodesRecursive(head);
    }

    public static LinkedList addNumberRepresentedByLists(LinkedList list1, LinkedList list2)
    {
	LinkedList result = new LinkedList();
	Node node1 = list1.head;
	Node node2 = list2.head;
	int carry = 0;
	while (node1 != null || node2 != null) {
	    int data = (node1 == null ? 0 : node1.data) + (node2 == null ? 0 : node2.data) + carry;
	    result.addNodeAtLast(data % 10);
	    carry = data / 10;
	    node1 = node1.next;
	    node2 = node2.next;
	}
	if (carry != 0)
	    result.addNodeAtLast(carry);
	return result;
    }

    public void rotateList(int k)
    {
	if (k >= size || k <= 0) {
	    return;
	}
	Node node = head;
	while (k-- > 1) {
	    node = node.next;
	}
	tail.next = head;
	head = node.next;
	node.next = null;
    }

    public void pairWiseSwap()
    {
	Node node = head;
	while (node != null && node.next != null) {
	    int temp = node.data;
	    node.data = node.next.data;
	    node.next.data = temp;
	    node = node.next.next;
	}
    }
    
    public void pairWiseSwapNodes() {
	head = pairWiseSwapNodes(head);
    }
    
    public Node pairWiseSwapNodes(Node node) {
	if(node == null || node.next == null)
	    return node;
	Node next = node.next;
	Node nextNext = next.next;
	next.next = node;
	node.next = pairWiseSwapNodes(nextNext);
	return next;
    }

    public void pairWiseSwapRecursive()
    {
	pairWiseSwapRecursive(head);
    }

    private void pairWiseSwapRecursive(Node node)
    {
	if (node == null || node.next == null)
	    return;
	int temp = node.data;
	node.data = node.next.data;
	node.next.data = temp;
	pairWiseSwapRecursive(node.next.next);
    }

    public void swapTwoNodesAndNotData(int x, int y)
    {
	Node node = head;
	Node prev1, prev2, node1, node2;
	prev1 = prev2 = node1 = node2 = null;

	while (node != null) {
	    if (node.data == x || node.data == y) {
		if (node1 == null) {
		    node1 = node;
		} else {
		    node2 = node;
		}
	    }
	    if (node != null && node2 != null) {
		break;
	    }
	    if (node1 == null) {
		prev1 = node;
	    }
	    if (node2 == null) {
		prev2 = node;
	    }

	    node = node.next;
	}
	if (node1 == null || node2 == null) {
	    return;
	}
	if (prev1 != null)
	    prev1.next = node2;
	else
	    head = node2;
	if (prev2 != null)
	    prev2.next = node1;
	Node temp = node2.next;
	node2.next = node1.next;
	node1.next = temp;
    }
    
    public static LinkedList addNumberRepresentedByListsDifficult(LinkedList a, LinkedList b) {
    	if(a.head == null)
    		return b;
    	if(b.head == null)
    		return a;
    	int size1 = a.getSize();
    	int size2 = b.getSize();
		LinkedList result = new LinkedList();
    	if(size1 == size2) {
    		System.out.println("size are equal");
        	int carry = addEqualListsDifficultUtil(a.head, b.head, result);
        	if(carry != 0)
        		result.addNode(carry);
        	return result;
    	}
    	int diff;
    	if(size1 > size2) {
    		diff = size1- size2;
    	}
    	else {
    		diff = size2- size1;
    		LinkedList temp = a;
    		a = b;
    		b = temp;
    	}
    	Node head1 = a.head;
    	while(diff-- != 1) {
    		head1 = head1.next;
    	}
    	int carry = addEqualListsDifficultUtil(head1.next, b.head, result);
    	result.printList();
    	System.out.println("a.head : " + a.head.data);
    	System.out.println("head1 : " + head1.data);
    	carry = addCarryToRemaining(a.head, head1, carry, result);
    	if(carry != 0)
    		result.addNode(carry);
    	return result;
    }
    private static int addCarryToRemaining(Node head, Node cur, int carry, LinkedList result) {
    	int carry1 = 0;
    	if(head != cur) {
    		carry1 = addCarryToRemaining(head.next, cur, carry, result);
    		int sum = head.data + carry1;
        	result.addNode(sum%10);
        	return sum/10;
    	}
    	int sum = head.data + carry;
    	result.addNode(sum%10);
    	return sum/10;
    }
    private static int addEqualListsDifficultUtil(Node a, Node b, LinkedList result) {
    	if(a == null && b == null)
    		return 0;
    	if(a == null || b == null)
    		return -1;
    	int carry = addEqualListsDifficultUtil(a.next, b.next, result);
    	int sum = a.data + b.data + carry;
    	result.addNode(sum%10);
    	return sum/10;
    }
    public void deleteNnodeAfterMnodes(int m, int n) {
    	Node node = head;
    	int x , y;
    	while(node != null) {
    		System.out.println("data : " + node.data);
    		x = m-1;
    		y = n;
    		while(x-- != 0 && node != null) {
    			System.out.println("1st : " + node.data);
        		node = node.next;
        	}
    		while(y-- != 0 && node != null && node.next != null) {
    			System.out.println("2nd : " + node.data);
    			node.next = node.next.next;
    		}
    		if(node != null && node.next != null)
    			node = node.next;
    	}
    }
    public void insertionSort() {
    	if(head == null || head.next == null)
    		return;
    	LinkedList list = new LinkedList();
    	Node node = head;
    	while(node != null) {
    		if(list.head == null)
    		{
    			list.addNode(node.data);
    			node = node.next;
    			continue;
    		}
    		Node prev = null;
    		Node node2 = list.head;
    		while(node2 != null && node2.data < node.data) {
    			prev = node2;
    			node2 = node2.next;
    		}
    		Node newNode = new Node();
    		newNode.data = node.data;
    		newNode.next = node2;
    		if(prev != null) {
    			prev.next = newNode;
    		}else{
    			list.head = newNode;
    		}
    		node = node.next;
    	}
    	head = list.head;
    }
    public void rearrangeLinkedListInPlace() {
    	// Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. 
    	// Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …
    	Node mid = getMiddleOfList();
    	LinkedList list = new LinkedList();
    	list.head = mid.next;
    	mid.next = null;
    	list.reverseList();
    	LinkedList.mergeAlternateOfGivenLists(this, list);
    }
    
    public static void mergeAlternateOfGivenLists(LinkedList list1, LinkedList list2) {
    	Node head1 = list1.head;
    	Node head2 = list2.head;
    	while(head1 != null && head2 != null) {
    		Node temp = head1.next;
    		head1.next = head2;
    		head2 = head2.next;
    		head1.next.next = temp;
    		head1 = temp;
    	}
    }
    public static LinkedList mergeTwoSortedListInReverseOrder(LinkedList a, LinkedList b) {
    	LinkedList result = new LinkedList();
    	Node node1 = a.head;
    	Node node2 = b.head;
    	while(node1 != null && node2 != null) {
    		if(node1.data < node2.data) {
    			result.addNode(node1.data);
    			node1 = node1.next;
    		}
    		else {
    			result.addNode(node2.data);
    			node2 = node2.next;
    		}
    	}
    	while(node1 != null) {
    		result.addNode(node1.data);
			node1 = node1.next;
    	}
    	while(node2 != null) {
    		result.addNode(node2.data);
			node2 = node2.next;
    	}
    	return result;
    }
    public void reverseInGroupOfKElements(int k) {
    	if(k > size || k == 0)
    		return;
    	head = reverseInGroupOfKElements(head, k);
    }
    public Node reverseInGroupOfKElements(Node node, int k) {
    	Node prev = node;
    	Node first = node;
    	int tempK = k;
    	Node cur = null;
    	if(node.next != null)
    		cur = node.next;
    	while(cur != null && tempK-- != 1) {
    		Node next = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    	}
    	if(cur != null) {
    		first.next = reverseInGroupOfKElements(cur, k);
    	}
    	else {
    		first.next = null;
    	}
    	return prev;
    }
    public void reverseAlternateKNodes(int k) {
    	if(k == 0 || head == null)
    		return;
    	Node node = head;
    	Node prev = null;
    	Node[] arr = null;
    	while(node != null) {
    		arr = reverseKNodes(node, k);
    		if(prev == null) {
    			head= arr[0];
    		}
    		else {
    			prev.next = arr[0];
    		}
    		Node[] arr2 = skipKNodes(arr[1], k);
    		node = arr2[0];
    		prev = arr2[1];
    	}
    }
    private Node[] skipKNodes(Node node, int k) {
    	Node prev = null;
    	while(node != null && k-- != 0) {
    		prev = node;
    		node = node.next;
    	}
    	Node[] arr = {node, prev};
    	return arr;
    }
    public Node[] reverseKNodes(Node node, int k) {
    	Node prev = node;
    	Node first = node;
    	Node cur = null;
    	if(node.next != null)
    		cur = node.next;
    	while(cur != null && k-- != 1) {
    		Node next = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    	}
    	first.next = cur;
    	Node[] arr = {prev, cur};
    	return arr;
    }
    public void addXToLinkedListDifficult(int x) {
    	if(head == null)
    		return;
    	LinkedList result = new LinkedList();
    	int carry = addXToLinkedListDifficult(head, result, x);
    	if(carry != 0)
    		result.addNode(carry);
    	head = result.head;
    }
    public int addXToLinkedListDifficult(Node node, LinkedList result, int x) {
    	if(node.next == null)
    	{
    		int sum = node.data + x;
        	result.addNode(sum%10);
        	return sum/10;
    	}
    	int carry = addXToLinkedListDifficult(node.next, result, x);
    	int sum = node.data + carry;
    	result.addNode(sum%10);
    	return sum/10;
    	
    }
    public void zigZagList() {
	boolean flag = true;
	Node cur = head;
	while(cur.next != null) {
	    if(flag) {
		if(cur.data  > cur.next.data) {
		    swapData(cur, cur.next);
		}
	    }
	    else {
		if(cur.data  < cur.next.data) {
		    swapData(cur, cur.next);
		}
	    }
	    cur = cur.next;
	    flag = !flag;
	}
    }
    private void swapData(Node a, Node b) {
	int tmp = a.data;
	a.data = b.data;
	b.data = tmp;
    }
}
