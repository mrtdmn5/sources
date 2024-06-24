package com.animaconnected.watch;

import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.logger.LogKt;
import com.animaconnected.msgpack.MsgPackCreator;
import com.animaconnected.watch.account.profile.ProfileProvider;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.Command;
import com.animaconnected.watch.device.DfuUiState;
import com.animaconnected.watch.device.FileResult;
import com.animaconnected.watch.device.WatchIO;
import com.animaconnected.watch.device.WatchStyle;
import com.animaconnected.watch.device.files.WatchFileSystem;
import com.animaconnected.watch.display.DisplayType;
import com.animaconnected.watch.display.RemoteApp;
import com.animaconnected.watch.display.ResourceSynchronizer;
import com.animaconnected.watch.display.WatchApp;
import com.animaconnected.watch.filter.FilterSettings;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.provider.demo.DemoModeProvider;
import com.animaconnected.watch.provider.preferences.PreferenceProvider;
import com.animaconnected.watch.storage.WatchDb;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayWatch.kt */
/* loaded from: classes3.dex */
public final class DisplayWatch extends Watch {
    private final DemoModeProvider demoModeProvider;
    private final DisplayType displayType;
    private final FilterSettings filterSettings;
    private WatchFileSystem fs;
    private final String lastFitnessResultTsKey;
    private boolean manualGcRequested;
    private final PreferenceProvider preferences;
    private final ProfileProvider profileProvider;
    private final WatchStyle style;
    private final String tagEditableFiles;

