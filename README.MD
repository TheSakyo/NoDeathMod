# NoDeathMod 

### ~~~ (VERSION FRANÇAISE) ~~~

## Description

**NoDeathMod** est un mod Minecraft Forge qui empêche le joueur de mourir.  
Lorsque le joueur subit des dégâts fatals, sa santé est bloquée à 1.0 point de vie au lieu de tomber à zéro, évitant ainsi la mort.

Ce mod est simple, léger, et s'intègre à Minecraft 1.19.4 (ou version proche).  
Il utilise l'événement `LivingHurtEvent` pour intercepter et modifier les dégâts reçus par le joueur.

---

## Fonctionnalités principales

- Bloque la santé du joueur à 1.0 lorsque les dégâts reçus devraient entraîner la mort
- Annule l'événement de dégâts fatal
- Compatible avec Forge pour Minecraft 1.19.4 (à adapter si besoin)
- Mod minimaliste et efficace

---

## Installation

1. Installer Minecraft Forge 1.20.1
2. Placer le fichier `nodeathmod-1.0-SNAPSHOT.jar` dans le dossier `mods` de votre installation Minecraft
3. Lancer Minecraft avec le profil Forge

---

## Utilisation

Aucune configuration nécessaire, le mod est actif dès le lancement.  
Lorsque vous subirez des dégâts mortels, vous resterez avec 1 demi coeur au lieu de mourir.

---

## Développement

Le mod est codé en Java avec Forge.  
Il s'appuie sur :

- `@Mod` pour enregistrer le mod et son identifiant `nodeathmod`
- `LivingHurtEvent` pour intercepter les dégâts
- Annulation de l'événement lorsque la mort est imminente et réinitialisation de la santé à 1.0f

---

## Exemple de code principal (simplifié)

```java
@Mod("nodeathmod")
public class NoDeathMod {
    public NoDeathMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof PlayerEntity player) {
            float healthAfterDamage = player.getHealth() - event.getAmount();
            if (healthAfterDamage <= 0.0f) {
                event.setCanceled(true);
                player.setHealth(1.0f);
            }
        }
    }
}
```

---

## Licence

Ce mod est open-source et libre d'utilisation.  
Vous pouvez le modifier et le redistribuer sous les termes de la licence MIT.

___
___

### ~~~ (ENGLISH VERSION) ~~~

## Description

**NoDeathMod** is a Minecraft Forge mod that prevents the player from dying.  
When the player takes fatal damage, their health is locked at 1.0 instead of dropping to zero, thus avoiding death.

This mod is simple, lightweight, and designed for Minecraft 1.19.4 (or similar version).  
It uses the `LivingHurtEvent` to intercept and modify damage taken by the player.

---

## Main Features

- Locks the player's health to 1.0 when damage would cause death
- Cancels the fatal damage event
- Compatible with Forge for Minecraft 1.19.4 (adjust as needed)
- Minimal and effective mod

---

## Installation

1. Install Minecraft Forge 1.19.4 (or compatible version)
2. Place the `NoDeathMod.jar` file in your Minecraft `mods` folder
3. Launch Minecraft with the Forge profile

---

## Usage

No configuration needed; the mod is active on launch.  
When you take fatal damage, you will remain with 1 health point instead of dying.

---

## Development

The mod is coded in Java using Forge.  
It relies on:

- `@Mod` to register the mod with the id `nodeathmod`
- `LivingHurtEvent` to intercept damage events
- Canceling the event and resetting health to 1.0f when death is imminent

---

## Main Code Example (simplified)

```java
@Mod("nodeathmod")
public class NoDeathMod {
    public NoDeathMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof PlayerEntity player) {
            float healthAfterDamage = player.getHealth() - event.getAmount();
            if (healthAfterDamage <= 0.0f) {
                event.setCanceled(true);
                player.setHealth(1.0f);
            }
        }
    }
}
```

---

## License

This mod is open-source and free to use.  
You may modify and redistribute it under the MIT License terms.
