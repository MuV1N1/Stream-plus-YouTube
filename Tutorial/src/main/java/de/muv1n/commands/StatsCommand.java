package de.muv1n.commands;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StatsCommand implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("§cYou must be a player to execute this command");
            return false;
        }
        if(args.length != 1){
            sender.sendMessage("§cUsage: /stats <played|kills|deaths>");
            return false;
        }

        int playedM, playedH, playedD, kills, deaths;
        String played = "";

        playedM = Objects.requireNonNull(Bukkit.getPlayer(sender.getName())).getStatistic(Statistic.TOTAL_WORLD_TIME);
        kills = Objects.requireNonNull(Bukkit.getPlayer(sender.getName())).getStatistic(Statistic.PLAYER_KILLS);
        deaths = Objects.requireNonNull(Bukkit.getPlayer(sender.getName())).getStatistic(Statistic.DEATHS);

        playedM = playedM / 20 / 60;
        if(playedM >= 60){
            playedH = playedM / 60;
            playedM = playedM % 60;
            if(playedH >= 24){
                playedD = playedH / 24;
                playedH = playedH % 24;
                played = "§7You played for §e" + playedD + " §7days, §e" + playedH + " §7hours and §e" + playedM + " §7minutes";
                return false;
            }
            played = "§7You played for §e" + playedH + " §7hours and §e" + playedM + " §7minutes";
            return false;
        }
        played = "§7You played for §e" + playedM + " §7minutes";

        switch (args[0]){
            case "played":
                sender.sendMessage(played);
                break;
            case "kills":
                switch (kills){
                    case 0:
                        sender.sendMessage("§7You never killed someone");
                        break;
                    case 1:
                        sender.sendMessage("§7You killed §e" + kills + " §7time");
                        break;
                    default:
                        sender.sendMessage("§7You killed §e" + kills + " §7times");
                        break;
                }
                break;
            case "deaths":
                switch (deaths){
                    case 0:
                        sender.sendMessage("§7You never died");
                        break;
                    case 1:
                        sender.sendMessage("§7You died §e" + deaths + " §7time");
                        break;
                    default:
                        sender.sendMessage("§7You died §e" + deaths + " §7times");
                        break;
                }
                break;
            default:
                sender.sendMessage("§cUsage: /stats <played|kills|deaths>");
                break;
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        List<String> cmds = List.of("played", "kills", "deaths");
        if(args.length == 1){
            return cmds.stream().filter(a -> a.startsWith(args[0])).toList();
        }else{
            return Collections.emptyList();
        }

    }
}
