package game_nim_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();
	private List<Node> childen = new ArrayList<Node>();

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	public List<Node> getChilden() {
		return childen;
	}

	public void setChilden(List<Node> childen) {
		this.childen = childen;
	}

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		List<Node> result = new ArrayList<Node>();
		if (!this.isTerminal()) {
			for (int i = 0; i < data.size(); i++) {
				int number = data.get(i);
				int vl = number / 2;
				for (int j = 0; j < vl; j++) {
					if (j != (number - j)) {
						List<Integer> lists = new ArrayList<Integer>();
						Node newNode = (Node) this.clone();
						newNode.data.remove(i);
						newNode.addAll(lists);
						this.childen.add(newNode);
					}
				}
			}
		}

		return this.childen;
	}

	public Node clone() {
		Node node = new Node();
		List<Integer> dataClone = new ArrayList<Integer>();
		List<Node> nodeClones = new ArrayList<Node>();
		for (int i = 0; i < data.size(); i++) {
			dataClone.add(data.get(i));
		}

		for (int i = 0; i < childen.size(); i++) {
			nodeClones.add(childen.get(i));
		}
		node.setData(dataClone);
		node.setChilden(nodeClones);
		return node;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		boolean result = true;
		Collections.sort(data, DESCOMPARATOR);
//		if (data.get(0) > 2) {
//			result = false;
//		}
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i) > 1) {
				result = false;
				break;
			}
		}
		return result;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
