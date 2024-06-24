package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.info.DeviceType;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.device.WatchIO;
import com.animaconnected.watch.display.AndroidGraphicsKt;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.Dashboard;
import com.animaconnected.watch.display.RemoteApp;
import com.animaconnected.watch.display.RemoteAppImpl;
import com.animaconnected.watch.display.RemoteStopWatchTest;
import com.animaconnected.watch.display.TestDrawCommandsWatchApp;
import com.animaconnected.watch.display.TestTextWatchApp;
import com.animaconnected.watch.display.Timer;
import com.animaconnected.watch.display.WatchApp;
import com.animaconnected.watch.display.emulator.WatchEmulator;
import com.animaconnected.watch.display.view.BottomPusher;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.display.view.DisplayDefinitionKt;
import com.animaconnected.watch.display.view.Image;
import com.animaconnected.watch.display.view.Position;
import com.animaconnected.watch.display.view.Rectangle;
import com.animaconnected.watch.display.view.Text;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Kolor;
import com.animaconnected.watch.image.Kolors;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.Static;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: DebugDisplayFragment.kt */
/* loaded from: classes3.dex */
public final class DebugDisplayFragment extends BaseFragment {
    private ImageView debugDisplayImage;
    private DebugDisplayView debugDisplayView;
    private ImageView debugPicture;
    private ImageView debugPicture2;
    private final DisplayWatch displayWatch;
    private final String name;
    private ImageView pascalWatch;
    private ScrollView scrollView;
    private final List<RemoteAppImpl> testApps;
    private TextView tvComplications;
    private final List<RemoteApp> watchAppList;
    private final List<RemoteApp> watchApps;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DebugDisplayFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DebugDisplayFragment newInstance() {
            return new DebugDisplayFragment();
        }

