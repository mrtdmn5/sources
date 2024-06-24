package com.amplifyframework.statemachine;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public interface Action {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Action.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ Action invoke$default(Companion companion, String str, Function3 block, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = null;
            }
            Intrinsics.checkNotNullParameter(block, "block");
            return new Action$Companion$invoke$1(str, block);
        }

        public final BasicAction basic(String id, Function3<? super EventDispatcher, ? super Environment, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(block, "block");
            return new BasicAction(id, block);
        }

        public final Action invoke(String str, Function3<? super EventDispatcher, ? super Environment, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return new Action$Companion$invoke$1(str, block);
        }

        public static /* synthetic */ Action invoke$default(Companion companion, String str, Function4 block, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = null;
            }
            Intrinsics.checkNotNullParameter(block, "block");
            return new Action$Companion$invoke$2(str, block);
        }

        public final <EnvType extends Environment> Action invoke(String str, Function4<? super EnvType, ? super String, ? super EventDispatcher, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return new Action$Companion$invoke$2(str, block);
        }
    }

    /* compiled from: Action.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static String getId(Action action) {
            return action.getClass().getSimpleName();
        }
    }

    Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation);

    String getId();
}
