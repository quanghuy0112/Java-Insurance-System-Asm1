public class InsuranceCard {
    private String cardNumber;
    private Customer cardHolder;
    private String policyOwner;
    private String exiprationDate;

    public InsuranceCard() {
        this.cardNumber = null;
        this.policyOwner = "Default";
        this.policyOwner = null;
    }

//    public InsuranceCard(int cardNumber, Customer cardHolder, String policyOwner, String exiprationDate) {
//        this.cardNumber = cardNumber;
//        this.cardHolder = cardHolder;
//        this.policyOwner = policyOwner;
//        this.exiprationDate = exiprationDate;
//    }

    public InsuranceCard(String cardNumber, String policyOwner, String exiprationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.exiprationDate = exiprationDate;
    }




    public String getCardNumber() {
        return cardNumber;
    }

    public Customer getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Customer cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Override
    public String toString() {
        return "InsuranceCard{" +
                "cardNumber=" + cardNumber +
                ", cardHolder=" + cardHolder.getCusName() +
                ", policyOwner='" + policyOwner + '\'' +
                ", exiprationDate='" + exiprationDate + '\'' +
                '}';
    }
}
