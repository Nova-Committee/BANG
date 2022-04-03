package committee.nova.pkst.bang;

import net.fabricmc.api.ModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BANG implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("BANG");
	public static final Identifier SOUND_ID = new Identifier("bang:bruh");
	public static SoundEvent BRUH_SOUND_EVENT = new SoundEvent(SOUND_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("serysly do not");
	}
}
