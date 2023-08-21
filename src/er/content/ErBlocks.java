package er.content;

import mindustry.content.Items;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.storage.*;
import static mindustry.type.ItemStack.*;

public class ErBlocks{
    public static Block
            //environment
            vanadiumOre, chromiumOre,
            //effect
            coreFervour;
    
    public static void load(){
        vanadiumOre = new OreBlock("vanadiumOre", ErItems.vanadium) {{
            oreThreshold = 0.9f;
            oreScale = 25f;
            variants = 3;
            wallOre = true;
        }};

        chromiumOre = new OreBlock("chromiumOre", ErItems.chromium) {{
            oreThreshold = 0.5f;
            oreScale = 10f;
            variants = 3;
            wallOre = true;
        }};

        coreFervour = new CoreBlock("coreFervour") {{
            requirements(Category.effect, with(Items.copper, 1000, Items.lead, 750));
            size = 3;
            squareSprite = false;
            itemCapacity = 1500;
            unitType = ErUnits.coreUnit;
            isFirstTier = true;
            unitCapModifier = 6;
        }};
    }
}
