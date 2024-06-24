package com.animaconnected.secondo.screens.settings;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PasswordManagementViewModel.kt */
/* loaded from: classes3.dex */
public abstract class PasswordState {
    public static final int $stable = 0;

    /* compiled from: PasswordManagementViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class ConfirmationCodeSent extends PasswordState {
        public static final int $stable = 0;
        public static final ConfirmationCodeSent INSTANCE = new ConfirmationCodeSent();

        private ConfirmationCodeSent() {
            super(null);
        }
    }

    /* compiled from: PasswordManagementViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Idle extends PasswordState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    /* compiled from: PasswordManagementViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class ResetPasswordConfirmed extends PasswordState {
        public static final int $stable = 0;
        public static final ResetPasswordConfirmed INSTANCE = new ResetPasswordConfirmed();

        private ResetPasswordConfirmed() {
            super(null);
        }
    }

    public /* synthetic */ PasswordState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public String toString() {
        if (Intrinsics.areEqual(this, Idle.INSTANCE)) {
            return "Idle";
        }
        if (Intrinsics.areEqual(this, ConfirmationCodeSent.INSTANCE)) {
            return "ConfirmationCodeSent";
        }
        if (Intrinsics.areEqual(this, ResetPasswordConfirmed.INSTANCE)) {
            return "ResetPasswordConfirmed";
        }
        throw new NoWhenBranchMatchedException();
    }

    private PasswordState() {
    }
}
