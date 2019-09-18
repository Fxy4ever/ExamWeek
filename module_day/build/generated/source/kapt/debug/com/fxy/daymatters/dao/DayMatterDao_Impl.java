package com.fxy.daymatters.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.fxy.daymatters.bean.Affair;
import io.reactivex.Flowable;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public class DayMatterDao_Impl implements DayMatterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAffair;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfAffair;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfAffair;

  public DayMatterDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAffair = new EntityInsertionAdapter<Affair>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Affair`(`id`,`title`,`startTime`,`classify`,`isNotify`,`isChineseDay`,`endTime`,`background`,`textColor`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Affair value) {
        stmt.bindLong(1, value.getDayMatterId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getStartTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStartTime());
        }
        if (value.getClassify() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getClassify());
        }
        final int _tmp;
        _tmp = value.isNotify() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        final int _tmp_1;
        _tmp_1 = value.isChineseDay() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        if (value.getEndTime() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEndTime());
        }
        if (value.getBackground() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBackground());
        }
        if (value.getTextColor() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTextColor());
        }
      }
    };
    this.__deletionAdapterOfAffair = new EntityDeletionOrUpdateAdapter<Affair>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Affair` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Affair value) {
        stmt.bindLong(1, value.getDayMatterId());
      }
    };
    this.__updateAdapterOfAffair = new EntityDeletionOrUpdateAdapter<Affair>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Affair` SET `id` = ?,`title` = ?,`startTime` = ?,`classify` = ?,`isNotify` = ?,`isChineseDay` = ?,`endTime` = ?,`background` = ?,`textColor` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Affair value) {
        stmt.bindLong(1, value.getDayMatterId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getStartTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStartTime());
        }
        if (value.getClassify() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getClassify());
        }
        final int _tmp;
        _tmp = value.isNotify() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        final int _tmp_1;
        _tmp_1 = value.isChineseDay() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        if (value.getEndTime() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEndTime());
        }
        if (value.getBackground() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBackground());
        }
        if (value.getTextColor() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTextColor());
        }
        stmt.bindLong(10, value.getDayMatterId());
      }
    };
  }

  @Override
  public long insertDayMatters(Affair bean) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAffair.insertAndReturnId(bean);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteDayMatters(Affair bean) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfAffair.handle(bean);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateDayMatters(Affair bean) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfAffair.handle(bean);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<Affair>> getDayMatters() {
    final String _sql = "select * from Affair";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Affair"}, new Callable<List<Affair>>() {
      @Override
      public List<Affair> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfDayMatterId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
          final int _cursorIndexOfStartTime = _cursor.getColumnIndexOrThrow("startTime");
          final int _cursorIndexOfClassify = _cursor.getColumnIndexOrThrow("classify");
          final int _cursorIndexOfIsNotify = _cursor.getColumnIndexOrThrow("isNotify");
          final int _cursorIndexOfIsChineseDay = _cursor.getColumnIndexOrThrow("isChineseDay");
          final int _cursorIndexOfEndTime = _cursor.getColumnIndexOrThrow("endTime");
          final int _cursorIndexOfBackground = _cursor.getColumnIndexOrThrow("background");
          final int _cursorIndexOfTextColor = _cursor.getColumnIndexOrThrow("textColor");
          final List<Affair> _result = new ArrayList<Affair>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Affair _item;
            _item = new Affair();
            final long _tmpDayMatterId;
            _tmpDayMatterId = _cursor.getLong(_cursorIndexOfDayMatterId);
            _item.setDayMatterId(_tmpDayMatterId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            _item.setTitle(_tmpTitle);
            final String _tmpStartTime;
            _tmpStartTime = _cursor.getString(_cursorIndexOfStartTime);
            _item.setStartTime(_tmpStartTime);
            final String _tmpClassify;
            _tmpClassify = _cursor.getString(_cursorIndexOfClassify);
            _item.setClassify(_tmpClassify);
            final boolean _tmpIsNotify;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsNotify);
            _tmpIsNotify = _tmp != 0;
            _item.setNotify(_tmpIsNotify);
            final boolean _tmpIsChineseDay;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsChineseDay);
            _tmpIsChineseDay = _tmp_1 != 0;
            _item.setChineseDay(_tmpIsChineseDay);
            final String _tmpEndTime;
            _tmpEndTime = _cursor.getString(_cursorIndexOfEndTime);
            _item.setEndTime(_tmpEndTime);
            final String _tmpBackground;
            _tmpBackground = _cursor.getString(_cursorIndexOfBackground);
            _item.setBackground(_tmpBackground);
            final String _tmpTextColor;
            _tmpTextColor = _cursor.getString(_cursorIndexOfTextColor);
            _item.setTextColor(_tmpTextColor);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flowable<List<Affair>> getDayMattersByKind(String classify) {
    final String _sql = "select * from Affair where classify = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (classify == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, classify);
    }
    return RxRoom.createFlowable(__db, new String[]{"Affair"}, new Callable<List<Affair>>() {
      @Override
      public List<Affair> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfDayMatterId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
          final int _cursorIndexOfStartTime = _cursor.getColumnIndexOrThrow("startTime");
          final int _cursorIndexOfClassify = _cursor.getColumnIndexOrThrow("classify");
          final int _cursorIndexOfIsNotify = _cursor.getColumnIndexOrThrow("isNotify");
          final int _cursorIndexOfIsChineseDay = _cursor.getColumnIndexOrThrow("isChineseDay");
          final int _cursorIndexOfEndTime = _cursor.getColumnIndexOrThrow("endTime");
          final int _cursorIndexOfBackground = _cursor.getColumnIndexOrThrow("background");
          final int _cursorIndexOfTextColor = _cursor.getColumnIndexOrThrow("textColor");
          final List<Affair> _result = new ArrayList<Affair>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Affair _item;
            _item = new Affair();
            final long _tmpDayMatterId;
            _tmpDayMatterId = _cursor.getLong(_cursorIndexOfDayMatterId);
            _item.setDayMatterId(_tmpDayMatterId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            _item.setTitle(_tmpTitle);
            final String _tmpStartTime;
            _tmpStartTime = _cursor.getString(_cursorIndexOfStartTime);
            _item.setStartTime(_tmpStartTime);
            final String _tmpClassify;
            _tmpClassify = _cursor.getString(_cursorIndexOfClassify);
            _item.setClassify(_tmpClassify);
            final boolean _tmpIsNotify;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsNotify);
            _tmpIsNotify = _tmp != 0;
            _item.setNotify(_tmpIsNotify);
            final boolean _tmpIsChineseDay;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsChineseDay);
            _tmpIsChineseDay = _tmp_1 != 0;
            _item.setChineseDay(_tmpIsChineseDay);
            final String _tmpEndTime;
            _tmpEndTime = _cursor.getString(_cursorIndexOfEndTime);
            _item.setEndTime(_tmpEndTime);
            final String _tmpBackground;
            _tmpBackground = _cursor.getString(_cursorIndexOfBackground);
            _item.setBackground(_tmpBackground);
            final String _tmpTextColor;
            _tmpTextColor = _cursor.getString(_cursorIndexOfTextColor);
            _item.setTextColor(_tmpTextColor);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flowable<List<String>> getClassify() {
    final String _sql = "select distinct classify from Affair";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Affair"}, new Callable<List<String>>() {
      @Override
      public List<String> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final String _item;
            _item = _cursor.getString(0);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
