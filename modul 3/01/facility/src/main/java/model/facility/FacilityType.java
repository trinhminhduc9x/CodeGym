package model.facility;

public class FacilityType {
    private int facilityTypeId;
    private String facilityTypeName;

    public FacilityType() {
    }

    public FacilityType(int facility_type_id, String facility_type_name) {
        this.facilityTypeId = facility_type_id;
        this.facilityTypeName = facility_type_name;
    }

    public int getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(int facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public String getFacilityTypeName() {
        return facilityTypeName;
    }

    public void setFacilityTypeName(String facilityTypeName) {
        this.facilityTypeName = facilityTypeName;
    }
}
