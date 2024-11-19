package net.mcreator.theboys.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.theboys.world.inventory.InstagramMenu;
import net.mcreator.theboys.procedures.FollowersCounterProcedure;
import net.mcreator.theboys.network.InstagramButtonMessage;
import net.mcreator.theboys.TheBoysMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class InstagramScreen extends AbstractContainerScreen<InstagramMenu> {
	private final static HashMap<String, Object> guistate = InstagramMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_invis;
	ImageButton imagebutton_recordbutton;

	public InstagramScreen(InstagramMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("the_boys:textures/screens/instagram.png");

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
		guiGraphics.drawString(this.font,

				FollowersCounterProcedure.execute(entity), -42, -2, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_invis = new ImageButton(this.leftPos + -12, this.topPos + 165, 20, 20, 0, 0, 20, new ResourceLocation("the_boys:textures/screens/atlas/imagebutton_invis.png"), 20, 40, e -> {
			if (true) {
				TheBoysMod.PACKET_HANDLER.sendToServer(new InstagramButtonMessage(0, x, y, z));
				InstagramButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_invis", imagebutton_invis);
		this.addRenderableWidget(imagebutton_invis);
		imagebutton_recordbutton = new ImageButton(this.leftPos + -28, this.topPos + 7, 50, 50, 0, 0, 50, new ResourceLocation("the_boys:textures/screens/atlas/imagebutton_recordbutton.png"), 50, 100, e -> {
			if (true) {
				TheBoysMod.PACKET_HANDLER.sendToServer(new InstagramButtonMessage(1, x, y, z));
				InstagramButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_recordbutton", imagebutton_recordbutton);
		this.addRenderableWidget(imagebutton_recordbutton);
	}
}
