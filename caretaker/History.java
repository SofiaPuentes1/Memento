package caretaker;

import java.util.Stack;
import memento.Memento;

public class History {

    private Stack<Memento> states;

    public History() {
        states = new Stack<Memento>();
    }

    public void saveState(Memento memento) {
        states.push(memento);
    }

    public Memento getLastState() {
        if (states.isEmpty()) {
            return null;
        }
        return states.pop();
    }

    public boolean isEmpty() {
        return states.isEmpty();
    }
}