# PronounsAPI

**Developed by [Emmy](https://github.com/hmEmmy)**

PronounsAPI is a lightweight and flexible plugin API that allows Minecraft developers to easily integrate pronoun support into their Bukkit-based projects. Designed with modularity and customization in mind, it ships with a simple default `PlayerRepository`.

This utility is perfect for developers looking to personalize player interactions and create a more inclusive server environment, with minimal setup required.

## Features

- 🔗 **Seamless Integration**: Works out of the box with Bukkit/Spigot-based projects.
- 🗂 **Default Repository**: Comes with a basic `PlayerRepository` for quick usage.
- 🧩 **Custom Core Support**: Easily adaptable to any core plugin that already manages player profiles.
- ✍️ **Grammar-Aware Enum**: Includes singular and plural forms, possessive variants, and contractions.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Custom Profile Integration](#custom-profile-integration)
- [Enum Structure](#enum-structure)
- [Contributing](#contributing)
- [Author](#author)

## Installation

1. Add `PronounsAPI` to your project (as a plugin dependency or source module).
2. Initialize the API in your plugin's main class:

```java
private PronounsAPI pronounsAPI;

@Override
public void onEnable() {
    this.pronounsAPI = new PronounsAPI(this);
}
```

## Usage

If your project does **not** have a profile system of its own, you can use the built-in repository:

```java
EnumPlayerPronouns pronouns = pronounsAPI.getPlayerRepository().getPronouns(player.getUniqueId());
```

You may also set it like so:

```java
pronounsAPI.getPlayerRepository().setPronouns(player.getUniqueId(), EnumPlayerPronouns.FEMALE);
```

This stores the data in-memory, and is ideal for smaller plugins or servers without persistent data layers.

---

## Custom Profile Integration

For developers using a custom core, you should ignore the default repository and instead integrate pronouns directly into your profile class:

```java
import me.emmy.api.enums.EnumPlayerPronouns;

// Using lombok might be a good idea here :), I still put the methods in for clarity
public class Profile {
    private EnumPlayerPronouns pronouns;

    public Profile() {
        this.pronouns = EnumPlayerPronouns.NOT_SPECIFIED;

        /*
         * Default pronouns, "They/Them".
         * players can change this via pronoun selection menu
         * or a command, It's really up to you.
         */
    }

    public EnumPlayerPronouns getPronouns() {
        return this.pronouns;
    }

    public void setPronouns(EnumPlayerPronouns pronouns) {
        this.pronouns = pronouns;
    }
}
```

You are responsible for storing and retrieving this value (e.g. via MongoDB, SQL, JSON). This approach is highly recommended to maintain consistency and avoid conflicting player data.

---

## Enum Structure

```java
FEMALE("Female", "she", "her", "hers", "she's"),
MALE("Male", "he", "him", "his", "he's"),
NOT_SPECIFIED("Not Specified", "they", "them", "theirs", "they're");
```

Each constant contains:

- `gender`: a readable name
- `pronouns`: she/he/they
- `possessive`: her/him/them
- `possessivePronoun`: hers/his/theirs
- `contractedPronoun`: she’s/he’s/they’re

This allows for natural, dynamic sentence construction in your plugin:

```java
String msg = profile.getPronouns().getContractedPronoun() + " currently in a duel.";

/*
 * Shows as: "they're currently in a duel."
 * 
 * If you wish you can add a new field to the enum for uppercase
 * pronouns, but I don't see the need for it.
 * If anything you can just split the string and capitalize the first letter.
 */

```

---

## Contributing

Contributions are welcome! To propose an improvement:

1. Fork the repository and create a new branch.
2. Add or modify features.
3. Test thoroughly.
4. Commit with a clear message.
5. Open a pull request and describe your changes.

Ideas like localization support or GUI toggles are always appreciated.

## Author

**PronounsAPI** is developed and maintained by [Emmy](https://github.com/hmEmmy). For inquiries or support:

- **GitHub**: [@hmEmmy](https://github.com/hmEmmy)
- **Discord**: [discord.gg/revere](https://discord.gg/revere)
- **Email**: [support@revere.dev](mailto:support@revere.dev)

Thank you for using and supporting PronounsAPI!
