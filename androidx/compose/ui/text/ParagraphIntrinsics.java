package androidx.compose.ui.text;

/* compiled from: ParagraphIntrinsics.kt */
/* loaded from: classes.dex */
public interface ParagraphIntrinsics {
    default boolean getHasStaleResolvedFonts() {
        return false;
    }

    float getMaxIntrinsicWidth();

    float getMinIntrinsicWidth();
}
