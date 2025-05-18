package fr.thesakyo.nodeathmod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

/**
 * The 'NoDeathMod' class is the main class for the 'NoDeathMod' mod.
 * It is responsible for registering the mod and Handling events.
 */
@Mod(NoDeathMod.MODID)
public class NoDeathMod {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "nodeathmod";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    /**
     * The constructor for the mod.
     */
    public NoDeathMod() {

        // Register ourselves for 'modloading'
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Event handler for when a player takes damage.
     * This event is called when a player takes damage.
     * It checks if the player is at 1.0f health and if so,
     * cancels the event and sets the health to 1.0f.
     *
     * @param event The event that is fired when a player takes damage.
     */
    @SubscribeEvent
    public void onDamage(LivingHurtEvent event) {

        // Check if the entity is a player, if not, return
        if (!(event.getEntity() instanceof Player player)) return;

        float damage = event.getAmount(); // Get the damage amount
        float health = player.getHealth(); // Get the player's health

        /*
         * If the player is at 1.0f health and takes damage,
         * cancel the event and set the health to 1.0f
         */
        if(health - damage <= 1.0f) {
            event.setCanceled(true); // Cancel the event
            player.setHealth(1.0f); // Set the health to 1.0f
        }
    }
}
