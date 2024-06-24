package com.animaconnected.secondo.screens.workout.detail;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.animaconnected.secondo.utils.debugging.Debugging;
import com.animaconnected.watch.account.strava.StravaTcxKt;
import com.animaconnected.watch.fitness.Session;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: WorkoutUtils.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.detail.WorkoutUtils$shareTcxFile$fileUri$1", f = "WorkoutUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutUtils$shareTcxFile$fileUri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Session $session;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutUtils$shareTcxFile$fileUri$1(Session session, Context context, Continuation<? super WorkoutUtils$shareTcxFile$fileUri$1> continuation) {
        super(2, continuation);
        this.$session = session;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutUtils$shareTcxFile$fileUri$1(this.$session, this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Instant.Companion companion = Instant.Companion;
            long startTs = this.$session.getStartTs();
            companion.getClass();
            Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(startTs);
            TimeZone.Companion.getClass();
            LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(fromEpochMilliseconds, TimeZone.UTC);
            File file = new File(this.$context.getFilesDir(), Debugging.debuggingFolder);
            file.mkdir();
            File file2 = new File(file, "TCX-" + localDateTime + ".xml");
            FilesKt__FileReadWriteKt.writeText$default(file2, StravaTcxKt.toTcx(this.$session));
            return FileProvider.getUriForFile(this.$context, file2);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Uri> continuation) {
        return ((WorkoutUtils$shareTcxFile$fileUri$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
