package com.animaconnected.secondo.utils.debugging;

import android.content.Context;
import androidx.compose.foundation.BorderStrokeKt;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.KronabyApplication;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.MainDispatcherLoader;

/* compiled from: FileWriter.kt */
/* loaded from: classes3.dex */
public final class FileWriter {
    public static final int $stable = 8;
    private File currentLogFile;
    private SimpleDateFormat dateFormatter;
    private final String fileEnding;
    private final CoroutineDispatcher fileWriterDispatcher;
    private final String folder;
    private final List<String> logCache;
    private Job logJob;
    private final int maxFileSizeInBytes;
    private final int maxFilesAmount;
    private final String prefix;
    private final long saveInterval;
    private final CoroutineScope scope;

    private FileWriter(String str, String str2, int r9, int r10, long j, String str3) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, "prefix", str2, "folder", str3, "fileEnding");
        this.prefix = str;
        this.folder = str2;
        this.maxFileSizeInBytes = r9;
        this.maxFilesAmount = r10;
        this.saveInterval = j;
        this.fileEnding = str3;
        this.logCache = new ArrayList();
        this.scope = KronabyApplication.Companion.getScope();
        this.fileWriterDispatcher = Dispatchers.Default.limitedParallelism(1);
        this.dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File updateCurrentLogfile(Context context, File file) {
        File file2;
        File file3 = new File(context.getFilesDir(), this.folder);
        if (!file3.exists()) {
            file3.mkdir();
        }
        if (file == null || file.length() >= this.maxFileSizeInBytes) {
            List sortedWith = CollectionsKt___CollectionsKt.sortedWith(files(context), new Comparator() { // from class: com.animaconnected.secondo.utils.debugging.FileWriter$updateCurrentLogfile$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return BorderStrokeKt.compareValues(Long.valueOf(((File) t).lastModified()), Long.valueOf(((File) t2).lastModified()));
                }
            });
            if (sortedWith.size() >= this.maxFilesAmount) {
                ((File) CollectionsKt___CollectionsKt.first(sortedWith)).delete();
            }
            if ((!sortedWith.isEmpty()) && ((File) CollectionsKt___CollectionsKt.last(sortedWith)).length() < this.maxFileSizeInBytes) {
                file2 = (File) CollectionsKt___CollectionsKt.last(sortedWith);
            } else {
                file2 = Debugging.INSTANCE.getFile(context, this.prefix + '-' + this.dateFormatter.format(new Date()) + this.fileEnding);
            }
            File file4 = file2;
            Intrinsics.checkNotNull(file4);
            return file4;
        }
        return file;
    }

    public final void append(Context context, String text) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        BuildersKt.launch$default(this.scope, this.fileWriterDispatcher, null, new FileWriter$append$1(this, text, null), 2);
        Job job = this.logJob;
        if (job == null || !job.isActive()) {
            this.logJob = BuildersKt.launch$default(this.scope, MainDispatcherLoader.dispatcher, null, new FileWriter$append$2(this, context, null), 2);
        }
    }

    public final void delete(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Iterator<T> it = files(context).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public final List<File> files(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File[] listFiles = new File(context.getFilesDir(), this.folder).listFiles();
        if (listFiles != null) {
            ArrayList arrayList = new ArrayList();
            for (File file : listFiles) {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (StringsKt__StringsKt.contains(name, this.prefix, false)) {
                    arrayList.add(file);
                }
            }
            return arrayList;
        }
        return EmptyList.INSTANCE;
    }

    public final Object flush(Context context, Continuation<? super Unit> continuation) {
        Object saveToFile = saveToFile(context, continuation);
        if (saveToFile == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return saveToFile;
        }
        return Unit.INSTANCE;
    }

    public final Object saveToFile(Context context, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.fileWriterDispatcher, new FileWriter$saveToFile$2(this, context, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final long size(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Iterator<T> it = files(context).iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((File) it.next()).length();
        }
        return j;
    }

    public final File zip(Context context, String zipName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(zipName, "zipName");
        Debugging debugging = Debugging.INSTANCE;
        File[] fileArr = (File[]) files(context).toArray(new File[0]);
        return debugging.createZip(context, zipName, (File[]) Arrays.copyOf(fileArr, fileArr.length));
    }

    private static /* synthetic */ void getFileWriterDispatcher$annotations() {
    }

    public /* synthetic */ FileWriter(String str, String str2, int r3, int r4, long j, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, r3, r4, j, str3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ FileWriter(java.lang.String r11, java.lang.String r12, int r13, int r14, long r15, java.lang.String r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r10 = this;
            r0 = r18 & 2
            if (r0 == 0) goto L8
            java.lang.String r0 = "debugging"
            r3 = r0
            goto L9
        L8:
            r3 = r12
        L9:
            r0 = r18 & 4
            if (r0 == 0) goto L11
            r0 = 1048576(0x100000, float:1.469368E-39)
            r4 = r0
            goto L12
        L11:
            r4 = r13
        L12:
            r0 = r18 & 8
            if (r0 == 0) goto L19
            r0 = 4
            r5 = r0
            goto L1a
        L19:
            r5 = r14
        L1a:
            r0 = r18 & 16
            if (r0 == 0) goto L2a
            int r0 = kotlin.time.Duration.$r8$clinit
            r0 = 20
            kotlin.time.DurationUnit r1 = kotlin.time.DurationUnit.SECONDS
            long r0 = kotlin.time.DurationKt.toDuration(r0, r1)
            r6 = r0
            goto L2b
        L2a:
            r6 = r15
        L2b:
            r0 = r18 & 32
            if (r0 == 0) goto L33
            java.lang.String r0 = ".log"
            r8 = r0
            goto L35
        L33:
            r8 = r17
        L35:
            r9 = 0
            r1 = r10
            r2 = r11
            r1.<init>(r2, r3, r4, r5, r6, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.debugging.FileWriter.<init>(java.lang.String, java.lang.String, int, int, long, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
