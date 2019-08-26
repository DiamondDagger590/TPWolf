package com.diamonddagger590.tpwolf.events;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

public class ChunkUnload implements Listener {

  @EventHandler(priority = EventPriority.LOWEST)
  public void onUnload(final ChunkUnloadEvent e){
    final Chunk c = e.getChunk();
    if(c.getEntities() == null){
      return;
    }
    Entity[] entities;
    for(int length = (entities = c.getEntities()).length, i = 0; i < length; ++i){
      final Entity en = entities[i];
      if(en != null){
        if(en.getType().equals(EntityType.WOLF)){
          Wolf wolf = (Wolf) en;
          if(!wolf.isSitting() && wolf.isTamed()){
            final AnimalTamer owner = wolf.getOwner();
            final OfflinePlayer p = Bukkit.getOfflinePlayer(owner.getUniqueId());
            if(p != null){
              if(p.hasPlayedBefore() && p.isOnline()){
                final Player player = p.getPlayer();
                final Location pLoc = player.getLocation();
                wolf.teleport(pLoc);
              }
            }
          }
        }
        else if(en.getType().equals(EntityType.CAT)){
          Cat cat = (Cat) en;
          if(!cat.isSitting() && cat.isTamed()){
            final AnimalTamer owner = cat.getOwner();
            final OfflinePlayer p = Bukkit.getOfflinePlayer(owner.getUniqueId());
            if(p != null){
              if(p.hasPlayedBefore() && p.isOnline()){
                final Player player = p.getPlayer();
                final Location pLoc = player.getLocation();
                cat.teleport(pLoc);
              }
            }
          }
        }
        else if(en.getType().equals(EntityType.PARROT)){
          Parrot parrot = (Parrot) en;
          if(!parrot.isSitting() && parrot.isTamed()){
            final AnimalTamer owner = parrot.getOwner();
            final OfflinePlayer p = Bukkit.getOfflinePlayer(owner.getUniqueId());
            if(p != null){
              if(p.hasPlayedBefore() && p.isOnline()){
                final Player player = p.getPlayer();
                final Location pLoc = player.getLocation();
                parrot.teleport(pLoc);
              }
            }
          }
        }
      }
    }
  }
}