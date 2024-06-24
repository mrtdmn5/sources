package com.animaconnected.widget.theme;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: ComposeThemeProviders.kt */
/* loaded from: classes3.dex */
public final class ThemePreviewParameterProvider implements PreviewParameterProvider<ComposeThemeProvider> {
    public static final int $stable = 8;
    private final Sequence<ComposeThemeProvider> values = SequencesKt__SequencesKt.sequenceOf(JaguarComposeThemeProvider.INSTANCE, LotusComposeThemeProvider.INSTANCE, FestinaComposeThemeProvider.INSTANCE, KronabyComposeLightThemeProvider.INSTANCE, KronabyComposeDarkThemeProvider.INSTANCE);
    private final int count = SequencesKt___SequencesKt.count(getValues());

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public int getCount() {
        return this.count;
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public Sequence<ComposeThemeProvider> getValues() {
        return this.values;
    }
}
