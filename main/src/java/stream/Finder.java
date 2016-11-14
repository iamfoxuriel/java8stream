package stream;

import java.util.ArrayList;
import java.util.List;

class Finder {
    static <E> List<E>  find(Iterable<E> collection, Matcher<E> m) {
        List<E> result = new ArrayList<>();
        for (E item : collection) {
            if (m.matches(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
