import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdminSystem {

    public static void main(String[] args) throws IOException{

        InsuranceCard insuranceCard1 = new InsuranceCard("1234567781", "Rmit", "2022-03-04");

        Customer cus1 = new PolicyHolder("123", "Huy");
        Customer cus2 = new PolicyHolder("345", "Dat");

        BankInfo bank1 = new BankInfo("MB", "Huy", "0112");

        Claim claim1 = new Claim("123", "2023-10-01", 500);
        Claim claim2 = new Claim("234", "2024-03-04", 1000);
//        claim1.setInsuredPerson(cus1);
//        claim2.setInsuredPerson(cus1);
//        claim1.setCardNumber(insuranceCard1);
//        claim2.setCardNumber(insuranceCard1);
        claim1.setReceiveBankInfo(bank1);

        insuranceCard1.setCardHolder(cus1);


//        ClaimOfCustomer claimManager = new ClaimOfCustomer();
        InsuranceOfCustomer insuranceManager = new InsuranceOfCustomer();

        insuranceManager.addInsuranceToCustomer(cus1, insuranceCard1);
        System.out.println(insuranceManager.getInsuranceCard(cus1));



        cus1.addClaim(claim1);
        cus1.addClaim(claim2);
        cus1.showInfo();


//        claimManager.addClaimToCustomer(cus1, claim1);
//        claimManager.addClaimToCustomer(cus1, claim2);




//        List<Claim> claimList = claimManager.getAllClaim(cus1);

//        for (Claim claim : claimList) {
//            System.out.println(claim);
//        }


//        claimManager.removeClaimCustomers(cus1, claim1);
//
//        for (Claim claim : claimList) {
//            System.out.println(claim);
//        }
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the claimID: ");
//
//        String claimID = scanner.nextLine();
//
//        Claim claim = claimManager.getOneClaim(cus1, claimID);
//        System.out.println(claim);

//        try {
//
//        File file = new File("C:\\RMIT Programing\\Java Programming\\asm1\\src\\customer.txt");
//
//        // Check if the file exists
//        if (!file.exists()) {
//            System.out.println("File not found.");
//            return;
//        }
//
//        Scanner scanFile = new Scanner(file);
//
//        Customer[] cusInfos = new Customer[100];
//        int index = 0;
//        while (scanFile.hasNextLine()) {
//            String line = scanFile.nextLine().trim();
//
//            if (line.isEmpty()) {
//                continue;
//            }
//
//            String[] parts = line.split("\\s+", 2);
//            if (parts.length < 2) {
//                continue;
//            }
//            String cusID = parts[0];
//            String cusName = parts[1];
//
//            Customer cusInfo = new PolicyHolder(cusID, cusName);
//            cusInfos[index] = cusInfo;
//            index++;
//        }
//
//        scanFile.close();
//
//        for (int i = 0; i < index; i++) {
////            System.out.println(cusInfos[i]);
//            System.out.println("Enter the CusID: ");
//            Scanner scanCusID = new Scanner(System.in);
//
//            String cusID = scanCusID.nextLine();
//            if(cusID.equals(cusInfos[i].getCusID())){
//                System.out.println(cusInfos[i]);
//            }
//        }
//
//    } catch (Exception e) {
//        // Handle other exceptions
//        e.printStackTrace();
//    }









   }
}
