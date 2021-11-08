package Program;

/*
 * 
 * Definir una interfaz
 * para los contenedores
 * y operar con la interfaz
 * 
 */


class UserContainer
{
	private int max=10000;
	private User[] user=new User[max];
	private int amount=0;
	
	public boolean addUser(User user)
	{
		if (this.max>this.amount)
		{
			this.user[this.amount]=user;
			this.amount++;
			return true;
		}else {return false;}
	}
	
	public int getAmount()
	{
		return this.amount;
	}
	public User Search(String user)
	{
		for(int a=0;a<amount;a++)
		{
			if(this.user[a].getName().equals(user))
			{
				return this.user[a];
			}
		}
		return null;
	}
	public int getMax()
	{
		return this.max;
	}
}
//character container
class CharacterContainer
{
	private int max=155;
	private Character[] character=new Character[max];
	private int amount=0;
	
	public boolean addCharacter(Character Character)
	{
		if (this.max>this.amount)
		{
			this.character[this.amount]=Character;
			this.amount++;
			return true;
		}else {return false;}
	}
	
	public int getAmount()
	{
		return this.amount;
	}
	public Character Search(String character)
	{
		for(int a=0;a<amount;a++)
		{
			if(this.character[a].getName().equals(character))
			{
				return this.character[a];
			}
		}
		return null;
	}
	@Override
	public String toString()
	{
		String list = "";
		for (int a=0;a<amount;a++)
		{
			list+=character[a].getName();
			if(a<amount-1)
			{
				list+=",";
			}
		}
		return list;
	}
	public int getMax()
	{
		return this.max;
	}
}
class SkinContainer
{
	private int max=10000;
	private Skin[] skins=new Skin[max];
	private int amount=0;
	
	public String getSkins()
	{
		String list="";
		for(int a=0;a<amount;a++)
		{
			if(skins[a]!=null)
			{
				list+=skins[a].getName();
				if(a<amount-1)
				{
					list+=", ";
				}
			}
		}
		return list;
	}
	public boolean addSkin(Skin skin)
	{
		if (this.max>this.amount)
		{
			this.skins[this.amount]=skin;
			this.amount++;
			return true;
		}else {return false;}
	}
	
	public int getAmount()
	{
		return this.amount;
	}
	public Skin Search(String skin)
	{
		for(int a=0;a<amount;a++)
		{
			if(this.skins[a].getName().equals(skin))
			{
				return this.skins[a];
			}
		}return null;
	}
	public int getMax()
	{
		return this.max;
	}
	public String toString()
	{
		String list = "";
		for (int a=0;a<amount;a++)
		{
			list+=skins[a].getName();
			if(a<amount-1)
			{
				list+=", ";
			}
		}
		return list;
	}
	public String searchSkinsByCharacter(String name)
	{
		String list="";
		for(int a=0;a<amount;a++)
		{
			if(skins[a].getCharacter().getName().equals(name))
			{
				list+=skins[a].getName();
				if(a<amount-1)
				{
					list+=",";
				}
			}
		}
		return list;
	}
}
class UserCharacterContainer
{
	private int max=155;
	private UserCharacter[] character=new UserCharacter[max];
	private int amount=0;
	
	public boolean addCharacter(UserCharacter Character)
	{
		if (this.max>this.amount)
		{
			this.character[this.amount]=Character;
			this.amount++;
			return true;
		}else {return false;}
	}
	
	public int getAmount()
	{
		return this.amount;
	}
	public UserCharacter Search(String character)
	{
		for(int a=0;a<amount;a++)
		{
			if(this.character[a].getName().equals(character))
			{
				return this.character[a];
			}
		}
		return null;
	}
	public String getCharacters()
	{
		String list="";
		for(int a=0;a<amount;a++)
		{
			list+=character[a].getName();
			if(a<amount-1)
			{
				list+=",";
			}
		}
		return list;
	}
	
	public int getMax()
	{
		return this.max;
	}

}
