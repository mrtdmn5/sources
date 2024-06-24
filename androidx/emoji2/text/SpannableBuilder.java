package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class SpannableBuilder extends SpannableStringBuilder {
    public final Class<?> mWatcherClass;
    public final ArrayList mWatchers;

    /* loaded from: classes.dex */
    public static class WatcherWrapper implements TextWatcher, SpanWatcher {
        public final AtomicInteger mBlockCalls = new AtomicInteger(0);
        public final Object mObject;

        public WatcherWrapper(Object obj) {
            this.mObject = obj;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            ((TextWatcher) this.mObject).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int r3, int r4, int r5) {
            ((TextWatcher) this.mObject).beforeTextChanged(charSequence, r3, r4, r5);
        }

        @Override // android.text.SpanWatcher
        public final void onSpanAdded(Spannable spannable, Object obj, int r4, int r5) {
            if (this.mBlockCalls.get() > 0 && (obj instanceof EmojiSpan)) {
                return;
            }
            ((SpanWatcher) this.mObject).onSpanAdded(spannable, obj, r4, r5);
        }

        @Override // android.text.SpanWatcher
        public final void onSpanChanged(Spannable spannable, Object obj, int r11, int r12, int r13, int r14) {
            int r4;
            int r6;
            if (this.mBlockCalls.get() > 0 && (obj instanceof EmojiSpan)) {
                return;
            }
            if (Build.VERSION.SDK_INT < 28) {
                if (r11 > r12) {
                    r11 = 0;
                }
                if (r13 > r14) {
                    r4 = r11;
                    r6 = 0;
                    ((SpanWatcher) this.mObject).onSpanChanged(spannable, obj, r4, r12, r6, r14);
                }
            }
            r4 = r11;
            r6 = r13;
            ((SpanWatcher) this.mObject).onSpanChanged(spannable, obj, r4, r12, r6, r14);
        }

        @Override // android.text.SpanWatcher
        public final void onSpanRemoved(Spannable spannable, Object obj, int r4, int r5) {
            if (this.mBlockCalls.get() > 0 && (obj instanceof EmojiSpan)) {
                return;
            }
            ((SpanWatcher) this.mObject).onSpanRemoved(spannable, obj, r4, r5);
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int r3, int r4, int r5) {
            ((TextWatcher) this.mObject).onTextChanged(charSequence, r3, r4, r5);
        }
    }

    public SpannableBuilder(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        this.mWatchers = new ArrayList();
        if (cls != null) {
            this.mWatcherClass = cls;
            return;
        }
        throw new NullPointerException("watcherClass cannot be null");
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void blockWatchers() {
        int r0 = 0;
        while (true) {
            ArrayList arrayList = this.mWatchers;
            if (r0 < arrayList.size()) {
                ((WatcherWrapper) arrayList.get(r0)).mBlockCalls.incrementAndGet();
                r0++;
            } else {
                return;
            }
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final Editable delete(int r1, int r2) {
        super.delete(r1, r2);
        return this;
    }

    public final void endBatchEdit() {
        unblockwatchers();
        int r1 = 0;
        while (true) {
            ArrayList arrayList = this.mWatchers;
            if (r1 < arrayList.size()) {
                ((WatcherWrapper) arrayList.get(r1)).onTextChanged(this, 0, length(), length());
                r1++;
            } else {
                return;
            }
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        WatcherWrapper watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        WatcherWrapper watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        WatcherWrapper watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanStart(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    @SuppressLint({"UnknownNullness"})
    public final <T> T[] getSpans(int r3, int r4, Class<T> cls) {
        boolean z;
        if (this.mWatcherClass == cls) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            WatcherWrapper[] watcherWrapperArr = (WatcherWrapper[]) super.getSpans(r3, r4, WatcherWrapper.class);
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, watcherWrapperArr.length));
            for (int r1 = 0; r1 < watcherWrapperArr.length; r1++) {
                tArr[r1] = watcherWrapperArr[r1].mObject;
            }
            return tArr;
        }
        return (T[]) super.getSpans(r3, r4, cls);
    }

    public final WatcherWrapper getWatcherFor(Object obj) {
        int r0 = 0;
        while (true) {
            ArrayList arrayList = this.mWatchers;
            if (r0 < arrayList.size()) {
                WatcherWrapper watcherWrapper = (WatcherWrapper) arrayList.get(r0);
                if (watcherWrapper.mObject == obj) {
                    return watcherWrapper;
                }
                r0++;
            } else {
                return null;
            }
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final Editable insert(int r1, CharSequence charSequence) {
        super.insert(r1, charSequence);
        return this;
    }

    public final boolean isWatcher(Object obj) {
        boolean z;
        if (obj == null) {
            return false;
        }
        if (this.mWatcherClass == obj.getClass()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:            if (r0 != false) goto L8;     */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int nextSpanTransition(int r2, int r3, java.lang.Class r4) {
        /*
            r1 = this;
            if (r4 == 0) goto Lb
            java.lang.Class<?> r0 = r1.mWatcherClass
            if (r0 != r4) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            if (r0 == 0) goto Ld
        Lb:
            java.lang.Class<androidx.emoji2.text.SpannableBuilder$WatcherWrapper> r4 = androidx.emoji2.text.SpannableBuilder.WatcherWrapper.class
        Ld:
            int r2 = super.nextSpanTransition(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.SpannableBuilder.nextSpanTransition(int, int, java.lang.Class):int");
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        WatcherWrapper watcherWrapper;
        if (isWatcher(obj)) {
            watcherWrapper = getWatcherFor(obj);
            if (watcherWrapper != null) {
                obj = watcherWrapper;
            }
        } else {
            watcherWrapper = null;
        }
        super.removeSpan(obj);
        if (watcherWrapper != null) {
            this.mWatchers.remove(watcherWrapper);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final /* bridge */ /* synthetic */ Editable replace(int r1, int r2, CharSequence charSequence) {
        replace(r1, r2, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int r3, int r4, int r5) {
        if (isWatcher(obj)) {
            WatcherWrapper watcherWrapper = new WatcherWrapper(obj);
            this.mWatchers.add(watcherWrapper);
            obj = watcherWrapper;
        }
        super.setSpan(obj, r3, r4, r5);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    @SuppressLint({"UnknownNullness"})
    public final CharSequence subSequence(int r3, int r4) {
        return new SpannableBuilder(this.mWatcherClass, this, r3, r4);
    }

    public final void unblockwatchers() {
        int r0 = 0;
        while (true) {
            ArrayList arrayList = this.mWatchers;
            if (r0 < arrayList.size()) {
                ((WatcherWrapper) arrayList.get(r0)).mBlockCalls.decrementAndGet();
                r0++;
            } else {
                return;
            }
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder delete(int r1, int r2) {
        super.delete(r1, r2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder insert(int r1, CharSequence charSequence) {
        super.insert(r1, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final /* bridge */ /* synthetic */ Editable replace(int r1, int r2, CharSequence charSequence, int r4, int r5) {
        replace(r1, r2, charSequence, r4, r5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) throws IOException {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final Editable insert(int r1, CharSequence charSequence, int r3, int r4) {
        super.insert(r1, charSequence, r3, r4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder replace(int r1, int r2, CharSequence charSequence) {
        blockWatchers();
        super.replace(r1, r2, charSequence);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c) {
        super.append(c);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder insert(int r1, CharSequence charSequence, int r3, int r4) {
        super.insert(r1, charSequence, r3, r4);
        return this;
    }

    public SpannableBuilder(Class<?> cls, CharSequence charSequence, int r3, int r4) {
        super(charSequence, r3, r4);
        this.mWatchers = new ArrayList();
        if (cls != null) {
            this.mWatcherClass = cls;
            return;
        }
        throw new NullPointerException("watcherClass cannot be null");
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c) {
        super.append(c);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c) throws IOException {
        super.append(c);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder replace(int r1, int r2, CharSequence charSequence, int r4, int r5) {
        blockWatchers();
        super.replace(r1, r2, charSequence, r4, r5);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int r2, int r3) {
        super.append(charSequence, r2, r3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int r2, int r3) {
        super.append(charSequence, r2, r3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int r2, int r3) throws IOException {
        super.append(charSequence, r2, r3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int r3) {
        super.append(charSequence, obj, r3);
        return this;
    }
}
