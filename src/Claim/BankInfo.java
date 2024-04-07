package Claim;

/**
 * @author <Pham Quang Huy - s3970891>
 */
public class BankInfo {
    private String bank;
    private String name;
    private String number;

    public BankInfo(){
        this.bank = "Default";
        this.name = "Default";
        this.number = "Default";
    }
    public BankInfo(String bank, String name, String number) {
        this.bank = bank;
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Claim.BankInfo{" +
                "bank='" + bank + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
