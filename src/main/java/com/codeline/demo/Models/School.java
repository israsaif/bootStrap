package com.codeline.demo.Models;


import javax.persistence.*;
import java.util.List;


@Entity
public class School extends BaseEntity{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;

        @Column(name = "school_name")
        String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
