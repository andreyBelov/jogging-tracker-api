package de.bergmanninfotech.joggingtrackerapi.entity;

import de.bergmanninfotech.joggingtrackerapi.entity.base.BaseEntity;
import de.bergmanninfotech.joggingtrackerapi.entity.base.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIMEZONE")
    private Instant birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

}
