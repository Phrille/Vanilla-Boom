/*
 * Copyright (C) 2023-2025 Phrille
 *
 * This file is part of the Vanilla Boom Mod.
 * Unauthorized distribution or modification is prohibited.
 * See LICENSE for details.
 */

package phrille.vanillaboom.data;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.EaselBlock;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.block.ModCakeBlock;
import phrille.vanillaboom.block.RainDetectorBlock;
import phrille.vanillaboom.block.crop.RicePlantBlock;
import phrille.vanillaboom.block.crop.TrellisBlock;
import phrille.vanillaboom.block.crop.TrellisCropBlock;
import phrille.vanillaboom.block.variant.*;
import phrille.vanillaboom.util.Utils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ModBlockStateProvider extends BlockStateProvider {
    public static final String RENDER_TYPE_CUTOUT = "cutout";
    public static final String RENDER_TYPE_CUTOUT_MIPPED = "cutout_mipped";
    public static final String RENDER_TYPE_TRANSLUCENT = "translucent";

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, VanillaBoom.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Models
        trellisCropModel();

        // Bricks
        simpleBlock(ModBlocks.COBBLESTONE_BRICKS.get());
        simpleBlock(ModBlocks.MOSSY_COBBLESTONE_BRICKS.get());
        simpleBlock(ModBlocks.MAGMA_BRICKS.get());
        simpleBlock(ModBlocks.OBSIDIAN_BRICKS.get());
        simpleBlock(ModBlocks.SNOW_BRICKS.get());
        simpleBlock(ModBlocks.TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.WHITE_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.ORANGE_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.YELLOW_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.LIME_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.PINK_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.GRAY_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.CYAN_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.PURPLE_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.BLUE_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.BROWN_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.GREEN_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.RED_TERRACOTTA_BRICKS.get());
        simpleBlock(ModBlocks.BLACK_TERRACOTTA_BRICKS.get());

        // Rocks
        simpleBlock(ModBlocks.PERIDOTITE.get());
        simpleBlock(ModBlocks.HYDRO_ROCK.get());
        simpleBlock(ModBlocks.INFERNAL_ROCK.get());

        // Sand and Gravel
        simpleBlock(ModBlocks.BONE_SAND.get());
        simpleBlock(ModBlocks.WITHER_BONE_SAND.get());

        // Polished
        simpleBlock(ModBlocks.POLISHED_PERIDOTITE.get());
        simpleBlock(ModBlocks.POLISHED_PRISMARINE.get());
        simpleBlock(ModBlocks.POLISHED_DARK_PRISMARINE.get());
        simpleBlock(ModBlocks.POLISHED_END_STONE.get());
        simpleBlock(ModBlocks.POLISHED_NETHERRACK.get());

        // Chiseled and cracked
        simpleBlock(ModBlocks.CRACKED_RED_NETHER_BRICKS.get());
        simpleBlock(ModBlocks.CHISELED_RED_NETHER_BRICKS.get());
        simpleBlock(ModBlocks.CHISELED_PURPUR_BLOCK.get());
        simpleBlock(ModBlocks.CHISELED_OBSIDIAN.get());

        // Pillars
        pillarBlock(ModBlocks.GRANITE_PILLAR.get());
        pillarBlock(ModBlocks.DIORITE_PILLAR.get());
        pillarBlock(ModBlocks.ANDESITE_PILLAR.get());
        pillarBlock(ModBlocks.PERIDOTITE_PILLAR.get());
        pillarBlock(ModBlocks.PRISMARINE_PILLAR.get());
        pillarBlock(ModBlocks.DARK_PRISMARINE_PILLAR.get());
        pillarBlock(ModBlocks.END_STONE_PILLAR.get());
        pillarBlock(ModBlocks.NETHERRACK_PILLAR.get());
        pillarBlock(ModBlocks.OBSIDIAN_PILLAR.get());

        // Storage Blocks
        simpleBlock(ModBlocks.CHARCOAL_BLOCK.get());
        simpleBlock(ModBlocks.SUGAR_BLOCK.get());
        pillarBlock(ModBlocks.SUGAR_CANE_BLOCK.get());
        simpleBlock(ModBlocks.GUNPOWDER_BLOCK.get());
        simpleBlock(ModBlocks.BLAZE_POWDER_BLOCK.get());
        sideBottomTopBlock(ModBlocks.MAGMA_CREAM_BLOCK.get());
        simpleBlock(ModBlocks.PRISMARINE_CRYSTAL_BLOCK.get());
        pillarBlock(ModBlocks.WITHER_BONE_BLOCK.get());
        simpleBlock(ModBlocks.WHITE_DYE_BLOCK.get());
        simpleBlock(ModBlocks.ORANGE_DYE_BLOCK.get());
        simpleBlock(ModBlocks.MAGENTA_DYE_BLOCK.get());
        simpleBlock(ModBlocks.LIGHT_BLUE_DYE_BLOCK.get());
        simpleBlock(ModBlocks.YELLOW_DYE_BLOCK.get());
        simpleBlock(ModBlocks.LIME_DYE_BLOCK.get());
        simpleBlock(ModBlocks.PINK_DYE_BLOCK.get());
        simpleBlock(ModBlocks.GRAY_DYE_BLOCK.get());
        simpleBlock(ModBlocks.LIGHT_GRAY_DYE_BLOCK.get());
        simpleBlock(ModBlocks.CYAN_DYE_BLOCK.get());
        simpleBlock(ModBlocks.PURPLE_DYE_BLOCK.get());
        simpleBlock(ModBlocks.BLUE_DYE_BLOCK.get());
        simpleBlock(ModBlocks.BROWN_DYE_BLOCK.get());
        simpleBlock(ModBlocks.GREEN_DYE_BLOCK.get());
        simpleBlock(ModBlocks.RED_DYE_BLOCK.get());
        simpleBlock(ModBlocks.BLACK_DYE_BLOCK.get());

        // Glass
        glassBlock(ModBlocks.SOUL_GLASS.get());
        glassBlock(ModBlocks.WHITE_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.ORANGE_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.MAGENTA_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.YELLOW_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.LIME_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.PINK_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.GRAY_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.CYAN_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.PURPLE_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.BLUE_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.BROWN_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.GREEN_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.RED_STAINED_SOUL_GLASS.get());
        glassBlock(ModBlocks.BLACK_STAINED_SOUL_GLASS.get());

        glassPaneBlock(ModBlocks.SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.WHITE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.ORANGE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.MAGENTA_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.LIGHT_BLUE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.YELLOW_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.LIME_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.PINK_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.GRAY_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.LIGHT_GRAY_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.CYAN_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.PURPLE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.BLUE_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.BROWN_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.GREEN_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.RED_STAINED_SOUL_GLASS_PANE.get());
        glassPaneBlock(ModBlocks.BLACK_STAINED_SOUL_GLASS_PANE.get());

        // Misc
        easelBlock(ModBlocks.EASEL.get());
        rainDetectorBlock(ModBlocks.RAIN_DETECTOR.get());
        barsBlock(ModBlocks.GOLD_BARS.get());
        flowerBlock(ModBlocks.ROSE.get(), ModBlocks.POTTED_ROSE.get());
        doublePlantBlock(ModBlocks.SHEARED_ROSE_BUSH.get());
        flowerBlock(ModBlocks.PEONY.get(), ModBlocks.POTTED_PEONY.get());
        doublePlantBlock(ModBlocks.SHEARED_PEONY.get());
        flowerBlock(ModBlocks.LILAC.get(), ModBlocks.POTTED_LILAC.get());
        doublePlantBlock(ModBlocks.SHEARED_LILAC.get());
        trellisBlock(ModBlocks.TRELLIS.get());
        trellisCropBlock(ModBlocks.TOMATO.get());
        trellisCropBlock(ModBlocks.CHILI.get());
        cropBlock(ModBlocks.RICE.get(), RicePlantBlock.AGE);
        vineBlock(ModBlocks.WITHERED_VINE.get());

        // Cakes
        cakeBlock(ModBlocks.CHOCOLATE_CAKE.get());
        cakeBlock(ModBlocks.CARROT_CAKE.get());
        cakeBlock(ModBlocks.BERRY_CAKE.get());

        // Variant Blocks
        ModBookshelfBlock.BOOKSHELVES.forEach(this::bookshelfBlock);
        ModLadderBlock.LADDERS.forEach(this::ladderBlock);
        ModStairBlock.STAIRS.forEach(stair -> {
            if (stair == ModBlocks.CUT_SANDSTONE_STAIRS.get()) {
                stairsBlock(stair, ModDataGenerator.extend(blockTexture(Blocks.SANDSTONE), "_top"));
            } else if (stair == ModBlocks.CUT_RED_SANDSTONE_STAIRS.get()) {
                stairsBlock(stair, ModDataGenerator.extend(blockTexture(Blocks.RED_SANDSTONE), "_top"));
            } else {
                stairsBlock(stair);
            }
        });
        ModSlabBlock.SLABS.forEach(this::slabBlock);
        ModWallBlock.WALLS.forEach(this::wallBlock);
        ModFenceBlock.FENCES.forEach(this::fenceBlock);
        ModFenceGateBlock.FENCE_GATES.forEach(this::fenceGateBlock);
    }

    public void pillarBlock(Block block) {
        axisBlock((RotatedPillarBlock) block, ModDataGenerator.extend(blockTexture(block), "_side"), ModDataGenerator.extend(blockTexture(block), "_top"));
    }

    public void sideBottomTopBlock(Block block) {
        simpleBlock(block, models().cubeBottomTop(
                name(block),
                ModDataGenerator.extend(blockTexture(block), "_side"),
                ModDataGenerator.extend(blockTexture(block), "_bottom"),
                ModDataGenerator.extend(blockTexture(block), "_top")
        ));
    }

    public void bookshelfBlock(ModBookshelfBlock bookshelf) {
        simpleBlock(bookshelf, models().cubeColumn(name(bookshelf), blockTexture(bookshelf), blockTexture(bookshelf.getParent())));
    }

    public void stairsBlock(ModStairBlock stair) {
        stairsBlock(stair, variantTexture(stair.getParent()));
    }

    public void stairsBlock(ModStairBlock stair, ResourceLocation end) {
        stairsBlock(stair, variantTexture(stair.getParent()), end, end);
    }

    public void slabBlock(ModSlabBlock slab) {
        slabBlock(slab, blockTexture(slab.getParent()), variantTexture(slab.getParent()));
    }

    public void wallBlock(ModWallBlock wall) {
        wallBlock(wall, variantTexture(wall.getParent()));
        models().withExistingParent(name(wall) + "_inventory", ModelProvider.BLOCK_FOLDER + "/wall_inventory")
                .texture("wall", variantTexture(wall.getParent()));
    }

    public void fenceBlock(ModFenceBlock fence) {
        fenceBlock(fence, variantTexture(fence.getParent()));
        models().withExistingParent(name(fence) + "_inventory", ModelProvider.BLOCK_FOLDER + "/fence_inventory")
                .texture("texture", variantTexture(fence.getParent()));
    }

    public void fenceGateBlock(ModFenceGateBlock fenceGate) {
        fenceGateBlock(fenceGate, variantTexture(fenceGate.getParent()));
    }

    public void glassBlock(Block glass) {
        simpleBlock(glass, models()
                .cubeAll(name(glass), blockTexture(glass))
                .renderType(ModBlockStateProvider.RENDER_TYPE_TRANSLUCENT));
    }

    public void glassPaneBlock(Block pane) {
        paneBlockWithRenderType(
                (IronBarsBlock) pane,
                ModDataGenerator.shrink(blockTexture(pane), "_pane"),
                ModDataGenerator.extend(blockTexture(pane), "_top"),
                ModBlockStateProvider.RENDER_TYPE_TRANSLUCENT
        );
    }

    public void barsBlock(Block bars) {
        paneBlockWithRenderType(
                (IronBarsBlock) bars,
                blockTexture(bars),
                blockTexture(bars),
                ModBlockStateProvider.RENDER_TYPE_CUTOUT_MIPPED
        );
    }

    public void flowerBlock(Block flower, Block pot) {
        simpleBlock(flower, models()
                .cross(name(flower), blockTexture(flower))
                .renderType(ModBlockStateProvider.RENDER_TYPE_CUTOUT));
        simpleBlock(pot, models()
                .withExistingParent(name(pot), ModelProvider.BLOCK_FOLDER + "/flower_pot_cross")
                .texture("plant", blockTexture(flower))
                .renderType(ModBlockStateProvider.RENDER_TYPE_CUTOUT));
    }

    public void ladderBlock(ModLadderBlock ladder) {
        ladderBlock(ladder, models()
                .withExistingParent(name(ladder), ModelProvider.BLOCK_FOLDER + "/ladder")
                .texture("texture", blockTexture(ladder))
                .renderType(ModBlockStateProvider.RENDER_TYPE_CUTOUT));
    }

    protected void ladderBlock(LadderBlock ladder, ModelFile model) {
        getVariantBuilder(ladder).forAllStatesExcept(state -> {
            Direction dir = state.getValue(LadderBlock.FACING);

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY((int) dir.getOpposite().toYRot())
                    .build();
        }, LadderBlock.WATERLOGGED);
    }

    public void cropBlock(Block crop, IntegerProperty ageProperty) {
        List<ModelFile> files = ageProperty.getAllValues()
                .map(age -> models()
                        .withExistingParent(name(crop) + "_stage" + age.value(), ModelProvider.BLOCK_FOLDER + "/crop")
                        .texture("crop", ModDataGenerator.extend(blockTexture(crop), "_stage" + age.value()))
                        .renderType(ModBlockStateProvider.RENDER_TYPE_CUTOUT))
                .collect(Collectors.toList());
        cropBlock((CropBlock) crop, files, ageProperty);
    }

    protected void cropBlock(CropBlock crop, List<ModelFile> files, IntegerProperty ageProperty) {
        getVariantBuilder(crop).forAllStates(state -> {
            int age = state.getValue(ageProperty);

            return ConfiguredModel.builder()
                    .modelFile(files.get(age))
                    .build();
        });
    }

    public void trellisBlock(Block trellis) {
        List<ModelFile> files = TrellisBlock.HALF.getAllValues()
                .map(property -> models()
                        .withExistingParent(name(trellis) + "_" + property.value(), ModelProvider.BLOCK_FOLDER + "/crop")
                        .texture("crop", blockTexture(trellis))
                        .renderType(ModBlockStateProvider.RENDER_TYPE_CUTOUT))
                .collect(Collectors.toList());
        trellisBlock((TrellisBlock) trellis, files);
    }

    protected void trellisBlock(TrellisBlock trellis, List<ModelFile> files) {
        getVariantBuilder(trellis).forAllStates(state -> {
            DoubleBlockHalf doubleBlock = state.getValue(TrellisBlock.HALF);

            return ConfiguredModel.builder()
                    .modelFile(doubleBlock == DoubleBlockHalf.UPPER ? files.get(0) : files.get(1))
                    .build();
        });
    }

    protected void trellisCropBlock(Block trellisCrop) {
        List<ModelFile> filesLower = TrellisCropBlock.AGE.getAllValues()
                .map(age -> models()
                        .withExistingParent(name(trellisCrop) + "_lower_stage" + age.value(), modLoc(ModelProvider.BLOCK_FOLDER + "/crop_with_trellis"))
                        .texture("crop", ModDataGenerator.extend(blockTexture(trellisCrop), "_lower_stage" + age.value()))
                        .renderType(ModBlockStateProvider.RENDER_TYPE_CUTOUT))
                .collect(Collectors.toList());
        List<ModelFile> filesUpper = TrellisCropBlock.AGE.getAllValues()
                .map(age -> models()
                        .withExistingParent(name(trellisCrop) + "_upper_stage" + age.value(), modLoc(ModelProvider.BLOCK_FOLDER + "/crop_with_trellis"))
                        .texture("crop", ModDataGenerator.extend(blockTexture(trellisCrop), "_upper_stage" + age.value()))
                        .renderType(ModBlockStateProvider.RENDER_TYPE_CUTOUT))
                .collect(Collectors.toList());
        trellisCropBlock((TrellisCropBlock) trellisCrop, filesLower, filesUpper);
    }

    protected void trellisCropBlock(TrellisCropBlock trellisCrop, List<ModelFile> filesLower, List<ModelFile> filesUpper) {
        getVariantBuilder(trellisCrop).forAllStates(state -> {
            DoubleBlockHalf doubleBlock = state.getValue(TrellisCropBlock.HALF);
            int age = state.getValue(TrellisCropBlock.AGE);

            return ConfiguredModel.builder()
                    .modelFile(doubleBlock == DoubleBlockHalf.UPPER ? filesUpper.get(age) : filesLower.get(age))
                    .build();
        });
    }

    protected void trellisCropModel() {
        models().getBuilder("crop_with_trellis")
                .ao(false)
                .texture("particle", "#crop")
                .texture("trellis", blockTexture(ModBlocks.TRELLIS.get()))
                .element()
                .from(0.8F, -1, 8)
                .to(15.2F, 15, 8)
                .rotation().origin(8, 8, 8).axis(Direction.Axis.Y).angle(45).rescale(true).end()
                .shade(false)
                .face(Direction.NORTH).uvs(0, 0, 16, 16).texture("#crop").end()
                .face(Direction.SOUTH).uvs(0, 0, 16, 16).texture("#crop").end()
                .end()
                .element()
                .from(8, -1, 0.8F)
                .to(8, 15, 15.2F)
                .rotation().origin(8, 8, 8).axis(Direction.Axis.Y).angle(45).rescale(true).end()
                .shade(false)
                .face(Direction.WEST).uvs(0, 0, 16, 16).texture("#crop").end()
                .face(Direction.EAST).uvs(0, 0, 16, 16).texture("#crop").end()
                .end()
                .element()
                .from(4, -1, 0)
                .to(4, 15, 16)
                .shade(false)
                .face(Direction.WEST).uvs(0, 0, 16, 16).texture("#trellis").end()
                .face(Direction.EAST).uvs(16, 0, 0, 16).texture("#trellis").end()
                .end()
                .element()
                .from(12, -1, 0)
                .to(12, 15, 16)
                .shade(false)
                .face(Direction.WEST).uvs(16, 0, 0, 16).texture("#trellis").end()
                .face(Direction.EAST).uvs(0, 0, 16, 16).texture("#trellis").end()
                .end()
                .element()
                .from(0, -1, 4)
                .to(16, 15, 4)
                .shade(false)
                .face(Direction.NORTH).uvs(0, 0, 16, 16).texture("#trellis").end()
                .face(Direction.SOUTH).uvs(16, 0, 0, 16).texture("#trellis").end()
                .end()
                .element()
                .from(0, -1, 12)
                .to(16, 15, 12)
                .shade(false)
                .face(Direction.NORTH).uvs(16, 0, 0, 16).texture("#trellis").end()
                .face(Direction.SOUTH).uvs(0, 0, 16, 16).texture("#trellis").end()
                .end();
    }

    public void doublePlantBlock(Block plant) {
        ModelFile upperModel = models()
                .withExistingParent(name(plant) + "_top", ModelProvider.BLOCK_FOLDER + "/cross")
                .texture("cross", ModDataGenerator.extend(blockTexture(plant), "_top"))
                .renderType(ModBlockStateProvider.RENDER_TYPE_CUTOUT);
        ModelFile lowerModel = models()
                .withExistingParent(name(plant) + "_bottom", ModelProvider.BLOCK_FOLDER + "/cross")
                .texture("cross", ModDataGenerator.extend(blockTexture(plant), "_bottom"))
                .renderType(ModBlockStateProvider.RENDER_TYPE_CUTOUT);

        getVariantBuilder(plant).forAllStates(state -> {
            DoubleBlockHalf doubleBlock = state.getValue(DoublePlantBlock.HALF);

            return ConfiguredModel.builder()
                    .modelFile(doubleBlock == DoubleBlockHalf.UPPER ? upperModel : lowerModel)
                    .build();
        });
    }

    public void vineBlock(Block vineBlock) {
        ModelFile vineModel = models()
                .withExistingParent(name(vineBlock), ModelProvider.BLOCK_FOLDER + "/vine")
                .texture("particle", blockTexture(vineBlock))
                .texture("vine", blockTexture(vineBlock))
                .renderType(ModBlockStateProvider.RENDER_TYPE_CUTOUT);
        ModelFile vineModelUpper = models()
                .withExistingParent(name(vineBlock) + "_upper", ModelProvider.BLOCK_FOLDER + "/vine")
                .texture("particle", blockTexture(Blocks.VINE))
                .texture("vine", blockTexture(Blocks.VINE))
                .renderType(ModBlockStateProvider.RENDER_TYPE_CUTOUT);

        MultiPartBlockStateBuilder builder = getMultipartBuilder(vineBlock);
        Direction.stream()
                .filter(direction -> direction != Direction.DOWN)
                .forEach(direction -> {
                    for (int i = 0; i < 2; i++) {
                        MultiPartBlockStateBuilder.PartBuilder partBuilder = builder.part()
                                .modelFile(direction == Direction.UP ? vineModelUpper : vineModel)
                                .rotationY(direction == Direction.UP ? 0 : (((int) direction.toYRot()) + 180) % 360)
                                .rotationX(direction == Direction.UP ? 270 : 0)
                                .uvLock(direction != Direction.NORTH)
                                .addModel();
                        if (i == 0) {
                            partBuilder.condition(VineBlock.getPropertyForFace(direction), true);
                        } else {
                            Direction.stream()
                                    .filter(dir -> dir != Direction.DOWN)
                                    .forEach(dir -> partBuilder.condition(VineBlock.getPropertyForFace(dir), false));
                        }
                    }
                });
    }

    public void rainDetectorBlock(Block rainDetector) {
        ModelFile defaultModel = rainDetectorModel(name(rainDetector), ModDataGenerator.extend(blockTexture(rainDetector), "_top"));
        ModelFile invertedModel = rainDetectorModel(name(rainDetector) + "_inverted", ModDataGenerator.extend(blockTexture(rainDetector), "_inverted_top"));

        rainDetectorBlock((RainDetectorBlock) rainDetector, defaultModel, invertedModel);
    }

    protected void rainDetectorBlock(RainDetectorBlock rainDetector, ModelFile defaultModel, ModelFile invertedModel) {
        getVariantBuilder(rainDetector).forAllStatesExcept(state -> {
            boolean inverted = state.getValue(RainDetectorBlock.INVERTED);

            return ConfiguredModel.builder()
                    .modelFile(inverted ? invertedModel : defaultModel)
                    .build();
        }, RainDetectorBlock.POWER);
    }

    protected BlockModelBuilder rainDetectorModel(String name, ResourceLocation top) {
        return models().withExistingParent(name, ModelProvider.BLOCK_FOLDER + "/template_daylight_detector")
                .texture("side", ModDataGenerator.extend(blockTexture(Blocks.DAYLIGHT_DETECTOR), "_side"))
                .texture("top", top);
    }

    public void cakeBlock(Block cake) {
        List<ModelFile> files = CakeBlock.BITES.getAllValues()
                .map(bites -> cakeModel(cake, bites.value()))
                .collect(Collectors.toList());

        cakeBlock((CakeBlock) cake, files);
        Utils.CANDLES.forEach(candle -> candleCakeBlock(cake, ((ModCakeBlock) cake).byCandle((CandleBlock) candle), candle));
    }

    protected void cakeBlock(CakeBlock cake, List<ModelFile> files) {
        getVariantBuilder(cake).forAllStates(state -> {
            int bites = state.getValue(CakeBlock.BITES);

            return ConfiguredModel.builder()
                    .modelFile(files.get(bites))
                    .build();
        });
    }

    protected BlockModelBuilder cakeModel(Block cake, int bites) {
        BlockModelBuilder builder = models().withExistingParent(getCakeName(name(cake), bites), ModelProvider.BLOCK_FOLDER + getCakeName("/cake", bites))
                .texture("side", ModDataGenerator.extend(blockTexture(cake), "_side"))
                .texture("top", ModDataGenerator.extend(blockTexture(cake), "_top"))
                .texture("bottom", ModDataGenerator.extend(blockTexture(cake), "_bottom"))
                .texture("particle", ModDataGenerator.extend(blockTexture(cake), "_side"));

        return bites == 0 ? builder : builder.texture("inside", ModDataGenerator.extend(blockTexture(cake), "_inner"));
    }

    public void candleCakeBlock(Block cake, Block candleCake, Block candle) {
        ModelFile defaultModel = candleCakeModel(cake, name(candleCake), blockTexture(candle));
        ModelFile litModel = candleCakeModel(cake, name(candleCake) + "_lit", ModDataGenerator.extend(blockTexture(candle), "_lit"));

        candleCakeBlock((CandleCakeBlock) candleCake, defaultModel, litModel);
    }

    protected void candleCakeBlock(CandleCakeBlock candleCake, ModelFile defaultModel, ModelFile litModel) {
        getVariantBuilder(candleCake).forAllStates(state -> {
            boolean lit = state.getValue(CandleCakeBlock.LIT);

            return ConfiguredModel.builder()
                    .modelFile(lit ? litModel : defaultModel)
                    .build();
        });
    }

    protected BlockModelBuilder candleCakeModel(Block cake, String name, ResourceLocation candle) {
        return models().withExistingParent(name, ModelProvider.BLOCK_FOLDER + "/template_cake_with_candle")
                .texture("candle", candle)
                .texture("side", ModDataGenerator.extend(blockTexture(cake), "_side"))
                .texture("top", ModDataGenerator.extend(blockTexture(cake), "_top"))
                .texture("bottom", ModDataGenerator.extend(blockTexture(cake), "_bottom"))
                .texture("particle", ModDataGenerator.extend(blockTexture(cake), "_side"));
    }

    public void easelBlock(Block easel) {
        ModelFile model = models().withExistingParent(name(easel), ModelProvider.BLOCK_FOLDER + "/lectern")
                .texture("particle", ModDataGenerator.extend(blockTexture(Blocks.LECTERN), "_sides"))
                .texture("bottom", blockTexture(Blocks.OAK_PLANKS))
                .texture("base", blockTexture(Blocks.OAK_PLANKS))
                .texture("front", ModDataGenerator.extend(blockTexture(easel), "_front"))
                .texture("sides", ModDataGenerator.extend(blockTexture(Blocks.LECTERN), "_sides"))
                .texture("top", ModDataGenerator.extend(blockTexture(easel), "_top"));

        getVariantBuilder(easel).forAllStates(state -> {
            Direction facing = state.getValue(EaselBlock.FACING);

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY((int) facing.getOpposite().toYRot())
                    .build();
        });
    }

    protected ResourceLocation variantTexture(Block block) {
        ResourceLocation name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block));

        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath()
                .replace("_wood", "_log")
                .replace("_hyphae", "_stem")
                .replace("smooth_sandstone", "sandstone_top")
                .replace("smooth_red_sandstone", "red_sandstone_top")
                .replace("quartz_block", "quartz_block_side")
                .replace("chiseled_quartz_block_side", "chiseled_quartz_block")
                .replace("smooth_quartz", "quartz_block_bottom"));
    }

    protected String name(Block block) {
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
    }

    protected String getCakeName(String name, int bites) {
        return name + (bites == 0 ? "" : "_slice" + bites);
    }
}
