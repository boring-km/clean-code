package abstract_factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void name() {
        // given
        ItemFactory factory = new LineItemFactory();    // 객체를 생성할 Factory 클래스에 대한 의존성
        OrderProcessing orderProcessing = new OrderProcessing();    // 실행을 위한 의존성

        // when
        LineItem lineItem = orderProcessing.execute(factory);   // 실행

        // then
        LineItem expected = new LineItem("고양이");

        assertEquals(expected, lineItem);
    }
}