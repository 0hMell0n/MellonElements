package top.mellon.elements.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import top.mellon.elements.Main;
import top.mellon.elements.utils.MessageUtil;

public class IgnoreCommand extends Command {
   public IgnoreCommand() {
      super("ignore", (String)null, new String[0]);
   }

   public void execute(CommandSender sender, String[] args) {
      if (!(sender instanceof ProxiedPlayer)) {
         sender.sendMessage(ChatColor.RED + "This command only for players!");
      } else {
         ProxiedPlayer player = (ProxiedPlayer)sender;
         if (args.length != 1) {
            player.sendMessage(Main.getInstance().getConfig().getString("Messages.Ignore.Usage").replace("&", "§"));
         } else {
            MessageUtil.ignore(player.getName(), args[0]);
         }

      }
   }
}
