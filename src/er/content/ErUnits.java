package er.content;

import arc.graphics.Color;
import er.graphics.ErPal;
import mindustry.ai.types.BuilderAI;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.part.RegionPart;
import mindustry.gen.UnitEntity;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.weapons.RepairBeamWeapon;

import static mindustry.Vars.tilesize;

public class ErUnits {
    public static UnitType

    skyforge;
    public static void load(){
        skyforge = new UnitType("skyforge") {{
            constructor = UnitEntity::create;
            coreUnitDock = true;
            controller = u -> new BuilderAI(true, 500f);
            isEnemy = false;
            targetPriority = -2;
            lowAltitude = false;
            mineWalls = true;
            mineFloor = false;
            mineHardnessScaling = false;
            flying = true;
            mineSpeed = 6f;
            mineTier = 1;
            buildSpeed = 1.2f;
            drag = 0.08f;
            speed = 4.5f;
            rotateSpeed = 7f;
            accel = 0.09f;
            itemCapacity = 60;
            health = 250f;
            armor = 1f;
            hitSize = 8f;
            payloadCapacity = 2f * 2f * tilesize * tilesize;
            pickupUnits = false;
            vulnerableWithPayloads = true;

            engineColor = Color.white;

            outlineColor = ErPal.Outline;

            fogRadius = 0f;
            targetable = false;
            hittable = false;

            trailLength = 7;
            trailColor = Color.white;
            weapons.add(new RepairBeamWeapon() {{
                reload = 10;
                x = 0;
                y = 1;
                top = false;
                repairSpeed = 0.05f;
                fractionRepairSpeed = 0.001f;
                mirror = false;
                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Pal.accent;
                healColor = Pal.accent;

                bullet = new BulletType(){{
                    maxRange = 60f;
                }};
            }});

            parts.add(new RegionPart("-mouth") {{
                progress = PartProgress.warmup;
                mirror = true;
                moveX = 1;
                moveY = -1;
                under = true;
            }});
        }};
    }
}