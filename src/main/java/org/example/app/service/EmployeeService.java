package org.example.app.service;

import org.example.app.entity.employee.Employee;
import org.example.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public Optional<Employee> save(Employee employee) {
        return Optional.of(repository.save(employee));
    }

    public Optional<List<Employee>> getAll() {
        return Optional.of(repository.findAll());
    }

    public Employee getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Employee update(Long id, Employee employee) {
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        String position = employee.getPosition();
        String phone = employee.getPhone();
        Optional<Employee> optional = repository.findById(id);
        if (optional.isPresent()) {
            Employee employeeUpdate = optional.get();
            if (firstName != null)
                employeeUpdate.setFirstName(firstName);
            if (lastName != null)
                if (position != null)
                    employeeUpdate.setPosition(position);
            employeeUpdate.setLastName(lastName);
            if (phone != null)
                employeeUpdate.setPhone(phone);
            repository.save(employeeUpdate);
        }
        return repository.findById(id).orElse(null);
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else return false;
    }

    public List<Employee> getByFirstName(String firstName) {
        return repository.findByFirstName(firstName)
                .orElse(Collections.emptyList());
    }

    public List<Employee> getByLastName(String lastName) {
        return repository.findByLastName(lastName)
                .orElse(Collections.emptyList());
    }
}
