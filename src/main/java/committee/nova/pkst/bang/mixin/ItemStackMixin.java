package committee.nova.pkst.bang.mixin;

import committee.nova.pkst.bang.BANG;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.TagKey;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow public abstract boolean isIn(TagKey<Item> tag);

    @Inject(method = "onCraft", at = @At("RETURN"))
    public void playSoundOnCraft(World world, PlayerEntity player, int amount, CallbackInfo ci) {
        if (!world.isClient) {
            if (this.isIn(BANG.CARPENTRY)) world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1f, 1f);
            if (this.isIn(BANG.METALWORKING)) world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_ANVIL_USE, SoundCategory.BLOCKS, 1f, 1f);
            if (this.isIn(BANG.INFUSION)) world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 1f);
            if (this.isIn(BANG.MASONRY)) world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1f, 1f);
            if (this.isIn(BANG.JEWELRY)) world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, SoundCategory.BLOCKS, 1f, 1f);
        }
    }
}
