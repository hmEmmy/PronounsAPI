package me.emmy.api;

import lombok.Getter;
import me.emmy.api.repository.PlayerRepository;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

@Getter
public class PronounsAPI {
    private final JavaPlugin plugin;
    private final PlayerRepository playerRepository;

    private final String version = "1.0.0";
    private final String author = "Emmy";
    private final String description = "A simple API for managing player pronouns in Minecraft plugins.";

    private final boolean usingDefaultRepository;

    /**
     * Constructor for the PronounsAPI class.
     *
     * @param plugin The JavaPlugin instance.
     */
    public PronounsAPI(JavaPlugin plugin, boolean initializeBasicRepository) {
        this.plugin = plugin;

        if (initializeBasicRepository) {
            this.playerRepository = new PlayerRepository();
            this.usingDefaultRepository = true;
        } else {
            this.playerRepository = null;
            this.usingDefaultRepository = false;
        }

        Arrays.asList(
                "",
                "&d&lPronounsAPI successfully initiated!",
                " &f" + this.description,
                "",
                " &fAuthor: &d" + this.author,
                " &fVersion: &d" + this.version,
                "",
                this.usingDefaultRepository ? " &dUsing default repository!" : " &aUsing custom repository!",
                " &fHooked into: &d" + plugin.getName(),
                ""
        ).forEach(message -> Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message)));
    }
}