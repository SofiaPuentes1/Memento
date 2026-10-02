package main;

import caretaker.History;
import memento.Memento;
import originator.Editor;

public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("Shopping list: milk");
        System.out.println("Current content: " + editor.getContent());
        history.saveState(editor.save());
        System.out.println("State saved");

        editor.setContent("Shopping list: milk, eggs, bread");
        System.out.println("Current content: " + editor.getContent());
        history.saveState(editor.save());
        System.out.println("State saved");

        editor.setContent("Shopping list: pizza, soda, chips");
        System.out.println("Current content: " + editor.getContent());

        if (!history.isEmpty()) {
            Memento lastState = history.getLastState();
            editor.restore(lastState);
            System.out.println("State restored");
        } else {
            System.out.println("There are no saved states");
        }
        System.out.println("Current content: " + editor.getContent());

        editor.setContent("Shopping list: milk, eggs, bread, apples");
        System.out.println("Current content: " + editor.getContent());
    }
}