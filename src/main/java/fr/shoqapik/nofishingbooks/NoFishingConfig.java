package fr.shoqapik.nofishingbooks;

import java.util.Arrays;
import java.util.List;
import net.minecraftforge.common.ForgeConfigSpec;

public class NoFishingConfig {
  public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
  
  public static final ForgeConfigSpec SPEC;
  
  static {
    BUILDER.push("NoFishing Configuration");
  }
  
  public static final ForgeConfigSpec.ConfigValue<List<? extends String>> BANNED_ITEMS = BUILDER.comment("List of banned fished items").defineList("banned_items", Arrays.asList("minecraft:enchanted_book"), item -> true);
  
  static {
    BUILDER.pop();
    SPEC = BUILDER.build();
  }
}
