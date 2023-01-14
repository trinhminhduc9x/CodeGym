package casestudy.service.impl.contract;

import casestudy.model.contract.Contract;
import casestudy.model.customer.Customer;
import casestudy.repository.contract.IContractRepository;
import casestudy.repository.customer.ICustomerRepository;
import casestudy.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    IContractRepository repository;

    @Override
    public List<Contract> findListAll() {
        return repository.findAll();
    }

    @Override
    public List<Contract> findListById(Integer id) {
        return null;
    }

    @Override
    public void save(Contract contract) {
        repository.save(contract);
    }

    @Override
    public Contract findById(Integer id) {
        return repository.findById(id).orElse(new Contract());
    }

    @Override
    public void update(Contract contract) {

    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Contract> findPageNameAll(Pageable pageable, String name) {
        return null;
    }

    @Override
    public Page<Contract> findPageAll(Pageable pageable) {
        return repository.findAllByName(pageable);
    }

}
