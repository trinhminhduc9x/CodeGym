package model.facility;

public class Facility {
    private int facilityId;
    private String facilityName;
    private int area;
    private double cost;
    private int maxPeople;
    private int rentTypeId;
    private int facilityTypeId;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloor;
    private String facilityFree;

    public Facility() {

    }

    public Facility(String facility_name, int area, double cost, int max_people, int rent_type_id, int facility_type_id, String standard_room, String description_other_convenience, double pool_area, int number_of_floor, String facility_free) {
        this.facilityName = facility_name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = max_people;
        this.rentTypeId = rent_type_id;
        this.facilityTypeId = facility_type_id;
        this.standardRoom = standard_room;
        this.descriptionOtherConvenience = description_other_convenience;
        this.poolArea = pool_area;
        this.numberOfFloor = number_of_floor;
        this.facilityFree = facility_free;
    }

    public Facility(int facility_id, String facility_name, int area, double cost, int max_people, int rent_type_id, int facility_type_id, String standard_room, String description_other_convenience, double pool_area, int number_of_floor, String facility_free) {
        this.facilityId = facility_id;
        this.facilityName = facility_name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = max_people;
        this.rentTypeId = rent_type_id;
        this.facilityTypeId = facility_type_id;
        this.standardRoom = standard_room;
        this.descriptionOtherConvenience = description_other_convenience;
        this.poolArea = pool_area;
        this.numberOfFloor = number_of_floor;
        this.facilityFree = facility_free;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public int getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(int facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }
}
