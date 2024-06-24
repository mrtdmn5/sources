package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.VerticalAlignElement;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.material.ContentColorKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.IconKt;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.device.DeviceWriterKt;
import com.animaconnected.watch.device.PhoneNotification;
import com.animaconnected.watch.device.Vibration;
import com.animaconnected.watch.display.AndroidGraphicsKt;
import com.animaconnected.watch.image.Kolor;
import com.animaconnected.watch.image.Kolors;
import com.animaconnected.watch.strings.Static;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.widget.ScreenTitleKt;
import com.google.common.base.Strings;
import com.google.common.collect.Hashing;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: DebugNotificationsFragment.kt */
/* loaded from: classes3.dex */
public final class DebugNotificationsFragment extends ComposeFragment {
    public static final int $stable = 8;
    private final Context ctx;
    private final Lazy image$delegate;
    private final String name;
    private int notificationId;
    private final DisplayWatch watch;

    public DebugNotificationsFragment() {
        Watch watch = ProviderFactory.getWatch().getWatch();
        Intrinsics.checkNotNull(watch, "null cannot be cast to non-null type com.animaconnected.watch.DisplayWatch");
        this.watch = (DisplayWatch) watch;
        this.ctx = KronabyApplication.Companion.getContext();
        this.image$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Bitmap>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$image$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bitmap invoke() {
                Context context;
                context = DebugNotificationsFragment.this.ctx;
                Resources resources = context.getResources();
                ThreadLocal<TypedValue> threadLocal = ResourcesCompat.sTempTypedValue;
                Drawable drawable = ResourcesCompat.Api21Impl.getDrawable(resources, R.drawable.breadcrumb_shadow_headsup, null);
                if (drawable != null) {
                    return DrawableKt.toBitmap$default(drawable, 24, 24, 4);
                }
                throw new IllegalArgumentException("No image found");
            }
        });
        this.name = "DebugNotifications";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PhoneNotification ComposeContent$lambda$2(MutableState<PhoneNotification> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap getImage() {
        return (Bitmap) this.image$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object removeNotification(com.animaconnected.watch.device.PhoneNotification r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Success, removed notification with id:"
            boolean r1 = r8 instanceof com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$removeNotification$1
            if (r1 == 0) goto L15
            r1 = r8
            com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$removeNotification$1 r1 = (com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$removeNotification$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$removeNotification$1 r1 = new com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$removeNotification$1
            r1.<init>(r6, r8)
        L1a:
            java.lang.Object r8 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L3c
            if (r3 != r5) goto L34
            java.lang.Object r7 = r1.L$1
            com.animaconnected.watch.device.PhoneNotification r7 = (com.animaconnected.watch.device.PhoneNotification) r7
            java.lang.Object r1 = r1.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment r1 = (com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment) r1
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L32
            goto L53
        L32:
            r7 = move-exception
            goto L72
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.watch.DisplayWatch r8 = r6.watch     // Catch: java.lang.Exception -> L70
            int r3 = r7.getId()     // Catch: java.lang.Exception -> L70
            r1.L$0 = r6     // Catch: java.lang.Exception -> L70
            r1.L$1 = r7     // Catch: java.lang.Exception -> L70
            r1.label = r5     // Catch: java.lang.Exception -> L70
            java.lang.Object r8 = com.animaconnected.watch.DisplayWatchJvm.removeNotification(r8, r3, r1)     // Catch: java.lang.Exception -> L70
            if (r8 != r2) goto L52
            return r2
        L52:
            r1 = r6
        L53:
            android.content.Context r8 = r1.getContext()     // Catch: java.lang.Exception -> L32
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L32
            r2.<init>(r0)     // Catch: java.lang.Exception -> L32
            int r7 = r7.getId()     // Catch: java.lang.Exception -> L32
            r2.append(r7)     // Catch: java.lang.Exception -> L32
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Exception -> L32
            android.widget.Toast r7 = android.widget.Toast.makeText(r8, r7, r4)     // Catch: java.lang.Exception -> L32
            r7.show()     // Catch: java.lang.Exception -> L32
            r4 = r5
            goto L8f
        L70:
            r7 = move-exception
            r1 = r6
        L72:
            android.content.Context r8 = r1.getContext()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed: "
            r0.<init>(r1)
            java.lang.String r7 = r7.getLocalizedMessage()
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            android.widget.Toast r7 = android.widget.Toast.makeText(r8, r7, r4)
            r7.show()
        L8f:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment.removeNotification(com.animaconnected.watch.device.PhoneNotification, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Type inference failed for: r2v12, types: [T, com.animaconnected.watch.device.PhoneNotification] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendAndStore(com.animaconnected.watch.device.PhoneNotification r20, androidx.compose.runtime.snapshots.SnapshotStateList<com.animaconnected.watch.device.PhoneNotification> r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            boolean r3 = r2 instanceof com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$sendAndStore$1
            if (r3 == 0) goto L19
            r3 = r2
            com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$sendAndStore$1 r3 = (com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$sendAndStore$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$sendAndStore$1 r3 = new com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$sendAndStore$1
            r3.<init>(r0, r2)
        L1e:
            java.lang.Object r2 = r3.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r5 = r3.label
            r6 = 1
            if (r5 == 0) goto L3d
            if (r5 != r6) goto L35
            java.lang.Object r1 = r3.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
            java.lang.Object r3 = r3.L$0
            androidx.compose.runtime.snapshots.SnapshotStateList r3 = (androidx.compose.runtime.snapshots.SnapshotStateList) r3
            kotlin.ResultKt.throwOnFailure(r2)
            goto L5c
        L35:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3d:
            kotlin.ResultKt.throwOnFailure(r2)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            r2.element = r1
            r5 = r21
            r3.L$0 = r5
            r3.L$1 = r2
            r3.label = r6
            java.lang.Object r1 = r0.sendNotification(r1, r3)
            if (r1 != r4) goto L56
            return r4
        L56:
            r3 = r5
            r18 = r2
            r2 = r1
            r1 = r18
        L5c:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto Lb4
            java.util.Iterator r2 = r3.iterator()
        L68:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L89
            java.lang.Object r4 = r2.next()
            r5 = r4
            com.animaconnected.watch.device.PhoneNotification r5 = (com.animaconnected.watch.device.PhoneNotification) r5
            int r5 = r5.getId()
            T r7 = r1.element
            com.animaconnected.watch.device.PhoneNotification r7 = (com.animaconnected.watch.device.PhoneNotification) r7
            int r7 = r7.getId()
            if (r5 != r7) goto L85
            r5 = r6
            goto L86
        L85:
            r5 = 0
        L86:
            if (r5 == 0) goto L68
            goto L8a
        L89:
            r4 = 0
        L8a:
            com.animaconnected.watch.device.PhoneNotification r4 = (com.animaconnected.watch.device.PhoneNotification) r4
            if (r4 == 0) goto L91
            r3.remove(r4)
        L91:
            T r2 = r1.element
            r3.add(r2)
            T r2 = r1.element
            r7 = r2
            com.animaconnected.watch.device.PhoneNotification r7 = (com.animaconnected.watch.device.PhoneNotification) r7
            com.animaconnected.watch.device.PhoneNotification r2 = (com.animaconnected.watch.device.PhoneNotification) r2
            int r2 = r2.getId()
            int r8 = r2 + 1
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 254(0xfe, float:3.56E-43)
            r17 = 0
            com.animaconnected.watch.device.PhoneNotification r2 = com.animaconnected.watch.device.PhoneNotification.m1082copyuy536eg$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r1.element = r2
        Lb4:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment.sendAndStore(com.animaconnected.watch.device.PhoneNotification, androidx.compose.runtime.snapshots.SnapshotStateList, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendNotification(com.animaconnected.watch.device.PhoneNotification r9, kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "Success, sent "
            boolean r1 = r10 instanceof com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$sendNotification$1
            if (r1 == 0) goto L15
            r1 = r10
            com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$sendNotification$1 r1 = (com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$sendNotification$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$sendNotification$1 r1 = new com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$sendNotification$1
            r1.<init>(r8, r10)
        L1a:
            java.lang.Object r10 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 0
            r5 = 2
            r6 = 0
            r7 = 1
            if (r3 == 0) goto L3e
            if (r3 != r7) goto L36
            java.lang.Object r9 = r1.L$1
            com.animaconnected.watch.device.PhoneNotification r9 = (com.animaconnected.watch.device.PhoneNotification) r9
            java.lang.Object r1 = r1.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment r1 = (com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L34
            goto L56
        L34:
            r9 = move-exception
            goto L69
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3e:
            kotlin.ResultKt.throwOnFailure(r10)
            int r10 = r8.notificationId     // Catch: java.lang.Exception -> L67
            int r10 = r10 + r7
            r8.notificationId = r10     // Catch: java.lang.Exception -> L67
            com.animaconnected.watch.DisplayWatch r10 = r8.watch     // Catch: java.lang.Exception -> L67
            r1.L$0 = r8     // Catch: java.lang.Exception -> L67
            r1.L$1 = r9     // Catch: java.lang.Exception -> L67
            r1.label = r7     // Catch: java.lang.Exception -> L67
            java.lang.Object r10 = com.animaconnected.watch.device.WatchNotificationKt.sendNotification(r10, r9, r1)     // Catch: java.lang.Exception -> L67
            if (r10 != r2) goto L55
            return r2
        L55:
            r1 = r8
        L56:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L34
            r10.<init>(r0)     // Catch: java.lang.Exception -> L34
            r10.append(r9)     // Catch: java.lang.Exception -> L34
            java.lang.String r9 = r10.toString()     // Catch: java.lang.Exception -> L34
            com.animaconnected.secondo.utils.ViewKt.toast$default(r1, r9, r6, r5, r4)     // Catch: java.lang.Exception -> L34
            r6 = r7
            goto L7e
        L67:
            r9 = move-exception
            r1 = r8
        L69:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "Failed: "
            r10.<init>(r0)
            java.lang.String r9 = r9.getLocalizedMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.animaconnected.secondo.utils.ViewKt.toast$default(r1, r9, r6, r5, r4)
        L7e:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment.sendNotification(com.animaconnected.watch.device.PhoneNotification, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1, kotlin.jvm.internal.Lambda] */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r18) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1768278853);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-205328385);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = new SnapshotStateList();
            startRestartGroup.updateValue(nextSlot);
        }
        final SnapshotStateList snapshotStateList = (SnapshotStateList) nextSlot;
        Object m = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -205328304);
        if (m == composer$Companion$Empty$1) {
            m = Platform.mutableStateOf$default(new PhoneNotification(this.notificationId, TransferTable.COLUMN_KEY, StringsExtensionsKt.m1571static("Test Notification"), StringsExtensionsKt.m1571static("Notification Body Test Text Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore  |et dolore magna aliqua."), AndroidGraphicsKt.toMitmap$default(getImage(), null, 1, null), Kolor.m1537constructorimpl(Kolors.deepSkyBlue), "com.kronaby.fakeapp", Vibration.ONE, null));
            startRestartGroup.updateValue(m);
        }
        final MutableState mutableState = (MutableState) m;
        startRestartGroup.end(false);
        CardKt.m162CardFjzlyU(null, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -820709602, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int r58) {
                Bitmap image;
                long Color;
                PhoneNotification ComposeContent$lambda$2;
                PhoneNotification ComposeContent$lambda$22;
                final MutableState<PhoneNotification> mutableState2;
                PhoneNotification ComposeContent$lambda$23;
                final MutableState<PhoneNotification> mutableState3;
                if ((r58 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                final DebugNotificationsFragment debugNotificationsFragment = DebugNotificationsFragment.this;
                final MutableState<PhoneNotification> mutableState4 = mutableState;
                final SnapshotStateList<PhoneNotification> snapshotStateList2 = snapshotStateList;
                composer2.startReplaceableGroup(-483455358);
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
                if (composer2.getApplier() instanceof Applier) {
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        composer2.useNode();
                    }
                    ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Updater.m228setimpl(composer2, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                    ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Updater.m228setimpl(composer2, currentCompositionLocalMap, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer2), composer2, 2058660585);
                    ScreenTitleKt.ScreenTitle(PaddingKt.m73paddingVpY3zN4$default(companion, 0.0f, 16, 1), "App notification", composer2, 54, 0);
                    composer2.startReplaceableGroup(693286680);
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, composer2);
                    composer2.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                    PersistentCompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
                    if (composer2.getApplier() instanceof Applier) {
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            composer2.useNode();
                        }
                        Updater.m228setimpl(composer2, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                        Updater.m228setimpl(composer2, currentCompositionLocalMap2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, composer2, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        modifierMaterializerOf2.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                        composer2.startReplaceableGroup(2058660585);
                        image = debugNotificationsFragment.getImage();
                        AndroidImageBitmap asImageBitmap = AndroidImageBitmap_androidKt.asImageBitmap(image);
                        Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(new VerticalAlignElement(Alignment.Companion.CenterVertically), 8);
                        Modifier modifier = IconKt.DefaultIconSizeModifier;
                        composer2.startReplaceableGroup(-554892675);
                        Color = ColorKt.Color(Color.m322getRedimpl(r4), Color.m321getGreenimpl(r4), Color.m319getBlueimpl(r4), ((Number) composer2.consume(ContentAlphaKt.LocalContentAlpha)).floatValue(), Color.m320getColorSpaceimpl(((Color) composer2.consume(ContentColorKt.LocalContentColor)).value));
                        composer2.startReplaceableGroup(1157296644);
                        boolean changed = composer2.changed(asImageBitmap);
                        Object rememberedValue = composer2.rememberedValue();
                        Object obj = Composer.Companion.Empty;
                        if (changed || rememberedValue == obj) {
                            rememberedValue = new BitmapPainter(asImageBitmap);
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        IconKt.m187Iconww6aTOc((BitmapPainter) rememberedValue, null, m71padding3ABfNKs, Color, composer2, 56, 0);
                        composer2.endReplaceableGroup();
                        ComposeContent$lambda$2 = DebugNotificationsFragment.ComposeContent$lambda$2(mutableState4);
                        String valueOf = String.valueOf(ComposeContent$lambda$2.getId());
                        KeyboardOptions keyboardOptions = new KeyboardOptions(0, 3, 0, 11);
                        Modifier m94width3ABfNKs = SizeKt.m94width3ABfNKs(companion, 64);
                        composer2.startReplaceableGroup(107594399);
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (rememberedValue2 == obj) {
                            rememberedValue2 = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                    invoke2(str);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(String it) {
                                    PhoneNotification ComposeContent$lambda$24;
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    MutableState<PhoneNotification> mutableState5 = mutableState4;
                                    ComposeContent$lambda$24 = DebugNotificationsFragment.ComposeContent$lambda$2(mutableState5);
                                    Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(it);
                                    mutableState5.setValue(PhoneNotification.m1082copyuy536eg$default(ComposeContent$lambda$24, intOrNull != null ? intOrNull.intValue() : 0, null, null, null, null, 0, null, null, 254, null));
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        ComposableSingletons$DebugNotificationsFragmentKt composableSingletons$DebugNotificationsFragmentKt = ComposableSingletons$DebugNotificationsFragmentKt.INSTANCE;
                        OutlinedTextFieldKt.OutlinedTextField(valueOf, (Function1) rememberedValue2, m94width3ABfNKs, false, false, null, composableSingletons$DebugNotificationsFragmentKt.m851getLambda1$secondo_kronabyRelease(), null, null, null, false, null, keyboardOptions, null, false, 0, 0, null, null, null, composer2, 1573296, 384, 1044408);
                        ComposeContent$lambda$22 = DebugNotificationsFragment.ComposeContent$lambda$2(mutableState4);
                        String app2 = ComposeContent$lambda$22.getTitle().app();
                        if (((double) 1.0f) > 0.0d) {
                            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                            companion.then(layoutWeightElement);
                            composer2.startReplaceableGroup(107594730);
                            Object rememberedValue3 = composer2.rememberedValue();
                            if (rememberedValue3 == obj) {
                                mutableState2 = mutableState4;
                                rememberedValue3 = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                        invoke2(str);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String it) {
                                        PhoneNotification ComposeContent$lambda$24;
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        MutableState<PhoneNotification> mutableState5 = mutableState2;
                                        ComposeContent$lambda$24 = DebugNotificationsFragment.ComposeContent$lambda$2(mutableState5);
                                        mutableState5.setValue(PhoneNotification.m1082copyuy536eg$default(ComposeContent$lambda$24, 0, null, StringsExtensionsKt.m1571static(it), null, null, 0, null, null, 251, null));
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue3);
                            } else {
                                mutableState2 = mutableState4;
                            }
                            composer2.endReplaceableGroup();
                            MutableState<PhoneNotification> mutableState5 = mutableState2;
                            OutlinedTextFieldKt.OutlinedTextField(app2, (Function1) rememberedValue3, layoutWeightElement, false, false, null, composableSingletons$DebugNotificationsFragmentKt.m852getLambda2$secondo_kronabyRelease(), null, null, null, false, null, null, null, false, 0, 0, null, null, null, composer2, 1572912, 0, 1048504);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            ComposeContent$lambda$23 = DebugNotificationsFragment.ComposeContent$lambda$2(mutableState5);
                            String app3 = ComposeContent$lambda$23.getText().app();
                            composer2.startReplaceableGroup(1901679808);
                            Object rememberedValue4 = composer2.rememberedValue();
                            if (rememberedValue4 == obj) {
                                mutableState3 = mutableState5;
                                rememberedValue4 = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                        invoke2(str);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String it) {
                                        PhoneNotification ComposeContent$lambda$24;
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        MutableState<PhoneNotification> mutableState6 = mutableState3;
                                        ComposeContent$lambda$24 = DebugNotificationsFragment.ComposeContent$lambda$2(mutableState6);
                                        mutableState6.setValue(PhoneNotification.m1082copyuy536eg$default(ComposeContent$lambda$24, 0, null, null, StringsExtensionsKt.m1571static(it), null, 0, null, null, DeviceWriterKt.maxTransferSize, null));
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue4);
                            } else {
                                mutableState3 = mutableState5;
                            }
                            composer2.endReplaceableGroup();
                            final MutableState<PhoneNotification> mutableState6 = mutableState3;
                            OutlinedTextFieldKt.OutlinedTextField(app3, (Function1) rememberedValue4, null, false, false, null, composableSingletons$DebugNotificationsFragmentKt.m853getLambda3$secondo_kronabyRelease(), null, null, null, false, null, null, null, false, 0, 0, null, null, null, composer2, 1572912, 0, 1048508);
                            ButtonKt.Button(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$3

                                /* compiled from: DebugNotificationsFragment.kt */
                                @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$3$1", f = "DebugNotificationsFragment.kt", l = {105}, m = "invokeSuspend")
                                /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$3$1, reason: invalid class name */
                                /* loaded from: classes3.dex */
                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ MutableState<PhoneNotification> $notification$delegate;
                                    final /* synthetic */ SnapshotStateList<PhoneNotification> $sentNotifications;
                                    int label;
                                    final /* synthetic */ DebugNotificationsFragment this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public AnonymousClass1(DebugNotificationsFragment debugNotificationsFragment, SnapshotStateList<PhoneNotification> snapshotStateList, MutableState<PhoneNotification> mutableState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.this$0 = debugNotificationsFragment;
                                        this.$sentNotifications = snapshotStateList;
                                        this.$notification$delegate = mutableState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.this$0, this.$sentNotifications, this.$notification$delegate, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        PhoneNotification ComposeContent$lambda$2;
                                        Object sendAndStore;
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
                                            DebugNotificationsFragment debugNotificationsFragment = this.this$0;
                                            ComposeContent$lambda$2 = DebugNotificationsFragment.ComposeContent$lambda$2(this.$notification$delegate);
                                            SnapshotStateList<PhoneNotification> snapshotStateList = this.$sentNotifications;
                                            this.label = 1;
                                            sendAndStore = debugNotificationsFragment.sendAndStore(ComposeContent$lambda$2, snapshotStateList, this);
                                            if (sendAndStore == coroutineSingletons) {
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
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    BuildersKt.launch$default(Hashing.getLifecycleScope(DebugNotificationsFragment.this), null, null, new AnonymousClass1(DebugNotificationsFragment.this, snapshotStateList2, mutableState6, null), 3);
                                }
                            }, null, false, null, null, null, null, null, null, composableSingletons$DebugNotificationsFragmentKt.m854getLambda4$secondo_kronabyRelease(), composer2, 805306368, 510);
                            ButtonKt.Button(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$4

                                /* compiled from: DebugNotificationsFragment.kt */
                                @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$4$1", f = "DebugNotificationsFragment.kt", l = {125}, m = "invokeSuspend")
                                /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$4$1, reason: invalid class name */
                                /* loaded from: classes3.dex */
                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ MutableState<PhoneNotification> $notification$delegate;
                                    final /* synthetic */ SnapshotStateList<PhoneNotification> $sentNotifications;
                                    private /* synthetic */ Object L$0;
                                    int label;
                                    final /* synthetic */ DebugNotificationsFragment this$0;

                                    /* compiled from: DebugNotificationsFragment.kt */
                                    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$4$1$1", f = "DebugNotificationsFragment.kt", l = {113}, m = "invokeSuspend")
                                    /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$4$1$1, reason: invalid class name and collision with other inner class name */
                                    /* loaded from: classes3.dex */
                                    public static final class C00521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ MutableState<PhoneNotification> $notification$delegate;
                                        final /* synthetic */ SnapshotStateList<PhoneNotification> $sentNotifications;
                                        int label;
                                        final /* synthetic */ DebugNotificationsFragment this$0;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public C00521(DebugNotificationsFragment debugNotificationsFragment, SnapshotStateList<PhoneNotification> snapshotStateList, MutableState<PhoneNotification> mutableState, Continuation<? super C00521> continuation) {
                                            super(2, continuation);
                                            this.this$0 = debugNotificationsFragment;
                                            this.$sentNotifications = snapshotStateList;
                                            this.$notification$delegate = mutableState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C00521(this.this$0, this.$sentNotifications, this.$notification$delegate, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            PhoneNotification ComposeContent$lambda$2;
                                            Object sendAndStore;
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
                                                DebugNotificationsFragment debugNotificationsFragment = this.this$0;
                                                ComposeContent$lambda$2 = DebugNotificationsFragment.ComposeContent$lambda$2(this.$notification$delegate);
                                                SnapshotStateList<PhoneNotification> snapshotStateList = this.$sentNotifications;
                                                this.label = 1;
                                                sendAndStore = debugNotificationsFragment.sendAndStore(ComposeContent$lambda$2, snapshotStateList, this);
                                                if (sendAndStore == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C00521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }
                                    }

                                    /* compiled from: DebugNotificationsFragment.kt */
                                    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$4$1$2", f = "DebugNotificationsFragment.kt", l = {123}, m = "invokeSuspend")
                                    /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$4$1$2, reason: invalid class name */
                                    /* loaded from: classes3.dex */
                                    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ MutableState<PhoneNotification> $notification$delegate;
                                        final /* synthetic */ SnapshotStateList<PhoneNotification> $sentNotifications;
                                        int label;
                                        final /* synthetic */ DebugNotificationsFragment this$0;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public AnonymousClass2(DebugNotificationsFragment debugNotificationsFragment, SnapshotStateList<PhoneNotification> snapshotStateList, MutableState<PhoneNotification> mutableState, Continuation<? super AnonymousClass2> continuation) {
                                            super(2, continuation);
                                            this.this$0 = debugNotificationsFragment;
                                            this.$sentNotifications = snapshotStateList;
                                            this.$notification$delegate = mutableState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass2(this.this$0, this.$sentNotifications, this.$notification$delegate, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            PhoneNotification ComposeContent$lambda$2;
                                            PhoneNotification ComposeContent$lambda$22;
                                            PhoneNotification ComposeContent$lambda$23;
                                            PhoneNotification ComposeContent$lambda$24;
                                            Object sendAndStore;
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
                                                ComposeContent$lambda$2 = DebugNotificationsFragment.ComposeContent$lambda$2(this.$notification$delegate);
                                                int id = ComposeContent$lambda$2.getId() + 100;
                                                ComposeContent$lambda$22 = DebugNotificationsFragment.ComposeContent$lambda$2(this.$notification$delegate);
                                                StringBuilder sb = new StringBuilder("title 2: ");
                                                ComposeContent$lambda$23 = DebugNotificationsFragment.ComposeContent$lambda$2(this.$notification$delegate);
                                                sb.append(ComposeContent$lambda$23.getTitle().firmware());
                                                Static m1571static = StringsExtensionsKt.m1571static(sb.toString());
                                                StringBuilder sb2 = new StringBuilder("text 2: ");
                                                ComposeContent$lambda$24 = DebugNotificationsFragment.ComposeContent$lambda$2(this.$notification$delegate);
                                                sb2.append(ComposeContent$lambda$24.getText().firmware());
                                                PhoneNotification m1082copyuy536eg$default = PhoneNotification.m1082copyuy536eg$default(ComposeContent$lambda$22, id, "key2", m1571static, StringsExtensionsKt.m1571static(sb2.toString()), null, 0, null, null, 240, null);
                                                DebugNotificationsFragment debugNotificationsFragment = this.this$0;
                                                SnapshotStateList<PhoneNotification> snapshotStateList = this.$sentNotifications;
                                                this.label = 1;
                                                sendAndStore = debugNotificationsFragment.sendAndStore(m1082copyuy536eg$default, snapshotStateList, this);
                                                if (sendAndStore == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }
                                    }

                                    /* compiled from: DebugNotificationsFragment.kt */
                                    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$4$1$3", f = "DebugNotificationsFragment.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryBaseLineColorDetail}, m = "invokeSuspend")
                                    /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$4$1$3, reason: invalid class name */
                                    /* loaded from: classes3.dex */
                                    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ MutableState<PhoneNotification> $notification$delegate;
                                        final /* synthetic */ SnapshotStateList<PhoneNotification> $sentNotifications;
                                        int label;
                                        final /* synthetic */ DebugNotificationsFragment this$0;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public AnonymousClass3(DebugNotificationsFragment debugNotificationsFragment, SnapshotStateList<PhoneNotification> snapshotStateList, MutableState<PhoneNotification> mutableState, Continuation<? super AnonymousClass3> continuation) {
                                            super(2, continuation);
                                            this.this$0 = debugNotificationsFragment;
                                            this.$sentNotifications = snapshotStateList;
                                            this.$notification$delegate = mutableState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass3(this.this$0, this.$sentNotifications, this.$notification$delegate, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            PhoneNotification ComposeContent$lambda$2;
                                            PhoneNotification ComposeContent$lambda$22;
                                            PhoneNotification ComposeContent$lambda$23;
                                            PhoneNotification ComposeContent$lambda$24;
                                            Object sendAndStore;
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
                                                ComposeContent$lambda$2 = DebugNotificationsFragment.ComposeContent$lambda$2(this.$notification$delegate);
                                                int id = ComposeContent$lambda$2.getId() + 100;
                                                ComposeContent$lambda$22 = DebugNotificationsFragment.ComposeContent$lambda$2(this.$notification$delegate);
                                                StringBuilder sb = new StringBuilder("title 3: ");
                                                ComposeContent$lambda$23 = DebugNotificationsFragment.ComposeContent$lambda$2(this.$notification$delegate);
                                                sb.append(ComposeContent$lambda$23.getTitle().firmware());
                                                Static m1571static = StringsExtensionsKt.m1571static(sb.toString());
                                                StringBuilder sb2 = new StringBuilder("text 3: ");
                                                ComposeContent$lambda$24 = DebugNotificationsFragment.ComposeContent$lambda$2(this.$notification$delegate);
                                                sb2.append(ComposeContent$lambda$24.getText().firmware());
                                                PhoneNotification m1082copyuy536eg$default = PhoneNotification.m1082copyuy536eg$default(ComposeContent$lambda$22, id, "key3", m1571static, StringsExtensionsKt.m1571static(sb2.toString()), null, 0, null, null, 240, null);
                                                DebugNotificationsFragment debugNotificationsFragment = this.this$0;
                                                SnapshotStateList<PhoneNotification> snapshotStateList = this.$sentNotifications;
                                                this.label = 1;
                                                sendAndStore = debugNotificationsFragment.sendAndStore(m1082copyuy536eg$default, snapshotStateList, this);
                                                if (sendAndStore == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }
                                    }

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public AnonymousClass1(DebugNotificationsFragment debugNotificationsFragment, SnapshotStateList<PhoneNotification> snapshotStateList, MutableState<PhoneNotification> mutableState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.this$0 = debugNotificationsFragment;
                                        this.$sentNotifications = snapshotStateList;
                                        this.$notification$delegate = mutableState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$sentNotifications, this.$notification$delegate, continuation);
                                        anonymousClass1.L$0 = obj;
                                        return anonymousClass1;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        CoroutineScope coroutineScope;
                                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                        int r1 = this.label;
                                        if (r1 != 0) {
                                            if (r1 == 1) {
                                                coroutineScope = (CoroutineScope) this.L$0;
                                                ResultKt.throwOnFailure(obj);
                                            } else {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                        } else {
                                            ResultKt.throwOnFailure(obj);
                                            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                                            BuildersKt.async$default(coroutineScope2, null, new C00521(this.this$0, this.$sentNotifications, this.$notification$delegate, null), 3);
                                            BuildersKt.async$default(coroutineScope2, null, new AnonymousClass2(this.this$0, this.$sentNotifications, this.$notification$delegate, null), 3);
                                            int r12 = Duration.$r8$clinit;
                                            long duration = DurationKt.toDuration(1, DurationUnit.SECONDS);
                                            this.L$0 = coroutineScope2;
                                            this.label = 1;
                                            if (DelayKt.m1695delayVtjQ1oo(duration, this) == coroutineSingletons) {
                                                return coroutineSingletons;
                                            }
                                            coroutineScope = coroutineScope2;
                                        }
                                        BuildersKt.async$default(coroutineScope, null, new AnonymousClass3(this.this$0, this.$sentNotifications, this.$notification$delegate, null), 3);
                                        return Unit.INSTANCE;
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    BuildersKt.launch$default(Hashing.getLifecycleScope(DebugNotificationsFragment.this), null, null, new AnonymousClass1(DebugNotificationsFragment.this, snapshotStateList2, mutableState6, null), 3);
                                }
                            }, null, false, null, null, null, null, null, null, composableSingletons$DebugNotificationsFragmentKt.m855getLambda5$secondo_kronabyRelease(), composer2, 805306368, 510);
                            TextKt.m216Text4IGK_g("On watch:", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer2.consume(TypographyKt.LocalTypography)).h5, composer2, 6, 0, 65534);
                            LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Type inference failed for: r3v1, types: [com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$5$invoke$$inlined$items$default$4, kotlin.jvm.internal.Lambda] */
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    final SnapshotStateList<PhoneNotification> snapshotStateList3 = snapshotStateList2;
                                    final MutableState<PhoneNotification> mutableState7 = mutableState6;
                                    final DebugNotificationsFragment debugNotificationsFragment2 = debugNotificationsFragment;
                                    final DebugNotificationsFragment$ComposeContent$1$1$5$invoke$$inlined$items$default$1 debugNotificationsFragment$ComposeContent$1$1$5$invoke$$inlined$items$default$1 = new Function1() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$5$invoke$$inlined$items$default$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Void invoke(PhoneNotification phoneNotification) {
                                            return null;
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            return invoke((PhoneNotification) obj2);
                                        }
                                    };
                                    LazyColumn.items(snapshotStateList3.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$5$invoke$$inlined$items$default$3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                            return invoke(num.intValue());
                                        }

                                        public final Object invoke(int r3) {
                                            return Function1.this.invoke(snapshotStateList3.get(r3));
                                        }
                                    }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$5$invoke$$inlined$items$default$4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int r33, Composer composer3, int r35) {
                                            int r1;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            if ((r35 & 14) == 0) {
                                                r1 = r35 | (composer3.changed(items) ? 4 : 2);
                                            } else {
                                                r1 = r35;
                                            }
                                            if ((r35 & 112) == 0) {
                                                r1 |= composer3.changed(r33) ? 32 : 16;
                                            }
                                            if ((r1 & 731) == 146 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                                            final PhoneNotification phoneNotification = (PhoneNotification) snapshotStateList3.get(r33);
                                            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                                            Modifier m71padding3ABfNKs2 = PaddingKt.m71padding3ABfNKs(BackgroundKt.m21backgroundbw27NRU(companion2, Color.LightGray, RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(0)), 2);
                                            final MutableState mutableState8 = mutableState7;
                                            Modifier m26clickableXHw0xAI$default = ClickableKt.m26clickableXHw0xAI$default(m71padding3ABfNKs2, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$5$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public /* bridge */ /* synthetic */ Unit invoke() {
                                                    invoke2();
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2() {
                                                    mutableState8.setValue(PhoneNotification.this);
                                                }
                                            });
                                            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                                            composer3.startReplaceableGroup(693286680);
                                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, composer3);
                                            composer3.startReplaceableGroup(-1323940314);
                                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3);
                                            PersistentCompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                            ComposeUiNode.Companion.getClass();
                                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12 = ComposeUiNode.Companion.Constructor;
                                            ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m26clickableXHw0xAI$default);
                                            if (composer3.getApplier() instanceof Applier) {
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(layoutNode$Companion$Constructor$12);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                Updater.m228setimpl(composer3, rowMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                                                Updater.m228setimpl(composer3, currentCompositionLocalMap3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$12 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                                if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, composer3, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$12);
                                                }
                                                modifierMaterializerOf3.invoke((Object) new SkippableUpdater(composer3), (Object) composer3, (Object) 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                String str = "Id: " + phoneNotification.getId() + " Title: " + phoneNotification.getTitle().app();
                                                if (((double) 1.0f) > 0.0d) {
                                                    LayoutWeightElement layoutWeightElement2 = new LayoutWeightElement(1.0f, true);
                                                    companion2.then(layoutWeightElement2);
                                                    TextKt.m216Text4IGK_g(str, layoutWeightElement2, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131068);
                                                    final DebugNotificationsFragment debugNotificationsFragment3 = debugNotificationsFragment2;
                                                    final SnapshotStateList snapshotStateList4 = snapshotStateList3;
                                                    ButtonKt.Button(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$5$1$2$1

                                                        /* compiled from: DebugNotificationsFragment.kt */
                                                        @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$5$1$2$1$1", f = "DebugNotificationsFragment.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryLineColorActivity}, m = "invokeSuspend")
                                                        /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$1$1$5$1$2$1$1, reason: invalid class name */
                                                        /* loaded from: classes3.dex */
                                                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ PhoneNotification $it;
                                                            final /* synthetic */ SnapshotStateList<PhoneNotification> $sentNotifications;
                                                            int label;
                                                            final /* synthetic */ DebugNotificationsFragment this$0;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            public AnonymousClass1(DebugNotificationsFragment debugNotificationsFragment, PhoneNotification phoneNotification, SnapshotStateList<PhoneNotification> snapshotStateList, Continuation<? super AnonymousClass1> continuation) {
                                                                super(2, continuation);
                                                                this.this$0 = debugNotificationsFragment;
                                                                this.$it = phoneNotification;
                                                                this.$sentNotifications = snapshotStateList;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new AnonymousClass1(this.this$0, this.$it, this.$sentNotifications, continuation);
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
                                                                    DebugNotificationsFragment debugNotificationsFragment = this.this$0;
                                                                    PhoneNotification phoneNotification = this.$it;
                                                                    this.label = 1;
                                                                    obj = debugNotificationsFragment.removeNotification(phoneNotification, this);
                                                                    if (obj == coroutineSingletons) {
                                                                        return coroutineSingletons;
                                                                    }
                                                                }
                                                                if (((Boolean) obj).booleanValue()) {
                                                                    this.$sentNotifications.remove(this.$it);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                            }
                                                        }

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                                            invoke2();
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2() {
                                                            BuildersKt.launch$default(Hashing.getLifecycleScope(DebugNotificationsFragment.this), null, null, new AnonymousClass1(DebugNotificationsFragment.this, phoneNotification, snapshotStateList4, null), 3);
                                                        }
                                                    }, null, false, null, null, null, null, null, null, ComposableSingletons$DebugNotificationsFragmentKt.INSTANCE.m856getLambda6$secondo_kronabyRelease(), composer3, 805306368, 510);
                                                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer3);
                                                    return;
                                                }
                                                throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", 1.0f, "; must be greater than zero").toString());
                                            }
                                            ComposablesKt.invalidApplier();
                                            throw null;
                                        }
                                    }, true));
                                }
                            }, composer2, 0, 255);
                            DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                            return;
                        }
                        throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", 1.0f, "; must be greater than zero").toString());
                    }
                    ComposablesKt.invalidApplier();
                    throw null;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, 1572864, 63);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment$ComposeContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r3) {
                    DebugNotificationsFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r18 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }
}
