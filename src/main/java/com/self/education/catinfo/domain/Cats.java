package com.self.education.catinfo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cats")
public class Cats implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Enumerated(value = STRING)
    @Column(name = "color", nullable = false)
    private Colors color;

    @Column(name = "tail_length")
    private Integer tailLength;

    @Column(name = "whiskers_length")
    private Integer whiskersLength;
}
