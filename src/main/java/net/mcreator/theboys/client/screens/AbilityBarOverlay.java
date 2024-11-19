
package net.mcreator.theboys.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.theboys.procedures.SelectedMove5DisplayProcedure;
import net.mcreator.theboys.procedures.SelectedMove4DisplayProcedure;
import net.mcreator.theboys.procedures.SelectedMove3DisplayProcedure;
import net.mcreator.theboys.procedures.SelectedMove2DisplayProcedure;
import net.mcreator.theboys.procedures.SelectedMove1DisplayProcedure;
import net.mcreator.theboys.procedures.HomelanderDisplayProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class AbilityBarOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (HomelanderDisplayProcedure.execute(entity)) {
			if (HomelanderDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_boys:textures/screens/homelandernewbar.png"), 5, h - 31, 0, 0, 97, 25, 97, 25);
			}
			if (SelectedMove1DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_boys:textures/screens/ability_selected.png"), 5, h - 32, 0, 0, 26, 26, 26, 26);
			}
			if (SelectedMove4DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_boys:textures/screens/ability_selected.png"), 58, h - 32, 0, 0, 26, 26, 26, 26);
			}
			if (SelectedMove2DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_boys:textures/screens/ability_selected.png"), 22, h - 32, 0, 0, 26, 26, 26, 26);
			}
			if (SelectedMove3DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_boys:textures/screens/ability_selected.png"), 39, h - 32, 0, 0, 26, 26, 26, 26);
			}
			if (SelectedMove5DisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("the_boys:textures/screens/ability_selected.png"), 76, h - 32, 0, 0, 26, 26, 26, 26);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
