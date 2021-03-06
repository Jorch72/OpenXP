package openxp.common.block;

import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import openxp.OpenXP;
import openxp.common.tileentity.TileEntityAutomatedEnchantmentTable;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockAutomatedEnchantmentTable extends BlockEnchantmentTable {

	public BlockAutomatedEnchantmentTable() {

		super(OpenXP.Config.enchantmentTableID);
		setHardness(0.5F);
		setCreativeTab(OpenXP.tabOpenXP);
		GameRegistry.registerBlock(this, "enchantmentTable");

		GameRegistry.registerTileEntity(TileEntityAutomatedEnchantmentTable.class, "enchantmentTable");

		setUnlocalizedName("openxp.enchantmentTable");
	}

	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (player.isSneaking() || tileEntity == null) {
			return false;
		}
		player.openGui(OpenXP.instance, OpenXP.Gui.enchantmentTable.ordinal(), world, x, y, z);
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityAutomatedEnchantmentTable();
	}

}
