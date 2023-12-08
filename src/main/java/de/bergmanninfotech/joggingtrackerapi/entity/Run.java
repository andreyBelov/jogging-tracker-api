package de.bergmanninfotech.joggingtrackerapi.entity;

import de.bergmanninfotech.joggingtrackerapi.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(indexes = {
        @Index(name = "run_user_id_i", columnList = "user_id"),
})
@Getter
@Setter
public class Run extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "run_user_id_fk"))
    private User user;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIMEZONE")
    private Instant startDateTime;

    @Column(nullable = false)
    private Float startLatitude;

    @Column(nullable = false)
    private Float startLongitude;

    @Column(columnDefinition = "TIMESTAMP WITH TIMEZONE")
    private Instant finishDateTime;

    private Float finishLatitude;

    private Float finishLongitude;

    private Long distance;

    private Float avgSpeed;
}
