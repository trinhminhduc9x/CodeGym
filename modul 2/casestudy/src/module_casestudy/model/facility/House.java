package module_casestudy.model.facility;

public class House extends Facility{
    private String standardFacility;
    private int numberFloors;

    public House() {
    }

    public House(String standardFacility, int numberFloors) {
        this.standardFacility = standardFacility;
        this.numberFloors = numberFloors;
    }

    public House(String nameFacility, int areaFacility, int moneyFacility, int maxPerSon, String typeFacility, String standardFacility, int numberFloors) {
        super(nameFacility, areaFacility, moneyFacility, maxPerSon, typeFacility);
        this.standardFacility = standardFacility;
        this.numberFloors = numberFloors;
    }

    public String getStandardFacility() {
        return standardFacility;
    }

    public void setStandardFacility(String standardFacility) {
        this.standardFacility = standardFacility;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString()+
                "standardFacility='" + standardFacility + '\'' +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
