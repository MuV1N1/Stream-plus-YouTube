package de.muv1n.event;

import jdk.jfr.Enabled;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {
    @EventHandler
    public static void onQuit(PlayerQuitEvent event) {
        event.quitMessage(Component.text("Goodbye, " + event.getPlayer().getName() + "!"));
    }
}
