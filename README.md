Canary Mod + Minecraft Python + Notification
============================================
  
  
1) Install Inotify  
  
[~] ➔ sudo apt-get install inotify-tools  
  
  
2) Run inotify :  
  
Serveur.1710/notifyMcPi.sh  

Copy the shell script to :
~/JEUX/MINECRAFT.notif/Serveur.1710/  
  
 
3) Temporary command file
  
Serveur.1710/mcpi.txt  
  
Copy the text file to :  
~/JEUX/MINECRAFT.notif/Serveur.1710/
  
  
4) Python script
  
Serveur.1710/parseMcPi.py  
   
Copit the Python script to :  
mcpi.txt  notifyMcpi.sh  parseMcPi.py  
  
  
5) Script to build a structure :  
  
Serveur.1710/McPi/pillar.py

Copy the script to :  
 
~/JEUX/MINECRAFT.notif/Serveur.1710/McPi/
  
  
6) Build the Canary Mod plugin :  
  
CanaryMod/McPi/build.sh  
  
  
7) Canary Mod plugin : 
 
/CanaryMod/McPi/dist/McPi.jar  

Copy the mod to :
~/JEUX/MINECRAFT.notif/Serveur.1710/plugins/
  
  
8) In the Minecraft client, call the plugin :

/mcpi create pillar
