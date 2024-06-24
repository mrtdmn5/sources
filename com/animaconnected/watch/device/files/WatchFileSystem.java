package com.animaconnected.watch.device.files;

import com.animaconnected.info.ByteUtils;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.msgpack.MsgPackCreator;
import com.animaconnected.watch.WatchAppValidator;
import com.animaconnected.watch.device.FileResult;
import com.animaconnected.watch.device.WatchIO;
import com.animaconnected.watch.display.ExpiringString;
import com.animaconnected.watch.display.FlashString;
import com.animaconnected.watch.display.RamString;
import com.animaconnected.watch.display.WatchString;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.UStringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: WatchFileSystem.kt */
/* loaded from: classes3.dex */
public final class WatchFileSystem {
    public static final Companion Companion = new Companion(null);
    public static final String ancsDir = "/ram/ancs";
    public static final String ancsFilterFile = "filter.msg";
    public static final String appDir = "/flash/ext/app";
    public static final String appPrefFile = "prefs_app.msg";
    public static final String flashRootDir = "/flash";
    public static final String flashTxtDir = "/flash/ext/txt";
    public static final String linkDir = "/ram/link";
    public static final String pictureDir = "/flash/ext/picture";
    public static final String positionsFile = "positions.msg";
    public static final String prefFilePrefix = "prefs";
    public static final String prefsDir = "/ram/prefs";
    public static final String ramRootDir = "/ram";
    public static final String ramTxtDir = "/ram/txt";
    public static final String settingsPrefFile = "prefs_settings.msg";
    public static final String tag = "WatchStorage";
    public static final String viewDir = "/flash/ext/view";
    public static final String watchPrefFile = "prefs_watch.msg";
    public static final String workoutPrefFile = "prefs_workout.msg";
    private final Map<FileEntry, CompletableDeferred<FileResult>> currentTransfers;

    /* renamed from: io */
    private final WatchIO f137io;
    private final Mutex writeMutex;

