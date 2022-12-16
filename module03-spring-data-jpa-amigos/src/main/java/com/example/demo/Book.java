package com.example.demo;


import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * - @Entity @Table Permet de mapper une entité à une table dans la bdd, va la créer ou la mettre à jour, selon la conf
 * dans application.properties, @Entity dit a hibernate que cette class est une entité <p/>
 * L'annotation @Entity, qui fait partie de javax.persistence.* et marque les classes comme modèles pour les objets de
 * domaine, également appelés entités.<p/>
 * Chaque classe d'entité doit avoir un identifiant unique, également appelé clé primaire. Ce champ est marqué avec @Id. <p/>
 * Les classes annotées avec @Entity sont mappés aux tables de base de données correspondant au nom de la classe, sauf
 * indication contraire à l'aide de l'annotation @Table. <p/>
 * - @Id @SequenceGenerator permet la définition d'une clé primaire <p/>
 * Une décision architecturale a été prise pour regrouper tous les champs liés à l'infrastructure dans cette classe,
 * y compris le champ de clé primaire marqué par @Id et @GeneratedValue, qui permettent la génération automatique de la
 * valeur les champs LocalDate qui sont modifiés lors de l'édition de l'objet ;
 */
@Entity(name = "Book")
@Table(name = "book")
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "book_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    @Column(
            name = "book_name",
            nullable = false
    )
    private String bookName;

    @ManyToOne
    @JoinColumn(
            name = "student_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_book_fk"
            )
    )
    private Student student;

    public Book() {
    }

    public Book(String bookName,
                LocalDateTime createdAt) {
        this.createdAt = createdAt;
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Student getStudent() {
        return student;
    }

    public String getBookName() {
        return bookName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", bookName='" + bookName + '\'' +
                ", student=" + student +
                '}';
    }
}
