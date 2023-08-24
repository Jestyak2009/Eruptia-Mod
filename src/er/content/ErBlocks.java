package er.content;

import arc.graphics.Color;
import er.graphics.ErPal;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.power.BeamNode;
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.blocks.production.BeamDrill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.*;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.*;

public class ErBlocks{
    public static Block
            //environment
            crimsoniteFloor, crimsoniteWall, crimsoniteBoulder, ebonvineFloor, ebonvineWall, ebonvineBoulder, ebonvineCluster, vanadiumOre, chromiumOre,
            //turrets
            burst,
            //production
            cliffDrill,
            //distribution
            vanadiumDuct,
            //power
            vanadiumNode, solarRefractor,
            //defense
            chromiumWall, chromiumWallLarge,
            //craft
            sandConverter,
            //effect
            coreFervour;
    
    public static void load(){
        //environment
        crimsoniteFloor = new Floor("crimsoniteFloor") {{
            variants = 3;
            wall = crimsoniteWall;
        }};
        crimsoniteWall = new StaticWall("crimsoniteWall") {{
            variants = 3;
        }};
        crimsoniteBoulder = new Prop("crimsoniteBoulder") {{
            crimsoniteFloor.asFloor().decoration = this;
            variants = 2;
        }};
        ebonvineFloor = new Floor("ebonvineFloor") {{
            variants = 3;
            wall = ebonvineWall;
        }};
        ebonvineWall = new StaticWall("ebonvineWall") {{
            variants = 2;
            itemDrop = ErItems.sand;
        }};
        ebonvineBoulder = new Prop("ebonvineBoulder") {{
            ebonvineFloor.asFloor().decoration = this;
            variants = 2;
        }};
        ebonvineCluster = new TallBlock("ebonvineCluster"){{
            variants = 3;
            clipSize = 128f;
        }};
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
        //turrets
        burst = new ItemTurret("burst") {{
            drawer = new DrawTurret("er-"){{
                requirements(Category.turret, with(ErItems.vanadium, 120, ErItems.chromium, 65));
                parts.addAll(
                        new RegionPart("-side"){{
                            progress = PartProgress.warmup;
                            moveY = 1f;
                            moveRot = 10f;
                            mirror = true;
                            moves.add(new PartMove(PartProgress.recoil, 0f, -1f, -10f));
                        }});

                ammo(
                        ErItems.chromium, new BasicBulletType(4f, 12){{
                            hitEffect = Fx.flakExplosion;
                            despawnEffect = Fx.flakExplosion;
                            knockback = 1f;
                            lifetime = 43.75f;
                            height = 8f;
                            width = 10f;
                            splashDamageRadius = 15f;
                            splashDamage = 4f;
                            scaledSplashDamage = true;
                            backColor = hitColor = trailColor = Color.valueOf("ea8878").lerp(Pal.redLight, 0.5f);
                            frontColor = Color.white;
                            ammoMultiplier = 1f;
                            hitSound = Sounds.explosion;

                            trailLength = 15;
                            trailWidth = 1f;
                            trailSinScl = 2.5f;
                            trailSinMag = 0.5f;
                            trailEffect = Fx.none;
                            despawnShake = 1f;

                            shootEffect = Fx.shootSmokeSquare;
                            smokeEffect = Fx.shootSmokeSquare;

                            fragBullet = intervalBullet = new BasicBulletType(1f, 0){{
                                shrinkX = 0f;
                                shrinkY = 0f;
                                width = 5f;
                                hitSize = 5f;
                                height = 5f;
                                pierce = true;
                                lifetime = 10f;
                                hitColor = backColor = trailColor = Color.valueOf("ea8878").lerp(Pal.redLight, 0.5f);
                                frontColor = Color.white;
                                trailWidth = 2.1f;
                                trailLength = 5;
                                hitEffect = despawnEffect = Fx.none;
                            }};
                            bulletInterval = 1f;
                            intervalRandomSpread = 20f;
                            intervalBullets = 2;
                            intervalAngle = 180f;
                            intervalSpread = 300f;

                            fragBullets = 20;
                            fragVelocityMin = 0.5f;
                            fragVelocityMax = 1.5f;
                            fragLifeMin = 0.5f;
                        }}
                );
                outlineColor = ErPal.Outline;

                squareSprite = false;

                shootSound = Sounds.shootSmite;
                targetGround = true;
                targetAir = true;
                shake = 1f;
                recoil = 1f;
                reload = 30f;
                rotateSpeed = 5f;
                minWarmup = 0.85f;
                shootWarmupSpeed = 0.07f;

                coolant = consume(new ConsumeLiquid(Liquids.water, 5f / 10f));
                coolantMultiplier = 1f;

                scaledHealth = 95;
                range = 175f;
                size = 2;
            }};
        }};
        //production
        cliffDrill = new BeamDrill("cliffDrill"){{
            requirements(Category.production, with(ErItems.vanadium, 40));
            drillTime = 195f;
            tier = 2;
            size = 2;
            range = 1;
            fogRadius = 3;
            squareSprite = false;
        }};
        //distribution
        vanadiumDuct = new Duct("vanadiumDuct"){{
            requirements(Category.distribution, with(ErItems.vanadium, 2));
            health = 55;
            speed = 2f;
        }};
        //power
        vanadiumNode = new BeamNode("vanadiumNode") {{
            requirements(Category.power, with(ErItems.vanadium, 12));
            consumesPower = outputsPower = true;
            laserColor2 = Color.valueOf("98a0b3");
            health = 65;
            range = 6;
            fogRadius = 1;

            consumePowerBuffered(500f);
        }};
        solarRefractor = new SolarGenerator("solarRefractor") {{
            requirements(Category.power, with(ErItems.vanadium, 250, ErItems.chromium, 175));
            powerProduction = 0.6f;

            size = 2;

            drawer = new DrawMulti(new DrawRegion(),
            new DrawGlowRegion("-glow"){{
                color = Color.valueOf("ffca8d");
            }},
            new DrawParticles(){{
                color = Color.valueOf("ffca8d");
                alpha = 0.1f;
                particleSize = 4f;
                particles = 50;
                particleRad = 12f;
                particleLife = 50f;
            }});
        }};
        //defense
        chromiumWall = new Wall("chromiumWall") {{
            requirements(Category.defense, with(ErItems.chromium, 6));
            size = 1;
            health = 560;
        }};
        chromiumWallLarge = new Wall("chromiumWallLarge") {{
            requirements(Category.defense, with(ErItems.chromium, 24));
            size = 2;
            health = 1120;
        }};
        //craft
        sandConverter = new GenericCrafter("sandConverter") {{
            requirements(Category.crafting, with(ErItems.vanadium, 85, ErItems.chromium, 50));
            size = 2;
            consumeItems(with(ErItems.sand, 3, ErItems.vanadium, 1));
            outputItem = new ItemStack(Items.silicon, 3);
            health = 120;
            hasPower = hasItems = true;
            consumePower(1f);
            itemCapacity = 10;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.1f;
            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    new DrawParticles(){{
                        color = Color.valueOf("ffca8d");
                        alpha = 0.7f;
                        particleSize = 2f;
                        particles = 50;
                        particleRad = 8f;
                        particleLife = 50f;
                    }},
                    new DrawRegion(),
                    new DrawGlowRegion("-glow"){{
                        color = Color.valueOf("ffca8d");
                    }},
                    new DrawParticles(){{
                        color = Color.valueOf("ffca8d");
                        alpha = 0.1f;
                        particleSize = 4f;
                        particles = 10;
                        particleRad = 4f;
                        reverse = true;
                        rotateScl = 10f;
                        particleLife = 50f;
                    }}
            );
            squareSprite = false;
        }};
        //effect
        coreFervour = new CoreBlock("coreFervour") {{
            requirements(Category.effect, with(Items.copper, 1000, Items.lead, 750));
            size = 3;
            squareSprite = false;
            itemCapacity = 1500;
            unitType = ErUnits.skyforge;
            isFirstTier = true;
            unitCapModifier = 6;
        }};
    }
}
