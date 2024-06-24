package com.animaconnected.secondo.screens.debugsettings;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.DatePicker;
import androidx.core.content.FileProvider;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.TimePeriod;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function2;

/* compiled from: DebugFitnessMainFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$10", f = "DebugFitnessMainFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugFitnessMainFragment$onCreateView$1$10 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $this_apply;
    int label;
    final /* synthetic */ DebugFitnessMainFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugFitnessMainFragment$onCreateView$1$10(View view, DebugFitnessMainFragment debugFitnessMainFragment, Continuation<? super DebugFitnessMainFragment$onCreateView$1$10> continuation) {
        super(2, continuation);
        this.$this_apply = view;
        this.this$0 = debugFitnessMainFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$3(View view, DebugFitnessMainFragment debugFitnessMainFragment, DatePicker datePicker, int r6, int r7, int r8) {
        SimpleDateFormat simpleDateFormat;
        FitnessProvider fitnessProvider;
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, r6);
        calendar.set(2, r7);
        calendar.set(5, r8);
        File file = new File(view.getContext().getFilesDir(), "fitness");
        file.mkdir();
        StringBuilder sb = new StringBuilder("Fitnessdata-");
        simpleDateFormat = debugFitnessMainFragment.sdf;
        sb.append(simpleDateFormat.format(calendar.getTime()));
        sb.append(".json");
        File file2 = new File(file, sb.toString());
        fitnessProvider = debugFitnessMainFragment.fitnessProvider;
        FilesKt__FileReadWriteKt.writeText$default(file2, fitnessProvider.debugExportToJson(TimePeriod.Companion.day(calendar.getTimeInMillis())));
        Uri uriForFile = FileProvider.getUriForFile(view.getContext(), file2);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        intent.setType("text/*");
        intent.addFlags(1);
        debugFitnessMainFragment.startActivity(Intent.createChooser(intent, "Share File"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugFitnessMainFragment$onCreateView$1$10(this.$this_apply, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugFitnessMainFragment$onCreateView$1$10) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final View view = this.$this_apply;
            final DebugFitnessMainFragment debugFitnessMainFragment = this.this$0;
            DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$10$$ExternalSyntheticLambda0
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public final void onDateSet(DatePicker datePicker, int r8, int r9, int r10) {
                    DebugFitnessMainFragment$onCreateView$1$10.invokeSuspend$lambda$3(view, debugFitnessMainFragment, datePicker, r8, r9, r10);
                }
            };
            Calendar calendar = Calendar.getInstance();
            new DatePickerDialog(this.$this_apply.getContext(), onDateSetListener, calendar.get(1), calendar.get(2), calendar.get(5)).show();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
