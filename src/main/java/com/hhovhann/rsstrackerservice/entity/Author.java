package com.hhovhann.rsstrackerservice.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Author {
    String name;
    String email;
}
