package homeWork1.list;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Кастомная реализация ArrayList.
 */
public class CustomArrayList<T> implements CustomList<T> {
    private Object[] elements;
    private int size;

    /**
     * Конструктор - создание нового объекта CustomArrayList с начальным размером массива.
     */
    public CustomArrayList() {
        elements = new Object[10];
        size = 0;
    }

    @Override
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    @Override
    public void clear() {
        elements = new Object[10];
        size = 0;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        Arrays.sort((T[]) elements, 0, size, comparator);
    }
    /**
     * Увеличение емкости массива при необходимости.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }
    /**
     * Проверка корректности индекса для операций получения и удаления.
     * @param index индекс элемента
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
    }


    @Override
    public int size() {
        return size;
    }
}
