package ru.tasks.task2_25;

public class TheElement {
    private Object value;
    private TheElement next;
    private TheElement previous;

    public TheElement(Object value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public TheElement getNext() {
        return this.next;
    }

    public TheElement getPrevious() {
        return this.previous;
    }

    public Object getValue() {
        return this.value;
    }

    public void setNext(TheElement next) {
        this.next = next;
    }

    public void setPrevious(TheElement previous) {
        this.previous = previous;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
