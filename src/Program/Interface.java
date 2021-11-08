package Program;

import java.util.Scanner;

interface MobaSystem
{
	/**
	* add a skin to the system
	* restrictions:
	* that there is a character.
	*
	* @param name skin.
	* @param quality skin.
	* @param name character.
	* @param price skin.
	* @return true if possible add the skin,
	* false in other case.
	*/
	boolean addSkin(String name,String quality,String nameCharacter,int price);
	/**
	* add a user to the system
	* restrictions:
	* none
	*
	* @param name user.
	* @param nick.
	* @param region.
	* @param password.
	* @param lvl.
	* @param rp.
	* @return true if possible add the user,
	* false in other case.
	*/
	boolean addUser(String name,String nick,String region,String password,int lvl,int rp);
	/**
	* add a character to the system
	* restrictions:
	* none
	*
	* @param name character.
	* @param rol.
	* @return true if possible add the user,
	* false in other case.
	*/
	boolean addCharacter(String name,String rol);
	/**
	* add a character to the user
	* restrictions:
	* that there is a user.
	*
	* @param name user.
	* @param name character.
	* @return true if possible add the user,
	* false in other case.
	*/
	boolean addUserCharacter(String name,String characterName);
	
	/**
	* get user finding
	* restrictions:
	* that there is a user.
	*
	* @param name user.
	* @return user if possible find the user,
	* null in other case.
	*/
	User findUser(String name);
	/**
	* get current user of system
	* restrictions:
	* none
	*
	* @return user if user exist,
	* null in other case.
	*/
	User getCurrentUser();
	/**
	* get skin finding
	* restrictions:
	* none
	*
	* @param name skin.
	* @return user if possible find the skin,
	* null in other case.
	*/
	Skin findSkin(String name);
	/**
	* get character finding
	* restrictions:
	* none
	*
	* @param name user.
	* @return character if possible find the character,
	* null in other case.
	*/
	Character findCharacter(String character);
	
	/**
	* add skin for the user
	* restrictions:
	* none
	*
	* @param name user.
	* @param name character.
	* @param name skin.
	*
	*/
	void addUserCharacterSkin(String name,String character, String skin);
	/**
	* set current user system
	* restrictions:
	* none
	*
	* @param name user.
	*
	*/
	void setCurrentUser(String name);
	/**
	* Start main menu.
	* restrictions:
	* none
	*
	*/
	void mainMenu();
	/**
	* Start login menu.
	* restrictions:
	* none
	*
	*/
	void login();
	/**
	* Start user menu.
	* restrictions:
	* none
	*
	*/
	void userMenu();
	/**
	* Start admin menu.
	* restrictions:
	* none
	*
	*/
	void adminMenu();
	/**
	* Start register menu.
	* restrictions:
	* none
	*
	*/
	void register();
	/**
	* Start buy skin menu.
	* restrictions:
	* none
	*
	*/
	void buySkin();
	/**
	* run show ability Skin.
	* restrictions:
	* none
	*
	*/
	void availabilitySkin();
	/**
	* run show user inventory.
	* restrictions:
	* none
	*
	*/
	void showInventory();
	/**
	* start rechargeRp menu.
	* restrictions:
	* none
	*
	*/
	void rechargeRp();
	/**
	* show user data.
	* restrictions:
	* none
	*
	*/
	void userData();
	/**
	* save global data.
	* restrictions:
	* Data existent.
	*
	*/
	void saveData();
	
}

class MobaSystemImpl implements MobaSystem
{
	private UserContainer users=new UserContainer();
	private CharacterContainer characters=new CharacterContainer();
	private SkinContainer skins=new SkinContainer();
	private String[] rol= {"SUPORT","ATACK DAMAGE CARRY","TOP LANER","MIDDLE LANER","JUNGLER"};
	private int[] collectedByRol=new int[5];
	private int[] characterByRol=new int[5];
	private String[] region= {"LAS","LAN","EUW","KR","NA","RU"};
	private int[] collectedByRegion=new int[6];
	
