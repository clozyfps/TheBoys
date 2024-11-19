package net.mcreator.theboys.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.theboys.world.inventory.PhoneMenu;
import net.mcreator.theboys.network.PhoneButtonMessage;
import net.mcreator.theboys.TheBoysMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PhoneScreen extends AbstractContainerScreen<PhoneMenu> {
	private final static HashMap<String, Object> guistate = PhoneMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_instagramicon;

	public PhoneScreen(PhoneMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("the_boys:textures/screens/phone.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("the_boys:textures/screens/phonescreen.png"), this.leftPos + -214, this.topPos + -37, 0, 0, 427, 240, 427, 240);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		imagebutton_instagramicon = new ImageButton(this.leftPos + -27, this.topPos + 4, 50, 50, 0, 0, 50, new ResourceLocation("the_boys:textures/screens/atlas/imagebutton_instagramicon.png"), 50, 100, e -> {
			if (true) {
				TheBoysMod.PACKET_HANDLER.sendToServer(new PhoneButtonMessage(0, x, y, z));
				PhoneButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_instagramicon", imagebutton_instagramicon);
		this.addRenderableWidget(imagebutton_instagramicon);
	}
}
