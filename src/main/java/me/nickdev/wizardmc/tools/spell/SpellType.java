package me.nickdev.wizardmc.tools.spell;

import me.nickdev.wizardmc.tools.spell.spells.*;

public enum SpellType {

    // None
    HEAL(HealSpell.class),

    // Fire spells
    FIRECIRCLE(FireCircleSpell.class),
    FIREEXPLOSION(FireExplosionSpell.class),
    FIRELIGHTNING(FireLightningSpell.class),
    FIRESHIELD(FireShieldSpell.class),

    // Air spells
    AIRJUMP(AirJumpSpell.class),
    AIRFLY(AirFlySpell.class),

    // Earth spells
    EARTHBUILD(EarthBuildSpell.class),

    // Water spells
    WATERGUARDIANATTACK(WaterGuardianAttack.class),
    WATERTRAP(WaterTrapSpell.class),
    ;

    private Class<? extends Spell> spellClass;

    SpellType(Class<? extends Spell> spellClass) {
        this.spellClass = spellClass;
    }

    public Class<? extends Spell> getSpellClass() {
        return spellClass;
    }
}
