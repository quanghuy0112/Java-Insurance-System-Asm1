package InsuranceCard;

import Customer.Customer;
import Claim.Claim;
import System.SystemManager;

import java.time.LocalDate;

public class InsuranceCard {
    private String cardNumber;
    private Customer cardHolder;
    private String policyOwner;
    private LocalDate expirationDate;

    public InsuranceCard() {
        this.cardNumber = null;
        this.policyOwner = "Default";
        this.policyOwner = null;
    }

    public InsuranceCard(String cardNumber, String policyOwner) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
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
                ", exiprationDate='" + expirationDate + '\'' +
                '}';
    }
}
