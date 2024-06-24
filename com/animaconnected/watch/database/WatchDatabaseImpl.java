package com.animaconnected.watch.database;

import androidx.compose.foundation.BorderStrokeKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.AfterVersion;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlSchema;
import com.animaconnected.watch.WatchDatabase;
import com.animaconnected.watch.filter.AncsQueries;
import com.animaconnected.watch.filter.ApplicationQueries;
import com.animaconnected.watch.filter.ImportantContactQueries;
import com.animaconnected.watch.fitness.DBActivityData;
import com.animaconnected.watch.fitness.DBDebug;
import com.animaconnected.watch.fitness.DBDeletedSessions;
import com.animaconnected.watch.fitness.DBDiagnostics;
import com.animaconnected.watch.fitness.DBElevation;
import com.animaconnected.watch.fitness.DBExercise;
import com.animaconnected.watch.fitness.DBFitnessIndex;
import com.animaconnected.watch.fitness.DBFitnessIndexProcessed;
import com.animaconnected.watch.fitness.DBGoal;
import com.animaconnected.watch.fitness.DBHeartrateData;
import com.animaconnected.watch.fitness.DBInterval;
import com.animaconnected.watch.fitness.DBLocationData;
import com.animaconnected.watch.fitness.DBPower;
import com.animaconnected.watch.fitness.DBProfile;
import com.animaconnected.watch.fitness.DBRestingHeartrateData;
import com.animaconnected.watch.fitness.DBSession;
import com.animaconnected.watch.fitness.DBSessionData;
import com.animaconnected.watch.fitness.DBSleepData;
import com.animaconnected.watch.fitness.DBSleepHistoryData;
import com.animaconnected.watch.fitness.DBSpeedCalibration;
import com.animaconnected.watch.fitness.DBStand;
import com.animaconnected.watch.fitness.DBStress;
import com.animaconnected.watch.fitness.DBWrist;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.StravaPendingUploads;
import com.animaconnected.watch.storage.models.BehaviourSlot;
import com.animaconnected.watch.storage.models.BehaviourSlotQueries;
import com.animaconnected.watch.storage.models.DBCurrentWatchQueries;
import com.animaconnected.watch.storage.models.DBWatch;
import com.animaconnected.watch.storage.models.DBWatchQueries;
import com.animaconnected.watch.sync.AppsQueries;
import com.animaconnected.watch.sync.ConfigQueries;
import com.animaconnected.watch.sync.DBApp;
import com.animaconnected.watch.sync.DBAppPositions;
import com.animaconnected.watch.sync.DBConfig;
import com.animaconnected.watch.sync.DBFile;
import com.animaconnected.watch.sync.DBPreferences;
import com.animaconnected.watch.sync.FilesQueries;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchDatabaseImpl.kt */
/* loaded from: classes3.dex */
public final class WatchDatabaseImpl extends TransacterImpl implements WatchDatabase {
    private final AncsQueries ancsQueries;
    private final ApplicationQueries applicationQueries;
    private final AppsQueries appsQueries;
    private final BehaviourSlotQueries behaviourSlotQueries;
    private final ConfigQueries configQueries;
    private final DBCurrentWatchQueries dBCurrentWatchQueries;
    private final DBWatchQueries dBWatchQueries;
    private final FilesQueries filesQueries;
    private final FitnessQueries fitnessQueries;
    private final ImportantContactQueries importantContactQueries;

    /* compiled from: WatchDatabaseImpl.kt */
    /* loaded from: classes3.dex */
    public static final class Schema implements SqlSchema<QueryResult.Value<Unit>> {
        public static final Schema INSTANCE = new Schema();

        private Schema() {
        }

