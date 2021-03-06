package io.github.veeshostak.aichat.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import io.github.veeshostak.aichat.database.dao.ChatPostDao;
import io.github.veeshostak.aichat.database.entity.ChatPost;

/**
 * Created by vladshostak on 12/23/17.
 */

@Database(entities = {ChatPost.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    // create Db and get an instance of it
    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "user-chat-posts")
                            .build();
        }
        return INSTANCE;
    }

    // Model
    public abstract ChatPostDao chatPostDao();
}
