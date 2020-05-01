package cn.yescallop.essentialsnk;

import cn.nukkit.plugin.PluginBase;
import cn.yescallop.essentialsnk.command.CommandManager;
import cn.yescallop.essentialsnk.task.TeleportationTask;

public class EssentialsNK extends PluginBase {

    private static EssentialsAPI api;

    @Override
    public void onEnable() {
        this.getDataFolder().mkdirs();
        Language.load(this.getServer().getLanguage().getLang());
        api = new EssentialsAPI(this);
        CommandManager.registerAll(api);
        this.getServer().getPluginManager().registerEvents(new EventListener(api), this);
        this.getLogger().info(Language.translate("essentialsnk.loaded"));
        this.getServer().getScheduler().scheduleRepeatingTask(this, new TeleportationTask(api), 1);
    }
    
    public static EssentialsAPI getAPI() {
        return api;
    }
}