        /* renamed from: migrateInternal-ElmaSbI, reason: not valid java name */
        private final Object m1061migrateInternalElmaSbI(SqlDriver sqlDriver, long j, long j2) {
            if (j <= 1 && j2 > 1) {
                sqlDriver.execute(null, "CREATE TABLE IF NOT EXISTS DBWatch (\n  device_address  TEXT PRIMARY KEY NOT NULL,\n  device_type INTEGER NOT NULL,\n  sku TEXT,\n  last_dfu_result TEXT NOT NULL DEFAULT \"None\",\n  time_diagnostics_sent INTEGER NOT NULL DEFAULT 0,\n  time_since_daily INTEGER NOT NULL DEFAULT 0\n)", null);
                sqlDriver.execute(null, "ALTER TABLE DBWatch ADD COLUMN stronger_vibration INTEGER NOT NULL DEFAULT 0", null);
            }
            if (j <= 2 && j2 > 2) {
                sqlDriver.execute(null, "ALTER TABLE DBWatch ADD COLUMN 'variant' INTEGER DEFAULT NULL", null);
            }
            if (j <= 3 && j2 > 3) {
                sqlDriver.execute(null, "ALTER TABLE DBWatch ADD COLUMN 'category' TEXT DEFAULT NULL", null);
            }
            if (j <= 4 && j2 > 4) {
                sqlDriver.execute(null, "CREATE TABLE DBHeartrateData (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  heartrate INTEGER NOT NULL,\n  confidence INTEGER NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBInterval (\n  identifier TEXT NOT NULL,\n  session_timestamp INTEGER NOT NULL,\n  start_timestamp INTEGER NOT NULL,\n  end_timestamp INTEGER NOT NULL,\n  PRIMARY KEY(identifier, session_timestamp, start_timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBActivityData (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  activity_class INTEGER,\n  walk_steps INTEGER,\n  run_steps INTEGER,\n  other_steps INTEGER,\n  rhythmic_steps_cadence INTEGER,\n  speed REAL,\n  distance INTEGER,\n  calories INTEGER,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBSessionData (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  state INTEGER NOT NULL,\n  type INTEGER,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBFile (\n  id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n  directory TEXT NOT NULL,\n  name TEXT NOT NULL,\n  hash TEXT NOT NULL,\n  size INTEGER NOT NULL,\n  CONSTRAINT UniqueFile UNIQUE (directory,name,hash,size)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBSession (\n  identifier TEXT NOT NULL,\n  start_timestamp INTEGER NOT NULL,\n  end_timestamp INTEGER NOT NULL,\n  total_time_ms INTEGER NOT NULL,\n  active_time_ms INTEGER NOT NULL,\n  total_distance_meter REAL NOT NULL,\n  steps INTEGER NOT NULL,\n  calories INTEGER NOT NULL,\n  elevationGain INTEGER NOT NULL,\n  type INTEGER,\n  PRIMARY KEY(identifier, start_timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBElevation (\n  identifier TEXT NOT NULL,\n  session_timestamp INTEGER NOT NULL,\n  number INTEGER NOT NULL, -- Index, but SQL didn't like that name\n  long REAL NOT NULL,\n  lat REAL NOT NULL,\n  elevation REAL NOT NULL,\n  resolution REAL NOT NULL,\n  FOREIGN KEY(identifier) REFERENCES DBSession(identifier),\n  FOREIGN KEY(session_timestamp) REFERENCES DBSession(start_timestamp),\n  PRIMARY KEY(identifier, session_timestamp, number)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBLocationData (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  long REAL NOT NULL,\n  lat REAL NOT NULL,\n  accuracy REAL NOT NULL,\n  altitude REAL NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBSleepData (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  sleep_state INTEGER NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBStand (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  successful_stands INTEGER NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBGoal (\n  timestamp INTEGER PRIMARY KEY NOT NULL,\n  identifier TEXT NOT NULL,\n  steps INTEGER NOT NULL,\n  stand INTEGER NOT NULL,\n  exercise INTEGER NOT NULL\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBExercise (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  active_minutes INTEGER NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBFitnessIndex (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  fitness_index REAL NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBStress (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  stress INTEGER NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBConfig (\n  identifier TEXT NOT NULL,\n  command TEXT NOT NULL,\n  data_hash INTEGER NOT NULL,\n  PRIMARY KEY(identifier, command)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBWrist (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  state INTEGER NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBAncsFilter (\n  identifier TEXT NOT NULL,\n  idx INTEGER NOT NULL,\n  ancs_category INTEGER,\n  ancs_attribute INTEGER,\n  search_string TEXT,\n  vibration_pattern INTEGER,\n  linked_filter_index INTEGER,\n  match_method INTEGER,\n  PRIMARY KEY(identifier, idx)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBImportantContact (\n  platform_specific_identifier TEXT PRIMARY KEY NOT NULL,\n  display_name TEXT NOT NULL,\n  phone_number TEXT,\n  email TEXT\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBSleepHistoryData (\n  identifier TEXT NOT NULL,\n  start INTEGER NOT NULL,\n  end INTEGER NOT NULL,\n  lightSleepMs INTEGER NOT NULL,\n  deepSleepMs INTEGER NOT NULL,\n  PRIMARY KEY(start)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBApplication (\n  identifier TEXT PRIMARY KEY NOT NULL,\n  setting INTEGER NOT NULL,\n  display_name TEXT NOT NULL\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBApp (\n  appId INTEGER PRIMARY KEY NOT NULL,\n  data_hash INTEGER NOT NULL\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBWatchFileSynced (\n  device_address TEXT NOT NULL,\n  file_id INTEGER NOT NULL,\n  FOREIGN KEY(file_id) REFERENCES DBFile(id),\n  PRIMARY KEY(device_address, file_id)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBAppPositions (\n  appId INTEGER PRIMARY KEY NOT NULL,\n  position INTEGER NOT NULL,\n  FOREIGN KEY(appId) REFERENCES DBApp(appId)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBQuickAction (\n  id INTEGER PRIMARY KEY NOT NULL,\n  appId INTEGER\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBRestingHeartrateData (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  restingHeartrate INTEGER NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE INDEX HeartrateDataIndex ON DBHeartrateData(timestamp)", null);
                sqlDriver.execute(null, "CREATE INDEX LocationDataIndex ON DBLocationData(timestamp)", null);
                sqlDriver.execute(null, "CREATE INDEX ActivityDataIndex ON DBActivityData(timestamp)", null);
            }
            if (j <= 5 && j2 > 5) {
                sqlDriver.execute(null, "CREATE TABLE DBProfile (\n  timestamp INTEGER PRIMARY KEY NOT NULL,\n  height INTEGER,\n  weight INTEGER,\n  ts_of_birth INTEGER,\n  gender INTEGER,\n  measurement INTEGER,\n  temperature INTEGER,\n  bedtime_hour INTEGER,\n  bedtime_min INTEGER\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBFile_new(\n    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    directory TEXT NOT NULL,\n    name TEXT NOT NULL,\n    hash TEXT NOT NULL,\n    size INTEGER NOT NULL,\n    pathHash TEXT DEFAULT NULL,\n    CONSTRAINT UniqueFile UNIQUE (directory,name,hash,size,pathHash)\n)", null);
                sqlDriver.execute(null, "INSERT INTO DBFile_new (id, directory, name, hash, size) SELECT id, directory, name, hash, size FROM DBFile", null);
                sqlDriver.execute(null, "DROP TABLE DBFile", null);
                sqlDriver.execute(null, "ALTER TABLE DBFile_new RENAME TO DBFile", null);
            }
            if (j <= 6 && j2 > 6) {
                sqlDriver.execute(null, "ALTER TABLE DBSessionData ADD COLUMN gps INTEGER", null);
                sqlDriver.execute(null, "ALTER TABLE DBSessionData ADD COLUMN session_id INTEGER NOT NULL DEFAULT -1", null);
                sqlDriver.execute(null, "ALTER TABLE DBLocationData ADD COLUMN accepted INTEGER DEFAULT 1 NOT NULL", null);
                sqlDriver.execute(null, "CREATE TABLE DBSession_new (\n  identifier TEXT NOT NULL,\n  start_timestamp INTEGER NOT NULL,\n  end_timestamp INTEGER NOT NULL,\n  total_time_ms INTEGER NOT NULL,\n  active_time_ms INTEGER NOT NULL,\n  total_distance_meter REAL NOT NULL,\n  steps INTEGER NOT NULL,\n  calories INTEGER NOT NULL,\n  elevationGain INTEGER NOT NULL,\n  type INTEGER NOT NULL,\n  gps INTEGER NOT NULL,\n  session_id INTEGER NOT NULL,\n  PRIMARY KEY(identifier, start_timestamp)\n)", null);
                sqlDriver.execute(null, "INSERT INTO DBSession_new (identifier, start_timestamp, end_timestamp, total_time_ms, active_time_ms, total_distance_meter, steps, calories, elevationGain, type, gps, session_id)\n\n-- Make \"type\" not null. If it's null (Workouts recorded on old Pascal firmware, default to Other(3))\n-- Gps is true for all previous recorded sessions. Insert 1\n-- session_id is almost the same as start_timestamp (FW can't gurantee that it is equal). Old recorded sessions will copy the start_timestamp as session_id.\nSELECT identifier,start_timestamp, end_timestamp, total_time_ms, active_time_ms, total_distance_meter, steps, calories, elevationGain, IFNULL(type, 3), 1, start_timestamp FROM DBSession", null);
                sqlDriver.execute(null, "DROP TABLE DBSession", null);
                sqlDriver.execute(null, "ALTER TABLE DBSession_new RENAME TO DBSession", null);
            }
            if (j <= 7 && j2 > 7) {
                sqlDriver.execute(null, "CREATE TABLE DBDeletedSessions (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
            }
            if (j <= 8 && j2 > 8) {
                sqlDriver.execute(null, "ALTER TABLE DBHeartrateData ADD COLUMN heartrate_low INTEGER", null);
                sqlDriver.execute(null, "ALTER TABLE DBHeartrateData ADD COLUMN heartrate_high INTEGER", null);
                sqlDriver.execute(null, "CREATE TABLE DBDebug (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  type INTEGER NOT NULL,\n  value INTEGER NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBDiagnostics (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  key TEXT NOT NULL,\n  value INTEGER NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
                sqlDriver.execute(null, "CREATE TABLE DBPower (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  state INTEGER NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
            }
            if (j <= 9 && j2 > 9) {
                sqlDriver.execute(null, "ALTER TABLE DBSession ADD COLUMN fitness_index REAL", null);
                sqlDriver.execute(null, "CREATE TABLE DBFitnessIndexProcessed (\n  identifier TEXT NOT NULL,\n  session_timestamp INTEGER NOT NULL,\n  processed_fitness_index REAL,\n  PRIMARY KEY(identifier, session_timestamp)\n)", null);
            }
            if (j <= 10 && j2 > 10) {
                sqlDriver.execute(null, "ALTER TABLE DBSession ADD COLUMN status INTEGER", null);
            }
            if (j <= 11 && j2 > 11) {
                sqlDriver.execute(null, "CREATE TABLE DBPreferences (\n  identifier TEXT NOT NULL,\n  preference TEXT NOT NULL,\n  value INTEGER,\n  PRIMARY KEY(identifier, preference)\n)", null);
                sqlDriver.execute(null, "DROP TABLE DBQuickAction", null);
            }
            if (j <= 12 && j2 > 12) {
                sqlDriver.execute(null, "CREATE TABLE StravaPendingUploads (\n    timestamp INTEGER NOT NULL REFERENCES DBSession(start_timestamp),\n    identifier TEXT NOT NULL REFERENCES DBSession(identifier),\n    failure_reason TEXT NOT NULL,\n    last_attempted_upload INTEGER NOT NULL,\n    UNIQUE (identifier, timestamp),\n    FOREIGN KEY (identifier, timestamp) REFERENCES DBSession(identifier, start_timestamp)\n)", null);
            }
            if (j <= 13 && j2 > 13) {
                sqlDriver.execute(null, "DROP TABLE DBPreferences", null);
                sqlDriver.execute(null, "CREATE TABLE DBPreferences (\n  identifier TEXT NOT NULL,\n  preferenceId INTEGER NOT NULL,\n  filename TEXT NOT NULL,\n  value TEXT, -- Base64 decoded bytes from msgpack\n  PRIMARY KEY(identifier, preferenceId)\n)", null);
            }
            if (j <= 14 && j2 > 14) {
                sqlDriver.execute(null, "CREATE TABLE DBPreferences_new (\n  identifier TEXT NOT NULL,\n  preferenceId INTEGER NOT NULL,\n  value TEXT, -- Base64 decoded bytes from msgpack\n  PRIMARY KEY(identifier, preferenceId)\n)", null);
                sqlDriver.execute(null, "INSERT INTO DBPreferences_new (identifier, preferenceId, value) SELECT identifier, preferenceId, value FROM DBPreferences", null);
                sqlDriver.execute(null, "DROP TABLE DBPreferences", null);
                sqlDriver.execute(null, "ALTER TABLE DBPreferences_new RENAME TO DBPreferences", null);
            }
            if (j <= 15 && j2 > 15) {
                sqlDriver.execute(null, "CREATE TABLE DBSpeedCalibration (\n  identifier TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  coefficient INTEGER NOT NULL,\n  PRIMARY KEY(identifier, timestamp)\n)", null);
            }
            if (j <= 16 && j2 > 16) {
                sqlDriver.execute(null, "DROP INDEX HeartrateDataIndex", null);
                sqlDriver.execute(null, "DROP INDEX LocationDataIndex", null);
                sqlDriver.execute(null, "DROP INDEX ActivityDataIndex", null);
                sqlDriver.execute(null, "CREATE TABLE DBActivityData_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  activity_class INTEGER,\n  walk_steps INTEGER,\n  run_steps INTEGER,\n  other_steps INTEGER,\n  rhythmic_steps_cadence INTEGER,\n  speed REAL,\n  distance INTEGER,\n  calories INTEGER,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBActivityData_new (hdid, timestamp, activity_class, walk_steps, run_steps, other_steps, rhythmic_steps_cadence, speed, distance, calories)\n    SELECT \"A-00000000\", timestamp, activity_class, walk_steps, run_steps, other_steps, rhythmic_steps_cadence, speed, distance, calories\n    FROM DBActivityData", null);
                sqlDriver.execute(null, "DROP TABLE DBActivityData", null);
                sqlDriver.execute(null, "ALTER TABLE DBActivityData_new RENAME TO DBActivityData", null);
                sqlDriver.execute(null, "CREATE TABLE DBHeartrateData_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  heartrate INTEGER NOT NULL,\n  confidence INTEGER NOT NULL,\n  heartrate_low INTEGER,\n  heartrate_high INTEGER,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBHeartrateData_new (hdid, timestamp, heartrate, confidence, heartrate_low, heartrate_high)\n    SELECT \"A-00000000\", timestamp, heartrate, confidence, heartrate_low, heartrate_high\n    FROM DBHeartrateData", null);
                sqlDriver.execute(null, "DROP TABLE DBHeartrateData", null);
                sqlDriver.execute(null, "ALTER TABLE DBHeartrateData_new RENAME TO DBHeartrateData", null);
                sqlDriver.execute(null, "CREATE TABLE DBDebug_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  type INTEGER NOT NULL,\n  value INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBDebug_new (hdid, timestamp, type, value)\n    SELECT \"A-00000000\", timestamp, type, value\n    FROM DBDebug", null);
                sqlDriver.execute(null, "DROP TABLE DBDebug", null);
                sqlDriver.execute(null, "ALTER TABLE DBDebug_new RENAME TO DBDebug", null);
                sqlDriver.execute(null, "CREATE TABLE DBDiagnostics_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  key TEXT NOT NULL,\n  value INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBDiagnostics_new (hdid, timestamp, key, value)\n    SELECT \"A-00000000\", timestamp, key, value\n    FROM DBDiagnostics", null);
                sqlDriver.execute(null, "DROP TABLE DBDiagnostics", null);
                sqlDriver.execute(null, "ALTER TABLE DBDiagnostics_new RENAME TO DBDiagnostics", null);
                sqlDriver.execute(null, "CREATE TABLE DBPower_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  state INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBPower_new (hdid, timestamp, state)\n    SELECT \"A-00000000\", timestamp, state\n    FROM DBPower", null);
                sqlDriver.execute(null, "DROP TABLE DBPower", null);
                sqlDriver.execute(null, "ALTER TABLE DBPower_new RENAME TO DBPower", null);
                sqlDriver.execute(null, "CREATE TABLE DBRestingHeartrateData_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  restingHeartrate INTEGER NOT NULL, -- 0 is inserted if resting HR has been processed but not enough data to give a good value\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBRestingHeartrateData_new (hdid, timestamp, restingHeartrate)\n    SELECT \"A-00000000\", timestamp, restingHeartrate\n    FROM DBRestingHeartrateData", null);
                sqlDriver.execute(null, "DROP TABLE DBRestingHeartrateData", null);
                sqlDriver.execute(null, "ALTER TABLE DBRestingHeartrateData_new RENAME TO DBRestingHeartrateData", null);
                sqlDriver.execute(null, "CREATE TABLE DBSleepData_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  sleep_state INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBSleepData_new (hdid, timestamp, sleep_state)\n    SELECT \"A-00000000\", timestamp, sleep_state\n    FROM DBSleepData", null);
                sqlDriver.execute(null, "DROP TABLE DBSleepData", null);
                sqlDriver.execute(null, "ALTER TABLE DBSleepData_new RENAME TO DBSleepData", null);
                sqlDriver.execute(null, "CREATE TABLE DBSleepHistoryData_new (\n  hdid TEXT NOT NULL,\n  start INTEGER NOT NULL,\n  end INTEGER NOT NULL,\n  lightSleepMs INTEGER NOT NULL,\n  deepSleepMs INTEGER NOT NULL,\n  PRIMARY KEY(start)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBSleepHistoryData_new (hdid, start, end, lightSleepMs, deepSleepMs)\n    SELECT \"A-00000000\", start, end, lightSleepMs, deepSleepMs\n    FROM DBSleepHistoryData", null);
                sqlDriver.execute(null, "DROP TABLE DBSleepHistoryData", null);
                sqlDriver.execute(null, "ALTER TABLE DBSleepHistoryData_new RENAME TO DBSleepHistoryData", null);
                sqlDriver.execute(null, "CREATE TABLE DBStand_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  successful_stands INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBStand_new (hdid, timestamp, successful_stands)\n    SELECT \"A-00000000\", timestamp, successful_stands\n    FROM DBStand", null);
                sqlDriver.execute(null, "DROP TABLE DBStand", null);
                sqlDriver.execute(null, "ALTER TABLE DBStand_new RENAME TO DBStand", null);
                sqlDriver.execute(null, "CREATE TABLE DBExercise_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  active_minutes INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBExercise_new (hdid, timestamp, active_minutes)\n    SELECT \"A-00000000\", timestamp, active_minutes\n    FROM DBExercise", null);
                sqlDriver.execute(null, "DROP TABLE DBExercise", null);
                sqlDriver.execute(null, "ALTER TABLE DBExercise_new RENAME TO DBExercise", null);
                sqlDriver.execute(null, "CREATE TABLE DBFitnessIndex_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  fitness_index REAL NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBFitnessIndex_new (hdid, timestamp, fitness_index)\n    SELECT \"A-00000000\", timestamp, fitness_index\n    FROM DBFitnessIndex", null);
                sqlDriver.execute(null, "DROP TABLE DBFitnessIndex", null);
                sqlDriver.execute(null, "ALTER TABLE DBFitnessIndex_new RENAME TO DBFitnessIndex", null);
                sqlDriver.execute(null, "CREATE TABLE DBFitnessIndexProcessed_new (\n  hdid TEXT NOT NULL,\n  session_timestamp INTEGER NOT NULL,\n  processed_fitness_index REAL,\n  PRIMARY KEY(hdid, session_timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBFitnessIndexProcessed_new (hdid, session_timestamp, processed_fitness_index)\n    SELECT \"A-00000000\", session_timestamp, processed_fitness_index\n    FROM DBFitnessIndexProcessed", null);
                sqlDriver.execute(null, "DROP TABLE DBFitnessIndexProcessed", null);
                sqlDriver.execute(null, "ALTER TABLE DBFitnessIndexProcessed_new RENAME TO DBFitnessIndexProcessed", null);
                sqlDriver.execute(null, "CREATE TABLE DBWrist_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  state INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBWrist_new (hdid, timestamp, state)\n    SELECT \"A-00000000\", timestamp, state\n    FROM DBWrist", null);
                sqlDriver.execute(null, "DROP TABLE DBWrist", null);
                sqlDriver.execute(null, "ALTER TABLE DBWrist_new RENAME TO DBWrist", null);
                sqlDriver.execute(null, "CREATE TABLE DBSpeedCalibration_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  coefficient INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBSpeedCalibration_new (hdid, timestamp, coefficient)\n    SELECT \"A-00000000\", timestamp, coefficient\n    FROM DBSpeedCalibration", null);
                sqlDriver.execute(null, "DROP TABLE DBSpeedCalibration", null);
                sqlDriver.execute(null, "ALTER TABLE DBSpeedCalibration_new RENAME TO DBSpeedCalibration", null);
                sqlDriver.execute(null, "CREATE TABLE DBStress_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  stress INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBStress_new (hdid, timestamp, stress)\n    SELECT \"A-00000000\", timestamp, stress\n    FROM DBStress", null);
                sqlDriver.execute(null, "DROP TABLE DBStress", null);
                sqlDriver.execute(null, "ALTER TABLE DBStress_new RENAME TO DBStress", null);
                sqlDriver.execute(null, "CREATE TABLE DBSessionData_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  state INTEGER NOT NULL,\n  type INTEGER,\n  gps INTEGER,\n  session_id INTEGER NOT NULL DEFAULT -1, -- Legacy sessions will have -1. See FitnessData.kt:legacySessionEntrySessionId\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBSessionData_new (hdid, timestamp, state, type, gps, session_id)\n    SELECT \"A-00000000\", timestamp, state, type, gps, session_id\n    FROM DBSessionData", null);
                sqlDriver.execute(null, "DROP TABLE DBSessionData", null);
                sqlDriver.execute(null, "ALTER TABLE DBSessionData_new RENAME TO DBSessionData", null);
                sqlDriver.execute(null, "CREATE TABLE DBDeletedSessions_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBDeletedSessions_new (hdid, timestamp)\n    SELECT \"A-00000000\", timestamp\n    FROM DBDeletedSessions", null);
                sqlDriver.execute(null, "DROP TABLE DBDeletedSessions", null);
                sqlDriver.execute(null, "ALTER TABLE DBDeletedSessions_new RENAME TO DBDeletedSessions", null);
                sqlDriver.execute(null, "CREATE TABLE DBLocationData_new (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  long REAL NOT NULL,\n  lat REAL NOT NULL,\n  accuracy REAL NOT NULL,\n  altitude REAL NOT NULL,\n  accepted INTEGER DEFAULT 1 NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBLocationData_new (hdid, timestamp, long, lat, accuracy, altitude, accepted)\n    SELECT \"A-00000000\", timestamp, long, lat, accuracy, altitude, accepted\n    FROM DBLocationData", null);
                sqlDriver.execute(null, "DROP TABLE DBLocationData", null);
                sqlDriver.execute(null, "ALTER TABLE DBLocationData_new RENAME TO DBLocationData", null);
                sqlDriver.execute(null, "CREATE TABLE DBSession_new (\n  hdid TEXT NOT NULL,\n  start_timestamp INTEGER NOT NULL,\n  end_timestamp INTEGER NOT NULL,\n  total_time_ms INTEGER NOT NULL,\n  active_time_ms INTEGER NOT NULL,\n  total_distance_meter REAL NOT NULL,\n  steps INTEGER NOT NULL,\n  calories INTEGER NOT NULL,\n  elevationGain INTEGER NOT NULL,\n  type INTEGER NOT NULL,\n  gps INTEGER NOT NULL,\n  session_id INTEGER NOT NULL,\n  fitness_index REAL,\n  status INTEGER,\n  PRIMARY KEY(hdid, start_timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBSession_new (hdid, start_timestamp, end_timestamp, total_time_ms, active_time_ms, total_distance_meter, steps, calories, elevationGain, type, gps, session_id, fitness_index, status)\n    SELECT \"A-00000000\", start_timestamp, end_timestamp, total_time_ms, active_time_ms, total_distance_meter, steps, calories, elevationGain, type, gps, session_id, fitness_index, status\n    FROM DBSession", null);
                sqlDriver.execute(null, "DROP TABLE DBSession", null);
                sqlDriver.execute(null, "ALTER TABLE DBSession_new RENAME TO DBSession", null);
                sqlDriver.execute(null, "CREATE TABLE DBInterval_new (\n  hdid TEXT NOT NULL,\n  session_timestamp INTEGER NOT NULL,\n  start_timestamp INTEGER NOT NULL,\n  end_timestamp INTEGER NOT NULL,\n  PRIMARY KEY(hdid, session_timestamp, start_timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBInterval_new (hdid, session_timestamp, start_timestamp, end_timestamp)\n    SELECT \"A-00000000\", session_timestamp, start_timestamp, end_timestamp\n    FROM DBInterval", null);
                sqlDriver.execute(null, "DROP TABLE DBInterval", null);
                sqlDriver.execute(null, "ALTER TABLE DBInterval_new RENAME TO DBInterval", null);
                sqlDriver.execute(null, "CREATE TABLE DBElevation_new (\n  hdid TEXT NOT NULL,\n  session_timestamp INTEGER NOT NULL,\n  number INTEGER NOT NULL, -- Index, but SQL didn't like that name\n  long REAL NOT NULL,\n  lat REAL NOT NULL,\n  elevation REAL NOT NULL,\n  resolution REAL NOT NULL,\n  FOREIGN KEY(hdid) REFERENCES DBSession(hdid),\n  FOREIGN KEY(session_timestamp) REFERENCES DBSession(start_timestamp),\n  PRIMARY KEY(hdid, session_timestamp, number)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBElevation_new (hdid, session_timestamp, number, long, lat, elevation, resolution)\n    SELECT \"A-00000000\", session_timestamp, number, long, lat, elevation, resolution\n    FROM DBElevation", null);
                sqlDriver.execute(null, "DROP TABLE DBElevation", null);
                sqlDriver.execute(null, "ALTER TABLE DBElevation_new RENAME TO DBElevation", null);
                sqlDriver.execute(null, "CREATE TABLE DBGoal_new (\n  timestamp INTEGER PRIMARY KEY NOT NULL,\n  hdid TEXT NOT NULL,\n  steps INTEGER NOT NULL,\n  stand INTEGER NOT NULL,\n  exercise INTEGER NOT NULL\n)", null);
                sqlDriver.execute(null, "REPLACE INTO DBGoal_new (timestamp, hdid, steps, stand, exercise)\n    SELECT timestamp, \"A-00000000\", steps, stand, exercise\n    FROM DBGoal", null);
                sqlDriver.execute(null, "DROP TABLE DBGoal", null);
                sqlDriver.execute(null, "ALTER TABLE DBGoal_new RENAME TO DBGoal", null);
                sqlDriver.execute(null, "CREATE TABLE StravaPendingUploads_new (\n    timestamp INTEGER NOT NULL REFERENCES DBSession(start_timestamp),\n    hdid TEXT NOT NULL REFERENCES DBSession(hdid),\n    failure_reason TEXT NOT NULL,\n    last_attempted_upload INTEGER NOT NULL,\n    UNIQUE (hdid, timestamp),\n    FOREIGN KEY (hdid, timestamp) REFERENCES DBSession(hdid, start_timestamp)\n)", null);
                sqlDriver.execute(null, "REPLACE INTO StravaPendingUploads_new (timestamp, hdid, failure_reason, last_attempted_upload)\n    SELECT timestamp, \"A-00000000\", failure_reason, last_attempted_upload\n    FROM StravaPendingUploads", null);
                sqlDriver.execute(null, "DROP TABLE StravaPendingUploads", null);
                sqlDriver.execute(null, "ALTER TABLE StravaPendingUploads_new RENAME TO StravaPendingUploads", null);
                sqlDriver.execute(null, "CREATE INDEX HeartrateDataIndex ON DBHeartrateData(timestamp)", null);
                sqlDriver.execute(null, "CREATE INDEX LocationDataIndex ON DBLocationData(timestamp)", null);
                sqlDriver.execute(null, "CREATE INDEX ActivityDataIndex ON DBActivityData(timestamp)", null);
            }
            QueryResult.Companion.getClass();
            return QueryResult.Companion.Unit;
        }

        @Override // app.cash.sqldelight.db.SqlSchema
        public /* synthetic */ QueryResult.Value<Unit> create(SqlDriver sqlDriver) {
            return new QueryResult.Value<>(m1062create0iQ1z0(sqlDriver));
        }

        /* renamed from: create-0iQ1-z0, reason: not valid java name */
        public Object m1062create0iQ1z0(SqlDriver driver) {
            Intrinsics.checkNotNullParameter(driver, "driver");
            driver.execute(null, "CREATE TABLE DBAncsFilter (\n  identifier TEXT NOT NULL,\n  idx INTEGER NOT NULL,\n  ancs_category INTEGER,\n  ancs_attribute INTEGER,\n  search_string TEXT,\n  vibration_pattern INTEGER,\n  linked_filter_index INTEGER,\n  match_method INTEGER,\n  PRIMARY KEY(identifier, idx)\n)", null);
            driver.execute(null, "CREATE TABLE DBApplication (\n  identifier TEXT PRIMARY KEY NOT NULL,\n  setting INTEGER NOT NULL,\n  display_name TEXT NOT NULL\n)", null);
            driver.execute(null, "CREATE TABLE DBApp (\n  appId INTEGER PRIMARY KEY NOT NULL,\n  data_hash INTEGER NOT NULL\n)", null);
            driver.execute(null, "CREATE TABLE DBAppPositions (\n  appId INTEGER PRIMARY KEY NOT NULL,\n  position INTEGER NOT NULL,\n  FOREIGN KEY(appId) REFERENCES DBApp(appId)\n)", null);
            driver.execute(null, "CREATE TABLE BehaviourSlot (\n  behaviour_type TEXT NOT NULL,\n  group_layer INTEGER NOT NULL,\n  slot INTEGER NOT NULL,\n PRIMARY KEY(behaviour_type, group_layer)\n)", null);
            driver.execute(null, "CREATE TABLE DBConfig (\n  identifier TEXT NOT NULL,\n  command TEXT NOT NULL,\n  data_hash INTEGER NOT NULL,\n  PRIMARY KEY(identifier, command)\n)", null);
            driver.execute(null, "CREATE TABLE DBPreferences (\n  identifier TEXT NOT NULL,\n  preferenceId INTEGER NOT NULL,\n  value TEXT, -- Base64 decoded bytes from msgpack\n  PRIMARY KEY(identifier, preferenceId)\n)", null);
            driver.execute(null, "CREATE TABLE DBCurrentWatch(\nid INTEGER PRIMARY KEY NOT NULL,\ncurrent_address TEXT\n)", null);
            driver.execute(null, "CREATE TABLE DBWatch (\n  device_address  TEXT PRIMARY KEY NOT NULL,\n  device_type INTEGER NOT NULL,\n  sku TEXT,\n  last_dfu_result TEXT NOT NULL DEFAULT \"None\",\n  stronger_vibration INTEGER NOT NULL DEFAULT 0,\n  time_diagnostics_sent INTEGER NOT NULL DEFAULT 0,\n  time_since_daily INTEGER NOT NULL DEFAULT 0,\n  variant INTEGER DEFAULT NULL,\n  category TEXT DEFAULT NULL\n)", null);
            driver.execute(null, "CREATE TABLE DBFile (\n  id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n  directory TEXT NOT NULL,\n  name TEXT NOT NULL,\n  hash TEXT NOT NULL,\n  size INTEGER NOT NULL,\n  pathHash TEXT DEFAULT NULL,\n  CONSTRAINT UniqueFile UNIQUE (directory,name,hash,size,pathHash)\n)", null);
            driver.execute(null, "CREATE TABLE DBWatchFileSynced (\n  device_address TEXT NOT NULL,\n  file_id INTEGER NOT NULL,\n  FOREIGN KEY(file_id) REFERENCES DBFile(id),\n  PRIMARY KEY(device_address, file_id)\n)", null);
            driver.execute(null, "CREATE TABLE DBActivityData (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  activity_class INTEGER,\n  walk_steps INTEGER,\n  run_steps INTEGER,\n  other_steps INTEGER,\n  rhythmic_steps_cadence INTEGER,\n  speed REAL,\n  distance INTEGER,\n  calories INTEGER,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBHeartrateData (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  heartrate INTEGER NOT NULL,\n  confidence INTEGER NOT NULL,\n  heartrate_low INTEGER,\n  heartrate_high INTEGER,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBDebug (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  type INTEGER NOT NULL,\n  value INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBDiagnostics (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  key TEXT NOT NULL,\n  value INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBPower (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  state INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBRestingHeartrateData (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  restingHeartrate INTEGER NOT NULL, -- 0 is inserted if resting HR has been processed but not enough data to give a good value\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBSleepData (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  sleep_state INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBSleepHistoryData (\n  hdid TEXT NOT NULL,\n  start INTEGER NOT NULL,\n  end INTEGER NOT NULL,\n  lightSleepMs INTEGER NOT NULL,\n  deepSleepMs INTEGER NOT NULL,\n  PRIMARY KEY(start)\n)", null);
            driver.execute(null, "CREATE TABLE DBStand (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  successful_stands INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBExercise (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  active_minutes INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBFitnessIndex (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  fitness_index REAL NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBFitnessIndexProcessed (\n  hdid TEXT NOT NULL,\n  session_timestamp INTEGER NOT NULL,\n  processed_fitness_index REAL,\n  PRIMARY KEY(hdid, session_timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBWrist (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  state INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBSpeedCalibration (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  coefficient INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBStress (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  stress INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBSessionData (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  state INTEGER NOT NULL,\n  type INTEGER,\n  gps INTEGER,\n  session_id INTEGER NOT NULL DEFAULT -1, -- Legacy sessions will have -1. See FitnessData.kt:legacySessionEntrySessionId\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBDeletedSessions (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBLocationData (\n  hdid TEXT NOT NULL,\n  timestamp INTEGER NOT NULL,\n  long REAL NOT NULL,\n  lat REAL NOT NULL,\n  accuracy REAL NOT NULL,\n  altitude REAL NOT NULL,\n  accepted INTEGER DEFAULT 1 NOT NULL,\n  PRIMARY KEY(hdid, timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBSession (\n  hdid TEXT NOT NULL,\n  start_timestamp INTEGER NOT NULL,\n  end_timestamp INTEGER NOT NULL,\n  total_time_ms INTEGER NOT NULL,\n  active_time_ms INTEGER NOT NULL,\n  total_distance_meter REAL NOT NULL,\n  steps INTEGER NOT NULL,\n  calories INTEGER NOT NULL,\n  elevationGain INTEGER NOT NULL,\n  type INTEGER NOT NULL,\n  gps INTEGER NOT NULL,\n  session_id INTEGER NOT NULL,\n  fitness_index REAL,\n  status INTEGER,\n  PRIMARY KEY(hdid, start_timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBInterval (\n  hdid TEXT NOT NULL,\n  session_timestamp INTEGER NOT NULL,\n  start_timestamp INTEGER NOT NULL,\n  end_timestamp INTEGER NOT NULL,\n  PRIMARY KEY(hdid, session_timestamp, start_timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBElevation (\n  hdid TEXT NOT NULL,\n  session_timestamp INTEGER NOT NULL,\n  number INTEGER NOT NULL, -- Index, but SQL didn't like that name\n  long REAL NOT NULL,\n  lat REAL NOT NULL,\n  elevation REAL NOT NULL,\n  resolution REAL NOT NULL,\n  FOREIGN KEY(hdid) REFERENCES DBSession(hdid),\n  FOREIGN KEY(session_timestamp) REFERENCES DBSession(start_timestamp),\n  PRIMARY KEY(hdid, session_timestamp, number)\n)", null);
            driver.execute(null, "CREATE TABLE DBGoal (\n  timestamp INTEGER PRIMARY KEY NOT NULL,\n  hdid TEXT NOT NULL,\n  steps INTEGER NOT NULL,\n  stand INTEGER NOT NULL,\n  exercise INTEGER NOT NULL\n)", null);
            driver.execute(null, "CREATE TABLE DBProfile (\n  timestamp INTEGER PRIMARY KEY NOT NULL,\n  height INTEGER,\n  weight INTEGER,\n  ts_of_birth INTEGER,\n  gender INTEGER,\n  measurement INTEGER,\n  temperature INTEGER,\n  bedtime_hour INTEGER,\n  bedtime_min INTEGER\n)", null);
            driver.execute(null, "CREATE TABLE StravaPendingUploads (\n    timestamp INTEGER NOT NULL REFERENCES DBSession(start_timestamp),\n    hdid TEXT NOT NULL REFERENCES DBSession(hdid),\n    failure_reason TEXT NOT NULL,\n    last_attempted_upload INTEGER NOT NULL,\n    UNIQUE (hdid, timestamp),\n    FOREIGN KEY (hdid, timestamp) REFERENCES DBSession(hdid, start_timestamp)\n)", null);
            driver.execute(null, "CREATE TABLE DBImportantContact (\n  platform_specific_identifier TEXT PRIMARY KEY NOT NULL,\n  display_name TEXT NOT NULL,\n  phone_number TEXT,\n  email TEXT\n)", null);
            driver.execute(null, "CREATE INDEX HeartrateDataIndex ON DBHeartrateData(timestamp)", null);
            driver.execute(null, "CREATE INDEX LocationDataIndex ON DBLocationData(timestamp)", null);
            driver.execute(null, "CREATE INDEX ActivityDataIndex ON DBActivityData(timestamp)", null);
            QueryResult.Companion.getClass();
            return QueryResult.Companion.Unit;
        }

        @Override // app.cash.sqldelight.db.SqlSchema
        public long getVersion() {
            return 17L;
        }

        @Override // app.cash.sqldelight.db.SqlSchema
        public /* synthetic */ QueryResult.Value<Unit> migrate(SqlDriver sqlDriver, long j, long j2, AfterVersion[] afterVersionArr) {
            return new QueryResult.Value<>(m1063migratezeHU3Mk(sqlDriver, j, j2, afterVersionArr));
        }

        /* renamed from: migrate-zeHU3Mk, reason: not valid java name */
        public Object m1063migratezeHU3Mk(SqlDriver driver, long j, long j2, AfterVersion... callbacks) {
            boolean z;
            Intrinsics.checkNotNullParameter(driver, "driver");
            Intrinsics.checkNotNullParameter(callbacks, "callbacks");
            ArrayList arrayList = new ArrayList();
            for (AfterVersion afterVersion : callbacks) {
                afterVersion.getClass();
                if (j <= 0 && 0 < j2) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    arrayList.add(afterVersion);
                }
            }
            Iterator it = CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.animaconnected.watch.database.WatchDatabaseImpl$Schema$migrate-zeHU3Mk$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    ((AfterVersion) t).getClass();
                    ((AfterVersion) t2).getClass();
                    return BorderStrokeKt.compareValues(0L, 0L);
                }
            }).iterator();
            if (!it.hasNext()) {
                if (j < j2) {
                    m1061migrateInternalElmaSbI(driver, j, j2);
                }
                QueryResult.Companion.getClass();
                return QueryResult.Companion.Unit;
            }
            AfterVersion afterVersion2 = (AfterVersion) it.next();
            Schema schema = INSTANCE;
            afterVersion2.getClass();
            schema.m1061migrateInternalElmaSbI(driver, j, 1L);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchDatabaseImpl(SqlDriver driver, BehaviourSlot.Adapter BehaviourSlotAdapter, DBActivityData.Adapter DBActivityDataAdapter, DBApp.Adapter DBAppAdapter, DBAppPositions.Adapter DBAppPositionsAdapter, DBConfig.Adapter DBConfigAdapter, DBDebug.Adapter DBDebugAdapter, DBDeletedSessions.Adapter DBDeletedSessionsAdapter, DBDiagnostics.Adapter DBDiagnosticsAdapter, DBElevation.Adapter DBElevationAdapter, DBExercise.Adapter DBExerciseAdapter, DBFile.Adapter DBFileAdapter, DBFitnessIndex.Adapter DBFitnessIndexAdapter, DBFitnessIndexProcessed.Adapter DBFitnessIndexProcessedAdapter, DBGoal.Adapter DBGoalAdapter, DBHeartrateData.Adapter DBHeartrateDataAdapter, DBInterval.Adapter DBIntervalAdapter, DBLocationData.Adapter DBLocationDataAdapter, DBPower.Adapter DBPowerAdapter, DBPreferences.Adapter DBPreferencesAdapter, DBProfile.Adapter DBProfileAdapter, DBRestingHeartrateData.Adapter DBRestingHeartrateDataAdapter, DBSession.Adapter DBSessionAdapter, DBSessionData.Adapter DBSessionDataAdapter, DBSleepData.Adapter DBSleepDataAdapter, DBSleepHistoryData.Adapter DBSleepHistoryDataAdapter, DBSpeedCalibration.Adapter DBSpeedCalibrationAdapter, DBStand.Adapter DBStandAdapter, DBStress.Adapter DBStressAdapter, DBWatch.Adapter DBWatchAdapter, DBWrist.Adapter DBWristAdapter, StravaPendingUploads.Adapter StravaPendingUploadsAdapter) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(BehaviourSlotAdapter, "BehaviourSlotAdapter");
        Intrinsics.checkNotNullParameter(DBActivityDataAdapter, "DBActivityDataAdapter");
        Intrinsics.checkNotNullParameter(DBAppAdapter, "DBAppAdapter");
        Intrinsics.checkNotNullParameter(DBAppPositionsAdapter, "DBAppPositionsAdapter");
        Intrinsics.checkNotNullParameter(DBConfigAdapter, "DBConfigAdapter");
        Intrinsics.checkNotNullParameter(DBDebugAdapter, "DBDebugAdapter");
        Intrinsics.checkNotNullParameter(DBDeletedSessionsAdapter, "DBDeletedSessionsAdapter");
        Intrinsics.checkNotNullParameter(DBDiagnosticsAdapter, "DBDiagnosticsAdapter");
        Intrinsics.checkNotNullParameter(DBElevationAdapter, "DBElevationAdapter");
        Intrinsics.checkNotNullParameter(DBExerciseAdapter, "DBExerciseAdapter");
        Intrinsics.checkNotNullParameter(DBFileAdapter, "DBFileAdapter");
        Intrinsics.checkNotNullParameter(DBFitnessIndexAdapter, "DBFitnessIndexAdapter");
        Intrinsics.checkNotNullParameter(DBFitnessIndexProcessedAdapter, "DBFitnessIndexProcessedAdapter");
        Intrinsics.checkNotNullParameter(DBGoalAdapter, "DBGoalAdapter");
        Intrinsics.checkNotNullParameter(DBHeartrateDataAdapter, "DBHeartrateDataAdapter");
        Intrinsics.checkNotNullParameter(DBIntervalAdapter, "DBIntervalAdapter");
        Intrinsics.checkNotNullParameter(DBLocationDataAdapter, "DBLocationDataAdapter");
        Intrinsics.checkNotNullParameter(DBPowerAdapter, "DBPowerAdapter");
        Intrinsics.checkNotNullParameter(DBPreferencesAdapter, "DBPreferencesAdapter");
        Intrinsics.checkNotNullParameter(DBProfileAdapter, "DBProfileAdapter");
        Intrinsics.checkNotNullParameter(DBRestingHeartrateDataAdapter, "DBRestingHeartrateDataAdapter");
        Intrinsics.checkNotNullParameter(DBSessionAdapter, "DBSessionAdapter");
        Intrinsics.checkNotNullParameter(DBSessionDataAdapter, "DBSessionDataAdapter");
        Intrinsics.checkNotNullParameter(DBSleepDataAdapter, "DBSleepDataAdapter");
        Intrinsics.checkNotNullParameter(DBSleepHistoryDataAdapter, "DBSleepHistoryDataAdapter");
        Intrinsics.checkNotNullParameter(DBSpeedCalibrationAdapter, "DBSpeedCalibrationAdapter");
        Intrinsics.checkNotNullParameter(DBStandAdapter, "DBStandAdapter");
        Intrinsics.checkNotNullParameter(DBStressAdapter, "DBStressAdapter");
        Intrinsics.checkNotNullParameter(DBWatchAdapter, "DBWatchAdapter");
        Intrinsics.checkNotNullParameter(DBWristAdapter, "DBWristAdapter");
        Intrinsics.checkNotNullParameter(StravaPendingUploadsAdapter, "StravaPendingUploadsAdapter");
        this.ancsQueries = new AncsQueries(driver);
        this.applicationQueries = new ApplicationQueries(driver);
        this.appsQueries = new AppsQueries(driver, DBAppAdapter, DBAppPositionsAdapter);
        this.behaviourSlotQueries = new BehaviourSlotQueries(driver, BehaviourSlotAdapter);
        this.configQueries = new ConfigQueries(driver, DBConfigAdapter, DBPreferencesAdapter);
        this.dBCurrentWatchQueries = new DBCurrentWatchQueries(driver, DBWatchAdapter);
        this.dBWatchQueries = new DBWatchQueries(driver, DBWatchAdapter);
        this.filesQueries = new FilesQueries(driver, DBFileAdapter);
        this.fitnessQueries = new FitnessQueries(driver, DBActivityDataAdapter, DBHeartrateDataAdapter, DBDebugAdapter, DBDiagnosticsAdapter, DBPowerAdapter, DBRestingHeartrateDataAdapter, DBSleepDataAdapter, DBSleepHistoryDataAdapter, DBStandAdapter, DBExerciseAdapter, DBFitnessIndexAdapter, DBFitnessIndexProcessedAdapter, DBWristAdapter, DBSpeedCalibrationAdapter, DBStressAdapter, DBSessionDataAdapter, DBDeletedSessionsAdapter, DBLocationDataAdapter, DBSessionAdapter, DBIntervalAdapter, DBElevationAdapter, DBGoalAdapter, DBProfileAdapter, StravaPendingUploadsAdapter);
        this.importantContactQueries = new ImportantContactQueries(driver);
    }

