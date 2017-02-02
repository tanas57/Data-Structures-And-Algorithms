import java.time.*;
import java.util.Random;
import java.math.*;

public class Tree {
	public String strYour_name = "Muhammet Tayyip MUSLU";
	public long Your_number = 2015510101;
	
public static void main(String [] args){

		int number = 1000; // number of insertion
		int SumSmallerNum = 1000; 
		int [] nums = CreateRDNumber(); // CREATE RANDOM 100.000 NUMBERS
		long st,fn;
		// AVL Tree
		Tree avl = new Tree(); // AVL Tree
		st = System.nanoTime(); // Starting time
		for(int i = 0 ; i < number; i++) avl.insert(nums[i],1);
		fn = System.nanoTime();
		double insert = (fn - st) / 1000000000.0;
		
		Node root = avl.root;
		System.out.println("----  AVL-Tree ----");
		System.out.println("All items were inserted.");
		System.out.println("The time elapsed for the insertion of all items is "+insert+" nanoseconds");
		System.out.println("The result of GETSUMSMALLER for the item with value "+ SumSmallerNum + " is " + avl.SumSmaller(SumSmallerNum));
		System.out.println("The maximum value of all items is " + avl.biggestValue(root));
		System.out.println("The minimum value of all items is " + avl.smallestValue(root));
		st = System.nanoTime();
		System.out.println("The summation of all items is " + avl.SumAllItems(root));
		fn = System.nanoTime();

		double sum = (double)(fn - st) / 1000000000.0; // get sum all items time

		System.out.format("The time elapsed for GETSUM is %f nanoseconds%n",sum);
		//avl.print();
		
		//Augmented AVL Tree
		Tree aug = new Tree(); // Augmented AVL Tree
		
		st = System.nanoTime(); // Starting time
		for(int i = 0 ; i < number; i++) aug.insert(nums[i],0);
		fn = System.nanoTime();
		//aug.setAugment();
		/* INFORMATION
		 * In Insertion process, kind of tree is determined
		 * insert(value,type) => type: 1 => AVL TREE
		 * 						 type: 0 => AUG AVL TREE
		*/ 
		
		insert = (fn - st) / 1000000000.0; // get insertion time
		
		root = aug.root;
		System.out.println("----  Augmented AVL-Tree ----");
		System.out.println("All items were inserted.");
		System.out.println("The time elapsed for the insertion of all items is "+insert+" nanoseconds");
		System.out.println("The result of GETSUMSMALLER for the item with value "+ SumSmallerNum + " is " + aug.SumSmaller(SumSmallerNum));
		System.out.println("The maximum value of all items is " + aug.biggestValue(root));
		System.out.println("The minimum value of all items is " + aug.smallestValue(root));
		st = System.nanoTime();
		System.out.println("The summation of all items is " + aug.SumAVL());
		fn = System.nanoTime();
		
		sum = (double)(fn - st) / 1000000000.0; // get sum all items time
		
		System.out.format("The time elapsed for GETSUM is %f nanoseconds%n",sum);
		
		//aug.printAug();
		//aug.print();
	}
// Create Random Numbers ARRAY
private static int[] CreateRDNumber()
	{
		boolean[] control = new boolean[100000];
		int[] nums = new int[100000];
		Random rnd = new Random();
		for(int i=0; i < 100000; i++){
			int temp = rnd.nextInt(100000);
			if(!control[temp]) { nums[i] = temp; control[temp]=true;}
			else i--;
		}
		return nums;
	}
private Node root;
private long sumAll = 0; 
private long sumSmal = 0;
private long sumAug = 0;
private class Node{
			public Node parent;
			public Node leftC;
			public Node rightC;
			public long value;
			public int balance;
			
			public long aug; // for AUG AVL TREE
			
