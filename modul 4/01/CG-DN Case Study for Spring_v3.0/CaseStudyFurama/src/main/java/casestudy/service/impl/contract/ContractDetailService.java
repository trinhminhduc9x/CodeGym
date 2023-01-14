package casestudy.service.impl.contract;

import casestudy.dto.ISumDto;
import casestudy.model.contract.ContractDetail;
import casestudy.repository.contract.IContractDetailRepository;
import casestudy.service.contract.IContracDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContracDetailService {

    @Autowired
    IContractDetailRepository repository;


    @Override
    public List<ContractDetail> findListAll() {
        return repository.findAll();
    }

    @Override
    public List<ContractDetail> findListById(Integer id) {
        return null;
    }

    @Override
    public void save(ContractDetail contractDetail) {
        repository.save(contractDetail);
    }

    @Override
    public ContractDetail findById(Integer id) {
        return null;
    }

    @Override
    public void update(ContractDetail contractDetail) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<ContractDetail> findPageNameAll(Pageable pageable, String name) {
        return null;
    }

    @Override
    public List<ContractDetail> findListcontractId(Integer contractId) {
        return repository.findListById(contractId);
    }

    @Override
    public List<ISumDto> findListByCustomerId(Integer contractId) {
        return repository.findListByCustomerId(contractId);
    }


}
