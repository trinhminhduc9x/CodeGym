package service.People;

import model.people.rentType;

import java.util.List;
import java.util.Map;

public interface IRentTypeService {
    List<rentType> FindAll();
    boolean addrentType(rentType rentType);
    boolean updaterentType(rentType rentType);
    boolean deleterentType(int id);
    rentType findById(int id);
    List<rentType>searchrentrentType(String name, String phone, String email, String customerTypeId);
    Map<String,String> checkValidaterentType(rentType rentType);
}
