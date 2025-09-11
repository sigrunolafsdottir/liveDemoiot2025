package org.example.livedemoiot2025.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    public Customer(String name, String email, Kpi kpi){
        this.name = name;
        this.email = email;
        this.kpi = kpi;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    @OneToOne
    @JoinColumn
    private Kpi kpi;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;
}



