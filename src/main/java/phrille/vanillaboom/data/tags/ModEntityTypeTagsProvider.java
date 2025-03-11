package phrille.vanillaboom.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.ModEntities;
import phrille.vanillaboom.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public ModEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VanillaBoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        // VanillaBoom Tags
        tag(ModTags.VanillaBoomTags.Entities.PRISMARINE_EXTRA_HURT)
                .add(EntityType.BLAZE)
                .add(EntityType.STRIDER)
                .add(EntityType.MAGMA_CUBE);

        // Vanilla Tags
        tag(EntityTypeTags.ARROWS).add(ModEntities.PRISMARINE_ARROW.get());
        tag(EntityTypeTags.AXOLOTL_HUNT_TARGETS)
                .add(ModEntities.TUNA.get())
                .add(ModEntities.PERCH.get())
                .add(ModEntities.PIKE.get())
                .add(ModEntities.EEL.get());
    }
}
