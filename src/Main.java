import java.util.*;

public class Main {
    public static void main(String[] args) {

        SystemManager sys = new SystemManager();
        sys.addInsurance();
        while (true) {
            try {

                System.out.println("Welcome to Insurance Management System!" + "\n"
                        + "1. View all Customer" + "\n"
                        + "2. View all Insurance Card" + "\n"
                        + "3. Add Dependent to Policy Holder" + "\n"
                        + "4. Add Claim to Customer" + "\n"
                        + "5. Update Claim" + "\n"
                        + "6. Remove Claim from Customer" + "\n"
                        + "7. View All Claim of a Customer" + "\n"
                        + "8. View One Claim of a Customer" + "\n"
                        + "9. Exit the Program" + "\n"
                        + "Enter your Choice: ");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("All of Customer: ");
                    sys.viewAllPolicyHolder();
                    sys.viewAllDependent();
                } else if (choice == 2) {
                    sys.showAllInsuranceCard();
                    while (true) {
                        System.out.println("1. Update the Expiration Date" + "\n"
                                + "2. Quit" + "\n"
                                + "Enter your Choice: ");
                        int choice1 = scanner.nextInt();
                        if (choice1 == 1) {
                            sys.setExpirationDate();
                        } else if (choice1 == 2) {
                            break;
                        } else {
                            System.out.println("Invalid Value!");
                        }
                    }
                } else if (choice == 3) {
                    sys.viewAllPolicyHolder();
                    sys.addDependentToPolicyHolder();
                } else if (choice == 4) {
                    sys.viewAllPolicyHolder();
                    sys.viewAllDependent();
                    sys.addClaimToCustomer();

                } else if (choice == 5) {
                    while (true) {
                        System.out.println("1. Update Bank Info" + "\n"
                                + "2. Update Exam Date" + "\n"
                                + "3. Update Claim Status" + "\n"
                                + "4. Quit" + "\n"
                                + "Enter your choice: ");
                        int choice2 = scanner.nextInt();
                        if (choice2 == 1) {
                            sys.setBank();
                        } else if (choice2 == 2) {
                            sys.setExamDateToClaim();
                        } else if (choice2 == 3) {
                            sys.setStatus();
                        } else if (choice2 == 4) {
                            break;
                        }
                    }
                } else if (choice == 6) {
                    sys.removeClaimFromCustomer();
                } else if (choice == 7) {
                    sys.viewAllClaim();
                } else if (choice == 8) {
                    sys.viewOneClaim();
                } else if (choice == 9) {
                    System.out.println("End the Program. Have a good day!");
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                sys.scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}