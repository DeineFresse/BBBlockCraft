package bb.mods.bbbc.machines.util.Recipes;

import bb.mods.bbbc.core.util.LogHelper;
import bb.mods.bbbc.core.util.Recipes.IRecipeBank;
import bb.mods.bbbc.core.util.Recipes.RecipeRegistry;
import bb.mods.bbbc.machines.references.RecipeIdentifier;

/**
 * Created by BB20101997 on 11.08.2014.
 */
public class PressRecipes extends IRecipeBank<PressRecipe> {

    public static PressRecipes INSTANCE;

    private PressRecipes(){
        super(PressRecipe.class);
    }

    public static IRecipeBank getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new PressRecipes();

            RecipeRegistry.getInstance().registerBank(RecipeIdentifier.PRESSBANK, INSTANCE);
            if (RecipeRegistry.getInstance().getRecipeBank(RecipeIdentifier.PRESSBANK) != INSTANCE) {
                LogHelper.error("Could not register RecipeBank PressRecipe already used identifier!");
            } else {
                LogHelper.info("RecipeBank PressRecipe instance already Registered,please check!");
            }
        }
        return INSTANCE;

    }
}
