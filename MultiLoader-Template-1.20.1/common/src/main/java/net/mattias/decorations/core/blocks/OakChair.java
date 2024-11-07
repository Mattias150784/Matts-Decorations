package net.mattias.decorations.core.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;

public class OakChair extends RotatedPillarBlock {

    // Define the complete VoxelShape for the chair by calling makeShape()
    private static final VoxelShape CHAIR_SHAPE = makeShape();

    public OakChair(Properties properties) {
        super(properties);
    }

    // Updated makeShape method as requested
    private static VoxelShape makeShape() {
        VoxelShape shape = Shapes.empty();

        // Legs
        shape = Shapes.join(shape, Shapes.box(0, 0, 0, 0.125, 0.5625, 0.125), BooleanOp.OR); // Front left leg
        shape = Shapes.join(shape, Shapes.box(0.875, 0, 0, 1, 0.5625, 0.125), BooleanOp.OR); // Front right leg
        shape = Shapes.join(shape, Shapes.box(0, 0, 0.875, 0.125, 0.5625, 1), BooleanOp.OR); // Back left leg
        shape = Shapes.join(shape, Shapes.box(0.875, 0, 0.875, 1, 0.5625, 1), BooleanOp.OR); // Back right leg

        // Seat area
        shape = Shapes.join(shape, Shapes.box(0, 0.5625, 0, 1, 0.6875, 1), BooleanOp.OR); // Seat

        // Backrest
        shape = Shapes.join(shape, Shapes.box(0, 0.6875, 0.875, 1, 1.6875, 1), BooleanOp.OR); // Backrest

        return shape;
    }

    // Override methods to use the custom VoxelShape
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return CHAIR_SHAPE;
    }

    @Override
    public VoxelShape getInteractionShape(BlockState state, BlockGetter world, BlockPos pos) {
        return CHAIR_SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return CHAIR_SHAPE;
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter world, BlockPos pos) {
        return 0;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        return InteractionResult.PASS;
    }
}
