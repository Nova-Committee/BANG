package committee.nova.pkst.bang;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BANG implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("BANG");
	public static final String MODID = "bang";

	public static final TagKey<Item> CARPENTRY = TagKey.of(Registry.ITEM_KEY, new Identifier(MODID, "carpentry"));
	public static final TagKey<Item> METALWORKING = TagKey.of(Registry.ITEM_KEY, new Identifier(MODID, "metalworking"));
	public static final TagKey<Item> INFUSION = TagKey.of(Registry.ITEM_KEY, new Identifier(MODID, "infusion"));
	public static final TagKey<Item> MASONRY = TagKey.of(Registry.ITEM_KEY, new Identifier(MODID, "masonry"));
	public static final TagKey<Item> JEWELRY = TagKey.of(Registry.ITEM_KEY, new Identifier(MODID, "jewelry"));

	@Override
	public void onInitialize() {
		LOGGER.info("aka Benchworking Aesthetic Noise Generator");
	}
}
