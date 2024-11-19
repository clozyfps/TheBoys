
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theboys.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.theboys.network.TrainMessage;
import net.mcreator.theboys.network.TalentMessage;
import net.mcreator.theboys.network.SwitchMoveMessage;
import net.mcreator.theboys.network.OutputMessage;
import net.mcreator.theboys.TheBoysMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TheBoysModKeyMappings {
	public static final KeyMapping OUTPUT = new KeyMapping("key.the_boys.output", GLFW.GLFW_KEY_C, "key.categories.theboys") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheBoysMod.PACKET_HANDLER.sendToServer(new OutputMessage(0, 0));
				OutputMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TALENT = new KeyMapping("key.the_boys.talent", GLFW.GLFW_KEY_F, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheBoysMod.PACKET_HANDLER.sendToServer(new TalentMessage(0, 0));
				TalentMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				TALENT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - TALENT_LASTPRESS);
				TheBoysMod.PACKET_HANDLER.sendToServer(new TalentMessage(1, dt));
				TalentMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SWITCH_MOVE = new KeyMapping("key.the_boys.switch_move", GLFW.GLFW_KEY_R, "key.categories.theboys") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheBoysMod.PACKET_HANDLER.sendToServer(new SwitchMoveMessage(0, 0));
				SwitchMoveMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TRAIN = new KeyMapping("key.the_boys.train", GLFW.GLFW_KEY_N, "key.categories.theboys") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheBoysMod.PACKET_HANDLER.sendToServer(new TrainMessage(0, 0));
				TrainMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long TALENT_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(OUTPUT);
		event.register(TALENT);
		event.register(SWITCH_MOVE);
		event.register(TRAIN);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				OUTPUT.consumeClick();
				TALENT.consumeClick();
				SWITCH_MOVE.consumeClick();
				TRAIN.consumeClick();
			}
		}
	}
}
