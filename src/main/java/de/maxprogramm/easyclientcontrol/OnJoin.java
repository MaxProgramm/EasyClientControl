package de.maxprogramm.easyclientcontrol;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitScheduler;
import com.lunarclient.bukkitapi.LunarClientAPI;

public class OnJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        boolean isLunarClientAllowed = EasyClientControl.getPlugin().getConfig().getBoolean("allow-lunar-client");
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.runTaskLater(EasyClientControl.getPlugin(), new Runnable() {
            @Override
            public void run() {
                if (LunarClientAPI.getInstance().isRunningLunarClient(player) && !isLunarClientAllowed){
                    player.kickPlayer("Using Lunarclient is not allowed");
                }
            }
        }, 2L);

    }


}
