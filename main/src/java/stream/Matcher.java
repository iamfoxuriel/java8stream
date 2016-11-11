package stream;

@FunctionalInterface
public interface Matcher<E> {
    boolean matches(E e);

    default Matcher<E> and(Matcher<? super E> other) {
        return e -> matches(e) && other.matches(e);
    }

    default Matcher<E> or(Matcher<? super E> other) {
        return e -> matches(e) || other.matches(e);
    }

    default Matcher<E> nagate() {
        return e -> !matches(e);
    }

    default Matcher<E> always(boolean bool) {
        return e -> bool;
    }

}
