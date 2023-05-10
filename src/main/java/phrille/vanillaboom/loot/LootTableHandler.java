package phrille.vanillaboom.loot;

import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;

public class LootTableHandler {
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> GLMS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, VanillaBoom.MOD_ID);

    private static final RegistryObject<DropLootModifier.Serializer> WITHER_SKELETON = GLMS.register("wither_skeleton", DropLootModifier.Serializer::new);
    private static final RegistryObject<DropLootModifier.Serializer> SILVERFISH = GLMS.register("silverfish", DropLootModifier.Serializer::new);
    private static final RegistryObject<DropLootModifier.Serializer> DROWNED = GLMS.register("drowned", DropLootModifier.Serializer::new);
    private static final RegistryObject<DropLootModifier.Serializer> POLAR_BEAR = GLMS.register("polar_bear", DropLootModifier.Serializer::new);
    private static final RegistryObject<DropLootModifier.Serializer> SPRUCE_LEAVES = GLMS.register("spruce_leaves", DropLootModifier.Serializer::new);
    private static final RegistryObject<DropLootModifier.Serializer> PUMPKIN = GLMS.register("pumpkin", DropLootModifier.Serializer::new);
    private static final RegistryObject<FishingLootModifier.Serializer> FISHING = GLMS.register("fishing", FishingLootModifier.Serializer::new);
}
