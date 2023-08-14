package net.mcreator.mechinaaddon.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.mechinaaddon.block.RemoteRedstoneBlockBlock;
import net.mcreator.mechinaaddon.block.RedstoneInterlockingBlockBlock;
import net.mcreator.mechinaaddon.block.InputsignalblockBlock;
import net.mcreator.mechinaaddon.MechinaAddonMod;

import java.util.Map;

public class RedstoneConnecterRightclickedOnBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MechinaAddonMod.LOGGER.warn("Failed to load dependency world for procedure RedstoneConnecterRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MechinaAddonMod.LOGGER.warn("Failed to load dependency x for procedure RedstoneConnecterRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MechinaAddonMod.LOGGER.warn("Failed to load dependency y for procedure RedstoneConnecterRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MechinaAddonMod.LOGGER.warn("Failed to load dependency z for procedure RedstoneConnecterRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MechinaAddonMod.LOGGER.warn("Failed to load dependency entity for procedure RedstoneConnecterRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				MechinaAddonMod.LOGGER.warn("Failed to load dependency itemstack for procedure RedstoneConnecterRightclickedOnBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == InputsignalblockBlock.block) {
			itemstack.getOrCreateTag().putDouble("position_X", x);
			itemstack.getOrCreateTag().putDouble("position_Y", y);
			itemstack.getOrCreateTag().putDouble("position_Z", z);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("you set ps: ("
						+ itemstack.getOrCreateTag().getDouble("position_X") + ", " + itemstack.getOrCreateTag().getDouble("position_Y") + ", "
						+ itemstack.getOrCreateTag().getDouble("position_Z") + " )")), (false));
			}
			itemstack.getOrCreateTag().putBoolean("Config", (true));
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == InputsignalblockBlock.block
				&& itemstack.getOrCreateTag().getBoolean("Config") == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Select Your Signal block"), (false));
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == RemoteRedstoneBlockBlock.block
				&& itemstack.getOrCreateTag().getBoolean("Config") == true) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(x, y, z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("position_X", (itemstack.getOrCreateTag().getDouble("position_X")));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(x, y, z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("position_Y", (itemstack.getOrCreateTag().getDouble("position_Y")));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(x, y, z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("position_Z", (itemstack.getOrCreateTag().getDouble("position_Z")));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			itemstack.getOrCreateTag().putBoolean("Config", (false));
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("all settings complete"), (false));
			}
		} else if (itemstack.getOrCreateTag().getBoolean("Config") == true
				&& (!((world.getBlockState(new BlockPos(x, y, z))).getBlock() == RemoteRedstoneBlockBlock.block)
						|| !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == RedstoneInterlockingBlockBlock.block))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Select Your Remote block"), (false));
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == RedstoneInterlockingBlockBlock.block
				&& itemstack.getOrCreateTag().getBoolean("Config")) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(x, y, z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("NumPositionX", (itemstack.getOrCreateTag().getDouble("position_X")));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(x, y, z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("NumPositionY", (itemstack.getOrCreateTag().getDouble("position_Y")));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(x, y, z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("NumPositionZ", (itemstack.getOrCreateTag().getDouble("position_Z")));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("all settings complete"), (false));
			}
			itemstack.getOrCreateTag().putBoolean("Config", (false));
		}
	}
}
