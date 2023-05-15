package phrille.vanillaboom.data.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.entity.ModEntities;

public class ModEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public ModEntityTypeTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, VanillaBoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(EntityTypeTags.ARROWS).add(ModEntities.PRISMARINE_ARROW.get());
        tag(EntityTypeTags.AXOLOTL_HUNT_TARGETS)
                .add(ModEntities.TUNA.get())
                .add(ModEntities.PERCH.get())
                .add(ModEntities.PIKE.get())
                .add(ModEntities.EEL.get());
    }
}