	private User currentUser;
	
	
	@Override
	public boolean addSkin(String name,String quality,String nameCharacter,int price) 
	{
		if (skins.getAmount()<skins.getMax())
		{
			Skin sk =new Skin(name,quality,price);
			sk.setCharacter(characters.Search(nameCharacter));
			skins.addSkin(sk);
			return true;
		}
		return false;
	}
	@Override
	public boolean addUser(String name,String nick,String region,String password,int lvl,int rp) 
	{
		if (users.getAmount()<10000)
		{
			User us = new User(name,nick,region,password,lvl,rp);
			users.addUser(us);
			return true;
		}
		return false;
	}
	@Override
	public boolean addCharacter(String name,String rol) 
	{
		if (characters.getAmount()<characters.getMax())
		{
			Character ch=new Character(name,rol);
			characters.addCharacter(ch);
			return true;
		}
		return false;
	}
	@Override
	public User findUser(String name) 
	{
		return users.Search(name);
	}
	@Override
	public Skin findSkin(String name) 
	{
		return skins.Search(name);
	}
	@Override
	public Character findCharacter(String character) 
	{
		return characters.Search(character);
	}
	@Override
	public boolean addUserCharacter(String name,String characterName) 
	{
		User user = users.Search(name);
		if (user.getAmountCharacter()<155)
		{
			UserCharacter uch= new UserCharacter(characterName);
			user.addCharacter(uch);
			return true;
		}
		return false;
	}
	@Override
	public void setCurrentUser(String name) 
	{
		this.currentUser=users.Search(name);
		
	}
	@Override
	public User getCurrentUser() 
	{
		
		return this.currentUser;
	}
	@Override
	public void addUserCharacterSkin(String name,String character, String skin)
	{
		if(skins.Search(skin)==null)
		{
			users.Search(name).addCharacterSkin(character, skin);
		}
		else {users.Search(name).addCharacterSkin(character, skins.Search(skin));}
	}
	
