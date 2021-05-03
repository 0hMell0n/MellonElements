package top.mellon.elements;

import java.util.Iterator;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import top.mellon.elements.commands.AlertCommand;
import top.mellon.elements.commands.FindCommand;
import top.mellon.elements.commands.HubCommand;
import top.mellon.elements.commands.IgnoreCommand;
import top.mellon.elements.commands.IgnoreallCommand;
import top.mellon.elements.commands.MessageCommand;
import top.mellon.elements.commands.OnlineCommand;
import top.mellon.elements.commands.PingCommand;
import top.mellon.elements.commands.ReloadCommand;
import top.mellon.elements.commands.SendCommand;
import top.mellon.elements.commands.ServerCommand;
import top.mellon.elements.commands.WhereCommand;
import top.mellon.elements.events.EventListener;
import top.mellon.elements.utils.ConfigUtil;

public class Main extends Plugin {
   private static Main instance;

   public Main() {
      instance = this;
   }

   public Configuration getConfig() {
      return ConfigUtil.getConfig();
   }

   public void onEnable() {
      ConfigUtil.saveDefaultConfig();
      boolean server = this.getConfig().getBoolean("Messages.Server.Allow");
      boolean find = this.getConfig().getBoolean("Messages.Find.Allow");
      boolean ping = this.getConfig().getBoolean("Messages.Ping.Allow");
      boolean ignore = this.getConfig().getBoolean("Messages.Ignore.Allow");
      boolean ignoreall = this.getConfig().getBoolean("Messages.IgnoreAll.Allow");
      boolean message = this.getConfig().getBoolean("Messages.Message.Allow");
      boolean where = this.getConfig().getBoolean("Messages.Where.Allow");
      boolean send = this.getConfig().getBoolean("Messages.Send.Allow");
      boolean online = this.getConfig().getBoolean("Messages.Online.Allow");
      boolean alert = this.getConfig().getBoolean("Messages.Alert.Allow");
      boolean hub = this.getConfig().getBoolean("Messages.Hub.Allow");
      if (alert) {
         this.getProxy().getPluginManager().registerCommand(this, new AlertCommand());
      }

      if (find) {
         this.getProxy().getPluginManager().registerCommand(this, new FindCommand());
      }

      if (ignoreall) {
         this.getProxy().getPluginManager().registerCommand(this, new IgnoreallCommand());
      }

      if (ignore) {
         this.getProxy().getPluginManager().registerCommand(this, new IgnoreCommand());
      }

      if (message) {
         this.getProxy().getPluginManager().registerCommand(this, new MessageCommand());
      }

      if (online) {
         this.getProxy().getPluginManager().registerCommand(this, new OnlineCommand());
      }

      if (send) {
         this.getProxy().getPluginManager().registerCommand(this, new SendCommand());
      }

      if (server) {
         this.getProxy().getPluginManager().registerCommand(this, new ServerCommand());
      }

      if (where) {
         this.getProxy().getPluginManager().registerCommand(this, new WhereCommand());
      }

      if (ping) {
         this.getProxy().getPluginManager().registerCommand(this, new PingCommand());
      }

      this.getProxy().getPluginManager().registerCommand(this, new ReloadCommand());
      if (hub) {
         Iterator var12 = ConfigUtil.getConfig().getStringList("HubAliases").iterator();

         while(var12.hasNext()) {
            String s = (String)var12.next();
            this.getProxy().getPluginManager().registerCommand(this, new HubCommand(s));
         }
      }

      this.getProxy().getPluginManager().registerListener(this, new EventListener());
   }

   public static Main getInstance() {
      return instance;
   }
}
