package house.greenhouse.bovinesandbuttercups.content.block.entity;

import house.greenhouse.bovinesandbuttercups.api.block.CustomFlowerType;
import house.greenhouse.bovinesandbuttercups.api.block.CustomMushroomType;
import house.greenhouse.bovinesandbuttercups.content.component.ItemCustomFlower;
import house.greenhouse.bovinesandbuttercups.content.component.ItemCustomMushroom;
import house.greenhouse.bovinesandbuttercups.registry.BovinesBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
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

    public void setFlowerType(ItemCustomFlower flower) {
        customFlower = flower;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        setFlowerType(new ItemCustomFlower(CustomFlowerType.CODEC.decode(registries.createSerializationContext(NbtOps.INSTANCE), tag.get("custom_flower")).getOrThrow().getFirst()));
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("custom_flower", CustomFlowerType.CODEC.encodeStart(registries.createSerializationContext(NbtOps.INSTANCE), getFlowerType().holder()).getOrThrow());
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
