package Kamen_Rider_Craft_4TH.item.Ichigo;


import Kamen_Rider_Craft_4TH.RiderItems;
import Kamen_Rider_Craft_4TH.TokuCraft_core;
import Kamen_Rider_Craft_4TH.util.IHasModel;
import Kamen_Rider_Craft_4TH.util.Refercence;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.nbt.NBTTagCompound;

public class item_Ichigoarmor extends ItemArmor  implements IHasModel
{

	public static final String[] CoreName= new String[] {"","_robo_rider","_bio_rider"};
	public static final String[] CoreNameStr= new String[] {"","_charge_up"};

	private static final int[] maxDamageArray = new int[] {11, 16, 15, 13};
	public String armorNamePrefix;
	public ArmorMaterial material;

	public item_Ichigoarmor (String name,ArmorMaterial par2EnumArmorMaterial, int par3, EntityEquipmentSlot par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.material = par2EnumArmorMaterial;
		par2EnumArmorMaterial.getDamageReductionAmount(par4);
		this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
		this.maxStackSize = 1;
		
        setUnlocalizedName(name);
        setRegistryName(name);
        TokuCraft_core.ITEMS.add(this);
	}


	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{

		if (entity instanceof EntityLivingBase){
			EntityLivingBase player = ((EntityLivingBase)entity);


			if (player.getItemStackFromSlot(EntityEquipmentSlot.FEET)!= null){

				if (player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof item_Ichigodriver){

					String rider = ((item_Ichigodriver)player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem()).Rider;


					if ((item_Ichigodriver)player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == RiderItems.sunriser ){

						if ( slot == EntityEquipmentSlot.LEGS)
						{
							return Refercence.MODID+":textures/armor/"+rider +CoreName[item_Ichigodriver.get_core(player.getItemStackFromSlot(EntityEquipmentSlot.FEET))]+"_2.png";
						}
						if ( slot == EntityEquipmentSlot.HEAD||slot == EntityEquipmentSlot.CHEST  )
						{
							return Refercence.MODID+":textures/armor/"+rider +CoreName[item_Ichigodriver.get_core(player.getItemStackFromSlot(EntityEquipmentSlot.FEET))]+"_1.png";

						}

					}else if ((item_Ichigodriver)player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == RiderItems.electrer ){

						if ( slot == EntityEquipmentSlot.LEGS)
						{
							return Refercence.MODID+":textures/armor/"+rider +CoreNameStr[item_Ichigodriver.get_core(player.getItemStackFromSlot(EntityEquipmentSlot.FEET))]+"_2.png";
						}
						if (slot == EntityEquipmentSlot.HEAD||slot == EntityEquipmentSlot.CHEST )
						{
							return Refercence.MODID+":textures/armor/"+rider +CoreNameStr[item_Ichigodriver.get_core(player.getItemStackFromSlot(EntityEquipmentSlot.FEET))]+"_1.png";

						}

					}else{

						if ( slot == EntityEquipmentSlot.LEGS)
						{
							return Refercence.MODID+":textures/armor/"+rider +"_2.png";
						}
						if (slot == EntityEquipmentSlot.HEAD||slot == EntityEquipmentSlot.CHEST  )
						{
							return Refercence.MODID+":textures/armor/"+rider +"_1.png";

						}

					}
					return Refercence.MODID+":textures/armor/blank.png";


				}
			}
			else
			{
				return Refercence.MODID+":textures/armor/blank.png";


			}
		}
		return Refercence.MODID+":textures/armor/blank.png";

	}


	/**
	 * Returns the 'max damage' factor array for the armor, each piece of armor have a durability factor (that gets
	 * multiplied by armor material factor)
	 */
	static int[] getMaxDamageArray()
	{
		return maxDamageArray;
	}
	@Override
	public void registerModels() {
		TokuCraft_core.proxy.registerItemRender(this,0,"inventory");
	}

}