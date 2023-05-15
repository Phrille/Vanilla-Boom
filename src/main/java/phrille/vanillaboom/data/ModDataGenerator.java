package phrille.vanillaboom.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.data.tags.ModBlockTagsProvider;
import phrille.vanillaboom.data.tags.ModEntityTypeTagsProvider;
import phrille.vanillaboom.data.tags.ModItemTagsProvider;

@Mod.EventBusSubscriber(modid = VanillaBoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        //Assets
        //generator.addProvider(new ModBlockStateProvider(generator, existingFileHelper));
        //generator.addProvider(new ModItemModelProvider(generator, existingFileHelper));
        //generator.addProvider(new ModLanguageProvider(generator, "en_us"));

        //Data
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(generator, existingFileHelper);
        generator.addProvider(blockTags);
        generator.addProvider(new ModItemTagsProvider(generator, blockTags, existingFileHelper));
        generator.addProvider(new ModEntityTypeTagsProvider(generator, existingFileHelper));
        //generator.addProvider(new ModRecipeProvider(generator));
    }
}
