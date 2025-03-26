package phrille.vanillaboom.loot;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import phrille.vanillaboom.VanillaBoom;

public class ModLootTables {
    public static final ResourceKey<LootTable> SPRUCE_LEAVES = register("modifiers/blocks/spruce_leaves");
    public static final ResourceKey<LootTable> DROWNED = register("modifiers/entities/drowned");
    public static final ResourceKey<LootTable> POLAR_BEAR = register("modifiers/entities/polar_bear");
    public static final ResourceKey<LootTable> SILVERFISH = register("modifiers/entities/silverfish");
    public static final ResourceKey<LootTable> WITHER_SKELETON = register("modifiers/entities/wither_skeleton");
    public static final ResourceKey<LootTable> FISHING_FISH = register("modifiers/gameplay/fishing/fish");

    private static ResourceKey<LootTable> register(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, VanillaBoom.resLoc(name));
    }
}
