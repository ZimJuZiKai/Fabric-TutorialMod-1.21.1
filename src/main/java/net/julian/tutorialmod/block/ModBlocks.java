package net.julian.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.julian.tutorialmod.TutorialMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // --- First Block to be added, can be copied for next ones
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            // --- New non-experience dropping block added, check parameters to be added by doing ...create().
            new Block(AbstractBlock.Settings.create()
                    // --- Block Hardness in float, no blast resistance but also float
                    .strength(4f)
                    // --- Tool required or broken by hand
                    .requiresTool()
                    // --- what sounds does it play
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    // --- Second Block with slightly changed parameters
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()));

    // --- Block Helper , unsure how it works
    private static Block registerBlock(String name , Block block){
        // --- registers the block, uses name and block data type (?)
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    // --- Block Item Helper , unsure how it works
    private static void registerBlockItem(String name , Block block){
        // --- takes the same things as the above but for the blocks inventory item (?)
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    // --- Block registration and Logger location, blocks are added to creative mode groups
    public static void registerModBlocks(){
        // --- Logger messages , posts custom messages on game startup, Progress update with MOD_ID
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        // --- added to the tab "Building Blocks"
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        });
    }
}
