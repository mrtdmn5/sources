package com.animaconnected.secondo.provider.status;

import com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider;
import com.animaconnected.secondo.screens.status.dfu.DfuRequiredFragment;

/* compiled from: StatusModel.kt */
/* loaded from: classes3.dex */
public final class DfuRequiredStatus extends StatusModel {
    public static final int $stable = 0;
    public static final DfuRequiredStatus INSTANCE = new DfuRequiredStatus();

    private DfuRequiredStatus() {
        super(STSAssumeRoleSessionCredentialsProvider.DEFAULT_DURATION_SECONDS, DfuRequiredFragment.class, null);
    }
}
