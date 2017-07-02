package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import org.bukkit.Particle;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.scheduler.BukkitRunnable;

public class FireExplosionSpell implements Spell {
    @Override
    public String getName() {
        return "FireExplosion";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Launches a powerful fireball."
        };
    }

    @Override
    public int getRequiredMana() {
        return 30;
    }

    @Override
    public void activate(Main main, Player player) {
        Fireball fireball = player.launchProjectile(Fireball.class);

        new BukkitRunnable() {

            @Override
            public void run() {
                if (fireball.isDead()) {
                    TNTPrimed tnt = fireball.getWorld().spawn(fireball.getLocation(), TNTPrimed.class);
                    tnt.setFuseTicks(1);
                    this.cancel();
                    return;
                }
                fireball.getLocation().getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, fireball.getLocation(), 1);
            }
        }.runTaskTimer(main, 1L, 1L);
    }
}
