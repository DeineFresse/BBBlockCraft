package bb.mods.bbbc.core.config;

import bb.mods.bbbc.core.util.LogHelper;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by BB20101997 on 23.07.2014.
 */
public class ConfigurationHandler
{

	public static boolean testBoolean = false;

	public static void init(File file){

		Configuration config = new Configuration(file);

		try{
			//Load config
			config.load();

			//Get values
			testBoolean  = config.get(Configuration.CATEGORY_GENERAL,"testBoolean",true).getBoolean(true);

            LogHelper.info("Loaded testBoolean successfull with value : "+testBoolean);
		}
		catch(Exception e){
			//Log Exception
			e.printStackTrace();
		}
		finally
		{
			//Save Config
			config.save();
		}

	}

}
