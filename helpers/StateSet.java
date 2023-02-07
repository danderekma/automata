package helpers;

import java.util.*;

public class StateSet implements Iterable<String> {
    private Set<String> states;

    public StateSet(String... s) throws Exception {
        if (s.length != 0) {
            states = new HashSet<>(Arrays.asList(s));
        } else {
            throw new Exception("Set of states must be non-empty");
        }
    }

    public Set<String> getStates() {
        return states;
    }

    public boolean addState(String s) {
        return states.add(s);
    }

    public boolean removeState(String s) {
        return states.remove(s);
    }

    public void setStates(String... s) throws Exception {
        if (s.length != 0) {
            states = new HashSet<>(Arrays.asList(s));
        } else {
            throw new Exception("Set of states must be non-empty");
        }
    }

    public boolean containsState(String s) {
        return states.contains(s);
    }

    public Iterator<String> iterator() {
        return states.iterator();
    }

    @Override
    public String toString() {
        return states.toString();
    }
}
