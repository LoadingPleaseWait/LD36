package com.github.houkagoteatime.LD36;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;

public class Assets {
	
	public static AssetManager manager = new AssetManager();
	public static void load() {
		manager.load("assets/music/Ho-kago Tea Time - U&I.mp3", Music.class);
		manager.load("assets/music/Yume Miru Kusuri - Girls Are Made of Frosting Cake.mp3", Music.class);
	}
	
	

}
