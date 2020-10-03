package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;

public class Program {

	public static void main(String[] args) {
		
		Person person = new Person(null, "Carlos da Silva", "carlos@gmail.com");
		Person person2 = new Person(null, "Joaquim Torres", "joaquim@gmail.com");
		Person person3 = new Person(null, "Ana Maria", "ana@gmail.com");
		
		//Creating entity manager factory with the configurations of database
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.persist(person2);
		entityManager.persist(person3);
		entityManager.getTransaction().commit();
		
		Person person4 = entityManager.find(Person.class, 2);
		System.out.println(person4); 
		
		System.out.println("Pronto");
		
		System.out.println(person);
		System.out.println(person2);
		System.out.println(person3);

		entityManager.close();
		entityManagerFactory.close();
		
	}

}
