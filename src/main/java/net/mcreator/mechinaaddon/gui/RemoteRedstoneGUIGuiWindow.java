
package net.mcreator.mechinaaddon.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.mechinaaddon.MechinaAddonMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class RemoteRedstoneGUIGuiWindow extends ContainerScreen<RemoteRedstoneGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = RemoteRedstoneGUIGui.guistate;

	public RemoteRedstoneGUIGuiWindow(RemoteRedstoneGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 291;
		this.ySize = 181;
	}

	private static final ResourceLocation texture = new ResourceLocation("mechina_addon:textures/screens/remote_redstone_gui.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Remote Redstone controller", 10, 5, -13369549);
		this.font.drawString(ms, "X: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "position_X")) + "", 10, 104, -12829636);
		this.font.drawString(ms, "Y: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "position_Y")) + "", 10, 113, -12829636);
		this.font.drawString(ms, "Z: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "position_Z")) + "", 10, 122, -12829636);
		this.font.drawString(ms, "RelayTick: ", 10, 32, -256);
		this.font.drawString(ms, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "RedstoneTick")) + "", 64, 32, -16777012);
		this.font.drawString(ms, "ConfigSet:" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "SettingValue")) + "", 10, 23, -65536);
		this.font.drawString(ms, "StartSignal: " + (new Object() {
			public boolean getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "StartTick")) + "", 10, 158, -256);
		this.font.drawString(ms, "BreakSet: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Break_set")) + "", 51, 41, -16737844);
		this.font.drawString(ms, "Lee eun woo neun 1 Tick lee 0.1Sec Rae-Yo", 10, 14, -65536);
		this.font.drawString(ms, "RedstoneSignal: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Redstone_ON")) + "", 10, 149, -65536);
		this.font.drawString(ms, "Relay: " + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "RelayNumberText")) + "", 10, 140, -12829636);
		this.font.drawString(ms, "Always On: " + (new Object() {
			public boolean getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "AlwaysOn")) + "", 10, 167, -65281);
		this.font.drawString(ms, "Break Relay Tick: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "BreakTick")) + "", 10, 50, -16776961);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 103, this.guiTop + 59, 40, 20, new StringTextComponent("x10"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(0, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 198, this.guiTop + 59, 51, 20, new StringTextComponent("Reset"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(1, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 103, this.guiTop + 80, 46, 20, new StringTextComponent("x100"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(2, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 145, this.guiTop + 59, 51, 20, new StringTextComponent("x1000"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(3, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 151, this.guiTop + 80, 56, 20, new StringTextComponent("x10000"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(4, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 209, this.guiTop + 80, 40, 20, new StringTextComponent("Set"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(5, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 45, this.guiTop + 80, 56, 20, new StringTextComponent("Start!"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(6, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 46, this.guiTop + 59, 51, 20, new StringTextComponent("Ready"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(7, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 103, this.guiTop + 104, 35, 20, new StringTextComponent("B1"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(8, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 140, this.guiTop + 104, 46, 20, new StringTextComponent("B10"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(9, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 188, this.guiTop + 104, 46, 20, new StringTextComponent("B100"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(10, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 226, this.guiTop + 126, 61, 20, new StringTextComponent("B/Reset"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(11, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 236, this.guiTop + 104, 51, 20, new StringTextComponent("B/Set"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(12, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 12, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 147, this.guiTop + 126, 72, 20, new StringTextComponent("Always On"), e -> {
			if (true) {
				MechinaAddonMod.PACKET_HANDLER.sendToServer(new RemoteRedstoneGUIGui.ButtonPressedMessage(13, x, y, z));
				RemoteRedstoneGUIGui.handleButtonAction(entity, 13, x, y, z);
			}
		}));
	}
}
