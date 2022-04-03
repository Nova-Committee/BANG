package committee.nova.pkst.bang.mixin;

import committee.nova.pkst.bang.BANG;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.class_7323;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public abstract class BlockMixin {
    @Shadow protected abstract Block asBlock();

    @Inject(method = "onPlaced", at = @At("RETURN"))
    public void playSoundOnPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack, CallbackInfo ci) {
        if (!world.isClient) {
            if (this.asBlock() instanceof class_7323) {
                world.playSound(null, pos, BANG.BRUH_SOUND_EVENT, SoundCategory.BLOCKS, 1f, 1f);
            }
        }
    }
}
