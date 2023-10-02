package phrille.vanillaboom.loot;

import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import phrille.vanillaboom.VanillaBoom;

public class LootTableHandler {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLMS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, VanillaBoom.MOD_ID);

    public static final RegistryObject<Codec<DropLootModifier>> DROP_LOOT_MODIFIER = GLMS.register("drop_loot_modifier", DropLootModifier.CODEC);
    public static final RegistryObject<Codec<FishingLootModifier>> FISHING_MODIFIER = GLMS.register("fishing_modifier", FishingLootModifier.CODEC);

    public static LootTableReference getLootTableReference(String resLoc) {
        return (LootTableReference) LootTableReference.lootTableReference(new ResourceLocation(resLoc)).build();
    }

    public static String getString(LootTableReference lootTable) {
        return lootTable.name.toString();
    }
}