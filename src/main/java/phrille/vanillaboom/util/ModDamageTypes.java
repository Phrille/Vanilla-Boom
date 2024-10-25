package phrille.vanillaboom.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import phrille.vanillaboom.VanillaBoom;

public class ModDamageTypes {
    public static final ResourceKey<DamageType> CHILI = register("chili");

    @SuppressWarnings("SameParameterValue")
    private static ResourceKey<DamageType> register(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(VanillaBoom.MOD_ID, name));
    }
}
