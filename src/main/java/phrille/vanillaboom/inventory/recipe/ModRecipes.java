package phrille.vanillaboom.inventory.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import phrille.vanillaboom.VanillaBoom;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, VanillaBoom.MOD_ID);
    public static final RegistryObject<RecipeSerializer<PaintingRecipe>> PAINTING_SERIALIZER = RECIPE_SERIALIZERS.register("painting", PaintingRecipe.PaintingRecipeSerializer::new);

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, VanillaBoom.MOD_ID);
    public static final RegistryObject<RecipeType<PaintingRecipe>> PAINTING = RECIPE_TYPES.register("painting", () -> new VanillaBoomRecipeType<>(new ResourceLocation(VanillaBoom.MOD_ID, "painting")));

    private record VanillaBoomRecipeType<T extends Recipe<?>>(ResourceLocation id) implements RecipeType<T> {
        @Override
        public String toString() {
            return id.toString();
        }
    }
}
