package ultimat3.endgamemod.gui;

import org.lwjgl.opengl.GL11;

import ultimat3.endgamemod.Reference;
import ultimat3.endgamemod.blocks.machines.tileentity.TileEntityForcefieldController;
import ultimat3.endgamemod.gui.container.ContainerForcefieldController;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiForcefieldController extends GuiContainer {
	
	private ResourceLocation				guiTex;
	private TileEntityForcefieldController	controller;
	
	public GuiForcefieldController(EntityPlayer player, World world, int x, int y, int z) {
		super(new ContainerForcefieldController(player, world, x, y, z));
		this.controller = ((TileEntityForcefieldController) world.getTileEntity(x, y, z));
		this.guiTex = new ResourceLocation(Reference.MOD_ID + ":textures/gui/container/forceFieldController.png");
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		ITextureObject tex = mc.renderEngine.getTexture(guiTex);
		GL11.glColor4f(1, 1, 1, 1);
		mc.renderEngine.bindTexture(guiTex);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}
	
}
