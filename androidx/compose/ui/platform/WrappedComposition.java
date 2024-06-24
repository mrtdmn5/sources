package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.kronaby.watch.app.R;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Wrapper.android.kt */
/* loaded from: classes.dex */
public final class WrappedComposition implements Composition, LifecycleEventObserver {
    public Lifecycle addedToLifecycle;
    public boolean disposed;
    public Function2<? super Composer, ? super Integer, Unit> lastContent = ComposableSingletons$Wrapper_androidKt.f11lambda1;
    public final Composition original;
    public final AndroidComposeView owner;

    public WrappedComposition(AndroidComposeView androidComposeView, CompositionImpl compositionImpl) {
        this.owner = androidComposeView;
        this.original = compositionImpl;
    }

    @Override // androidx.compose.runtime.Composition
    public final void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.owner.getView().setTag(R.id.wrapped_composition_tag, null);
            Lifecycle lifecycle = this.addedToLifecycle;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
            }
        }
        this.original.dispose();
    }

    @Override // androidx.compose.runtime.Composition
    public final boolean getHasInvalidations() {
        return this.original.getHasInvalidations();
    }

    @Override // androidx.compose.runtime.Composition
    public final boolean isDisposed() {
        return this.original.isDisposed();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose();
        } else if (event == Lifecycle.Event.ON_CREATE && !this.disposed) {
            setContent(this.lastContent);
        }
    }

    @Override // androidx.compose.runtime.Composition
    public final void setContent(final Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.owner.setOnViewTreeOwnersAvailable(new Function1<AndroidComposeView.ViewTreeOwners, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r4v7, types: [androidx.compose.ui.platform.WrappedComposition$setContent$1$1, kotlin.jvm.internal.Lambda] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(AndroidComposeView.ViewTreeOwners viewTreeOwners) {
                AndroidComposeView.ViewTreeOwners it = viewTreeOwners;
                Intrinsics.checkNotNullParameter(it, "it");
                final WrappedComposition wrappedComposition = WrappedComposition.this;
                if (!wrappedComposition.disposed) {
                    Lifecycle lifecycle = it.lifecycleOwner.getLifecycle();
                    final Function2<Composer, Integer, Unit> function2 = content;
                    wrappedComposition.lastContent = function2;
                    if (wrappedComposition.addedToLifecycle == null) {
                        wrappedComposition.addedToLifecycle = lifecycle;
                        lifecycle.addObserver(wrappedComposition);
                    } else if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                        wrappedComposition.original.setContent(ComposableLambdaKt.composableLambdaInstance(-2000640158, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1.1

                            /* compiled from: Wrapper.android.kt */
                            @DebugMetadata(c = "androidx.compose.ui.platform.WrappedComposition$setContent$1$1$1", f = "Wrapper.android.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryLineLegendColorActivity}, m = "invokeSuspend")
                            /* renamed from: androidx.compose.ui.platform.WrappedComposition$setContent$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* loaded from: classes.dex */
                            public final class C00291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                public int label;
                                public final /* synthetic */ WrappedComposition this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C00291(WrappedComposition wrappedComposition, Continuation<? super C00291> continuation) {
                                    super(2, continuation);
                                    this.this$0 = wrappedComposition;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C00291(this.this$0, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C00291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                    int r1 = this.label;
                                    if (r1 != 0) {
                                        if (r1 == 1) {
                                            ResultKt.throwOnFailure(obj);
                                        } else {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                    } else {
                                        ResultKt.throwOnFailure(obj);
                                        AndroidComposeView androidComposeView = this.this$0.owner;
                                        this.label = 1;
                                        Object boundsUpdatesEventLoop = androidComposeView.accessibilityDelegate.boundsUpdatesEventLoop(this);
                                        if (boundsUpdatesEventLoop != coroutineSingletons) {
                                            boundsUpdatesEventLoop = Unit.INSTANCE;
                                        }
                                        if (boundsUpdatesEventLoop == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.ui.platform.WrappedComposition$setContent$1$1$2, kotlin.jvm.internal.Lambda] */
                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer, Integer num) {
                                boolean z;
                                Set set;
                                View view;
                                Object obj;
                                Composer composer2 = composer;
                                if ((num.intValue() & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                } else {
                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                                    final WrappedComposition wrappedComposition2 = WrappedComposition.this;
                                    Object tag = wrappedComposition2.owner.getTag(R.id.inspection_slot_table_set);
                                    boolean z2 = true;
                                    if ((tag instanceof Set) && (!(tag instanceof KMappedMarker) || (tag instanceof KMutableSet))) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        set = (Set) tag;
                                    } else {
                                        set = null;
                                    }
                                    AndroidComposeView androidComposeView = wrappedComposition2.owner;
                                    if (set == null) {
                                        Object parent = androidComposeView.getParent();
                                        if (parent instanceof View) {
                                            view = (View) parent;
                                        } else {
                                            view = null;
                                        }
                                        if (view != null) {
                                            obj = view.getTag(R.id.inspection_slot_table_set);
                                        } else {
                                            obj = null;
                                        }
                                        if (!(obj instanceof Set) || ((obj instanceof KMappedMarker) && !(obj instanceof KMutableSet))) {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            set = (Set) obj;
                                        } else {
                                            set = null;
                                        }
                                    }
                                    if (set != null) {
                                        set.add(composer2.getCompositionData());
                                        composer2.collectParameterInformation();
                                    }
                                    EffectsKt.LaunchedEffect(androidComposeView, new C00291(wrappedComposition2, null), composer2);
                                    ProvidedValue[] providedValueArr = {InspectionTablesKt.LocalInspectionTables.provides(set)};
                                    final Function2<Composer, Integer, Unit> function22 = function2;
                                    CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1193460702, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition.setContent.1.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(Composer composer3, Integer num2) {
                                            Composer composer4 = composer3;
                                            if ((num2.intValue() & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                            } else {
                                                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                                AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals(WrappedComposition.this.owner, function22, composer4, 8);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer2, 56);
                                }
                                return Unit.INSTANCE;
                            }
                        }, true));
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }
}
