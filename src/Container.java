
/**
 * Динамический контейнер для хранения целых чисел на основе массива.
 * Поддерживает добавление, удаление и извлечение элементов.
 */
public class Container {
    private int[] _elements;
    private  int _size;
    /**
     * Создает контейнер с начальной емкостью 10 элементов.
     */
    public Container(){
        _elements = new int[10];
        _size = 0;
    }
    /**
     * Создает контейнер с заданной начальной емкостью.
     */
    public Container(int size){
        _size = size;
        _elements = new int[_size];
    }

    public int getSize(){
        return _size;
    }
    /**
     * Добавляет элемент в контейнер.
     * При заполнении текущего массива автоматически увеличивает его размер в на 10.
     *
     * @param newElem целое число для добавления
     */
    public void add(int newElem){
        if(_size == _elements.length){
            resize();
        }
        _elements[_size++] = newElem;
    }
    /**
     * Удаляет элемент по указанному индексу и сдвигает последующие элементы.
     *
     * @param index позиция элемента для удаления (от 0 до size-1)
     * @throws IndexOutOfBoundsException если индекс выходит за границы
     */
    public void remove(int index){
        checkIndex(index);
        System.arraycopy(_elements, index+1, _elements, index, _size - index - 1);
        _size--;
    }
    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index позиция элемента (от 0 до size-1)
     * @return элемент на указанной позиции
     * @throws IndexOutOfBoundsException если индекс выходит за границы
     */
    public int get(int index) {
        checkIndex(index);
        return _elements[index];
    }
    private void checkIndex(int index) {
        if(index < 0 || index >= _size){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    private void resize(){
        int[] newElements = new int[_elements.length + 10];
        System.arraycopy(_elements, 0, newElements, 0, _size);
        _elements = newElements;
    }

}
