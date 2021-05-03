package top.mellon.elements.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import top.mellon.elements.Main;

public class WhereCommand extends Command {
   public WhereCommand() {
      super("where", (String)null, new String[]{"whe"});
   }

   public void execute(CommandSender sender, String[] args) {
      if (!(sender instanceof ProxiedPlayer)) {
         sender.sendMessage(ChatColor.RED + "This command only for players!");
      } else {
         if (!sender.hasPermission("bungeeel.where")) {
            sender.sendMessage(Main.getInstance().getConfig().getString("Messages.NoPermissions").replace("&", "§"));
            return;
         }

         sender.sendMessage(Main.getInstance().getConfig().getString("Messages.Where.Where").replace("&", "§").replace("{server}", ((ProxiedPlayer)sender).getServer().getInfo().getName()));
      }

   }
}
