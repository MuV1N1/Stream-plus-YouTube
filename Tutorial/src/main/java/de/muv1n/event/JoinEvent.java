package de.muv1n.event;

import de.muv1n.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class JoinEvent implements Listener {

    public Main plugin;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Component
                headerText = Component.text("§7Welcome to the server, §e" + event.getPlayer().getName() + "§7!"),
                footerText = Component.text("§7This is your §e" + (event.getPlayer().getStatistic(Statistic.LEAVE_GAME) + 1) + ". §7join!");

        event.getPlayer().sendPlayerListHeaderAndFooter(headerText, footerText);

        int joins = event.getPlayer().getStatistic(Statistic.LEAVE_GAME) + 1;

        event.joinMessage(Component.text("Welcome to the server, " + event.getPlayer().getName() + "!" + " This is your " + joins + ". join!"));
    }
}
