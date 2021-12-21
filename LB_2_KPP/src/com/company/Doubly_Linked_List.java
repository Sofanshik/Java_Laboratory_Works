package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class Doubly_Linked_List<T> implements Interface_Doubly_Linked_List<T> {
    // Узлы на голову, хвост.
    private Node head, tail;
    // Размерность списка
    private int size;
    // Конструктор списка
    Doubly_Linked_List() {
        head = tail = null;
        size = 0;
    }

    class Node {

        private T data;// Поля ссылок на след. и пред. узлы
        Node prev, next;// Конструктор узлов
        public Node(final T data, final Node next, final Node prev) {
            this.data = data;
            this.next = next;

            this.prev = prev;
        }
    }

    // Метод добавления элемента в узел.
    @Override
    public void add(T e) {
        final Node current = tail;
        final Node newNode = new Node(e, null, current);
        tail = newNode;
        if (current == null) {
            head = newNode;
        }
        else {
            current.next = newNode;

        }
        size++;
    }

    // Метод вывода элементов на экран.
    @Override
    public String toString() {
        Node current = head;
        String result = "{ ";
        while (current != null) {
            result += current.data;
            result += "; \n\n ";
            current = current.next;
        }
        result += "}";
        return result;
    }
    // Метод очистки списка
    @Override
    public void clear() {
        Node current = head;
        while (current != null) {
            current.data = null;
            Node tmp = current.next;
            current = current.next = current.prev = null;
            current = tmp;
            size--;
        }
        head = tail = null;
    }

    // Метод удадений элемента по индексу
    @Override
    public void removeInd(int index) {
        if (index == 1) {
            head.data = null; head.next.prev = null;
            head = head.next;
        }
        else if (index == size) {
            tail.data = null;
            tail.prev.next = null;
            tail = tail.prev;
        }
        else if (index > 1 && index < size) {
            Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        current.data = null;
        current.next.prev = current.prev;
        current.prev.next = current.next;
        current.next = current.prev = null;
        }
        else
            System.out.println("Wrong index!!");
        size--;
        }


    public boolean removeEl(Object e) {
        int count = 1;
        Node current = head;
        while (current != null) {
            if (current.data == e) {
                removeInd(count);
                return true;
            }
            current = current.next;
            count++;

        }
        return false;
    }

    // Метод получения элемента по индексу.
    @Override
    public T showEl(int index) {
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        return current.data;
    }

    // метод возврата колекции в виде массива.
    @Override
    public Object[] toArray() {
        Object []array = new Object[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }


    // Геттер размерности.
    @Override
    public int size() {
        return size;
    }


    // Метод проверяющий содержится ли элемент/параметр в списке.
    @Override
    public boolean contains(Object e) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(e))
            return true;
            current = current.next;
        }
        return false;
    }


    // Создания нового итератора для работы с элементами.
    @Override
    public Iterator<T> iterator() {
        return new IteratorDoublyLinkedList();
        }

    // Вложенный класс-итератор.
    private class IteratorDoublyLinkedList implements Iterator<T> {
        int index;
        boolean next_false = false;
        boolean remove_true = false;

        @Override
        public boolean hasNext() {
            return index < size;
        }
        @Override
        public T next() {
            if (hasNext()) {
                next_false = true;
                return showEl(index++);
            }

            throw new NoSuchElementException();
        }

        public void remove() {
            if (!next_false || remove_true) {
                throw new IllegalStateException(); // исключение
            }
            removeInd(index);
            next_false = false;
        }
    }
}
