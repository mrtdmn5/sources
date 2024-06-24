package io.ktor.http.content;

import app.cash.sqldelight.ColumnAdapter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OutgoingContent.kt */
/* loaded from: classes3.dex */
public class NullBody implements ColumnAdapter {
    public static final NullBody INSTANCE$1 = new NullBody();
    public static final NullBody INSTANCE = new NullBody();

    public static final int findParagraphEnd(int r3, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        for (int r32 = r3 + 1; r32 < length; r32++) {
            if (charSequence.charAt(r32) == '\n') {
                return r32;
            }
        }
        return charSequence.length();
    }

    @Override // app.cash.sqldelight.ColumnAdapter
    public Object decode(Object obj) {
        return Integer.valueOf((int) ((Number) obj).longValue());
    }

    @Override // app.cash.sqldelight.ColumnAdapter
    public Object encode(Object obj) {
        return Long.valueOf(((Number) obj).intValue());
    }
}
