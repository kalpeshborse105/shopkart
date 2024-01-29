package com.shope.shopmart.Entities;

// import java.time.Instant;

// import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
// import org.springframework.data.annotation.CreatedDate;
// import org.springframework.data.annotation.LastModifiedDate;
// import org.springframework.data.jpa.domain.support.AuditingEntityListener;
// import org.springframework.data.rest.core.annotation.RestResource;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
// @EntityListeners(AuditingEntityListener.class)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String mobile;
    
    // @CreatedDate
    // private Instant createdAt;

    // @LastModifiedDate
    // private Instant modifiedAt;
    
    // @OneToOne
    // @JoinColumn(name = "address_id")
    // @RestResource(path = "userAddress", rel = "address")
    // private Address address;
    }

    