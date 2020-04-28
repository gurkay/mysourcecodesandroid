package com.mysourcecodesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ActivityJSoupLibrary extends AppCompatActivity implements View.OnClickListener{

    TextView j_soup_txtresult;
    Button j_soup_btntab1,j_soup_btntab2,j_soup_btntab3;
    Context context = this;
    private String webSiteUrl;
    public String findContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_soup_library);

        init();
    }

    public void init() {
        // add toolbar back button arrow
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        j_soup_btntab1 = findViewById(R.id.j_soup_btntab1);
        j_soup_btntab2 = findViewById(R.id.j_soup_btntab2);
        j_soup_btntab3 = findViewById(R.id.j_soup_btntab3);
        j_soup_btntab1.setOnClickListener(this);
        j_soup_btntab2.setOnClickListener(this);
        j_soup_btntab3.setOnClickListener(this);

        j_soup_txtresult = findViewById(R.id.j_soup_txtresult);

    }

    public void setWebSiteUrl(String siteUrl) {
        this.webSiteUrl = siteUrl;
    }

    public void getWebSite() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder builder = new StringBuilder();
                try {
                    Document doc = Jsoup.connect(webSiteUrl).get();

                    String title = doc.title();

                    builder.append(title).append("\n");

                    if(findContent.equalsIgnoreCase("caContent")){

                        Elements links = doc.select("div.caContent a[href]");
                        log("Here : ", "AYBU Duyurular");
                        for(Element link : links) {
                            log(link.text() + " Link : ", link.attr("href"));

                            builder.append("\n").append("Link : ").append(link.attr("href"))
                                    .append("\n").append("Text : ").append(link.text());
                        }


                    } else if (findContent.equalsIgnoreCase("cnContent")) {
                        Elements links = doc.select("div.cnContent a[href]");
                        log("Here : ", "AYBU Haberler");
                        for(Element link : links) {
                            log(link.text() + " Link : ", link.attr("href"));

                            builder.append("\n").append("Link : ").append(link.attr("href"))
                                    .append("\n").append("Text : ").append(link.text());
                        }
                    } else {

                        Elements links = doc.select("a[href]");
                        log("Here : ", "Yemek Menu");
                        for(Element link : links) {
                            if(findContent.equalsIgnoreCase(link.text())) {
                                builder.append("\n").append("Link : ").append(link.attr("href"))
                                        .append("\n").append("Text : ").append(link.text());
                            }

                        }
                    }
                }catch (IOException e) {
                    builder.append("\n").append("Error : ").append(e.getMessage()).append("\n");
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        j_soup_txtresult.setText(builder.toString());
                    }
                });
            }
        }).start();
    }

    private static void log(String msg, String vals) {
        System.out.println(String.format("\n" + msg + " " + vals));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if(itemId == R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.j_soup_btntab1:
                setWebSiteUrl("https://aybu.edu.tr/sks/");
                findContent = "Aylık Yemek Menüsü";
                getWebSite();
                break;
            case R.id.j_soup_btntab2:
                setWebSiteUrl("https://aybu.edu.tr/muhendislik/bilgisayar/");
                findContent = "caContent";
                getWebSite();
                break;
            case R.id.j_soup_btntab3:
                setWebSiteUrl("https://aybu.edu.tr/muhendislik/bilgisayar/");
                findContent = "cnContent";
                getWebSite();
                break;
        }
    }
}
