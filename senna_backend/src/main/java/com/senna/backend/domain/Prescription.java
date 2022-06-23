package com.senna.backend.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "prescription")
// class prescription{
//     - Long prescription_id
//     - Long patient_id
//     - Long doctor_id
//     - String prescription_name
//     - Date prescription_date
//     - String prescription_description
//     - String prescription_status
//     - List<drug> drugs
//     }
public class Prescription
{
    @Id
    @SequenceGenerator(name = "prescription_sequence", sequenceName = "prescription_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prescription_sequence")
    @Column(name = "prescription_id", updatable = false)
    private Long prescription_id;

    @Column(name = "prescription_name")
    private String prescription_name;

    @Column(name = "prescription_date")
    private LocalDateTime prescription_date;

    @Column(name = "prescription_description")
    private String prescription_description;

    @Column(name = "prescription_status")
    private String prescription_status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    private List<Drug> drugs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return Objects.equals(prescription_id, that.prescription_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescription_id);
    }
}