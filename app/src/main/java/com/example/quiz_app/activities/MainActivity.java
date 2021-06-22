package com.example.quiz_app.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.quiz_app.R;
import com.example.quiz_app.adapter.QuizAdapter;
import com.example.quiz_app.models.Quiz;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    ActionBarDrawerToggle actionBarDrawerToggle;
    QuizAdapter adapter;
    FirebaseFirestore fireStore;

    private List<Quiz> quizlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateDummyData();
        setUpView();

    }

    private void populateDummyData() {
        quizlist.add(new Quiz("12-10-2021","12-10-2021"));
        quizlist.add(new Quiz("13-10-2021","13-10-2021"));
        quizlist.add(new Quiz("14-10-2021","14-10-2021"));
        quizlist.add(new Quiz("15-10-2021","15-10-2021"));
        quizlist.add(new Quiz("16-10-2021","16-10-2021"));
        quizlist.add(new Quiz("17-10-2021","17-10-2021"));
        quizlist.add(new Quiz("18-10-2021","18-10-2021"));
        quizlist.add(new Quiz("19-10-2021","19-10-2021"));
        quizlist.add(new Quiz("20-10-2021","20-10-2021"));
        quizlist.add(new Quiz("21-10-2021","21-10-2021"));
        quizlist.add(new Quiz("22-10-2021","22-10-2021"));
        quizlist.add(new Quiz("23-10-2021","23-10-2021"));

    }

    void setUpView() {
        setUpFireStore();
        setUpDrawerLayout();
        setUpRecycleView();


    }

    private void setUpFireStore() {
        fireStore = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = fireStore.collection("Quizzes");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if( value == null || error != null)
                {
                    Toast.makeText(MainActivity.this, "Error while fetchind data!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d( "DATA", value.toObjects(Quiz.class).toString());
                quizlist.clear();
                quizlist.addAll(value.toObjects(Quiz.class));
                adapter.notifyDataSetChanged();

            }
        });

    }

    void setUpRecycleView()
    {
        RecyclerView recyclerView;
        adapter = new QuizAdapter(this, quizlist);
        recyclerView = findViewById(R.id.quizRecycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }


    void setUpDrawerLayout() {
        setSupportActionBar(findViewById(R.id.AppBar));
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, findViewById(R.id.maindrawer),R.string.app_name , R.string.app_name);
        actionBarDrawerToggle.syncState();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}