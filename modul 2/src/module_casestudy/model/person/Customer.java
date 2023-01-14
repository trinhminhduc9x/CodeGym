package module_casestudy.model.person;

public class Customer extends Person{
    private String typeCustomer;
    private String  addressCustomer;

    public Customer() {
    }

    public Customer(String typeCustomer, String addressCustomer) {
        this.typeCustomer = typeCustomer;
        this.addressCustomer = addressCustomer;
    }

    public Customer(String id, String name, boolean gender, int idNumber, int phoneNumber, String email, String typeCustomer, String addressCustomer) {
        super(id, name, gender, idNumber, phoneNumber, email);
        this.typeCustomer = typeCustomer;
        this.addressCustomer = addressCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString()+
                "typeCustomer='" + typeCustomer + '\'' +
                ", addressCustomer='" + addressCustomer + '\'' +
                '}';
    }
}
