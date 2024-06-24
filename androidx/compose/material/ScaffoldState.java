package androidx.compose.material;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scaffold.kt */
/* loaded from: classes.dex */
public final class ScaffoldState {
    public final DrawerState drawerState;
    public final SnackbarHostState snackbarHostState;

    public ScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState) {
        Intrinsics.checkNotNullParameter(drawerState, "drawerState");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        this.drawerState = drawerState;
        this.snackbarHostState = snackbarHostState;
    }
}
