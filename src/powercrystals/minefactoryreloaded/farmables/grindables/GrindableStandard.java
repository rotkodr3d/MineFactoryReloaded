package powercrystals.minefactoryreloaded.farmables.grindables;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import powercrystals.minefactoryreloaded.api.IFactoryGrindable;
import powercrystals.minefactoryreloaded.api.MobDrop;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrindableStandard implements IFactoryGrindable
{
	private Class<? extends EntityLivingBase> _grindableClass;
	private List<MobDrop> _drops;
	private boolean _entityProcessed;

	public GrindableStandard(Class<? extends EntityLivingBase> entityToGrind, MobDrop[] dropStacks, boolean entityProcessed)
	{
		_grindableClass = entityToGrind;
		_drops = new ArrayList<MobDrop>();
		for(MobDrop d : dropStacks)
		{
			_drops.add(d);
		}
		_entityProcessed = entityProcessed;
	}

	public GrindableStandard(Class<? extends EntityLivingBase> entityToGrind, MobDrop[] dropStacks)
	{
		this(entityToGrind, dropStacks, true);
	}

	public GrindableStandard(Class<? extends EntityLivingBase> entityToGrind, @Nonnull ItemStack dropStack, boolean entityProcessed)
	{
		_grindableClass = entityToGrind;
		_drops = new ArrayList<MobDrop>();
		_drops.add(new MobDrop(10, dropStack));
		_entityProcessed = entityProcessed;
	}

	public GrindableStandard(Class<? extends EntityLivingBase> entityToGrind, @Nonnull ItemStack dropStack)
	{
		this(entityToGrind, dropStack, true);
	}

	public GrindableStandard(Class<? extends EntityLivingBase> entityToGrind, boolean entityProcessed)
	{
		_grindableClass = entityToGrind;
		_drops = new ArrayList<MobDrop>();
		_entityProcessed = entityProcessed;
	}

	public GrindableStandard(Class<? extends EntityLivingBase> entityToGrind)
	{
		this(entityToGrind, true);
	}

	@Override
	public Class<? extends EntityLivingBase> getGrindableEntity()
	{
		return _grindableClass;
	}

	@Override
	public List<MobDrop> grind(World world, EntityLivingBase entity, Random random)
	{
		return _drops;
	}

	@Override
	public boolean processEntity(EntityLivingBase entity)
	{
		return _entityProcessed;
	}
}
