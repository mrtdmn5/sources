package com.amplifyframework.core;

import android.content.Context;
import android.content.res.Resources;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class Resources {

    /* loaded from: classes.dex */
    public static final class ResourceLoadingException extends Exception {
        private static final long serialVersionUID = 1;

        public ResourceLoadingException(String str, Throwable th) {
            super(str, th);
        }
    }

    private Resources() {
    }

    public static int getRawResourceId(Context context, String str) throws ResourceLoadingException {
        try {
            return context.getResources().getIdentifier(str, "raw", context.getPackageName());
        } catch (Exception e) {
            throw new ResourceLoadingException(ConstraintSet$$ExternalSyntheticOutline0.m("No such resource with identifier ", str), e);
        }
    }

    public static JSONObject readJsonResource(Context context, String str) throws ResourceLoadingException {
        return readJsonResourceFromId(context, getRawResourceId(context, str));
    }

    public static JSONObject readJsonResourceFromId(Context context, int r4) throws ResourceLoadingException {
        try {
            Scanner scanner = new Scanner(context.getResources().openRawResource(r4));
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
            scanner.close();
            try {
                return new JSONObject(sb.toString());
            } catch (JSONException e) {
                throw new ResourceLoadingException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Failed to read the resource with ID ", r4, InstructionFileId.DOT), e);
            }
        } catch (Resources.NotFoundException e2) {
            throw new ResourceLoadingException(SubMenuBuilder$$ExternalSyntheticOutline0.m("No such resource with ID = ", r4), e2);
        }
    }
}
