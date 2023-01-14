package householdmanagement.service;

import householdmanagement.dtoView.HouseholView;
import householdmanagement.model.Househol;
import householdmanagement.model.Member;
import householdmanagement.model.MemberType;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IHouseholService {
    Page<HouseholView> fildPageAll(Pageable pageable);

    Integer count(String householId);

    List<Member> nameMemBer();

    List<Member> findMemberById(Integer id);

    void save(Househol househol);

    void saveMember(Member member);
    void saveCreate(Househol househol);

    Househol findById(Integer id);

    Member findByIdMeber(Integer id);

    MemberType findByIdMemberType(Integer id);

}
