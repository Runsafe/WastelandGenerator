package no.runsafe.wastelandgenerator;

import no.runsafe.framework.minecraft.Item;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class Generator extends ChunkGenerator
{
	@Override
	public byte[][] generateBlockSections(World world, Random random, int cx, int cz, BiomeGrid biomes)
	{
		byte[][] result = new byte[world.getMaxHeight() / 16][];

		for (int x = 0; x < 16; x++)
		{
			for (int z = 0; z < 16; z++)
			{
				result = setBlock(result, x, 60, z, (byte) Item.BuildingBlock.Dirt.getItemID());
				if (random.nextInt(4) == 2)
					result = setBlock(result, x, 61, z, (byte) Item.Decoration.LongGrass.getItemID());
			}
		}

		return result;
	}

	private byte[][] setBlock(byte[][] result, int x, int y, int z, byte block)
	{
		if (result[y >>4] == null)
			result[y >> 4] = new byte[4096];

		result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = block;
		return result;
	}

	private Random random = new Random();
}
