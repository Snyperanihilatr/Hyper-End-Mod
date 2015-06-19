package ultimat3.endgamemod.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import ultimat3.endgamemod.blocks.machines.tileentity.TileEntityProductionFurnace;
import ultimat3.endgamemod.gui.slot.SlotMachineFuel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

<<<<<<< HEAD
public class ContainerProductionFurnace extends ContainerMachine {
=======
public class ContainerProductionFurnace extends Container {
	
	@SuppressWarnings("unused")
	private World						world;
	private TileEntityProductionFurnace	machine;
	private short						lastCookTime;
	private short						lastBurnTime;
>>>>>>> fa3e81984486903a91271b84c55562d3acb95396
	
	public ContainerProductionFurnace(EntityPlayer player, World world, int x, int y, int z) {
		super(player, world, x, y, z);
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int slotID) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotID);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			// Output slot
			if (slotID == 2) {
				
				// Add to inv
				if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
				
				// Inventory slots
			} else if (slotID != 1 && slotID != 0) {
				
				// If it's smeltable, add it to the input slot
				if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
					if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
						return null;
					}
					
					// Fuel? Add to the fuel slot
				} else if (itemstack1.getItem() == Item.getItemFromBlock(Blocks.coal_block)) {
					if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
						return null;
					}
					
					// Main inventory? Add to hotbar
				} else if (slotID >= 3 && slotID < 30) {
					if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
						return null;
					}
					
					// Hotbar? Add to main inv
				} else if (slotID >= 30 && slotID < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
				return null;
			}
			
			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
			
			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}
			
			slot.onPickupFromSlot(player, itemstack1);
		}
		
		return itemstack;
	}

	@Override
	protected Slot[] getSlotsForAdding() {
		return new Slot[] {
				new Slot(machine, 0, 56, 17),
				new SlotMachineFuel(machine, 1, new ItemStack(Blocks.coal_block), 56, 53),
				new Slot(machine, 2, 116, 35)
		};
	}
}
