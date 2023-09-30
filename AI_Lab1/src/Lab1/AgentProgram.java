package Lab1;

import Lab1.Environment.LocationState;


public class AgentProgram {

	public Action execute(Percept p) {// location, status
		// TODO
		if (p.getLocationState() == LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		}
//		} else if (p.getAgentLocation() == Environment.LOCATION_A) {
//			return Environment.MOVE_RIGHT;
//		} else if (p.getAgentLocation() == Environment.LOCATION_B) {
//			return Environment.MOVE_LEFT;
//		}
//		return NoOpAction.NO_OP;
			return randomAction(Environment.MOVE_LEFT, Environment.MOVE_RIGHT, Environment.MOVE_UP, Environment.MOVE_DOWN);
	}

	public Action randomAction(Action actionA, Action actionB, Action actionC, Action actionD) {
		int random = 1 + (int) (Math.random() * ((4 - 1) + 1));
		if (random == 1)
			return actionA;
		if (random == 2)
			return actionB;
		if (random == 3)
			return actionC;
		
			return actionD;
		
	}

	@Override
	public String toString() {
		return "AgentProgram []";
	}

}