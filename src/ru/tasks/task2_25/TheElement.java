package ru.tasks.task2_25;

public class TheElement<T> {
    private T value;
    private TheElement next;
    private TheElement previous;

    public TheElement(T value) {
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

    public T getValue() {
        return this.value;
    }

    public void setNext(TheElement next) {
        this.next = next;
    }

    public void setPrevious(TheElement previous) {
        this.previous = previous;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
