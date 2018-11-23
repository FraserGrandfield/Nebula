package com.Nebula.NebulaBot;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class App extends ListenerAdapter{
    public static void main( String[] args ) throws Exception{
        JDA jda = new JDABuilder(AccountType.BOT).setToken(Ref.token).buildBlocking();
        jda.addEventListener(new App());
        
    }
    
    @Override
    public void onMessageReceived(MessageReceivedEvent evt) {
    	User objUser = evt.getAuthor();
    	String objUserID = evt.getAuthor().getId();
    	MessageChannel objMsgCh = evt.getChannel();
    	String objMsgChID = evt.getChannel().getId();
    	Message objMsg = evt.getMessage();
    	String guildID = evt.getGuild().getId();
    	if (!objUserID.equals("461887312607969310")){
	    	if ((objMsg.getContentRaw().toLowerCase().startsWith(Ref.prefix + "channel"))){
	    		
		    	List<TextChannel> allChannels = new ArrayList<TextChannel>(evt.getGuild().getTextChannels());
		    	String channel = allChannels.get(0).getId();
		    	
	    		AddChannel.ChannelMethord(objMsg.getContentRaw().toLowerCase(), objMsgCh, objMsgChID, guildID, allChannels);
	    	}
	    	switch(objMsg.getContentRaw().toLowerCase()){
	    		case Ref.prefix+"beep":
	    			objMsgCh.sendMessage(objUser.getAsMention() + " Boop?").queue();
	    			break;
	    	}
    	}
    }
}
