package com.animaconnected.secondo.notification.criteria;

import com.animaconnected.secondo.notification.DeviceNotification;
import com.animaconnected.secondo.screens.notification.magicword.KeyWord;
import com.animaconnected.secondo.screens.notification.magicword.MagicWordProvider;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes3.dex */
public class MagicWordCriteria extends Criteria {
    @Override // com.animaconnected.secondo.notification.criteria.Criteria
    public int valid(DeviceNotification deviceNotification) {
        List<KeyWord> allKeyWords = MagicWordProvider.getInstance().getAllKeyWords();
        Set<String> texts = deviceNotification.getTexts();
        boolean z = false;
        if (texts != null) {
            for (String str : texts) {
                Iterator<KeyWord> it = allKeyWords.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (str.contains(it.next().keyword.toLowerCase(Locale.getDefault()))) {
                        z = true;
                        break;
                    }
                }
            }
        }
        if (z) {
            return this.mAction;
        }
        return -1;
    }
}
