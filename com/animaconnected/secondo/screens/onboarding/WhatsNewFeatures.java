package com.animaconnected.secondo.screens.onboarding;

import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: WhatsNewStorage.kt */
/* loaded from: classes3.dex */
final class WhatsNewFeatures {
    public static final WhatsNewFeatures INSTANCE = new WhatsNewFeatures();
    private static final List<WhatsNewInfo> latestFeatures = EmptyList.INSTANCE;
    public static final int version = 0;

    private WhatsNewFeatures() {
    }

    public final List<WhatsNewInfo> getLatestFeatures() {
        return latestFeatures;
    }
}
