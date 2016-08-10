package com.vadstep.gymglishtestproject.Controller.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vadstep.gymglishtestproject.Controller.Adapters.WebAdapter;
import com.vadstep.gymglishtestproject.Controller.Listeners.RecyclerItemClickListener;
import com.vadstep.gymglishtestproject.Model.AppConst;
import com.vadstep.gymglishtestproject.Model.WebLink;
import com.vadstep.gymglishtestproject.R;
import com.vadstep.gymglishtestproject.Utils.RecyclerViewDivider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<WebLink> urlList = new ArrayList<>();
    private RecyclerView recyclerView;
    private WebAdapter mAdapter;
    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(MainActivity.this)
                .setTitle(R.string.alert_dialog_title)
                .setMessage(R.string.alert_dialog_text)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new WebAdapter(urlList);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(MainActivity.this,WebActivity.class);
                        if(urlList.get(position)!=null)
                        intent.putExtra(AppConst.URL_LINK,urlList.get(position).getUrl());
                        startActivity(intent);
                    }
                })
        );
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new RecyclerViewDivider(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        prepareUrlList();
    }
    private void prepareUrlList() {
        urlList.add(new WebLink("https://www.gymglish.com"));
        urlList.add(new WebLink("https://www.frantastique.com"));
        urlList.add(new WebLink("http://www.vatefaireconjuguer.com"));

        urlList.add(new WebLink("https://www.richmorning.com"));
        urlList.add(new WebLink("http://thewordofthemonth.com"));
        urlList.add(new WebLink("http://www.comment-utiliser-son-cpf.fr/"));
        mAdapter.notifyDataSetChanged();
    }
}
