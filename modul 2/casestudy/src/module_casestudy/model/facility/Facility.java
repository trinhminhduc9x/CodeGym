package module_casestudy.model.facility;

public abstract class Facility {
    private String nameFacility;
    private int areaFacility;
    private int moneyFacility;
    private int maxPerSon;
    private String typeFacility;

    public Facility() {
    }

    public Facility(String nameFacility, int areaFacility, int moneyFacility, int maxPerSon, String typeFacility) {
        this.nameFacility = nameFacility;
        this.areaFacility = areaFacility;
        this.moneyFacility = moneyFacility;
        this.maxPerSon = maxPerSon;
        this.typeFacility = typeFacility;
    }

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public int getAreaFacility() {
        return areaFacility;
    }

    public void setAreaFacility(int areaFacility) {
        this.areaFacility = areaFacility;
    }

    public int getMoneyFacility() {
        return moneyFacility;
    }

    public void setMoneyFacility(int moneyFacility) {
        this.moneyFacility = moneyFacility;
    }

    public int getMaxPerSon() {
        return maxPerSon;
    }

    public void setMaxPerSon(int maxPerSon) {
        this.maxPerSon = maxPerSon;
    }

    public String getTypeFacility() {
        return typeFacility;
    }

    public void setTypeFacility(String typeFacility) {
        this.typeFacility = typeFacility;
    }

    @Override
    public String toString() {
        return "nameFacility='" + nameFacility + '\'' +
                ", areaFacility=" + areaFacility +
                ", moneyFacility=" + moneyFacility +
                ", maxPerSon=" + maxPerSon +
                ", typeFacility='" + typeFacility + '\''
                ;
    }
}
