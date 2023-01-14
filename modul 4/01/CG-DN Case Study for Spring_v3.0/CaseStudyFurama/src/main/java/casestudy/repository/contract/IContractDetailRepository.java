package casestudy.repository.contract;

import casestudy.dto.ISumDto;
import casestudy.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value = " select * from contract_detail where contract_id = :contractId ", nativeQuery = true)
    List<ContractDetail> findListById(@Param("contractId") Integer contractId);

    @Query(value = " SELECT \n" +
            "\t\tattach_facility.name nameFacility,\n" +
            "\t\tcustomer.name nameCustomer,\n" +
            "\t\tattach_facility.cost costAttachFacility,\n" +
            "\t\tcontract_detail.quantity quantity,\n" +
            "        facility.cost costFacility\n" +
            "          ,SUM((IFNULL(contract_detail.quantity * attach_facility.cost, 0)) + facility.cost) sumMony\n" +
            "            FROM\n" +
            "            customer\n" +
            "             join\n" +
            "            contract \n" +
            "             on customer.id =contract.customer_id\n" +
            "               join\n" +
            "            facility\n" +
            "            on facility.id=contract.facility_id\n" +
            "\t\t join\n" +
            "        contract_detail\n" +
            "        on contract_detail.contract_id=contract.id\n" +
            "          join\n" +
            "               attach_facility \n" +
            "              on attach_facility.id=contract_detail.attach_facility_id\n" +
            "\n" +
            "\t\tWHERE\n" +
            "           customer_id = :customerId\n" +
            "            GROUP BY nameFacility", nativeQuery = true)
    List<ISumDto> findListByCustomerId(@Param("customerId") Integer contractId);


}
