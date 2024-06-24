package kotlinx.serialization.json.internal;

import kotlin.collections.ArrayDeque;

/* compiled from: ArrayPools.kt */
/* loaded from: classes4.dex */
public class CharArrayPoolBase {
    public final ArrayDeque<char[]> arrays = new ArrayDeque<>();
    public int charsTotal;
}
