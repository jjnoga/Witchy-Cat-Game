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

		MapTileBuilder snowTile = new MapTileBuilder(snowFrame);

		mapTiles.add(snowTile);

		// ice
		Frame iceFrame = new FrameBuilder(getSubImage(0, 6)).withScale(tileScale).build();

		MapTileBuilder iceTile = new MapTileBuilder(iceFrame);

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
				new FrameBuilder(getSubImage(1, 9), 500).withScale(tileScale).build(),
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

		MapTileBuilder autTreeTrunkTile = new MapTileBuilder(autTreeTrunkFrame).withTileType(TileType.NOT_PASSABLE);

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

		return mapTiles;

	}
}
