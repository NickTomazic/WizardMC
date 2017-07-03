package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import me.nickdev.wizardmc.utils.BlockManager;
import me.nickdev.wizardmc.utils.MobManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class FireCreeperAttackSpell implements Spell {
    @Override
    public String getName() {
        return "FireCreeper";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Spawns a deadly creeper at the cursor location."
        };
    }

    @Override
    public int getRequiredMana() {
        return 65;
    }

    @Override
    public void activate(Main main, Player player) {
        MobManager.spawnMob(main, BlockManager.getTargetBlock(player, 18).getLocation().add(0, 1, 0), EntityType.CREEPER, ChatColor.RED + "FireCreeper");
    }
}
