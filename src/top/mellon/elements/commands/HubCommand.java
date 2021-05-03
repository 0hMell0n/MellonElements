package top.mellon.elements.commands;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import top.mellon.elements.Main;
import top.mellon.elements.utils.ConfigUtil;
import top.mellon.elements.utils.ServerUtil;

public class HubCommand extends Command {
   public HubCommand(String name) {
      super("hub", (String)null, new String[]{name});
   }

   public void execute(CommandSender sender, String[] args) {
      if (!(sender instanceof ProxiedPlayer)) {
         sender.sendMessage(ChatColor.RED + "This command only for players!");
      } else {
         List<String> hubs = ConfigUtil.getConfig().getStringList("Hubs");
         boolean b = false;
         Iterator var5 = hubs.iterator();

         while(var5.hasNext()) {
            String hub = (String)var5.next();
            if (ServerUtil.getServer(hub) == null) {
               b = true;
               return;
            }
         }

         if (b) {
            sender.sendMessage(Main.getInstance().getConfig().getString("Messages.Hub.NeDostupnoNiOdnogo").replace("&", "§"));
            return;
         }

         if (hubs.contains(((ProxiedPlayer)sender).getServer().getInfo().getName())) {
            sender.sendMessage(Main.getInstance().getConfig().getString("Messages.Hub.Already").replace("&", "§"));
            return;
         }

         String hub = (String)hubs.get((new Random()).nextInt(hubs.size()));
         ((ProxiedPlayer)sender).connect(ServerUtil.getServer(hub));
      }

   }
}
