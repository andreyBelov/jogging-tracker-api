package de.bergmanninfotech.joggingtrackerapi.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class AuditableEntity {

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIMEZONE")
    @CreatedDate
    protected Instant createdAt;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIMEZONE")
    @LastModifiedDate
    protected Instant lastModifiedAt;

}
