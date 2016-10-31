package com.mp3player.otherclasses;
import jaco.mp3.player.*;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.mp3player.interfaces.PlayerInterface;



public class PlayerMethods implements PlayerInterface {
	
	//Creation of player object
	MP3Player player=new MP3Player();
	//Static string fileName to control to control if the user clickes play befor opening file 
	public static String fileName="NoFile";
	public File file=new File("none");
	//ArrayList fielList is responsible for adding items to Playlist display
	public static ArrayList<String> fileList=new ArrayList<String>();
	//Static variables playerIndex and displayIndex control our navigation through playlist, 
	//playerIndex is internal for the player, display index is for the user interface display
	public static int playerIndex=0;
	public static int displayIndex=0;
	/**
	setter method to the string filename
	**/
	public static void setFileName(String fileName) {
		PlayerMethods.fileName = fileName;
	}
	/**
	getter method to the Stirng fileName
	**/
	public String getFileName(){
		return fileName;
	}
	/**
	 * updatedisplay while we open file
	 * @param lblNowPlaying
	 */
	public void updateDisplay(JLabel lblNowPlaying){
		lblNowPlaying.setText(getCurrentFile());
			}
	/**
	 * updatedisplay while we navigate through playlist
	 * @param lblNowPlaying
	 */
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
		//displayTester();
		/*while(displayIndex<playerIndex && displayIndex>=0){
			displayIndex++;
			//setFileName(fileList.get(displayIndex) );
		}*/
		
		
	}

	@Override
	public void previous() {
		player.skipBackward();
		
		displayIndex--;
		//displayTester();
		/*while(displayIndex<playerIndex && displayIndex>=0){
			
			//setFileName(fileList.get(displayIndex) );
		}*/
		
		
		
	}
	/**Temporary method to test the value of the variables while debuging
	 * 
	 */
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
			//displayTester();
					
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
				//displayTester();
			}
			
				
		
	}
	
	

}
