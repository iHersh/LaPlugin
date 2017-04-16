package me.Chase.Main;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Kits {
	
	public enum KitsEnum {
		STARTER,
		VIP,
		VIPPLUS,
		PREMIUM
	}
	
	static String starter = "&7Starter&r ";
	static String vip = "&5&lVIP&r ";
	static String vipplus = "&5&lVIP+&r ";
	static String premium = "&9&lPremium&r ";
	
	@SuppressWarnings("deprecation")
	public static void starter(Player p)
	{
		Inventory inv = p.getInventory();
		
		ItemStack it1 = new ItemStack(Material.getMaterial(298));
		ItemMeta it1m = it1.getItemMeta();
		
		ItemStack it2 = new ItemStack(Material.getMaterial(299));
		ItemMeta it2m = it2.getItemMeta();
		
		ItemStack it3 = new ItemStack(Material.getMaterial(300));
		ItemMeta it3m = it3.getItemMeta();
		
		ItemStack it4 = new ItemStack(Material.getMaterial(301));
		ItemMeta it4m = it4.getItemMeta();
		
		ItemStack it5 = new ItemStack(Material.getMaterial(272));
		ItemMeta it5m = it5.getItemMeta();
		
		ItemStack it6 = new ItemStack(Material.getMaterial(274));
		ItemMeta it6m = it6.getItemMeta();
		
		ItemStack it7 = new ItemStack(Material.getMaterial(275));
		ItemMeta it7m = it7.getItemMeta();
		
		ItemStack it8 = new ItemStack(Material.getMaterial(261));
		ItemMeta it8m = it8.getItemMeta();
		
		ItemStack it9 = new ItemStack(Material.getMaterial(262));
		ItemStack it10 = new ItemStack(Material.getMaterial(366));
		
		it1m.setDisplayName(Main.color(starter + "Helmet"));
		it2m.setDisplayName(Main.color(starter + "Chestplate"));
		it3m.setDisplayName(Main.color(starter + "Leggings"));
		it4m.setDisplayName(Main.color(starter + "Boots"));
		it5m.setDisplayName(Main.color(starter + "Sword"));
		it6m.setDisplayName(Main.color(starter + "Pickaxe"));
		it7m.setDisplayName(Main.color(starter + "Axe"));
		it8m.setDisplayName(Main.color(starter + "Bow"));
		
		it1.setItemMeta(it1m);
		it2.setItemMeta(it2m);
		it3.setItemMeta(it3m);
		it4.setItemMeta(it4m);
		it5.setItemMeta(it5m);
		it6.setItemMeta(it6m);
		it7.setItemMeta(it7m);
		it8.setItemMeta(it8m);
		
		inv.addItem(it1);
		inv.addItem(it2);
		inv.addItem(it3);
		inv.addItem(it4);
		inv.addItem(it5);
		inv.addItem(it6);
		inv.addItem(it7);
		inv.addItem(it8);
		inv.addItem(it9);
		inv.addItem(it10);
		
		p.sendMessage(Main.color(Main.kits + "&aYou have recieved the STARTER kit!"));
	}
	
	@SuppressWarnings("deprecation")
	public static void vip(Player p)
	{
		Inventory inv = p.getInventory();
		
		ItemStack it1 = new ItemStack(Material.getMaterial(267));
		ItemMeta it1m = it1.getItemMeta();
		
		ItemStack it2 = new ItemStack(Material.getMaterial(306));
		ItemMeta it2m = it2.getItemMeta();
		
		ItemStack it3 = new ItemStack(Material.getMaterial(307));
		ItemMeta it3m = it3.getItemMeta();
		
		ItemStack it4 = new ItemStack(Material.getMaterial(308));
		ItemMeta it4m = it4.getItemMeta();
		
		ItemStack it5 = new ItemStack(Material.getMaterial(309));
		ItemMeta it5m = it5.getItemMeta();
		
		ItemStack it6 = new ItemStack(Material.getMaterial(261));
		ItemMeta it6m = it6.getItemMeta();
		
		ItemStack it9 = new ItemStack(Material.getMaterial(262));
		ItemStack it10 = new ItemStack(Material.getMaterial(366));
		
		it1m.setDisplayName(Main.color(vip + "Sword"));
		it1m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		it1m.addEnchant(Enchantment.DURABILITY, 3, true);
		
		it2m.setDisplayName(Main.color(vip + "Helmet"));
		it2m.addEnchant(Enchantment.DURABILITY, 3, true);
		
		it3m.setDisplayName(Main.color(vip + "Chestplate"));
		it3m.addEnchant(Enchantment.DURABILITY, 3, true);
		
		it4m.setDisplayName(Main.color(vip + "Leggings"));
		it4m.addEnchant(Enchantment.DURABILITY, 3, true);
		
		it5m.setDisplayName(Main.color(vip + "Boots"));
		it5m.addEnchant(Enchantment.DURABILITY, 3, true);
		
		it6m.setDisplayName(Main.color(vip + "Bow"));
		it6m.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		
		it1.setItemMeta(it1m);
		it2.setItemMeta(it2m);
		it3.setItemMeta(it3m);
		it4.setItemMeta(it4m);
		it5.setItemMeta(it5m);
		it6.setItemMeta(it6m);
		
		inv.addItem(it1);
		inv.addItem(it2);
		inv.addItem(it3);
		inv.addItem(it4);
		inv.addItem(it5);
		inv.addItem(it6);
		inv.addItem(it9);
		inv.addItem(it10);
		
		p.sendMessage(Main.color(Main.kits + "&aYou have recieved the " + Main.vip + " &akit!"));
	}
	
	@SuppressWarnings("deprecation")
	public static void vipplus(Player p)
	{
		Inventory inv = p.getInventory();
		
		ItemStack it1 = new ItemStack(Material.getMaterial(276));
		ItemMeta it1m = it1.getItemMeta();
		
		ItemStack it2 = new ItemStack(Material.getMaterial(306));
		ItemMeta it2m = it2.getItemMeta();
		
		ItemStack it3 = new ItemStack(Material.getMaterial(307));
		ItemMeta it3m = it3.getItemMeta();
		
		ItemStack it4 = new ItemStack(Material.getMaterial(308));
		ItemMeta it4m = it4.getItemMeta();
		
		ItemStack it5 = new ItemStack(Material.getMaterial(309));
		ItemMeta it5m = it5.getItemMeta();
		
		ItemStack it6 = new ItemStack(Material.getMaterial(261));
		ItemMeta it6m = it6.getItemMeta();
		
		ItemStack it9 = new ItemStack(Material.getMaterial(262));
		ItemStack it10 = new ItemStack(Material.getMaterial(366));
		
		it1m.setDisplayName(Main.color(vipplus + "Sword"));
		it1m.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
		it1m.addEnchant(Enchantment.DURABILITY, 3, true);
		
		it2m.setDisplayName(Main.color(vipplus + "Helmet"));
		it2m.addEnchant(Enchantment.DURABILITY, 3, true);
		it2m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		
		it3m.setDisplayName(Main.color(vipplus + "Chestplate"));
		it3m.addEnchant(Enchantment.DURABILITY, 3, true);
		it3m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		
		it4m.setDisplayName(Main.color(vipplus + "Leggings"));
		it4m.addEnchant(Enchantment.DURABILITY, 3, true);
		it4m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		
		it5m.setDisplayName(Main.color(vipplus + "Boots"));
		it5m.addEnchant(Enchantment.DURABILITY, 3, true);
		it5m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		
		it6m.setDisplayName(Main.color(vipplus + "Bow"));
		it6m.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		it6m.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
		it6m.addEnchant(Enchantment.DURABILITY, 3, true);
		
		it1.setItemMeta(it1m);
		it2.setItemMeta(it2m);
		it3.setItemMeta(it3m);
		it4.setItemMeta(it4m);
		it5.setItemMeta(it5m);
		it6.setItemMeta(it6m);
		
		inv.addItem(it1);
		inv.addItem(it2);
		inv.addItem(it3);
		inv.addItem(it4);
		inv.addItem(it5);
		inv.addItem(it6);
		inv.addItem(it9);
		inv.addItem(it10);
		
		p.sendMessage(Main.color(Main.kits + "&aYou have recieved the " + Main.vipplus + " &akit!"));
	}
	
	@SuppressWarnings("deprecation")
	public static void premium(Player p)
	{
		Inventory inv = p.getInventory();
		
		ItemStack it1 = new ItemStack(Material.getMaterial(276));
		ItemMeta it1m = it1.getItemMeta();
		
		ItemStack it2 = new ItemStack(Material.getMaterial(310));
		ItemMeta it2m = it2.getItemMeta();
		
		ItemStack it3 = new ItemStack(Material.getMaterial(311));
		ItemMeta it3m = it3.getItemMeta();
		
		ItemStack it4 = new ItemStack(Material.getMaterial(312));
		ItemMeta it4m = it4.getItemMeta();
		
		ItemStack it5 = new ItemStack(Material.getMaterial(313));
		ItemMeta it5m = it5.getItemMeta();
		
		ItemStack it6 = new ItemStack(Material.getMaterial(261));
		ItemMeta it6m = it6.getItemMeta();
		
		ItemStack it9 = new ItemStack(Material.getMaterial(262));
		ItemStack it10 = new ItemStack(Material.getMaterial(366));
		
		it1m.setDisplayName(Main.color(premium + "Sword"));
		it1m.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
		it1m.addEnchant(Enchantment.DURABILITY, 3, true);
		
		it2m.setDisplayName(Main.color(premium + "Helmet"));
		it2m.addEnchant(Enchantment.DURABILITY, 3, true);
		it2m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		
		it3m.setDisplayName(Main.color(premium + "Chestplate"));
		it3m.addEnchant(Enchantment.DURABILITY, 3, true);
		it3m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		
		it4m.setDisplayName(Main.color(premium + "Leggings"));
		it4m.addEnchant(Enchantment.DURABILITY, 3, true);
		it4m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		
		it5m.setDisplayName(Main.color(premium + "Boots"));
		it5m.addEnchant(Enchantment.DURABILITY, 3, true);
		it5m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		
		it6m.setDisplayName(Main.color(premium + "Bow"));
		it6m.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		it6m.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
		it6m.addEnchant(Enchantment.DURABILITY, 3, true);
		
		it1.setItemMeta(it1m);
		it2.setItemMeta(it2m);
		it3.setItemMeta(it3m);
		it4.setItemMeta(it4m);
		it5.setItemMeta(it5m);
		it6.setItemMeta(it6m);
		
		inv.addItem(it1);
		inv.addItem(it2);
		inv.addItem(it3);
		inv.addItem(it4);
		inv.addItem(it5);
		inv.addItem(it6);
		inv.addItem(it9);
		inv.addItem(it10);
		
		p.sendMessage(Main.color(Main.kits + "&aYou have recieved the " + Main.premium + " &akit!"));
	}
	
	//THIS IS JUST FOR FUTURE USE WITH DIFFERENT CLASSES!!
	//THE STUFF ABOVE IS JUST HARD-CODED!
	public static void addItem(ItemStack it, String name, Player p) {
		ItemStack item = it;
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		
		p.getInventory().addItem(it);
	}
}
