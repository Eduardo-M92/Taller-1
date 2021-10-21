package Program;

class User
{
	private String name;
	private String nick;
	private String region;
	private String password;
	private int lvl;
	private int rp;
	
	//cantidades de PJs y Skins
	private int amountCh;
	private int amountSk;
	
	private Character[] characters=new Character[155];
	private Skin[] skins=new Skin[10000];
	
	
	public User() {}
	public User(String name, String nick, String region, String password,int lvl, int rp, int amountCh, int amountSk)
	{
		super();
		this.name = name;
		this.nick = nick;
		this.region = region;
		this.password = password;
		this.lvl = lvl;
		this.rp = rp;
		this.amountCh = amountCh;
		this.amountSk = amountSk;

	}
	public boolean addCharacter(Character ch)
	{
		if(amountCh<155)
		{
			characters[amountCh]=ch;
			return true;
		}else {return false;}
	}
	public boolean addSkin(Skin skin)
	{
		if(amountSk<10000)
		{
			skins[amountCh]=skin;
			return true;
		}else {return false;}
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
	public Skin[] getSkins()
	{
		return skins;
	}
	public void setSkins(Skin[] skins)
	{
		this.skins = skins;
	}
	public Character[] getCharacters()
	{
		return characters;
	}
	public void setCharacters(Character[] characters)
	{
		this.characters = characters;
	}
	public int getAmountCh()
	{
		return amountCh;
	}
	public int getAmountSk()
	{
		return amountSk;
	}
	public void setAmountCh(int amountCh) {
		this.amountCh = amountCh;
	}
	public void setAmountSk(int amountSk) {
		this.amountSk = amountSk;
	}
	public String toString() {
		return "User [name=" + name + ", nick=" + nick + ", region=" + region + ", password=" + password + ", lvl="
				+ lvl + ", rp=" + rp + ", amountCh=" + amountCh + ", amountSk=" + amountSk +"]";
	}
}

class Skin
{
	private String name;
	private String quality;
	private Character character;
	
	public Skin()
	{
	}
	public Skin(String name,String quality)
	{
		this.quality=quality;
		this.name=name;
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
	public String toString() {
		return "Skin [name=" + name + ", quality=" + quality + ", character=" + character.getName() + "]";
	}
}

class Character
{
	private String name;
	private String rol;
	
	public Character()
	{
	}
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
}