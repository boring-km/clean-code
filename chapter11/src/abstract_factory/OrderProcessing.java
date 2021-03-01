package abstract_factory;

public class OrderProcessing {

    public LineItem execute(ItemFactory lineItemFactory) {
        return lineItemFactory.makeLineItem(); // 객체 생성 시점은 애플리케이션이 결정한다.
    }
}
