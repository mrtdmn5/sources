package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontFamilyResolver.kt */
/* loaded from: classes.dex */
public interface TypefaceResult extends State<Object> {

    /* compiled from: FontFamilyResolver.kt */
    /* loaded from: classes.dex */
    public static final class Async implements TypefaceResult, State<Object> {
        public final AsyncFontListLoader current;

        public Async(AsyncFontListLoader asyncFontListLoader) {
            this.current = asyncFontListLoader;
        }

        @Override // androidx.compose.ui.text.font.TypefaceResult
        public final boolean getCacheable() {
            return this.current.cacheable;
        }

        @Override // androidx.compose.runtime.State
        public final Object getValue() {
            return this.current.getValue();
        }
    }

    /* compiled from: FontFamilyResolver.kt */
    /* loaded from: classes.dex */
    public static final class Immutable implements TypefaceResult {
        public final boolean cacheable;
        public final Object value;

        public Immutable(Object value, boolean z) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
            this.cacheable = z;
        }

        @Override // androidx.compose.ui.text.font.TypefaceResult
        public final boolean getCacheable() {
            return this.cacheable;
        }

        @Override // androidx.compose.runtime.State
        public final Object getValue() {
            return this.value;
        }
    }

    boolean getCacheable();
}
