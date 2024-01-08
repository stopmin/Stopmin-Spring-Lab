package jpabook.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "DELIVERY_ID")
    private Order order;
}
