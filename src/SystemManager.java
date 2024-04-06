import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemManager {
    static Scanner scanner = new Scanner(System.in);
    static List<PolicyHolder> policyHolderList = FileSystem.readPolicyHolderFile();
    static List<InsuranceCard> insuranceCardList = FileSystem.readInsuranceFile();
    static List<Claim> claimList = FileSystem.readClaimFile();

    public static void addInsuranceCardToCustomer() {
        System.out.println("Enter the CusID: ");
        String cusID = scanner.nextLine();
        boolean foundCustomer = false;
        for (int i = 0; i < policyHolderList.size(); i++) {
            if (cusID.equals(policyHolderList.get(i).getCusID())) {
                foundCustomer = true;
                System.out.println("Enter the InsuranceCard: ");
                String insuranceNumber = scanner.nextLine();

                boolean foundInsuranceNumber = false;

                for (int j = 0; j < insuranceCardList.size(); j++) {
                    if (insuranceNumber.equals(insuranceCardList.get(j).getCardNumber())) {
                        policyHolderList.get(i).addInsuranceCard(insuranceCardList.get(j));
                        insuranceCardList.get(j).setCardHolder(policyHolderList.get(i));
                        policyHolderList.get(i).showInfo();
                        foundInsuranceNumber = true;
                    }
                }
                if (!foundInsuranceNumber) {
                    System.out.println("InsuranceCard with number " + insuranceNumber + " not found.");
                }
            }
        }
        if (!foundCustomer) {
            System.out.println("Customer with ID " + cusID + " not found.");
        }
    }

    public static void addClaimToCustomer() {

        System.out.println("Enter the customer ID you want to add claim: ");
        String cusID = scanner.nextLine();

        boolean foundCustomer = false;

        for (int i = 0; i < policyHolderList.size(); i++) {
            if (cusID.equals(policyHolderList.get(i).getCusID())) {
                foundCustomer = true;

                while (true) {
                    System.out.println("Enter the claim ID you want to add (or type 'quit' to exit): ");
                    String claimID = scanner.nextLine();

                    if (claimID.equals("quit")) {
                        System.out.println("Exiting claim input.");
                        break; // Exit the claim input loop if the user types 'quit'

                    }
                    boolean foundClaim = false;
                    for (int j = 0; j < claimList.size(); j++) {
                        if (claimID.equals(claimList.get(j).getClaimID())) {
                            foundClaim = true;
                            if (policyHolderList.get(i).getInsuranceCard() == null) {
                                System.out.println("Please add the insuranceCard for this customer.");
                                break;
                            }
                            policyHolderList.get(i).addClaim(claimList.get(j));
                            claimList.get(j).setInsuredPerson(policyHolderList.get(i));
                            claimList.get(j).setCardNumber();
                            policyHolderList.get(i).showInfo();
                            System.out.println("Enter the bank: ");
                            String bank = scanner.nextLine();
                            System.out.println("Enter the name: ");
                            String name = scanner.nextLine();
                            System.out.println("Enter the number: ");
                            String number = scanner.nextLine();
                            claimList.get(j).setReceiveBankInfo(new BankInfo(bank, name, number));
                            System.out.println(claimList.get(j));
//                            break; // Exit the claim search loop if claim found
                        }
                    }

                    if (!foundClaim) {
                        System.out.println("Claim with ID " + claimID + " not found.");
                    }
                }

            }
        }
        if (!foundCustomer) {
            System.out.println("Customer with ID " + cusID + " not found.");
        }
    }

    public static void removeClaimFromCustomer() {
        System.out.println("Enter the Customer ID you want to remove claim: ");
        String cusID = scanner.nextLine();

        boolean foundCustomer = false;

        for (int i = 0; i < policyHolderList.size(); i++) {
            if (cusID.equals(policyHolderList.get(i).getCusID())) {
                foundCustomer = true;

                while (true) {
                    System.out.println("Enter the claimID you want to remove (or type 'quit' to exit): ");
                    String claimID = scanner.nextLine();

                    if (claimID.equals("quit")) {
                        System.out.println("Exiting claim input.");
                        break; // Exit the claim input loop if the user types 'quit'

                    }
                    boolean foundClaim = false;
                    for (int j = 0; j < claimList.size(); j++) {
                        if (claimID.equals(claimList.get(j).getClaimID())) {
                            foundClaim = true;

                            policyHolderList.get(i).removeClaim(claimList.get(j));
                            claimList.get(j).setInsuredPerson(policyHolderList.get(i));
                            claimList.get(j).setCardNumber();
                            policyHolderList.get(i).showInfo();

//                            break; // Exit the claim search loop if claim found
                        }
                    }

                    if (!foundClaim) {
                        System.out.println("Claim with ID " + claimID + " not found.");
                    }
                }


            }
        }
        if (!foundCustomer) {
            System.out.println("Customer with ID " + cusID + " not found.");
        }
    }

    public static void setBank() {
        while (true) {
            System.out.println("Enter the claimID you want to set bank (or type 'quit' to exit): ");
            String claimID = scanner.nextLine();

            if (claimID.equals("quit")) {
                System.out.println("Exiting claim input.");
                break; // Exit the claim input loop if the user types 'quit'
            }
            boolean foundClaim = false;
            for (int j = 0; j < claimList.size(); j++) {
                if (claimID.equals(claimList.get(j).getClaimID())) {
                    foundClaim = true;
                    System.out.println("Enter the bank: ");
                    String bank = scanner.nextLine();
                    System.out.println("Enter the name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the number: ");
                    String number = scanner.nextLine();
                    claimList.get(j).setReceiveBankInfo(new BankInfo(bank, name, number));
                    System.out.println(claimList.get(j));
                }
            }

            if (!foundClaim) {
                System.out.println("Claim with ID " + claimID + " not found.");
            }
        }

    }
}

