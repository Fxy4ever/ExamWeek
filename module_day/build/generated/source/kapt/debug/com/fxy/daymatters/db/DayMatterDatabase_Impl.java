package com.fxy.daymatters.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import com.fxy.daymatters.dao.DayMatterDao;
import com.fxy.daymatters.dao.DayMatterDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class DayMatterDatabase_Impl extends DayMatterDatabase {
  private volatile DayMatterDao _dayMatterDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Affair` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `startTime` TEXT, `classify` TEXT, `isNotify` INTEGER NOT NULL, `isChineseDay` INTEGER NOT NULL, `endTime` TEXT, `background` TEXT, `textColor` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"2f9dec66f51647b5ebead8859bf85890\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Affair`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAffair = new HashMap<String, TableInfo.Column>(9);
        _columnsAffair.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsAffair.put("title", new TableInfo.Column("title", "TEXT", false, 0));
        _columnsAffair.put("startTime", new TableInfo.Column("startTime", "TEXT", false, 0));
        _columnsAffair.put("classify", new TableInfo.Column("classify", "TEXT", false, 0));
        _columnsAffair.put("isNotify", new TableInfo.Column("isNotify", "INTEGER", true, 0));
        _columnsAffair.put("isChineseDay", new TableInfo.Column("isChineseDay", "INTEGER", true, 0));
        _columnsAffair.put("endTime", new TableInfo.Column("endTime", "TEXT", false, 0));
        _columnsAffair.put("background", new TableInfo.Column("background", "TEXT", false, 0));
        _columnsAffair.put("textColor", new TableInfo.Column("textColor", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAffair = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAffair = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAffair = new TableInfo("Affair", _columnsAffair, _foreignKeysAffair, _indicesAffair);
        final TableInfo _existingAffair = TableInfo.read(_db, "Affair");
        if (! _infoAffair.equals(_existingAffair)) {
          throw new IllegalStateException("Migration didn't properly handle Affair(com.fxy.daymatters.bean.Affair).\n"
                  + " Expected:\n" + _infoAffair + "\n"
                  + " Found:\n" + _existingAffair);
        }
      }
    }, "2f9dec66f51647b5ebead8859bf85890", "b5f09c03778d924575ca13dc214f32b5");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Affair");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Affair`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public DayMatterDao dayMattersDao() {
    if (_dayMatterDao != null) {
      return _dayMatterDao;
    } else {
      synchronized(this) {
        if(_dayMatterDao == null) {
          _dayMatterDao = new DayMatterDao_Impl(this);
        }
        return _dayMatterDao;
      }
    }
  }
}
