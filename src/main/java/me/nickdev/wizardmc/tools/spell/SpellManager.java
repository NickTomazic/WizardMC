package me.nickdev.wizardmc.tools.spell;

import java.util.HashMap;

public class SpellManager {

    private HashMap<SpellType, Spell> spells = new HashMap<>();

    public SpellManager() {
        loadSpells();
    }

    private void loadSpells() {
        for (SpellType spellType : SpellType.values()) {
            try {
                spells.put(spellType, spellType.getSpellClass().newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public Spell getSpell(SpellType spellType) {
        return spells.get(spellType);
    }
}
