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
    public String getBank() {
        return bank;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BankInfo{" +
                "bank='" + bank + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
