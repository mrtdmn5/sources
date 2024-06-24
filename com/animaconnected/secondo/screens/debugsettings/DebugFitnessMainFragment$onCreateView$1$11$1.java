package com.animaconnected.secondo.screens.debugsettings;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.activity.result.ActivityResult;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.secondo.utils.ViewKt;
import com.google.common.collect.Hashing;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: DebugFitnessMainFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$11$1", f = "DebugFitnessMainFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugFitnessMainFragment$onCreateView$1$11$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ Button $this_apply;
    int label;
    final /* synthetic */ DebugFitnessMainFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugFitnessMainFragment$onCreateView$1$11$1(DebugFitnessMainFragment debugFitnessMainFragment, Button button, Continuation<? super DebugFitnessMainFragment$onCreateView$1$11$1> continuation) {
        super(2, continuation);
        this.this$0 = debugFitnessMainFragment;
        this.$this_apply = button;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugFitnessMainFragment$onCreateView$1$11$1(this.this$0, this.$this_apply, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugFitnessMainFragment$onCreateView$1$11$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (Build.VERSION.SDK_INT < 33 && ContextCompat.checkSelfPermission(this.this$0.requireContext(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                this.this$0.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
            } else {
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("*/*");
                intent.addCategory("android.intent.category.OPENABLE");
                CustomActivityResult<Intent, ActivityResult> activityLauncher = this.this$0.getActivityLauncher();
                final DebugFitnessMainFragment debugFitnessMainFragment = this.this$0;
                final Button button = this.$this_apply;
                activityLauncher.launch(intent, new Function1<ActivityResult, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$11$1.1

                    /* compiled from: DebugFitnessMainFragment.kt */
                    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$11$1$1$1", f = "DebugFitnessMainFragment.kt", l = {205}, m = "invokeSuspend")
                    /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$11$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* loaded from: classes3.dex */
                    public static final class C00511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Button $this_apply;
                        final /* synthetic */ Uri $uri;
                        private /* synthetic */ Object L$0;
                        Object L$1;
                        int label;
                        final /* synthetic */ DebugFitnessMainFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C00511(Button button, Uri uri, DebugFitnessMainFragment debugFitnessMainFragment, Continuation<? super C00511> continuation) {
                            super(2, continuation);
                            this.$this_apply = button;
                            this.$uri = uri;
                            this.this$0 = debugFitnessMainFragment;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            C00511 c00511 = new C00511(this.$this_apply, this.$uri, this.this$0, continuation);
                            c00511.L$0 = obj;
                            return c00511;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r4v0, types: [int] */
                        /* JADX WARN: Type inference failed for: r4v1 */
                        /* JADX WARN: Type inference failed for: r4v4 */
                        /* JADX WARN: Type inference failed for: r4v7 */
                        /* JADX WARN: Type inference failed for: r4v8 */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            ProgressBar progressBar;
                            String str;
                            ProgressBar progressBar2;
                            Object withContext;
                            String str2;
                            ContentResolver contentResolver;
                            Cursor query;
                            String str3;
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            ?? r4 = this.label;
                            try {
                                if (r4 != 0) {
                                    if (r4 == 1) {
                                        str2 = (String) this.L$1;
                                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                                        ResultKt.throwOnFailure(obj);
                                        withContext = obj;
                                        r4 = coroutineScope;
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                } else {
                                    ResultKt.throwOnFailure(obj);
                                    CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                                    Context context = this.$this_apply.getContext();
                                    if (context != null && (contentResolver = context.getContentResolver()) != null && (query = contentResolver.query(this.$uri, null, null, null, null)) != null) {
                                        try {
                                            int columnIndex = query.getColumnIndex("_display_name");
                                            query.moveToFirst();
                                            String string = query.getString(columnIndex);
                                            CloseableKt.closeFinally(query, null);
                                            str = string;
                                        } finally {
                                        }
                                    } else {
                                        str = null;
                                    }
                                    if (str != null) {
                                        progressBar2 = this.this$0.progressBar;
                                        if (progressBar2 != null) {
                                            progressBar2.setVisibility(0);
                                            DefaultIoScheduler defaultIoScheduler = Dispatchers.IO;
                                            DebugFitnessMainFragment$onCreateView$1$11$1$1$1$result$1 debugFitnessMainFragment$onCreateView$1$11$1$1$1$result$1 = new DebugFitnessMainFragment$onCreateView$1$11$1$1$1$result$1(str, this.this$0, this.$this_apply, this.$uri, null);
                                            this.L$0 = coroutineScope2;
                                            this.L$1 = str;
                                            this.label = 1;
                                            withContext = BuildersKt.withContext(defaultIoScheduler, debugFitnessMainFragment$onCreateView$1$11$1$1$1$result$1, this);
                                            if (withContext == coroutineSingletons) {
                                                return coroutineSingletons;
                                            }
                                            str2 = str;
                                            r4 = coroutineScope2;
                                        } else {
                                            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                                            throw null;
                                        }
                                    } else {
                                        return Unit.INSTANCE;
                                    }
                                }
                                boolean booleanValue = ((Boolean) withContext).booleanValue();
                                DebugFitnessMainFragment debugFitnessMainFragment = this.this$0;
                                if (booleanValue) {
                                    str3 = "Imported " + str2 + '!';
                                } else {
                                    str3 = "Failed to import " + str2;
                                }
                                ViewKt.toast((Fragment) debugFitnessMainFragment, str3, true);
                            } catch (Exception e) {
                                Object obj2 = r4;
                                ViewKt.toast((Fragment) this.this$0, "Failed to import. Error: " + e.getMessage(), true);
                                LogKt.err$default(obj2, "Error:", (String) null, (Throwable) e, false, 10, (Object) null);
                            }
                            progressBar = this.this$0.progressBar;
                            if (progressBar != null) {
                                progressBar.setVisibility(8);
                                return Unit.INSTANCE;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                            throw null;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C00511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ActivityResult activityResult) {
                        invoke2(activityResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ActivityResult activityResult) {
                        Uri data;
                        Intrinsics.checkNotNullParameter(activityResult, "activityResult");
                        Intent intent2 = activityResult.mData;
                        if (intent2 == null || (data = intent2.getData()) == null) {
                            return;
                        }
                        LifecycleCoroutineScopeImpl lifecycleScope = Hashing.getLifecycleScope(DebugFitnessMainFragment.this);
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        BuildersKt.launch$default(lifecycleScope, MainDispatcherLoader.dispatcher, null, new C00511(button, data, DebugFitnessMainFragment.this, null), 2);
                    }
                });
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
