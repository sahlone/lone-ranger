package com.auto1.lr.service;

import com.auto1.lr.logger.ConsoleLogger;
import com.auto1.lr.model.NPC;
import com.auto1.lr.model.Player;
import com.auto1.lr.map.locations.DesertLocation;
import com.auto1.lr.map.locations.Location;
import com.auto1.lr.actions.menu.AbstractMenu;
import com.auto1.lr.actions.menu.FightMenu;
import com.auto1.lr.utils.RandomUtil;

/**
 * Basic implementation of {@link FightService}
 *
 * @author Sahil Lone
 * @since 1.0
 */
public class FightServiceImpl implements FightService {

    private AbstractMenu menu;

    public FightServiceImpl() {
        menu = new FightMenu();
    }

    /**
     * This is where the action lies
     * Fight sequence ,damages etc
     *
     *
     */
    public Location battle(Player hero, Location location) {
        NPC monster = (NPC) location.getLocationItem();
        int heroHealth = hero.getCurrentHealth();
        int monsterHealth = monster.getCurrentHealth();
        while (heroHealth > 0 && monsterHealth > 0) {
            printMessage(hero.getName() + "'s health: " + heroHealth + " | " + monster.getName() + "'s Health: " + monsterHealth);
            menu.showMenu();
            int selection = menu.getSelectionIndex();

            //Player turn
            if (selection == 2) {
                monsterHealth = playerAttack(hero, monster, monsterHealth);
            } else if (selection == 1) {
                printMessage("You begin charging your attack!");
                hero.increaseDamageOnOnePoint();
            }

            //Enemy turn
            if (monsterHealth > 0 && heroHealth > 0) {
                heroHealth = monsterAttack(hero, monster, heroHealth);
            }
        }
        if (heroHealth <= 0) {
            ConsoleLogger.log("You lost all blood! Fighter wins.");
            System.exit(0);
        } else if (monsterHealth <= 0) {
            ConsoleLogger.log("---------------------------------------------------------");
            ConsoleLogger.log(hero.getName() + " has defeated " + monster.getName() + "!");
            ConsoleLogger.log("You earn " + monster.getExpCost() + " exp on the enemy.");
            ConsoleLogger.log("----------------------------------------------------------");
            hero.addExp(monster.getExpCost());
            int x = location.getX();
            int y = location.getY();
            location = new DesertLocation("monster's cave", x, y);
        }
        return location;
    }

    private int playerAttack(Player hero, NPC fighter, int monsterHealth) {
        int monsterDodge = RandomUtil.nextInt(10) + 1;
        if (monsterDodge >= 9) { // Failed attack
            printMessage(fighter.getName() + " dodged your attack!");
        } else if (monsterDodge <= 8) { // Successful attack
            int damage = hero.getDamage() + RandomUtil.nextInt(hero.getDamage()) - RandomUtil.nextInt(fighter.getDefence());
            if (damage < 0) {
                damage = 0;
            }
            monsterHealth -= damage;
            printMessage(hero.getName() + " hits " + fighter.getName() + " for " + damage + " damage!");

        }
        return monsterHealth;
    }

    private int monsterAttack(Player hero, NPC monster, int heroHealth) {
        int monsterDamage = monster.getDamage() + RandomUtil.nextInt(monster.getDamage()) - RandomUtil.nextInt(hero.getDefence());
        if (monsterDamage < 0) {
            monsterDamage = 0;
        }
        int monsterHitPlayer = RandomUtil.nextInt(100) + 1;
        if (monsterHitPlayer > 15) {
            heroHealth -= monsterDamage;
            printMessage(monster.getName() + " hits " + hero.getName() + " for " + monsterDamage + " damage!");
        } else if (monsterHitPlayer <= 15) {
            printMessage(monster.getName() + " misses " + hero.getName() + "!");
        }
        return heroHealth;
    }

    private void printMessage(String message) {
        ConsoleLogger.log("------------------------------------------------------------");
        ConsoleLogger.log(message);
        ConsoleLogger.log("-------------------------------------------------------------");
    }
}
