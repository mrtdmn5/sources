package com.animaconnected.secondo.screens.workout.heartrate;

import androidx.compose.foundation.pager.PagerState;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HelpPagesBottomDialog.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class HelpPagesBottomDialogKt$DialogContent$1$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    final /* synthetic */ Function0<Unit> $dismissDialog;
    final /* synthetic */ List<HelpPageModel> $pageModels;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HelpPagesBottomDialogKt$DialogContent$1$2(CoroutineScope coroutineScope, PagerState pagerState, List<HelpPageModel> list, Function0<Unit> function0) {
        super(1, Intrinsics.Kotlin.class, "changePage", "DialogContent$lambda$1$changePage(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/pager/PagerState;Ljava/util/List;Lkotlin/jvm/functions/Function0;I)V", 0);
        this.$scope = coroutineScope;
        this.$pagerState = pagerState;
        this.$pageModels = list;
        this.$dismissDialog = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r5) {
        HelpPagesBottomDialogKt.DialogContent$lambda$1$changePage(this.$scope, this.$pagerState, this.$pageModels, this.$dismissDialog, r5);
    }
}
