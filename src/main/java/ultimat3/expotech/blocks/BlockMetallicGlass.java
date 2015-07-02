package ultimat3.expotech.blocks;

import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMetallicGlass extends Ultimat3Block {

	public BlockMetallicGlass(String name) {
		super(name, Material.glass);
		setHarvestLevel("pickaxe", 2);
	}
	@Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}