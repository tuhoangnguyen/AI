package student;

public class task3 {
	IInformedSearchAlgo greedy = new GreedyBestFirstSearchAlgo();
	IInformedSearchAlgo astar = new AStarSearchAlgo();

	public boolean isAdmissibleH(Node root, String goal) {
		double h = greedy.execute(root, goal).getH();
		double hStar = astar.execute(root, goal).getG();

		System.out.print("H:" + h + "--------" + "H*:" + hStar);

		return h <= hStar && h >= 0;
	}
}
