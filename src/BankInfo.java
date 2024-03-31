public class BankInfo {
    private String bank;
    private String name;
    private int number;

    public BankInfo(){
        this.bank = "Default";
        this.name = "Default";
        this.number = 0;
    }
    public BankInfo(String bank, String name, int number) {
        this.bank = bank;
        this.name = name;
        this.number = number;
    }
}
