package Program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main
{
	public static void main(String args[]) throws FileNotFoundException
	{
		UserContainer userBox= new UserContainer();
		CharacterContainer characterBox= new CharacterContainer();
		SkinContainer skinBox= new SkinContainer();
		
		leer(userBox,characterBox,skinBox);
		
		System.out.println(userBox);
		System.out.println(skinBox);
	}
	
	static void leer(UserContainer userBox,CharacterContainer characterBox,SkinContainer skinBox) throws FileNotFoundException
	{
		File characters=new File("Personajes.txt");
		File acounts=new File("Cuentas.txt");
		try (Scanner e=new Scanner(characters))
		{
			while(e.hasNext())
			{
				String[] line=e.nextLine().split(",");
				Character ch = new Character();
				ch.setName(line[0]);
				ch.setRol(line[1]);
				for(int a=3;a<(Integer.parseInt(line[2])*2)+3;a+=2)
				{
					Skin sk=new Skin();
					sk.setName(line[a]);
					sk.setQuality(line[a+1]);
					sk.setCharacter(ch);
					skinBox.addSkin(sk);
				}
				characterBox.addCharacter(ch);
				
			}
		}
		try (Scanner c=new Scanner(acounts))
		{
			while(c.hasNext())
			{
				User user=new User();
				String line=c.nextLine();
				String[] parts=line.split(",");
				user.setName(parts[0]);
				user.setNick(parts[2]);
				user.setPassword(parts[1]);
				user.setLvl(Integer.parseInt(parts[3]));
				user.setRp(Integer.parseInt(parts[4]));
				user.setAmountCh(Integer.parseInt(parts[5]));
				
				for (int a=1;a<=user.getAmountCh();a++)
				{
					user.addCharacter(characterBox.Search(parts[5+a]));
				}
				user.setAmountSk(Integer.parseInt(parts[user.getAmountCh()+6]));
				user.setRegion(parts[user.getAmountSk()+user.getAmountCh()+7]);
				userBox.addUser(user);
			}
		}
	}
	
}

