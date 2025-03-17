package phrille.vanillaboom.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import phrille.vanillaboom.VanillaBoom;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.inventory.EaselMenu;
import phrille.vanillaboom.inventory.ModMenuTypes;
import phrille.vanillaboom.inventory.recipe.ModRecipes;
import phrille.vanillaboom.inventory.recipe.PaintingRecipe;

@JeiPlugin
public class VanillaBoomJEIPlugin implements IModPlugin {
    public static final ResourceLocation UID = new ResourceLocation(VanillaBoom.MOD_ID, "main");
    public static final RecipeType<PaintingRecipe> PAINTING = RecipeType.create(VanillaBoom.MOD_ID, "painting", PaintingRecipe.class);

    @Override
    public void registerItemSubtypes(ISubtypeRegistration subtypeRegistry) {
        subtypeRegistry.useNbtForSubtypes(Items.PAINTING);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new PaintingRecipeCategory(guiHelper));
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(PAINTING, Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ModRecipes.PAINTING.get()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.EASEL.get()), PAINTING);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(EaselMenu.class, ModMenuTypes.EASEL_MENU.get(), PAINTING, EaselMenu.DYE_SLOT_START, EaselMenu.CANVAS_SLOT + 1, 9, 36);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }
}
