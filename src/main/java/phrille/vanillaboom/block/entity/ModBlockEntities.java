package phrille.vanillaboom.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, VanillaBoom.MOD_ID);

    public static final RegistryObject<BlockEntityType<RainDetectorBlockEntity>> RAIN_DETECTOR = BLOCK_ENTITY_TYPES.register("rain_detector", () -> BlockEntityType.Builder.of(RainDetectorBlockEntity::new, ModBlocks.RAIN_DETECTOR.get()).build(null));
}
