package com.animaconnected.secondo.screens.tipsandtricks;

import com.animaconnected.secondo.provider.lottie.LottieFile;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TipsAndTricksModel.kt */
/* loaded from: classes3.dex */
public class TipsAndTricksModel {
    public static final int $stable = 0;
    private final int descriptionResourceIdLong;
    private final Integer descriptionResourceIdShort;
    private final LottieFile lottieFile;
    private final String name;
    private final int priority;
    private final int titleResourceId;
    private final String url;

    public TipsAndTricksModel(String name, int r3, int r4, int r5, Integer num, String str, LottieFile lottieFile) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lottieFile, "lottieFile");
        this.name = name;
        this.priority = r3;
        this.titleResourceId = r4;
        this.descriptionResourceIdLong = r5;
        this.descriptionResourceIdShort = num;
        this.url = str;
        this.lottieFile = lottieFile;
    }

    public final int getDescriptionResourceIdLong() {
        return this.descriptionResourceIdLong;
    }

    public final Integer getDescriptionResourceIdShort() {
        return this.descriptionResourceIdShort;
    }

    public final LottieFile getLottieFile() {
        return this.lottieFile;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getTitleResourceId() {
        return this.titleResourceId;
    }

    public final String getUrl() {
        return this.url;
    }

    public boolean isCompatibleToBeShown() {
        return true;
    }
}
