import java.util.List;

public class AdminSystem {

    public static void main(String[] args){

        InsuranceCard insuranceCard1 = new InsuranceCard(1234567781, null, "Rmit", "2022-03-04");

        Customer cus1 = new PolicyHolder("123", "Huy", insuranceCard1);

        Claim claim1 = new Claim(123, cus1, insuranceCard1, "2023-10-01", 500);
        Claim claim2 = new Claim(234, cus1, insuranceCard1, "2024-03-04", 1000);



        cus1.addClaim(claim1);
        cus1.addClaim(claim2);
        cus1.showInfo();
        ClaimOfCustomer Claim1 = new ClaimOfCustomer();
        List<Claim> ClaimList = Claim1.getAllClaim("123");
        for (Claim claim : ClaimList){
            claim.toString();
        }





    }
}
