/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 14:30
 */

/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 06:50
 */

package aldy.uas10116158.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoUserLogin {
    @Query("SELECT * FROM user_login")
    List<UserLogin> getListUser();

    @Query("SELECT * FROM user_login WHERE username LIKE :username AND password = :password")
    UserLogin findByUsername(String username, String password);

    @Insert
    void insertUser(UserLogin... user);
}
