package phrille.vanillaboom.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper fileHelper) {
        super(gen, VanillaBoom.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
