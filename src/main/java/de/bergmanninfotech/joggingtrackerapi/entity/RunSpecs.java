package de.bergmanninfotech.joggingtrackerapi.entity;

import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;

public class RunSpecs {
    public static Specification<Run> userIdEquals(Long userId) {
        return (r, q, cb) -> {
            if (userId == null) {
                return cb.conjunction();
            } else {
                Join<Run, User> user = r.join(Run_.user);
                return cb.equal(user.get(User_.id), userId);
            }
        };
    }

    public static Specification<Run> startDateTimeGreaterThanOrEqualTo(Instant from) {
        return (r, q, cb) -> {
            if (from == null) {
                return cb.conjunction();
            }
            return cb.greaterThanOrEqualTo(r.get(Run_.startDateTime), from);
        };
    }

    public static Specification<Run> startDateTimeLessThan(Instant to) {
        return (r, q, cb) -> {
            if (to == null) {
                return cb.conjunction();
            }
            return cb.lessThan(r.get(Run_.startDateTime), to);
        };
    }
}
