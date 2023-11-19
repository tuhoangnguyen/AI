package lab_7;

public class Test {
	public static void main(String[] args) {
		GA_NQueenAlgo test = new GA_NQueenAlgo();
		Node node = test.execute();
		node.displayBoard();
	}
}
