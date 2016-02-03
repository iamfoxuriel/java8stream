/**
 * Data with comparable key
 * Created by Jadenz on 2016/2/2.
 */
public class ComparableData<T> {

    private Comparable comparable;

    private T data;

    public ComparableData(Comparable comparable, T data) {
        this.comparable = comparable;
        this.data = data;
    }

    public Comparable getComparable() {
        return comparable;
    }

    public T getData() {
        return data;
    }
}
