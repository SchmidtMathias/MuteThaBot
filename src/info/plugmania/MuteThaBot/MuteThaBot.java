package info.plugmania.MuteThaBot;

public class MuteThaBot extends JavaPlugin {
	
	HashMap<String,Auth> auths = new HashMap<String,Auth>;
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerJoinEvent event) {
		if(!auths.contains(event.getPlayer().getName()){
			auths.put(event.getPlayer().getName(),new Auth());
		}
		if(!auths.get(event.get.Player().getName()).isAuth){
			player.sendMessage(ChatColor.GOLD + "[MuteThaBot] Please type '" + auths.get(event.getPlayer().getName()).rnd + "' now to authenticate yourself");
		}
	}

	@EventHandler
	public void onPlayerChat(PlayerChatEvent event){
		if(auths.contains(event.getPlayer().getName())) {
			if(!auths.get(event.get.Player().getName()).isAuth){
				if(event.getMessage() equals auths.get(event.getPlayer().getName()).rnd){
					auths.get(event.getPlayer().getName()).isAuth=true;
				}else{
					player.sendMessage(ChatColor.GOLD + "[MuteThaBot] Please type '" + auths.get(event.getPlayer().getName()).rnd + "' now to authenticate yourself");	
				}
				event.setCanceled=true;
			}
	    	}
	}
	
	class Auth{
		boolean isAuth;
		int rnd;
	    	public Auth(){
	    		this.isAuth=false;
	    		Random r = new Random();
	    		this.rnd = r.nextInt(9);
	    	}
	}
	
	
}
