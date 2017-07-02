package me.nickdev.wizardmc.tools.spell;

import me.nickdev.wizardmc.tools.spell.spells.*;

public enum SpellType {

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
    ;

    private Class<? extends Spell> spellClass;

    SpellType(Class<? extends Spell> spellClass) {
        this.spellClass = spellClass;
    }

    public Class<? extends Spell> getSpellClass() {
        return spellClass;
    }
}
