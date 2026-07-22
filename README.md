# Ender Staves

A Forge 1.20.1 addon for Iron's Spells 'n Spellbooks.

Available on Modrinth.

# Ender Staff

While held in the main hand, the staff provides:

- +15% Ender spell power
- +25% mana regeneration
- +100 maximum mana
- 6 total melee attack damage (1 base player damage + 5 item modifier)
- Staff casting animation and weapon enchantability inherited from Iron's `StaffItem`

## Building

Use Java 17, then run:

```bash
./gradlew build
```

The mod jar is created in `build/libs/`.

For a development client:

```bash
./gradlew runClient
```

## Update 1.2.1

- Refined the Ender Staff's inventory GUI positioning, scale, and proportions.

## Update 1.2.0

- Added a full-bright, animated Eye of Ender crystal to the custom Ender Staff model.
- Added a gentle crystal pulse, floating motion, and subtle drift effect.
- Added a dedicated Eye glow model and transparent base-eye texture so the animated crystal renders cleanly without overlapping the staff body.

## Update 1.1.0

- Added configurable Ender Staff bonuses:
  - Ender spell power
  - Mana regeneration
  - Maximum mana
- Added a revised custom 3D Ender Staff model.
- Added updated staff textures, including the Eye, platform, hilt, holder, handle, and shaft textures.

## Required runtime mods

- Minecraft 1.20.1
- Forge 47.x
- Iron's Spells 'n Spellbooks 3.16.2 or newer for 1.20.1
- Iron's Spells' own required dependencies

L_Ender's Cataclysm is optional.

## License

MIT
