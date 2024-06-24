package com.animaconnected.watch;

import com.animaconnected.watch.device.files.WatchFile;
import com.animaconnected.watch.display.ContainerCommand;
import com.animaconnected.watch.display.DrawCommand;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchAppValidator.kt */
/* loaded from: classes3.dex */
public final class WatchAppValidator {
    public static final WatchAppValidator INSTANCE = new WatchAppValidator();
    private static final int maxBytesWatchFile = 2048;
    private static final int maxFileNameCharacters = 24;
    private static final int maxListDrawCommandContainers = 20;
    private static final int maxListDrawCommandElements = 40;
    private static final int maxPathNameCharacters = 50;

    private WatchAppValidator() {
    }

    private final boolean validateByteSize(WatchFile watchFile) {
        boolean z;
        if (watchFile.getBytes().length < 2048) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        throw new IllegalArgumentException(("File (" + watchFile.getFullPath() + ") must be smaller than 2048, but was " + watchFile.getBytes().length).toString());
    }

    private final boolean validateFileName(WatchFile watchFile) {
        boolean z;
        String input = watchFile.getFullPath();
        Intrinsics.checkNotNullExpressionValue(Pattern.compile("\\s"), "compile(...)");
        Intrinsics.checkNotNullParameter(input, "input");
        if (!r1.matcher(input).find()) {
            boolean z2 = false;
            if (watchFile.getFullPath().length() < 50) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (watchFile.getName().length() <= 24) {
                    z2 = true;
                }
                if (z2) {
                    return true;
                }
                throw new IllegalArgumentException(("File name: " + watchFile.getName() + " exceeds size limit").toString());
            }
            throw new IllegalArgumentException(("File name: " + watchFile.getFullPath() + " total path exceeds size limit").toString());
        }
        throw new IllegalArgumentException(("File name: " + watchFile.getFullPath() + " can't include whitespace").toString());
    }

    public final void validateAppFile(WatchFile file) {
        Intrinsics.checkNotNullParameter(file, "file");
        validateFileName(file);
        validateByteSize(file);
    }

    public final boolean validateDrawCommands(List<? extends DrawCommand> commands) {
        boolean z;
        Intrinsics.checkNotNullParameter(commands, "commands");
        ArrayList arrayList = new ArrayList();
        for (Object obj : commands) {
            if (obj instanceof ContainerCommand) {
                arrayList.add(obj);
            }
        }
        boolean z2 = false;
        if (arrayList.size() < 20) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (commands.size() < 40) {
                z2 = true;
            }
            if (z2) {
                return true;
            }
            throw new IllegalArgumentException("Validation of DrawCommands failed due to max number elements exceeded!".toString());
        }
        throw new IllegalArgumentException("Validation of DrawCommands failed due to max number of containers exceeded!".toString());
    }

    public final void validateLinkFile(WatchFile file) {
        Intrinsics.checkNotNullParameter(file, "file");
        validateFileName(file);
        validateByteSize(file);
    }

    public final void validatePictureFile(WatchFile file) {
        Intrinsics.checkNotNullParameter(file, "file");
        validateFileName(file);
    }

    public final void validateTextFile(WatchFile file) {
        Intrinsics.checkNotNullParameter(file, "file");
        validateFileName(file);
        validateByteSize(file);
    }

    public final void validateViewFile(WatchFile file) {
        Intrinsics.checkNotNullParameter(file, "file");
        validateFileName(file);
        validateByteSize(file);
    }
}
