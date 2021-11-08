package Program;

/*
 * Clase personajes en posecion, y este tendr una lista de kins compradas
 * 
 * El usuario no puede tener una lista skins
 * 
 */
class User
{
	private String name;
	private String nick;
	private String region;
	private String password;
	private int lvl;
	private int rp;
	
	
	private UserCharacterContainer characterBox=new UserCharacterContainer();
	

	public User() {}
	public User(String name, String nick, String region, String password,int lvl, int rp)
	{
		super();
		this.name = name;
		this.nick = nick;
		this.region = region;
		this.password = password;
		this.lvl = lvl;
		this.rp = rp;
	}
	public String getCharacters()
	{
		return characterBox.getCharacters();
	}
	public UserCharacter getCharacter(String name)
	{
		return characterBox.Search(name);
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getNick()
	{
		return nick;
	}
	public void setNick(String nick)
	{
		this.nick = nick;
	}
	public String getRegion()
	{
		return region;
	}
	public void setRegion(String region)
	{
		this.region = region;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public int getRp()
	{
		return rp;
	}
	public void setRp(int rp)
	{
		this.rp = rp;
	}
	public int getLvl()
	{
		return lvl;
	}
	public void setLvl(int lvl)
	{
		this.lvl = lvl;
	}
	public UserCharacter searchCharacter(String name)
	{
		return characterBox.Search(name);
	}
	public Skin searchSkin(String characterName,String skinName)
	{
		if(characterBox.Search(characterName)!=null)
		{
			return characterBox.Search(characterName).searchSkin(skinName);
		}else {return null;}
	}
	public void addCharacter(UserCharacter character)
	{
		if(character!=null)
		{
			this.characterBox.addCharacter(character);
		}
	}
	public void addCharacter(String name)
	{
		UserCharacter ch =new UserCharacter(name);
			this.characterBox.addCharacter(ch);
		}
	public int getAmountCharacter()
	{
		return this.characterBox.getAmount();
	}
	public void addCharacterSkin(String character,Skin skin)
	{
		characterBox.Search(character).addSkin(skin);
	}
	public void addCharacterSkin(String character,String skin)
	{
		Skin sk = new Skin();
		sk.setName(skin);
		characterBox.Search(character).addSkin(sk);
	}
}

class Skin
{
	private String name;
	private String quality;
	private Character character;
	private int price=0;
	
	public Skin()
	{
		
	}
	public int getPrice()
	{
		return this.price;
	}
	public void setPrice(int price)
	{
		this.price=price;
	}
	public Skin(String name,String quality,int price)
	{
		this.quality=quality;
		this.name=name;
		this.price=price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuality() {
		return this.quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
}

class Character
{
	private String name;
	private String rol;
	private int collected=0;
	
	public Character(String name,String rol)
	{
		this.rol=rol;
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public void setCollected(int collected)
	{
		this.collected=collected;
	}
	public int getCollected()
	{
		return this.collected;
	}
	
}
class UserCharacter
{
	private String name;
	private SkinContainer skins=new SkinContainer();
	
	public String getSkins()
	{
		return skins.getSkins();
	}
	public UserCharacter(String name)
	{
		super();
		this.name = name;
	}
	public Skin searchSkin(String name)
	{
		
		return skins.Search(name);
		
	}
	public boolean addSkin(Skin skin)
	{
		if(skins.getAmount()<10000)
		{
			skins.addSkin(skin);
			return true;
		}return false;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getAmountSkins()
	{
		return skins.getAmount();
	}
	
}