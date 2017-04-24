package com.sahil.lr.model;

import java.io.Serializable;

/**
 * Player entity contains all required stats
 * for game play.
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class Player implements Serializable {

    private String name;
    private int maxHealth;
    private int currentHealth;
    private int experience;
    private int damage;
    private int defence;

    public Player(String name, int health, int experience, int damage, int defence) {
        this.name = name;
        this.maxHealth = health;
        this.currentHealth = health;
        this.experience = experience;
        this.damage = damage;
        this.defence = defence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void addExp(int exp) {
        this.experience += exp;
    }

    public void increaseDamage(int factor) {
        this.damage += factor;
    }

    public void increaseDamageOnOnePoint() {
        increaseDamage(1);
    }

    @Override
    public String toString() {
        return name + "'s Statistics: " +
                "\n Health:     " + currentHealth + "/" + maxHealth +
                "\n Experience: " + experience +
                "\n Damage:     " + damage +
                "\n Defence:    " + defence;
    }
}
