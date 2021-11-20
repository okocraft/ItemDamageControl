package net.okocraft.itemdamagecontrol;

import java.util.Arrays;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemDamageControl extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onJoin(PlayerItemDamageEvent event) {
        List<ItemStack> armorContents = Arrays.asList(event.getPlayer().getEquipment().getArmorContents());
        int damage = event.getDamage();
        if (!armorContents.contains(event.getItem()) || damage == 0) {
            return;
        }

        if (damage > 3) {
            event.setDamage(3);
        }
    }
}
