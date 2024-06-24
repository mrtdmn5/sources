package com.animaconnected.secondo.utils;

import android.content.Context;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.animaconnected.secondo.screens.notification.NotificationInfo;
import com.animaconnected.watch.behaviour.Behaviour;
import java.text.Collator;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class AlphabeticSortingHelper {

    /* loaded from: classes3.dex */
    public static class BehaviourComparator implements Comparator<BehaviourPlugin<Behaviour>> {
        private final Collator mCollator = AlphabeticSortingHelper.access$000();
        private final Context mContext;

        public BehaviourComparator(Context context) {
            this.mContext = context;
        }

        @Override // java.util.Comparator
        public int compare(BehaviourPlugin<Behaviour> behaviourPlugin, BehaviourPlugin<Behaviour> behaviourPlugin2) {
            return this.mCollator.compare(this.mContext.getString(behaviourPlugin.getNameId()), this.mContext.getString(behaviourPlugin2.getNameId()));
        }
    }

    /* loaded from: classes3.dex */
    public static class ConfigurationItemComparator implements Comparator<ConfigurationItem> {
        private final Context mContext = KronabyApplication.getContext();
        private final Collator mCollator = AlphabeticSortingHelper.access$000();

        @Override // java.util.Comparator
        public int compare(ConfigurationItem configurationItem, ConfigurationItem configurationItem2) {
            NotificationInfo fromType = NotificationInfo.getFromType(configurationItem.getType());
            NotificationInfo fromType2 = NotificationInfo.getFromType(configurationItem2.getType());
            if (fromType == null || fromType2 == null) {
                return 0;
            }
            return this.mCollator.compare(this.mContext.getString(fromType.getName()), this.mContext.getString(fromType2.getName()));
        }
    }

    public static /* synthetic */ Collator access$000() {
        return getCollator();
    }

    public static Comparator<BehaviourPlugin<Behaviour>> createBehaviourComparator(Context context) {
        return new BehaviourComparator(context);
    }

    public static Comparator<ConfigurationItem> createConfigurationItemComparator() {
        return new ConfigurationItemComparator();
    }

    private static Collator getCollator() {
        Collator collator = Collator.getInstance(ProviderFactory.createConfigProvider().getTranslationCompatibleLocale());
        collator.setStrength(1);
        return collator;
    }
}
