package com.senna.backend.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "Users")
public class User {
    @Id
    @SequenceGenerator(name = "userSequence", sequenceName = "userSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    @Column(name = "userId", updatable = false)
    private Long userId;

    @Column(name = "firstName", nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "lastName", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "CIN", nullable = false, columnDefinition = "TEXT")
    private String CIN;

    @Column(name = "email", nullable = false, unique = true, columnDefinition = "TEXT")
    private String email;

    @Column(name = "birthday", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime birthday;

    @Column(name = "address", nullable = false, columnDefinition = "TEXT")
    private String address;

    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        User user = (User) o;
        return userId != null && Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
