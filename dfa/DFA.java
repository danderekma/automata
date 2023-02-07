import java.util.*;

import helpers.Alphabet;
import helpers.StateSet;
import helpers.TransitionFunction;

public class DFA {
    private StateSet q;
    private Alphabet sigma;
    private String startState;
    private StateSet acceptStates;
    private TransitionFunction delta;

    public DFA(StateSet q, Alphabet sigma, TransitionFunction delta, String startState,
            StateSet acceptStates) throws Exception {
        this.q = q;
        this.sigma = sigma;
        this.startState = startState;
        this.acceptStates = acceptStates;
        this.delta = delta;
    }

    public boolean accepts(String input) {
        String currState = startState;
        if (input.length() != 0) {
            for (String i : input.split("")) {
                currState = delta.getNextState(currState, i);
            }
        }
        return acceptStates.containsState(currState);
    }

    public boolean decides(Set<String> language) {
        for (String s : language) {
            if (!accepts(s)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Q = " + q + "\n" + "Σ = " + sigma + "\n" + "δ = " + delta + "\n" + "s = " + startState + "\n" + "F = "
                + acceptStates + "\n";
    }
}
