package phrille.vanillaboom.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.ModEntities;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public ModEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VanillaBoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(EntityTypeTags.ARROWS).add(ModEntities.PRISMARINE_ARROW.get());
        tag(EntityTypeTags.AXOLOTL_HUNT_TARGETS)
                .add(ModEntities.TUNA.get())
                .add(ModEntities.PERCH.get())
                .add(ModEntities.PIKE.get())
                .add(ModEntities.EEL.get());
    }
}
