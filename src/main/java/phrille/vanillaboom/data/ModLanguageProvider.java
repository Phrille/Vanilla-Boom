package phrille.vanillaboom.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(DataGenerator gen, String locale) {
        super(gen, VanillaBoom.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("language.name", "English");
        add("language.region", "United States");
        add("language.locale", "en_us");

        add("itemGroup.vanillaboom_tab", "Vanilla Boom");
        add("itemGroup.vanillaboom_variant_blocks_tab", "Vanilla Boom: Variant Blocks");

        add(ModBlocks.COBBLESTONE_BRICKS, "Cobblestone Bricks");
    }
}
