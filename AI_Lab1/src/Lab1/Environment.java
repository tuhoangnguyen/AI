package Lab1;

import java.util.ArrayList;
import java.util.List;


public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	public static final String LOCATION_C = "C";
	public static final String LOCATION_D = "D";
	private static int score = 0;
	List<Agent> agents = new ArrayList<>();

	public enum LocationState {
		CLEAN, DIRTY
	}

	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

//	public Environment(LocationState locAState, LocationState locBState) {
//		envState = new EnvironmentState(locAState, locBState);
//	}

	public Environment(LocationState locAState, LocationState locBState, LocationState locCState,
			LocationState locDState) {
		envState = new EnvironmentState(locAState, locBState, locCState, locDState);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		// TODO
		if (envState.getLocationState(location) != null) {
			envState.setAgentLocation(location);
		}
		this.agent = agent;
		agents.add(agent);

	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		if (action == SUCK_DIRT) {
			score = score + 500;
			envState.setLocationState(envState.getAgentLocation(), LocationState.CLEAN);
		} else if (action == MOVE_LEFT) {
			if (envState.getAgentLocation() == LOCATION_A || envState.getAgentLocation() == LOCATION_D) {
				score = score - 100;
				return envState;
			} else if (envState.getAgentLocation() == LOCATION_B) {
				score = score - 10;
				envState.setAgentLocation(LOCATION_A);
				return envState;
			} else {
				score = score - 10;
				envState.setAgentLocation(LOCATION_D);
				return envState;
			}
		} else if (action == MOVE_RIGHT) {
			if (envState.getAgentLocation() == LOCATION_B || envState.getAgentLocation() == LOCATION_C) {
				score = score - 100;
				return envState;
			} else if (envState.getAgentLocation() == LOCATION_A) {
				score = score - 10;
				envState.setAgentLocation(LOCATION_B);
				return envState;
			} else {
				score = score - 10;
				envState.setAgentLocation(LOCATION_C);
				return envState;
			}
		} else if (action == MOVE_UP) {
			if (envState.getAgentLocation() == LOCATION_A || envState.getAgentLocation() == LOCATION_B) {
				score = score - 100;
				return envState;
			} else if (envState.getAgentLocation() == LOCATION_C) {
				score = score - 10;
				envState.setAgentLocation(LOCATION_B);
				return envState;
			} else {
				score = score - 10;
				envState.setAgentLocation(LOCATION_A);
				return envState;
			}

		} else if (action == MOVE_DOWN) {
			if (envState.getAgentLocation() == LOCATION_C || envState.getAgentLocation() == LOCATION_D) {
				score = score - 100;
				return envState;
			} else if (envState.getAgentLocation() == LOCATION_A) {
				score = score - 10;
				envState.setAgentLocation(LOCATION_D);
				return envState;
			} else {
				score = score - 10;
				envState.setAgentLocation(LOCATION_C);
				return envState;
			}

		}
		return envState;
	}
	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		// TODO
		return new Percept(envState.getAgentLocation(), envState.getLocationState(envState.getAgentLocation()));
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
//		Action anAction = agent.execute(getPerceptSeenBy());
		Action anAction1 = agent.execute_fourCell(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction1);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction1);
//
//		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
//				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN))

		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_C) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_D) == LocationState.CLEAN))
			isDone = true;// if both squares are clean, then agent do not need to do any action
		es.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}
}
