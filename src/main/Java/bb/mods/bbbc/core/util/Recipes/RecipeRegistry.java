package bb.mods.bbbc.core.util.Recipes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by BB20101997 on 11.08.2014.
 */
public class RecipeRegistry {

    private static RecipeRegistry INSTANCE;

    private final Map<String,IRecipeBank> BankMap = new HashMap<String,IRecipeBank>();

    private RecipeRegistry(){}

    public static RecipeRegistry getInstance(){

        if(INSTANCE == null){
            INSTANCE =new RecipeRegistry();
        }

        return INSTANCE;
    }
    public void registerBank(String pressbank, IRecipeBank instance) {
            if((!BankMap.containsKey(pressbank))||BankMap.get(pressbank)==null) {
                BankMap.put(pressbank, instance);
            }
    }
    public IRecipeBank getRecipeBank(String identifier){
        return BankMap.get(identifier);
    }


}