	public void mainMenu()
	{
		Scanner sc=new Scanner(System.in);
		boolean cicle=true;
		while(cicle)
		{
			System.out.println("Bienvenido a la tienda de “Juego genérico” ");
			System.out.println("a)Iniciar sesion");
			System.out.println("b)Registrar nuevo usuario");
			System.out.println("c)Salir");
			System.out.print("Ingrese operación a relizar: ");
			
			String option=sc.next().toLowerCase();
			switch (option)
			{
			case "a":
				login();
				if (currentUser==null)
				{
					System.out.println("-------------------------------------------");
					System.out.println("Datos Incorrectos");
					System.out.println("-------------------------------------------");
				}
				else 
				{
					if(currentUser.getName().equals("admin"))
					{
						cicle=false;
					}
					else {cicle=false;userMenu();}
				}
				break;
			case "b":
				register();
				cicle=false;
				userMenu();
				break;
			case "c":
				saveData();
				break;
			}
		}
	}
	public void login()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Iniciar sesion ingrese sus datos");
		System.out.print("Nombre: ");
		String name = sc.nextLine();
		User tempUser = users.Search(name);
		if(tempUser!=null)
		{
			System.out.print("Contraseña: ");
			String password = sc.nextLine();
			if(tempUser.getPassword().equals(password))
			{
				this.currentUser=tempUser;
				System.out.println("Inicio de sesion exitoso");
			}
		}
		else
		{
			if(name.toLowerCase().equals("admin"))
			{
				System.out.print("Contraseña: ");
				String password = sc.nextLine();
				if(password.toLowerCase().equals("admin"))
				{
					adminMenu();
				}
			}else {System.out.println("Usuario no registrado");}
		}
		
	}
	public void adminMenu()
	{
		User admin=new User();
		admin.setName("admin");
		this.currentUser=admin;
		boolean cicle = true;
		Scanner sc = new Scanner(System.in);
		while(cicle)
		{
			System.out.println("Admin menu");
			System.out.println("Menu de opciones");
			System.out.println("a)Recaudacion por Rol");
			System.out.println("b)Ventas por region");
			System.out.println("c)Ventas por personaje");
			System.out.println("d)Cantidad de personajes por rol");
			System.out.println("e)Añadir un personaje");
			System.out.println("f)Añadir una skin");
			System.out.println("g)Bloquear jugador");
			System.out.println("h)Cuentas por nivel mayor a menor");
			System.out.println("i)Salir");
			System.out.print("Ingrese operacion a realizar: ");
			String option = sc.next().toLowerCase();
			switch (option)
			{
			case "a":
				for(int a=0;a<rol.length;a++)
				{
					System.out.println(rol[a]+" con una recaudacion de "+collectedByRol[a]*6.15+"CLP");
				}
				break;
			case "b":
				for(int a=0;a<region.length;a++)
				{
					System.out.println(region[a]+" con una recaudacion de "+collectedByRegion[a]*6.15+"CLP");
				}
				break;
			case "c":
				for(int a=0;a<characters.getAmount();a++)
				{
					System.out.println("El personaje "+characters.getCharacterI(a).getName()+" tiene una recaudacion de "+characters.getCharacterI(a).getCollected()*6.15+"CLP");
				}
				break;
			case "d":
					for(int b=0;b<characters.getAmount();b++)
					{
						switch (characters.getCharacterI(b).getRol())
						{
						case "SUP":
							characterByRol[0]+=1;
							break;
						case "ADC":
							characterByRol[1]+=1;
							break;
						case "TOP":
							characterByRol[2]+=1;
							break;
						case "MID":
							characterByRol[3]+=1;
							break;
						case "JG":
							characterByRol[4]+=1;
							break;
						}
					}
				for(int a=0;a<rol.length;a++)
				{
					System.out.println("El rol "+rol[a]+" tiene "+characterByRol[a]+" personajes");
				}
				break;
			case "e":
				
				break;
			case "f":
				
				break;
			case "g":
				
				break;
			case "h":
				
				break;
			case "i":
				mainMenu();
				cicle=false;
				break;
			default:
				System.out.println("Opcion incorrecta");
			}
		}
		
	}
	public void register()
	{
		try {
			String region="";
			Scanner sc=new Scanner(System.in);
			System.out.println("Ingrese sus datos para el registro");
			System.out.print("Nombre de la cuenta: ");
			String name = sc.nextLine();
			while(users.Search(name)!=null && !name.toLowerCase().equals("f"))
			{
				System.out.println("Usuario ya registrado ingrese “F” para cancelar el registro");
				System.out.print("Nombre de la cuenta: ");
				name = sc.nextLine();
			}
			if(!name.toLowerCase().equals("f") && users.Search(name)==null)
			{
				System.out.print("Nick: ");
				String nick = sc.nextLine();
				System.out.print("Contraseña: ");
				String password = sc.nextLine();
				String[] verifipass = password.split("");
				while(verifipass.length>=8)
				{
					System.out.println("La contraseña debe contener almenos 8 caracteres");
					System.out.print("Contraseña: ");
					password = sc.nextLine();
					verifipass = password.split("");
				}
				boolean cicle=true;
				while(cicle)
				{
					System.out.print("Regiones: LAS(1), LAN(2), EUW(3), KR(4), NA(5), RU(6)");
					System.out.print("Seleccione una region (ejemplo: 1): ");
					int valid = sc.nextInt();
					switch (valid)
					{
					case 1:
						region="LAS";
						cicle=false;
						break;
					case 2:
						region="LAN";
						cicle=false;
						break;
					case 3:
						region="EUW";
						cicle=false;
						break;
					case 4:
						region="KR";
						cicle=false;
						break;
					case 5:
						region="NA";
						cicle=false;
						break;
					case 6:
						region="RU";
						cicle=false;
						break;
					default:
						 System.out.println("Ingrese un numero correspondiente a alguna region");
					}
				}
				addUser(name,nick,region,password,0,0);
				this.currentUser=users.Search(name);
			}
		}catch (java.util.InputMismatchException ex) {System.out.println("-------------------------------------------");System.out.println("Invalid number format");System.out.println("-------------------------------------------");}
		
	}
	public void userMenu()
	{
			System.out.println("Hola "+currentUser.getName()+" Bienvenido");
			boolean cicle = true;
			Scanner sc = new Scanner(System.in);
			while(cicle)
			{
				System.out.println("Menu de opciones");
				System.out.println("a)Comprar Skin");
				System.out.println("b)Comprar Personaje");
				System.out.println("c)Disponibilidad de Skins");
				System.out.println("d)Mi inventario");
				System.out.println("e)Recargar RP");
				System.out.println("f)Mis Datos");
				System.out.println("g)Cerrar sesion");
				System.out.print("Ingrese operacion a realizar: ");
				String option = sc.next().toLowerCase();
				
				switch (option)
				{
				case "a":
					buySkin();
					break;
				case "b":
					buyCharacter();
					break;
				case "c":
					availabilitySkin();
					break;
				case "d":
					showInventory();
					break;
				case "e":
					rechargeRp();
					break;
				case "f":
					userData();
					break;
				case "g":
					cicle=false;
					mainMenu();
					break;
				}
				
			}
		
	}
	public void buySkin()
	{
		Scanner sc = new Scanner(System.in);
		availabilitySkin();
		System.out.print("Escriba el nombre del personaje: ");
		String ch = sc.nextLine();
		
		if(currentUser.searchCharacter(ch)==null)
		{
			System.out.println("Nombre incorrecto o este personaje no le pertenece");
			System.out.print("Desea ir Comprarlo (si - no): ");
			String option = sc.next().toLowerCase();
			while(!option.equals("si") && !option.equals("no"))
			{
				System.out.println("Opcion no valida");
				System.out.print("Desea ir Comprar el personaje (si - no): ");
				option = sc.next().toLowerCase();
			}
			if(option.equals("si"))
			{
				buyCharacter();
			}
		}
		else
		{
			String list = skins.searchSkinsByCharacter(ch);
			String[] arraySkin=list.split(",");
			System.out.print("Escriba el nombre de la Skin(escribir f para salir): ");
			String sk = sc.nextLine();
			boolean cicle=true;
			while(cicle&&!sk.equals("f"))
			{
				int a=0;
				for(a=0;a<arraySkin.length;a++)
				{
					if(arraySkin[a].equals(sk))
					{
						cicle=false;
						break;
					}
				}
				if (a==arraySkin.length)
				{
					System.out.println("Skin no encontrada");
					System.out.print("Escriba el nombre de la Skin(escribir f para salir): ");
					sk = sc.nextLine();
				}
			}
			if(!sk.equals("f"))
			{
				int skinPrice=skins.Search(sk).getPrice();
				
				System.out.println("La skin y tiene un precio de "+skinPrice+"RP"+" y su RP es de "+currentUser.getRp()+"RP");
				System.out.print("Desea comprarla(si - no): ");
				String option = sc.next().toLowerCase();
				while(!option.equals("si") && !option.equals("no"))
				{
					System.out.println("Opcion no valida");
					System.out.print("Desea ir Comprar la skin (si - no): ");
					option = sc.next().toLowerCase();
				}
				
				if(currentUser.getRp()>=skinPrice && option.equals("si"))
				{
	
					switch (currentUser.getRegion())
					{
					case "LAS":
						collectedByRegion[0]+=skinPrice;
						break;
					case "LAN":
						collectedByRegion[1]+=skinPrice;
						break;
					case "EUW":
						collectedByRegion[2]+=skinPrice;
						break;
					case "KR":
						collectedByRegion[3]+=skinPrice;
						break;
					case "NA":
						collectedByRegion[4]+=skinPrice;
						break;
					case "RU":
						collectedByRegion[5]+=skinPrice;
						break;
					}
					currentUser.setRp(currentUser.getRp()-skinPrice);
					addUserCharacterSkin(currentUser.getName(), ch, sk);
					currentUser.setLvl(currentUser.getLvl()+1);
					System.out.println("Compra realizada con exito nuevo saldo: "+currentUser.getRp()+"RP");
				}
				else
				{
					if(option.equals("si"))
					{
						System.out.println("Dinero insificiente");
					}
					else
					{
						System.out.println("Compra cancelada...");
					}
				}
			}
		}
	}
	public void buyCharacter()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu compra de Personajes");
		System.out.print("Personajes disponibles: ");
		System.out.println(characters);
		System.out.println("Los personajes tienen un precio de 975RP y tu RP es de "+currentUser.getRp());
		System.out.print("Escriba el nombre del personaje(f para salir): ");
		String ch = sc.nextLine();
		
		while(characters.Search(ch)==null&&!ch.equals("f"))
		{
			System.out.println("Nombre incorrecto o personaje no existe");
			System.out.print("Escriba el nombre del personaje(f para salir): ");
			ch = sc.nextLine();
		}
		if(currentUser.getRp()>=975&&!ch.equals("f"))
		{
			if(currentUser.searchCharacter(ch)==null)
			{
				switch (characters.Search(ch).getRol())
				{
				case "SUP":
					collectedByRol[0]+=975;
					break;
				case "ADC":
					collectedByRol[1]+=975;
					break;
				case "TOP":
					collectedByRol[2]+=975;
					break;
				case "MID":
					collectedByRol[3]+=975;
					break;
				case "JG":
					collectedByRol[4]+=975;
					break;
				}
				currentUser.setRp(currentUser.getRp()-975);
				currentUser.addCharacter(ch);
				currentUser.setLvl(currentUser.getLvl()+3);
				System.out.println("Personaje comprado nuevo saldo "+currentUser.getRp());
			}
			else {System.out.println("Personaje en posecion no se puede comprar");}
		}
		else {if(!ch.equals("f")) {System.out.println("Saldo insuficiente favor cargar RP");}}
	}
	public void availabilitySkin()
	{
		System.out.println("Personajes disponibles: "+characters);
		String[] list = characters.toString().split(",");
		String skinUniqueList="";
			
		for(int a=0;a<list.length;a++)
		{
			String[] skinList=skins.searchSkinsByCharacter(list[a]).split(",");
			skinUniqueList="";
			for(int b=0;b<skinList.length;b++)
			{
				if(b<skinList.length-1)
				{
					skinUniqueList+=", ";
				}
				
			}
			if(skinUniqueList.split(",").length!=2)
			{
				System.out.println("Las skins del personaje "+list[a]+" Son "+skinUniqueList);
			}
		}
		
	}
	public void showInventory()
	{
		System.out.println("Personajes: "+currentUser.getCharacters());
		String[] list = currentUser.getCharacters().split(",");
		for(int a=0;a<list.length;a++)
		{
			if(currentUser.searchCharacter(list[a])!=null)
			{
				System.out.print("Personaje "+list[a]+", Skins: ");
				
				System.out.println(currentUser.getCharacter(list[a]).getSkins());
			}
		}
		
	}
	public void rechargeRp()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Menu recarga de RP");
		System.out.println("Su saldo es: "+currentUser.getRp()+"RP");
		System.out.print("Cuanto RP desea cargar: ");
		int carga = sc.nextInt();
		while(carga<0)
		{
			System.out.println("Monto invalido");
			System.out.print("Cuanto RP desea cargar: ");
			carga = sc.nextInt();
		}
		currentUser.setRp(currentUser.getRp()+carga);
		System.out.println("Su nuevo saldo es: "+currentUser.getRp()+"RP");
	}
	public void userData()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Datos del Usuario");
		String password="";
		String[] parts = currentUser.getPassword().split("");
		for(int a=0;a<parts.length;a++)
		{
			if(parts.length-3>a)
			{
				password+="*";
			}else {password+= parts[a];}
		}
		System.out.println("Nombre: "+currentUser.getName()+", Nick: "+currentUser.getNick()+", Contraseña: "+password);
		System.out.print("Quiere cambiar de contraseña(si - no):");
		String option=sc.next().toLowerCase();
		while(!option.equals("si")&&!option.equals("no"))
		{
			System.out.println("Opcion no valida");
			System.out.print("Quiere cambiar de contraseña(si - no):");
			option=sc.next().toLowerCase();
		}
		boolean cicle=false;
		if(option.equals("si"))
		{
			cicle=true;
		}else {cicle=false;}
		
		while(cicle)
		{
			System.out.print("Ingrese su contraseña antigua: ");
			String lasPass=sc.nextLine(); 
			while(!currentUser.getPassword().equals(lasPass))
			{
				System.out.println("Ingrese una contraseña valida");
				System.out.print("Ingrese su contraseña antigua: ");
				lasPass=sc.nextLine(); 
			}
			System.out.print("Ingrese su nueva contraseña: ");
			String newPass1 = sc.nextLine();
			while(newPass1.split("").length<8)
			{
				System.out.println("Su contraseña debe tener almenos 8 caracteres");
				System.out.print("Ingrese su nueva contraseña: ");
				newPass1 = sc.nextLine();
			}
			System.out.print("Ingrese denuevo nueva contraseña para confirmar: ");
			String newPass2 = sc.nextLine();
			if(newPass2.equals(newPass1))
			{
				System.out.println("Contraseña cambiada con exito");
				currentUser.setPassword(newPass1);
				cicle=false;
			}
			else {System.out.println("Las contraseñas no coinciden cancelando proceso...");cicle=false;}
		}
	}
	@Override
	public void saveData()
	{
		
	}
	
}
