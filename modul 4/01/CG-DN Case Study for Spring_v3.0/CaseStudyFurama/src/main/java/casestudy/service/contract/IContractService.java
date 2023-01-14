package casestudy.service.contract;

import casestudy.model.contract.Contract;
import casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService extends IGeneralService<Contract> {
    @Override
    List<Contract> findListAll();

    @Override
    List<Contract> findListById(Integer id);

    @Override
    void save(Contract contract);

    @Override
    Contract findById(Integer id);

    @Override
    void update(Contract contract);

    @Override
    void remove(Integer id);

    @Override
    Page<Contract> findPageNameAll(Pageable pageable, String name);

    Page<Contract> findPageAll(Pageable pageable);
}
