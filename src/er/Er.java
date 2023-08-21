package er;

import arc.*;
import arc.util.*;
import er.content.ErItems;
import er.content.ErPlanets;
import er.content.ErUnits;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import er.content.ErBlocks;

public class Er extends Mod{

    public Er(){
        Log.info("Loaded ExampleJavaMod constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("When imposter is sus").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("er-frog")).pad(20f).row();
                dialog.cont.button("Tuturutututuru", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        Log.info("Loading some eruptia items.");
        ErItems.load();
        Log.info("Loading some eruptia units.");
        ErUnits.load();
        Log.info("Loading some eruptia blocks.");
        ErBlocks.load();
        Log.info("Loading some eruptia planets.");
        ErPlanets.load();
    }
}