    /* compiled from: WatchFileSystem.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public WatchFileSystem(WatchIO io2) {
        Intrinsics.checkNotNullParameter(io2, "io");
        this.f137io = io2;
        this.writeMutex = MutexKt.Mutex$default();
        this.currentTransfers = new LinkedHashMap();
    }

    public static /* synthetic */ Object makeDirectory$default(WatchFileSystem watchFileSystem, String str, String str2, Continuation continuation, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            str2 = null;
        }
        return watchFileSystem.makeDirectory(str, str2, continuation);
    }

    public final Object deleteAppInfo(int r9, Continuation<? super FileResult> continuation) {
        return deleteFile$watch_release(new WatchFile(appDir, r9 + ".msg", new byte[0], false, 8, null), continuation);
    }

    public final Object deleteFile$watch_release(FileEntry fileEntry, Continuation<? super FileResult> continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return BuildersKt.withContext(MainDispatcherLoader.dispatcher, new WatchFileSystem$deleteFile$2(this, fileEntry, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00be -> B:17:0x00bf). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00c2 -> B:18:0x00c3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getDirectoryRecursive(java.lang.String r15, java.lang.String r16, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.files.Directory> r17) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.files.WatchFileSystem.getDirectoryRecursive(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final WatchIO getIo() {
        return this.f137io;
    }

    public final WatchFile makeAppFile(int r9, byte[] viewBytes) {
        Intrinsics.checkNotNullParameter(viewBytes, "viewBytes");
        WatchFile watchFile = new WatchFile(appDir, r9 + ".msg", viewBytes, false, 8, null);
        WatchAppValidator.INSTANCE.validateAppFile(watchFile);
        return watchFile;
    }

    public final Object makeDirectory(String str, String str2, Continuation<? super FileResult> continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return BuildersKt.withContext(MainDispatcherLoader.dispatcher, new WatchFileSystem$makeDirectory$2(str2, str, this, null), continuation);
    }

    public final WatchFile makeLinkFile(String linkName, String imageHash) {
        Intrinsics.checkNotNullParameter(linkName, "linkName");
        Intrinsics.checkNotNullParameter(imageHash, "imageHash");
        WatchFile watchFile = new WatchFile(linkDir, linkName, StringsKt__StringsJVMKt.encodeToByteArray(imageHash), false, 8, null);
        WatchAppValidator.INSTANCE.validateLinkFile(watchFile);
        return watchFile;
    }

    public final WatchFile makePictureFile(String name, byte[] bytes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        final WatchFile watchFile = new WatchFile(pictureDir, name.concat(".bin"), bytes, false, 8, null);
        WatchAppValidator.INSTANCE.validatePictureFile(watchFile);
        LogKt.verbose$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$makePictureFile$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Validated " + WatchFile.this.getFullPath();
            }
        }, 6, (Object) null);
        return watchFile;
    }

    public final WatchFile makeStringFile(String name, WatchString watchString, MsgPackCreator msgPackCreator) {
        WatchFile watchFile;
        WatchFile watchFile2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(watchString, "watchString");
        Intrinsics.checkNotNullParameter(msgPackCreator, "msgPackCreator");
        if (watchString instanceof ExpiringString) {
            Pair pair = new Pair("string", watchString.getString());
            ExpiringString expiringString = (ExpiringString) watchString;
            watchFile2 = new WatchFile(ramTxtDir, name.concat(".txx"), msgPackCreator.newStringMap(MapsKt__MapsKt.mapOf(pair, new Pair("fallback", expiringString.getFallbackString()), new Pair("expiry", Integer.valueOf(DateTimeUtilsKt.toWatchSeconds(expiringString.getExpiry()))))).toMsgPackBytes(), false, 8, null);
        } else {
            if (watchString instanceof RamString) {
                watchFile = new WatchFile(ramTxtDir, name.concat(".txt"), StringsKt__StringsJVMKt.encodeToByteArray(watchString.getString()), false, 8, null);
            } else if (watchString instanceof FlashString) {
                watchFile = new WatchFile(flashTxtDir, name.concat(".txt"), StringsKt__StringsJVMKt.encodeToByteArray(watchString.getString()), false, 8, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            watchFile2 = watchFile;
        }
        WatchAppValidator.INSTANCE.validateTextFile(watchFile2);
        return watchFile2;
    }

    public final WatchFile makeViewFile(String name, byte[] viewBytes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(viewBytes, "viewBytes");
        WatchFile watchFile = new WatchFile(viewDir, name.concat(".msg"), viewBytes, false, 8, null);
        WatchAppValidator.INSTANCE.validateViewFile(watchFile);
        return watchFile;
    }

    /* renamed from: onFileDeleteResult-Qn1smSk$watch_release */
    public final void m1109onFileDeleteResultQn1smSk$watch_release(final FileResult result, final int r12) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(result, "result");
        LogKt.debug$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$onFileDeleteResult$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "On file delete result: " + FileResult.this;
            }
        }, 6, (Object) null);
        Iterator<T> it = this.currentTransfers.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((FileEntry) ((Map.Entry) obj).getKey()).mo1102getPathHashpVg5ArA() == r12) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            LogKt.err$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$onFileDeleteResult$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "File delete result: " + FileResult.this + " for unexpected file. pathHash " + ((Object) UInt.m1664toStringimpl(r12));
                }
            }, 6, (Object) null);
            return;
        }
        final FileEntry fileEntry = (FileEntry) entry.getKey();
        CompletableDeferred completableDeferred = (CompletableDeferred) entry.getValue();
        this.currentTransfers.remove(fileEntry);
        if (result != FileResult.OK) {
            LogKt.verbose$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$onFileDeleteResult$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "File with hash " + ((Object) UInt.m1664toStringimpl(FileEntry.this.mo1102getPathHashpVg5ArA())) + " was not deleted. Error: " + result.getMessage();
                }
            }, 6, (Object) null);
            completableDeferred.complete(result);
            return;
        }
        if ((fileEntry instanceof WatchFile) && r12 == fileEntry.mo1102getPathHashpVg5ArA()) {
            LogKt.verbose$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$onFileDeleteResult$4
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "File delete with " + FileEntry.this.getName() + " ok";
                }
            }, 6, (Object) null);
            completableDeferred.complete(result);
            return;
        }
        LogKt.warn$default((Object) this, "Received delete success: " + fileEntry + " \nBut hash did not match: \n  Result " + result + " returned pathHash " + ((Object) UInt.m1664toStringimpl(r12)) + ", file pathHash " + ((Object) UInt.m1664toStringimpl(fileEntry.mo1102getPathHashpVg5ArA())), (String) null, (Throwable) null, false, 14, (Object) null);
        completableDeferred.complete(result);
    }

    /* renamed from: onFileResult-miZAcA0$watch_release */
    public final void m1110onFileResultmiZAcA0$watch_release(final FileResult result, final int r14, Integer num, final UInt uInt) {
        String str;
        Object obj;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(result, "result");
        LogKt.debug$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$onFileResult$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "On file result: " + FileResult.this;
            }
        }, 6, (Object) null);
        Iterator<T> it = this.currentTransfers.entrySet().iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((FileEntry) ((Map.Entry) obj).getKey()).mo1102getPathHashpVg5ArA() == r14) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            LogKt.err$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$onFileResult$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "File result: " + FileResult.this + " for unexpected file. pathHash " + ((Object) UInt.m1664toStringimpl(r14)) + " and dataHash " + uInt;
                }
            }, 6, (Object) null);
            return;
        }
        final FileEntry fileEntry = (FileEntry) entry.getKey();
        CompletableDeferred completableDeferred = (CompletableDeferred) entry.getValue();
        this.currentTransfers.remove(fileEntry);
        if (result != FileResult.OK) {
            LogKt.verbose$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$onFileResult$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "File with hash " + ByteUtils.m748toHexStringqim9Vi0$default(FileEntry.this.mo1102getPathHashpVg5ArA(), 0, 1, null) + " error " + result.getMessage();
                }
            }, 6, (Object) null);
            completableDeferred.complete(result);
            return;
        }
        if ((fileEntry instanceof WatchFile) && r14 == fileEntry.mo1102getPathHashpVg5ArA()) {
            WatchFile watchFile = (WatchFile) fileEntry;
            int m1107getDataHashpVg5ArA = watchFile.m1107getDataHashpVg5ArA();
            if (uInt != null && uInt.data == m1107getDataHashpVg5ArA) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int length = watchFile.getBytes().length;
                if (num != null && num.intValue() == length) {
                    LogKt.verbose$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$onFileResult$4
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "File with " + FileEntry.this.getName() + " ok";
                        }
                    }, 6, (Object) null);
                    completableDeferred.complete(result);
                    return;
                }
            }
        }
        if ((fileEntry instanceof DirectoryDescriptor) && r14 == fileEntry.mo1102getPathHashpVg5ArA()) {
            LogKt.verbose$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$onFileResult$5
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Directory " + FileEntry.this.getName() + " ok";
                }
            }, 6, (Object) null);
            completableDeferred.complete(result);
            return;
        }
        StringBuilder sb = new StringBuilder("Received file failed test. Local file:  ");
        sb.append(fileEntry);
        sb.append(" \nReturned values: \n  Result ");
        sb.append(result);
        sb.append(" pathHash ");
        sb.append(ByteUtils.m748toHexStringqim9Vi0$default(r14, 0, 1, null));
        sb.append(" dataHash ");
        if (uInt != null) {
            str = UStringsKt.m1669toStringV7xB4Y4(uInt.data);
        }
        sb.append(str);
        LogKt.warn$default((Object) this, sb.toString(), (String) null, (Throwable) null, false, 14, (Object) null);
        completableDeferred.complete(FileResult.OtherBadHash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00ff -> B:16:0x0106). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readFile(com.animaconnected.watch.device.files.FileDescriptor r25, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.files.WatchFile> r26) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.files.WatchFileSystem.readFile(com.animaconnected.watch.device.files.FileDescriptor, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readFolder(com.animaconnected.watch.device.files.DirectoryDescriptor r13, kotlin.coroutines.Continuation<? super java.util.List<? extends com.animaconnected.watch.device.files.FileEntry>> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.animaconnected.watch.device.files.WatchFileSystem$readFolder$1
            if (r0 == 0) goto L13
            r0 = r14
            com.animaconnected.watch.device.files.WatchFileSystem$readFolder$1 r0 = (com.animaconnected.watch.device.files.WatchFileSystem$readFolder$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.files.WatchFileSystem$readFolder$1 r0 = new com.animaconnected.watch.device.files.WatchFileSystem$readFolder$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r13 = r0.L$0
            com.animaconnected.watch.device.files.DirectoryDescriptor r13 = (com.animaconnected.watch.device.files.DirectoryDescriptor) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L49
        L2b:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L33:
            kotlin.ResultKt.throwOnFailure(r14)
            com.animaconnected.watch.device.WatchIO r14 = r12.f137io
            java.lang.String r2 = r13.getFullPath()
            r0.L$0 = r13
            r0.label = r3
            java.lang.String r3 = "ls"
            java.lang.Object r14 = r14.readFilesPaged(r3, r2, r0)
            if (r14 != r1) goto L49
            return r1
        L49:
            java.util.Map r14 = (java.util.Map) r14
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r14.size()
            r0.<init>(r1)
            java.util.Set r14 = r14.entrySet()
            java.util.Iterator r14 = r14.iterator()
        L5c:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto La9
            java.lang.Object r1 = r14.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r1 = r1.getValue()
            com.animaconnected.watch.device.WatchIO$FileMeta r1 = (com.animaconnected.watch.device.WatchIO.FileMeta) r1
            int r2 = r1.getSize()
            r3 = -1
            if (r2 != r3) goto L8a
            com.animaconnected.watch.device.files.DirectoryDescriptor r1 = new com.animaconnected.watch.device.files.DirectoryDescriptor
            java.lang.String r4 = r13.getFullPath()
            r6 = 0
            r7 = 4
            r8 = 0
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8)
            goto La5
        L8a:
            com.animaconnected.watch.device.files.FileDescriptor r2 = new com.animaconnected.watch.device.files.FileDescriptor
            java.lang.String r4 = r13.getFullPath()
            int r6 = r1.getSize()
            kotlin.UInt r7 = r1.m1097getDeckHash0hXNFcg()
            java.lang.Long r8 = r1.getTimestamp()
            r9 = 0
            r10 = 32
            r11 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r1 = r2
        La5:
            r0.add(r1)
            goto L5c
        La9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.files.WatchFileSystem.readFolder(com.animaconnected.watch.device.files.DirectoryDescriptor, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeFile$watch_release(com.animaconnected.watch.device.files.WatchFile r9, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.FileResult> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.device.files.WatchFileSystem$writeFile$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.device.files.WatchFileSystem$writeFile$1 r0 = (com.animaconnected.watch.device.files.WatchFileSystem$writeFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.files.WatchFileSystem$writeFile$1 r0 = new com.animaconnected.watch.device.files.WatchFileSystem$writeFile$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L2f
            goto L7b
        L2f:
            r10 = move-exception
            goto L85
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r2 = r0.L$1
            com.animaconnected.watch.device.files.WatchFile r2 = (com.animaconnected.watch.device.files.WatchFile) r2
            java.lang.Object r4 = r0.L$0
            com.animaconnected.watch.device.files.WatchFileSystem r4 = (com.animaconnected.watch.device.files.WatchFileSystem) r4
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r2
            goto L60
        L4b:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.sync.Mutex r10 = r8.writeMutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r2 = r10.lock(r5, r0)
            if (r2 != r1) goto L5f
            return r1
        L5f:
            r4 = r8
        L60:
            kotlinx.coroutines.CoroutineDispatcher r2 = com.animaconnected.watch.DispatchersKt.mainDispatcher()     // Catch: java.lang.Throwable -> L81
            com.animaconnected.watch.device.files.WatchFileSystem$writeFile$2$1 r6 = new com.animaconnected.watch.device.files.WatchFileSystem$writeFile$2$1     // Catch: java.lang.Throwable -> L81
            r6.<init>(r4, r9, r5)     // Catch: java.lang.Throwable -> L81
            r0.L$0 = r10     // Catch: java.lang.Throwable -> L81
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L81
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L81
            r0.label = r3     // Catch: java.lang.Throwable -> L81
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r2, r6, r0)     // Catch: java.lang.Throwable -> L81
            if (r9 != r1) goto L78
            return r1
        L78:
            r7 = r10
            r10 = r9
            r9 = r7
        L7b:
            com.animaconnected.watch.device.FileResult r10 = (com.animaconnected.watch.device.FileResult) r10     // Catch: java.lang.Throwable -> L2f
            r9.unlock(r5)
            return r10
        L81:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L85:
            r9.unlock(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.files.WatchFileSystem.writeFile$watch_release(com.animaconnected.watch.device.files.WatchFile, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
