import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
// import java.util.Scanner;

// interface vaccinater
interface vaccinator{ 
    public void set_Vaccine(int bcg,int p,int r,int m);
    public void return_vaccine(int rbcg,int rp,int rr,int rm);
}
abstract class CW_Detail{
    public abstract void details(String name,int age,String vaccine) throws IOException;
}

 // age exception 
class age_Exception extends Exception{
@Override
public String toString() {
    return "you enter wrong age";
}
}

// center 

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
        try {
            seeVaccine();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void details(String name, int age, String vaccine) throws IOException{
FileWriter cw_record = new FileWriter(vac,true);
cw_record.write(name +" "+age + " "+vaccine +"\n") ; 
cw_record.close();       
    }
}

public class demo_2 {
public static void main(String[] args) throws IOException {

    
    // vac.createNewFile();
    center c1 = new center();
// c1.create_File();
c1.age=3;
c1.vaccinater_data("waseem janyaro", "Keti bunder");
c1.details("name",33 ,"vaccine");

        }
    }
