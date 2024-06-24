package com.animaconnected.secondo.screens;

import android.widget.ImageView;
import androidx.emoji2.text.DefaultEmojiCompatConfig;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import com.animaconnected.secondo.screens.dashboard.DashboardFragment;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda1(int r1, Object obj, Object obj2, Object obj3) {
        this.$r8$classId = r1;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                MainActivity.animateWhatIsNew$lambda$15((DashboardFragment) this.f$0, (MainActivity) this.f$1, (ImageView) this.f$2);
                return;
            default:
                EmojiCompatInitializer.BackgroundDefaultLoader backgroundDefaultLoader = (EmojiCompatInitializer.BackgroundDefaultLoader) this.f$0;
                EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback = (EmojiCompat.MetadataRepoLoaderCallback) this.f$1;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f$2;
                backgroundDefaultLoader.getClass();
                try {
                    FontRequestEmojiCompatConfig create = DefaultEmojiCompatConfig.create(backgroundDefaultLoader.mContext);
                    if (create != null) {
                        FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = (FontRequestEmojiCompatConfig.FontRequestMetadataLoader) create.mMetadataLoader;
                        synchronized (fontRequestMetadataLoader.mLock) {
                            fontRequestMetadataLoader.mExecutor = threadPoolExecutor;
                        }
                        create.mMetadataLoader.load(new EmojiCompat.MetadataRepoLoaderCallback
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003e: INVOKE 
                              (wrap:androidx.emoji2.text.EmojiCompat$MetadataRepoLoader:0x0037: IGET (r0v5 'create' androidx.emoji2.text.FontRequestEmojiCompatConfig) A[Catch: all -> 0x004d, TRY_ENTER, WRAPPED] (LINE:56) androidx.emoji2.text.EmojiCompat.Config.mMetadataLoader androidx.emoji2.text.EmojiCompat$MetadataRepoLoader)
                              (wrap:androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$1:0x003b: CONSTRUCTOR 
                              (r1v1 'metadataRepoLoaderCallback' androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback)
                              (r2v1 'threadPoolExecutor' java.util.concurrent.ThreadPoolExecutor)
                             A[Catch: all -> 0x004d, MD:(androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback, java.util.concurrent.ThreadPoolExecutor):void (m), WRAPPED] (LINE:60) call: androidx.emoji2.text.EmojiCompatInitializer.BackgroundDefaultLoader.1.<init>(androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback, java.util.concurrent.ThreadPoolExecutor):void type: CONSTRUCTOR)
                             INTERFACE call: androidx.emoji2.text.EmojiCompat.MetadataRepoLoader.load(androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback):void A[Catch: all -> 0x004d, MD:(androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback):void (m), TRY_LEAVE] (LINE:63) in method: com.animaconnected.secondo.screens.MainActivity$$ExternalSyntheticLambda1.run():void, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:315)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                            	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:84)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                            	at java.base/java.util.ArrayList.forEach(Unknown Source)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: androidx.emoji2.text.EmojiCompatInitializer.BackgroundDefaultLoader.1.<init>(androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback, java.util.concurrent.ThreadPoolExecutor):void, class status: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:803)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 35 more
                            */
                        /*
                            this = this;
                            int r0 = r5.$r8$classId
                            switch(r0) {
                                case 0: goto L6;
                                default: goto L5;
                            }
                        L5:
                            goto L16
                        L6:
                            java.lang.Object r0 = r5.f$0
                            com.animaconnected.secondo.screens.dashboard.DashboardFragment r0 = (com.animaconnected.secondo.screens.dashboard.DashboardFragment) r0
                            java.lang.Object r1 = r5.f$1
                            com.animaconnected.secondo.screens.MainActivity r1 = (com.animaconnected.secondo.screens.MainActivity) r1
                            java.lang.Object r2 = r5.f$2
                            android.widget.ImageView r2 = (android.widget.ImageView) r2
                            com.animaconnected.secondo.screens.MainActivity.$r8$lambda$FGziKZMkCq4FcCLVB5IFJ3BhlGE(r0, r1, r2)
                            return
                        L16:
                            java.lang.Object r0 = r5.f$0
                            androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader r0 = (androidx.emoji2.text.EmojiCompatInitializer.BackgroundDefaultLoader) r0
                            java.lang.Object r1 = r5.f$1
                            androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r1 = (androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback) r1
                            java.lang.Object r2 = r5.f$2
                            java.util.concurrent.ThreadPoolExecutor r2 = (java.util.concurrent.ThreadPoolExecutor) r2
                            r0.getClass()
                            android.content.Context r0 = r0.mContext     // Catch: java.lang.Throwable -> L4d
                            androidx.emoji2.text.FontRequestEmojiCompatConfig r0 = androidx.emoji2.text.DefaultEmojiCompatConfig.create(r0)     // Catch: java.lang.Throwable -> L4d
                            if (r0 == 0) goto L45
                            androidx.emoji2.text.EmojiCompat$MetadataRepoLoader r3 = r0.mMetadataLoader     // Catch: java.lang.Throwable -> L4d
                            androidx.emoji2.text.FontRequestEmojiCompatConfig$FontRequestMetadataLoader r3 = (androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader) r3     // Catch: java.lang.Throwable -> L4d
                            java.lang.Object r4 = r3.mLock     // Catch: java.lang.Throwable -> L4d
                            monitor-enter(r4)     // Catch: java.lang.Throwable -> L4d
                            r3.mExecutor = r2     // Catch: java.lang.Throwable -> L42
                            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
                            androidx.emoji2.text.EmojiCompat$MetadataRepoLoader r0 = r0.mMetadataLoader     // Catch: java.lang.Throwable -> L4d
                            androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$1 r3 = new androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$1     // Catch: java.lang.Throwable -> L4d
                            r3.<init>()     // Catch: java.lang.Throwable -> L4d
                            r0.load(r3)     // Catch: java.lang.Throwable -> L4d
                            goto L54
                        L42:
                            r0 = move-exception
                            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
                            throw r0     // Catch: java.lang.Throwable -> L4d
                        L45:
                            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L4d
                            java.lang.String r3 = "EmojiCompat font provider not available on this device."
                            r0.<init>(r3)     // Catch: java.lang.Throwable -> L4d
                            throw r0     // Catch: java.lang.Throwable -> L4d
                        L4d:
                            r0 = move-exception
                            r1.onFailed(r0)
                            r2.shutdown()
                        L54:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.MainActivity$$ExternalSyntheticLambda1.run():void");
                    }
                }
