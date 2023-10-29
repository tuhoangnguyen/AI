package student;

public class TestAStar {
	public static void main(String[] args) {
		Node s = new Node("S", 6);
		Node b = new Node("B", 4);
		Node a = new Node("A", 4);
		Node c = new Node("C", 4);
		Node d = new Node("D", 3.5);
		Node e = new Node("E", 1);
		Node f = new Node("F", 1);
		Node g = new Node("G", 0);
		
		s.addEdge(b, 3);
		s.addEdge(a, 2);
		a.addEdge(c, 3);
		b.addEdge(d, 3);
		b.addEdge(c, 1);
		c.addEdge(e, 3);
		c.addEdge(d, 1);
		d.addEdge(f, 2);
		f.addEdge(g, 1);
		e.addEdge(g, 2);
		
//		Node s = new Node("S",30);
//		Node b = new Node("B", 25);
//		Node a = new Node("A", 22);
//		Node c = new Node("C", 20);
//		Node d = new Node("D", 10);
//		Node e = new Node("E", 6);
//		Node f = new Node("F", 8);
//		Node h = new Node("H", 16);
//		Node k = new Node("K", 26);
//		Node g1 = new Node("G1", 0);
//		Node g2 = new Node("G2", 0);
//		
//		s.addEdge(b, 8);
//		s.addEdge(k, 6);
//		s.addEdge(b, 8);
//		a.addEdge(d, 15);
//		b.addEdge(a, 7);
//		b.addEdge(c, 11);
//		c.addEdge(e, 12);
//		d.addEdge(g2, 9);
//		e.addEdge(g1, 7);
//		f.addEdge(g1, 10);
//		k.addEdge(a, 13);
//		k.addEdge(h, 10);
//		h.addEdge(s, 9);
//		h.addEdge(f, 7);
//		h.addEdge(g1, 19);
		
//		IInformedSearchAlgo aStar = new AStarSearchAlgo();
//		Node res = aStar.execute(s, g1.getLabel());
//		System.out.println(NodeUtils.printPath(res));
		
		IInformedSearchAlgo greedy = new GreedyBestFirstSearchAlgo();
		Node res = greedy.execute(s, b.getLabel(),"G");
//		Node res = greedy.execute(s, g.getLabel());
		System.out.println(NodeUtils.printPath(res));
		
		task3 task3 = new task3();
		System.out.println(task3.isAdmissibleH(s, "G"));
	}
}
