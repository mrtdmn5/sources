package com.animaconnected.secondo.screens;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.viewbinding.ViewBinding;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: BottomSheet.kt */
/* loaded from: classes3.dex */
public final class BottomSheetKt {
    public static final BottomDialog createBottomDialog(Context context, int r4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        final View inflate = ((LayoutInflater) systemService).inflate(r4, (ViewGroup) null, false);
        return new BottomDialog(context, new Function1<BottomDialog, View>() { // from class: com.animaconnected.secondo.screens.BottomSheetKt$createBottomDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final View invoke(BottomDialog it) {
                Intrinsics.checkNotNullParameter(it, "it");
                View sheetView = inflate;
                Intrinsics.checkNotNullExpressionValue(sheetView, "$sheetView");
                return sheetView;
            }
        });
    }

    public static final void showBottomDialog(Context context, int r3, final Function1<? super Boolean, Unit> approved) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(approved, "approved");
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final BottomDialog createBottomDialog = createBottomDialog(context, r3);
        View findViewById = createBottomDialog.findViewById(R.id.btn_approve);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.BottomSheetKt$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BottomSheetKt.showBottomDialog$lambda$3$lambda$0(Ref$BooleanRef.this, createBottomDialog, approved, view);
                }
            });
        }
        View findViewById2 = createBottomDialog.findViewById(R.id.btn_cancel);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.BottomSheetKt$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BottomSheetKt.showBottomDialog$lambda$3$lambda$1(Ref$BooleanRef.this, createBottomDialog, approved, view);
                }
            });
        }
        createBottomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.animaconnected.secondo.screens.BottomSheetKt$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                BottomSheetKt.showBottomDialog$lambda$3$lambda$2(Ref$BooleanRef.this, approved, dialogInterface);
            }
        });
        createBottomDialog.show();
    }

    public static /* synthetic */ BottomDialog showBottomDialog$default(Context context, boolean z, Function3 function3, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            z = true;
        }
        return showBottomDialog(context, z, (Function3<? super Function0<Unit>, ? super Composer, ? super Integer, Unit>) function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBottomDialog$lambda$3$lambda$0(Ref$BooleanRef dismissed, BottomDialog this_apply, Function1 approved, View view) {
        Intrinsics.checkNotNullParameter(dismissed, "$dismissed");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(approved, "$approved");
        dismissed.element = true;
        this_apply.dismiss();
        approved.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBottomDialog$lambda$3$lambda$1(Ref$BooleanRef dismissed, BottomDialog this_apply, Function1 approved, View view) {
        Intrinsics.checkNotNullParameter(dismissed, "$dismissed");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(approved, "$approved");
        dismissed.element = true;
        this_apply.dismiss();
        approved.invoke(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBottomDialog$lambda$3$lambda$2(Ref$BooleanRef dismissed, Function1 approved, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dismissed, "$dismissed");
        Intrinsics.checkNotNullParameter(approved, "$approved");
        if (!dismissed.element) {
            approved.invoke(Boolean.FALSE);
        }
    }

    public static final BottomDialog createBottomDialog(Context context, final Function2<? super BottomDialog, ? super LayoutInflater, ? extends ViewBinding> viewBinding) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        final LayoutInflater layoutInflater = (LayoutInflater) systemService;
        return new BottomDialog(context, new Function1<BottomDialog, View>() { // from class: com.animaconnected.secondo.screens.BottomSheetKt$createBottomDialog$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final View invoke(BottomDialog it) {
                Intrinsics.checkNotNullParameter(it, "it");
                View root = viewBinding.invoke(it, layoutInflater).getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                return root;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.animaconnected.secondo.screens.BottomDialog, android.app.Dialog] */
    public static final BottomDialog showBottomDialog(final Context context, boolean z, final Function3<? super Function0<Unit>, ? super Composer, ? super Integer, Unit> content) {
        View decorView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(content, "content");
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.BottomSheetKt$showBottomDialog$dismissIfRequested$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                BottomDialog bottomDialog = ref$ObjectRef.element;
                if (bottomDialog == null) {
                    return null;
                }
                if (!ref$BooleanRef.element) {
                    bottomDialog = null;
                }
                if (bottomDialog == null) {
                    return null;
                }
                bottomDialog.dismiss();
                return Unit.INSTANCE;
            }
        };
        final Function0<Unit> function02 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.BottomSheetKt$showBottomDialog$dismissDialogCallback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Ref$BooleanRef.this.element = true;
                return function0.invoke();
            }
        };
        ?? bottomDialog = new BottomDialog(context, new Function1<BottomDialog, View>() { // from class: com.animaconnected.secondo.screens.BottomSheetKt$showBottomDialog$dialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [com.animaconnected.secondo.screens.BottomSheetKt$showBottomDialog$dialog$1$1$1, kotlin.jvm.internal.Lambda] */
            @Override // kotlin.jvm.functions.Function1
            public final View invoke(BottomDialog bottomDialog2) {
                Intrinsics.checkNotNullParameter(bottomDialog2, "<anonymous parameter 0>");
                ComposeView composeView = new ComposeView(context, null, 6);
                final Function3<Function0<Unit>, Composer, Integer, Unit> function3 = content;
                final Function0<Unit> function03 = function02;
                composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow.INSTANCE);
                composeView.setContent(ComposableLambdaKt.composableLambdaInstance(87466288, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.BottomSheetKt$showBottomDialog$dialog$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int r4) {
                        if ((r4 & 11) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                        } else {
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                            function3.invoke(function03, composer, 0);
                        }
                    }
                }, true));
                return composeView;
            }
        });
        bottomDialog.setDismissible(z);
        bottomDialog.show();
        Window window = bottomDialog.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            ViewTreeViewModelStoreOwner.set(decorView, context instanceof ViewModelStoreOwner ? (ViewModelStoreOwner) context : null);
            ViewTreeLifecycleOwner.set(decorView, context instanceof LifecycleOwner ? (LifecycleOwner) context : null);
            ViewTreeSavedStateRegistryOwner.set(decorView, context instanceof SavedStateRegistryOwner ? (SavedStateRegistryOwner) context : null);
        }
        ref$ObjectRef.element = bottomDialog;
        function0.invoke();
        return bottomDialog;
    }
}
