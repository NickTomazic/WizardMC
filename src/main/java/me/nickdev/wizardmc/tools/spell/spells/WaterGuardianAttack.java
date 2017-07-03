package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.chat.CC;
import me.nickdev.wizardmc.tools.spell.Spell;
import me.nickdev.wizardmc.utils.BlockManager;
import me.nickdev.wizardmc.utils.MobManager;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class WaterGuardianAttack implements Spell {
    @Override
    public String getName() {
        return "WaterGuardianAttack";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Spawns a guardian at the block you're looking at."
        };
    }

    @Override
    public int getRequiredMana() {
        return 30;
    }

    @Override
    public void activate(Main main, Player player) {
        MobManager.spawnMob(main, BlockManager.getTargetBlock(player, 30).getLocation(), EntityType.GUARDIAN, CC.SPECIAL + "Guardian", 200);
    }
}