			Node(int data, int type){
				leftC = null; rightC = null; parent = null;
				if(type == 1) // AVL TREE
				{
					value = data;
				}
				else{ // AUG-AVL TREE
					value = data;
					aug	  = SumSmaller(data); // Get sum small values for AUG AVL Tree
				}
				balance = 0;
			}
}
// Insert to AVL & AUG AVL TREE a new item.
private void insert(int num,int type){
	Node n = new Node (num, type); // Create New Node (type 1: AVL, type 0: AugAVL
	insert(this.root,n); // go recursive func.
	if(type == 0) setAugment(root,num); // recheck augments
}
private void insert(Node parent, Node newest){
			
	if(parent == null){ // first item is added
				this.root = newest;
				//System.out.println("root eklendi");
	}
	else{
		if(parent.value > newest.value) // go left
		{
			if(parent.leftC == null){ // added directly to left
				parent.leftC = newest; // add new node
				newest.parent = parent; // new node becomes root's child
				//System.out.println("sola eklendi");
				// check balance
				checkBalance(parent); // until left is empty
			}
			else{ // control childs
				 insert(parent.leftC,newest); // child check
			}
		}
		else{ // go right
			
			if(parent.rightC == null){ // added directly to left
				 parent.rightC = newest; // add new node
				 newest.parent = parent;
				 //System.out.println("saða eklendi");
				 // check balance
				 checkBalance(parent); // until right is empty
			}
			else{ // control childs
				insert(parent.rightC,newest); // child check
			}
		}
				
	}
}
// Balance Control and Rotations
private void checkBalance(Node n) {
	reBalance(n); // added node's balance is checked
    if (n.balance == -2) { 
        if (height(n.leftC.leftC) >= height(n.leftC.rightC)) 
            n = rightRotate(n);
        else n = leftRightRotate(n);
    }
    else if (n.balance == 2) {
        if (height(n.rightC.rightC) >= height(n.rightC.leftC))
            n = leftRotate(n);
        else n = rightLeftRotate(n);
    }

    if (n.parent != null) {
    	checkBalance(n.parent); // recheck parents
    } else {
        root = n; // Tree's root
    }
}
// Left Rotation
 private Node leftRotate(Node n) {
	 /*
		 * rightý lefte atacam etkilenneler seçilinin > rootu 
		 * 		5
		 * 			6
		 * 		  4	   7
		 * 6 yý left yapsam 6 root olacak 5 6 nýn childi olacak
		 * 
		 */
  Node v = n.rightC; // choosen node's right leaf to v Node
  v.parent = n.parent; // parents relocate
  
  n.rightC = v.leftC;
  
  if(n.rightC!=null) {
   n.rightC.parent=n;
  }
  
  v.leftC = n; 
  n.parent = v;
  
  if(v.parent!=null) {
   if(v.parent.rightC==n) {
    v.parent.rightC = v;
   } else if(v.parent.leftC==n) {
    v.parent.leftC = v;
   }
  }
  // check balance nodes
  reBalance(n);
  reBalance(v);
  
  return v;
 }
// Right Rotate
 private Node rightRotate(Node n) {
  
  Node v = n.leftC;
  v.parent = n.parent;
  
  n.leftC = v.rightC;
  
  if(n.leftC!=null) {
   n.leftC.parent=n;
  }
  
  v.rightC = n;
  n.parent = v;
  
  
  if(v.parent!=null) {
   if(v.parent.rightC==n) {
    v.parent.rightC = v;
   } else if(v.parent.leftC==n) {
    v.parent.leftC = v;
   }
  }
  // check balance nodes
  reBalance(n);
  reBalance(v);
  
  return v;
 }
 // Double Rotation => Left then Right
 private Node leftRightRotate(Node u) {
  u.leftC = leftRotate(u.leftC); // before left rotate
  return rightRotate(u); // then right rotate
 }
// Double Rotation => Right then Left
 private Node rightLeftRotate(Node u) {
  u.rightC = rightRotate(u.rightC); // before right rotate
  return leftRotate(u); // then left rotate
 }
// Calculate deepest of leafs
 private int height(Node n) { // calculate height each leaf
	  if(n==null) {
	   return -1;
	  }
	  
	  if(n.leftC==null && n.rightC==null) {
	   return 0; // has not any child
	  } else if(n.leftC==null) {
	   return 1 + height(n.rightC); // calculate height right leaf
	  } else if(n.rightC==null) {
	   return 1 + height(n.leftC); // calculate height left leaf
	  } else {
	   return 1 + Math.max(height(n.leftC),height(n.rightC)); // choose bigger leaf
	  }
 }
// Balance proccess
 private void reBalance(Node n) {
	  n.balance = height(n.rightC)-height(n.leftC); // Root's balance => Left childs - Right Childs 
}
 // Print the Tree => Inorder
 private void print() {
	 print(root);
 }
 private void print(Node n) {
     if (n != null) {
    	 print(n.leftC);
         System.out.printf("%s ", n.value);
         print(n.rightC);
     }
 }
 // Found searching value's Node
 private Node search(Node n, long val)
 {
	 if(n != null){
		 	if(n.value == val) { /*System.out.println("founded : " + n);*/return n; }
			else if(n.value > val) {search(n.leftC,val);}
			else if(n.value < val) {search(n.rightC,val);}
	 }
	 return null;
 }
 // Get the smallest value
 private long smallestValue(Node n)
 {
	 if(n.leftC != null){
		 return smallestValue(n.leftC);
	 }
	 return n.value;
 }
 // Get the biggest value
 private long biggestValue(Node n)
 {
	 if(n.rightC != null){
		 return biggestValue(n.rightC);
	 }
	 return n.value;
 }
 // Get Smaller Choosen value => Sum 
 public long SumSmaller(long val)
 {
	// a node comes , getsumsmaller him
	 sumSmal = 0;
	 SumSmaller(root, val);
	 return sumSmal;
 }
 private void SumSmaller(Node n ,long val)
 {
	 if(n != null){
		 SumSmaller(n.leftC, val);
		 if(n.value < val) sumSmal += n.value;
		 SumSmaller(n.rightC, val);
	 }
 }
 // Inorder All items SUM
 private long SumAllItems(Node n){
	 if(n != null){
		 SumAllItems(n.leftC);
		 sumAll += n.value;
         SumAllItems(n.rightC);
	 }
	 return sumAll;
 }
 // Additional codes for Augmented AVL TREE
//update augments
private void setAugment(Node n, long val){
		if(n!=null){
			setAugment(n.leftC,val);
			if(val < n.value) n.aug += val;
			//else return;
			setAugment(n.rightC,val);
		}
}
//Print Aug Values Tree => Inorder
private void printAug() {
	System.out.println("Value(Augment)");
	printAug(root);
}
private void printAug(Node n) {
 if (n != null) {
	   printAug(n.leftC);
     System.out.print(n.value + "(" + n.aug + ") ");
     printAug(n.rightC);
 }
}
// SUM AVL - Last right node's key + aug
 private long SumAVL(){
	 Node n = root;
	 while(n.rightC!=null){
		 n = n.rightC;
	 }
	 long count = n.value + n.aug;
	 return count;
 }
}