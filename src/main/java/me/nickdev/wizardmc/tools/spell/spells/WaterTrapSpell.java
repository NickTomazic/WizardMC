package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import me.nickdev.wizardmc.utils.BlockManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class WaterTrapSpell implements Spell {
    @Override
    public String getName() {
        return "WaterTrap";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Spawns a water trap!"
        };
    }

    @Override
    public int getRequiredMana() {
        return 50;
    }

    @Override
    public void activate(Main main, Player player) {
        BlockManager.createShield(main, BlockManager.getTargetBlock(player, 25).getLocation(), Material.WATER, 10);
    }
}
