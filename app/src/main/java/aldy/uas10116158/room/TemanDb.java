/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 15/08/19 18:17
 */

package aldy.uas10116158.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Teman.class}, version = 1, exportSchema = false)
public abstract class TemanDb extends RoomDatabase {
    public abstract TemanDao temanDao();

    private static TemanDb INSTANCE;

    public static TemanDb getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TemanDb.class, "teman_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
