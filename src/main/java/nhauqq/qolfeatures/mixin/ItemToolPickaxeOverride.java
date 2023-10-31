package nhauqq.qolfeatures.mixin;

import net.minecraft.core.block.Block;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import nhauqq.qolfeatures.helper.InventoryHelper;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = ItemToolPickaxe.class, remap = false)
public abstract class ItemToolPickaxeOverride extends ItemTool {
	protected ItemToolPickaxeOverride (String name, int id, int damageDealt, ToolMaterial toolMaterial, Tag<Block> tagEffectiveAgainst) {
		super(name, id, damageDealt, toolMaterial, tagEffectiveAgainst);
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced){
		int torchIndex = InventoryHelper.findStackIndex(entityplayer.inventory.mainInventory, new ItemStack(Block.torchCoal));
		if (torchIndex != -1){
			ItemStack stack = entityplayer.inventory.mainInventory[torchIndex];
			boolean flag = stack.getItem().onItemUse(stack, entityplayer, world, blockX, blockY, blockZ, side, xPlaced, yPlaced);
			if (stack.stackSize <= 0){
				entityplayer.inventory.mainInventory[torchIndex] = null;
			}
			return flag;
		}
		return false;
	}
}
