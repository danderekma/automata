package helpers;

import java.util.*;

public class Alphabet implements Iterable<String> {
    private Set<String> alphabet;

    public Alphabet(String... symbols) throws Exception {
        if (symbols.length != 0) {
            alphabet = new HashSet<>(Arrays.asList(symbols));
        } else {
            throw new Exception("Alphabet must be non-empty");
        }
    }

    public Set<String> getAlphabet() {
        return alphabet;
    }

    public boolean addSymbol(String symbol) {
        return alphabet.add(symbol);
    }

    public boolean removeSymbol(String symbol) {
        return alphabet.remove(symbol);
    }

    public void setAlphabet(String... symbols) throws Exception {
        if (symbols.length != 0) {
            alphabet = new HashSet<>(Arrays.asList(symbols));
        } else {
            throw new Exception("Alphabet must be non-empty");
        }
    }

    public boolean containsSymbol(String symbol) {
        return alphabet.contains(symbol);
    }

    public Iterator<String> iterator() {
        return alphabet.iterator();
    }

    @Override
    public String toString() {
        return alphabet.toString();
    }
}