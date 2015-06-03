package ultimat3.endgamemod.items;

import ultimat3.endgamemod.EndGame;
import ultimat3.endgamemod.blocks.Ultimat3Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Superclass this for new item classes (for the Ultimat3 modding team).
 * 
 * @author Ebilkill
 */
public abstract class Ultimat3Item extends Item {
	/** @see #getName() */
	private final String name;

	/**
	 * Simple constructor. Only requires an internal name for the item. Sets the
	 * unlocalized name equal to ModId_name.
	 * 
	 * @param name
	 *            The internal name of the item.
	 * @author Ebilkill
	 */
	public Ultimat3Item(String name) {
		this.name = name;
		GameRegistry.registerItem(this, name, EndGame.MODID);
		this.setUnlocalizedName(EndGame.MODID + "_" + name);
		this.setTextureName(name);
		this.setCreativeTab(EndGame.creaTab);
	}

	/**
	 * 1.8 stuff. Same as in {@link Ultimat3Block#getName()}
	 * 
	 * @return The in-code name of this item.
	 * @author Ebilkill
	 */
	public String getName() {
		return this.name;
	}
}
