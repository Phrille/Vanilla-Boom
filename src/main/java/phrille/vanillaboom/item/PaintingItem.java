package phrille.vanillaboom.item;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.HangingEntity;
import net.minecraft.entity.item.PaintingEntity;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import phrille.vanillaboom.util.VanillaBoomTab;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PaintingItem extends Item {
    private final PaintingType motive;

    public PaintingItem(PaintingType motive) {
        super(new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB));
        this.motive = motive;
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        BlockPos pos = context.getClickedPos();
        Direction direction = context.getClickedFace();
        BlockPos relative = pos.relative(direction);
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (player != null && !mayPlace(player, direction, stack, relative)) {
            return ActionResultType.FAIL;
        } else {
            World world = context.getLevel();
            HangingEntity hangingentity = new PaintingEntity(world, relative, direction, motive);

            CompoundNBT nbt = stack.getTag();
            if (nbt != null) {
                EntityType.updateCustomEntityTag(world, player, hangingentity, nbt);
            }

            if (hangingentity.survives()) {
                if (!world.isClientSide) {
                    hangingentity.playPlacementSound();
                    //world.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
                    world.addFreshEntity(hangingentity);
                }

                stack.shrink(1);
                return ActionResultType.sidedSuccess(world.isClientSide);
            } else {
                return ActionResultType.CONSUME;
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent(getDescriptionId() + ".desc").withStyle(TextFormatting.BLUE));
    }

    protected boolean mayPlace(PlayerEntity player, Direction direction, ItemStack stack, BlockPos pos) {
        return !direction.getAxis().isVertical() && player.mayUseItemAt(pos, direction, stack);
    }
}
