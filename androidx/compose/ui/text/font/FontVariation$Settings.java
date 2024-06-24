package androidx.compose.ui.text.font;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontVariation.kt */
/* loaded from: classes.dex */
public final class FontVariation$Settings {
    public final ArrayList settings;

    public FontVariation$Settings(FontVariation$Setting... fontVariation$SettingArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (FontVariation$Setting fontVariation$Setting : fontVariation$SettingArr) {
            String axisName = fontVariation$Setting.getAxisName();
            Object obj = linkedHashMap.get(axisName);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(axisName, obj);
            }
            ((List) obj).add(fontVariation$Setting);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.size() == 1) {
                CollectionsKt__ReversedViewsKt.addAll(list, arrayList);
            } else {
                throw new IllegalArgumentException(OpaqueKey$$ExternalSyntheticOutline0.m(ActivityResultRegistry$$ExternalSyntheticOutline0.m("'", str, "' must be unique. Actual [ ["), CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, null, 63), ']').toString());
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        this.settings = arrayList2;
        int size = arrayList2.size();
        for (int r2 = 0; r2 < size && !((FontVariation$Setting) arrayList2.get(r2)).getNeedsDensity(); r2++) {
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof FontVariation$Settings) && Intrinsics.areEqual(this.settings, ((FontVariation$Settings) obj).settings)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.settings.hashCode();
    }
}
