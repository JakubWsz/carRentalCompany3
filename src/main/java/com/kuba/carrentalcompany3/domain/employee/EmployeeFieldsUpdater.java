package com.kuba.carrentalcompany3.domain.employee;

import com.kuba.carrentalcompany3.domain.UpdateFieldProcess;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.domain.employee.model.EmployeeFieldType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.ContractType;

import java.math.BigDecimal;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public enum EmployeeFieldsUpdater {
    DOMAIN_ID(EmployeeFieldType.DOMAIN_ID, Employee::setDomainId),
    FIRST_NAME(EmployeeFieldType.FIRST_NAME, Employee::setFirstname),
    LAST_NAME(EmployeeFieldType.LAST_NAME, Employee::setLastname),
    ADDRESS_STREET(EmployeeFieldType.ADDRESS_STREET, Employee::updateStreetAddress),
    ADDRESS_POSTAL_CODE(EmployeeFieldType.ADDRESS_POSTAL_CODE, Employee::updatePostalCode),
    ADDRESS_CITY_NAME(EmployeeFieldType.ADDRESS_CITY_NAME, Employee::updateCityName),
    PESEL(EmployeeFieldType.PESEL, Employee::setPesel),
    ACCOUNT_NUMBER(EmployeeFieldType.ACCOUNT_NUMBER, Employee::setAccountNumber),
    SALARY_AMOUNT(EmployeeFieldType.SALARY_AMOUNT,
            (employee, salary) -> employee.setSalaryAmount(new BigDecimal(salary))),
    CONTRACT_TYPE(EmployeeFieldType.CONTRACT_TYPE,
            (employee, contract) -> employee.setContractType(ContractType.valueOf(contract))),
    POSITION(EmployeeFieldType.POSITION, Employee::setPosition),
    OFFICE_ID(EmployeeFieldType.OFFICE_ID, Employee::setOfficeId);


    private final EmployeeFieldType employeeFieldType;
    private final UpdateFieldProcess<Employee> updateFieldProcess;

    EmployeeFieldsUpdater(EmployeeFieldType employeeFieldType, UpdateFieldProcess<Employee> updateFieldProcess) {
        this.employeeFieldType = employeeFieldType;
        this.updateFieldProcess = updateFieldProcess;
    }

    private void update(Employee employee, String value) {
        if (Objects.nonNull(value)) {
            updateFieldProcess.update(employee, value);
        }
    }

    public static void updateAll(Employee employee, Map<EmployeeFieldType, String> fieldUpdates) {
        fieldUpdates.forEach((obj, val) -> getByFieldType(obj).update(employee, val));
    }

    public static EmployeeFieldsUpdater getByFieldType(EmployeeFieldType employeeFieldType) {
        return Stream.of(EmployeeFieldsUpdater.values())
                .filter(employeeFieldsUpdater -> employeeFieldsUpdater.employeeFieldType.equals(employeeFieldType))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
