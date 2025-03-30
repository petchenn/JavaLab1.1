public class Container {
    private int[] _elements;
    private  int _size;

    public Container(){
        _elements = new int[10];
        _size = 0;
    }
    public Container(int size){
        _size = size;
        _elements = new int[_size];
    }

    public int getSize(){
        return _size;
    }
    public void add(int newElem){
        if(_size == _elements.length){
            resize();
        }
        _elements[_size++] = newElem;
    }
    public void remove(int index){
        checkIndex(index);
        System.arraycopy(_elements, index+1, _elements, index, _size - index - 1);
        _size--;
    }
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
