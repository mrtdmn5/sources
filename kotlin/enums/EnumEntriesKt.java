package kotlin.enums;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnumEntries.kt */
/* loaded from: classes.dex */
public final class EnumEntriesKt {
    public static final EnumEntriesList enumEntries(Enum[] entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new EnumEntriesList(entries);
    }
}
