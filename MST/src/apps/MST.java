package apps;

import java.util.ArrayList;
import java.util.Iterator;

import structures.Graph;
import structures.MinHeap;
import structures.Vertex;

public class MST {

	/**
	 * Initializes the algorithm by building single-vertex partial trees
	 * 
	 * @param graph Graph for which the MST is to be found
	 * @return The initial partial tree list
	 */
	public static PartialTreeList initialize(Graph graph) {
		/* COMPLETE THIS METHOD */

		PartialTreeList tree = new PartialTreeList();

		for(int i =0; i<graph.vertices.length;i++){

			Vertex.Neighbor temp = graph.vertices[i].neighbors;

			PartialTree pt = new PartialTree(graph.vertices[i]);

			//Add arcs for each verticies 
			/*
			while(temp != null){
				PartialTree.Arc arc = new PartialTree.Arc(graph.vertices[i], temp.vertex , temp.weight);
				pt.getArcs().insert(arc);
				temp = temp.next;
			}
			 */
			tree.append(pt);
		}
		return tree;
	}

	/**
	 * Executes the algorithm on a graph, starting with the initial partial tree list
	 * 
	 * @param graph Graph for which MST is to be found
	 * @param ptlist Initial partial tree list
	 * @return Array list of all arcs that are in the MST - sequence of arcs is irrelevant
	 */
	public static ArrayList<PartialTree.Arc> execute(Graph graph, PartialTreeList ptlist) {

		/* COMPLETE THIS METHOD */

		ArrayList<PartialTree.Arc> list = new ArrayList<PartialTree.Arc>();

		ArrayList<PartialTree.Arc> reportArc = new ArrayList<PartialTree.Arc>();


		Iterator<PartialTree> itr = ptlist.iterator();
		PartialTree temp = itr.next();

		//prints out the list from initialize
		/*
		while(temp!=null){
			System.out.println("execute: \n"+temp.toString());

			if(itr.hasNext()){
				temp = itr.next();	
			}else{
				break;
			}
		}
		 */

		//adds all the arcs to a list
		for(int i=0; i<ptlist.size();i++){

			Vertex.Neighbor check = graph.vertices[i].neighbors;
			PartialTree T = new PartialTree(graph.vertices[i]);
			PartialTree.Arc arc = new PartialTree.Arc(graph.vertices[i], check.vertex, check.weight);
			MinHeap<PartialTree.Arc> heap = new MinHeap<PartialTree.Arc>();

			while(check != null){
				arc = new PartialTree.Arc(graph.vertices[i], check.vertex , check.weight);
				heap.insert(arc);

				check = check.next;
			}	

			for(int k = 0; k<graph.vertices.length;k++){
				//Sorts the list from min length to max adds it to PT List
				while(!heap.isEmpty()){
					list.add(heap.getMin());
					temp.getArcs().insert(heap.getMin());
					heap.deleteMin();
				}
			}

			//Only to check what we have in the partial tree list
			System.out.println("temp tostring: "+temp.toString());




			//gets the minimum from the heap
			/*
			T.getArcs().insert(heap.getMin());
			list.add(heap.getMin());
			 */

			if(itr.hasNext()){
				temp = itr.next();
			}
		}


		//All vertices for the nodes contain arcs in ascending order
		//System.out.println("out: "+temp.toString());



		System.out.println(list.toString());

		Vertex v = temp.getRoot();
		PartialTree T = new PartialTree(v);



		Iterator<PartialTree> it = ptlist.iterator();
		PartialTree pri = it.next();


		//Get min of the arc, and v1 & v2
		PartialTree.Arc priority = pri.getArcs().getMin();

		//Tree 1 (for v1), t2 for tree 2. merge the 2 trees
		Vertex v1 = priority.v1;
		Vertex v2 = priority.v2;

		PartialTree t2 = ptlist.removeTreeContaining(v2);
		PartialTree t1 = ptlist.remove();



		//Merges the 2 lists
		t1.merge(t2);
		pri.getArcs().deleteMin();

		System.out.println("merge: "+t1.toString());

		//append to list
		ptlist.append(t1);

		//check if v1 == v2


		reportArc.add(priority);
		//if(it.hasNext()){
		//	pri = it.next();
		//}else{
		//	break;
		//}

		System.out.println("reportArc to string: "+reportArc.toString());



		//returns ArrayList<PartialTree.Arc> list
		return list;
	}



}

