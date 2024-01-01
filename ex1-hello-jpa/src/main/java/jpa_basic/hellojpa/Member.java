package jpa_basic.hellojpa;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "TEAM_ID")
    private Long teamId;
}
