package ultimat3.endgamemod.init;

import ultimat3.endgamemod.blocks.machines.tileentity.TileEntityForcefieldController;
import ultimat3.endgamemod.blocks.machines.tileentity.TileEntityHighProductionFurnace;
import ultimat3.endgamemod.blocks.machines.tileentity.TileEntityMechanicalAssembler;
import ultimat3.endgamemod.blocks.machines.tileentity.TileEntityMetallurgyChamber;
import ultimat3.endgamemod.blocks.machines.tileentity.TileEntityProductionFurnace;
import ultimat3.endgamemod.blocks.machines.tileentity.TileEntitySuperCompressor;
import ultimat3.endgamemod.multiblock.ParticleAcceleratorMultiblock;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {
	
	public static final String	PRODUCTION_FURNACE_ID		= "u3_egm_productionFurnace";
	public static final String	HIGH_PRODUCTION_FURNACE_ID	= "u3_egm_highProductionFurnace";
	public static final String	SUPER_COMPRESSOR_ID			= "u3_egm_superCompressor";
	public static final String	METALLURGY_CHAMBER_ID		= "u3_egm_metallurgyChamber";
	public static final String	FORCEFIELD_CONTROLLER_ID	= "u3_egm_forcefieldController";
	public static final String	MECHANICAL_ASSEMBLER_ID		= "u3_egm_mechanicalAssembler";
	public static final String	PARTICLE_ACCELERATOR_ID		= "u3_egm_particleAccelerator";
	
	public static void init() {
		GameRegistry.registerTileEntity(TileEntityProductionFurnace.class, PRODUCTION_FURNACE_ID);
		GameRegistry.registerTileEntity(TileEntityHighProductionFurnace.class, HIGH_PRODUCTION_FURNACE_ID);
		GameRegistry.registerTileEntity(TileEntitySuperCompressor.class, SUPER_COMPRESSOR_ID);
		GameRegistry.registerTileEntity(TileEntityMetallurgyChamber.class, METALLURGY_CHAMBER_ID);
		GameRegistry.registerTileEntity(TileEntityForcefieldController.class, FORCEFIELD_CONTROLLER_ID);
		GameRegistry.registerTileEntity(TileEntityMechanicalAssembler.class, MECHANICAL_ASSEMBLER_ID);
		GameRegistry.registerTileEntity(ParticleAcceleratorMultiblock.class, PARTICLE_ACCELERATOR_ID);
	}
	
}
