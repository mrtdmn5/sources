package com.animaconnected.secondo.screens.onboarding;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OnboardingPermission.kt */
/* loaded from: classes3.dex */
public abstract class PermissionState {
    public static final int $stable = 0;

    /* compiled from: OnboardingPermission.kt */
    /* loaded from: classes3.dex */
    public static final class Denied extends PermissionState {
        public static final int $stable = 0;
        public static final Denied INSTANCE = new Denied();

        private Denied() {
            super(null);
        }
    }

    /* compiled from: OnboardingPermission.kt */
    /* loaded from: classes3.dex */
    public static final class Granted extends PermissionState {
        public static final int $stable = 0;
        public static final Granted INSTANCE = new Granted();

        private Granted() {
            super(null);
        }
    }

    /* compiled from: OnboardingPermission.kt */
    /* loaded from: classes3.dex */
    public static final class Idle extends PermissionState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    public /* synthetic */ PermissionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PermissionState() {
    }
}
