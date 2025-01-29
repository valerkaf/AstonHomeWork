package homeWork1.list;

import java.util.Comparator;

public interface CustomList<T> {
    void add(T element);
    void add(int index, T element);
    T get(int index);
    void remove(int index);
    void clear();
    void sort(Comparator<? super T> comparator);
    int size();
}
