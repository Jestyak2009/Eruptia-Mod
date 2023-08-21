package er.content;

import arc.graphics.Color;
import er.planets.EruptiaPlanetGenerator;
import mindustry.Vars;
import mindustry.content.Items;
import mindustry.content.Planets;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.type.Planet;

public class ErPlanets {
    public static Planet

    Eruptia;

    public static void load() {
        Planets.serpulo.hiddenItems.addAll(Vars.content.items()).removeAll(Items.serpuloItems);
        Planets.erekir.hiddenItems.addAll(Vars.content.items()).removeAll(Items.erekirItems);

        Eruptia = new Planet("Eruptia", Planets.sun, 1, 1) {{
            defaultCore = ErBlocks.coreFervour;
            generator = new EruptiaPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 2, 0.15f, 0.14f, 5, Color.valueOf("ffffff").a(0.75f), 2, 0.42f, 1f, 0.43f),
                    new HexSkyMesh(this, 3, 0.6f, 0.15f, 5, Color.valueOf("ffffff").a(0.75f), 2, 0.42f, 1.2f, 0.45f)
            );
            accessible = true;
            bloom = true;
            alwaysUnlocked = true;
            visible = true;
            atmosphereColor = Color.valueOf("B79E54");
            startSector = 45;
            atmosphereRadIn = 0.01f;
            atmosphereRadOut = 0.2f;
            clearSectorOnLose = true;
            orbitRadius = 10;
            ruleSetter = r -> {
                r.attributes.clear();
                r.waveTeam = Team.neoplastic;
                r.showSpawns = true;
                r.fog = true;
                r.onlyDepositCore = false;
            };
            unlockedOnLand.add(ErBlocks.coreFervour);
            hiddenItems.addAll(Vars.content.items()).removeAll(ErItems.ErItems);
        }};
    }
}
