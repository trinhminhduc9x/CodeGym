package module_casestudy.model.facility;

public class Villa extends Facility {
    private String standardFacility;
    private int numberFloors;
    private int areaPool;

    public Villa() {
    }

    public Villa(String standardFacility, int numberFloors, int areaPool) {
        this.standardFacility = standardFacility;
        this.numberFloors = numberFloors;
        this.areaPool = areaPool;
    }

    public Villa(String nameFacility, int areaFacility, int moneyFacility, int maxPerSon, String typeFacility) {
        super(nameFacility, areaFacility, moneyFacility, maxPerSon, typeFacility);
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

    public int getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(int areaPool) {
        this.areaPool = areaPool;
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString() +
                "standardFacility='" + standardFacility + '\'' +
                ", numberFloors=" + numberFloors +
                ", areaPool=" + areaPool +
                '}';
    }
}
