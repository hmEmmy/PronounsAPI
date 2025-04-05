package me.emmy.api;

import lombok.Getter;
import me.emmy.api.repository.PlayerRepository;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class PronounsAPI {
    private final JavaPlugin plugin;
    private final PlayerRepository playerRepository;

    /**
     * Constructor for the PronounsAPI class.
     *
     * @param plugin The JavaPlugin instance.
     */
    public PronounsAPI(JavaPlugin plugin) {
        this.plugin = plugin;
        this.playerRepository = new PlayerRepository();
    }
}