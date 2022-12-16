package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * <h2>@Repository</h2>
 * modèle de composant utilisé pour fournir un accès aux données, spécialisation de l'annotation
 * "@Component" pour la couche DAO <p>
 *
 * <h2>@Transactional</h2>
 * Spring Transaction est le module spécifique chargé de l'intégration des transactions.
 * <p>
 * Une transaction est définie par un début et une fin qui peut être soit une validation des modifications (commit),
 * soit une annulation des modifications effectuées (rollback). On parle de démarcation transactionnelle pour désigner
 * la portion de code qui doit s’exécuter dans le cadre d’une transaction.<p/>
 *
 * <h2>@Query</h2>
 * Habituellement, les classes de repository doivent effectuer des requêtes personnalisées et plus complexes qui
 * ne sont pas couvertes par les méthodes par défaut fournies par un Spring Data Repository.
 * Dans ce cas, le développeur doit définir ses propres méthodes que Spring doit implémenter lors de la création de
 * l'instance de référentiel. Pour indiquer à Spring ce que ces méthodes doivent faire, l'annotation @Query est
 * utilisée pour les annoter. À l'intérieur de cette annotation doit se trouver une définition de requête exécutée
 * au moment de l'exécution et les résultats renvoyés. <p/>
 */
@Repository
@Transactional(readOnly = true)
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    // Postgres sql
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(
            String email
    );

    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.age >= ?2")
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqual(
            String firstName,
            Integer age
    );

    @Query(value = "SELECT * FROM student WHERE first_name = :firstName AND age >= :age", nativeQuery = true)
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqualNative(
            @Param("firstName") String firstName,
            @Param("age") Integer age
    );

    @Transactional
    @Modifying
    @Query("DELETE FROM Student u WHERE u.id = ?1")
    int deleteStudentById(Long id);

}
