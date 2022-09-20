// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Scanner;


// interface vaccinator{
//     public void set_Vaccine(int bcg,int p,int r,int m);
//     public void return_vaccine(int rbcg,int rp,int rr,int rm);
//     public void set_Data();
// }
//  // age exception 
// class age_Exception extends Exception{
// @Override
// public String toString() {
//     return "you enter wrong age";
// }
// }
//   class center implements vaccinator{

// File f1 = new File("Vaccine file");
//     String name;
//    int age;
//    int BCG,PENTA,ROTA,MEASELES;
//    public void create_File() throws IOException {
//        if(f1.createNewFile())
//        {
//            System.out.println("File is created");
//        }
//        else {
//            System.out.println("File is not created");
//        }
//    }
    
//    public void detail(String name,int age) throws age_Exception {
       
//       if(age<0){throw new age_Exception();} 
//        else if(age<2){
//            System.out.println("Inject bcg");
//        }
//     else if(age>2&&age<3){
//         System.out.println("Inject penta");
//     }
//     else if(age>3&&age<4){
//         System.out.println("Inject rota");
//     }
//     else if(age>4&&age<5){
//         System.out.println("Inject measeles");
//     }

//    }

//     @Override
//     public void set_Vaccine(int bcg,int p,int r,int m) {
//         this.BCG=bcg;
//         this.PENTA=p;
//         this.ROTA=r;
//         this.MEASELES=m;
//     }
    
//     @Override
//     public void return_vaccine(int rbcg,int rp,int rr,int rm) {
//         int re_bcg=BCG-rbcg;
//         int re_Rota=ROTA-rr;
//         int re_penta=PENTA-rp;
//         int re_measeles=MEASELES-rm;
    
//     }
 
//     @Override
//     public void set_Data() {
         
        
//     }

//     void seeVaccine() throws IOException{
//     FileWriter fw = new FileWriter(f1);

//         fw.write("BCG"+BCG);
//         fw.write("PENTA"+PENTA);
//         fw.write("ROTA"+ROTA);
//         fw.write("MEASELES"+MEASELES);
//         fw.close();
        
//     }
// }
// public class Demo {
// public static void main(String[] args) throws IOException {
// File vac = new File("Register.txt");
//     Scanner sc = new Scanner(System.in);
//     // vac.createNewFile();
//     center c1 = new center();
// // c1.create_File();
//         System.out.println("Welcome");
    
//         System.out.println("Enter you name");
//         String name = sc.nextLine();
//         System.out.println("Enter you area");
//         String area = sc.nextLine();
//          FileWriter vac_recode = new FileWriter(vac);
//          vac_recode.write("Vaccinater name :"+ name + "Vaccinated area :" + area); 
//          System.out.println("Select vaccine quaintity ");
//          System.out.println("BCG");
//          int b= sc.nextInt();
//          System.out.println("penta");
//          int p = sc.nextInt();
//          System.out.println("Rota");
//          int r = sc.nextInt();
//          System.out.println("Measeles");
//          int m = sc.nextInt();
//          c1.set_Vaccine(b, p, r, m);
//          char c;
//         // now proccess is started
//          do {
//          System.out.println("1 for child");
//         System.out.println("2 for pregnent women");
//         int option = sc.nextInt();
//         switch (option) {
//             // children option
//             case 1:
//             System.out.println("Enter name");
//             String child_name = sc.nextLine();
//             System.out.println("Enter age");
//             int age = sc.nextInt();
//                    try {
//                     c1.detail(child_name,age);
//                 } catch (age_Exception e) {
//                     e.toString();
//                 }
//                 break;
//             case 2:
//             // pregnent women 
//             default:
//             System.out.println("You Enter wrong option");
//                 break;
//         }

//         System.out.println("Do you want to continue");
//          c = sc.next().charAt(0);
//     } while (c == 'y');
//     // vac_recode.write("name"+ child_name +);
//          vac_recode.close();
//          System.out.println("Enter return vaccine detail");
//          System.out.println("BCG");
//          int rbcg= sc.nextInt();
//          System.out.println("penta");
//          int rp = sc.nextInt();
//          System.out.println("Rota");
//          int rr = sc.nextInt();
//          System.out.println("Measeles");
//          int rm = sc.nextInt();
//          c1.return_vaccine(rbcg, rp, rr, rm);
//      sc.close();
//   // now option game will be start 


//         }
    


// }
