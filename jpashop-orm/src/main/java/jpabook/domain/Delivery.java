package jpabook.domain;

import javax.persistence.*;

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;
    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Order order;
}
