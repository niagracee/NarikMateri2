package com.niyagrace.narikmateri;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    // Deklarasi
    ImageView ivGambarMateri;
    WebView wvKontenMateri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Inisialisasi
        ivGambarMateri = (ImageView) findViewById(R.id.ivGambarMateri);
        wvKontenMateri = (WebView) findViewById(R.id.wvKontenMateri);

        // Jalankan method tampil detail berita
        showDetailBerita();
    }

    private void showDetailBerita() {
        // Tangkap data dari intent
        String judul_berita = getIntent().getStringExtra("JDL_BERITA");
        String tanggal_berita = getIntent().getStringExtra("TGL_BERITA");
        String penulis_berita = getIntent().getStringExtra("PNS_BERITA");
        String isi_berita = getIntent().getStringExtra("ISI_BERITA");
        String foto_berita = getIntent().getStringExtra("FTO_BERITA");

        // Set judul actionbar / toolbar
        getSupportActionBar().setTitle(judul_berita);

        // Untuk gambar berita
        Picasso.with(this).load(foto_berita).into(ivGambarMateri);
        // Set isi berita sebagai html ke WebView
        wvKontenMateri.getSettings().setJavaScriptEnabled(true);
        wvKontenMateri.loadData(isi_berita, "text/html; charset=utf-8", "UTF-8");
    }
}