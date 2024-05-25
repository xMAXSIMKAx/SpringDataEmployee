package org.example.app.repository;

import org.example.app.entity.employee.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// @Repository - варіант @Component, який повідомляє Spring, що це компонент,
// яким має керувати контейнер IoC.
// Зокрема, репозиторії призначені визначення логіки для шару збереження.
//
// CrudRepository забезпечує CRUD методи.
// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
//
// CrudRepository приймає клас сутності, а також тип даних ID,
// який він повинен використовувати для запиту.
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAll();
    Optional<List<Employee>> findByFirstName(String firstName);
    Optional<List<Employee>> findByLastName(String lastName);
}
