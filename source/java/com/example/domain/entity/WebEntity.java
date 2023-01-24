package com.example.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * JPA entity
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "web_entity")
public class WebEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "web_entity_seq")
    @SequenceGenerator(sequenceName = "web_entity_seq", allocationSize = 1, name = "web_entity_seq")
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name", length = 128, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 200, nullable = false)
    private String lastName;
    @Column(name = "middle_name", length = 200, nullable = false)
    private String middleName;
}
