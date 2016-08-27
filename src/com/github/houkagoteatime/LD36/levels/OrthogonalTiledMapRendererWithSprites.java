package com.github.houkagoteatime.LD36.levels;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.github.houkagoteatime.LD36.entities.Entity;
import com.github.houkagoteatime.LD36.entities.Player;
import com.github.houkagoteatime.LD36.entities.enemies.Enemy;
import com.github.houkagoteatime.LD36.weapons.Projectile;

public class OrthogonalTiledMapRendererWithSprites extends OrthogonalTiledMapRenderer {
    private List<Entity> entitys;
    private int drawSpritesAfterLayer = 1;
    private Level level;

    public OrthogonalTiledMapRendererWithSprites(TiledMap map, Level level) {
        super(map);
        this.level = level;
        entitys = new ArrayList<Entity>();
    }

    @Override
    public void render() {
        beginRender();
        int currentLayer = 0;
        for (MapLayer layer : map.getLayers()) {
            if (layer.isVisible()) {
                if (layer instanceof TiledMapTileLayer) {
                    renderTileLayer((TiledMapTileLayer)layer);
                    currentLayer++;
                    if(currentLayer == drawSpritesAfterLayer){
                    	//draw player
						this.getBatch().draw(level.getPlayer().getSprite(), level.getPlayer().getPosition().x, level.getPlayer().getPosition().y, level.getPlayer().getSprite().getOriginX(), level.getPlayer().getSprite().getOriginY(), Player.HEIGHT, Player.WIDTH, 1f, 1f, level.getPlayer().getSprite().getRotation());

                    	//draw enemies
                        for(Enemy enemy: level.getEnemies()) {
                        	this.getBatch().draw(enemy.getSprite(), enemy.getPosition().x, enemy.getPosition().y);
                        }
                        //draw projectiles
						for(Projectile p : level.getProjectiles()) {
							this.getBatch().draw(p.getSprite(), p.getxPosition(), p.getyPosition());
						}
                    }
                } else {
                    for (MapObject object : layer.getObjects()) {
                        renderObject(object);
                    }
                }
            }
        }
        endRender();
    }

}
