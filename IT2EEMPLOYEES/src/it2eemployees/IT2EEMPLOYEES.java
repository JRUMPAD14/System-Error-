package it2eemployees;

import java.util.Scanner;

public class IT2EEMPLOYEES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        IT2EEMPLOYEES emp = new IT2EEMPLOYEES(); 
        
        while (true) {
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            
            switch (action) {
                case 1:
                    emp.addEmployees(conf, sc);
                    break;
                case 2:
                    emp.viewEmployees();
                    break;
                case 3:
                    emp.viewEmployees();
                    emp.updateEmployee(); 
                    break;
                case 4:
                    emp.viewEmployees();
                    emp.deleteEmployee(); 
                    emp.viewEmployees();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid action. Please try again.");
            }
        }
    }

    public void addEmployees(config conf, Scanner sc) {
        System.out.print("First Name: ");
        String fname = sc.next();

        System.out.print("Last Name: ");
        String lname = sc.next();

        System.out.print("Email: ");
        String email = sc.next();

        System.out.print("Position: ");
        String position = sc.next();

        System.out.print("Status: ");
        String status = sc.next();

        String sql = "INSERT INTO tbl_employee (e_fname, e_lname, e_email, e_position, e_status) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, fname, lname, email, position, status);

        System.out.println("Employee added successfully.");
    }

    public void viewEmployees() {
        String qry = "SELECT * FROM tbl_employees";
        String[] hdrs = {"ID", "First Name", "Last Name", "Email", "Status"};
        String[] clms = {"e_id", "e_fname", "e_lname", "e_email", "e_status"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clms);
    }

    public void updateEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to Update: ");
        int id = sc.nextInt();

        System.out.print("Enter new First Name: ");
        String nfname = sc.next();
        System.out.print("Enter new Last Name: ");
        String nlname = sc.next();
        System.out.print("Enter new Email: ");
        String nemail = sc.next();
        System.out.print("Enter new Status: ");
        String nstatus = sc.next();

        String qry = "UPDATE tbl_employees SET e_fname = ?, e_lname = ?, e_email = ?, e_status = ? WHERE e_id = ?";

        config conf = new config();
        conf.updateRecord(qry, nfname, nlname, nemail, nstatus, id);
    }

    public void deleteEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_employees WHERE e_id = ?";

        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}
