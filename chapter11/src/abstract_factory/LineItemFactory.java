package abstract_factory;

public class LineItemFactory implements ItemFactory{
    @Override
    public LineItem makeLineItem() {
        return new LineItem("고양이");
    }
}
