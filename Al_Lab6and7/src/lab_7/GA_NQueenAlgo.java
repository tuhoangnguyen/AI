package lab_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		int k = 0;
		initPopulation();
		List<Node> newPopulation;
		while (k < MAX_ITERATIONS) {
			newPopulation = new ArrayList<Node>();
			for (int i = 0; i < POP_SIZE; i++) {
				Node x = getParentByRandomSelection();
				Node y = getParentByRandomSelection();
				Node child = reproduce(x, y);
				if (MUTATION_RATE < rd.nextDouble()) {
					mutate(child);
				}
				if (child.getH() == 0)
					return child;
				newPopulation.add(child);
			}
			population = newPopulation;
		}
		Collections.sort(population);
		return population.get(0);
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		int queenX = rd.nextInt(0, Node.N);
		int number = rd.nextInt(0, Node.N);
		node.getState()[queenX].setRow(number);
	}

	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		int number = rd.nextInt(0, 8);
		Node node = new Node();
		node.generateBoard();
		if (number == 0) {
			node = y;
		} else if (number == 7) {
			node = x;
		} else {
			for (int i = 0; i < number; i++) {
				int rowX = x.getState()[i].getRow();
				node.getState()[i].setRow(rowX);
			}

			for (int j = number; j < y.N; j++) {
				int rowY = y.getState()[j].getRow();
				node.getState()[j].setRow(rowY);
			}
		}
		return node;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		int K = 5;
		List<Node> nodes = new ArrayList<Node>();
		for (int i = 0; i < K; i++) {
			int number = rd.nextInt(0, 100);
			Node node = population.get(number);
			int oldNumber = number;
			nodes.add(node);
		}
		return nodes.get(0);

	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		int number = rd.nextInt(0, 100);
		Node node = population.get(number);
		return node;
	}

}
