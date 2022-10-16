package br.com.bruno.learningroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class},version = 1)
public abstract class PersonDataBase extends RoomDatabase {

    public abstract PersonDao personDao();

    /*Essa classe abstrata é declarada como o banco de dados, e é o que informa ao bd as classes que
    serão armazenadas lá, com base nas funções declaradas na classe Dao.*/
}
