package Ss10_Dsa.exercise.model;

import java.util.Arrays;
import java.util.Scanner;

public class MyList <E>{
    Scanner scanner = new Scanner(System.in);
    private int size =0;
    private static final int DEFAULT_CAPACITY =10;
    private Object elements[];
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public void ensureCapa() {
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements,newSize);
    }

    public int size(){
        return this.size;
    }
    public void add(int index, E element) {
        if(size == elements.length) {
            ensureCapa();
        }
        System.arraycopy(elements,index,elements,index+1,size-index);
        elements[index]=element;
    }
    public void remove (int index){
        System.arraycopy(elements,index+1,elements,index,size-1-index);
        elements[size-1]=null;
    }
    public E get (int index) {
        if (index > size || index <0) {
            throw new ArrayIndexOutOfBoundsException("index" + index + "size" +size);
        }
        return (E) elements[index];
    }
    public E clone () {
        return (E) elements;
    }
    public boolean contains (E o) {
        for (int i=0;i<size;i++) {
            if (o.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }
    public int indexOf (E o) {
        for (int i=0;i<size;i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }
    public boolean add (E e) {
        if(size == elements.length) {
            ensureCapa();
        }
        elements[size++]=e;
        return true;
    }
    void clear () {
        for (int i =0;i<size;i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(5);
        listInteger.add(6);
        listInteger.add(7);
        listInteger.remove(0);
        System.out.println(Arrays.toString(listInteger.elements));
    }

}
