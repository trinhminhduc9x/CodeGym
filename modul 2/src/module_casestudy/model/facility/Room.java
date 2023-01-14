package module_casestudy.model.facility;

public class Room extends Facility{
    private String freeFacility;

    public Room() {
    }

    public Room(String freeFacility) {
        this.freeFacility = freeFacility;
    }

    public Room(String nameFacility, int areaFacility, int moneyFacility, int maxPerSon, String typeFacility, String freeFacility) {
        super(nameFacility, areaFacility, moneyFacility, maxPerSon, typeFacility);
        this.freeFacility = freeFacility;
    }

    public String getFreeFacility() {
        return freeFacility;
    }

    public void setFreeFacility(String freeFacility) {
        this.freeFacility = freeFacility;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                "freeFacility='" + freeFacility + '\'' +
                '}';
    }
}
