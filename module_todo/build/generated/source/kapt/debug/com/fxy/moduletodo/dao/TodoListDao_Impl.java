package com.fxy.moduletodo.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.fxy.moduletodo.bean.Step;
import com.fxy.moduletodo.bean.TodoList;
import com.fxy.moduletodo.util.converters.TodoConverter;
import io.reactivex.Flowable;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public class TodoListDao_Impl implements TodoListDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTodoList;

  private final TodoConverter __todoConverter = new TodoConverter();

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTodoList;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfTodoList;

  public TodoListDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTodoList = new EntityInsertionAdapter<TodoList>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `TodoList`(`id`,`content`,`deadLine`,`isAddMyDay`,`isFinish`,`isImportant`,`steps`,`notes`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TodoList value) {
        stmt.bindLong(1, value.getId());
        if (value.getContent() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getContent());
        }
        if (value.getDeadLine() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDeadLine());
        }
        final int _tmp;
        _tmp = value.isAddMyDay() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        final int _tmp_1;
        _tmp_1 = value.isFinish() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        final int _tmp_2;
        _tmp_2 = value.isImportant() ? 1 : 0;
        stmt.bindLong(6, _tmp_2);
        final String _tmp_3;
        _tmp_3 = __todoConverter.objectToString(value.getSteps());
        if (_tmp_3 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_3);
        }
        if (value.getNotes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNotes());
        }
      }
    };
    this.__deletionAdapterOfTodoList = new EntityDeletionOrUpdateAdapter<TodoList>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `TodoList` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TodoList value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfTodoList = new EntityDeletionOrUpdateAdapter<TodoList>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `TodoList` SET `id` = ?,`content` = ?,`deadLine` = ?,`isAddMyDay` = ?,`isFinish` = ?,`isImportant` = ?,`steps` = ?,`notes` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TodoList value) {
        stmt.bindLong(1, value.getId());
        if (value.getContent() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getContent());
        }
        if (value.getDeadLine() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDeadLine());
        }
        final int _tmp;
        _tmp = value.isAddMyDay() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        final int _tmp_1;
        _tmp_1 = value.isFinish() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        final int _tmp_2;
        _tmp_2 = value.isImportant() ? 1 : 0;
        stmt.bindLong(6, _tmp_2);
        final String _tmp_3;
        _tmp_3 = __todoConverter.objectToString(value.getSteps());
        if (_tmp_3 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_3);
        }
        if (value.getNotes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNotes());
        }
        stmt.bindLong(9, value.getId());
      }
    };
  }

  @Override
  public long insertTodo(TodoList todo) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfTodoList.insertAndReturnId(todo);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteTodo(TodoList todo) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfTodoList.handle(todo);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateTodo(TodoList todo) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfTodoList.handle(todo);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<TodoList>> getTodoList() {
    final String _sql = "SELECT * FROM TodoList";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"TodoList"}, new Callable<List<TodoList>>() {
      @Override
      public List<TodoList> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfContent = _cursor.getColumnIndexOrThrow("content");
          final int _cursorIndexOfDeadLine = _cursor.getColumnIndexOrThrow("deadLine");
          final int _cursorIndexOfIsAddMyDay = _cursor.getColumnIndexOrThrow("isAddMyDay");
          final int _cursorIndexOfIsFinish = _cursor.getColumnIndexOrThrow("isFinish");
          final int _cursorIndexOfIsImportant = _cursor.getColumnIndexOrThrow("isImportant");
          final int _cursorIndexOfSteps = _cursor.getColumnIndexOrThrow("steps");
          final int _cursorIndexOfNotes = _cursor.getColumnIndexOrThrow("notes");
          final List<TodoList> _result = new ArrayList<TodoList>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TodoList _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpContent;
            _tmpContent = _cursor.getString(_cursorIndexOfContent);
            final String _tmpDeadLine;
            _tmpDeadLine = _cursor.getString(_cursorIndexOfDeadLine);
            final boolean _tmpIsAddMyDay;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAddMyDay);
            _tmpIsAddMyDay = _tmp != 0;
            final boolean _tmpIsFinish;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFinish);
            _tmpIsFinish = _tmp_1 != 0;
            final boolean _tmpIsImportant;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsImportant);
            _tmpIsImportant = _tmp_2 != 0;
            final List<Step> _tmpSteps;
            final String _tmp_3;
            _tmp_3 = _cursor.getString(_cursorIndexOfSteps);
            _tmpSteps = __todoConverter.stringToObject(_tmp_3);
            final String _tmpNotes;
            _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            _item = new TodoList(_tmpId,_tmpContent,_tmpDeadLine,_tmpIsAddMyDay,_tmpIsFinish,_tmpIsImportant,_tmpSteps,_tmpNotes);
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
