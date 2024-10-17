package phrille.vanillaboom.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

@SuppressWarnings("ConstantConditions")
public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, VanillaBoom.MOD_ID);

    public static final RegistryObject<BlockEntityType<RainDetectorBlockEntity>> RAIN_DETECTOR = BLOCK_ENTITIES.register("rain_detector", () -> BlockEntityType.Builder.of(RainDetectorBlockEntity::new, ModBlocks.RAIN_DETECTOR.get()).build(null));
}
