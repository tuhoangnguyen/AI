package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {
	PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
	List<Node> explored = new ArrayList<>();
	
	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) return current;
			List<Node> children = current.getChildrenNodes();
			for(Node e : children) {
				if(!explored.contains(e) && !frontier.contains(e)) {
					frontier.add(e);
					e.setParent(current);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean starter = false;
		if(root.getLabel().equals(goal)) return root;
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) return current;
			
			if(current.getLabel().equals(start)) {
				frontier.clear();
				current.setParent(null);
			}
			
			explored.add(current);
			List<Node> children = current.getChildrenNodes();
			for(Node e : children) {
				if(!frontier.contains(e)) {
					frontier.add(e);
					e.setParent(current);
				}
			}
		
		}
		return null;
	}

}
