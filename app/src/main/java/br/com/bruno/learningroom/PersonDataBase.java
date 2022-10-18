package br.com.bruno.learningroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class},version = 1)
public abstract class PersonDataBase extends RoomDatabase {

    public abstract PersonDao personDao();

    public static PersonDataBase INSTANCE;

    //Criando a instancia para o BD
    public static PersonDataBase getDataBase(final Context context){
        if (INSTANCE.equals(null)){
            synchronized (PersonDataBase.class){
                if (INSTANCE.equals(null)) INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        PersonDataBase.class, "person-database").fallbackToDestructiveMigration().build();
            }
        }
        return INSTANCE;
    }

    /*Essa classe abstrata é declarada como o banco de dados, e é o que informa ao bd as classes que
    serão armazenadas lá, com base nas funções declaradas na classe Dao.*/
}
