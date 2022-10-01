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
	super(ImageLoader.load("CommonTileset2.png"), 16, 16, 3);
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

	return mapTiles;
    }
}
