package mcpi;
import net.canarymod.plugin.Plugin;
import net.canarymod.logger.Logman;
import net.canarymod.Canary;
import net.canarymod.commandsys.*;
import net.canarymod.chat.MessageReceiver;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import net.canarymod.api.entity.living.humanoid.Player;

public class McPi extends Plugin implements CommandListener {

	public static Logman logger;

	public McPi() { 
		logger = getLogman();
	}

  	private void usage(Player me) {
    	me.chat("Usage: mcpi create <structure name>");
  	}

  	private void parseArgs(Player me, String [] args) {    
    	if (args.length < 3) {
      		usage(me);
      		return;
    	}
    	if (args[1].equalsIgnoreCase("create")) {
    	    try {
      		    buildStructure(me, args);
      	    } catch (Exception ex) {
   			ex.printStackTrace();
   		    }
    	}

  	}

  	private void buildStructure(Player me, String [] args)  throws IOException {

    	try {
			//String cmd = "ls -al";
			String cmd = "./McPi/mcpi.py " + args[1] + " " + args[2];

			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(cmd);
			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

			String line = "";
			while ((line=buf.readLine())!=null) {
				System.out.println(line);
			}
		} catch (Exception ex) {
   			ex.printStackTrace();
   		}
  	}



	@Override
		public boolean enable() { 
			logger.info("Starting up");   
			try {
				Canary.commands().registerCommands(this, this, false);
			} catch (CommandDependencyException e) {
				logger.error("Duplicate command name");
			}
			return true;
		}

	@Override
		public void disable() {
		}

	@Command(aliases = { "mcpi" },
			description = "Execute Python command",
			permissions = { "" },
			toolTip = "/mcpi")

		public void mcpiCommand(MessageReceiver caller, String[] args) {
    		if (caller instanceof Player) { 
      			Player me = (Player)caller; 
      			parseArgs(me, args);
    		}

			String msg = "Call McPi";
			Canary.instance().getServer().broadcastMessage(msg);
		}

}
