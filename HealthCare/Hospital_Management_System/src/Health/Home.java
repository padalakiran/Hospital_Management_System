package Health;

import java.util.Scanner;

public class Home {
	
	public static int  Run_pro() {
		System.out.println("\nWelcome to XYZ Hospital");
		System.out.println("1.Patient Login \n2.Patient Signup \n3.Doctor Login \n4.Admin Login  \n5.Exit");
		Scanner a=new Scanner(System.in);
		System.out.print("Pleace Select An Option: ");
		int ab=a.nextInt();
		 return ab;
		}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
			int b=0;
			while(b==0) {
			try {
			//Home c=new Home();
			int i=Home.Run_pro();
			if(i==1) {
				Patient_login.plogin();
			}else if(i==2) {
				Patient_Signup.patient_sign();
			}else if(i==3) {
				Doctor_login.dlogin();
			}else if(i==4) {
				Admin_login.login();
			}
			else if(i==5) {
				b+=1;
				System.out.println("---------- Thank You ----------");
			}else {
				System.out.println("Enter Valid Option");
			}
			
			}catch(Exception e) {
			System.out.println("Enter Valid Option");
		}
		}
		

	}

	
	}


