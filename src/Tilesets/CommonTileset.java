package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.GameObject;
import Level.PlayerState;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file
public class CommonTileset extends Tileset {

    public CommonTileset() {
	super(ImageLoader.load("CommonTileset.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
	ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

	///////////// spring /////////////

	// grass
	Frame grassFrame = new FrameBuilder(getSubImage(0, 0)).withScale(tileScale).build();

	MapTileBuilder grassTile = new MapTileBuilder(grassFrame);

	mapTiles.add(grassTile);

	// sign
	Frame signFrame = new FrameBuilder(getSubImage(3, 0)).withScale(tileScale).build();

	MapTileBuilder signTile = new MapTileBuilder(signFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(signTile);

	// sand
	Frame sandFrame = new FrameBuilder(getSubImage(0, 1)).withScale(tileScale).build();

	MapTileBuilder sandTile = new MapTileBuilder(sandFrame);

	mapTiles.add(sandTile);

	// rock
	Frame rockFrame = new FrameBuilder(getSubImage(3, 1)).withScale(tileScale).build();

	MapTileBuilder rockTile = new MapTileBuilder(rockFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(rockTile);

	// tree trunk with full hole
	Frame treeTrunkWithFullHoleFrame = new FrameBuilder(getSubImage(2, 2)).withScale(tileScale).build();

	MapTileBuilder treeTrunkWithFullHoleTile = new MapTileBuilder(grassFrame)
		.withTopLayer(treeTrunkWithFullHoleFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(treeTrunkWithFullHoleTile);

	// left end branch
	Frame leftEndBranchFrame = new FrameBuilder(getSubImage(2, 4)).withScale(tileScale).withBounds(0, 6, 16, 4)
		.build();

	MapTileBuilder leftEndBranchTile = new MapTileBuilder(grassFrame).withTopLayer(leftEndBranchFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(leftEndBranchTile);

	// right end branch
	Frame rightEndBranchFrame = new FrameBuilder(getSubImage(2, 4)).withScale(tileScale).withBounds(0, 6, 16, 4)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder rightEndBranchTile = new MapTileBuilder(grassFrame).withTopLayer(rightEndBranchFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(rightEndBranchTile);

	// tree trunk
	Frame treeTrunkFrame = new FrameBuilder(getSubImage(1, 0)).withScale(tileScale).build();

	MapTileBuilder treeTrunkTile = new MapTileBuilder(grassFrame).withTopLayer(treeTrunkFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(treeTrunkTile);

	// tree top leaves
	Frame treeTopLeavesFrame = new FrameBuilder(getSubImage(1, 1)).withScale(tileScale).build();

	MapTileBuilder treeTopLeavesTile = new MapTileBuilder(grassFrame).withTopLayer(treeTopLeavesFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(treeTopLeavesTile);

	// yellow flower
	Frame[] yellowFlowerFrames = new Frame[] {
		new FrameBuilder(getSubImage(1, 2), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(1, 3), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(1, 2), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(1, 4), 500).withScale(tileScale).build() };

	MapTileBuilder yellowFlowerTile = new MapTileBuilder(yellowFlowerFrames);

	mapTiles.add(yellowFlowerTile);

	// purple flower
	Frame[] purpleFlowerFrames = new Frame[] {
		new FrameBuilder(getSubImage(0, 2), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(0, 3), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(0, 2), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(0, 4), 500).withScale(tileScale).build() };

	MapTileBuilder purpleFlowerTile = new MapTileBuilder(purpleFlowerFrames);

	mapTiles.add(purpleFlowerTile);

	// middle branch
	Frame middleBranchFrame = new FrameBuilder(getSubImage(2, 3)).withScale(tileScale).withBounds(0, 6, 16, 4)
		.build();

	MapTileBuilder middleBranchTile = new MapTileBuilder(grassFrame).withTopLayer(middleBranchFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(middleBranchTile);

	// tree trunk bottom
	Frame treeTrunkBottomFrame = new FrameBuilder(getSubImage(2, 0)).withScale(tileScale).build();

	MapTileBuilder treeTrunkBottomTile = new MapTileBuilder(treeTrunkBottomFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(treeTrunkBottomTile);

	// mushrooms
	Frame mushroomFrame = new FrameBuilder(getSubImage(2, 1)).withScale(tileScale).build();

	MapTileBuilder mushroomTile = new MapTileBuilder(mushroomFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(mushroomTile);

	// grey rock
	Frame greyRockFrame = new FrameBuilder(getSubImage(3, 2)).withScale(tileScale).build();

	MapTileBuilder greyRockTile = new MapTileBuilder(greyRockFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(greyRockTile);

	// bush
	Frame bushFrame = new FrameBuilder(getSubImage(3, 3)).withScale(tileScale).build();

	MapTileBuilder bushTile = new MapTileBuilder(bushFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(bushTile);

	// house body
	Frame houseBodyFrame = new FrameBuilder(getSubImage(3, 4)).withScale(tileScale).build();

	MapTileBuilder houseBodyTile = new MapTileBuilder(houseBodyFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(houseBodyTile);

	// house roof body
	Frame houseRoofBodyFrame = new FrameBuilder(getSubImage(4, 0)).withScale(tileScale).build();

	MapTileBuilder houseRoofBodyTile = new MapTileBuilder(grassFrame).withTopLayer(houseRoofBodyFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(houseRoofBodyTile);

	// left house roof
	Frame leftHouseRoofFrame = new FrameBuilder(getSubImage(4, 1)).withScale(tileScale).build();

	MapTileBuilder leftHouseRoofTile = new MapTileBuilder(grassFrame).withTopLayer(leftHouseRoofFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(leftHouseRoofTile);

	// right house roof
	Frame rightHouseRoofFrame = new FrameBuilder(getSubImage(4, 1)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder rightHouseRoofTile = new MapTileBuilder(grassFrame).withTopLayer(rightHouseRoofFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(rightHouseRoofTile);

	// left window
	Frame leftWindowFrame = new FrameBuilder(getSubImage(4, 2)).withScale(tileScale).build();

	MapTileBuilder leftWindowTile = new MapTileBuilder(leftWindowFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(leftWindowTile);

	// right window
	Frame rightWindowFrame = new FrameBuilder(getSubImage(4, 2)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder rightWindowTile = new MapTileBuilder(rightWindowFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(rightWindowTile);

	// door
	Frame doorFrame = new FrameBuilder(getSubImage(4, 3)).withScale(tileScale).build();

	MapTileBuilder doorTile = new MapTileBuilder(doorFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(doorTile);

	// top water
	Frame[] topWaterFrames = new Frame[] { new FrameBuilder(getSubImage(5, 0), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(5, 1), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(5, 2), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(5, 1), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(5, 0), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(5, 3), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(5, 4), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(5, 3), 500).withScale(tileScale).build() };

	MapTileBuilder topWaterTile = new MapTileBuilder(topWaterFrames).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(topWaterTile);

	/////////////// winter ///////////////

	// snow
	Frame snowFrame = new FrameBuilder(getSubImage(0, 5)).withScale(tileScale).build();

	MapTileBuilder snowTile = new MapTileBuilder(snowFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(snowTile);

	// ice
	Frame iceFrame = new FrameBuilder(getSubImage(0, 6)).withScale(tileScale).build();

	MapTileBuilder iceTile = new MapTileBuilder(iceFrame).withTileType(TileType.ICY);

	mapTiles.add(iceTile);

	// blue flower
	Frame[] blueFlowerFrames = new Frame[] { new FrameBuilder(getSubImage(0, 7), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(0, 8), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(0, 7), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(0, 9), 500).withScale(tileScale).build() };

	MapTileBuilder blueFlowerTile = new MapTileBuilder(blueFlowerFrames);

	mapTiles.add(blueFlowerTile);

	// red flower
	Frame[] redFlowerFrames = new Frame[] { new FrameBuilder(getSubImage(1, 7), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(1, 8), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(1, 7), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(1, 9), 500).withScale(tileScale).build() };

	MapTileBuilder redFlowerTile = new MapTileBuilder(redFlowerFrames);

	mapTiles.add(redFlowerTile);

	// fallen branch
	Frame fallenBranchFrame = new FrameBuilder(getSubImage(2, 1)).withScale(tileScale).build();

	MapTileBuilder fallenBranchTile = new MapTileBuilder(fallenBranchFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(fallenBranchTile);

	// small rocks
	Frame smallRocksFrame = new FrameBuilder(getSubImage(3, 8)).withScale(tileScale).build();

	MapTileBuilder smallRocksTile = new MapTileBuilder(smallRocksFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(smallRocksTile);

	// cracked ice
	Frame crackedIceFrame = new FrameBuilder(getSubImage(5, 5)).withScale(tileScale).build();

	MapTileBuilder crackedIceTile = new MapTileBuilder(crackedIceFrame);

	mapTiles.add(crackedIceTile);

	// snowman bottom
	Frame snowmanBottomFrame = new FrameBuilder(getSubImage(5, 6)).withScale(tileScale).build();

	MapTileBuilder snowmanBottomTile = new MapTileBuilder(snowmanBottomFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(snowmanBottomTile);

	// snowman top
	Frame snowmanTopFrame = new FrameBuilder(getSubImage(5, 7)).withScale(tileScale).build();

	MapTileBuilder snowmanTopTile = new MapTileBuilder(snowFrame).withTopLayer(snowmanTopFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(snowmanTopTile);

	// snowFadeRight
	Frame snowFadeRightFrame = new FrameBuilder(getSubImage(5, 8)).withScale(tileScale).build();

	MapTileBuilder snowFadeRightTile = new MapTileBuilder(snowFadeRightFrame);

	mapTiles.add(snowFadeRightTile);

	// snowFadeLeft
	Frame snowFadeLeftFrame = new FrameBuilder(getSubImage(5, 8)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder snowFadeLeftTile = new MapTileBuilder(snowFadeLeftFrame);

	mapTiles.add(snowFadeLeftTile);

	// snowFadeUp
	Frame snowFadeUpFrame = new FrameBuilder(getSubImage(6, 8)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder snowFadeUpTile = new MapTileBuilder(snowFadeUpFrame);

	mapTiles.add(snowFadeUpTile);

	// snowFadeDown
	Frame snowFadeDownFrame = new FrameBuilder(getSubImage(6, 8)).withScale(tileScale).build();

	MapTileBuilder snowFadeDownTile = new MapTileBuilder(snowFadeDownFrame);

	mapTiles.add(snowFadeDownTile);

	// snowFadeBottomRight
	Frame snowFadeBottomRightFrame = new FrameBuilder(getSubImage(5, 9)).withScale(tileScale).build();

	MapTileBuilder snowFadeBottomRightTile = new MapTileBuilder(snowFadeBottomRightFrame);

	mapTiles.add(snowFadeBottomRightTile);

	// snowFadeBottomLeft
	Frame snowFadeBottomLeftFrame = new FrameBuilder(getSubImage(5, 9)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder snowFadeBottomLeftTile = new MapTileBuilder(snowFadeBottomLeftFrame);

	mapTiles.add(snowFadeBottomLeftTile);

	// snowFadeTopRight
	Frame snowFadeTopRightFrame = new FrameBuilder(getSubImage(5, 9)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder snowFadeTopRightTile = new MapTileBuilder(snowFadeTopRightFrame);

	mapTiles.add(snowFadeTopRightTile);

	// snowFadeTopLeft
	Frame snowFadeTopLeftFrame = new FrameBuilder(getSubImage(5, 9)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_H_AND_V).build();

	MapTileBuilder snowFadeTopLeftTile = new MapTileBuilder(snowFadeTopLeftFrame);

	mapTiles.add(snowFadeTopLeftTile);

	// snowFadeFullBottomRight
	Frame snowFadeFullBottomRightFrame = new FrameBuilder(getSubImage(6, 9)).withScale(tileScale).build();

	MapTileBuilder snowFadeFullBottomRightTile = new MapTileBuilder(snowFadeFullBottomRightFrame);

	mapTiles.add(snowFadeFullBottomRightTile);

	// snowFadeFullBottomLeft
	Frame snowFadeFullBottomLeftFrame = new FrameBuilder(getSubImage(6, 9)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder snowFadeFullBottomLeftTile = new MapTileBuilder(snowFadeFullBottomLeftFrame);

	mapTiles.add(snowFadeFullBottomLeftTile);

	// snowFadeFullTopRight
	Frame snowFadeFullTopRightFrame = new FrameBuilder(getSubImage(6, 9)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder snowFadeFullTopRightTile = new MapTileBuilder(snowFadeFullTopRightFrame);

	mapTiles.add(snowFadeFullTopRightTile);

	// snowFadeFullTopLeft
	Frame snowFadeFullTopLeftFrame = new FrameBuilder(getSubImage(6, 9)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_H_AND_V).build();

	MapTileBuilder snowFadeFullTopLeftTile = new MapTileBuilder(snowFadeFullTopLeftFrame);

	mapTiles.add(snowFadeFullTopLeftTile);

	///////// summer ////////
	// desertSand
	Frame desertSandFrame = new FrameBuilder(getSubImage(6, 6)).withScale(tileScale).build();

	MapTileBuilder desertSandTile = new MapTileBuilder(desertSandFrame);

	mapTiles.add(desertSandTile);

	// sandRock
	Frame sandRockFrame = new FrameBuilder(getSubImage(6, 5)).withScale(tileScale).build();

	MapTileBuilder sandRockTile = new MapTileBuilder(sandRockFrame);

	mapTiles.add(sandRockTile);
	// desertLizard
	Frame desertLizardFrame = new FrameBuilder(getSubImage(7, 5)).withScale(tileScale).build();

	MapTileBuilder desertLizardTile = new MapTileBuilder(desertLizardFrame);

	mapTiles.add(desertLizardTile);
	// desertFlower
	Frame desertFlowerFrame = new FrameBuilder(getSubImage(6, 7)).withScale(tileScale).build();

	MapTileBuilder desertFlowerTile = new MapTileBuilder(desertFlowerFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(desertFlowerTile);
	// cactus
	Frame cactusFrame = new FrameBuilder(getSubImage(7, 6)).withScale(tileScale).build();

	MapTileBuilder cactusTile = new MapTileBuilder(cactusFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cactusTile);
	// sandDunes
	Frame sandDuneFrame = new FrameBuilder(getSubImage(7, 8)).withScale(tileScale).build();

	MapTileBuilder sandDuneTile = new MapTileBuilder(sandDuneFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(sandDuneTile);
	// cactusFlower
	Frame cactusFlowerFrame = new FrameBuilder(getSubImage(7, 6)).withScale(tileScale).build();

	MapTileBuilder cactusFlowerTile = new MapTileBuilder(cactusFlowerFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cactusFlowerTile);
	// DessertRockFlower
	Frame desertRockFrame = new FrameBuilder(getSubImage(7, 9)).withScale(tileScale).build();

	MapTileBuilder desertRockTile = new MapTileBuilder(desertRockFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(desertRockTile);

	/////// autumn///////

	// dead grass
	Frame deadGrassFrame = new FrameBuilder(getSubImage(6, 0)).withScale(tileScale).build();

	MapTileBuilder deadGrassTile = new MapTileBuilder(deadGrassFrame);

	mapTiles.add(deadGrassTile);

	// puddle
	Frame puddleFrame = new FrameBuilder(getSubImage(6, 1)).withScale(tileScale).build();

	MapTileBuilder puddleTile = new MapTileBuilder(puddleFrame);

	mapTiles.add(puddleTile);

	// pink flower
	Frame pinkFlowerFrame = new FrameBuilder(getSubImage(6, 2)).withScale(tileScale).build();

	MapTileBuilder pinkFlowerTile = new MapTileBuilder(pinkFlowerFrame);

	mapTiles.add(pinkFlowerTile);

	// purple big flower
	Frame purpleBigFlowerFrames = new FrameBuilder(getSubImage(7, 2)).withScale(tileScale).build();

	MapTileBuilder purpleBigFlowerTile = new MapTileBuilder(purpleBigFlowerFrames);

	mapTiles.add(purpleBigFlowerTile);

	// autumn leaves
	Frame autumnLeavesFrame = new FrameBuilder(getSubImage(7, 1)).withScale(tileScale).build();

	MapTileBuilder autumnLeavesTile = new MapTileBuilder(deadGrassFrame).withTopLayer(autumnLeavesFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(autumnLeavesTile);

	// autumn tree trunk
	Frame autTreeTrunkFrame = new FrameBuilder(getSubImage(7, 0)).withScale(tileScale).build();

	MapTileBuilder autTreeTrunkTile = new MapTileBuilder(deadGrassFrame).withTopLayer(autTreeTrunkFrame)
		.withTileType(TileType.PASSABLE);;

	mapTiles.add(autTreeTrunkTile);

	// autumn tree trunk bottom
	Frame autTreeTrunkBottomFrame = new FrameBuilder(getSubImage(8, 0)).withScale(tileScale).build();

	MapTileBuilder autTreeTrunkBottomTile = new MapTileBuilder(autTreeTrunkBottomFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(autTreeTrunkBottomTile);

	// small colored mushrooms
	Frame smallMushroomsFrame = new FrameBuilder(getSubImage(8, 1)).withScale(tileScale).build();

	MapTileBuilder smallMushroomsTile = new MapTileBuilder(smallMushroomsFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(smallMushroomsTile);

	// autumn tree trunk with full hole
	Frame autTreeTrunkWithFullHoleFrame = new FrameBuilder(getSubImage(8, 2)).withScale(tileScale).build();

	MapTileBuilder autTreeTrunkWithFullHoleTile = new MapTileBuilder(deadGrassFrame)
		.withTopLayer(autTreeTrunkWithFullHoleFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(autTreeTrunkWithFullHoleTile);

	// mushroom left end branch
	Frame mushLeftEndBranchFrame = new FrameBuilder(getSubImage(8, 4)).withScale(tileScale).withBounds(0, 6, 16, 4)
		.build();

	MapTileBuilder mushLeftEndBranchTile = new MapTileBuilder(deadGrassFrame).withTopLayer(mushLeftEndBranchFrame)
		.withTileType(TileType.PASSABLE);
	MapTileBuilder leftEndBranchAutumnTile = new MapTileBuilder(deadGrassFrame).withTopLayer(leftEndBranchFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(mushLeftEndBranchTile);
	mapTiles.add(leftEndBranchAutumnTile);

	// mushroom right end branch
	Frame mushRightEndBranchFrame = new FrameBuilder(getSubImage(8, 4)).withScale(tileScale).withBounds(0, 6, 16, 4)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder mushRightEndBranchTile = new MapTileBuilder(deadGrassFrame).withTopLayer(mushRightEndBranchFrame)
		.withTileType(TileType.PASSABLE);
	MapTileBuilder rightEndBranchAutumnTile = new MapTileBuilder(deadGrassFrame).withTopLayer(rightEndBranchFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(mushRightEndBranchTile);
	mapTiles.add(rightEndBranchAutumnTile);

	// mushroom middle branch
	Frame mushMiddleBranchFrame = new FrameBuilder(getSubImage(8, 3)).withScale(tileScale).withBounds(0, 6, 16, 4)
		.build();

	MapTileBuilder mushMiddleBranchTile = new MapTileBuilder(deadGrassFrame).withTopLayer(mushMiddleBranchFrame)
		.withTileType(TileType.PASSABLE);
	MapTileBuilder middleBranchAutumnTile = new MapTileBuilder(deadGrassFrame).withTopLayer(middleBranchFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(mushMiddleBranchTile);
	mapTiles.add(middleBranchAutumnTile);

	// rock autumn tile
	Frame autRockFrame = new FrameBuilder(getSubImage(9, 1)).withScale(tileScale).build();

	MapTileBuilder autRockTile = new MapTileBuilder(autRockFrame);

	mapTiles.add(autRockTile);

	// autumn sign
	Frame autSignFrame = new FrameBuilder(getSubImage(9, 2)).withScale(tileScale).build();

	MapTileBuilder autSignTile = new MapTileBuilder(autSignFrame);

	mapTiles.add(autSignTile);

	// small rocks autumn
	Frame smallRocksAutumnFrame = new FrameBuilder(getSubImage(11, 0)).withScale(tileScale).build();

	MapTileBuilder smallRocksAutumnTile = new MapTileBuilder(smallRocksAutumnFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(smallRocksAutumnTile);

	// dead shrubbery
	Frame deadShrubFrame = new FrameBuilder(getSubImage(9, 3)).withScale(tileScale).build();

	MapTileBuilder deadShrubTile = new MapTileBuilder(deadShrubFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(deadShrubTile);

	// dead twig autumn
	Frame deadTwigAutumnFrame = new FrameBuilder(getSubImage(11, 1)).withScale(tileScale).build();

	MapTileBuilder deadTwigAutumnTile = new MapTileBuilder(deadTwigAutumnFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(deadTwigAutumnTile);

	// cobweb
	Frame cobwebFrame = new FrameBuilder(getSubImage(11, 2)).withScale(tileScale).build();

	MapTileBuilder cobwebTile = new MapTileBuilder(deadGrassFrame).withTopLayer(cobwebFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(cobwebTile);

	// autumnFadeRight
	Frame autumnFadeRightFrame = new FrameBuilder(getSubImage(6, 3)).withScale(tileScale).build();

	MapTileBuilder autumnFadeRightTile = new MapTileBuilder(autumnFadeRightFrame);

	mapTiles.add(autumnFadeRightTile);

	// autumnFadeLeft
	Frame autumnFadeLeftFrame = new FrameBuilder(getSubImage(6, 3)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder autumnFadeLeftTile = new MapTileBuilder(autumnFadeLeftFrame);

	mapTiles.add(autumnFadeLeftTile);

	// autumnFadeUp
	Frame autumnFadeUpFrame = new FrameBuilder(getSubImage(7, 3)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder autumnFadeUpTile = new MapTileBuilder(autumnFadeUpFrame);

	mapTiles.add(autumnFadeUpTile);

	// autumnFadeDown
	Frame autumnFadeDownFrame = new FrameBuilder(getSubImage(7, 3)).withScale(tileScale).build();

	MapTileBuilder autumnFadeDownTile = new MapTileBuilder(autumnFadeDownFrame);

	mapTiles.add(autumnFadeDownTile);

	// autumnFadeBottomRight
	Frame autumnFadeBottomRightFrame = new FrameBuilder(getSubImage(6, 4)).withScale(tileScale).build();

	MapTileBuilder autumnFadeBottomRightTile = new MapTileBuilder(autumnFadeBottomRightFrame);

	mapTiles.add(autumnFadeBottomRightTile);

	// autumnFadeBottomLeft
	Frame autumnFadeBottomLeftFrame = new FrameBuilder(getSubImage(6, 4)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder autumnFadeBottomLeftTile = new MapTileBuilder(autumnFadeBottomLeftFrame);

	mapTiles.add(autumnFadeBottomLeftTile);

	// autumnFadeTopRight
	Frame autumnFadeTopRightFrame = new FrameBuilder(getSubImage(6, 4)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder autumnFadeTopRightTile = new MapTileBuilder(autumnFadeTopRightFrame);

	mapTiles.add(autumnFadeTopRightTile);

	// autumnFadeTopLeft
	Frame autumnFadeTopLeftFrame = new FrameBuilder(getSubImage(6, 4)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_H_AND_V).build();

	MapTileBuilder autumnFadeTopLeftTile = new MapTileBuilder(autumnFadeTopLeftFrame);

	mapTiles.add(autumnFadeTopLeftTile);

	// autumnFadeFullBottomRight
	Frame autumnFadeFullBottomRightFrame = new FrameBuilder(getSubImage(7, 4)).withScale(tileScale).build();

	MapTileBuilder autumnFadeFullBottomRightTile = new MapTileBuilder(autumnFadeFullBottomRightFrame);

	mapTiles.add(autumnFadeFullBottomRightTile);

	// autumnFadeFullBottomLeft
	Frame autumnFadeFullBottomLeftFrame = new FrameBuilder(getSubImage(7, 4)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder autumnFadeFullBottomLeftTile = new MapTileBuilder(autumnFadeFullBottomLeftFrame);

	mapTiles.add(autumnFadeFullBottomLeftTile);

	// autumnFadeFullTopRight
	Frame autumnFadeFullTopRightFrame = new FrameBuilder(getSubImage(7, 4)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder autumnFadeFullTopRightTile = new MapTileBuilder(autumnFadeFullTopRightFrame);

	mapTiles.add(autumnFadeFullTopRightTile);

	// autumnFadeFullTopLeft
	Frame autumnFadeFullTopLeftFrame = new FrameBuilder(getSubImage(7, 4)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_H_AND_V).build();

	MapTileBuilder autumnFadeFullTopLeftTile = new MapTileBuilder(autumnFadeFullTopLeftFrame);

	mapTiles.add(autumnFadeFullTopLeftTile);

	///////////////// More Winter////////////////
	// middle winter branch
	Frame middleBranchWinterFrame = new FrameBuilder(getSubImage(2, 8)).withScale(tileScale).withBounds(0, 6, 16, 4)
		.build();

	MapTileBuilder middleBranchWinterTile = new MapTileBuilder(snowFrame).withTopLayer(middleBranchWinterFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(middleBranchWinterTile);

	// tree trunk winter bottom
	Frame treeTrunkWinterBottomFrame = new FrameBuilder(getSubImage(2, 5)).withScale(tileScale).build();

	MapTileBuilder treeTrunkWinterBottomTile = new MapTileBuilder(treeTrunkWinterBottomFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(treeTrunkWinterBottomTile);

	// rock winter
	Frame rockWinterFrame = new FrameBuilder(getSubImage(3, 6)).withScale(tileScale).build();

	MapTileBuilder rockWinterTile = new MapTileBuilder(rockWinterFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(rockWinterTile);

	// tree trunk with full hole winter
	Frame treeTrunkWinterWithFullHoleFrame = new FrameBuilder(getSubImage(2, 7)).withScale(tileScale).build();

	MapTileBuilder treeTrunkWinterWithFullHoleTile = new MapTileBuilder(snowFrame)
		.withTopLayer(treeTrunkWinterWithFullHoleFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(treeTrunkWinterWithFullHoleTile);

	// left end branch winter
	Frame leftEndBranchWinterFrame = new FrameBuilder(getSubImage(2, 9)).withScale(tileScale)
		.withBounds(0, 6, 16, 4).build();

	MapTileBuilder leftEndBranchWinterTile = new MapTileBuilder(snowFrame).withTopLayer(leftEndBranchWinterFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(leftEndBranchWinterTile);

	// right end branch winter
	Frame rightEndBranchWinterFrame = new FrameBuilder(getSubImage(2, 9)).withScale(tileScale)
		.withBounds(0, 6, 16, 4).withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder rightEndBranchWinterTile = new MapTileBuilder(snowFrame).withTopLayer(rightEndBranchWinterFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(rightEndBranchWinterTile);

	// tree trunk winter
	Frame treeTrunkWinterFrame = new FrameBuilder(getSubImage(1, 5)).withScale(tileScale).build();

	MapTileBuilder treeTrunkWinterTile = new MapTileBuilder(snowFrame).withTopLayer(treeTrunkWinterFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(treeTrunkWinterTile);

	// tree top leaves winter
	Frame treeTopWinterLeavesFrame = new FrameBuilder(getSubImage(1, 6)).withScale(tileScale).build();

	MapTileBuilder treeTopWinterLeavesTile = new MapTileBuilder(snowFrame).withTopLayer(treeTopWinterLeavesFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(treeTopWinterLeavesTile);

	// tree top leaves snow winter
	Frame treeTopWinterSnowLeavesFrame = new FrameBuilder(getSubImage(8, 5)).withScale(tileScale).build();

	MapTileBuilder treeTopWinterSnowLeavesTile = new MapTileBuilder(snowFrame)
		.withTopLayer(treeTopWinterSnowLeavesFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(treeTopWinterSnowLeavesTile);

	// sign winter
	Frame signWinterFrame = new FrameBuilder(getSubImage(3, 5)).withScale(tileScale).build();

	MapTileBuilder signWinterTile = new MapTileBuilder(signWinterFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(signWinterTile);

	// sign snow winter
	Frame signWinterSnowFrame = new FrameBuilder(getSubImage(3, 7)).withScale(tileScale).build();

	MapTileBuilder signWinterSnowTile = new MapTileBuilder(signWinterSnowFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(signWinterSnowTile);

	// house body winter
	Frame houseBodyWinterFrame = new FrameBuilder(getSubImage(3, 9)).withScale(tileScale).build();

	MapTileBuilder houseBodyWinterTile = new MapTileBuilder(houseBodyWinterFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(houseBodyWinterTile);

	// house roof body winter
	Frame houseRoofBodyWinterFrame = new FrameBuilder(getSubImage(4, 5)).withScale(tileScale).build();

	MapTileBuilder houseRoofBodyWinterTile = new MapTileBuilder(snowFrame).withTopLayer(houseRoofBodyWinterFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(houseRoofBodyWinterTile);

	// left house roof winter
	Frame leftHouseRoofWinterFrame = new FrameBuilder(getSubImage(4, 6)).withScale(tileScale).build();

	MapTileBuilder leftHouseRoofWinterTile = new MapTileBuilder(snowFrame).withTopLayer(leftHouseRoofWinterFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(leftHouseRoofWinterTile);

	// right house roof winter
	Frame rightHouseRoofWinterFrame = new FrameBuilder(getSubImage(4, 6)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder rightHouseRoofWinterTile = new MapTileBuilder(snowFrame).withTopLayer(rightHouseRoofWinterFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(rightHouseRoofWinterTile);

	// left window winter
	Frame leftWindowWinterFrame = new FrameBuilder(getSubImage(4, 7)).withScale(tileScale).build();

	MapTileBuilder leftWindowWinterTile = new MapTileBuilder(leftWindowWinterFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(leftWindowWinterTile);

	// right window winter
	Frame rightWindowWinterFrame = new FrameBuilder(getSubImage(4, 7)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder rightWindowWinterTile = new MapTileBuilder(rightWindowWinterFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(rightWindowWinterTile);

	// door winter
	Frame doorWinterFrame = new FrameBuilder(getSubImage(4, 8)).withScale(tileScale).build();

	MapTileBuilder doorWinterTile = new MapTileBuilder(doorWinterFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(doorWinterTile);

	// test

	Frame redFrame = new FrameBuilder(getSubImage(8, 6)).withScale(tileScale).build();

	MapTileBuilder redTile = new MapTileBuilder(redFrame);

	mapTiles.add(redTile);

	// cliff down
	Frame cliffDownFrame = new FrameBuilder(getSubImage(12, 0)).withScale(tileScale).build();

	MapTileBuilder cliffDownTile = new MapTileBuilder(cliffDownFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cliffDownTile);

	// cliff up
	Frame cliffUpFrame = new FrameBuilder(getSubImage(12, 0)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder cliffUpTile = new MapTileBuilder(cliffUpFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cliffUpTile);

	// cliff right
	Frame cliffRightFrame = new FrameBuilder(getSubImage(12, 1)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder cliffRightTile = new MapTileBuilder(cliffRightFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cliffRightTile);

	// cliff left
	Frame cliffLeftFrame = new FrameBuilder(getSubImage(12, 1)).withScale(tileScale).build();

	MapTileBuilder cliffLeftTile = new MapTileBuilder(cliffLeftFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cliffLeftTile);

	// cliff out corner top left
	Frame cliffOutCornerTopLeftFrame = new FrameBuilder(getSubImage(12, 2)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder cliffOutCornerTopLeftTile = new MapTileBuilder(cliffOutCornerTopLeftFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cliffOutCornerTopLeftTile);

	// cliff out corner top right
	Frame cliffOutCornerTopRightFrame = new FrameBuilder(getSubImage(12, 2)).withScale(tileScale).build();

	MapTileBuilder cliffOutCornerTopRightTile = new MapTileBuilder(cliffOutCornerTopRightFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cliffOutCornerTopRightTile);

	// cliff out corner bottom left
	Frame cliffOutCornerBottomRightFrame = new FrameBuilder(getSubImage(12, 2)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder cliffOutCornerBottomRightTile = new MapTileBuilder(cliffOutCornerBottomRightFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cliffOutCornerBottomRightTile);

	// cliff out corner bottom right
	Frame cliffOutCornerBottomLeftFrame = new FrameBuilder(getSubImage(12, 2)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_H_AND_V).build();

	MapTileBuilder cliffOutCornerBottomLeftTile = new MapTileBuilder(cliffOutCornerBottomLeftFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cliffOutCornerBottomLeftTile);

	// cliff in corner top left
	Frame cliffInCornerTopLeftFrame = new FrameBuilder(getSubImage(12, 3)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder cliffInCornerTopLeftTile = new MapTileBuilder(cliffInCornerTopLeftFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cliffInCornerTopLeftTile);

	// cliff in corner top right
	Frame cliffInCornerTopRightFrame = new FrameBuilder(getSubImage(12, 3)).withScale(tileScale).build();

	MapTileBuilder cliffInCornerTopRightTile = new MapTileBuilder(cliffInCornerTopRightFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cliffInCornerTopRightTile);

	// cliff in corner bottom left
	Frame cliffInCornerBottomRightFrame = new FrameBuilder(getSubImage(12, 3)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder cliffInCornerBottomRightTile = new MapTileBuilder(cliffInCornerBottomRightFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cliffInCornerBottomRightTile);

	// cliff in corner bottom right
	Frame cliffInCornerBottomLeftFrame = new FrameBuilder(getSubImage(12, 3)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_H_AND_V).build();

	MapTileBuilder cliffInCornerBottomLeftTile = new MapTileBuilder(cliffInCornerBottomLeftFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(cliffInCornerBottomLeftTile);

	// sand house mid wall

	Frame sandHouseMidWallFrame = new FrameBuilder(getSubImage(8, 7)).withScale(tileScale).build();

	MapTileBuilder sandHouseMidWallTile = new MapTileBuilder(sandHouseMidWallFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(sandHouseMidWallTile);

	// sand house wall right

	Frame sandHouseRightWallFrame = new FrameBuilder(getSubImage(8, 8)).withScale(tileScale).build();

	MapTileBuilder sandHouseRightWallTile = new MapTileBuilder(sandHouseRightWallFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(sandHouseRightWallTile);

	// sand house Flag top

	Frame sandHouseFlagTopFrame = new FrameBuilder(getSubImage(8, 9)).withScale(tileScale).build();

	MapTileBuilder sandHouseFlagTopTile = new MapTileBuilder(desertSandFrame).withTopLayer(sandHouseFlagTopFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(sandHouseFlagTopTile);

	// sand house left corner

	Frame sandHouseLeftCornerFrame = new FrameBuilder(getSubImage(9, 5)).withScale(tileScale).build();

	MapTileBuilder sandHouseLeftCornerTile = new MapTileBuilder(sandHouseLeftCornerFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(sandHouseLeftCornerTile);

	// sand house bottom

	Frame sandHouseBottomFrame = new FrameBuilder(getSubImage(9, 6)).withScale(tileScale).build();

	MapTileBuilder sandHouseBottomTile = new MapTileBuilder(sandHouseBottomFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(sandHouseBottomTile);

	// sand house right corner

	Frame sandHouseRightCornerFrame = new FrameBuilder(getSubImage(9, 7)).withScale(tileScale).build();

	MapTileBuilder sandHouseRightCornerTile = new MapTileBuilder(sandHouseRightCornerFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(sandHouseRightCornerTile);

	// sand house door

	Frame sandHouseDoorFrame = new FrameBuilder(getSubImage(9, 8)).withScale(tileScale).build();

	MapTileBuilder sandHouseDoorTile = new MapTileBuilder(sandHouseDoorFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(sandHouseDoorTile);

	// sand house top

	Frame sandHouseTopFrame = new FrameBuilder(getSubImage(9, 9)).withScale(tileScale).build();

	MapTileBuilder sandHouseTopTile = new MapTileBuilder(desertSandFrame).withTopLayer(sandHouseTopFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(sandHouseTopTile);

	// sand house door deco

	Frame sandHouseDoorDecoFrame = new FrameBuilder(getSubImage(10, 5)).withScale(tileScale).build();

	MapTileBuilder sandHouseDoorDecoTile = new MapTileBuilder(sandHouseDoorDecoFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(sandHouseDoorDecoTile);

	// sand house right window wall

	Frame sandHouseRightWindowWallFrame = new FrameBuilder(getSubImage(10, 6)).withScale(tileScale).build();

	MapTileBuilder sandHouseRightWindowWallTile = new MapTileBuilder(sandHouseRightWindowWallFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(sandHouseRightWindowWallTile);

	// sand house left window wall

	Frame sandHouseLeftWindowWallFrame = new FrameBuilder(getSubImage(10, 7)).withScale(tileScale).build();

	MapTileBuilder sandHouseLeftWindowWellTile = new MapTileBuilder(sandHouseLeftWindowWallFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(sandHouseLeftWindowWellTile);

	// sand house left window

	Frame sandHouseLeftWindowFrame = new FrameBuilder(getSubImage(10, 8)).withScale(tileScale).build();

	MapTileBuilder sandHouseLeftWindowTile = new MapTileBuilder(sandHouseLeftWindowFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(sandHouseLeftWindowTile);

	// sand house right window

	Frame sandHouseRightWindowFrame = new FrameBuilder(getSubImage(10, 9)).withScale(tileScale).build();

	MapTileBuilder sandHouseRightWindowTile = new MapTileBuilder(sandHouseRightWindowFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(sandHouseRightWindowTile);

	// autumnPath
	Frame autumnPathFrame = new FrameBuilder(getSubImage(11, 3)).withScale(tileScale).build();

	MapTileBuilder autumnPathTile = new MapTileBuilder(autumnPathFrame);

	mapTiles.add(autumnPathTile);

// autumnLeavePile
	Frame autumnLeavePileFrame = new FrameBuilder(getSubImage(11, 4)).withScale(tileScale).build();

	MapTileBuilder autumnLeavePileTile = new MapTileBuilder(autumnLeavePileFrame);

	mapTiles.add(autumnLeavePileTile);

// autumnGate
	Frame autumnGateFrame = new FrameBuilder(getSubImage(11, 5)).withScale(tileScale).build();

	MapTileBuilder autumnGateTile = new MapTileBuilder(autumnGateFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(autumnGateTile);

// autumnSideGate
	Frame autumnSideGateFrame = new FrameBuilder(getSubImage(12, 4)).withScale(tileScale).build();

	MapTileBuilder autumnSideGateTile = new MapTileBuilder(autumnSideGateFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(autumnSideGateTile);

	/////////////// shop interior ///////////////

	// tileFloor

	Frame tileFloorFrame = new FrameBuilder(getSubImage(12, 5)).withScale(tileScale).build();

	MapTileBuilder tileFloorTile = new MapTileBuilder(tileFloorFrame);

	mapTiles.add(tileFloorTile);

	// counterBottom

	Frame counterBottomFrame = new FrameBuilder(getSubImage(12, 7)).withScale(tileScale).build();

	MapTileBuilder counterBottomTile = new MapTileBuilder(counterBottomFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(counterBottomTile);

	// counterBottomRight

	Frame counterBottomRightFrame = new FrameBuilder(getSubImage(12, 8)).withScale(tileScale).build();

	MapTileBuilder counterBottomRightTile = new MapTileBuilder(counterBottomRightFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(counterBottomRightTile);

	// counterBottomLeft

	Frame counterBottomLeftFrame = new FrameBuilder(getSubImage(12, 6)).withScale(tileScale).build();

	MapTileBuilder counterBottomLeftTile = new MapTileBuilder(counterBottomLeftFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(counterBottomLeftTile);

	// counterTop

	Frame counterTopFrame = new FrameBuilder(getSubImage(11, 7)).withScale(tileScale).build();

	MapTileBuilder counterTopTile = new MapTileBuilder(tileFloorFrame).withTopLayer(counterTopFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(counterTopTile);

	// counterTopRight

	Frame counterTopRightFrame = new FrameBuilder(getSubImage(11, 8)).withScale(tileScale).build();

	MapTileBuilder counterTopRightTile = new MapTileBuilder(tileFloorFrame).withTopLayer(counterTopRightFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(counterTopRightTile);

	// counterTopLeft

	Frame counterTopLeftFrame = new FrameBuilder(getSubImage(11, 8)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder counterTopLeftTile = new MapTileBuilder(tileFloorFrame).withTopLayer(counterTopLeftFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(counterTopLeftTile);

	// shopWall

	Frame shopWallFrame = new FrameBuilder(getSubImage(13, 8)).withScale(tileScale).build();

	MapTileBuilder shopWallTile = new MapTileBuilder(shopWallFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(shopWallTile);

	// shopWallVoidLeft

	Frame shopWallVoidLeftFrame = new FrameBuilder(getSubImage(13, 9)).withScale(tileScale).build();

	MapTileBuilder shopWallVoidLeftTile = new MapTileBuilder(shopWallVoidLeftFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(shopWallVoidLeftTile);

	// shopWallVoidRight

	Frame shopWallVoidRightFrame = new FrameBuilder(getSubImage(13, 9)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder shopWallVoidRightTile = new MapTileBuilder(shopWallVoidRightFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(shopWallVoidRightTile);

	// shopWallVoidUp

	Frame shopWallVoidUpFrame = new FrameBuilder(getSubImage(13, 2)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder shopWallVoidUpTile = new MapTileBuilder(shopWallVoidUpFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(shopWallVoidUpTile);

	// shopWallVoidDown

	Frame shopWallVoidDownFrame = new FrameBuilder(getSubImage(13, 2)).withScale(tileScale).build();

	MapTileBuilder shopWallVoidDownTile = new MapTileBuilder(shopWallVoidDownFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(shopWallVoidDownTile);

	// shopWallVoidUpLeft

	Frame shopWallVoidUpLeftFrame = new FrameBuilder(getSubImage(13, 6)).withScale(tileScale).build();

	MapTileBuilder shopWallVoidUpLeftTile = new MapTileBuilder(shopWallVoidUpLeftFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(shopWallVoidUpLeftTile);

	// shopWallVoidUpRight

	Frame shopWallVoidUpRightFrame = new FrameBuilder(getSubImage(13, 6)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder shopWallVoidUpRightTile = new MapTileBuilder(shopWallVoidUpRightFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(shopWallVoidUpRightTile);

	// shopWallVoidDownLeft

	Frame shopWallVoidDownLeftFrame = new FrameBuilder(getSubImage(13, 6)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder shopWallVoidDownLeftTile = new MapTileBuilder(shopWallVoidDownLeftFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(shopWallVoidDownLeftTile);

	// shopWallVoidDownRight

	Frame shopWallVoidDownRightFrame = new FrameBuilder(getSubImage(13, 6)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_H_AND_V).build();

	MapTileBuilder shopWallVoidDownRightTile = new MapTileBuilder(shopWallVoidDownRightFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(shopWallVoidDownRightTile);

	// void

	Frame voidFrame = new FrameBuilder(getSubImage(13, 7)).withScale(tileScale).build();

	MapTileBuilder voidTile = new MapTileBuilder(voidFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(voidTile);

	// shelfOne

	Frame shelfOneFrame = new FrameBuilder(getSubImage(11, 9)).withScale(tileScale).build();

	MapTileBuilder shelfOneTile = new MapTileBuilder(shelfOneFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(shelfOneTile);

	// shelfTwo

	Frame shelfTwoFrame = new FrameBuilder(getSubImage(12, 9)).withScale(tileScale).build();

	MapTileBuilder shelfTwoTile = new MapTileBuilder(shelfTwoFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(shelfTwoTile);

	// shelfTopOne

	Frame shelfTopOneFrame = new FrameBuilder(getSubImage(13, 3)).withScale(tileScale).build();

	MapTileBuilder shelfTopOneTile = new MapTileBuilder(tileFloorFrame).withTopLayer(shelfTopOneFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(shelfTopOneTile);

	// shelfTopTwo

	Frame shelfTopTwoFrame = new FrameBuilder(getSubImage(13, 4)).withScale(tileScale).build();

	MapTileBuilder shelfTopTwoTile = new MapTileBuilder(tileFloorFrame).withTopLayer(shelfTopTwoFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(shelfTopTwoTile);

	// barrel

	Frame barrelFrame = new FrameBuilder(getSubImage(13, 5)).withScale(tileScale).build();

	MapTileBuilder barrelTile = new MapTileBuilder(barrelFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(barrelTile);

	// hauntedHouseLeft
	Frame hauntedHouseLeftFrame = new FrameBuilder(getSubImage(13, 0)).withScale(tileScale).build();

	MapTileBuilder hauntedHouseLeftTile = new MapTileBuilder(hauntedHouseLeftFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(hauntedHouseLeftTile);

	// hauntedHouseRight
	Frame hauntedHouseRightFrame = new FrameBuilder(getSubImage(13, 0)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder hauntedHouseRightTile = new MapTileBuilder(hauntedHouseRightFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(hauntedHouseRightTile);

	// hauntedHouse
	Frame hauntedHouseFrame = new FrameBuilder(getSubImage(13, 1)).withScale(tileScale).build();

	MapTileBuilder hauntedHouseTile = new MapTileBuilder(hauntedHouseFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(hauntedHouseTile);
	// hauntedHouseRoofLeft
	Frame hauntedHouseRoofLeftFrame = new FrameBuilder(getSubImage(14, 2)).withScale(tileScale).build();

	MapTileBuilder hauntedHouseLeftRoofTile = new MapTileBuilder(deadGrassFrame)
		.withTopLayer(hauntedHouseRoofLeftFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(hauntedHouseLeftRoofTile);

	// hauntedHouseRoofRight
	Frame hauntedHouseRightRoofFrame = new FrameBuilder(getSubImage(14, 2)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder hauntedHouseRightRoofTile = new MapTileBuilder(deadGrassFrame)
		.withTopLayer(hauntedHouseRightRoofFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(hauntedHouseRightRoofTile);

	// hauntedHouseWindow
	Frame hauntedHouseWindowFrame = new FrameBuilder(getSubImage(14, 1)).withScale(tileScale).build();

	MapTileBuilder hauntedHouseWindowTile = new MapTileBuilder(hauntedHouseWindowFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(hauntedHouseWindowTile);

	// hauntedHouseRoof
	Frame hauntedHouseRoofFrame = new FrameBuilder(getSubImage(14, 0)).withScale(tileScale).build();

	MapTileBuilder hauntedHouseRoofTile = new MapTileBuilder(deadGrassFrame).withTopLayer(hauntedHouseRoofFrame)
		.withTileType(TileType.PASSABLE);

	mapTiles.add(hauntedHouseRoofTile);
	// hauntedHouseRoofBlack
	Frame hauntedHouseRoofBlackFrame = new FrameBuilder(getSubImage(14, 3)).withScale(tileScale).build();

	MapTileBuilder hauntedHouseRoofBlackTile = new MapTileBuilder(deadGrassFrame)
		.withTopLayer(hauntedHouseRoofBlackFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(hauntedHouseRoofBlackTile);
	// table
	Frame tableFrame = new FrameBuilder(getSubImage(14, 6)).withScale(tileScale).build();

	MapTileBuilder tableTile = new MapTileBuilder(tableFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(tableTile);
	// hauntedHouseRoofBlack
	Frame hauntedHouseFloorFrame = new FrameBuilder(getSubImage(14, 4)).withScale(tileScale).build();

	MapTileBuilder hauntedHouseFloorTile = new MapTileBuilder(hauntedHouseFloorFrame);

	mapTiles.add(hauntedHouseFloorTile);

	// leftWood
	Frame anitaLeftFloorFrame = new FrameBuilder(getSubImage(14, 7)).withScale(tileScale).build();

	MapTileBuilder anitaLeftFloorTile = new MapTileBuilder(anitaLeftFloorFrame);

	mapTiles.add(anitaLeftFloorTile);

	// rightWood
	Frame anitaRightFloorFrame = new FrameBuilder(getSubImage(14, 7)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder anitaRightFloorTile = new MapTileBuilder(anitaRightFloorFrame);

	mapTiles.add(anitaRightFloorTile);

	// leftbottomWood
	Frame anitaLeftBottomFloorFrame = new FrameBuilder(getSubImage(14, 7)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_H_AND_V).build();

	MapTileBuilder anitaLeftBottomFloorTile = new MapTileBuilder(anitaLeftBottomFloorFrame);

	mapTiles.add(anitaLeftBottomFloorTile);

	// rightBottomWood
	Frame anitaRightBottomFloorFrame = new FrameBuilder(getSubImage(14, 7)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder anitaRightBottomFloorTile = new MapTileBuilder(anitaRightBottomFloorFrame);

	mapTiles.add(anitaRightBottomFloorTile);
	// mourningGrass
	Frame mourningGrassFrame = new FrameBuilder(getSubImage(14, 9)).withScale(tileScale).build();

	MapTileBuilder mourningGrassTile = new MapTileBuilder(mourningGrassFrame).withTileType(TileType.PASSABLE);

	mapTiles.add(mourningGrassTile);
	// mourningRoots
	Frame mourningRootsFrame = new FrameBuilder(getSubImage(15, 0)).withScale(tileScale).build();

	MapTileBuilder mourningRootsTile = new MapTileBuilder(mourningRootsFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(mourningRootsTile);
	// mourningTree
	Frame mourningTreeFrame = new FrameBuilder(getSubImage(15, 1)).withScale(tileScale).build();

	MapTileBuilder mourningTreeTile = new MapTileBuilder(mourningTreeFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(mourningTreeTile);
	// mourningWood
	Frame mourningWoodFrame = new FrameBuilder(getSubImage(15, 2)).withScale(tileScale).build();

	MapTileBuilder mourningWoodTile = new MapTileBuilder(mourningWoodFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(mourningWoodTile);

	// mourningLeaves
	Frame mourningLeavesFrame = new FrameBuilder(getSubImage(15, 3)).withScale(tileScale).build();

	MapTileBuilder mourningLeavesTile = new MapTileBuilder(mourningGrassFrame).withTopLayer(mourningLeavesFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(mourningLeavesTile);
	// mourningWater
	Frame[] mourningWaterFrames = new Frame[] {
		new FrameBuilder(getSubImage(5, 0), 500).withScale(tileScale).withImageEffect(ImageEffect.FLIP_VERTICAL)
			.build(),
		new FrameBuilder(getSubImage(5, 1), 500).withScale(tileScale).withImageEffect(ImageEffect.FLIP_VERTICAL)
			.build(),
		new FrameBuilder(getSubImage(5, 2), 500).withScale(tileScale).withImageEffect(ImageEffect.FLIP_VERTICAL)
			.build(),
		new FrameBuilder(getSubImage(5, 1), 500).withScale(tileScale).withImageEffect(ImageEffect.FLIP_VERTICAL)
			.build(),
		new FrameBuilder(getSubImage(5, 0), 500).withScale(tileScale).withImageEffect(ImageEffect.FLIP_VERTICAL)
			.build(),
		new FrameBuilder(getSubImage(5, 3), 500).withScale(tileScale).withImageEffect(ImageEffect.FLIP_VERTICAL)
			.build(),
		new FrameBuilder(getSubImage(5, 4), 500).withScale(tileScale).withImageEffect(ImageEffect.FLIP_VERTICAL)
			.build(),
		new FrameBuilder(getSubImage(5, 3), 500).withScale(tileScale).withImageEffect(ImageEffect.FLIP_VERTICAL)
			.build() };

	MapTileBuilder mourningWaterTile = new MapTileBuilder(mourningWaterFrames).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(mourningWaterTile);

//		// cauldron
//		
//		Frame cauldronFrame = new FrameBuilder(getSubImage(14, 8)).withScale(tileScale).build();
//
//		MapTileBuilder cauldronTile = new MapTileBuilder(anitaLeftFloorFrame).withTopLayer(cauldronFrame)
//				.withTileType(TileType.NOT_PASSABLE);
//
//		mapTiles.add(cauldronTile);
//		
//		// first cauldron
//		
//		Frame firstCauldronFrame = new FrameBuilder(getSubImage(15, 4)).withScale(tileScale).build();
//
//		MapTileBuilder firstCauldronTile = new MapTileBuilder(anitaLeftFloorFrame).withTopLayer(firstCauldronFrame)
//				.withTileType(TileType.NOT_PASSABLE);
//
//		mapTiles.add(firstCauldronTile);

	// top left bed

	Frame topLeftBedFrame = new FrameBuilder(getSubImage(15, 5)).withScale(tileScale).build();

	MapTileBuilder topLeftBedFrameTile = new MapTileBuilder(anitaLeftFloorFrame).withTopLayer(topLeftBedFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(topLeftBedFrameTile);

	// top right bed

	Frame topRightBedFrame = new FrameBuilder(getSubImage(15, 5)).withImageEffect(ImageEffect.FLIP_HORIZONTAL)
		.withScale(tileScale).build();

	MapTileBuilder topRightBedTile = new MapTileBuilder(anitaRightFloorFrame).withTopLayer(topRightBedFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(topRightBedTile);

	// bottom left bed

	Frame bottomLeftBedFrame = new FrameBuilder(getSubImage(15, 6)).withScale(tileScale).build();

	MapTileBuilder bottomLeftBedTile = new MapTileBuilder(anitaRightBottomFloorFrame)
		.withTopLayer(bottomLeftBedFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(bottomLeftBedTile);

	// bottom right bed


	Frame bottomRightBedFrame = new FrameBuilder(getSubImage(15, 6)).withImageEffect(ImageEffect.FLIP_HORIZONTAL)
		.withScale(tileScale).build();

		MapTileBuilder bottomRightBedTile = new MapTileBuilder(anitaLeftFloorFrame).withTopLayer(bottomRightBedFrame)
						.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(bottomRightBedTile);

	// left desk


	Frame leftDeskFrame = new FrameBuilder(getSubImage(15, 7)).withScale(tileScale).build();

		MapTileBuilder leftDeskTile = new MapTileBuilder(anitaRightFloorFrame).withTopLayer(leftDeskFrame)
						.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(leftDeskTile);

	// right desk

	Frame rightDeskFrame = new FrameBuilder(getSubImage(15, 8)).withScale(tileScale).build();

	MapTileBuilder rightDeskTile = new MapTileBuilder(anitaLeftFloorFrame).withTopLayer(rightDeskFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(rightDeskTile);

	// shelfTopOne in house

	Frame shelfTopOneHouseFrame = new FrameBuilder(getSubImage(13, 3)).withScale(tileScale).build();

	MapTileBuilder shelfTopOneHouseTile = new MapTileBuilder(anitaLeftFloorFrame)
		.withTopLayer(shelfTopOneHouseFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(shelfTopOneHouseTile);

	// shelfTopTwo in house

	Frame shelfTopTwoHouseFrame = new FrameBuilder(getSubImage(13, 4)).withScale(tileScale).build();

	MapTileBuilder shelfTopTwoHouseTile = new MapTileBuilder(anitaRightFloorFrame)
		.withTopLayer(shelfTopTwoHouseFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(shelfTopTwoHouseTile);

	// treeBaseOneLeft

	Frame treeBaseOneLeftFrame = new FrameBuilder(getSubImage(15, 9)).withScale(tileScale).build();

	MapTileBuilder treeBaseOneLeftTile = new MapTileBuilder(treeBaseOneLeftFrame);

	mapTiles.add(treeBaseOneLeftTile);

	// treeBaseOneRight

	Frame treeBaseOneRightFrame = new FrameBuilder(getSubImage(15, 9)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder treeBaseOneRightTile = new MapTileBuilder(treeBaseOneRightFrame);

	mapTiles.add(treeBaseOneRightTile);

	// treeBaseTwoLeft

	Frame treeBaseTwoLeftFrame = new FrameBuilder(getSubImage(16, 9)).withScale(tileScale).build();

	MapTileBuilder treeBaseTwoLeftTile = new MapTileBuilder(treeBaseTwoLeftFrame);

	mapTiles.add(treeBaseTwoLeftTile);

	// treeBaseTwoRight

	Frame treeBaseTwoRightFrame = new FrameBuilder(getSubImage(16, 9)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder treeBaseTwoRightTile = new MapTileBuilder(treeBaseTwoRightFrame);

	mapTiles.add(treeBaseTwoRightTile);

	// springLogsEndOneLeft

	Frame springLogsEndOneLeftFrame = new FrameBuilder(getSubImage(16, 1)).withScale(tileScale).build();

	MapTileBuilder springLogsEndOneLeftTile = new MapTileBuilder(springLogsEndOneLeftFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(springLogsEndOneLeftTile);

	// springLogsEndOneRight

	Frame springLogsEndOneRightFrame = new FrameBuilder(getSubImage(16, 1)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder springLogsEndOneRightTile = new MapTileBuilder(springLogsEndOneRightFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(springLogsEndOneRightTile);

	// springLogsEndTwoLeft

	Frame springLogsEndTwoLeftFrame = new FrameBuilder(getSubImage(16, 2)).withScale(tileScale).build();

	MapTileBuilder springLogsEndTwoLeftTile = new MapTileBuilder(springLogsEndTwoLeftFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(springLogsEndTwoLeftTile);

	// springLogsEndTwoRight

	Frame springLogsEndTwoRightFrame = new FrameBuilder(getSubImage(16, 2)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder springLogsEndTwoRightTile = new MapTileBuilder(springLogsEndTwoRightFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(springLogsEndTwoRightTile);

	// wetSandGrass

	Frame wetSandGrassFrame = new FrameBuilder(getSubImage(16, 0)).withScale(tileScale).build();

	MapTileBuilder wetSandGrassTile = new MapTileBuilder(wetSandGrassFrame);

	mapTiles.add(wetSandGrassTile);

	// firePit

	Frame[] firePitFrames = new Frame[] { new FrameBuilder(getSubImage(16, 3), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(16, 4), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(16, 5), 500).withScale(tileScale).build(),
		new FrameBuilder(getSubImage(16, 4), 500).withScale(tileScale).build() };

	MapTileBuilder firePitTile = new MapTileBuilder(firePitFrames).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(firePitTile);

	// stoneGrassUp

	Frame stoneGrassUpFrame = new FrameBuilder(getSubImage(16, 6)).withScale(tileScale).build();

	MapTileBuilder stoneGrassUpTile = new MapTileBuilder(stoneGrassUpFrame);

	mapTiles.add(stoneGrassUpTile);

	// stoneGrassDown

	Frame stoneGrassDownFrame = new FrameBuilder(getSubImage(16, 6)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder stoneGrassDownTile = new MapTileBuilder(stoneGrassDownFrame);

	mapTiles.add(stoneGrassDownTile);

	// stoneGrassLeft

	Frame stoneGrassLeftFrame = new FrameBuilder(getSubImage(16, 7)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder stoneGrassLeftTile = new MapTileBuilder(stoneGrassLeftFrame);

	mapTiles.add(stoneGrassLeftTile);

	// stoneGrassRight

	Frame stoneGrassRightFrame = new FrameBuilder(getSubImage(16, 7)).withScale(tileScale).build();

	MapTileBuilder stoneGrassRightTile = new MapTileBuilder(stoneGrassRightFrame);

	mapTiles.add(stoneGrassRightTile);

	// stoneGrassUpLeft

	Frame stoneGrassUpLeftFrame = new FrameBuilder(getSubImage(16, 8)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_H_AND_V).build();

	MapTileBuilder stoneGrassUpLeftTile = new MapTileBuilder(stoneGrassUpLeftFrame);

	mapTiles.add(stoneGrassUpLeftTile);

	// stoneGrassUpRight

	Frame stoneGrassUpRightFrame = new FrameBuilder(getSubImage(16, 8)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder stoneGrassUpRightTile = new MapTileBuilder(stoneGrassUpRightFrame);

	mapTiles.add(stoneGrassUpRightTile);

	// stoneGrassDownLeft

	Frame stoneGrassDownLeftFrame = new FrameBuilder(getSubImage(16, 8)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder stoneGrassDownLeftTile = new MapTileBuilder(stoneGrassDownLeftFrame);

	mapTiles.add(stoneGrassDownLeftTile);

	// stoneGrassDownRight

	Frame stoneGrassDownRightFrame = new FrameBuilder(getSubImage(16, 8)).withScale(tileScale).build();

	MapTileBuilder stoneGrassDownRightTile = new MapTileBuilder(stoneGrassDownRightFrame);

	mapTiles.add(stoneGrassDownRightTile);

	// grassSandLeft
	
	Frame grassSandLeftFrame = new FrameBuilder(getSubImage(17, 4)).withScale(tileScale).build();

	MapTileBuilder grassSandLeftTile = new MapTileBuilder(grassSandLeftFrame);

	mapTiles.add(grassSandLeftTile);

	// grassSandRight
	
	Frame grassSandRightFrame = new FrameBuilder(getSubImage(17, 4)).withScale(tileScale).withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder grassSandRightTile = new MapTileBuilder(grassSandRightFrame);

	mapTiles.add(grassSandRightTile);
	
	// grassSandT
	
	Frame grassSandTFrame = new FrameBuilder(getSubImage(17, 5)).withScale(tileScale).build();

	MapTileBuilder grassSandTTile = new MapTileBuilder(grassSandTFrame);

	mapTiles.add(grassSandTTile);
	
	// grassSandB
	
	Frame grassSandBFrame = new FrameBuilder(getSubImage(17, 5)).withScale(tileScale).withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder grassSandBTile = new MapTileBuilder(grassSandBFrame);

	mapTiles.add(grassSandBTile);
	
	// grassSandTL
	
	Frame grassSandTLFrame = new FrameBuilder(getSubImage(17, 7)).withScale(tileScale).build();

	MapTileBuilder grassSandTLTile = new MapTileBuilder(grassSandTLFrame);

	mapTiles.add(grassSandTLTile);
	
	// grassSandTR
	
	Frame grassSandTRFrame = new FrameBuilder(getSubImage(17, 7)).withScale(tileScale).withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder grassSandTRTile = new MapTileBuilder(grassSandTRFrame);

	mapTiles.add(grassSandTRTile);
	
	// grassSandBL
	
	Frame grassSandBLFrame = new FrameBuilder(getSubImage(17, 7)).withScale(tileScale).withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder grassSandBLTile = new MapTileBuilder(grassSandBLFrame);

	mapTiles.add(grassSandBLTile);
	
	// grassSandBR
	
	Frame grassSandBRFrame = new FrameBuilder(getSubImage(17, 7)).withScale(tileScale).withImageEffect(ImageEffect.FLIP_H_AND_V).build();

	MapTileBuilder grassSandBRTile = new MapTileBuilder(grassSandBRFrame);

	mapTiles.add(grassSandBRTile);
	
	// sandGrassTL
	
	Frame sandGrassTLFrame = new FrameBuilder(getSubImage(17, 6)).withScale(tileScale).build();

	MapTileBuilder sandGrassTLTile = new MapTileBuilder(sandGrassTLFrame);

	mapTiles.add(sandGrassTLTile);
	
	// sandGrassTR
	
	Frame sandGrassTRFrame = new FrameBuilder(getSubImage(17, 6)).withScale(tileScale).withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder sandGrassTRTile = new MapTileBuilder(sandGrassTRFrame);

	mapTiles.add(sandGrassTRTile);
	
	// sandGrassBL
	
	Frame sandGrassBLFrame = new FrameBuilder(getSubImage(17, 6)).withScale(tileScale).withImageEffect(ImageEffect.FLIP_VERTICAL).build();

	MapTileBuilder sandGrassBLTile = new MapTileBuilder(sandGrassBLFrame);

	mapTiles.add(sandGrassBLTile);
	
	// sandGrassBR
	
	Frame sandGrassBRFrame = new FrameBuilder(getSubImage(17, 6)).withScale(tileScale).withImageEffect(ImageEffect.FLIP_H_AND_V).build();

	MapTileBuilder sandGrassBRTile = new MapTileBuilder(sandGrassBRFrame);

	mapTiles.add(sandGrassBRTile);
	
	// winterLogsEndRight
	
	Frame winterLogsEndRightOneFrame = new FrameBuilder(getSubImage(17, 2)).withScale(tileScale).build();

	MapTileBuilder winterLogsEndRightOneTile = new MapTileBuilder(winterLogsEndRightOneFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(winterLogsEndRightOneTile);
	
	Frame winterLogsEndRightTwoFrame = new FrameBuilder(getSubImage(17, 2)).withScale(tileScale).withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder winterLogsEndRightTwoTile = new MapTileBuilder(winterLogsEndRightTwoFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(winterLogsEndRightTwoTile);
	
	// winterLogsEndLeft
	
	Frame winterLogsEndLeftOneFrame = new FrameBuilder(getSubImage(17, 3)).withScale(tileScale).build();

	MapTileBuilder winterLogsEndLeftOneTile = new MapTileBuilder(winterLogsEndLeftOneFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(winterLogsEndLeftOneTile);
	
	Frame winterLogsEndLeftTwoFrame = new FrameBuilder(getSubImage(17, 3)).withScale(tileScale).withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder winterLogsEndLeftTwoTile = new MapTileBuilder(winterLogsEndLeftTwoFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(winterLogsEndLeftTwoTile);
	
	// solidFallTrunk
	
	Frame solidFallTrunkFrame = new FrameBuilder(getSubImage(7, 0)).withScale(tileScale).build();

	MapTileBuilder solidFallTrunkTile = new MapTileBuilder(solidFallTrunkFrame).withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(solidFallTrunkTile);
	
	// deadTreeBaseLeft
	
	Frame deadTreeBaseLeftOneFrame = new FrameBuilder(getSubImage(18, 2)).withScale(tileScale)
		.build();

	MapTileBuilder deadTreeBaseLeftOneTile = new MapTileBuilder(deadTreeBaseLeftOneFrame);

	mapTiles.add(deadTreeBaseLeftOneTile);
	
	Frame deadTreeBaseLeftTwoFrame = new FrameBuilder(getSubImage(18, 2)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder deadTreeBaseLeftTwoTile = new MapTileBuilder(deadTreeBaseLeftTwoFrame);

	mapTiles.add(deadTreeBaseLeftTwoTile);
	
	// deadTreeBaseRight
	
	Frame deadTreeBaseRightOneFrame = new FrameBuilder(getSubImage(18, 3)).withScale(tileScale)
		.build();

	MapTileBuilder deadTreeBaseRightOneTile = new MapTileBuilder(deadTreeBaseRightOneFrame);

	mapTiles.add(deadTreeBaseRightOneTile);
	
	Frame deadTreeBaseRightTwoFrame = new FrameBuilder(getSubImage(18, 3)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder deadTreeBaseRightTwoTile = new MapTileBuilder(deadTreeBaseRightTwoFrame);

	mapTiles.add(deadTreeBaseRightTwoTile);
	
	// winterTreeBaseLeft
	
	Frame winterTreeBaseLeftOneFrame = new FrameBuilder(getSubImage(18, 0)).withScale(tileScale)
		.build();

	MapTileBuilder winterTreeBaseLeftOneTile = new MapTileBuilder(winterTreeBaseLeftOneFrame);

	mapTiles.add(winterTreeBaseLeftOneTile);
	
	Frame winterTreeBaseLeftTwoFrame = new FrameBuilder(getSubImage(18, 0)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder winterTreeBaseLeftTwoTile = new MapTileBuilder(winterTreeBaseLeftTwoFrame);

	mapTiles.add(winterTreeBaseLeftTwoTile);
	
	// winterTreeBaseRight
	
	Frame winterTreeBaseRightOneFrame = new FrameBuilder(getSubImage(18, 1)).withScale(tileScale)
		.build();

	MapTileBuilder winterTreeBaseRightOneTile = new MapTileBuilder(winterTreeBaseRightOneFrame);

	mapTiles.add(winterTreeBaseRightOneTile);
	
	Frame winterTreeBaseRightTwoFrame = new FrameBuilder(getSubImage(18, 1)).withScale(tileScale)
		.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder winterTreeBaseRightTwoTile = new MapTileBuilder(winterTreeBaseRightTwoFrame);

	mapTiles.add(winterTreeBaseRightTwoTile);
	
	// logsBaseEndRight
	
	Frame logsBaseEndRightOneFrame = new FrameBuilder(getSubImage(17, 0)).withScale(tileScale).build();

	MapTileBuilder logsBaseEndRightOneTile = new MapTileBuilder(logsBaseEndRightOneFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(logsBaseEndRightOneTile);
	
	Frame logsBaseEndRightTwoFrame = new FrameBuilder(getSubImage(17, 0)).withScale(tileScale).withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder logsBaseEndRightTwoTile = new MapTileBuilder(logsBaseEndRightTwoFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(logsBaseEndRightTwoTile);
	
	// logsBaseEndLeft
	
	Frame logsBaseEndLeftOneFrame = new FrameBuilder(getSubImage(17, 1)).withScale(tileScale).build();

	MapTileBuilder logsBaseEndLeftOneTile = new MapTileBuilder(logsBaseEndLeftOneFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(logsBaseEndLeftOneTile);
	
	Frame logsBaseEndLeftTwoFrame = new FrameBuilder(getSubImage(17, 1)).withScale(tileScale).withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

	MapTileBuilder logsBaseEndLeftTwoTile = new MapTileBuilder(logsBaseEndLeftTwoFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(logsBaseEndLeftTwoTile);
	
	// wetSandFall
	
	Frame wetSandFallFrame = new FrameBuilder(getSubImage(17, 9)).withScale(tileScale).build();

	MapTileBuilder wetSandFallTile = new MapTileBuilder(wetSandFallFrame);

	mapTiles.add(wetSandFallTile);
	
	// wetSandSummer
	
	Frame wetSandSummerFrame = new FrameBuilder(getSubImage(17, 8)).withScale(tileScale).build();

	MapTileBuilder wetSandSummerTile = new MapTileBuilder(wetSandSummerFrame);

	mapTiles.add(wetSandSummerTile);
	
	// solidAutumnLeaves
	
	Frame solidAutumnLeavesFrame = new FrameBuilder(getSubImage(7, 1)).withScale(tileScale).build();

	MapTileBuilder solidAutumnLeavesTile = new MapTileBuilder(cliffDownFrame).withTopLayer(solidAutumnLeavesFrame)
		.withTileType(TileType.NOT_PASSABLE);

	mapTiles.add(solidAutumnLeavesTile);
	
	

	return mapTiles;

    }
}
