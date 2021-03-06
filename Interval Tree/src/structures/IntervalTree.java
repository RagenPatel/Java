package structures;

import java.util.ArrayList;

/**
 * Encapsulates an interval tree.
 * 
 * @author runb-cs112
 */
public class IntervalTree {

	/**
	 * The root of the interval tree
	 */
	IntervalTreeNode root;

	/**
	 * Constructs entire interval tree from set of input intervals. Constructing the tree
	 * means building the interval tree structure and mapping the intervals to the nodes.
	 * 
	 * @param intervals Array list of intervals for which the tree is constructed
	 */
	public IntervalTree(ArrayList<Interval> intervals) {

		// make a copy of intervals to use for right sorting
		ArrayList<Interval> intervalsRight = new ArrayList<Interval>(intervals.size());
		for (Interval iv : intervals) {
			intervalsRight.add(iv);
		}

		// rename input intervals for left sorting
		ArrayList<Interval> intervalsLeft = intervals;

		// sort intervals on left and right end points
		Sorter.sortIntervals(intervalsLeft, 'l');
		Sorter.sortIntervals(intervalsRight,'r');

		// get sorted list of end points without duplicates
		ArrayList<Integer> sortedEndPoints = Sorter.getSortedEndPoints(intervalsLeft, intervalsRight);

		// build the tree nodes
		root = buildTreeNodes(sortedEndPoints);

		// map intervals to the tree nodes
		mapIntervalsToTree(intervalsLeft, intervalsRight);
	}

	/**
	 * Builds the interval tree structure given a sorted array list of end points.
	 * 
	 * @param endPoints Sorted array list of end points
	 * @return Root of the tree structure
	 */
	public static IntervalTreeNode buildTreeNodes(ArrayList<Integer> endPoints) {
		// COMPLETE THIS METHOD
		Queue<IntervalTreeNode> treeQ = new Queue<IntervalTreeNode>();
		
		
		//enqueue nodes to a Q from the input file
		for(int i = 0; i < endPoints.size();i++){
			float info = (float)endPoints.get(i);
			IntervalTreeNode node = new IntervalTreeNode(info, info, info);
			treeQ.enqueue(node);
		}

		int Qsize = 0;
		while(treeQ.size()!=0){

			Qsize = treeQ.size();

			if(Qsize ==1){
				IntervalTreeNode node = treeQ.dequeue();
				return node;
			}


			//split the nodes into an equal tree with left and right children
			int temp = Qsize;

			while(temp > 1){
				IntervalTreeNode tree1 = treeQ.dequeue();
				IntervalTreeNode tree2 = treeQ.dequeue();
				float max = tree1.maxSplitValue;
				float min = tree2.minSplitValue;
				float mid = (max+min)/2;
				IntervalTreeNode node = new IntervalTreeNode(mid, tree1.minSplitValue, tree2.maxSplitValue);
				node.leftChild = tree1;
				node.rightChild = tree2;
				treeQ.enqueue(node);
				temp -= 2;
			}
			//if size = 1 enqueue dequeue 
			if(temp==1){
				treeQ.enqueue(treeQ.dequeue());
			}
		 
		}


		// THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE PROGRAM COMPILE
		return null;
	}

	/**
	 * Maps a set of intervals to the nodes of this interval tree. 
	 * 
	 * @param leftSortedIntervals Array list of intervals sorted according to left endpoints
	 * @param rightSortedIntervals Array list of intervals sorted according to right endpoints
	 */
	public void mapIntervalsToTree(ArrayList<Interval> leftSortedIntervals, ArrayList<Interval> rightSortedIntervals) {
		// COMPLETE THIS METHOD
		
		
	}

	/**
	 * Gets all intervals in this interval tree that intersect with a given interval.
	 * 
	 * @param q The query interval for which intersections are to be found
	 * @return Array list of all intersecting intervals; size is 0 if there are no intersections
	 */
	public ArrayList<Interval> findIntersectingIntervals(Interval q) {
		// COMPLETE THIS METHOD


		// THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE PROGRAM COMPILE
		return null;
	}

	/**
	 * Returns the root of this interval tree.
	 * 
	 * @return Root of interval tree.
	 */
	public IntervalTreeNode getRoot() {
		return root;
	}
	
	
}

