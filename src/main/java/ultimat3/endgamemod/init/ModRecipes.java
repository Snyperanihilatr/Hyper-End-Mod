package ultimat3.endgamemod.init;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import ultimat3.endgamemod.EndGame;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Initialize all recipes here. Called from the {@link EndGame#init(cpw.mods.fml.common.event.FMLInitializationEvent)}
 * method.
 * 
 * @author Ebilkill
 */
public class ModRecipes {
	
	/**
	 * Compression recipes
	 */
	private static final FactoryRecipes	COMPRESSION	= new FactoryRecipes(false);
	
	public static FactoryRecipes compression() {
		return COMPRESSION;
	}
	
	public static void initRecipes() {
		// Basic recipes
		initShapedRecipes();
		initShapelessRecipes();
		initSmeltingRecipes();
		
		// machine recipes
		initCompressionRecipes();
	}
	
	// noformat
	private static void initShapedRecipes() {
		// normal
		for(int meta = 0; meta < ModItems.ingotNames.length; ++meta) {
			// Nuggets-> ingots
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemIngots, 1, meta), new Object[] {
				"XXX", "XXX", "XXX", 'X', new ItemStack(ModItems.itemNuggets, 1, meta)
			});
			
			// Ingots-> blocks
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockMetals, 1, meta), new Object[] {
				"III", "III", "III", 'I', new ItemStack(ModItems.itemIngots, 1, meta)
			}); // I for ingot!
		}
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockReinforcedIron), new Object[] {"XXX", "XYX", "XXX", 'X', Items.diamond, 'Y', Blocks.iron_block});
		// Ore Dictionary
		
	}
	
	private static void initShapelessRecipes() {
		// normal
		for(int meta = 0; meta < ModItems.nuggetNames.length; ++meta) {
			// Ingots->nuggets
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemNuggets, 9, meta), new Object[] {
				new ItemStack(ModItems.itemIngots, 1, meta)
			});
			
			// Blocks->ingots
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemIngots, 9, meta), new Object[] {
				new ItemStack(ModBlocks.blockMetals, 1, meta)
			});
		}
		
		// Ore Dictionary
		
	}
	
	private static void initSmeltingRecipes() {
		// ores -> ingots. TODO add better XP values, these must be pretty sucky. Just added a random value.
		GameRegistry.addSmelting(new ItemStack(ModBlocks.blockOres, 1, 0), new ItemStack(ModItems.itemIngots, 1, 0), 2F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.blockOres, 1, 1), new ItemStack(ModItems.itemIngots, 1, 1), 2.0F);
	}
	//format
	
	private static void initCompressionRecipes() {
		compression().addRecipe(new ItemStack(Blocks.dirt), new ItemStack(Items.diamond));
	}
	
	/**
	 * Use this to make new recipe managers for our machines.
	 * 
	 * @author Ebilkill
	 */
	public static class FactoryRecipes {
		private Map<ItemStack, ItemStack>	recipesMap;
		private boolean						useInputAmount;
		
		public FactoryRecipes(boolean useInputAmount) {
			this.recipesMap = new HashMap<ItemStack, ItemStack>();
			this.useInputAmount = useInputAmount;
		}
		
		/**
		 * Adds a recipe that turns input into output.
		 * 
		 * @param input The item in the input (metadata sensitive).
		 * @param output The output item.
		 */
		public void addRecipe(ItemStack input, ItemStack output) {
			if (this.useInputAmount)
				this.recipesMap.put(input.copy(), output);
			else
				this.recipesMap.put(new ItemStack(input.getItem(), 1, input.getItemDamage()), output);
		}
		
		/**
		 * Gets the result of this input.
		 * 
		 * @param input The item in the input.
		 * @return The result of this operation, or null if there is no result.
		 */
		public ItemStack getResult(ItemStack input) {
			Iterator iterator = this.recipesMap.entrySet().iterator();
			Entry entry;
			
			do {
				if (!iterator.hasNext()) {
					return null;
				}
				
				entry = (Entry) iterator.next();
			} while (!this.areItemsEqual(input, (ItemStack) entry.getKey()));
			
			return (ItemStack) entry.getValue();
		}
		
		private boolean areItemsEqual(ItemStack input, ItemStack recipeInput) {
			return recipeInput.getItem() == input.getItem()
					&& (recipeInput.getItemDamage() == 32767 || recipeInput.getItemDamage() == input.getItemDamage());
		}
	}
}
