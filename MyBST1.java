package Set;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MyBST1<U extends Comparable<U>, V> {
	TreeNode<U, V> root;

	class TreeNode<U, V> {
		public U data1;
		public V data2;
		public TreeNode<U, V> leftchild, rightchild;

		TreeNode() {
			super();

		}

		TreeNode(U data1, V data2) {
			this.data1 = data1;
			this.data2 = data2;
		}

		public void display() {
			System.out.println("The Data1 is" + data1 + " and data2 is "+ data2);
		}

		public String toString() {
			return data2 + "";
		}

	}
	
	//adding node to tree
	public void addnode(U key,V val){
		
		TreeNode<U, V> newNode=new TreeNode<U,V>(key,val);
		
		if(root==null){
			root=newNode;
		}
		else{
			
			TreeNode<U, V> parentnode,currentnode;
			currentnode=root;
			int res;
			
			while(true){
				parentnode=currentnode;
				res=key.compareTo(currentnode.data1);
				if(res<0){
					// key is lesser than current node thus will go to left subtree
					currentnode=currentnode.leftchild;
					if(currentnode==null){
						parentnode.leftchild=newNode;
						return;
					}
				}
				else{
					//res >=0 thus key will go to right sub tree
					currentnode=currentnode.rightchild;
					if(currentnode ==null){
						parentnode.rightchild=newNode;
						return;
					}
				}
			}
			
		}
		
	}
	
	//inorder traversal of BST
	public void inOrderTraversal(TreeNode<U, V> currentnode){
		
		if(currentnode !=null){
			inOrderTraversal(currentnode.leftchild);
			System.out.print(currentnode.data1 +" "+currentnode.data2+"-->");
			inOrderTraversal(currentnode.rightchild);
			
		}
	}
	
	//pre-order traversal of BST or DFS traversal
	public void preOrderTraversal(TreeNode<U, V> currentnode){
		if(currentnode !=null){
			System.out.print(currentnode.data1 +" "+currentnode.data2+"-->");
			preOrderTraversal(currentnode.leftchild);
			preOrderTraversal(currentnode.rightchild);
			
		}
	}
	
	//post-order traversal of BST
	public void postOrderTraversal(TreeNode<U, V> currentnode){
		if(currentnode !=null){
			postOrderTraversal(currentnode.leftchild);
			postOrderTraversal(currentnode.rightchild);
			System.out.print(currentnode.data1 +" "+currentnode.data2+"-->");
			
		}
	}
	
	//BFS traversal of BST
	public void bfsTraversal(TreeNode<U, V> currentnode){
		Queue <TreeNode> queue1 = new LinkedList<TreeNode>();
		queue1.add(currentnode);
		while(!queue1.isEmpty()){
			TreeNode<U, V> node1=queue1.poll();
			System.out.print(node1.data1+"--> ");
			if(node1.leftchild !=null) queue1.add(node1.leftchild);
			if(node1.rightchild !=null)queue1.add(node1.rightchild);
			
		}
		
	}
	
	
	
	//searching an element/checking contains using iterative method not recursion
	//TC-->O(height), SC-->O(1)
	public boolean contains(U key){
		TreeNode<U, V> currentnode =root;
		
		while(currentnode !=null){
			int res=key.compareTo(currentnode.data1);
			if(res<0)
				currentnode=currentnode.leftchild;
			else if(res >0)
				currentnode=currentnode.rightchild;
			else{
				System.out.println("\n\nThe element found in the tree where data1 is "+currentnode.data1+" and data2 is "+currentnode.data2);
				return true;
			}
			
		}

	return false;
	}
	
	public static void main(String [] args){
		MyBST1<Integer,String> theTree=new MyBST1<Integer,String>();

		Random r= new Random();
		int total=r.nextInt(10-1)+5;
		System.out.println("Total Node count is :"+total);
		System.out.println("The input series for tree is :");
		int temp2;
		for(int i=1;i<=total;i++){
			temp2=r.nextInt(100-1)+1;
			theTree.addnode(temp2, "Testnode"+i);
			System.out.print(temp2 +" Testnode"+i+"-->");
		}
		
		System.out.println("\n\nThe preorder traversal of Binary search tree is");
		theTree.preOrderTraversal(theTree.root);
		
		System.out.println("\n\nThe Inorder traversal of Binary search tree is");
		theTree.inOrderTraversal(theTree.root);
		
		System.out.println("\n\nBFS traversal of Binary search tree is");
		theTree.bfsTraversal(theTree.root);
		
		/*	
		System.out.println("\n\nThe post order traversal of Binary search tree is");
		theTree.postOrderTraversal(theTree.root);
		
		System.out.println("\n\nThe key is available in the tree? "+theTree.contains(5));
		*/

	}
	
}
