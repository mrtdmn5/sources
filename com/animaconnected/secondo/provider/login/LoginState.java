package com.animaconnected.secondo.provider.login;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LoginViewModel.kt */
/* loaded from: classes3.dex */
public abstract class LoginState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int id;

    /* compiled from: LoginViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LoginState fromId(Integer num) {
            Idle idle = Idle.INSTANCE;
            int id = idle.getId();
            if (num == null || num.intValue() != id) {
                SignedIn signedIn = SignedIn.INSTANCE;
                int id2 = signedIn.getId();
                if (num == null || num.intValue() != id2) {
                    ConfirmSignUp confirmSignUp = ConfirmSignUp.INSTANCE;
                    int id3 = confirmSignUp.getId();
                    if (num == null || num.intValue() != id3) {
                        return Uninitialized.INSTANCE;
                    }
                    return confirmSignUp;
                }
                return signedIn;
            }
            return idle;
        }

        private Companion() {
        }
    }

    /* compiled from: LoginViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class ConfirmSignUp extends LoginState {
        public static final int $stable = 0;
        public static final ConfirmSignUp INSTANCE = new ConfirmSignUp();

        private ConfirmSignUp() {
            super(4, null);
        }
    }

    /* compiled from: LoginViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Idle extends LoginState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(2, null);
        }
    }

    /* compiled from: LoginViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class SignedIn extends LoginState {
        public static final int $stable = 0;
        public static final SignedIn INSTANCE = new SignedIn();

        private SignedIn() {
            super(3, null);
        }
    }

    /* compiled from: LoginViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Uninitialized extends LoginState {
        public static final int $stable = 0;
        public static final Uninitialized INSTANCE = new Uninitialized();

        private Uninitialized() {
            super(1, null);
        }
    }

    public /* synthetic */ LoginState(int r1, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1);
    }

    public final int getId() {
        return this.id;
    }

    private LoginState(int r1) {
        this.id = r1;
    }
}
