package lk.ijse.spring.pos.service.impl;

import lk.ijse.spring.pos.dto.CustomerDTO;
import lk.ijse.spring.pos.entity.Customer;
import lk.ijse.spring.pos.repo.CustomerRepo;
import lk.ijse.spring.pos.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CustomerRepo repo;

    @Override
    public void addCustomer(CustomerDTO dto) {
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void deleteCustomer(String id) {
        repo.deleteById(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public CustomerDTO findCustomer(String id) {
        return mapper.map(repo.findById(id), CustomerDTO.class);
    }
}
