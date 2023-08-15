package fr.shoqapik.nofishingbooks;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

@Mod("nofishingbooks")
public class NoFishingBooks {
  public static final String MODID = "nofishingbooks";
  
  public NoFishingBooks() {
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, (IConfigSpec)NoFishingConfig.SPEC, "no-fishing-books.toml");
    MinecraftForge.EVENT_BUS.register(this);
  }
  
  @SubscribeEvent
  public void onItemFish(ItemFishedEvent event) {
    for (ItemStack stack : event.getDrops()) {
      if (NoFishingConfig.BANNED_ITEMS.get().contains(Registry.ITEM.getKey(stack.getItem()).toString())) {
        event.getEntity().sendSystemMessage((Component)Component.literal("" + ChatFormatting.RED + stack.getItem().toString() + " is banned from being fished."));
        event.setCanceled(true);
      } 
    } 
  }
}
