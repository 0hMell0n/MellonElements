package top.mellon.elements.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import top.mellon.elements.Main;
import top.mellon.elements.utils.MessageUtil;

public class IgnoreallCommand extends Command {
   public IgnoreallCommand() {
      super("ignoreall");
   }

   public void execute(CommandSender sender, String[] args) {
      if (!(sender instanceof ProxiedPlayer)) {
         sender.sendMessage(ChatColor.RED + "This command only for players!");
      } else {
         ProxiedPlayer player = (ProxiedPlayer)sender;
         if (MessageUtil.ignoreAll.contains(player.getName().toLowerCase())) {
            MessageUtil.ignoreAll.remove(player.getName().toLowerCase());
            player.sendMessage(Main.getInstance().getConfig().getString("Messages.IgnoreAll.UnIgnore").replace("&", "§"));
         } else {
            MessageUtil.ignoreAll.add(player.getName().toLowerCase());
            player.sendMessage(Main.getInstance().getConfig().getString("Messages.IgnoreAll.Ignore").replace("&", "§"));
         }

      }
   }
}
