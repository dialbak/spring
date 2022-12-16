package com.example.demo;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * L'annotation EmbeddedId est appliquée à un champ persistant ou à une propriété d'une classe d'entité ou d'une
 * superclasse mappée pour désigner une clé primaire composite qui est une classe intégrable. La classe intégrable doit
 * être annotée comme Embeddable.
 * <p/>
 * Il ne doit y avoir qu'une seule annotation EmbeddedId et aucune annotation Id lorsque l'annotation EmbeddedId est
 * utilisée
 * <p/>
 * - @MapsId est utilisé pour remplir automatiquement la clé primaire d'une entité enfant si elle a la même clé
 * primaire que celle de l'entité parent. <p/>
 * - @Column et @JoinColumn permettent de faire ce que leurs noms disent, créer simplement des colonnes ou faire des
 * jointures en définissant certains paramètres pour les personnaliser
 */
@Entity(name = "Enrolment")
@Table(name = "enrolment")
public class Enrolment {

    @EmbeddedId
    private EnrolmentId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(
            name = "student_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_student_id_fk"
            )
    )
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(
            name = "course_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_course_id_fk"
            )
    )
    private Course course;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;


    public Enrolment(EnrolmentId id,
                     Student student,
                     Course course,
                     LocalDateTime createdAt) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.createdAt = createdAt;
    }

    public Enrolment(Student student,
                     Course course,
                     LocalDateTime createdAt) {
        this.student = student;
        this.course = course;
        this.createdAt = createdAt;
    }

    public Enrolment() {
    }

    public EnrolmentId getId() {
        return id;
    }

    public void setId(EnrolmentId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
