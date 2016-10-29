package com.mp3player.otherclasses;
import jaco.mp3.player.*;

import java.io.File;

import javax.swing.JFileChooser;
import com.mp3player.interfaces.PlayerInterface;



public class PlayerMethods implements PlayerInterface {
	
	MP3Player player=new MP3Player();
	
	public File file=new File("none");
	
	@Override
	public void play() {
		/*if(player.getName()==null)
			JOptionPane.showMessageDialog(null, "Please choose mp3 file first","Error Message",JOptionPane.ERROR_MESSAGE);
		else*/
		player.play();
	
	}

	@Override
	public void pause() {
		player.pause();
		
	}

	@Override
	public void stop() {
		player.stop();
		
	}

	@Override
	public void next() {
		System.out.println(player.getName());
		player.skipForward();
		
		
	}

	@Override
	public void previous() {
		player.skipBackward();
		
	}

	@Override
	public void shuffle() {
		player.setShuffle(true);
		
	}

	@Override
	public void repeat() {
		player.setRepeat(true);
		
	}

	@Override
	public void addToPlaylist(File file) {
		player.addToPlayList(file);
		
	}

	@Override
	public void open() {
		JFileChooser fileChooser=new JFileChooser();
			int returnval=fileChooser.showOpenDialog( null);
			if (returnval==JFileChooser.APPROVE_OPTION){
				this.file=fileChooser.getSelectedFile() ;
				player.stop();
				this.player=new MP3Player(file);
				player.play();
				
			}
			
				
		
	}

	

}
