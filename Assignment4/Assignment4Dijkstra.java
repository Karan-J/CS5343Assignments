
public class Assignment4Dijkstra {

	public static void main(String[] args) {

		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		Vertex vertexD = new Vertex("D");
		Vertex vertexE = new Vertex("E");
		Vertex vertexF = new Vertex("F");
		Vertex vertexG = new Vertex("G");
		Vertex vertexH = new Vertex("H");
		Vertex vertexI = new Vertex("I");
		Vertex vertexJ = new Vertex("J");

		// a - b,c,d
		vertexA.addEdge(vertexB, 5);
		vertexA.addEdge(vertexC, 1);
		vertexA.addEdge(vertexD, 2);

		// b - c,e,f,g a
		vertexB.addEdge(vertexC, 7);
		vertexB.addEdge(vertexE, 2);
		vertexB.addEdge(vertexF, 4);
		vertexB.addEdge(vertexG, 5);
		vertexB.addEdge(vertexA, 5);

		// c - d,e,i a,b
		vertexC.addEdge(vertexD, 3);
		vertexC.addEdge(vertexE, 6);
		vertexC.addEdge(vertexI, 8);
		vertexC.addEdge(vertexA, 1);
		vertexC.addEdge(vertexB, 7);

		// d - e,i,c a
		vertexD.addEdge(vertexE, 4);
		vertexD.addEdge(vertexI, 9);
		vertexD.addEdge(vertexA, 2);
		vertexD.addEdge(vertexC, 3);

		// e - i,f,h,j c,d,b
		vertexE.addEdge(vertexI, 1);
		vertexE.addEdge(vertexF, 2);
		vertexE.addEdge(vertexH, 4);
		vertexE.addEdge(vertexJ, 1);
		vertexE.addEdge(vertexC, 6);
		vertexE.addEdge(vertexD, 4);
		vertexE.addEdge(vertexB, 2);

		// f - g,h,j b,e
		vertexF.addEdge(vertexG, 3);
		vertexF.addEdge(vertexH, 3);
		vertexF.addEdge(vertexJ, 2);
		vertexF.addEdge(vertexB, 4);
		vertexF.addEdge(vertexE, 2);

		// g - h b,f,
		vertexG.addEdge(vertexH, 4);
		vertexG.addEdge(vertexB, 5);
		vertexG.addEdge(vertexF, 3);

		// h - j f,g,e,
		vertexH.addEdge(vertexJ, 2);
		vertexH.addEdge(vertexF, 3);
		vertexH.addEdge(vertexG, 4);
		vertexH.addEdge(vertexE, 2);

		// i - c,d,e
		vertexI.addEdge(vertexC, 8);
		vertexI.addEdge(vertexD, 9);
		vertexI.addEdge(vertexE, 1);

		// j - e,f,h
		vertexJ.addEdge(vertexE, 1);
		vertexJ.addEdge(vertexF, 2);
		vertexJ.addEdge(vertexH, 2);

		// Considering an undirected graph. Hence the to and from edges have been added
		// for each vertex
		Graph graph = new Graph();

		graph.addVertex(vertexA);
		graph.addVertex(vertexB);
		graph.addVertex(vertexC);
		graph.addVertex(vertexD);
		graph.addVertex(vertexE);
		graph.addVertex(vertexF);
		graph.addVertex(vertexG);
		graph.addVertex(vertexH);
		graph.addVertex(vertexI);
		graph.addVertex(vertexJ);

		System.out.println("Printing the adjacency list of the vertices");
		graph.printVertices(graph);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

		System.out.println("Printing the edges of the graph");
		graph.printEdges(graph);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

		graph.calculateShortestPathToAllVerticesFromSource(graph, vertexA);

		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("Shortest Paths With Distances");

		for (Vertex vertex : graph.vertices) {
			System.out.println(vertex + "'s Path : " + vertex.getShortestPath() + " -> " + vertex
					+ " , Shortest Distance = " + vertex.getDistance());
		}

	}

}
