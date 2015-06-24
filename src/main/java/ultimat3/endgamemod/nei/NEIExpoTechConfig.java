package ultimat3.endgamemod.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;


public class NEIExpoTechConfig implements IConfigureNEI
{

    @Override
    public void loadConfig ()
    {
    	API.registerRecipeHandler(new RecipeHandlerMatterConsolidator());
    	API.registerUsageHandler(new RecipeHandlerMatterConsolidator());
    }

    @Override
    public String getName ()
    {
        return "ExpoTech";
    }

    @Override
    public String getVersion ()
    {
        return "${version}";
    }

}