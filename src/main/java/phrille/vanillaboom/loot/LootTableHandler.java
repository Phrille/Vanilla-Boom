package phrille.vanillaboom.loot;

import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;

public class LootTableHandler {
    private static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, VanillaBoom.MOD_ID);

    private static final RegistryObject<DropLootModifier.Serializer> WITHER_SKELETON = GLM.register("wither_skeleton", DropLootModifier.Serializer::new);
    private static final RegistryObject<DropLootModifier.Serializer> SILVERFISH = GLM.register("silverfish", DropLootModifier.Serializer::new);
    private static final RegistryObject<DropLootModifier.Serializer> DROWNED = GLM.register("drowned", DropLootModifier.Serializer::new);
    private static final RegistryObject<DropLootModifier.Serializer> POLAR_BEAR = GLM.register("polar_bear", DropLootModifier.Serializer::new);
    private static final RegistryObject<DropLootModifier.Serializer> SPRUCE_LEAVES = GLM.register("spruce_leaves", DropLootModifier.Serializer::new);
    private static final RegistryObject<DropLootModifier.Serializer> PUMPKIN = GLM.register("pumpkin", DropLootModifier.Serializer::new);
    private static final RegistryObject<FishingLootModifier.Serializer> FISHING = GLM.register("fishing", FishingLootModifier.Serializer::new);

    public static void init(IEventBus modEventBus) {
        GLM.register(modEventBus);
    }
}
