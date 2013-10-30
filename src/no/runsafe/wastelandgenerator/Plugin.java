package no.runsafe.wastelandgenerator;

import no.runsafe.framework.RunsafePlugin;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class Plugin extends RunsafePlugin
{
	@Override
	protected void PluginSetup() {}

	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id)
	{
		return new Generator();
	}

	public Location getFixedSpawnLocation(World world, Random random)
	{
		return new Location(world, 0.5D, 64D, 0.5D);
	}
}
