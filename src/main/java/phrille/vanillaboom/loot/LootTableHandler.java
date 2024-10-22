package phrille.vanillaboom.loot;

import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import phrille.vanillaboom.VanillaBoom;

@SuppressWarnings("unused")
public class LootTableHandler {
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> GLMS = DeferredRegister.create(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, VanillaBoom.MOD_ID);

    public static final RegistryObject<DropLootModifier.Serializer> WITHER_SKELETON = GLMS.register("wither_skeleton", DropLootModifier.Serializer::new);
    public static final RegistryObject<DropLootModifier.Serializer> SILVERFISH = GLMS.register("silverfish", DropLootModifier.Serializer::new);
    public static final RegistryObject<DropLootModifier.Serializer> DROWNED = GLMS.register("drowned", DropLootModifier.Serializer::new);
    public static final RegistryObject<DropLootModifier.Serializer> POLAR_BEAR = GLMS.register("polar_bear", DropLootModifier.Serializer::new);
    public static final RegistryObject<DropLootModifier.Serializer> SPRUCE_LEAVES = GLMS.register("spruce_leaves", DropLootModifier.Serializer::new);
    public static final RegistryObject<FishingLootModifier.Serializer> FISHING = GLMS.register("fishing", FishingLootModifier.Serializer::new);
}
