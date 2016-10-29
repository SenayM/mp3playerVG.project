package com.mp3player.interfaces;

import java.io.File;

public interface PlayerInterface {
	public void play();
	public void pause();
	public void stop();
	public void next();
	public void previous();
	public void shuffle();
	public void repeat();
	public void addToPlaylist(File file);
	public void open();

}
