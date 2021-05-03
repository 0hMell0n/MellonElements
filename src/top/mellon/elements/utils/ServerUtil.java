package top.mellon.elements.utils;

import net.md_5.bungee.api.config.ServerInfo;
import top.mellon.elements.Main;

public final class ServerUtil {
   public static ServerInfo getServer(String server) {
      return Main.getInstance().getProxy().getServerInfo(server);
   }
}
