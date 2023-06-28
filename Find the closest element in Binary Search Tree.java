// https://course.acciojob.com/idle?question=b6dc6dc8-f442-41e4-af8a-1d22286d4746
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;
	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}


class Main {
	static Node buildTree(String str) {
		// System.out.print(str);
		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}
		String ip[] = str.split(" ");
		Node root = new Node(Integer.parseInt(ip[0]));
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int i = 1;
		while (queue.size() > 0 && i < ip.length) {
			Node currNode = queue.peek();
			queue.remove();
			String currVal = ip[i];
			if (!currVal.equals("N")) {
				currNode.left = new Node(Integer.parseInt(currVal));
				queue.add(currNode.left);
			}
			i++;
			if (i >= ip.length)
				break;
			currVal = ip[i];
			if (!currVal.equals("N")) {
				currNode.right = new Node(Integer.parseInt(currVal));
				queue.add(currNode.right);
			}
			i++;
		}
		return root;
	}

	static void printLevelOrder(Node root)
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {

			/* poll() removes the present head.
			For more information on poll() visit
			http://www.tutorialspoint.com/java/
			util/linkedlist_poll.htm */
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			/*Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			/*Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}


	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		//System.out.print(s);
		Node root = buildTree(s);
		int k;
		k = sc.nextInt();
		Solution tree = new Solution();
		int answer = tree.maxDiff(root,k);
		System.out.println(answer);
	}
}



class Solution { 
	static int ans;
	static int diff;
static int maxDiff(Node root, int k)
{
   //your code here
	ans=0;
	diff=Integer.MAX_VALUE;
	solve(root,k);
	return ans;
}
	private static void solve(Node root, int k){
		if(root==null)return;
		if(diff>Math.abs(root.data-k)){
			diff=Math.abs(root.data-k);
			ans=root.data;
		}
		if(root.data<k) solve(root.right,k);
		else solve(root.left,k);
	}
}
