package com.animaconnected.secondo.screens.debugsettings;

import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.device.files.FileDescriptor;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;

/* compiled from: DebugDeviceStorageFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$deleteFileAt$1", f = "DebugDeviceStorageFragment.kt", l = {R.styleable.AppTheme_themeShadowOpacity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugDeviceStorageFragment$deleteFileAt$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DebugDeviceStorageFragment.ListEntryFile $entry;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ DebugDeviceStorageFragment this$0;

    /* compiled from: DebugDeviceStorageFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$deleteFileAt$1$1", f = "DebugDeviceStorageFragment.kt", l = {R.styleable.AppTheme_toolbarActionTextStyle}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$deleteFileAt$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DebugDeviceStorageFragment.ListEntryFile $entry;
        int label;
        final /* synthetic */ DebugDeviceStorageFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DebugDeviceStorageFragment debugDeviceStorageFragment, DebugDeviceStorageFragment.ListEntryFile listEntryFile, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = debugDeviceStorageFragment;
            this.$entry = listEntryFile;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$entry, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object deleteFile;
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
                DebugDeviceStorageFragment debugDeviceStorageFragment = this.this$0;
                FileDescriptor file = this.$entry.getFile();
                this.label = 1;
                deleteFile = debugDeviceStorageFragment.deleteFile(file, this);
                if (deleteFile == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugDeviceStorageFragment$deleteFileAt$1(DebugDeviceStorageFragment.ListEntryFile listEntryFile, DebugDeviceStorageFragment debugDeviceStorageFragment, int r3, Continuation<? super DebugDeviceStorageFragment$deleteFileAt$1> continuation) {
        super(2, continuation);
        this.$entry = listEntryFile;
        this.this$0 = debugDeviceStorageFragment;
        this.$position = r3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugDeviceStorageFragment$deleteFileAt$1(this.$entry, this.this$0, this.$position, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DebugDeviceStorageFragment.DebugDeviceStorageAdapter debugDeviceStorageAdapter;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                DefaultIoScheduler defaultIoScheduler = Dispatchers.IO;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$entry, null);
                this.label = 1;
                if (BuildersKt.withContext(defaultIoScheduler, anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            this.$entry.setRemoved(true);
            debugDeviceStorageAdapter = this.this$0.rvAdapter;
        } catch (Exception e) {
            ViewKt.toast$default((Fragment) this.this$0, e.toString(), false, 2, (Object) null);
        }
        if (debugDeviceStorageAdapter != null) {
            debugDeviceStorageAdapter.notifyItemChanged(this.$position);
            return Unit.INSTANCE;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugDeviceStorageFragment$deleteFileAt$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
