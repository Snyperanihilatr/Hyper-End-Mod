package ultimat3.expotech.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import ultimat3.expotech.gui.container.ContainerMatterConsolidator;

public class GuiMatterConsolidator extends GuiMachine {

	public GuiMatterConsolidator(EntityPlayer player, World world, int x, int y, int z) {
		super(new ContainerMatterConsolidator(player, world, x, y, z), "matterConsolidator", player, world, x, y, z);
	}

}
