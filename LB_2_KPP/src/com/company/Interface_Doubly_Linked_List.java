package com.company;
import java.lang.Iterable;


public interface Interface_Doubly_Linked_List<T> extends Iterable<T> {
    // методы, что реализованы в классе DoublyLinkedList.
    void add(T e);
    String toString();
    void clear();
    void removeInd(int index);
    boolean removeEl(Object e);
    T showEl(int index);
    Object[] toArray();
    int size();
    boolean contains(T e);
}
