package phrille.vanillaboom.data.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
        super(generator, blockTags, VanillaBoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

    }
}
