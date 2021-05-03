package top.mellon.elements.commands;

import java.util.Iterator;
import net.md_5.bungee.BungeeTitle;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import top.mellon.elements.Main;

public class AlertCommand extends Command {
   public AlertCommand() {
      super("alert", (String)null, new String[]{"bc", "broadcast"});
   }

   public void execute(CommandSender sender, String[] args) {
      if (!sender.hasPermission("bungeeel.alert")) {
         sender.sendMessage(Main.getInstance().getConfig().getString("Messages.NoPermissions").replace("&", "§"));
      } else {
         if (args.length == 0) {
            sender.sendMessage(Main.getInstance().getConfig().getString("Messages.Alert.Usage").replace("&", "§"));
         } else {
            StringBuilder msg = new StringBuilder();
            String[] var4 = args;
            int var5 = args.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               String arg = var4[var6];
               msg.append(arg + " ");
            }

            Iterator var8 = Main.getInstance().getProxy().getPlayers().iterator();

            while(var8.hasNext()) {
               ProxiedPlayer players = (ProxiedPlayer)var8.next();
               players.sendTitle((new BungeeTitle()).title(new TextComponent(Main.getInstance().getConfig().getString("Messages.Alert.Title.header").replace("&", "§").replace("{message}", msg.toString().replace("&", "§")))).subTitle(new TextComponent(Main.getInstance().getConfig().getString("Messages.Alert.Title.footer").replace("&", "§").replace("{message}", msg.toString().replace("&", "§")))));
               players.sendMessage(Main.getInstance().getConfig().getString("Messages.Alert.Chat").replace("&", "§").replace("{message}", msg.toString().replace("&", "§")));
            }
         }

      }
   }
}
