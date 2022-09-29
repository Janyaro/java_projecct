import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

abstract class CW_Detail {
    public abstract void set_Vaccine(int bcg, int p, int r, int m) throws IOException;

    public abstract void details(String child_name, int age, String vaccinename) throws IOException;
}

// age exception
class age_Exception extends Exception {
    @Override
    public String toString() {
        return "you enter wrong age";
    }
}

// center class

class center extends CW_Detail {
    // files name
    File vac = new File("Register.txt");
    File f1 = new File("Vaccine file.txt");

    String name;
    int age;
    int BCG, PENTA, ROTA, MEASELES;

    public center() throws IOException {
        f1.createNewFile();

    }

    // Data appent into the File
    public void vaccinater_data(String name, String area) throws IOException {
        FileWriter vac_recode = new FileWriter(vac, true);
        vac_recode.write("Vaccinater name :" + name + "  Vaccinated area :" + area + "\n");
        vac_recode.close();

    }

    // end of file
    // age exception
    public void check_age(int age) throws age_Exception {

        if (age < 0) {
            throw new age_Exception();
        }

    }

    @Override
    public void details(String child_name, int age, String vaccinename) throws IOException {
        FileWriter cw_record = new FileWriter(vac, true);
        cw_record.write(child_name + " " + age + " " + vaccinename + "\n");
        cw_record.close();
    }

    public void vaccine_detail() throws FileNotFoundException {
        FileReader fr = new FileReader(f1);
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            System.out.println(line);
        }
        scan.close();

    }

    public void delete_file(int del_file) {
        switch (del_file) {
            case 1:
                vac.delete();
                break;
            case 2:
                f1.delete();
            default:
                System.out.println("Invalid option");
                break;
        }

    }

    @Override
    public void set_Vaccine(int bcg, int p, int r, int m) throws IOException {
        FileWriter fw = new FileWriter(f1);

        fw.write("BCG  :" + bcg + "\n");
        fw.write("PENTA  :" + p + "\n");
        fw.write("ROTA  :" + r + "\n");
        fw.write("MEASELES  :" + m + "\n");
        fw.close();

    }

}

public class demo_2 {
    public static void main(String[] args) throws IOException {
        center c1 = new center();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter vaccinater name");
        String name = sc.nextLine();
        System.out.println("Enter vaccination area");
        String area = sc.nextLine();
        c1.vaccinater_data(name, area);

        System.out.println("Manage vaccination ");
        System.out.println("BCG ");
        int bcg = sc.nextInt();
        System.out.println("Penta");
        int p = sc.nextInt();
        System.out.println("Rota");
        int r = sc.nextInt();
        System.out.println("Measeles");
        int m = sc.nextInt();
        c1.set_Vaccine(bcg, p, r, m);

        char con;
        do {
            System.out.println("1:see vaccine");
            System.out.println("2: vaccination ");
            System.out.println("3: delete file");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    c1.vaccine_detail();
                    break;
                case 2:
                sc.nextLine();
                        System.out.println("Enter children name ");
                        String child_name = sc.nextLine();
                        System.out.println("Enter age");
                            int child_age = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter vaccine type");
                            
                            String vaccine = sc.nextLine();
                            c1.details(child_name, child_age, vaccine);
                                            break;
                case 3:
                    try {
                        System.out.println("1:Delete data file");
                        System.out.println("2:vaccine file");
                        int del_file = sc.nextInt();
                        c1.delete_file(del_file);

                    } catch (Exception e) {
                        System.out.println("Files not found");
                    }
                default:
                    break;
            }
            System.out.println("Do you want to continue");
            con = sc.next().charAt(0);
        } while (con == 'y' || con == 'Y');
        sc.close();
    }
}
