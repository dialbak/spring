package com.example.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Une interface n'a pas de propriété, elle contient que des méthodes qui vont être implémentées dans les
 * classes enfants qui vont implémenter l'interface, <p>
 * extends l'interface CrudRepository permet d'avoir plusieurs méthodes comme (save, count, delete)
 */
public interface StudentIdCardRepository extends CrudRepository<StudentIdCard, Long> {

}
