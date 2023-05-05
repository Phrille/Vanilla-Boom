package phrille.vanillaboom.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, VanillaBoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }
}
