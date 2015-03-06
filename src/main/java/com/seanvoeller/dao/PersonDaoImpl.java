package com.seanvoeller.dao;

import com.seanvoeller.model.Person;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * DAO implementation for Person entity
 *
 * @author fushumang
 */
@Transactional
public class PersonDaoImpl {

  @PersistenceContext
  private EntityManager em;

  public Long save(Person person) {
    em.persist(person);
    return person.getId();
  }

  public List<Person>getAll() {
    return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
  }
}