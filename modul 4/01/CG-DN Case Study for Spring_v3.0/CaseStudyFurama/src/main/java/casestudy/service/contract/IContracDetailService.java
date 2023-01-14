package casestudy.service.contract;

import casestudy.dto.ISumDto;
import casestudy.model.contract.ContractDetail;
import casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContracDetailService extends IGeneralService<ContractDetail> {
    @Override
    List<ContractDetail> findListAll();

    @Override
    List<ContractDetail> findListById(Integer id);

    @Override
    void save(ContractDetail contractDetail);

    @Override
    ContractDetail findById(Integer id);

    @Override
    void update(ContractDetail contractDetail);

    @Override
    void remove(Integer id);

    @Override
    Page<ContractDetail> findPageNameAll(Pageable pageable, String name);

    List<ContractDetail> findListcontractId( Integer contractId);

    List<ISumDto> findListByCustomerId(Integer contractId);

}
