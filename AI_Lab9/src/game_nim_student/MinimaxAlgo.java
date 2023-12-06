package game_nim_student;

public class MinimaxAlgo {
	public void execute(Node node) {
		int v = maxValue(node);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		if (node.isTerminal())
			return 1;
		int v = Integer.MIN_VALUE;
		for (Node subNode : node.getSuccessors()) {
			v = Math.max(v, minValue(subNode));
		}
		return v;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		if (node.isTerminal())
			return 0;
		int v = Integer.MAX_VALUE;
		for (Node subNode : node.getSuccessors()) {
			v = Math.min(v, maxValue(subNode));
		}
		return v;
	}
}
