package er.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

public class ErItems {
    public static final Seq<Item> ErItems = new Seq<>();

    public static Item
            vanadium, chromium, sand;

    public static void load() {
        vanadium = new Item("vanadium", Color.valueOf("b84f63")) {{
            lowPriority = false;
            hardness = 1;
            cost = 0.5f;
        }};
        sand = new Item("sand", Color.valueOf("f7cba4")){{
            lowPriority = true;
            buildable = false;
            hardness = 2;
        }};
        chromium = new Item("chromium", Color.valueOf("595e64")) {{
            lowPriority = false;
            hardness = 2;
            cost = 1f;
        }};
    }
}
