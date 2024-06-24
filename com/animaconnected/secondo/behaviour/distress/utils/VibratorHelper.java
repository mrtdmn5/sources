package com.animaconnected.secondo.behaviour.distress.utils;

import android.os.Handler;
import android.os.Looper;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.behaviour.util.VibratorPatterns;

/* loaded from: classes3.dex */
public class VibratorHelper {
    private static final int MIN_TIME_BETWEEN_REQUEST_AND_ACKNOWLEDGE = 3000;
    private long mAcknowledgeTime;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private static final VibratorHelper sVibratorHelper = new VibratorHelper();
    private static final Runnable VIBRATOR_ACKNOWLEDGE_RUNNABLE = new VibratorHelper$$ExternalSyntheticLambda0();
    private static final Runnable VIBRATOR_ERROR_RUNNABLE = new VibratorHelper$$ExternalSyntheticLambda1();
    private static final Runnable VIBRATOR_ENTER_DISTRESS_RUNNABLE = new VibratorHelper$$ExternalSyntheticLambda2();

    private VibratorHelper() {
    }

    public static VibratorHelper getInstance() {
        return sVibratorHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0() {
        ProviderFactory.getWatch().startVibratorWithPattern(VibratorPatterns.getDistressAcknowledge());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$1() {
        ProviderFactory.getWatch().startVibratorWithPattern(VibratorPatterns.getErrorDistress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$2() {
        ProviderFactory.getWatch().startVibratorWithPattern(VibratorPatterns.getEnterDistress());
    }

    public void acknowledgeInvite() {
        this.mHandler.post(VIBRATOR_ACKNOWLEDGE_RUNNABLE);
    }

    public void acknowledgeReceived() {
        long currentTimeMillis = this.mAcknowledgeTime - System.currentTimeMillis();
        if (currentTimeMillis <= 0) {
            this.mHandler.post(VIBRATOR_ACKNOWLEDGE_RUNNABLE);
        } else {
            this.mHandler.postDelayed(VIBRATOR_ACKNOWLEDGE_RUNNABLE, currentTimeMillis);
        }
    }

    public void enterDistress() {
        this.mHandler.post(VIBRATOR_ENTER_DISTRESS_RUNNABLE);
    }

    public void error() {
        this.mHandler.post(VIBRATOR_ERROR_RUNNABLE);
    }

    public void requestSent() {
        this.mAcknowledgeTime = System.currentTimeMillis() + 3000;
        this.mHandler.post(VIBRATOR_ACKNOWLEDGE_RUNNABLE);
    }
}
