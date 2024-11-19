package net.mcreator.theboys.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.theboys.TheBoysMod;

import java.util.function.Supplier;
import java.util.ArrayList;

import com.ibm.icu.util.Output;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheBoysModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		TheBoysMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Power = original.Power;
			clone.Mastery = original.Mastery;
			clone.Output = original.Output;
			clone.VModifier = original.VModifier;
			clone.Move1 = original.Move1;
			clone.Move2 = original.Move2;
			clone.CurrentTalent = original.CurrentTalent;
			clone.LightPower = original.LightPower;
			clone.Live = original.Live;
			clone.Reputation = original.Reputation;
			clone.Popularity = original.Popularity;
			clone.LiveGeneration = original.LiveGeneration;
			clone.HeroName = original.HeroName;
			clone.Move3 = original.Move3;
			clone.Move4 = original.Move4;
			clone.Move5 = original.Move5;
			clone.TrainingSwitch = original.TrainingSwitch;
			clone.StrengthEXP = original.StrengthEXP;
			clone.StrengthCap = original.StrengthCap;
			clone.StrengthLevel = original.StrengthLevel;
			clone.DefenseEXP = original.DefenseEXP;
			clone.DefenseCap = original.DefenseCap;
			clone.DefenseLevel = original.DefenseLevel;
			if (!event.isWasDeath()) {
				clone.SpeedSoundCheck = original.SpeedSoundCheck;
				clone.HeadSave = original.HeadSave;
				clone.ChestSave = original.ChestSave;
				clone.LegSave = original.LegSave;
				clone.BootSave = original.BootSave;
				clone.Laser = original.Laser;
				clone.Flight = original.Flight;
				clone.Blood = original.Blood;
				clone.LiveViewers = original.LiveViewers;
			}
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("the_boys", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public String Power = "";
		public double Mastery = 0;
		public double Output = 0;
		public boolean SpeedSoundCheck = false;
		public ItemStack HeadSave = ItemStack.EMPTY;
		public ItemStack ChestSave = ItemStack.EMPTY;
		public ItemStack LegSave = ItemStack.EMPTY;
		public ItemStack BootSave = ItemStack.EMPTY;
		public double VModifier = 0;
		public String Move1 = "";
		public String Move2 = "";
		public String CurrentTalent = "";
		public boolean Laser = false;
		public boolean Flight = false;
		public double LightPower = 0;
		public double Blood = 0;
		public boolean Live = false;
		public double LiveViewers = 0;
		public double Reputation = 0;
		public double Popularity = 0;
		public double LiveGeneration = 0;
		public String HeroName = "\"\"";
		public String Move3 = "\"\"";
		public String Move4 = "\"\"";
		public String Move5 = "\"\"";
		public double TrainingSwitch = 0;
		public double StrengthEXP = 0.0;
		public double StrengthCap = 10.0;
		public double StrengthLevel = 0;
		public double DefenseEXP = 0;
		public double DefenseCap = 10.0;
		public double DefenseLevel = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				TheBoysMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(entity.level()::dimension), new PlayerVariablesSyncMessage(this, entity.getId()));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("Power", Power);
			nbt.putDouble("Mastery", Mastery);
			nbt.putDouble("Output", Output);
			nbt.putBoolean("SpeedSoundCheck", SpeedSoundCheck);
			nbt.put("HeadSave", HeadSave.save(new CompoundTag()));
			nbt.put("ChestSave", ChestSave.save(new CompoundTag()));
			nbt.put("LegSave", LegSave.save(new CompoundTag()));
			nbt.put("BootSave", BootSave.save(new CompoundTag()));
			nbt.putDouble("VModifier", VModifier);
			nbt.putString("Move1", Move1);
			nbt.putString("Move2", Move2);
			nbt.putString("CurrentTalent", CurrentTalent);
			nbt.putBoolean("Laser", Laser);
			nbt.putBoolean("Flight", Flight);
			nbt.putDouble("LightPower", LightPower);
			nbt.putDouble("Blood", Blood);
			nbt.putBoolean("Live", Live);
			nbt.putDouble("LiveViewers", LiveViewers);
			nbt.putDouble("Reputation", Reputation);
			nbt.putDouble("Popularity", Popularity);
			nbt.putDouble("LiveGeneration", LiveGeneration);
			nbt.putString("HeroName", HeroName);
			nbt.putString("Move3", Move3);
			nbt.putString("Move4", Move4);
			nbt.putString("Move5", Move5);
			nbt.putDouble("TrainingSwitch", TrainingSwitch);
			nbt.putDouble("StrengthEXP", StrengthEXP);
			nbt.putDouble("StrengthCap", StrengthCap);
			nbt.putDouble("StrengthLevel", StrengthLevel);
			nbt.putDouble("DefenseEXP", DefenseEXP);
			nbt.putDouble("DefenseCap", DefenseCap);
			nbt.putDouble("DefenseLevel", DefenseLevel);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Power = nbt.getString("Power");
			Mastery = nbt.getDouble("Mastery");
			Output = nbt.getDouble("Output");
			SpeedSoundCheck = nbt.getBoolean("SpeedSoundCheck");
			HeadSave = ItemStack.of(nbt.getCompound("HeadSave"));
			ChestSave = ItemStack.of(nbt.getCompound("ChestSave"));
			LegSave = ItemStack.of(nbt.getCompound("LegSave"));
			BootSave = ItemStack.of(nbt.getCompound("BootSave"));
			VModifier = nbt.getDouble("VModifier");
			Move1 = nbt.getString("Move1");
			Move2 = nbt.getString("Move2");
			CurrentTalent = nbt.getString("CurrentTalent");
			Laser = nbt.getBoolean("Laser");
			Flight = nbt.getBoolean("Flight");
			LightPower = nbt.getDouble("LightPower");
			Blood = nbt.getDouble("Blood");
			Live = nbt.getBoolean("Live");
			LiveViewers = nbt.getDouble("LiveViewers");
			Reputation = nbt.getDouble("Reputation");
			Popularity = nbt.getDouble("Popularity");
			LiveGeneration = nbt.getDouble("LiveGeneration");
			HeroName = nbt.getString("HeroName");
			Move3 = nbt.getString("Move3");
			Move4 = nbt.getString("Move4");
			Move5 = nbt.getString("Move5");
			TrainingSwitch = nbt.getDouble("TrainingSwitch");
			StrengthEXP = nbt.getDouble("StrengthEXP");
			StrengthCap = nbt.getDouble("StrengthCap");
			StrengthLevel = nbt.getDouble("StrengthLevel");
			DefenseEXP = nbt.getDouble("DefenseEXP");
			DefenseCap = nbt.getDouble("DefenseCap");
			DefenseLevel = nbt.getDouble("DefenseLevel");
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TheBoysMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	public static class PlayerVariablesSyncMessage {
		private final int target;
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
			this.target = buffer.readInt();
		}

		public PlayerVariablesSyncMessage(PlayerVariables data, int entityid) {
			this.data = data;
			this.target = entityid;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
			buffer.writeInt(message.target);
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.level().getEntity(message.target).getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Power = message.data.Power;
					variables.Mastery = message.data.Mastery;
					variables.Output = message.data.Output;
					variables.SpeedSoundCheck = message.data.SpeedSoundCheck;
					variables.HeadSave = message.data.HeadSave;
					variables.ChestSave = message.data.ChestSave;
					variables.LegSave = message.data.LegSave;
					variables.BootSave = message.data.BootSave;
					variables.VModifier = message.data.VModifier;
					variables.Move1 = message.data.Move1;
					variables.Move2 = message.data.Move2;
					variables.CurrentTalent = message.data.CurrentTalent;
					variables.Laser = message.data.Laser;
					variables.Flight = message.data.Flight;
					variables.LightPower = message.data.LightPower;
					variables.Blood = message.data.Blood;
					variables.Live = message.data.Live;
					variables.LiveViewers = message.data.LiveViewers;
					variables.Reputation = message.data.Reputation;
					variables.Popularity = message.data.Popularity;
					variables.LiveGeneration = message.data.LiveGeneration;
					variables.HeroName = message.data.HeroName;
					variables.Move3 = message.data.Move3;
					variables.Move4 = message.data.Move4;
					variables.Move5 = message.data.Move5;
					variables.TrainingSwitch = message.data.TrainingSwitch;
					variables.StrengthEXP = message.data.StrengthEXP;
					variables.StrengthCap = message.data.StrengthCap;
					variables.StrengthLevel = message.data.StrengthLevel;
					variables.DefenseEXP = message.data.DefenseEXP;
					variables.DefenseCap = message.data.DefenseCap;
					variables.DefenseLevel = message.data.DefenseLevel;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
