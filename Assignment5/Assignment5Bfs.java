
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Assignment5Bfs {

	public static void main(String[] args) {
		
		System.out.println("Performing BFS Topological Sort on Graph1");
		BfsQ1();
		System.out.println("-------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Performing BFS Topological Sort on Graph2");
		BfsQ2();
		System.out.println("-------------------------------------------------------------------------");
		
	}
	
	public static void printInDegrees(GraphBfs graph) {
		System.out.println("============= Printing in-degrees ==================");
		int i = 1;
		for (Integer j : graph.getInDegree()) {
			if (j != null ) {
				System.out.println(i + " -> " + j);
				i++;
			}
		}
	}
	
	public static void printAdjacencyList(GraphBfs graph) {
		System.out.println("============= Printing adjacency list ==================");
		int i = 1;
		for (List<Integer> list : graph.getAdjacencyList()) {
			if (list != null ) {
				System.out.println(i + " -> " + list);
				i++;
			}
		}
	}
	
	public static void BfsQ1() {
		List<Edge> edges = new ArrayList<>();

		Edge ab = new Edge(1, 2);
		Edge ae = new Edge(1, 5);
		Edge af = new Edge(1, 6);	
		Edge bc = new Edge(2, 3);
		Edge be = new Edge(2, 5);
		Edge bg = new Edge(2, 7);
		Edge cd = new Edge(3, 4);
		Edge de = new Edge(4, 5);
		Edge eg = new Edge(5, 7);
		Edge ef = new Edge(5, 8);
		Edge fe = new Edge(6, 5);
		Edge fh = new Edge(6, 8);
		Edge gd = new Edge(7, 4);
		Edge gh = new Edge(7, 8);
		
		edges.add(ab);
		edges.add(ae);
		edges.add(af);
		edges.add(bc);
		edges.add(be);
		edges.add(bg);
		edges.add(cd);
		edges.add(de);
		edges.add(ef);
		edges.add(eg);
		edges.add(fe);
		edges.add(fh);
		edges.add(gd);
		edges.add(gh);
		
		int numberOfVertices = 8;
		GraphBfs graph = new GraphBfs(edges, numberOfVertices);
		
//		System.out.println(graph.getAdjacencyList());
		printAdjacencyList(graph);
		
		printInDegrees(graph);
		
		List<Integer> topologicallyOrderedList = TopologicalSortBfs.performBfsTopologicalSort(graph, numberOfVertices);
		
		if (topologicallyOrderedList != null) {
			System.out.println("========== BFS Topologically Ordered Graph ==========");
			System.out.println(topologicallyOrderedList);
		}
		else {
			System.out.println("The given graph has at least one cycle. Hence, Topological sorting is not possible");
		}

	}

	
	public static void BfsQ2() {

		Map<Integer,String> map = new HashMap<>();
		map.put(1,"m");
		map.put(2,"n");
		map.put(3,"o");
		map.put(4,"p");
		map.put(5,"q");
		map.put(6,"r");
		map.put(7,"s");
		map.put(8,"t");
		map.put(9,"u");
		map.put(10,"v");
		map.put(11,"w");
		map.put(12,"x");
		map.put(13,"y");
		map.put(14,"z");
		
		System.out.println("Converting the graph of String/Character vertices into numerical vertices for convenient indexing of lists as lists don't support String/Character indices");
		System.out.println("The mappings are as follows:");
		for (Entry<Integer, String> e : map.entrySet()) {
			System.out.println(e.getValue() + " ~> " + e.getKey());
		}
		
		List<Edge> edges = new ArrayList<>();

//		m 	q,r,x
		Edge mq = new Edge(1, 5);
		Edge mr = new Edge(1, 6);
		Edge mx = new Edge(1, 12);
//		n	o,q,u
		Edge no = new Edge(2, 3);
		Edge nq = new Edge(2, 5);
		Edge nu = new Edge(2, 9);
//		o	r,s,v
		Edge or = new Edge(3, 6);
		Edge os = new Edge(3, 7);
		Edge ov = new Edge(3, 10);
//		p	o,s,z
		Edge po = new Edge(4, 3);
		Edge ps = new Edge(4, 7);
		Edge pz = new Edge(4, 14);
//		q	t
		Edge qt = new Edge(5, 8);		
//		r 	u,y
		Edge ru = new Edge(6, 9);
		Edge ry = new Edge(6, 13);
//		s	r
		Edge sr = new Edge(7, 6);
//		t	
//		u 	t
		Edge ut = new Edge(9, 8);
//		v 	x,w
		Edge vw = new Edge(10, 11);
		Edge vx = new Edge(10, 12);
//		w 	z
		Edge wz = new Edge(11, 14);
//		x 
//		y 	v
		Edge yv = new Edge(13, 10);
//		z

		edges.add(mq);
		edges.add(mr);
		edges.add(mx);
		edges.add(no);
		edges.add(nq);
		edges.add(nu);
		edges.add(ov);
		edges.add(os);
		edges.add(or);
		edges.add(po);
		edges.add(ps);
		edges.add(pz);
		edges.add(qt);
		edges.add(ru);
		edges.add(ry);
		edges.add(sr);
		edges.add(ut);
		edges.add(vx);
		edges.add(vw);
		edges.add(wz);
		edges.add(yv);
		
		int numberOfVertices = 14;
		GraphBfs graph = new GraphBfs(edges, numberOfVertices);
		
		printAdjacencyList(graph);
		printInDegrees(graph);
		
		List<Integer> topologicallyOrderedList = TopologicalSortBfs.performBfsTopologicalSort(graph, numberOfVertices);
		
		if (topologicallyOrderedList != null) {
			System.out.println("========== BFS Topologically Ordered Graph ==========");
			System.out.println(topologicallyOrderedList);
			
			List<String> outList = new ArrayList<>();
			
			for(Integer i : topologicallyOrderedList) {
				String s = map.get(i);
				outList.add(s);
			}
			
			System.out.println("Final output: " + outList);
		}
		else {
			System.out.println("The given graph has at least one cycle. Hence, Topological sorting is not possible");
		}

	}

}
