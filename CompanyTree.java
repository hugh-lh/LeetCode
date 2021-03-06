//package OA2secondRound;

import java.util.*;

class Node {
	int val;
	ArrayList<Node> children;
	public Node(int val) {
		this.val = val;
		children = new ArrayList<Node>();
	}
}

class SumCount {
	int number;
	int sum;
	double avgMax;
	public SumCount(int number, int sum, double avgMax) {
		this.number = number;
		this.sum = sum;
		this.avgMax = avgMax;
	}
}

public class CompanyTree {
	public static Node getMaxAvgSubTree(Node root) {
		// write your code here
		if (root == null) return root;
		Node[] result = new Node[1];
		postDFS(root, result);
		return result[0];
	}
	public static SumCount postDFS(Node root, Node[] result) {
		int sum = root.val;
		int num = 1;
		double avgMax = Double.MIN_VALUE;
		if (root.children == null || root.children.size() == 0) return new SumCount(num, sum, avgMax);
		for (Node n : root.children) {
			if (n != null) {
				SumCount sc = postDFS(n, result);
				sum += sc.sum;
				num += sc.number;
				avgMax = Math.max(avgMax, sc.avgMax);
			}
		}
		double avg = (double) sum/num;
		if (avg > avgMax) {
			avgMax = avg;
			result[0] = root;
		}
		return new SumCount(num, sum, avgMax);
	}
	
	public static void main(String[] args) {
		CompanyTree mas = new CompanyTree();
		
		/*
		 * case 1:
		 *       5
		 *     /   \
		 *   3       3
 		 *  / \     /  \
		 * 1   1   1    1  
		 * return is 5
		 */
		Node head1 = new Node(5);
		head1.children.add(new Node(3));
		head1.children.add(new Node(3));
		head1.children.get(0).children.add(new Node(1));
		head1.children.get(0).children.add(new Node(1));
		head1.children.get(1).children.add(new Node(1));
		head1.children.get(1).children.add(new Node(1));
		Node check = mas.getMaxAvgSubTree(head1);
		if(check == head1) {
			System.out.println("test case 1 correct!");
		} else {
			System.out.println("test case 1 fail!");
			System.out.println(check.val);
		}
		
		/*
		 * case 2:
		 *       3
		 *     /   \
		 *   17      8  
		 * return is 3
		 */
		Node head2 = new Node(3);
		head2.children.add(new Node(17));
		head2.children.add(new Node(8));
		check = mas.getMaxAvgSubTree(head2);
		if(check == head2) {
			System.out.println("test case 2 correct!");
		} else {
			System.out.println("test case 2 fail!");
			System.out.println(check.children);
			System.out.println(check.val);
		}
		
		/*
		 * case 3:
		 * null
		 * return is null
		 */
		Node head3 = null;
		check = mas.getMaxAvgSubTree(head3);
		if(check == null) {
			System.out.println("test case 3 correct!");
		} else {
			System.out.println("test case 3 fail!");
		}
		
		/*
		 * case 4:
		 * 1
		 * return is null
		 */
		Node head4 = new Node(1);
		check = mas.getMaxAvgSubTree(head4);
		if(check == null) {
			System.out.println("test case 4 correct!");
		} else {
			System.out.println(check.val);
			System.out.println("test case 4 fail!");
		}
		
		/*
		 * case 5:
		 * 1
		 * | \
		 * 0  null
		 * return is node 1
		 */
		Node head5 = new Node(1);
		head5.children.add(new Node(1));
		head5.children.add(null);
		check = mas.getMaxAvgSubTree(head5);
		if(check == head5) {
			System.out.println("test case 5 correct!");
		} else {
			System.out.println("test case 5 fail!");
			System.out.println(check.val);
		}
		
		/*
		 * case 6:
		 *   1
		 *  / \
		 * 0   3
		 * |
		 * 4
		 * return is node 2 in 2nd level, not root
		 */
		Node head6 = new Node(1);
		head6.children.add(new Node(0));
		head6.children.add(new Node(3));
		head6.children.get(0).children.add(new Node(4));
		check = mas.getMaxAvgSubTree(head6);
		if(check == head6.children.get(0)) {
			System.out.println("test case 6 correct!");
		} else {
			System.out.println("test case 6 fail!");
		}
		
		/*
		 * case 7:
		 *   1
		 *  / \
		 * 2   300
		 * |\ 
		 * 1 1
		 * return is node root
		 */
		Node head7 = new Node(1);
		head7.children.add(new Node(2));
		head7.children.add(new Node(300));
		head7.children.get(0).children.add(new Node(1));
		head7.children.get(0).children.add(new Node(1));
		check = mas.getMaxAvgSubTree(head7);
		if(check == head7) {
			System.out.println("test case 7 correct!");
		} else {
			System.out.println("test case 7 fail!");
		}
		
		/*
		 * case 8:
		 *   1
		 *  / \
		 * 200   3
		 * |\ 
		 * 1 1
		 * return is node 200
		 */
		Node head8 = new Node(1);
		head8.children.add(new Node(200));
		head8.children.add(new Node(3));
		head8.children.get(0).children.add(new Node(1));
		head8.children.get(0).children.add(new Node(1));
		check = mas.getMaxAvgSubTree(head8);
		if(check == head8.children.get(0)) {
			System.out.println("test case 8 correct!");
		} else {
			System.out.println("test case 8 fail!");
		}
	}
}
