package edu.odu.cs.cs330.items;

import java.util.Scanner;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
public class Armour extends Item {
    /**
     * Durability decreases each time armour is used.
     */
    protected int durability;

    /**
     * The amount of damage that can be negated.
     */
    protected int  defense;

    /**
     * Base material out of which the armour is constructed.
     */
    protected String material;

    /**
     * Type of enchantment afforded (e.g. protection, feather_falling, or
     * unbreaking)
     */
    protected String modifier;

    /**
     * Enchantment level applied.
     */
    protected int modifierLevel;

    /**
     * Associated element--e.g., ice, fire, and lightning.
     */
    protected String element;

    /**
     * Default to a armour with an empty name, zero durability, zero defense,
     * blank material, no modifier a zero modifier level, and a blank element.
     */
    public Armour()
    {
        super.setName("");
        this.setMaterial("");
        this.setDurability(0);
        this.setDefense(0);
        this.setModifier("");
        this.setModifierLevel(0);
        this.setElement("");
    }

    /**
     * Duplicate a piece of armour.
     *
     * @param src armour to duplicate
     */
    public Armour(Armour src)
    {
        this.setName(src.getName());
        this.setMaterial(src.getMaterial());
        this.setDurability(src.getDurability());
        this.setDefense(src.getDefense());
        this.setModifier(src.getModifier());
        this.setModifierLevel(src.getModifierLevel());
        this.setElement(src.getElement());
    }

    /**
     * Retrieve armour durability.
     *
     * @return remaining durability
     */
    public int getDurability()
    {
        return this.durability;
    }

    /**
     * Set armour durability.
     *
     * @param dur new durability value
     */
    public void setDurability(int dur)
    {
        this.durability = dur;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Update defense.
     *
     * @param def replacement defense
     */
    public void setDefense(int def)
    {
        this.defense = def;
    }

    /**
     * Retrieve armour material.
     *
     * @return base material
     */
    public String getMaterial()
    {
        return this.material;
    }

    /**
     * Set armour Material.
     *
     * @param mat replacement material type
     */
    public void setMaterial(String mat)
    {
        this.material = mat;
    }

    /**
     * Retrieve armour modifier.
     *
     * @return buff/debuff provided
     */
    public String getModifier()
    {
        return this.modifier;
    }

    /**
     * Set armour modifier.
     *
     * @param mod updated modifier
     */
    public void setModifier(String mod)
    {
        this.modifier = mod;
    }

    /**
     * Retrieve armour modifier level.
     *
     * @return buff/debuff level
     */
    public int getModifierLevel()
    {
        return this.modifierLevel;
    }

    /**
     * Set armour modifier level.
     *
     * @param level replacement modifier level
     */
    public void setModifierLevel(int level)
    {
        this.modifierLevel = level;
    }

    /**
     * Retrieve armour element.
     *
     * @return element
     */
    public String getElement()
    {
        return this.element;
    }

    /**
     * Set armour element.
     *
     * @param ele new element
     */
    public void setElement(String ele)
    {
        this.element = ele;
    }

    @Override
    public boolean isStackable()
    {
        return false;
    }

    /**
     * Read Armour attributes.
     */
    @Override
    public void read(Scanner snr)
    {
        super.setName(snr.next());
        this.setMaterial(snr.next());
        this.setDurability(snr.nextInt());
        this.setDefense(snr.nextInt());
        this.setModifier(snr.next());
        this.setModifierLevel(snr.nextInt());
        this.setElement(snr.next());
    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone()
    {
        Armour cpy = new Armour();
        cpy.setName(this.getName());
        cpy.setMaterial(this.getMaterial());
        cpy.setDurability(this.getDurability());
        cpy.setDefense(this.getDefense());
        cpy.setModifier(this.getModifier());
        cpy.setModifierLevel(this.getModifierLevel());
        cpy.setElement(this.getElement());
        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier, and
     * element.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Armour)) {
            return false;
        }

        Armour rhsItem = (Armour) rhs;

        // Replace the next line
        return rhsItem.hashCode() == this.hashCode();
    }

    /**
     * Generate a hash code by adding the name, material, modifier, and element
     * hash codes.
     */
    @Override
    public int hashCode()
    {
        return this.name.hashCode() + this.material.hashCode() + this.modifier.hashCode() + this.element.hashCode();
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {
        String fmtString = String.join(
            System.lineSeparator(),
        "  Nme: %s",
            "  Dur: %d",
            "  Def: %d",
            "  Mtl: %s", 
            "  Mdr: %s (Lvl %d)",
            "  Emt: %s",
            ""
        );

        return String.format(
            fmtString,
            this.getName(),
            this.getDurability(),
            this.getDefense(),
            this.getMaterial(),
            this.getModifier(),
            this.getModifierLevel(),
            this.getElement()
        );
    }
}




