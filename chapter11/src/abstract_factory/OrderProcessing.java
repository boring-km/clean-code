package abstract_factory;

public class OrderProcessing {

    private final ItemFactory itemFactory;

    public OrderProcessing(ItemFactory itemFactory) {   // DIP 반영
        this.itemFactory = itemFactory;
    }

    public LineItem execute() {
        return itemFactory.makeLineItem(); // 객체 생성 시점은 애플리케이션이 결정한다.
    }
}
