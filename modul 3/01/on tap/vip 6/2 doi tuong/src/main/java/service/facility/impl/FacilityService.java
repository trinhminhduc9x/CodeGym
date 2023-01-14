package service.facility.impl;

import model.facility.Facility;
import repository.facility.IFacilityrepository;
import repository.facility.impl.FacilityRepository;
import service.facility.IFacilityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacilityService implements IFacilityService {
    IFacilityrepository facilityrepository = new FacilityRepository();
    @Override
    public List<Facility> FindAll() {
        return facilityrepository.FindAll();
    }

    @Override
    public boolean addFacility(Facility facility) {
        return facilityrepository.addFacility(facility);
    }

    @Override
    public boolean updateFacility(Facility facility) {
        return facilityrepository.updateFacility(facility);
    }

    @Override
    public boolean deleteFacility(int id) {
        return facilityrepository.deleteFacility(id);
    }

    @Override
    public Facility findById(int id) {
        return facilityrepository.findById(id);
    }

    @Override
    public Map<String, String> checkValidate(Facility facility) {
        Map<String,String>errorMap=new HashMap<>();

//        Kiểm tra tên dịch vụ
        if (!facility.getFacilityName().isEmpty()){
            if (!facility.getFacilityName().matches("^([A-Z0-9]\\w+)+(\\s[A-Z0-9]\\w+)*")) {
                errorMap.put("name","Tên sai định dạng,Tên dịch vụ được phép chứa số. Và các kí" +
                        " tự đầu tiên của mỗi từ phải viết\n" + "hoa.");
            }
        }else {
            errorMap.put("name","Tên dịch vụ không được để trống");
        }
        if (facility.getArea()<=0){
            errorMap.put("area","Area must >0");
        }
        if (facility.getCost()<=0){
            errorMap.put("cost","Cost must >0");
        }
        if (facility.getMaxPeople()<=0){
            errorMap.put("maxPeople","Max People must >0");
        }
        if (facility.getNumberOfFloor()<=0){
            errorMap.put("numberOfFloor","Number OfF loor must >0");
        }
        if (facility.getPoolArea()<=0){
            errorMap.put("poolArea","Pool Area must >0");
        }
        return errorMap;
    }


}