    /* compiled from: DisplayWatch.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[DeviceType.values().length];
            try {
                r0[DeviceType.PASCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[DeviceType.PASCAL_FULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[FileResult.values().length];
            try {
                r02[FileResult.OkAlreadyExists.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r02[FileResult.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayWatch(BasicStorage storage, String identifier, String str, DeviceType watchType, FirmwareVariant firmwareVariant, MsgPackCreator msgPackCreator, ResourceSynchronizer resourceSynchronizer, WatchDb watchDb, FitnessQueries fitnessQueries, DeviceDataSync deviceDataSync, Function1<? super Continuation<? super Unit>, ? extends Object> syncSuspend, Behaviours behaviours, ProfileProvider profileProvider, FilterSettings filterSettings, DemoModeProvider demoModeProvider, PreferenceProvider preferences, WatchStyle style) {
        super(storage, identifier, str, watchType, firmwareVariant, fitnessQueries, msgPackCreator, resourceSynchronizer, watchDb, deviceDataSync, syncSuspend, behaviours, null);
        DisplayType displayType;
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(watchType, "watchType");
        Intrinsics.checkNotNullParameter(firmwareVariant, "firmwareVariant");
        Intrinsics.checkNotNullParameter(msgPackCreator, "msgPackCreator");
        Intrinsics.checkNotNullParameter(resourceSynchronizer, "resourceSynchronizer");
        Intrinsics.checkNotNullParameter(watchDb, "watchDb");
        Intrinsics.checkNotNullParameter(fitnessQueries, "fitnessQueries");
        Intrinsics.checkNotNullParameter(deviceDataSync, "deviceDataSync");
        Intrinsics.checkNotNullParameter(syncSuspend, "syncSuspend");
        Intrinsics.checkNotNullParameter(behaviours, "behaviours");
        Intrinsics.checkNotNullParameter(profileProvider, "profileProvider");
        Intrinsics.checkNotNullParameter(filterSettings, "filterSettings");
        Intrinsics.checkNotNullParameter(demoModeProvider, "demoModeProvider");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(style, "style");
        this.profileProvider = profileProvider;
        this.filterSettings = filterSettings;
        this.demoModeProvider = demoModeProvider;
        this.preferences = preferences;
        this.style = style;
        int r1 = WhenMappings.$EnumSwitchMapping$0[watchType.ordinal()];
        if (r1 == 1) {
            displayType = DisplayType.Sub;
        } else if (r1 != 2) {
            displayType = DisplayType.Sub;
        } else {
            displayType = DisplayType.Full;
        }
        this.displayType = displayType;
        this.lastFitnessResultTsKey = "lastFitnessResultTsKey";
        this.tagEditableFiles = "EditableFiles";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handleFileChange(final com.animaconnected.watch.device.files.WatchFile r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.animaconnected.watch.DisplayWatch$handleFileChange$1
            if (r0 == 0) goto L13
            r0 = r14
            com.animaconnected.watch.DisplayWatch$handleFileChange$1 r0 = (com.animaconnected.watch.DisplayWatch$handleFileChange$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.DisplayWatch$handleFileChange$1 r0 = new com.animaconnected.watch.DisplayWatch$handleFileChange$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r13 = r0.L$2
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r2 = r0.L$1
            com.animaconnected.watch.device.files.WatchFile r2 = (com.animaconnected.watch.device.files.WatchFile) r2
            java.lang.Object r4 = r0.L$0
            com.animaconnected.watch.DisplayWatch r4 = (com.animaconnected.watch.DisplayWatch) r4
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = r2
            goto L77
        L34:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3c:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.String r5 = r12.tagEditableFiles
            r6 = 0
            r7 = 0
            com.animaconnected.watch.DisplayWatch$handleFileChange$2 r8 = new com.animaconnected.watch.DisplayWatch$handleFileChange$2
            r8.<init>()
            r9 = 6
            r10 = 0
            r4 = r12
            com.animaconnected.logger.LogKt.debug$default(r4, r5, r6, r7, r8, r9, r10)
            java.util.List r14 = r12.getApps$watch_release()
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r14 = r14.iterator()
        L5d:
            boolean r4 = r14.hasNext()
            if (r4 == 0) goto L6f
            java.lang.Object r4 = r14.next()
            boolean r5 = r4 instanceof com.animaconnected.watch.display.FirmwareApp
            if (r5 == 0) goto L5d
            r2.add(r4)
            goto L5d
        L6f:
            java.util.Iterator r14 = r2.iterator()
            r4 = r12
            r11 = r14
            r14 = r13
            r13 = r11
        L77:
            boolean r2 = r13.hasNext()
            if (r2 == 0) goto L92
            java.lang.Object r2 = r13.next()
            com.animaconnected.watch.display.FirmwareApp r2 = (com.animaconnected.watch.display.FirmwareApp) r2
            r0.L$0 = r4
            r0.L$1 = r14
            r0.L$2 = r13
            r0.label = r3
            java.lang.Object r2 = r2.onWatchFileChange(r14, r4, r0)
            if (r2 != r1) goto L77
            return r1
        L92:
            com.animaconnected.watch.display.ResourceSynchronizer r13 = r4.getResourceSynchronizer$watch_release()
            java.lang.String r0 = r4.getIdentifier()
            r13.setFileSynced(r0, r14)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.handleFileChange(com.animaconnected.watch.device.files.WatchFile, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0023. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x025a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x021e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x018d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0174 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0139 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initDirectories(com.animaconnected.watch.device.files.WatchFileSystem r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.initDirectories(com.animaconnected.watch.device.files.WatchFileSystem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x02cd, code lost:            com.animaconnected.logger.LogKt.debug$default((java.lang.Object) r2, r2.tagEditableFiles, (java.lang.Throwable) null, false, (kotlin.jvm.functions.Function0) new com.animaconnected.watch.DisplayWatch$initEditableFiles$3$1$3(r3, r5), 6, (java.lang.Object) null);        r8.L$0 = r2;        r8.L$1 = r4;        r8.L$2 = r1;        r8.L$3 = r0;        r8.L$4 = null;        r8.label = 3;        r3 = r4.readFile(r3, r8);     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x02f7, code lost:            if (r3 != r9) goto L99;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x02f9, code lost:            return r9;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x02fa, code lost:            r28 = r1;        r1 = r0;        r0 = r3;        r3 = r4;        r4 = r2;        r2 = r28;     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0324  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0316 -> B:13:0x0319). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0249 -> B:14:0x0253). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initEditableFiles(com.animaconnected.watch.device.files.WatchFileSystem r31, kotlin.coroutines.Continuation<? super kotlin.Unit> r32) {
        /*
            Method dump skipped, instructions count: 807
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.initEditableFiles(com.animaconnected.watch.device.files.WatchFileSystem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object removeApp(int r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.DisplayWatch$removeApp$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.DisplayWatch$removeApp$1 r0 = (com.animaconnected.watch.DisplayWatch$removeApp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.DisplayWatch$removeApp$1 r0 = new com.animaconnected.watch.DisplayWatch$removeApp$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3f
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r6)
            com.animaconnected.watch.device.files.WatchFileSystem r6 = r4.fs
            if (r6 == 0) goto L42
            r0.label = r3
            java.lang.Object r6 = r6.deleteAppInfo(r5, r0)
            if (r6 != r1) goto L3f
            return r1
        L3f:
            com.animaconnected.watch.device.FileResult r6 = (com.animaconnected.watch.device.FileResult) r6
            goto L43
        L42:
            r6 = 0
        L43:
            com.animaconnected.watch.device.FileResult r5 = com.animaconnected.watch.device.FileResult.OK
            if (r6 != r5) goto L48
            goto L49
        L48:
            r3 = 0
        L49:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.removeApp(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object removeFile(com.animaconnected.watch.device.files.WatchFileSystem r21, com.animaconnected.watch.device.files.FileDescriptor r22, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.files.FileDescriptor> r23) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.removeFile(com.animaconnected.watch.device.files.WatchFileSystem, com.animaconnected.watch.device.files.FileDescriptor, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x025e -> B:11:0x0264). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x01e7 -> B:12:0x020e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x012e -> B:38:0x0135). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object removeUnusedFiles(java.util.List<com.animaconnected.watch.device.files.FileDescriptor> r29, com.animaconnected.watch.device.files.WatchFileSystem r30, boolean r31, kotlin.coroutines.Continuation<? super java.util.List<com.animaconnected.watch.device.files.FileDescriptor>> r32) {
        /*
            Method dump skipped, instructions count: 681
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.removeUnusedFiles(java.util.List, com.animaconnected.watch.device.files.WatchFileSystem, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object removeUnusedFiles$default(DisplayWatch displayWatch, List list, WatchFileSystem watchFileSystem, boolean z, Continuation continuation, int r5, Object obj) {
        if ((r5 & 4) != 0) {
            z = false;
        }
        return displayWatch.removeUnusedFiles(list, watchFileSystem, z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0026. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0422 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x062f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0677 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0678  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02f5 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v38, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x0423 -> B:63:0x042d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0624 -> B:19:0x0627). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x058f -> B:33:0x0590). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x04ec -> B:51:0x04f9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x02ef -> B:76:0x02f2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncApp(com.animaconnected.watch.display.WatchApp r34, com.animaconnected.watch.device.files.WatchFileSystem r35, kotlin.coroutines.Continuation<? super java.util.List<com.animaconnected.watch.device.files.FileDescriptor>> r36) {
        /*
            Method dump skipped, instructions count: 1704
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncApp(com.animaconnected.watch.display.WatchApp, com.animaconnected.watch.device.files.WatchFileSystem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e3 A[LOOP:1: B:21:0x00dd->B:23:0x00e3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncAppIds(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncAppIds(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0191 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncAppInfo(final com.animaconnected.watch.display.WatchApp r21, kotlin.coroutines.Continuation<? super java.util.List<com.animaconnected.watch.device.files.FileDescriptor>> r22) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncAppInfo(com.animaconnected.watch.display.WatchApp, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x007f -> B:10:0x0082). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncApps(com.animaconnected.watch.device.files.WatchFileSystem r9, kotlin.coroutines.Continuation<? super java.util.List<com.animaconnected.watch.device.files.FileDescriptor>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.DisplayWatch$syncApps$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.DisplayWatch$syncApps$1 r0 = (com.animaconnected.watch.DisplayWatch$syncApps$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.DisplayWatch$syncApps$1 r0 = new com.animaconnected.watch.DisplayWatch$syncApps$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r9 = r0.L$4
            java.util.Collection r9 = (java.util.Collection) r9
            java.lang.Object r2 = r0.L$3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$2
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Object r5 = r0.L$1
            com.animaconnected.watch.device.files.WatchFileSystem r5 = (com.animaconnected.watch.device.files.WatchFileSystem) r5
            java.lang.Object r6 = r0.L$0
            com.animaconnected.watch.DisplayWatch r6 = (com.animaconnected.watch.DisplayWatch) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L82
        L3b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L43:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.List r10 = r8.getApps$watch_release()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r10, r4)
            r2.<init>(r4)
            java.util.Iterator r10 = r10.iterator()
            r6 = r8
            r7 = r10
            r10 = r9
            r9 = r2
            r2 = r7
        L60:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L8a
            java.lang.Object r4 = r2.next()
            com.animaconnected.watch.display.WatchApp r4 = (com.animaconnected.watch.display.WatchApp) r4
            r0.L$0 = r6
            r0.L$1 = r10
            r0.L$2 = r9
            r0.L$3 = r2
            r0.L$4 = r9
            r0.label = r3
            java.lang.Object r4 = r6.syncApp(r4, r10, r0)
            if (r4 != r1) goto L7f
            return r1
        L7f:
            r5 = r10
            r10 = r4
            r4 = r9
        L82:
            java.util.List r10 = (java.util.List) r10
            r9.add(r10)
            r9 = r4
            r10 = r5
            goto L60
        L8a:
            java.util.List r9 = (java.util.List) r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r9 = kotlin.collections.CollectionsKt__IteratorsJVMKt.flatten(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncApps(com.animaconnected.watch.device.files.WatchFileSystem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncDailyGoals(kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncDailyGoals(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0088 A[Catch: Exception -> 0x0033, TryCatch #1 {Exception -> 0x0033, blocks: (B:11:0x002f, B:12:0x007f, B:14:0x0088, B:17:0x008b), top: B:10:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b A[Catch: Exception -> 0x0033, TRY_LEAVE, TryCatch #1 {Exception -> 0x0033, blocks: (B:11:0x002f, B:12:0x007f, B:14:0x0088, B:17:0x008b), top: B:10:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncDemoMode(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r12 = this;
            java.lang.String r0 = "Synced demo mode: "
            boolean r1 = r13 instanceof com.animaconnected.watch.DisplayWatch$syncDemoMode$1
            if (r1 == 0) goto L15
            r1 = r13
            com.animaconnected.watch.DisplayWatch$syncDemoMode$1 r1 = (com.animaconnected.watch.DisplayWatch$syncDemoMode$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.animaconnected.watch.DisplayWatch$syncDemoMode$1 r1 = new com.animaconnected.watch.DisplayWatch$syncDemoMode$1
            r1.<init>(r12, r13)
        L1a:
            java.lang.Object r13 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            java.lang.String r4 = "demo_mode"
            r5 = 1
            if (r3 == 0) goto L40
            if (r3 != r5) goto L38
            int r2 = r1.I$1
            int r3 = r1.I$0
            java.lang.Object r1 = r1.L$0
            com.animaconnected.watch.DisplayWatch r1 = (com.animaconnected.watch.DisplayWatch) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> L33
            goto L7f
        L33:
            r13 = move-exception
            r3 = r13
            r0 = r1
            goto Lb8
        L38:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L40:
            kotlin.ResultKt.throwOnFailure(r13)
            com.animaconnected.watch.provider.demo.DemoModeProvider r13 = r12.demoModeProvider
            com.animaconnected.watch.provider.demo.DemoMode r13 = r13.getCurrentDemoMode()
            com.animaconnected.watch.provider.demo.WatchDemoMode r13 = r13.watchDemoModeToSync()
            if (r13 != 0) goto L52
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L52:
            int r3 = r13.getMode()
            int r13 = java.lang.Integer.hashCode(r3)
            com.animaconnected.watch.display.ResourceSynchronizer r6 = r12.getResourceSynchronizer$watch_release()
            java.lang.String r7 = r12.getIdentifier()
            boolean r6 = r6.isConfigSynced(r7, r4, r13)
            if (r6 != 0) goto Lc2
            com.animaconnected.watch.device.WatchIO r6 = r12.getIo()     // Catch: java.lang.Exception -> Lb5
            if (r6 == 0) goto L82
            r1.L$0 = r12     // Catch: java.lang.Exception -> Lb5
            r1.I$0 = r3     // Catch: java.lang.Exception -> Lb5
            r1.I$1 = r13     // Catch: java.lang.Exception -> Lb5
            r1.label = r5     // Catch: java.lang.Exception -> Lb5
            java.lang.Object r1 = r6.writeDemoMode(r3, r1)     // Catch: java.lang.Exception -> Lb5
            if (r1 != r2) goto L7d
            return r2
        L7d:
            r1 = r12
            r2 = r13
        L7f:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L33
            goto L86
        L82:
            r1 = 0
            r2 = r13
            r13 = r1
            r1 = r12
        L86:
            if (r13 != 0) goto L8b
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L33
            return r13
        L8b:
            com.animaconnected.watch.display.ResourceSynchronizer r13 = r1.getResourceSynchronizer$watch_release()     // Catch: java.lang.Exception -> L33
            java.lang.String r5 = r1.getIdentifier()     // Catch: java.lang.Exception -> L33
            r13.setConfigSynced(r5, r4, r2)     // Catch: java.lang.Exception -> L33
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L33
            r13.<init>(r0)     // Catch: java.lang.Exception -> L33
            r13.append(r3)     // Catch: java.lang.Exception -> L33
            java.lang.String r0 = " | hash: "
            r13.append(r0)     // Catch: java.lang.Exception -> L33
            r13.append(r2)     // Catch: java.lang.Exception -> L33
            java.lang.String r6 = r13.toString()     // Catch: java.lang.Exception -> L33
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 14
            r11 = 0
            r5 = r1
            com.animaconnected.logger.LogKt.verbose$default(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L33
            goto Lc2
        Lb5:
            r13 = move-exception
            r0 = r12
            r3 = r13
        Lb8:
            java.lang.String r1 = "Failed to sync demo mode"
            r2 = 0
            r4 = 0
            r5 = 10
            r6 = 0
            com.animaconnected.logger.LogKt.verbose$default(r0, r1, r2, r3, r4, r5, r6)
        Lc2:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncDemoMode(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object syncDone(final Set<? extends SyncFlags> set, Continuation<? super Unit> continuation) {
        WatchIO io2;
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.DisplayWatch$syncDone$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "syncDone with flags: " + set;
            }
        }, 7, (Object) null);
        if ((!set.isEmpty()) && (io2 = getIo()) != null) {
            Object writeSyncDone = io2.writeSyncDone(set, continuation);
            if (writeSyncDone == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return writeSyncDone;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncFitnessConfig(kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncFitnessConfig(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00c1 -> B:10:0x00c4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncFlashStrings(com.animaconnected.watch.device.files.WatchFileSystem r13, kotlin.coroutines.Continuation<? super java.util.List<com.animaconnected.watch.device.files.FileDescriptor>> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.animaconnected.watch.DisplayWatch$syncFlashStrings$1
            if (r0 == 0) goto L13
            r0 = r14
            com.animaconnected.watch.DisplayWatch$syncFlashStrings$1 r0 = (com.animaconnected.watch.DisplayWatch$syncFlashStrings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.DisplayWatch$syncFlashStrings$1 r0 = new com.animaconnected.watch.DisplayWatch$syncFlashStrings$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            long r4 = r0.J$0
            java.lang.Object r13 = r0.L$4
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r2 = r0.L$3
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r6 = r0.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.L$1
            com.animaconnected.watch.device.files.WatchFileSystem r7 = (com.animaconnected.watch.device.files.WatchFileSystem) r7
            java.lang.Object r8 = r0.L$0
            com.animaconnected.watch.DisplayWatch r8 = (com.animaconnected.watch.DisplayWatch) r8
            kotlin.ResultKt.throwOnFailure(r14)
            goto Lc4
        L3e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L46:
            kotlin.ResultKt.throwOnFailure(r14)
            com.animaconnected.logger.MeasurementBackend r14 = com.animaconnected.logger.MeasurementBackendKt.getMeasurementBackend()
            r2 = 0
            if (r14 == 0) goto L56
            java.lang.String r4 = "syncFlashStrings"
            java.lang.String r2 = r14.begin(r4, r2)
        L56:
            long r4 = kotlin.time.MonotonicTimeSource.read()
            kotlin.enums.EnumEntries r14 = com.animaconnected.watch.strings.Key.getEntries()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r14 = r14.iterator()
        L67:
            boolean r7 = r14.hasNext()
            if (r7 == 0) goto L7e
            java.lang.Object r7 = r14.next()
            r8 = r7
            com.animaconnected.watch.strings.Key r8 = (com.animaconnected.watch.strings.Key) r8
            boolean r8 = r8.getFirmware()
            if (r8 == 0) goto L67
            r6.add(r7)
            goto L67
        L7e:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Iterator r6 = r6.iterator()
            r8 = r12
            r11 = r14
            r14 = r13
            r13 = r6
            r6 = r2
            r2 = r11
        L8d:
            boolean r7 = r13.hasNext()
            if (r7 == 0) goto Lcd
            java.lang.Object r7 = r13.next()
            com.animaconnected.watch.strings.Key r7 = (com.animaconnected.watch.strings.Key) r7
            java.lang.String r9 = r7.name()
            r10 = 20
            java.lang.String r9 = kotlin.text.StringsKt___StringsKt.take(r10, r9)
            com.animaconnected.watch.display.FlashString r10 = new com.animaconnected.watch.display.FlashString
            java.lang.String r7 = com.animaconnected.watch.strings.StringsExtensionsKt.getFirmwareString(r7)
            r10.<init>(r7)
            r0.L$0 = r8
            r0.L$1 = r14
            r0.L$2 = r6
            r0.L$3 = r2
            r0.L$4 = r13
            r0.J$0 = r4
            r0.label = r3
            java.lang.Object r7 = r8.syncText$watch_release(r14, r9, r10, r0)
            if (r7 != r1) goto Lc1
            return r1
        Lc1:
            r11 = r7
            r7 = r14
            r14 = r11
        Lc4:
            com.animaconnected.watch.device.files.FileDescriptor r14 = (com.animaconnected.watch.device.files.FileDescriptor) r14
            if (r14 == 0) goto Lcb
            r2.add(r14)
        Lcb:
            r14 = r7
            goto L8d
        Lcd:
            java.util.List r2 = (java.util.List) r2
            kotlin.time.TimeSource.Monotonic.ValueTimeMark.m1693elapsedNowUwyO8pc(r4)
            if (r6 == 0) goto Ldd
            com.animaconnected.logger.MeasurementBackend r13 = com.animaconnected.logger.MeasurementBackendKt.getMeasurementBackend()
            if (r13 == 0) goto Ldd
            r13.end(r6)
        Ldd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncFlashStrings(com.animaconnected.watch.device.files.WatchFileSystem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncNotifications(com.animaconnected.watch.device.files.WatchFileSystem r16, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.files.FileDescriptor> r17) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncNotifications(com.animaconnected.watch.device.files.WatchFileSystem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object syncPicture$watch_release$default(DisplayWatch displayWatch, WatchFileSystem watchFileSystem, String str, String str2, byte[] bArr, boolean z, Continuation continuation, int r14, Object obj) {
        if ((r14 & 8) != 0) {
            z = false;
        }
        return displayWatch.syncPicture$watch_release(watchFileSystem, str, str2, bArr, z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncTheme(kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncTheme(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncView(final com.animaconnected.watch.display.RemoteApp r19, final int r20, java.util.List<? extends com.animaconnected.watch.display.DrawCommand> r21, com.animaconnected.watch.device.files.WatchFileSystem r22, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.files.FileDescriptor> r23) {
        /*
            r18 = this;
            r7 = r18
            r8 = r20
            r0 = r21
            r9 = r22
            r1 = r23
            boolean r2 = r1 instanceof com.animaconnected.watch.DisplayWatch$syncView$1
            if (r2 == 0) goto L1d
            r2 = r1
            com.animaconnected.watch.DisplayWatch$syncView$1 r2 = (com.animaconnected.watch.DisplayWatch$syncView$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L1d
            int r3 = r3 - r4
            r2.label = r3
            goto L22
        L1d:
            com.animaconnected.watch.DisplayWatch$syncView$1 r2 = new com.animaconnected.watch.DisplayWatch$syncView$1
            r2.<init>(r7, r1)
        L22:
            r10 = r2
            java.lang.Object r1 = r10.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r11 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r10.label
            r12 = 1
            if (r2 == 0) goto L41
            if (r2 != r12) goto L39
            long r2 = r10.J$0
            java.lang.Object r0 = r10.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto Lcd
        L39:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L41:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "app.id="
            r1.<init>(r2)
            com.animaconnected.watch.display.AppId r2 = r19.getId()
            r1.append(r2)
            java.lang.String r2 = ", app.title="
            r1.append(r2)
            com.animaconnected.watch.strings.KeyString r2 = r19.getTitle()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.animaconnected.logger.MeasurementBackend r2 = com.animaconnected.logger.MeasurementBackendKt.getMeasurementBackend()
            if (r2 == 0) goto L6f
            java.lang.String r3 = "syncView"
            java.lang.String r1 = r2.begin(r3, r1)
            goto L70
        L6f:
            r1 = 0
        L70:
            r13 = r1
            long r14 = kotlin.time.MonotonicTimeSource.read()
            com.animaconnected.watch.WatchAppValidator r1 = com.animaconnected.watch.WatchAppValidator.INSTANCE
            r1.validateDrawCommands(r0)
            com.animaconnected.msgpack.MsgPackCreator r1 = r18.getMsgPackCreator$watch_release()
            byte[] r6 = com.animaconnected.watch.device.DisplayDefinitionParserKt.toBytes(r0, r1)
            java.lang.String r1 = r18.getTag$watch_release()
            r2 = 0
            r3 = 0
            com.animaconnected.watch.DisplayWatch$syncView$2$1 r4 = new com.animaconnected.watch.DisplayWatch$syncView$2$1
            r5 = r19
            r4.<init>()
            r16 = 6
            r17 = 0
            r0 = r18
            r5 = r16
            r12 = r6
            r6 = r17
            com.animaconnected.logger.LogKt.verbose$default(r0, r1, r2, r3, r4, r5, r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.animaconnected.watch.display.AppId r1 = r19.getId()
            int r1 = r1.getCode()
            r0.append(r1)
            r1 = 58
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.animaconnected.watch.device.files.WatchFile r0 = r9.makeViewFile(r0, r12)
            r10.L$0 = r13
            r10.J$0 = r14
            r1 = 1
            r10.label = r1
            java.lang.Object r1 = r7.syncFile(r9, r0, r10)
            if (r1 != r11) goto Lcb
            return r11
        Lcb:
            r0 = r13
            r2 = r14
        Lcd:
            com.animaconnected.watch.device.files.FileDescriptor r1 = (com.animaconnected.watch.device.files.FileDescriptor) r1
            kotlin.time.TimeSource.Monotonic.ValueTimeMark.m1693elapsedNowUwyO8pc(r2)
            if (r0 == 0) goto Ldd
            com.animaconnected.logger.MeasurementBackend r2 = com.animaconnected.logger.MeasurementBackendKt.getMeasurementBackend()
            if (r2 == 0) goto Ldd
            r2.end(r0)
        Ldd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncView(com.animaconnected.watch.display.RemoteApp, int, java.util.List, com.animaconnected.watch.device.files.WatchFileSystem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object changeView(com.animaconnected.watch.display.RemoteApp r10, int r11, com.animaconnected.watch.device.WatchAppAnimation r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.animaconnected.watch.DisplayWatch$changeView$1
            if (r0 == 0) goto L13
            r0 = r13
            com.animaconnected.watch.DisplayWatch$changeView$1 r0 = (com.animaconnected.watch.DisplayWatch$changeView$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.DisplayWatch$changeView$1 r0 = new com.animaconnected.watch.DisplayWatch$changeView$1
            r0.<init>(r9, r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r10 = r0.L$0
            com.animaconnected.watch.DisplayWatch r10 = (com.animaconnected.watch.DisplayWatch) r10
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> L2b
            goto L60
        L2b:
            r2 = r10
            goto L56
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            kotlin.ResultKt.throwOnFailure(r13)
            com.animaconnected.watch.device.WatchIO r13 = r9.getIo()     // Catch: java.lang.Exception -> L55
            if (r13 == 0) goto L60
            com.animaconnected.watch.display.AppId r10 = r10.getId()     // Catch: java.lang.Exception -> L55
            int r10 = r10.getCode()     // Catch: java.lang.Exception -> L55
            int r12 = r12.getId()     // Catch: java.lang.Exception -> L55
            r0.L$0 = r9     // Catch: java.lang.Exception -> L55
            r0.label = r3     // Catch: java.lang.Exception -> L55
            java.lang.Object r10 = r13.writeChangeView(r10, r11, r12, r0)     // Catch: java.lang.Exception -> L55
            if (r10 != r1) goto L60
            return r1
        L55:
            r2 = r9
        L56:
            r3 = 0
            r4 = 0
            r5 = 0
            com.animaconnected.watch.DisplayWatch$changeView$2 r6 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.DisplayWatch$changeView$2
                static {
                    /*
                        com.animaconnected.watch.DisplayWatch$changeView$2 r0 = new com.animaconnected.watch.DisplayWatch$changeView$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.DisplayWatch$changeView$2) com.animaconnected.watch.DisplayWatch$changeView$2.INSTANCE com.animaconnected.watch.DisplayWatch$changeView$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch$changeView$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch$changeView$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Failed to changeView"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch$changeView$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch$changeView$2.invoke():java.lang.Object");
                }
            }
            r7 = 7
            r8 = 0
            com.animaconnected.logger.LogKt.verbose$default(r2, r3, r4, r5, r6, r7, r8)
        L60:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.changeView(com.animaconnected.watch.display.RemoteApp, int, com.animaconnected.watch.device.WatchAppAnimation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object configureApp(final WatchApp watchApp, Continuation<? super Unit> continuation) {
        WatchFileSystem watchFileSystem = this.fs;
        if (watchFileSystem == null) {
            return Unit.INSTANCE;
        }
        if (getApps$watch_release().contains(watchApp)) {
            Object syncApp = syncApp(watchApp, watchFileSystem, continuation);
            if (syncApp == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return syncApp;
            }
            return Unit.INSTANCE;
        }
        LogKt.warn$default((Object) this, getTag$watch_release(), (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.DisplayWatch$configureApp$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "App " + WatchApp.this.getTitle() + ", not in app list. Not synced!";
            }
        }, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0025. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x019b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0188 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0173 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0129 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.animaconnected.watch.Watch
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doConnect(com.animaconnected.watch.device.WatchIO r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.doConnect(com.animaconnected.watch.device.WatchIO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.Watch
    public void doDisconnect() {
        this.fs = null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0027. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03f2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0295 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0271 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0246 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0224 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0202 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x057f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0580  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0335  */
    @Override // com.animaconnected.watch.Watch
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doSync(boolean r31, kotlin.coroutines.Continuation<? super kotlin.Unit> r32) {
        /*
            Method dump skipped, instructions count: 1460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.doSync(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List<WatchApp> getApps$watch_release() {
        return getBehaviours$watch_release().getWatchApps();
    }

    public final DisplayType getDisplayType() {
        return this.displayType;
    }

    public final WatchFileSystem getFs() {
        return this.fs;
    }

    public final long getLastFitnessResultTs$watch_release() {
        Long l = getStorage$watch_release().getLong(this.lastFitnessResultTsKey);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final boolean getManualGcRequested() {
        return this.manualGcRequested;
    }

    public final PreferenceProvider getPreferences$watch_release() {
        return this.preferences;
    }

    public final WatchStyle getStyle() {
        return this.style;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.Watch
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object isFirmwareSupported(com.animaconnected.watch.device.WatchIO r12, kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) {
        /*
            r11 = this;
            boolean r12 = r13 instanceof com.animaconnected.watch.DisplayWatch$isFirmwareSupported$1
            if (r12 == 0) goto L13
            r12 = r13
            com.animaconnected.watch.DisplayWatch$isFirmwareSupported$1 r12 = (com.animaconnected.watch.DisplayWatch$isFirmwareSupported$1) r12
            int r0 = r12.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r12.label = r0
            goto L18
        L13:
            com.animaconnected.watch.DisplayWatch$isFirmwareSupported$1 r12 = new com.animaconnected.watch.DisplayWatch$isFirmwareSupported$1
            r12.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r12.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r12.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            boolean r12 = r12.Z$0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L92
        L29:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L31:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.String r13 = r11.getFirmwareRevision()
            r1 = 0
            if (r13 == 0) goto L40
            com.animaconnected.watch.device.BaseFirmwareVersion r13 = com.animaconnected.watch.device.FirmwareVersionKt.toFirmwareVersion(r13)
            goto L41
        L40:
            r13 = r1
        L41:
            boolean r3 = r13 instanceof com.animaconnected.watch.device.FirmwareVersion
            if (r3 == 0) goto L48
            r1 = r13
            com.animaconnected.watch.device.FirmwareVersion r1 = (com.animaconnected.watch.device.FirmwareVersion) r1
        L48:
            if (r1 != 0) goto L4d
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            return r12
        L4d:
            boolean r13 = com.animaconnected.watch.device.FirmwareVersionKt.isSupported(r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "FW version supported: "
            r3.<init>(r4)
            r3.append(r13)
            java.lang.String r4 = ". (current: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = ", supported: "
            r3.append(r1)
            kotlin.Pair r1 = com.animaconnected.watch.device.FirmwareVersionKt.getSupportedRange()
            r3.append(r1)
            r1 = 41
            r3.append(r1)
            java.lang.String r5 = r3.toString()
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r4 = r11
            com.animaconnected.logger.LogKt.debug$default(r4, r5, r6, r7, r8, r9, r10)
            if (r13 != 0) goto L93
            com.animaconnected.watch.device.DfuUiState r1 = com.animaconnected.watch.device.DfuUiState.Init
            r12.Z$0 = r13
            r12.label = r2
            java.lang.Object r12 = r11.setDfuUIState(r1, r12)
            if (r12 != r0) goto L91
            return r0
        L91:
            r12 = r13
        L92:
            r13 = r12
        L93:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r13)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.isFirmwareSupported(com.animaconnected.watch.device.WatchIO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* renamed from: onFileChanged-b1QGwmY$watch_release, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1045onFileChangedb1QGwmY$watch_release(final int r12, int r13, int r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r11 = this;
            boolean r13 = r15 instanceof com.animaconnected.watch.DisplayWatch$onFileChanged$1
            if (r13 == 0) goto L13
            r13 = r15
            com.animaconnected.watch.DisplayWatch$onFileChanged$1 r13 = (com.animaconnected.watch.DisplayWatch$onFileChanged$1) r13
            int r0 = r13.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r13.label = r0
            goto L18
        L13:
            com.animaconnected.watch.DisplayWatch$onFileChanged$1 r13 = new com.animaconnected.watch.DisplayWatch$onFileChanged$1
            r13.<init>(r11, r15)
        L18:
            java.lang.Object r15 = r13.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r13.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3b
            if (r1 == r3) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r15)
            goto Lb2
        L2b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L33:
            java.lang.Object r12 = r13.L$0
            com.animaconnected.watch.DisplayWatch r12 = (com.animaconnected.watch.DisplayWatch) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto La4
        L3b:
            kotlin.ResultKt.throwOnFailure(r15)
            com.animaconnected.watch.device.files.WatchFileSystem r15 = r11.fs
            if (r15 != 0) goto L45
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L45:
            com.animaconnected.watch.display.ResourceSynchronizer r1 = r11.getResourceSynchronizer$watch_release()
            java.lang.String r4 = r11.getIdentifier()
            long r5 = (long) r12
            r7 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r5 = r5 & r7
            r7 = 10
            java.lang.String r5 = java.lang.Long.toString(r5, r7)
            com.animaconnected.watch.sync.DBFile r1 = r1.getEditableFile(r4, r5)
            if (r1 != 0) goto L72
            java.lang.String r5 = r11.tagEditableFiles
            r6 = 0
            r7 = 0
            com.animaconnected.watch.DisplayWatch$onFileChanged$2 r8 = new com.animaconnected.watch.DisplayWatch$onFileChanged$2
            r8.<init>()
            r9 = 6
            r10 = 0
            r4 = r11
            com.animaconnected.logger.LogKt.debug$default(r4, r5, r6, r7, r8, r9, r10)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L72:
            java.lang.String r12 = r1.getHash()
            int r12 = kotlin.text.UStringsKt.toUInt(r12)
            if (r14 != r12) goto L8b
            java.lang.String r5 = r11.tagEditableFiles
            r6 = 0
            r7 = 0
            com.animaconnected.watch.DisplayWatch$onFileChanged$3 r8 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.DisplayWatch$onFileChanged$3
                static {
                    /*
                        com.animaconnected.watch.DisplayWatch$onFileChanged$3 r0 = new com.animaconnected.watch.DisplayWatch$onFileChanged$3
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.DisplayWatch$onFileChanged$3) com.animaconnected.watch.DisplayWatch$onFileChanged$3.INSTANCE com.animaconnected.watch.DisplayWatch$onFileChanged$3
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch$onFileChanged$3.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch$onFileChanged$3.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "File change but dataHash is the same, ignoring"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch$onFileChanged$3.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch$onFileChanged$3.invoke():java.lang.Object");
                }
            }
            r9 = 6
            r10 = 0
            r4 = r11
            com.animaconnected.logger.LogKt.debug$default(r4, r5, r6, r7, r8, r9, r10)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L8b:
            long r4 = com.animaconnected.info.DateTimeUtilsKt.currentTimeMillis()
            java.lang.Long r12 = new java.lang.Long
            r12.<init>(r4)
            com.animaconnected.watch.device.files.FileDescriptor r12 = com.animaconnected.watch.display.ResourceSynchronizerKt.toFileDescriptor(r1, r12)
            r13.L$0 = r11
            r13.label = r3
            java.lang.Object r15 = r15.readFile(r12, r13)
            if (r15 != r0) goto La3
            return r0
        La3:
            r12 = r11
        La4:
            com.animaconnected.watch.device.files.WatchFile r15 = (com.animaconnected.watch.device.files.WatchFile) r15
            r14 = 0
            r13.L$0 = r14
            r13.label = r2
            java.lang.Object r12 = r12.handleFileChange(r15, r13)
            if (r12 != r0) goto Lb2
            return r0
        Lb2:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.m1045onFileChangedb1QGwmY$watch_release(int, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object requestAppState(com.animaconnected.watch.display.AppId r10, com.animaconnected.watch.display.VisibilityState r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.animaconnected.watch.DisplayWatch$requestAppState$1
            if (r0 == 0) goto L13
            r0 = r12
            com.animaconnected.watch.DisplayWatch$requestAppState$1 r0 = (com.animaconnected.watch.DisplayWatch$requestAppState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.DisplayWatch$requestAppState$1 r0 = new com.animaconnected.watch.DisplayWatch$requestAppState$1
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r10 = r0.L$0
            com.animaconnected.watch.DisplayWatch r10 = (com.animaconnected.watch.DisplayWatch) r10
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L2b
            goto L59
        L2b:
            r2 = r10
            goto L4f
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            kotlin.ResultKt.throwOnFailure(r12)
            com.animaconnected.watch.device.WatchIO r12 = r9.getIo()     // Catch: java.lang.Exception -> L4e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)     // Catch: java.lang.Exception -> L4e
            int r10 = r10.getCode()     // Catch: java.lang.Exception -> L4e
            r0.L$0 = r9     // Catch: java.lang.Exception -> L4e
            r0.label = r3     // Catch: java.lang.Exception -> L4e
            java.lang.Object r10 = r12.writeRequestAppState(r10, r11, r0)     // Catch: java.lang.Exception -> L4e
            if (r10 != r1) goto L59
            return r1
        L4e:
            r2 = r9
        L4f:
            r3 = 0
            r4 = 0
            r5 = 0
            com.animaconnected.watch.DisplayWatch$requestAppState$2 r6 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.DisplayWatch$requestAppState$2
                static {
                    /*
                        com.animaconnected.watch.DisplayWatch$requestAppState$2 r0 = new com.animaconnected.watch.DisplayWatch$requestAppState$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.DisplayWatch$requestAppState$2) com.animaconnected.watch.DisplayWatch$requestAppState$2.INSTANCE com.animaconnected.watch.DisplayWatch$requestAppState$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch$requestAppState$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch$requestAppState$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Failed to requestAppState"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch$requestAppState$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch$requestAppState$2.invoke():java.lang.Object");
                }
            }
            r7 = 7
            r8 = 0
            com.animaconnected.logger.LogKt.verbose$default(r2, r3, r4, r5, r6, r7, r8)
        L59:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.requestAppState(com.animaconnected.watch.display.AppId, com.animaconnected.watch.display.VisibilityState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.Watch
    public void resetConfigs() {
        LogKt.verbose$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.DisplayWatch$resetConfigs$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Resetting configs";
            }
        }, 7, (Object) null);
        getResourceSynchronizer$watch_release().setConfigUnSynced(getIdentifier(), Command.FITNESS_CONFIG);
        getResourceSynchronizer$watch_release().setConfigUnSynced(getIdentifier(), Command.FITNESS_TARGETS);
        getResourceSynchronizer$watch_release().setConfigUnSynced(getIdentifier(), Command.VIBRATOR_CONFIG);
        getResourceSynchronizer$watch_release().setConfigUnSynced(getIdentifier(), Command.DISPLAY_COLOR);
        getResourceSynchronizer$watch_release().setConfigUnSynced(getIdentifier(), Command.DEMO_MODE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendImage(java.lang.String r13, com.animaconnected.watch.image.Mitmap r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Exception {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.animaconnected.watch.DisplayWatch$sendImage$1
            if (r0 == 0) goto L13
            r0 = r15
            com.animaconnected.watch.DisplayWatch$sendImage$1 r0 = (com.animaconnected.watch.DisplayWatch$sendImage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.DisplayWatch$sendImage$1 r0 = new com.animaconnected.watch.DisplayWatch$sendImage$1
            r0.<init>(r12, r15)
        L18:
            r7 = r0
            java.lang.Object r15 = r7.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            long r13 = r7.J$0
            java.lang.Object r0 = r7.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L84
        L2e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L36:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r1 = "name="
            r15.<init>(r1)
            r15.append(r13)
            java.lang.String r15 = r15.toString()
            com.animaconnected.logger.MeasurementBackend r1 = com.animaconnected.logger.MeasurementBackendKt.getMeasurementBackend()
            if (r1 == 0) goto L54
            java.lang.String r3 = "sendImage"
            java.lang.String r15 = r1.begin(r3, r15)
            goto L55
        L54:
            r15 = 0
        L55:
            long r10 = kotlin.time.MonotonicTimeSource.read()
            com.animaconnected.watch.device.files.WatchFileSystem r3 = r12.fs
            if (r3 != 0) goto L5e
            goto L86
        L5e:
            int r1 = r13.length()
            r4 = 24
            if (r1 > r4) goto L97
            java.lang.String r4 = r14.getBytesHash()
            byte[] r5 = r14.getBytes()
            r6 = 0
            r8 = 8
            r9 = 0
            r7.L$0 = r15
            r7.J$0 = r10
            r7.label = r2
            r1 = r12
            r2 = r3
            r3 = r13
            java.lang.Object r13 = syncPicture$watch_release$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r13 != r0) goto L82
            return r0
        L82:
            r0 = r15
            r13 = r10
        L84:
            r10 = r13
            r15 = r0
        L86:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            kotlin.time.TimeSource.Monotonic.ValueTimeMark.m1693elapsedNowUwyO8pc(r10)
            if (r15 == 0) goto L96
            com.animaconnected.logger.MeasurementBackend r14 = com.animaconnected.logger.MeasurementBackendKt.getMeasurementBackend()
            if (r14 == 0) goto L96
            r14.end(r15)
        L96:
            return r13
        L97:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Image name must be less than 24 characters"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.sendImage(java.lang.String, com.animaconnected.watch.image.Mitmap, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object setDfuUIState(DfuUiState dfuUiState, Continuation<? super Unit> continuation) {
        WatchIO io2 = getIo();
        if (io2 != null) {
            Object writeDfuReady = io2.writeDfuReady(dfuUiState, continuation);
            if (writeDfuReady == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return writeDfuReady;
            }
            return Unit.INSTANCE;
        }
        return null;
    }

    public final void setLastFitnessResultTs$watch_release(long j) {
        getStorage$watch_release().put(this.lastFitnessResultTsKey, j);
    }

    public final void setManualGcRequested(boolean z) {
        this.manualGcRequested = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object showApp(com.animaconnected.watch.display.RemoteApp r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.DisplayWatch$showApp$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.DisplayWatch$showApp$1 r0 = (com.animaconnected.watch.DisplayWatch$showApp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.DisplayWatch$showApp$1 r0 = new com.animaconnected.watch.DisplayWatch$showApp$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6c
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.lang.Object r6 = r0.L$1
            com.animaconnected.watch.display.RemoteApp r6 = (com.animaconnected.watch.display.RemoteApp) r6
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.DisplayWatch r2 = (com.animaconnected.watch.DisplayWatch) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L56
        L3e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.device.files.WatchFileSystem r7 = r5.fs
            if (r7 != 0) goto L48
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L48:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.syncApp(r6, r7, r0)
            if (r7 != r1) goto L55
            return r1
        L55:
            r2 = r5
        L56:
            com.animaconnected.watch.display.AppId r7 = r6.getId()
            com.animaconnected.watch.display.VisibilityState r6 = r6.getOnStartState()
            r4 = 0
            r0.L$0 = r4
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r6 = r2.requestAppState(r7, r6, r0)
            if (r6 != r1) goto L6c
            return r1
        L6c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.showApp(com.animaconnected.watch.display.RemoteApp, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncFile(com.animaconnected.watch.device.files.WatchFile r13, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.files.FileDescriptor> r14) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncFile(com.animaconnected.watch.device.files.WatchFile, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncPicture$watch_release(com.animaconnected.watch.device.files.WatchFileSystem r21, java.lang.String r22, java.lang.String r23, byte[] r24, boolean r25, kotlin.coroutines.Continuation<? super java.util.List<com.animaconnected.watch.device.files.FileDescriptor>> r26) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncPicture$watch_release(com.animaconnected.watch.device.files.WatchFileSystem, java.lang.String, java.lang.String, byte[], boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncPositions$watch_release(com.animaconnected.watch.device.files.WatchFileSystem r14, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.files.FileDescriptor> r15) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncPositions$watch_release(com.animaconnected.watch.device.files.WatchFileSystem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncText$watch_release(com.animaconnected.watch.device.files.WatchFileSystem r19, java.lang.String r20, com.animaconnected.watch.display.WatchString r21, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.files.FileDescriptor> r22) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncText$watch_release(com.animaconnected.watch.device.files.WatchFileSystem, java.lang.String, com.animaconnected.watch.display.WatchString, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object updateApp(RemoteApp remoteApp, Continuation<? super Unit> continuation) {
        LogKt.debug$default((Object) this, getTag$watch_release(), (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.DisplayWatch$updateApp$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Update app start";
            }
        }, 6, (Object) null);
        WatchFileSystem watchFileSystem = this.fs;
        if (watchFileSystem == null) {
            return Unit.INSTANCE;
        }
        Object syncApp = syncApp(remoteApp, watchFileSystem, continuation);
        if (syncApp == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return syncApp;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncFile(com.animaconnected.watch.device.files.WatchFileSystem r17, com.animaconnected.watch.device.files.WatchFile r18, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.files.FileDescriptor> r19) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatch.syncFile(com.animaconnected.watch.device.files.WatchFileSystem, com.animaconnected.watch.device.files.WatchFile, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
