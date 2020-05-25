package sdg.demo.java;

import java.util.Scanner;

public class SDGDemo {
	
	public static void main(String[] args) {
		System.out.print("Enter a string : ");
        Scanner scanner = new Scanner(System. in);
        String inputString = scanner. nextLine();
        System.out.println("String read from console is : \n"+inputString); 
        Employee emp = new Employee();
        String title = emp.searchTitleByName(inputString);
        System.out.println("the tile of employee is:"+title);
        
	}

}
