
import java.util.ArrayList;
import java.util.List;

public class TopologicalSortDfs {
	
	public static List<Integer> performTopologicalSortDfs(GraphBfs graph, int numberOfVertices) {
		
		List<Integer> visited = new ArrayList<>();
		List<Integer> done = new ArrayList<>();
		List<Integer> inDegrees = graph.getInDegree();
		List<Integer> topologicallySortedList = new ArrayList<>();
		
		for ( int source = 0 ; source < numberOfVertices + 1 ; source++ ) {
			if ( source > 0 ) {
				visited.add(source, 0);
				done.add(source, 0);
			}
			else {
				visited.add(source, null);
				done.add(source, null);
			}
		}

//		System.out.println(visited);
//		System.out.println(done);
		
		List<Integer> sources = new ArrayList<>();
		for (int i = 0 ; i < numberOfVertices ; i++) {
			Integer in = inDegrees.get(i);
			if  (in != null && in == 0 ) {
				sources.add(i);
			}
		}
		
		System.out.println("Vertices with 0 indegree. Treating them as sources");
		System.out.println(sources);
		System.out.println("==============================");
		
		for ( int i = 0 ; i < sources.size() ; i++ ) {
			Integer source = sources.get(i);
			System.out.println("Starting from source = " + source);
			int value = Dfs(source,graph,visited,done,topologicallySortedList); 
			if ( value == -1 ) {
				return null;
			}
			System.out.println("TopologicalList " + topologicallySortedList);
		}
		return topologicallySortedList;
	}
	
	public static int Dfs(Integer source, GraphBfs graph, List<Integer> visited, List<Integer> done, List<Integer> topologicallySortedList) {
		visited.set(source, 1);
		List<List<Integer>> adjacencyList = graph.getAdjacencyList();
		List<Integer> adj = adjacencyList.get(source);
		List<Integer> temp = adj; 
//		System.out.println(adj);	
		int returnVal;
				
		int index = 0;
		while (temp.size() != 0 ) {
			Integer i = temp.remove(index);
//			System.out.println("i = " + i);
			
			if ( done.get(i) == 0 && visited.get(i) == 1 ) {
//				System.out.println("Cycle detected. Topological ordering is not possible for this graph");
				return -1;
			}
			else {				
				returnVal = Dfs(i,graph,visited, done, topologicallySortedList);
				if (returnVal == -1) {
					return -1;
				}
			}
		}
		
		if (temp.size() == 0) {
			done.set(source, 1);
			if (!topologicallySortedList.contains(source)) {
				topologicallySortedList.add(source);
			}
		}
		
//		for (int i = 0 ; i < done.size(); i++ ) {
//			if ( i == 0) {
//				System.out.printf("%d,     ",i);
//			}
//			else {
//				System.out.printf("%d, ",i);
//			}
//		}
//		System.out.println();
//		System.out.println(visited + " v");
//		System.out.println(done + " d");
//		System.out.println("++++++++++++++++++++++");
		
		return source;
	}

}
