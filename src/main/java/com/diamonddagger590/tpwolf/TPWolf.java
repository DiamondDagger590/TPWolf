package com.diamonddagger590.tpwolf;

import com.diamonddagger590.tpwolf.events.ChunkUnload;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TPWolf extends JavaPlugin {

  @Override
  public void onEnable(){
    Bukkit.getPluginManager().registerEvents(new ChunkUnload(), this);
  }

  @Override
  public void onDisable(){
    // Plugin shutdown logic
  }
}
