package androidx.compose.material;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetScaffold.kt */
/* loaded from: classes.dex */
public final class BottomSheetScaffoldState {
    public final BottomSheetState bottomSheetState;
    public final DrawerState drawerState;
    public final SnackbarHostState snackbarHostState;

    public BottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState) {
        Intrinsics.checkNotNullParameter(drawerState, "drawerState");
        Intrinsics.checkNotNullParameter(bottomSheetState, "bottomSheetState");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        this.drawerState = drawerState;
        this.bottomSheetState = bottomSheetState;
        this.snackbarHostState = snackbarHostState;
    }
}
