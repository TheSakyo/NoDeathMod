# NoDeathMod

### ~~~ (VERSION FRANÇAISE) ~~~

## Description

**NoDeathMod** est un mod Minecraft Forge qui empêche le joueur de mourir.  
Lorsque le joueur subit des dégâts fatals, sa santé est bloquée à 1 coeur et demi au lieu de tomber à zéro, évitant ainsi la mort.

Ce mod est simple, léger, et s'intègre à Minecraft 1.20.1.  
Il utilise l'événement `LivingHurtEvent` pour intercepter et modifier les dégâts reçus par le joueur.

---

## Fonctionnalités principales

- Bloque la santé du joueur à 1 coeur et demi lorsque les dégâts reçus devraient entraîner la mort.
- Annule l'événement de dégâts fatal.
- Mod minimaliste et efficace.

---

## Installation

1. Installer Minecraft Forge 1.20.1.
2. Placer le fichier `nodeathmod-1.0-SNAPSHOT.jar` dans le dossier `mods` de votre installation Minecraft.
3. Lancer Minecraft avec le profil Forge.

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

## Licence et crédits

Ce mod est open-source et libre d'utilisation sous licence MIT.
Vous êtes libre de le modifier et de le redistribuer, à condition de me mentionner clairement en tant qu'auteur original dans vos distributions ou modifications.

___
___

### ~~~ (ENGLISH VERSION) ~~~

## Description

**NoDeathMod** is a Minecraft Forge mod that prevents the player from dying.  
When the player takes fatal damage, their health is locked at 1.5 hearts of dropping to zero, thus avoiding death.

This mod is simple, lightweight, and designed for Minecraft 1.20.1.  
It uses the `LivingHurtEvent` to intercept and modify damage taken by the player.

---

## Main Features

- Locks the player's health to 1.5 hearts when damage would cause death.
- Cancels the fatal damage event.
- Minimal and effective mod.

---

## Installation

1. Install Minecraft Forge 1.20.1.
2. Place the `NoDeathMod.jar` file in your Minecraft `mods` folder.
3. Launch Minecraft with the Forge profile.

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

## License and Credit

This mod is open-source and free to use under the MIT license.
You are free to modify and redistribute it, provided that you clearly credit me as the original author in your distributions or modifications.


