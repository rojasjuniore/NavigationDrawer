package com.rojasjuniore.rojasjuniore;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ActividaPrincipal extends ActionBarActivity {

    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence mTitle;
    private int mTitleposition;

    private String[] tagTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activida_principal);

        mTitle = getTitle();
        //Obtener arreglo de strings desde los recursos
        tagTitles = getResources().getStringArray(R.array.Tags);
        this.drawerList = (ListView) findViewById(R.id.left_drawer);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Nueva lista de drawer items
        Rojasjuniore rojasjuniore_data[] = new Rojasjuniore[]{
                new Rojasjuniore(R.drawable.ic_launcher, tagTitles[0]),
                new Rojasjuniore(R.drawable.ic_launcher, tagTitles[1]),
                new Rojasjuniore(R.drawable.ic_launcher, tagTitles[2]),
                new Rojasjuniore(R.drawable.ic_launcher, tagTitles[3]),
                new Rojasjuniore(R.drawable.ic_launcher, tagTitles[4]),
                new Rojasjuniore(R.drawable.ic_launcher, tagTitles[5]),
                new Rojasjuniore(R.drawable.ic_launcher, tagTitles[6]),
                new Rojasjuniore(R.drawable.ic_launcher, tagTitles[7]),
                new Rojasjuniore(R.drawable.ic_launcher, tagTitles[8])
        };

        RojasjunioreAdapter adapter = new RojasjunioreAdapter(this, R.layout.drawer_list_item, rojasjuniore_data);
        drawerList.setAdapter(adapter);
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(mTitle);
                supportInvalidateOptionsMenu();
                Toast.makeText(ActividaPrincipal.this, "HOla Cerrado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("Seleccione una opcion");
                supportInvalidateOptionsMenu();
                Toast.makeText(ActividaPrincipal.this, "Abierto", Toast.LENGTH_SHORT).show();
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {

        mTitle = getResources().getStringArray(R.array.Tags)[position];
        mTitleposition = position;
        Fragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString(MyFragment.KEY_TEXT, mTitle.toString());
        args.putString(MyFragment.KEY_INT, String.valueOf(mTitleposition));
        fragment.setArguments(args);

        //  // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        // // Highlight the selected item, update the title, and close the drawer
        drawerList.setItemChecked(position, true);
        getSupportActionBar().setTitle(mTitle);
        drawerLayout.closeDrawer(drawerList);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content
        // view
        boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
        menu.findItem(R.id.action_search).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Cambiar las configuraciones del drawer si hubo modificaciones
        drawerToggle.onConfigurationChanged(newConfig);
    }

    //Este metodo escucha el butto Hamburguesa .)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            // Toma los eventos de selección del toggle aquí
            return true;
        }
        //Manejo de los action buttons
        return super.onOptionsItemSelected(item);
    }

}
