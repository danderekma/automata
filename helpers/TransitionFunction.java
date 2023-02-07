package helpers;

import java.util.*;
import java.util.Map.Entry;

public class TransitionFunction {
    private final Map<List<String>, String> delta;

    public TransitionFunction(StateSet q, Alphabet sigma, String... mappings) throws Exception {
        delta = new HashMap<>();

        for (String state : q) {
            for (String symbol : sigma) {
                delta.put(new ArrayList<>(Arrays.asList(state, symbol)), "");
            }
        }

        for (String mapping : mappings) {
            mapping = mapping.replaceAll("\\s", "");
            if (mapping.contains(",") && mapping.contains("->")) {
                String currState = mapping.substring(0, mapping.indexOf(","));
                String symbol = mapping.substring(mapping.indexOf(",") + 1, mapping.indexOf("-"));
                String nextState = mapping.substring(mapping.indexOf(">") + 1);

                if (q.containsState(currState) && sigma.containsSymbol(symbol) && q.containsState(nextState)) {
                    delta.put(new ArrayList<>(Arrays.asList(currState, symbol)), nextState);
                } else {
                    throw new Exception("Mapping must include valid currState, symbol, and nextState");
                }
            } else {
                throw new Exception(
                        "Transition function mapping must be of the format \"currState, symbol -> nextState\"");
            }
        }

        for (Entry<List<String>, String> mapping : delta.entrySet()) {
            if (mapping.getValue().equals("")) {
                throw new Exception("Transition function is undefined for (" + mapping.getKey().get(0) + ", "
                        + mapping.getKey().get(1) + ")");
            }
        }
    }

    public String getNextState(String currState, String symbol) {
        return delta.get(new ArrayList<>(Arrays.asList(currState, symbol)));
    }

    @Override
    public String toString() {
        return delta.toString();
    }
}
