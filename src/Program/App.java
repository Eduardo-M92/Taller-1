package Program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App
{
	public static void main(String args[]) throws FileNotFoundException
	{
		MobaSystem mobaSystem=new MobaSystemImpl();
		
		leer(mobaSystem);
		mobaSystem.mainMenu();
		
	}
	/**
	* read data from txt
	* restrictions:
	* MobaSystem exist.
	*
	* @param MobaSystem.
	*/
	static void leer(MobaSystem mobaSystem) throws FileNotFoundException
	{
		File characters=new File("Personajes.txt");
		File acounts=new File("Cuentas.txt");
		File statistics=new File("Estadisticas.txt");
		try (Scanner e=new Scanner(characters))
		{
			int price=0;
			while(e.hasNext())
			{
				String[] line=e.nextLine().split(",");	
				String name=line[0];
				String rol=line[1];
				mobaSystem.addCharacter(name, rol);
				for(int a=3;a<(Integer.parseInt(line[2])*2)+3;a+=2)
				{
					switch (line[a+1])
					{
					case "M":
						price=3250;
						break;
					case "D":
						price=2750;
						break;
					case "L":
						price=1820;
						break;
					case "E":
						price=1350;
						break;
					case "N":
						price=975;
						break;
					}
					mobaSystem.addSkin(line[a],line[a+1],name,price);
				}
			}
		}
		try (Scanner c=new Scanner(acounts))
		{
			while(c.hasNext())
			{
				
				String line=c.nextLine();
				String[] parts=line.split(",");
				
				String name=parts[0];
				String nick=parts[2];
				String password=parts[1];
				String region=parts[parts.length-1];
				int lvl=Integer.parseInt(parts[3]);
				int rp = Integer.parseInt(parts[4]);
				
				mobaSystem.addUser(name,nick,region,password,lvl,rp);
				
				for (int a=6;a<parts.length-2;a++)
				{
					//System.out.println("Campeon: "+parts[a]);
					String characterName = parts[a];
					int cantSkin=Integer.parseInt(parts[a+1]);
					mobaSystem.addUserCharacter(name,characterName);
					for (int b=a+2;b<(cantSkin+(a+2));b++)
					{
						//System.out.println("Skin: "+parts[b]);
						mobaSystem.addUserCharacterSkin(name,characterName, parts[b]);
					}
					a+=cantSkin+1;
				}
			}
		}
		try (Scanner f=new Scanner(statistics))
		{
			while(f.hasNext())
			{
				String line=f.nextLine();
				String[] parts=line.split(",");
				if(mobaSystem.findCharacter(parts[0])!=null)
				{
					mobaSystem.findCharacter(parts[0]).setCollected(Integer.parseInt(parts[1]));
				}
			}
		}
	}
}

