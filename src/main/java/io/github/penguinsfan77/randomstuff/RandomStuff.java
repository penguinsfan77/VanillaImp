package io.github.penguinsfan77.randomstuff;

import io.github.penguinsfan77.randomstuff.proxy.IProxy;
import io.github.penguinsfan77.randomstuff.refrence.Refrences;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= Refrences.MOD_ID, 
name= Refrences.MOD_NAME, 
version= Refrences.VERSION)
public class RandomStuff {

	@Mod.Instance(Refrences.MOD_ID)
	public static RandomStuff instance;
	
	@SidedProxy(clientSide= Refrences.CLIENT_PROXY_CLASS, serverSide= Refrences.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		
        
        
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    	
        
        
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
        
        
    }

}
