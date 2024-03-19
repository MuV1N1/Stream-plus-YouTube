package de.muv1n;


import de.muv1n.commands.StatsCommand;
import de.muv1n.event.JoinEvent;
import de.muv1n.event.QuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

     public final Logger LOGGER = this.getLogger();

        @Override
        public void onEnable() {
            registerEvent(getServer().getPluginManager());
            registerCommand();
        }

        @Override
        public void onDisable() {
            LOGGER.log(Level.INFO , "Plugin disabled");
        }
        public void registerEvent(PluginManager manager){
            manager.registerEvents(new JoinEvent(), this);
            manager.registerEvents(new QuitEvent(), this);
        }
        public void registerCommand(){
            Objects.requireNonNull(this.getCommand("stats")).setExecutor(new StatsCommand());
        }
}