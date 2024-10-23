package org.example;

// Лабораторная работа №1 по языку программирования Java. Выполнил: Фефелов Дмитрий, 3 курс, 3 группа

/**
 * Задача: Создать класс контейнер, позволяющий хранить произвольное количество объектов. Использование встроенных коллекций запрещено.  Задание можно реализовать с помощью массива или связанного списка. Контейнер должен позволять добавлять, извлекать, удалять элементы.
 * Задача будет решаться с помощью массива.
 * Начальными значениями выберу 10, так как это значение считается "стандартным" для массивов
 *
 */

public class Container<T> {
    private Object[] data;
    private int size;

    public Container() {
        this.data = new Object[10];
        this.size = 0;
    }

    /**
     * Далее добавим функцию добавления элемента в массив. Каждый новый элемент будет довавляться в конец массива.
     * @param elem элемент, который будет добавляться в массив.
     */
    public void add(T elem) {
        if (size == data.length) {
            resize();
        }

        data[size] = elem;
        size++;
    }

    /**
     * Важным аспектом является добавление метода get(), для получения элемента из массива и метод remove(), для удаления элемента из массива. Так же внутри этих методов будет осуществляться проверка с помощью IndexOutOfBoundsException.
     * @param index индекс элемента в массиве
     * @return возращение элемента по заданному индексу.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }
        return (T) data[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    /**
     * Здесь зается метод size() для того чтобы вывести количество элементов массива на данный момент времени.
     * @return возвращение количества элементов массива.
     */
    public int size() {
        return size;
    }

    /**
     * Заключительным обозначим метод resize(), с помощью которого и будет производиться увеличение массива.
     */
    private void resize() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

}

