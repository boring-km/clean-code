package abstract_factory;

import java.util.Objects;

public class LineItem {
    private final String item;

    public LineItem(String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return Objects.equals(item, lineItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}
