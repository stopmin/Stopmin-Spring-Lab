package jpa_basic.hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {
    @Id
    private Long id;
    @Column(name = "name", nullable = false)
    private String username;
    private int age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;
    @Lob
    private String description;

    @Transient
    private int temp;

    public Member() {

    }


    public void setId(Long id) {
        this.id = id;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }


}
