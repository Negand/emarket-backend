package com.rvs.emarket.auth.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "permissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(unique = true, nullable = false)
    @Column(name = "code", unique = true, nullable = false)
    private String name;  // <- asegurate de que se llame name

    @Column(name = "description")
    private String description;  // mapeamos la columna description
}
