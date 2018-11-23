package com.Nebula.NebulaBot;

import java.io.*;
import java.util.List;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

public class AddChannel {
	public static void ChannelMethord(String idMessage, MessageChannel msgCh, String channelID, String guildID, List<TextChannel> allChannel) {
		boolean enteredIDTrue = false;
		boolean channelExist = false;
		
		try {
		idMessage = idMessage.split(" ")[1];
		}catch(Exception e) {
			enteredIDTrue = true;
		}
		
		for(int i = 0; i < allChannel.size(); i++) {
			if(idMessage.equals(allChannel.get(i).getId())) {
				channelExist = true;
			}
		}
		
		File checkFile = new File("\\Users\\fraser\\Documents\\A Documents\\Computer Science\\NebulaData\\" + guildID + ".txt");
		boolean exists = checkFile.exists();
		
		if(enteredIDTrue == true) {
			msgCh.sendMessage("Please enter a valid channel ID.").queue();
		}else if (channelExist == false) {
			msgCh.sendMessage("Please enter a valid channel ID.").queue();
		}else if(exists == true) {
			msgCh.sendMessage("You have already added a channel for the bot to update tweets too on this server.").queue();
		}else if(exists ==! true && enteredIDTrue ==! true && channelExist == true) {
			File file = new File("\\Users\\fraser\\Documents\\A Documents\\Computer Science\\NebulaData\\" + guildID + ".txt");
			try {
				file.createNewFile();
				PrintWriter pw = new PrintWriter(file);
				pw.print(idMessage);
				pw.close();
				msgCh.sendMessage("Channel " + idMessage + " has been added for the bot to send twitter updates too.").queue();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
