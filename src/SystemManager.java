import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemManager {
    static Scanner scanner = new Scanner(System.in);
    static List<PolicyHolder> policyHolderList = FileSystem.readPolicyHolderFile();
    static List<Dependent> dependentList = FileSystem.readDependentFile();
    static List<InsuranceCard> insuranceCardList = FileSystem.readInsuranceFile();
    static List<Claim> claimList = FileSystem.readClaimFile();

    public static void addInsurance() {
        for (int i = 0; i < policyHolderList.size(); i++) {
            for (int j = 0; j < insuranceCardList.size(); j++) {
                if (i == j) {
                    policyHolderList.get(i).addInsuranceCard(insuranceCardList.get(j));
                    insuranceCardList.get(j).setCardHolder(policyHolderList.get(i));
//                    policyHolderList.get(i).showInfo();
                }
            }
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
                            claimList.get(i).getDocuments();
                            policyHolderList.get(i).showInfo();
//                           break; // Exit the claim search loop if claim found
                        }
                    }

                    if (!foundClaim) {
                        System.out.println("Claim with ID " + claimID + " not found.");
                    }
                }

            }


        }
        for (int i = 0; i < dependentList.size(); i++) {

            if (cusID.equals(dependentList.get(i).getCusID())) {
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
                            if (dependentList.get(i).getInsuranceCard() == null) {
                                System.out.println("This customer (Dependent) have not added to any policy holder!");
                                break;
                            }
                            dependentList.get(i).addClaim(claimList.get(j));
                            claimList.get(j).setInsuredPerson(dependentList.get(i));
                            claimList.get(j).setCardNumber();
                            dependentList.get(i).showInfo();
//                           break; // Exit the claim search loop if claim found
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
        for (int i = 0; i < dependentList.size(); i++) {
            if (cusID.equals(dependentList.get(i).getCusID())) {
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

                            dependentList.get(i).removeClaim(claimList.get(j));
                            claimList.get(j).setInsuredPerson(dependentList.get(i));
                            claimList.get(j).setCardNumber();
                            dependentList.get(i).showInfo();

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

    public static void viewAllClaim() {
        System.out.println("Enter the CusID: ");
        String cusID = scanner.nextLine();
        for (int i = 0; i < policyHolderList.size(); i++) {
            if (cusID.equals(policyHolderList.get(i).getCusID())) {
                policyHolderList.get(i).showInfo();
            }
        }
        for (int i = 0; i < dependentList.size(); i++) {
            if (cusID.equals(dependentList.get(i).getCusID())) {
                dependentList.get(i).showInfo();
            }
        }
    }

    public static void viewOneClaim() {
        System.out.println("Enter the customer ID you want to view claim: ");
        String cusID = scanner.nextLine();

        boolean foundCustomer = false;

        for (int i = 0; i < policyHolderList.size(); i++) {
            if (cusID.equals(policyHolderList.get(i).getCusID())) {
                foundCustomer = true;

                while (true) {
                    System.out.println("Enter the claim ID you want to view (or type 'quit' to exit): ");
                    String claimID = scanner.nextLine();

                    if (claimID.equals("quit")) {
                        System.out.println("Exiting claim input.");
                        break; // Exit the claim input loop if the user types 'quit'

                    }
                    boolean foundClaim = false;
                    for (int j = 0; j < claimList.size(); j++) {
                        if (claimID.equals(claimList.get(j).getClaimID())) {
                            foundClaim = true;
                            if (claimList.get(j).getInsuredPerson() == null) {
                                System.out.println("Please add this claim to customer first");
                                break;
                            }

                            System.out.println(claimList.get(j));

//                            break; // Exit the claim search loop if claim found
                        }
                    }
                    if (!foundClaim) {
                        System.out.println("Claim with ID " + claimID + " not found.");
                    }
                }

            }
        }  for (int i = 0; i < dependentList.size(); i++) {
            if (cusID.equals(dependentList.get(i).getCusID())) {
                foundCustomer = true;

                while (true) {
                    System.out.println("Enter the claim ID you want to view (or type 'quit' to exit): ");
                    String claimID = scanner.nextLine();

                    if (claimID.equals("quit")) {
                        System.out.println("Exiting claim input.");
                        break; // Exit the claim input loop if the user types 'quit'

                    }
                    boolean foundClaim = false;
                    for (int j = 0; j < claimList.size(); j++) {
                        if (claimID.equals(claimList.get(j).getClaimID())) {
                            foundClaim = true;
                            if (claimList.get(j).getInsuredPerson() == null) {
                                System.out.println("Please add this claim to customer first");
                                break;
                            }

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

    public static void setExamDateToClaim() {
        System.out.println("Enter the claimID you want to set exam date (or type 'quit' to exit): ");
        String claimID = scanner.nextLine();
        for (int j = 0; j < claimList.size(); j++) {
            if (claimID.equals(claimList.get(j).getClaimID())) {
                if (claimList.get(j).getInsuredPerson() == null) {
                    System.out.println("Please add this claim to customer first");
                    break;
                } else {
                    System.out.println("Enter the year: ");
                    int year = scanner.nextInt();
                    System.out.println("Enter the month: ");
                    int month = scanner.nextInt();
                    System.out.println("Enter the day: ");
                    int day = scanner.nextInt();
                    LocalDate date = LocalDate.of(year, month, day);
                    claimList.get(j).setExamDate(date);
                    System.out.println(claimList.get(j));
                }
            }
        }
    }

    public static void setStatus() {
        System.out.println("Enter the claimID you want to set status (or type 'quit' to exit): ");
        String claimID = scanner.nextLine();
        for (int j = 0; j < claimList.size(); j++) {
            if (claimID.equals(claimList.get(j).getClaimID())) {
                if (claimList.get(j).getInsuredPerson() == null) {
                    System.out.println("Please add this claim to customer first");
                    break;
                } else {
                    System.out.println("Enter the status (new, processing, done): ");
                    String status = scanner.nextLine();
                    if (status.equals("new")) {
                        claimList.get(j).setStatus(ClaimStatus.NEW);
                    }
                    if (status.equals("processing")) {
                        claimList.get(j).setStatus(ClaimStatus.PROCESSING);
                    }
                    if (status.equals("done")) {
                        claimList.get(j).setStatus(ClaimStatus.DONE);
                    }
                }

            }
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

    public static void addDependentToPolicyHolder() {
        System.out.println("Enter the policy holder ID you want to add dependent: ");
        String cusID = scanner.nextLine();

        boolean foundCustomer = false;

        for (int i = 0; i < policyHolderList.size(); i++) {

            if (cusID.equals(policyHolderList.get(i).getCusID())) {
                foundCustomer = true;
                while (true) {
                    System.out.println("Enter the dependent ID you want to add (or type 'quit' to exit): ");
                    String claimID = scanner.nextLine();

                    if (claimID.equals("quit")) {
                        System.out.println("Exiting dependent input.");
                        break; // Exit the claim input loop if the user types 'quit'
                    }
                    boolean foundClaim = false;
                    for (int j = 0; j < dependentList.size(); j++) {
                        if (claimID.equals(dependentList.get(j).getCusID())) {
                            foundClaim = true;
                            dependentList.get(j).addInsuranceCard(policyHolderList.get(i).getInsuranceCard());
                            policyHolderList.get(i).addDependent(dependentList.get(j));
                            policyHolderList.get(i).showListOfDependent();
//                            break; // Exit the claim search loop if claim found
                        }
                    }

                    if (!foundClaim) {
                        System.out.println("Dependent with ID " + claimID + " not found.");
                    }
                }

            }

        }
        if (!foundCustomer) {
            System.out.println("Policy holder with ID " + cusID + " not found.");
        }
    }


}
