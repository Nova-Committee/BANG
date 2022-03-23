package committee.nova.bang;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

import static net.minecraft.sounds.SoundEvents.*;
import static net.minecraft.tags.ItemTags.create;

@Mod(Bang.MODID)
public class Bang {
    public static final String MODID = "bang";
    public static final Map<TagKey<Item>, SoundEvent> SOUNDS = Map.of(createTag("carpentry"), AXE_STRIP, createTag("metalworking"), ANVIL_USE, createTag("infusion"), ENCHANTMENT_TABLE_USE, createTag("masonry"), STONE_BREAK, createTag("jewelry"), AMETHYST_BLOCK_BREAK);

    public Bang() {
        MinecraftForge.EVENT_BUS.addListener(this::onItemCrafted);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private static TagKey<Item> createTag(String id) {
        return create(new ResourceLocation(MODID + ":" + id));
    }

    public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        final Player player = event.getPlayer();
        final ItemStack stack = event.getCrafting();
        SOUNDS.forEach((t, s) -> {
            if (stack.is(t)) player.playSound(s, 1F, 1F);
        });
    }
}