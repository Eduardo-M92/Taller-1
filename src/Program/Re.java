package Program;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class Re
{
	public static void main(String args[]) throws IOException
	{
		File personajesL=new File ("Personajes.txt");
		String[] vector=new String[1000];
		String[] vector3;
		int[] vector2=new int[1000];
		int cant=0;
		try(Scanner pL=new Scanner(personajesL))
		{
			while(pL.hasNext())
			{
				String linea=pL.nextLine();
				vector[cant]=linea;
				String[] datos=linea.split(",");
				vector2[cant]=datos[cant].length();
				cant++;
			}
		}
		FileWriter estadis=new FileWriter("Estadisticas.txt");
		PrintWriter pwE = new PrintWriter(estadis);
		FileWriter personajesW=new FileWriter("Personajes.txt");
		PrintWriter pw = new PrintWriter(personajesW);
		for (int a=0;a<cant;a++)
		{
			Random Rm = new Random();
			int valor2= (Rm.nextInt(900000));
			while(valor2<100000)
			{
				Rm = new Random();
				valor2= (Rm.nextInt(900000));
			}
			vector3=vector[a].split(",");
			pwE.println(vector3[0]+","+valor2);
			System.out.println(vector[a]);
			pw.print(vector3[0]+","+vector3[1]+",");
			for (int b=2;b<vector3.length;b++)
			{
				
				 Rm = new Random();
				int valor= (Rm.nextInt(5));
				System.out.println(valor);
				
				switch (valor)
				{
				case 0:
					Rm = new Random();
					valor= (Rm.nextInt(5));
					if(valor==0 || valor==1||valor==2||valor==3)
					{
						pw.print(vector3[b]+","+"N"+",");
					}else {pw.print(vector3[b]+","+"D"+",");}
					break;
				case 1:
					Rm = new Random();
					valor= (Rm.nextInt(5));
					if(valor==1 || valor==2||valor==3||valor==4)
					{
						pw.print(vector3[b]+","+"E"+",");
					}else {pw.print(vector3[b]+","+"N"+",");}
					break;
				case 2:
					Rm = new Random();
					valor= (Rm.nextInt(5));
					if(valor==2 || valor==3||valor==4||valor==1)
					{
						pw.print(vector3[b]+","+"L"+",");
					}else {pw.print(vector3[b]+","+"E"+",");}
					break;
				case 3:
					Rm = new Random();
					valor= (Rm.nextInt(5));
					if(valor==3 || valor==4)
					{
						pw.print(vector3[b]+","+"D"+",");
					}else {pw.print(vector3[b]+","+"L"+",");}
					break;
				case 4:
					Rm = new Random();
					valor= (Rm.nextInt(5));
					if(valor==4 || valor==1)
					{
						pw.print(vector3[b]+","+"M"+",");
					}else {pw.print(vector3[b]+","+"N"+",");}
					break;
				}
			}
			pw.println(vector3.length-2);
			
		}
		pwE.close();
		pw.close();
	}
}
