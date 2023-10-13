package com.hello.core.order;

import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {
    @Test
    void createOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.createOrder(1L, "item1", 10000);
    }
}
