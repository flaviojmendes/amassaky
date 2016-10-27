package es.flaviojmend.service;

import es.flaviojmend.persistence.entity.Employee;
import es.flaviojmend.persistence.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by flavio.mendes on 23/08/2016.
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void updateEmployee(Employee employee) throws Exception {
        if(employee.getIdEmployee() == null) {
            throw new Exception("Não é possível atualizar um Funcionário com Id nulo.");
        }

        employeeRepository.save(employee);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Iterable<Employee> listEmployees(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

}
