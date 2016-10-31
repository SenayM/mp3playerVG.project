package com.mp3player.otherclasses;
import jaco.mp3.player.*;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.mp3player.interfaces.PlayerInterface;



public class PlayerMethods implements PlayerInterface {
	
	
	MP3Player player=new MP3Player();
	public static String fileName="NoFile";
	public static ArrayList<String> fileList=new ArrayList<String>();
	public static int playerIndex=0;
	public static int displayIndex=0;
	
	public File file=new File("none");
	
	
	
	public static void setFileName(String fileName) {
		PlayerMethods.fileName = fileName;
	}
	public String getFileName(){
		return fileName;
	}
	public void updateDisplay(JLabel lblNowPlaying){
		lblNowPlaying.setText(getCurrentFile());
			}
	public void updateDisplayOnNextPrevious(JLabel lblNowPlaying){
		lblNowPlaying.setText(fileList.get(displayIndex));
			}
	@Override
	public void play() {
		if(file.getName()=="none")
			JOptionPane.showMessageDialog(null, "Please choose mp3 file first","Error Message",JOptionPane.ERROR_MESSAGE);
		else
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
		player.skipForward();
		
		displayIndex++;
		displayTester();
		/*while(displayIndex<playerIndex && displayIndex>=0){
			displayIndex++;
			//setFileName(fileList.get(displayIndex) );
		}*/
		
		
	}

	@Override
	public void previous() {
		player.skipBackward();
		
		displayIndex--;
		displayTester();
		/*while(displayIndex<playerIndex && displayIndex>=0){
			
			//setFileName(fileList.get(displayIndex) );
		}*/
		
		
		
	}
	public void displayTester(){
		System.out.println("playerIndex : "+playerIndex);
		System.out.println("dispayindex : "+displayIndex);
		System.out.println("getCurrentFile() : "+getCurrentFile());
		System.out.println("getFileName() : "+getFileName());
		
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
	public void addToPlaylist() {
		JFileChooser fileChooser=new JFileChooser();
		int returnval=fileChooser.showOpenDialog( null);
		if (returnval==JFileChooser.APPROVE_OPTION){
			this.file=fileChooser.getSelectedFile() ;
			//player.stop();
			//this.player=new MP3Player(file);
			player.addToPlayList(file);
			playerIndex++;	
			fileList.add(file.getName());
			displayTester();
					
		}
		
		
	}

	
	public static String getCurrentFile() {
		return fileList.get(playerIndex);
	}
	
	public void open() {
		JFileChooser fileChooser=new JFileChooser();
			int returnval=fileChooser.showOpenDialog( null);
			if (returnval==JFileChooser.APPROVE_OPTION){
				this.file=fileChooser.getSelectedFile() ;
				player.stop();
				this.player=new MP3Player(file);
				player.play();
				fileName=file.getName();
				fileList.clear();
				fileList.add(fileName);	
				displayTester();
			}
			
				
		
	}
	
	

}
