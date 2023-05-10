package phrille.vanillaboom.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

public class ModBlockEntities {
    private static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, VanillaBoom.MOD_ID);

    public static final RegistryObject<BlockEntityType<RainDetectorBlockEntity>> RAIN_DETECTOR = TILE_ENTITY_TYPES.register("rain_detector", () -> BlockEntityType.Builder.of(RainDetectorBlockEntity::new, ModBlocks.RAIN_DETECTOR.get()).build(null));

    public static void init(IEventBus modEventBus) {
        TILE_ENTITY_TYPES.register(modEventBus);
    }
}
