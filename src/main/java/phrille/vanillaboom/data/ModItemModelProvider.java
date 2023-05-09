package phrille.vanillaboom.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, VanillaBoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        item(ModItems.APPLE_PIE);
    }

    public void item(Item item) {
        item(item, "generated");
    }

    public void item(Item item, String parent) {
        withExistingParent(name(item), ModelProvider.ITEM_FOLDER + "/" + parent)
                .texture("layer0", itemTexture(item));
    }

    protected ResourceLocation itemTexture(Item item) {
        ResourceLocation name = item.getRegistryName();
        return new ResourceLocation(name.getNamespace(), ModelProvider.ITEM_FOLDER + "/" + name.getPath());
    }

    protected String name(Item item) {
        return item.getRegistryName().getPath();
    }
}
