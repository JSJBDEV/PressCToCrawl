package gd.rf.acro.crawl.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BreakableBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class CrawlBlock extends BreakableBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
    public CrawlBlock(Properties properties) {
        super(properties);
    }
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    //this function use to be tick() but that apparently doesnt exist in 1.15
    @Override
    public void func_225534_a_(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos,Blocks.AIR.getDefaultState());
    }

    @Override
    public boolean ticksRandomly(BlockState p_149653_1_) {
        return super.ticksRandomly(p_149653_1_);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn.getPosition().getY()>pos.getY()-0.5)
        {
            worldIn.setBlockState(pos,Blocks.AIR.getDefaultState());
        }
    }
}
