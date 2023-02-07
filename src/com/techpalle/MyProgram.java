package com.techpalle;
import java.util.Scanner;
public class MyProgram {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		int value=in.nextInt();
		switch(value) 
		{
			case 1:Student.Creating();
			
			case 2:Student.inserting(in.next(), in.next(), in.next());
			
			case 3:Student.update(1, "kannada", "raghu@gmail.com");
			
			case 4:Student.deleting(7);
			
			case 5:System.exit(0);
		}
		in.close();
	}

}

