package kotlinx.serialization.json.internal;

import kotlin.collections.ArrayDeque;

/* compiled from: ArrayPools.kt */
/* loaded from: classes4.dex */
public class ByteArrayPoolBase {
    public final ArrayDeque<byte[]> arrays = new ArrayDeque<>();
}
