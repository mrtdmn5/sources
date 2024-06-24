package androidx.compose.ui.text.input;

/* compiled from: OffsetMapping.kt */
/* loaded from: classes.dex */
public interface OffsetMapping {

    /* compiled from: OffsetMapping.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final OffsetMapping$Companion$Identity$1 Identity = new OffsetMapping$Companion$Identity$1();
    }

    int originalToTransformed(int r1);

    int transformedToOriginal(int r1);
}
