package com.example.marinero_kj.persistance.localStorage;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.marinero_kj.pojo.Sight;

import java.util.List;

public class SightRepository {

    private SightDao sightDao;
    private static SightRepository instance;
    private LiveData<List<Sight>> sights;

    private SightRepository(Application application){
        SightDatabase db= SightDatabase.getInstance(application);
        sightDao=db.sightDao();
        sights=sightDao.getAllSights();
    }

    public LiveData<List<Sight>> getAllSighta(){return sights;}

    public static SightRepository getInstance(Application application){
        if(instance==null)
            return new SightRepository(application);
        else return instance;
    }

    public void addSight(Sight sight){
        new InsertSightAsync(sightDao).execute(sight);
    }

    public void deleteSights(){
        new InsertSightAsync(sightDao).execute();
    }


//--------------------------------------------------------------------------------------
    private static class InsertSightAsync extends AsyncTask<Sight, Void, Void> {
        private SightDao sightDao;

        private InsertSightAsync(SightDao  noteDao){
            this.sightDao=noteDao;
        }

        @Override
        protected Void doInBackground(Sight... sights) {
            sightDao.insert(sights[0]);
            return null;
        }
    }

    private static class DeleteSightsAsync extends AsyncTask<Void, Void, Void> {
        private SightDao sightDao;

        private DeleteSightsAsync(SightDao  noteDao){
            this.sightDao=noteDao;
        }

        @Override
        protected Void doInBackground(Void... sights) {
            sightDao.deleteAllSights();
            return null;
        }
    }

}
