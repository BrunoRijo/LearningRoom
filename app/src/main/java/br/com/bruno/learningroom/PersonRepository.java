package br.com.bruno.learningroom;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.xml.transform.Result;

public class PersonRepository {

    PersonDao personDao;

    PersonRepository(Application application){
        PersonDataBase db = PersonDataBase.getDataBase(application);
        personDao = db.personDao();
    }

    //Um liveData é como um dado mutável em tempo de execução.
    LiveData<List<Person>> getPerson(){
        return personDao.getAllPersons();
    }

    void insert (Person person){
        new insertAsynTask(personDao).execute(person);
    }

    private static class insertAsynTask extends AsyncTask<Person, void, void>{
        private PersonDao taskDao;

        insertAsynTask(PersonDao personDao){
            taskDao = personDao;
        }

        @Override
        protected Result doInBackground(br.com.bruno.learningroom.Person... people) {
            taskDao.insert(people[0]);
            return null;
        }
    }

}

