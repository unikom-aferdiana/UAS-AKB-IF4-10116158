/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 14:30
 */

/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 07:10
 */

package aldy.uas10116158.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserLogin.class}, version = 1, exportSchema = false)
public abstract class AppUserLogin extends RoomDatabase {
    public abstract DaoUserLogin daoUserLogin();
}
