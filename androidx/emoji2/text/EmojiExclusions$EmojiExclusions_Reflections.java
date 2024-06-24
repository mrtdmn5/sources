package androidx.emoji2.text;

import android.annotation.SuppressLint;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class EmojiExclusions$EmojiExclusions_Reflections {
    @SuppressLint({"BanUncheckedReflection"})
    public static Set<int[]> getExclusions() {
        try {
            Object invoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", new Class[0]).invoke(null, new Object[0]);
            if (invoke == null) {
                return Collections.emptySet();
            }
            Set<int[]> set = (Set) invoke;
            Iterator<int[]> it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.emptySet();
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.emptySet();
        }
    }
}
