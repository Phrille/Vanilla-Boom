package phrille.vanillaboom.inventory;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.Tags;
import phrille.vanillaboom.block.ModBlocks;
import phrille.vanillaboom.item.ModItems;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class EaselMenu extends AbstractContainerMenu {
    public static final int DYE_SLOT_START = 0;
    public static final int DYE_SLOT_END = 3;
    public static final int CANVAS_SLOT = 4;
    public static final int RESULT_SLOT = 5;
    private static final int INV_SLOT_START = 6;
    private static final int INV_SLOT_END = 33;
    private static final int USE_ROW_SLOT_START = 33;
    private static final int USE_ROW_SLOT_END = 42;

    private final ContainerLevelAccess access;
    private final DataSlot selectedPaintingIndex = DataSlot.standalone();
    private final Runnable slotUpdateListener = () -> {
    };

    private final Slot[] dyeSlots;
    private final Slot canvasSlot;
    private final Slot resultSlot;
    private final Container inputContainer = new SimpleContainer(5) {
        public void setChanged() {
            super.setChanged();
            EaselMenu.this.slotsChanged(this);
            EaselMenu.this.slotUpdateListener.run();
        }
    };
    private final Container resultContainer = new ResultContainer();

    private long lastSoundTime;

    public EaselMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }

    public EaselMenu(int containerId, Inventory inventory, ContainerLevelAccess access) {
        super(ModMenuTypes.EASEL_MENU.get(), containerId);
        this.access = access;
        dyeSlots = new Slot[DYE_SLOT_END + 1];

        for (int i = DYE_SLOT_START; i < dyeSlots.length; i++) {
            dyeSlots[i] = addSlot(new Slot(inputContainer, i, 8, 8 + i * 18) {
                @Override
                public boolean mayPlace(ItemStack stack) {
                    return stack.is(Tags.Items.DYES);
                }
            });
        }

        canvasSlot = addSlot(new Slot(inputContainer, CANVAS_SLOT, 30, 35) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ModItems.CANVAS.get());
            }
        });

        resultSlot = addSlot(new Slot(resultContainer, 0, 147, 36) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                access.execute((level, pos) -> {
                    long l = level.getGameTime();
                    if (EaselMenu.this.lastSoundTime != l) {
                        level.playSound(null, pos, SoundEvents.UI_LOOM_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        EaselMenu.this.lastSoundTime = l;
                    }
                });
                super.onTake(player, stack);
            }
        });

        for (int invRow = 0; invRow < 3; ++invRow) {
            for (int invCol = 0; invCol < 9; ++invCol) {
                this.addSlot(new Slot(inventory, invCol + invRow * 9 + 9, 8 + invCol * 18, 84 + invRow * 18));
            }
        }

        for (int hotBar = 0; hotBar < 9; ++hotBar) {
            this.addSlot(new Slot(inventory, hotBar, 8 + hotBar * 18, 142));
        }

        addDataSlot(selectedPaintingIndex);
    }

    @Override
    public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(access, player, ModBlocks.EASEL.get());
    }
}
