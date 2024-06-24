package com.animaconnected.secondo.screens.debugsettings;

import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.device.Command;
import com.animaconnected.watch.device.files.FileDescriptor;
import com.animaconnected.watch.device.files.WatchFile;
import com.animaconnected.watch.device.files.WatchFileSystem;
import com.animaconnected.watch.display.AndroidGraphicsKt;
import com.animaconnected.watch.image.ImageBuilder;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;

/* compiled from: DebugDeviceStorageFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$invalidateListRow$1", f = "DebugDeviceStorageFragment.kt", l = {R.styleable.AppTheme_stepsHistoryLineLegendColorActivity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugDeviceStorageFragment$invalidateListRow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DebugDeviceStorageFragment.ListEntryFile $entry;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ DebugDeviceStorageFragment this$0;

    /* compiled from: DebugDeviceStorageFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$invalidateListRow$1$1", f = "DebugDeviceStorageFragment.kt", l = {R.styleable.AppTheme_stepsHistoryNoDataBackgroundActivity}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$invalidateListRow$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DebugDeviceStorageFragment.ListEntryFile $entry;
        private /* synthetic */ Object L$0;
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$entry, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            DisplayWatch displayWatch;
            String contentString;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 == 1) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception unused) {
                        LogKt.verbose$default((Object) coroutineScope, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment.invalidateListRow.1.1.1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to read file";
                            }
                        }, 7, (Object) null);
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    displayWatch = this.this$0.watch;
                    WatchFileSystem fs = displayWatch.getFs();
                    if (fs != null) {
                        FileDescriptor file = this.$entry.getFile();
                        this.L$0 = coroutineScope2;
                        this.label = 1;
                        Object readFile = fs.readFile(file, this);
                        if (readFile == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        obj = readFile;
                    } else {
                        return Unit.INSTANCE;
                    }
                } catch (Exception unused2) {
                    coroutineScope = coroutineScope2;
                    LogKt.verbose$default((Object) coroutineScope, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment.invalidateListRow.1.1.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to read file";
                        }
                    }, 7, (Object) null);
                    return Unit.INSTANCE;
                }
            }
            WatchFile watchFile = (WatchFile) obj;
            if (watchFile != null) {
                DebugDeviceStorageFragment.ListEntryFile listEntryFile = this.$entry;
                contentString = this.this$0.getContentString(watchFile);
                listEntryFile.setContent(contentString);
                if (StringsKt__StringsJVMKt.equals("bin", watchFile.getExtension()) && StringsKt__StringsKt.contains(watchFile.getDirectory(), Command.PICTURE, false)) {
                    this.$entry.setBitmap(AndroidGraphicsKt.toBitmap$default(ImageBuilder.INSTANCE.decodeToMitmap(watchFile.getBytes()), null, 1, null));
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugDeviceStorageFragment$invalidateListRow$1(DebugDeviceStorageFragment debugDeviceStorageFragment, int r2, DebugDeviceStorageFragment.ListEntryFile listEntryFile, Continuation<? super DebugDeviceStorageFragment$invalidateListRow$1> continuation) {
        super(2, continuation);
        this.this$0 = debugDeviceStorageFragment;
        this.$position = r2;
        this.$entry = listEntryFile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugDeviceStorageFragment$invalidateListRow$1(this.this$0, this.$position, this.$entry, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DebugDeviceStorageFragment.DebugDeviceStorageAdapter debugDeviceStorageAdapter;
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
            DefaultIoScheduler defaultIoScheduler = Dispatchers.IO;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$entry, null);
            this.label = 1;
            if (BuildersKt.withContext(defaultIoScheduler, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        debugDeviceStorageAdapter = this.this$0.rvAdapter;
        if (debugDeviceStorageAdapter != null) {
            debugDeviceStorageAdapter.notifyItemChanged(this.$position);
            return Unit.INSTANCE;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugDeviceStorageFragment$invalidateListRow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
