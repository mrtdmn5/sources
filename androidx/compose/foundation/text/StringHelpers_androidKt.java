package androidx.compose.foundation.text;

/* compiled from: StringHelpers.android.kt */
/* loaded from: classes.dex */
public final class StringHelpers_androidKt {
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:            if (r4 != false) goto L11;     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int findFollowingBreak(int r11, java.lang.String r12) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            boolean r0 = androidx.emoji2.text.EmojiCompat.isConfigured()
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L1e
            androidx.emoji2.text.EmojiCompat r0 = androidx.emoji2.text.EmojiCompat.get()
            int r4 = r0.getLoadState()
            if (r4 != r3) goto L1a
            r4 = r3
            goto L1b
        L1a:
            r4 = r2
        L1b:
            if (r4 == 0) goto L1e
            goto L1f
        L1e:
            r0 = r1
        L1f:
            if (r0 == 0) goto L93
            int r4 = r0.getLoadState()
            if (r4 != r3) goto L29
            r4 = r3
            goto L2a
        L29:
            r4 = r2
        L2a:
            if (r4 == 0) goto L8b
            androidx.emoji2.text.EmojiCompat$CompatInternal19 r0 = r0.mHelper
            androidx.emoji2.text.EmojiProcessor r4 = r0.mProcessor
            r4.getClass()
            r0 = -1
            if (r11 < 0) goto L7b
            int r5 = r12.length()
            if (r11 < r5) goto L3d
            goto L7b
        L3d:
            boolean r5 = r12 instanceof android.text.Spanned
            if (r5 == 0) goto L58
            r5 = r12
            android.text.Spanned r5 = (android.text.Spanned) r5
            int r6 = r11 + 1
            java.lang.Class<androidx.emoji2.text.EmojiSpan> r7 = androidx.emoji2.text.EmojiSpan.class
            java.lang.Object[] r6 = r5.getSpans(r11, r6, r7)
            androidx.emoji2.text.EmojiSpan[] r6 = (androidx.emoji2.text.EmojiSpan[]) r6
            int r7 = r6.length
            if (r7 <= 0) goto L58
            r4 = r6[r2]
            int r4 = r5.getSpanEnd(r4)
            goto L7c
        L58:
            int r5 = r11 + (-16)
            int r6 = java.lang.Math.max(r2, r5)
            int r5 = r12.length()
            int r7 = r11 + 16
            int r7 = java.lang.Math.min(r5, r7)
            r8 = 2147483647(0x7fffffff, float:NaN)
            r9 = 1
            androidx.emoji2.text.EmojiProcessor$EmojiProcessLookupCallback r10 = new androidx.emoji2.text.EmojiProcessor$EmojiProcessLookupCallback
            r10.<init>(r11)
            r5 = r12
            java.lang.Object r4 = r4.process(r5, r6, r7, r8, r9, r10)
            androidx.emoji2.text.EmojiProcessor$EmojiProcessLookupCallback r4 = (androidx.emoji2.text.EmojiProcessor.EmojiProcessLookupCallback) r4
            int r4 = r4.end
            goto L7c
        L7b:
            r4 = r0
        L7c:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r5 = r4.intValue()
            if (r5 != r0) goto L87
            r2 = r3
        L87:
            if (r2 != 0) goto L93
            r1 = r4
            goto L93
        L8b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Not initialized yet"
            r11.<init>(r12)
            throw r11
        L93:
            if (r1 == 0) goto L9a
            int r11 = r1.intValue()
            return r11
        L9a:
            java.text.BreakIterator r0 = java.text.BreakIterator.getCharacterInstance()
            r0.setText(r12)
            int r11 = r0.following(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.StringHelpers_androidKt.findFollowingBreak(int, java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:            if (r4 != false) goto L11;     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int findPrecedingBreak(int r12, java.lang.String r13) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            boolean r0 = androidx.emoji2.text.EmojiCompat.isConfigured()
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L1e
            androidx.emoji2.text.EmojiCompat r0 = androidx.emoji2.text.EmojiCompat.get()
            int r4 = r0.getLoadState()
            if (r4 != r3) goto L1a
            r4 = r3
            goto L1b
        L1a:
            r4 = r2
        L1b:
            if (r4 == 0) goto L1e
            goto L1f
        L1e:
            r0 = r1
        L1f:
            if (r0 == 0) goto L99
            int r4 = r12 + (-1)
            int r4 = java.lang.Math.max(r2, r4)
            int r5 = r0.getLoadState()
            if (r5 != r3) goto L2f
            r5 = r3
            goto L30
        L2f:
            r5 = r2
        L30:
            if (r5 == 0) goto L91
            androidx.emoji2.text.EmojiCompat$CompatInternal19 r0 = r0.mHelper
            androidx.emoji2.text.EmojiProcessor r5 = r0.mProcessor
            r5.getClass()
            r0 = -1
            if (r4 < 0) goto L81
            int r6 = r13.length()
            if (r4 < r6) goto L43
            goto L81
        L43:
            boolean r6 = r13 instanceof android.text.Spanned
            if (r6 == 0) goto L5e
            r6 = r13
            android.text.Spanned r6 = (android.text.Spanned) r6
            int r7 = r4 + 1
            java.lang.Class<androidx.emoji2.text.EmojiSpan> r8 = androidx.emoji2.text.EmojiSpan.class
            java.lang.Object[] r7 = r6.getSpans(r4, r7, r8)
            androidx.emoji2.text.EmojiSpan[] r7 = (androidx.emoji2.text.EmojiSpan[]) r7
            int r8 = r7.length
            if (r8 <= 0) goto L5e
            r4 = r7[r2]
            int r4 = r6.getSpanStart(r4)
            goto L82
        L5e:
            int r6 = r4 + (-16)
            int r7 = java.lang.Math.max(r2, r6)
            int r6 = r13.length()
            int r8 = r4 + 16
            int r8 = java.lang.Math.min(r6, r8)
            r9 = 2147483647(0x7fffffff, float:NaN)
            r10 = 1
            androidx.emoji2.text.EmojiProcessor$EmojiProcessLookupCallback r11 = new androidx.emoji2.text.EmojiProcessor$EmojiProcessLookupCallback
            r11.<init>(r4)
            r6 = r13
            java.lang.Object r4 = r5.process(r6, r7, r8, r9, r10, r11)
            androidx.emoji2.text.EmojiProcessor$EmojiProcessLookupCallback r4 = (androidx.emoji2.text.EmojiProcessor.EmojiProcessLookupCallback) r4
            int r4 = r4.start
            goto L82
        L81:
            r4 = r0
        L82:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r5 = r4.intValue()
            if (r5 != r0) goto L8d
            r2 = r3
        L8d:
            if (r2 != 0) goto L99
            r1 = r4
            goto L99
        L91:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "Not initialized yet"
            r12.<init>(r13)
            throw r12
        L99:
            if (r1 == 0) goto La0
            int r12 = r1.intValue()
            return r12
        La0:
            java.text.BreakIterator r0 = java.text.BreakIterator.getCharacterInstance()
            r0.setText(r13)
            int r12 = r0.preceding(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.StringHelpers_androidKt.findPrecedingBreak(int, java.lang.String):int");
    }
}
