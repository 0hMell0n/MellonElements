package top.mellon.elements.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Command;
import top.mellon.elements.Main;

public class OnlineCommand extends Command {
   public OnlineCommand() {
      super("online", (String)null, new String[]{"glist"});
   }

   public void execute(CommandSender sender, String[] args) {
      if (args.length == 1) {
         if (Main.getInstance().getProxy().getServerInfo(args[0]) == null) {
            sender.sendMessage(Main.getInstance().getConfig().getString("Messages.Server.NoExists").replace("&", "§"));
         } else {
            ServerInfo server = ProxyServer.getInstance().getServerInfo(args[0]);
            int online = ProxyServer.getInstance().getServerInfo(args[0]).getPlayers().size();
            sender.sendMessage(Main.getInstance().getConfig().getString("Messages.Online.Another").replace("&", "§").replace("{server}", server.getName()).replace("{online}", String.valueOf(online)));
         }
      } else {
         sender.sendMessage(Main.getInstance().getConfig().getString("Messages.Online.Online").replace("&", "§").replace("{online}", String.valueOf(ProxyServer.getInstance().getOnlineCount())));
      }

   }
}
