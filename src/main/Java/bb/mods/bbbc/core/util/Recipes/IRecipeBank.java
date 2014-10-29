package bb.mods.bbbc.core.util.Recipes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BB20101997 on 13.08.2014.
 */

public abstract class IRecipeBank<T extends IRecipe> {

    public final List<T> recipeList = new ArrayList<T>();

    public final Class<T> Tclass;

    public IRecipeBank(Class<T> cl){
        Tclass = cl;
    }

    public void addRecipe(T irec){

        recipeList.add(irec);

    }

    @SuppressWarnings("unchecked")
    public T[] getRecipeList() {

        T[] arr = null;

        try{

            arr = recipeList.toArray((T[]) java.lang.reflect.Array.newInstance(Tclass, 0));

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return arr;

    }

}
