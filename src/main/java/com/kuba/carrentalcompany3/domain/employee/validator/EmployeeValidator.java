package com.kuba.carrentalcompany3.domain.employee.validator;

import com.kuba.carrentalcompany3.domain.AddressValidator;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.domain.exception.EmployeeExceptionCode;
import com.kuba.carrentalcompany3.lib.Assertion;

public class EmployeeValidator {

    public static void validateEmployee(Employee employee) {
        AddressValidator.validateAddressNotNull(employee.getAddress());
        AddressValidator.validateAddressData(employee.getAddress());
        validateEmployeeFirstnameIsNotNull(employee);
        validateEmployeeLastnameIsNotNull(employee);
        validateEmployeePeselIsNotNull(employee);
        validateEmployeeAccountNumberIsNotNull(employee);
        validateEmployeeSalaryAmountIsNotNull(employee);
        validateEmployeeContractTypeIsNotNull(employee);
        validateEmployeePositionIsNotNull(employee);
    }

    private static void validateEmployeeFirstnameIsNotNull(Employee employee) {
        Assertion.notNull(employee.getFirstname(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_FIRSTNAME_CANT_BE_NULL));
        Assertion.notEmpty(employee.getFirstname(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_FIRSTNAME_CANT_BE_NULL));
    }

    private static void validateEmployeeLastnameIsNotNull(Employee employee){
        Assertion.notNull(employee.getLastname(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_LASTNAME_CANT_BE_NULL));
        Assertion.notEmpty(employee.getLastname(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_LASTNAME_CANT_BE_NULL));
    }

    private static void validateEmployeePeselIsNotNull(Employee employee){
        Assertion.notNull(employee.getPesel(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_PESEL_CANT_BE_NULL));
        Assertion.notEmpty(employee.getPesel(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_PESEL_CANT_BE_NULL));
    }

    private static void validateEmployeeAccountNumberIsNotNull(Employee employee){
        Assertion.notNull(employee.getAccountNumber(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_ACCOUNT_NUMBER_CANT_BE_NULL));
        Assertion.notEmpty(employee.getAccountNumber(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_ACCOUNT_NUMBER_CANT_BE_NULL));
    }

    private static void validateEmployeeSalaryAmountIsNotNull(Employee employee){
        Assertion.notNull(employee.getSalaryAmount(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_SALARY_AMOUNT_CANT_BE_NULL));
    }

    private static void validateEmployeeContractTypeIsNotNull(Employee employee){
        Assertion.notNull(employee.getContractType(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_CONTRACT_TYPE_CANT_BE_NULL));
    }

    private static void validateEmployeePositionIsNotNull(Employee employee){
        Assertion.notNull(employee.getPosition(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_POSITION_CANT_BE_NULL));
        Assertion.notEmpty(employee.getPosition(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_POSITION_CANT_BE_NULL));
    }
}
