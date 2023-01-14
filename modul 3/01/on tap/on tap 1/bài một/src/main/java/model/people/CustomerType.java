package model.people;

public class CustomerType {
    int idMember;
    int CMND;
    String nameMember;
    private String DateOfBirth;

    public CustomerType() {
    }

    public CustomerType(int idMember, int CMND, String nameMember, String dateOfBirth) {
        this.idMember = idMember;
        this.CMND = CMND;
        this.nameMember = nameMember;
        DateOfBirth = dateOfBirth;
    }

    public CustomerType(int idMember, String nameMember) {
        this.idMember = idMember;
        this.nameMember = nameMember;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public int getCMND() {
        return CMND;
    }

    public void setCMND(int CMND) {
        this.CMND = CMND;
    }

    public String getNameMember() {
        return nameMember;
    }

    public void setNameMember(String nameMember) {
        this.nameMember = nameMember;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }
}
