package com.seanvoeller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seanvoeller.dao.PersonDaoImpl;
import com.seanvoeller.model.Person;

/**
 * App class with main method to test our DAO
 *
 * @author fushumang
 */
public class App {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new
        ClassPathXmlApplicationContext("applicationContext.xml");
    PersonDaoImpl dao = (PersonDaoImpl) context.getBean("personDao");

    Person peter = new Person("Peter", "Sagan");
    Person nasta = new Person("Nasta", "Kuzminova");

    dao.save(peter);
    dao.save(nasta);

    List<Person> persons = dao.getAll();
    for (Person person : persons) {
      System.out.println(person);
    }
    context.close();
  }
}