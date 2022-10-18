package br.com.bruno.learningroom;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PersonViewModel extends AndroidViewModel {

    PersonRepository repository;
    LiveData<List<Person>> listaDePessoas;

    public PersonViewModel(Application application){
        super(application);
        repository = new PersonRepository(application);
        listaDePessoas = repository.getPerson();
    }

    LiveData<List<Person>> getAllPersons() {
      return listaDePessoas;
    }

    public void insertPerson (Person person){
        repository.insert(person);
    }

}
