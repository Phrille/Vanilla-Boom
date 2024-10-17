package phrille.vanillaboom.block.tile;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

public class ModTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, VanillaBoom.MOD_ID);

    public static final RegistryObject<TileEntityType<RainDetectorTileEntity>> RAIN_DETECTOR = TILE_ENTITIES.register("rain_detector", () -> TileEntityType.Builder.of(RainDetectorTileEntity::new, ModBlocks.RAIN_DETECTOR.get()).build(null));
}
