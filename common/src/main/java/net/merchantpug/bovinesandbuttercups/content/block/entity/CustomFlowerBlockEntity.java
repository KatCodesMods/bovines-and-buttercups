package net.merchantpug.bovinesandbuttercups.content.block.entity;

import net.merchantpug.bovinesandbuttercups.content.component.ItemCustomFlower;
import net.merchantpug.bovinesandbuttercups.registry.BovinesBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CustomFlowerBlockEntity extends BlockEntity {
    @Nullable
    private ItemCustomFlower customFlower;

    public CustomFlowerBlockEntity(BlockPos pos, BlockState state) {
        super(BovinesBlockEntityTypes.CUSTOM_FLOWER, pos, state);
    }

    public ItemCustomFlower getFlowerType() {
        return customFlower;
    }

    public void setCustomFlower(ItemCustomFlower flower) {
        customFlower = flower;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        return saveWithoutMetadata(provider);
    }
}
