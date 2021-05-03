package top.mellon.elements.commands;

import java.io.File;
import java.io.IOException;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.YamlConfiguration;
import top.mellon.elements.utils.ConfigUtil;

public class ReloadCommand extends Command {
   public ReloadCommand() {
      super("bereload", (String)null, new String[]{"greload", "preload", "berl", "grl", "prl"});
   }

   public void execute(CommandSender sender, String[] args) {
      if (!sender.hasPermission("bungeel.reload")) {
         sender.sendMessage(ConfigUtil.getConfig().getString("Messages.NoPermissions").replace("&", "§"));
      } else {
         sender.sendMessage(ConfigUtil.getConfig().getString("Messages.Reload").replace("&", "§"));

         try {
            Configuration config = YamlConfiguration.getProvider(YamlConfiguration.class).load(new File("config.yml"));
            YamlConfiguration.getProvider(YamlConfiguration.class).save(config, new File("config.yml"));
         } catch (IOException var4) {
            var4.printStackTrace();
         }

         ConfigUtil.reloadConfig();
         ProxyServer.getInstance().getPluginManager().enablePlugins();
      }
   }
}