        private Companion() {
        }
    }

    /* compiled from: DebugDisplayFragment.kt */
    /* loaded from: classes3.dex */
    public static final class ImagesApp extends RemoteAppImpl {
        public static final String TYPE = "Images";
        private final String analyticsName;
        private final Context context;
        private final Mitmap icon;
        private final AppId id;
        private Job job;
        private Mitmap mitmap;
        private final Static title;
        private final String type;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        /* compiled from: DebugDisplayFragment.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public ImagesApp(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.mitmap = GraphicsKt.emptyMitmap();
            this.type = TYPE;
            this.analyticsName = TYPE;
            this.id = AppId.DebugImages;
            this.title = StringsExtensionsKt.m1571static(TYPE);
            this.icon = GraphicsKt.emptyMitmap();
        }

        @Override // com.animaconnected.watch.behaviour.Behaviour
        public void activate(Slot slot) {
            Intrinsics.checkNotNullParameter(slot, "slot");
            super.activate(slot);
            this.job = BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new DebugDisplayFragment$ImagesApp$activate$1(this, null), 3);
        }

        @Override // com.animaconnected.watch.behaviour.Behaviour
        public void deactivated(Slot slot) {
            Intrinsics.checkNotNullParameter(slot, "slot");
            super.deactivated(slot);
            Job job = this.job;
            if (job != null) {
                job.cancel(null);
            }
        }

        @Override // com.animaconnected.watch.behaviour.Behaviour
        public String getAnalyticsName() {
            return this.analyticsName;
        }

        public final Context getContext() {
            return this.context;
        }

        @Override // com.animaconnected.watch.display.RemoteApp
        public List<Display> getDisplays() {
            return CollectionsKt__CollectionsKt.listOf(DisplayDefinitionKt.display(new Function1<Display, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$ImagesApp$getDisplays$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Display display) {
                    invoke2(display);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Display display) {
                    Intrinsics.checkNotNullParameter(display, "$this$display");
                    final DebugDisplayFragment.ImagesApp imagesApp = DebugDisplayFragment.ImagesApp.this;
                    DisplayDefinitionKt.subDisplaySafeArea(display, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$ImagesApp$getDisplays$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Rectangle rectangle) {
                            invoke2(rectangle);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Rectangle subDisplaySafeArea) {
                            Mitmap mitmap;
                            Intrinsics.checkNotNullParameter(subDisplaySafeArea, "$this$subDisplaySafeArea");
                            subDisplaySafeArea.m1114setColor1L9c4HM(Kolor.m1536boximpl(Kolor.m1537constructorimpl(Kolors.orangeRed)));
                            subDisplaySafeArea.setFill(false);
                            subDisplaySafeArea.setThickness(5);
                            mitmap = DebugDisplayFragment.ImagesApp.this.mitmap;
                            DisplayDefinitionKt.image$default(subDisplaySafeArea, 0, 0, mitmap, DebugDisplayFragment.ImagesApp.this.getType() + ":Image", new Function1<Image, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment.ImagesApp.getDisplays.1.1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Image image) {
                                    invoke2(image);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Image image) {
                                    Intrinsics.checkNotNullParameter(image, "$this$image");
                                    image.setPosition(Position.Center);
                                }
                            }, 3, (Object) null);
                        }
                    });
                    DisplayDefinitionKt.bottomPusher(display, new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$ImagesApp$getDisplays$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                            invoke2(bottomPusher);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(BottomPusher bottomPusher) {
                            Intrinsics.checkNotNullParameter(bottomPusher, "$this$bottomPusher");
                            bottomPusher.setNavCommand(-1);
                        }
                    });
                }
            }));
        }

        @Override // com.animaconnected.watch.display.WatchApp
        public Mitmap getIcon() {
            return this.icon;
        }

        @Override // com.animaconnected.watch.display.WatchApp
        public AppId getId() {
            return this.id;
        }

        @Override // com.animaconnected.watch.behaviour.Behaviour
        public String getType() {
            return this.type;
        }

        @Override // com.animaconnected.watch.display.WatchApp
        public Static getTitle() {
            return this.title;
        }
    }

    /* compiled from: DebugDisplayFragment.kt */
    /* loaded from: classes3.dex */
    public static final class LvglIcon extends RemoteAppImpl {
        public static final String TYPE = "LVGLKronabyIcon";
        private Job job;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private Mitmap mitmap = GraphicsKt.emptyMitmap();
        private final String type = TYPE;
        private final String analyticsName = TYPE;
        private final AppId id = AppId.DebugIcon;
        private final Static title = StringsExtensionsKt.m1571static(TYPE);
        private final Mitmap icon = GraphicsKt.emptyMitmap();

        /* compiled from: DebugDisplayFragment.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object getKronabyIconAsMitmap(Continuation<? super Mitmap> continuation) {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            return BuildersKt.withContext(MainDispatcherLoader.dispatcher, new DebugDisplayFragment$LvglIcon$getKronabyIconAsMitmap$2(null), continuation);
        }

        @Override // com.animaconnected.watch.behaviour.Behaviour
        public void activate(Slot slot) {
            Intrinsics.checkNotNullParameter(slot, "slot");
            super.activate(slot);
            this.job = BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new DebugDisplayFragment$LvglIcon$activate$1(this, null), 3);
        }

        @Override // com.animaconnected.watch.behaviour.Behaviour
        public void deactivated(Slot slot) {
            Intrinsics.checkNotNullParameter(slot, "slot");
            super.deactivated(slot);
            Job job = this.job;
            if (job != null) {
                job.cancel(null);
            }
        }

        @Override // com.animaconnected.watch.behaviour.Behaviour
        public String getAnalyticsName() {
            return this.analyticsName;
        }

        @Override // com.animaconnected.watch.display.RemoteApp
        public List<Display> getDisplays() {
            return CollectionsKt__CollectionsKt.listOf(DisplayDefinitionKt.display(new Function1<Display, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$LvglIcon$getDisplays$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Display display) {
                    invoke2(display);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Display display) {
                    Intrinsics.checkNotNullParameter(display, "$this$display");
                    final DebugDisplayFragment.LvglIcon lvglIcon = DebugDisplayFragment.LvglIcon.this;
                    DisplayDefinitionKt.subDisplaySafeArea(display, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$LvglIcon$getDisplays$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Rectangle rectangle) {
                            invoke2(rectangle);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Rectangle subDisplaySafeArea) {
                            Mitmap mitmap;
                            Intrinsics.checkNotNullParameter(subDisplaySafeArea, "$this$subDisplaySafeArea");
                            DisplayDefinitionKt.text$default(subDisplaySafeArea, StringsExtensionsKt.m1571static("LVGL Kronaby Icon"), DebugDisplayFragment.LvglIcon.this.getPaint().getDefault(), false, null, new Function1<Text, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment.LvglIcon.getDisplays.1.1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                                    invoke2(text);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Text text) {
                                    Intrinsics.checkNotNullParameter(text, "$this$text");
                                    text.setPosition(Position.Top);
                                }
                            }, 12, null);
                            mitmap = DebugDisplayFragment.LvglIcon.this.mitmap;
                            DisplayDefinitionKt.image$default(subDisplaySafeArea, 0, 0, mitmap, (String) null, new Function1<Image, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment.LvglIcon.getDisplays.1.1.2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Image image) {
                                    invoke2(image);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Image image) {
                                    Intrinsics.checkNotNullParameter(image, "$this$image");
                                    image.setPosition(Position.Center);
                                }
                            }, 11, (Object) null);
                        }
                    });
                    DisplayDefinitionKt.bottomPusher(display, new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$LvglIcon$getDisplays$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                            invoke2(bottomPusher);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(BottomPusher bottomPusher) {
                            Intrinsics.checkNotNullParameter(bottomPusher, "$this$bottomPusher");
                            bottomPusher.setNavCommand(-1);
                        }
                    });
                }
            }));
        }

        @Override // com.animaconnected.watch.display.WatchApp
        public Mitmap getIcon() {
            return this.icon;
        }

        @Override // com.animaconnected.watch.display.WatchApp
        public AppId getId() {
            return this.id;
        }

        @Override // com.animaconnected.watch.behaviour.Behaviour
        public String getType() {
            return this.type;
        }

        @Override // com.animaconnected.watch.display.WatchApp
        public Static getTitle() {
            return this.title;
        }
    }

    public DebugDisplayFragment() {
        boolean z;
        DeviceType deviceType = ProviderFactory.getWatch().getDeviceType();
        if (deviceType != null && deviceType.getHasDisplay()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Watch watch = ProviderFactory.getWatch().getWatch();
            Intrinsics.checkNotNull(watch, "null cannot be cast to non-null type com.animaconnected.watch.DisplayWatch");
            this.displayWatch = (DisplayWatch) watch;
            List<WatchApp> watchApps = ProviderFactory.getWatch().getBehaviours().getWatchApps();
            ArrayList arrayList = new ArrayList();
            for (Object obj : watchApps) {
                if (obj instanceof RemoteApp) {
                    arrayList.add(obj);
                }
            }
            this.watchAppList = arrayList;
            List<RemoteAppImpl> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new RemoteAppImpl[]{new Dashboard(), new Timer(), new RemoteStopWatchTest(), new TestDrawCommandsWatchApp(), new TestTextWatchApp(), new ImagesApp(KronabyApplication.Companion.getContext()), new LvglIcon()});
            this.testApps = listOf;
            this.watchApps = CollectionsKt___CollectionsKt.plus((Iterable) arrayList, (Collection) listOf);
            this.name = "DebugDisplay";
            return;
        }
        ViewKt.toast$default((Fragment) this, "Connect to display watch to debug display", false, 2, (Object) null);
        throw new IllegalArgumentException("Connect to display watch to debug display");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$lambda$0(DebugDisplayFragment this$0, WatchIO watchIO, CompoundButton compoundButton, boolean z) {
        int r1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.pascalWatch;
        if (imageView != null) {
            if (z) {
                r1 = 4;
            } else {
                r1 = 0;
            }
            imageView.setVisibility(r1);
            if (watchIO instanceof WatchEmulator) {
                DebugDisplayView debugDisplayView = this$0.debugDisplayView;
                if (debugDisplayView != null) {
                    debugDisplayView.getEmulatorDisplay().setPascalFull(z);
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("debugDisplayView");
                    throw null;
                }
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pascalWatch");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054 A[Catch: Exception -> 0x003e, TRY_LEAVE, TryCatch #0 {Exception -> 0x003e, blocks: (B:18:0x003a, B:20:0x004e, B:22:0x0054), top: B:17:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendAllData(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$sendAllData$1
            if (r0 == 0) goto L13
            r0 = r12
            com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$sendAllData$1 r0 = (com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$sendAllData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$sendAllData$1 r0 = new com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$sendAllData$1
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r12)
            goto L8e
        L2a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L32:
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r5 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment r5 = (com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment) r5
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L3e
            goto L4e
        L3e:
            r12 = move-exception
            r2 = r5
            goto L6b
        L41:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.List<com.animaconnected.watch.display.RemoteApp> r12 = r11.watchApps     // Catch: java.lang.Exception -> L69
            java.lang.Iterable r12 = (java.lang.Iterable) r12     // Catch: java.lang.Exception -> L69
            java.util.Iterator r12 = r12.iterator()     // Catch: java.lang.Exception -> L69
            r5 = r11
            r2 = r12
        L4e:
            boolean r12 = r2.hasNext()     // Catch: java.lang.Exception -> L3e
            if (r12 == 0) goto L8e
            java.lang.Object r12 = r2.next()     // Catch: java.lang.Exception -> L3e
            com.animaconnected.watch.display.RemoteApp r12 = (com.animaconnected.watch.display.RemoteApp) r12     // Catch: java.lang.Exception -> L3e
            com.animaconnected.watch.DisplayWatch r6 = r5.displayWatch     // Catch: java.lang.Exception -> L3e
            r0.L$0 = r5     // Catch: java.lang.Exception -> L3e
            r0.L$1 = r2     // Catch: java.lang.Exception -> L3e
            r0.label = r4     // Catch: java.lang.Exception -> L3e
            java.lang.Object r12 = r6.configureApp(r12, r0)     // Catch: java.lang.Exception -> L3e
            if (r12 != r1) goto L4e
            return r1
        L69:
            r12 = move-exception
            r2 = r11
        L6b:
            java.lang.String r5 = "Error"
            r6 = 0
            r8 = 0
            r9 = 10
            r10 = 0
            r4 = r2
            r7 = r12
            com.animaconnected.logger.LogKt.warn$default(r4, r5, r6, r7, r8, r9, r10)
            kotlinx.coroutines.scheduling.DefaultScheduler r4 = kotlinx.coroutines.Dispatchers.Default
            kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.internal.MainDispatcherLoader.dispatcher
            com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$sendAllData$3 r5 = new com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$sendAllData$3
            r6 = 0
            r5.<init>(r2, r12, r6)
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r0)
            if (r12 != r1) goto L8e
            return r1
        L8e:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment.sendAllData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object showApp(com.animaconnected.watch.display.RemoteApp r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$showApp$1
            if (r0 == 0) goto L13
            r0 = r13
            com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$showApp$1 r0 = (com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$showApp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$showApp$1 r0 = new com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$showApp$1
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r13)
            goto L77
        L2a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L32:
            java.lang.Object r12 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment r12 = (com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment) r12
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> L3a
            goto L77
        L3a:
            r13 = move-exception
            goto L56
        L3c:
            kotlin.ResultKt.throwOnFailure(r13)
            com.animaconnected.watch.display.VisibilityState r13 = r12.getOnStartState()     // Catch: java.lang.Exception -> L54
            com.animaconnected.watch.DisplayWatch r2 = r11.displayWatch     // Catch: java.lang.Exception -> L54
            com.animaconnected.watch.display.AppId r12 = r12.getId()     // Catch: java.lang.Exception -> L54
            r0.L$0 = r11     // Catch: java.lang.Exception -> L54
            r0.label = r4     // Catch: java.lang.Exception -> L54
            java.lang.Object r12 = r2.requestAppState(r12, r13, r0)     // Catch: java.lang.Exception -> L54
            if (r12 != r1) goto L77
            return r1
        L54:
            r13 = move-exception
            r12 = r11
        L56:
            java.lang.String r5 = "Error"
            r6 = 0
            r8 = 0
            r9 = 10
            r10 = 0
            r4 = r12
            r7 = r13
            com.animaconnected.logger.LogKt.warn$default(r4, r5, r6, r7, r8, r9, r10)
            kotlinx.coroutines.scheduling.DefaultScheduler r2 = kotlinx.coroutines.Dispatchers.Default
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.internal.MainDispatcherLoader.dispatcher
            com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$showApp$2 r4 = new com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$showApp$2
            r5 = 0
            r4.<init>(r12, r13, r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r12 != r1) goto L77
            return r1
        L77:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment.showApp(com.animaconnected.watch.display.RemoteApp, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Object obj;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugDisplayFragment$onCreateView$1(this, null), 3);
        View inflate = inflater.inflate(R.layout.fragment_debug_display, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.debug_display_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.debugDisplayView = (DebugDisplayView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.debug_display_image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.debugDisplayImage = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.debug_picture);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.debugPicture = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.debug_picture2);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.debugPicture2 = (ImageView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.tv_complications);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.tvComplications = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.scrollView_debug_display);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.scrollView = (ScrollView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.img_debug_pascal_watch);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.pascalWatch = (ImageView) findViewById7;
        DebugDisplayView debugDisplayView = this.debugDisplayView;
        if (debugDisplayView != null) {
            debugDisplayView.setPixelSize(390, 390);
            View findViewById8 = inflate.findViewById(R.id.edit_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
            onClick(findViewById8, new DebugDisplayFragment$onCreateView$2$1(null));
            final WatchIO io2 = this.displayWatch.getIo();
            if (io2 instanceof WatchEmulator) {
                WatchEmulator watchEmulator = (WatchEmulator) io2;
                DebugDisplayView debugDisplayView2 = this.debugDisplayView;
                if (debugDisplayView2 != null) {
                    watchEmulator.addDisplay(debugDisplayView2.getEmulatorDisplay());
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("debugDisplayView");
                    throw null;
                }
            }
            ((SwitchCompat) inflate.findViewById(R.id.show_overlay)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    DebugDisplayFragment.onCreateView$lambda$5$lambda$0(DebugDisplayFragment.this, io2, compoundButton, z);
                }
            });
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.debug_display_layout);
            Iterator<T> it = this.watchApps.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((RemoteApp) obj) instanceof TestDrawCommandsWatchApp) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            RemoteApp remoteApp = (RemoteApp) obj;
            if (remoteApp != null) {
                InputStream open = inflate.getResources().getAssets().open("watch/img.png");
                Intrinsics.checkNotNullExpressionValue(open, "open(...)");
                byte[] readBytes = ByteStreamsKt.readBytes(open);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(readBytes, 0, readBytes.length);
                Intrinsics.checkNotNull(decodeByteArray);
                ((TestDrawCommandsWatchApp) remoteApp).setMitmap(AndroidGraphicsKt.toMitmap$default(decodeByteArray, null, 1, null));
            }
            for (RemoteApp remoteApp2 : this.watchApps) {
                Button button = new Button(inflate.getContext(), null, R.attr.settingsButtonOutline);
                button.setText(remoteApp2.getTitle().app());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = 8;
                button.setLayoutParams(layoutParams);
                onClick(button, new DebugDisplayFragment$onCreateView$2$5$btn$1$1(this, remoteApp2, null));
                linearLayout.addView(button);
            }
            return inflate;
        }
        Intrinsics.throwUninitializedPropertyAccessException("debugDisplayView");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Iterator<T> it = this.watchApps.iterator();
        while (it.hasNext()) {
            ((RemoteApp) it.next()).deactivated(Slot.Display);
        }
    }
}
