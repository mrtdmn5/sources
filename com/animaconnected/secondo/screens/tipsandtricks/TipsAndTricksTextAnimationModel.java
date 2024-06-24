package com.animaconnected.secondo.screens.tipsandtricks;

import com.animaconnected.secondo.provider.lottie.LottieFile;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TipsAndTricksTextAnimationModel.kt */
/* loaded from: classes3.dex */
public class TipsAndTricksTextAnimationModel extends TipsAndTricksModel {
    public static final int $stable = 0;
    private final int descriptionResourceIdAnimation1;
    private final int descriptionResourceIdAnimation2;
    private final float frameAnimationChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TipsAndTricksTextAnimationModel(String name, int r11, int r12, int r13, String str, LottieFile lottieFile, float f, int r17, int r18) {
        super(name, r11, r12, r13, null, str, lottieFile);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lottieFile, "lottieFile");
        this.frameAnimationChange = f;
        this.descriptionResourceIdAnimation1 = r17;
        this.descriptionResourceIdAnimation2 = r18;
    }

    public final int getDescriptionResourceIdAnimation1() {
        return this.descriptionResourceIdAnimation1;
    }

    public final int getDescriptionResourceIdAnimation2() {
        return this.descriptionResourceIdAnimation2;
    }

    public final float getFrameAnimationChange() {
        return this.frameAnimationChange;
    }
}
