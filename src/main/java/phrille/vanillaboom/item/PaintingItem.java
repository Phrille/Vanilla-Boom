package phrille.vanillaboom.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import phrille.vanillaboom.util.VanillaBoomTab;

import javax.annotation.Nullable;
import java.util.List;

public class PaintingItem extends Item {
    private final Motive motive;

    public PaintingItem(Motive motive) {
        super(new Item.Properties().tab(VanillaBoomTab.VANILLA_BOOM_TAB));
        this.motive = motive;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Direction direction = context.getClickedFace();
        BlockPos relative = pos.relative(direction);
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (player != null && !this.mayPlace(player, direction, stack, relative)) {
            return InteractionResult.FAIL;
        } else {
            Level level = context.getLevel();
            HangingEntity hangingentity = new Painting(level, relative, direction, motive);

            CompoundTag compoundtag = stack.getTag();
            if (compoundtag != null) {
                EntityType.updateCustomEntityTag(level, player, hangingentity, compoundtag);
            }

            if (hangingentity.survives()) {
                if (!level.isClientSide) {
                    hangingentity.playPlacementSound();
                    level.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
                    level.addFreshEntity(hangingentity);
                }

                stack.shrink(1);
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.CONSUME;
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(new TranslatableComponent(getDescriptionId() + ".desc").withStyle(ChatFormatting.BLUE));
    }

    protected boolean mayPlace(Player player, Direction direction, ItemStack stack, BlockPos pos) {
        return !direction.getAxis().isVertical() && player.mayUseItemAt(pos, direction, stack);
    }
}
