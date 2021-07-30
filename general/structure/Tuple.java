package structure;

public class Tuple<T1, T2> {
    private T1 t1;
    private T2 t2;

    public Tuple(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public T1 first() {
        return t1;
    }

    public T2 second() {
        return t2;
    }

    public void setFirst(T1 t1) {
        this.t1 = t1;
    }

    public void setSecond(T2 t2) {
        this.t2 = t2;
    }

    @Override
    public String toString() {
        return "<" + t1 + ", " + t2 + ">";
    }
}
