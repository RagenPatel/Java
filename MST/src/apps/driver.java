package apps;

import java.io.IOException;

import structures.Graph;
import structures.Vertex;
import apps.PartialTree.Arc;

public class driver {

	public static void main(String[] args) 
	throws IOException{
		// TODO Auto-generated method stub
		
		System.out.print("Enter name of file: ");
		/*
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		System.out.println(input);
		*/
		Graph gh = new Graph("graph2.txt");
		gh.print();
		
		MST.initialize(gh);
		
		PartialTreeList a = MST.initialize(gh);
		
		MST.execute(gh, a);
		
		
		//Vertex v = gh.vertices[0].getRoot();
		//System.out.println("Vertex v: "+a.toString());
		//a.removeTreeContaining(v);
		
		
		//------------------------------------------------------------------------------------------------
		//System.out.println(gh.vertices[8]);
		//Vertex.Neighbor temp = gh.vertices[0].neighbors;
		/*
		System.out.println(temp.vertex);
		System.out.println(gh.vertices[0].getRoot());
		System.out.println(temp.weight);
		temp = temp.next;
		System.out.println(temp.vertex);
		System.out.println(temp.weight);
		temp = temp.next;
		System.out.println(temp.vertex);
		*/
		
		
		//Make arc and add to partialTree for iterator
		/*
		PartialTree tr = new PartialTree(gh.vertices[0]);
		PartialTree.Arc b = new Arc(gh.vertices[0],temp.vertex,temp.weight);
		while(temp != null){
			b = new Arc(gh.vertices[0],temp.vertex,temp.weight);
			tr.getArcs().insert(b);
			temp = temp.next;
		}
		
		
		System.out.println(b.toString());
		System.out.println(tr.getRoot());
		
		PartialTreeList tree = new PartialTreeList();
		tree.append(tr);
		
		//iterator.next for next tree in list
		System.out.println("Iterator: "+tree.iterator().next());
		
		//PartialTree.Arc a = new PartialTree.Arc(gh.vertices[0],temp.vertex,temp.weight);
		
		System.out.println("to string: "+ tr.toString());
		
		
		
	
		while(temp!=null){
			System.out.println(gh.vertices[0].parent + " -> "+temp.vertex + ", "+temp.weight);
			temp = temp.next;
		}
		*/
		
		/*
		ArrayList<Vertex> arr = new ArrayList<Vertex>();
		while(fileReader.hasNextLine()){
			if(fileReader.next().length()<2){
				int k = 0;
				if(k == 0){
					int length = fileReader.nextInt();
				}
				
				for(int i = 0; i<k;i++){
					Vertex vertex = new Vertex(fileReader.nextLine());
					arr[i] = vertex;
					
				}
				k++;
				
			}
		}
		*/
		
		
		
		
	}

}
