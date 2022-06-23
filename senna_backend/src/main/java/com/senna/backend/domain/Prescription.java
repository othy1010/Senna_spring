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
// - Long prescriptionId
// - Long patientId
// - Long doctorId
// - String prescriptionName
// - Date prescriptionDate
// - String prescriptionDescription
// - String prescriptionStatus
// - List<drug> drugs
// }
public class Prescription {
    @Id
    @SequenceGenerator(name = "prescriptionSequence", sequenceName = "prescriptionSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prescriptionSequence")
    @Column(name = "prescriptionId", updatable = false)
    private Long prescriptionId;

    @Column(name = "prescriptionName")
    private String prescriptionTitle;

    @Column(name = "prescriptionDate")
    private LocalDateTime prescriptionDate;

    @Column(name = "prescriptionDescription")
    private String prescriptionDescription;

    @Column(name = "prescriptionStatus")
    private String prescriptionStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patientId")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    private List<Drug> drugs;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Prescription that = (Prescription) o;
        return Objects.equals(prescriptionId, that.prescriptionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescriptionId);
    }
}