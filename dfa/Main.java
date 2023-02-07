import java.util.*;

import helpers.Alphabet;
import helpers.StateSet;
import helpers.TransitionFunction;

public class Main {
    public static void main(String[] args) throws Exception {
        StateSet q = new StateSet("q0", "q1", "q2");
        Alphabet sigma = new Alphabet("a");
        TransitionFunction delta = new TransitionFunction(q, sigma,
                "q0, a -> q1", "q1, a -> q2", "q2, a -> q0");
        String startState = "q0";
        StateSet acceptStates = new StateSet("q0");

        DFA d = new DFA(q, sigma, delta, startState, acceptStates);
        System.out.print(d);
    }
}