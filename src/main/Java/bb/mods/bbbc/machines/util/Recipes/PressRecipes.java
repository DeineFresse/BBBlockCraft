package bb.mods.bbbc.machines.util.Recipes;

import bb.mods.bbbc.core.util.Recipes.IRecipeBank;

/**
 * Created by BB20101997 on 11.08.2014.
 */
public class PressRecipes extends IRecipeBank<PressRecipe> {

    public static PressRecipes INSTANCE;

    public static IRecipeBank getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new PressRecipes();
        }
        return INSTANCE;

    }

    @Override
    public void addRecipe(PressRecipe irec) {

    }
}
