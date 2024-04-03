public class Dependent extends Customer{
    private String relationship;

    public Dependent(){
        super();
        this.relationship = "Default";
    }

//    public Dependent(String cusID, String cusName, InsuranceCard insuranceCard, String relationship) {
//        super(cusID, cusName, insuranceCard);
//        this.relationship = relationship;
//    }

        public Dependent(String cusID, String cusName, String relationship) {
        super(cusID, cusName);
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }
}
