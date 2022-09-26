import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.InputStream;
// import java.util.Scanner;
import java.util.Scanner;



// interface vaccinater
interface vaccinator{ 
    public void set_Vaccine(int bcg,int p,int r,int m);
    public void return_vaccine(int rbcg,int rp,int rr,int rm);
}
abstract class CW_Detail{
    public abstract void details(String child_name,int age,String vaccinename) throws IOException;
}

 // age exception 
class age_Exception extends Exception{
@Override
public String toString() {
    return "you enter wrong age";
}
}

// center class

  class center extends CW_Detail implements vaccinator{
// files name 
File vac = new File("Register.txt");
File f1 = new File("Vaccine file");

String name;
   int age;
   int BCG,PENTA,ROTA,MEASELES;
   public void create_File() throws IOException {
       if(f1.createNewFile())
       {
           System.out.println("File is created");
       }
             else {
           System.out.println("File is not created");
       }
   }

public void vaccinater_data(String name,String area) throws IOException {
    FileWriter vac_recode = new FileWriter(vac,true);
    vac_recode.write("Vaccinater name :"+ name + "  Vaccinated area :" + area + "\n");
vac_recode.close();
    
}
// end of file 
    // age exception 
   public void check_age(int age) throws age_Exception {
       
      if(age<0){throw new age_Exception();} 
     
   }
// for vaccine start vaccine
    @Override
    public void set_Vaccine(int bcg,int p,int r,int m)  {
        this.BCG=bcg;
        this.PENTA=p;
        this.ROTA=r;
        this.MEASELES=m;
    }
       
    @Override
    public void return_vaccine(int rbcg,int rp,int rr,int rm) {
        int re_bcg=BCG-rbcg;
        int re_Rota=ROTA-rr;
        int re_penta=PENTA-rp;
        int re_measeles=MEASELES-rm;

        System.out.println(re_bcg);
        System.out.println(re_Rota);
        System.out.println(re_penta);
        System.out.println(re_measeles);
    
    }

    void seeVaccine() throws IOException{
        FileWriter fw = new FileWriter(f1);
    
            fw.write("BCG"+BCG +"\n");
            fw.write("PENTA"+PENTA +"\n");
            fw.write("ROTA"+ROTA +"\n");
            fw.write("MEASELES"+MEASELES +"\n");
            fw.close();
            
        }
  // end of vaccine method 
    
    @Override
    public void details(String child_name, int age, String vaccinename) throws IOException{
FileWriter cw_record = new FileWriter(vac,true);
cw_record.write(child_name +" "+age + " "+vaccinename +"\n") ; 
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
}

public class demo_2 {
public static void main(String[] args) throws IOException {
    center c1 = new center();
    Scanner sc =new Scanner(System.in);
System.out.println("Enter vaccinater name");
String name = sc.nextLine();
System.out.println("Enter vaccination area");
String area = sc.nextLine();
c1.vaccinater_data(name, area);

System.out.println("Manage vaccination ");
System.out.println("BCG ");
int bcg=sc.nextInt();
System.out.println("Penta");
int p = sc.nextInt();
System.out.println("Rota");
int r= sc.nextInt();
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
      try {
        c1.vaccine_detail();
 
      } catch (Exception e) {
    System.out.println("vaccination file doesnot found");       
    }         
     break;
    case 2:
    try {
        System.out.println("Enter children name ");    
        String child_name = sc.nextLine().toString();
        try {
            System.out.println("Enter age");
    int child_age = sc.nextInt();
    try {
        System.out.println("Enter vaccine type");
        String vaccine = sc.nextLine();
        c1.details(child_name, child_age, vaccine);
                
    } catch (Exception e) {
        System.out.println("Enter wright output");
    }
        } catch (Exception e) {
                    System.out.println("Enter integer");
        }
    } catch (Exception e) {
        
        System.out.println("Enter String ");
    }
    

    
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
} while (con=='y'||con=='Y');
// System.out.println("Enter return vaccine");
// System.out.println("BCG ");
// int rbcg=sc.nextInt();
// System.out.println("Penta");
// int rp = sc.nextInt();
// System.out.println("Rota");
// int rr= sc.nextInt();
// System.out.println("Measeles");
// int rm = sc.nextInt();
// c1.return_vaccine(rbcg, rp, rr, rm);
sc.close();
}
    }
