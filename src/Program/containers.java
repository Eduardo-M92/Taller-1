package Program;

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
	public String toString() {
		System.out.println("[max=" + max + ", amount=" + amount + "]");
		for (int a=0;a<amount;a++)
		{
			System.out.println("user=" + user[a]);
		}
		return "";
		
	}
}
//character container
class CharacterContainer
{
	private int max=10000;
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
}
class SkinContainer
{
	private int max=10000;
	private Skin[] skins=new Skin[max];
	private int amount=0;
	
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
	public String toString()
	{
		System.out.println("[max=" + max + ", amount=" + amount + "]");
		for (int a=0;a<amount;a++)
		{
			System.out.println("Skin=" + skins[a]);
		}
		return "";
	}
}
