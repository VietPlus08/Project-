package services.impl;

import models.Customer;
import repositories.IBaseRepositories;
import repositories.impl.CustomerRepository;
import services.IBaseServices;
import utils.Valid;

import java.util.List;
import java.util.Map;

public class CustomerServices implements IBaseServices<Customer> {
    IBaseRepositories<Customer> repositories = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public List<Customer> findByCondition(String id) {
        return repositories.findByCondition(id);
    }

    @Override
    public Customer findById(String id) {
        return repositories.findByCondition(id).get(0);
    }

    @Override
    public Map<String, String> create(Customer customer) {
        Map<String,String> error = Valid.getValidation(customer);
        String id = String.valueOf(customer.getId());
        if (repositories.findByCondition(id).isEmpty() && error.isEmpty()){
            repositories.create(customer);
            return error;
        }
        error.put("id","Id had been existed");
        return error;
    }
    @Override
    public void delete(String id) {
        repositories.delete(id);
    }

    @Override
    public Map<String, String> update(Customer customer) {
        Map<String,String> error = Valid.getValidation(customer);
        if (error.isEmpty()){
            repositories.update(customer);
        }
        return error;
    }
}
