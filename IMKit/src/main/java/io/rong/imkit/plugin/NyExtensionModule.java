package io.rong.imkit.plugin;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.manager.InternalModuleManager;
import io.rong.imlib.model.Conversation;


public class NyExtensionModule extends DefaultExtensionModule {

    @Override
    public List<IPluginModule> getPluginModules(Conversation.ConversationType conversationType) {
        List<IPluginModule>  pluginModuleList = new ArrayList();
        ImagePlugin image = new CusEvaluatePlugin();
        EvaluatePlugin evaluatePlugin = new EvaluatePlugin();
        pluginModuleList.add(image);
//        pluginModuleList.add(evaluatePlugin);

        if(conversationType.equals(Conversation.ConversationType.GROUP) || conversationType.equals(Conversation.ConversationType.DISCUSSION) || conversationType.equals(Conversation.ConversationType.PRIVATE)) {
            pluginModuleList.addAll(InternalModuleManager.getInstance().getExternalPlugins(conversationType));
        }

        return pluginModuleList;
    }
}
