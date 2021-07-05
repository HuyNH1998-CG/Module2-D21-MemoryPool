import java.util.LinkedList;

public abstract class MemoryPool<T> {
    private LinkedList<T> items = new LinkedList<>();
    public void freeItem(T item){
        items.add(item);
    }

    protected abstract T allocate();

    public T newItem(){
        T out = null;
        if (items.size() == 0){
            out = allocate();
        } else {
            out = items.getFirst();
            items.removeFirst();
        }
        return out;
    }
}
