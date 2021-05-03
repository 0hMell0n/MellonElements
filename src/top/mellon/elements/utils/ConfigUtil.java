package top.mellon.elements.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import top.mellon.elements.Main;

public final class ConfigUtil {
   private static Configuration config;

   public static void saveDefaultConfig() {
      try {
         if (!Main.getInstance().getDataFolder().exists()) {
            Main.getInstance().getDataFolder().mkdir();
         }

         File file = new File(Main.getInstance().getDataFolder(), "config.yml");
         if (!file.exists()) {
            Files.copy(Main.getInstance().getResourceAsStream("config.yml"), file.toPath(), new CopyOption[0]);
         }

         loadConfig();
      } catch (IOException var1) {
         var1.printStackTrace();
      }

   }

   public static void reloadConfig() {
      loadConfig();
   }

   public static void loadConfig() {
      try {
         config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(Main.getInstance().getDataFolder(), "config.yml"));
      } catch (IOException var1) {
         var1.printStackTrace();
      }

   }

   public static Configuration getConfig() {
      return config;
   }
}
