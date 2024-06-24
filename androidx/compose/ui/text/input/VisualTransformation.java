package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;

/* compiled from: VisualTransformation.kt */
/* loaded from: classes.dex */
public interface VisualTransformation {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: VisualTransformation.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
    }

    TransformedText filter(AnnotatedString annotatedString);
}