    @Override // com.animaconnected.watch.WatchDatabase
    public AncsQueries getAncsQueries() {
        return this.ancsQueries;
    }

    @Override // com.animaconnected.watch.WatchDatabase
    public ApplicationQueries getApplicationQueries() {
        return this.applicationQueries;
    }

    @Override // com.animaconnected.watch.WatchDatabase
    public AppsQueries getAppsQueries() {
        return this.appsQueries;
    }

    @Override // com.animaconnected.watch.WatchDatabase
    public BehaviourSlotQueries getBehaviourSlotQueries() {
        return this.behaviourSlotQueries;
    }

    @Override // com.animaconnected.watch.WatchDatabase
    public ConfigQueries getConfigQueries() {
        return this.configQueries;
    }

    @Override // com.animaconnected.watch.WatchDatabase
    public DBCurrentWatchQueries getDBCurrentWatchQueries() {
        return this.dBCurrentWatchQueries;
    }

    @Override // com.animaconnected.watch.WatchDatabase
    public DBWatchQueries getDBWatchQueries() {
        return this.dBWatchQueries;
    }

    @Override // com.animaconnected.watch.WatchDatabase
    public FilesQueries getFilesQueries() {
        return this.filesQueries;
    }

    @Override // com.animaconnected.watch.WatchDatabase
    public FitnessQueries getFitnessQueries() {
        return this.fitnessQueries;
    }

    @Override // com.animaconnected.watch.WatchDatabase
    public ImportantContactQueries getImportantContactQueries() {
        return this.importantContactQueries;
    }
}
