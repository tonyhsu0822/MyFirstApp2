package com.mycompany.myfirstapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;


public class DisplayMessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get the message from the intent
        Intent intent = getIntent() ;
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE) ;

        XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset() ;
        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();

        double[] xvalue = new double[100] ;
        double[] yvalue = new double[100] ;

        XYSeries series = new XYSeries("Number Data");


       setContentView(R.layout.activity_display_message);
       // TextView textView = (TextView)findViewById(R.id.number_text_view) ;
        //textView.setText(MyActivity.message[0]);
        double min = -100;
        double max = 100;
        int times = MyActivity.times - 1 ;
        for(int i =0;i<=times;i++){
            xvalue[i] = i ;
            yvalue[i] = Double.parseDouble(MyActivity.message[i]) ;
            series.add(xvalue[i],yvalue[i]);
        }

        for(int i = 0; i <= times; i++){
            if(yvalue[i] < min){
                min = yvalue[i];
            }
            if(yvalue[i] > max){
                max = yvalue[i];
            }
        }

        XYSeriesRenderer renderer = new XYSeriesRenderer();

        renderer.setFillPoints(true);
        renderer.setDisplayChartValues(true);
        renderer.setChartValuesTextSize(30);
        renderer.setPointStyle(PointStyle.CIRCLE);

        mDataset.addSeries(series);
        mRenderer.addSeriesRenderer(renderer);
        setChartSetting(mRenderer, "Body Temperature", "Time", "temperature", -0.5, (double)times+0.5, min-5, max+5);

        mRenderer.setYAxisMax(40);
        mRenderer.setYAxisMin(35);
        mRenderer.setBackgroundColor(Color.WHITE);
        mRenderer.setDisplayValues(true);
        mRenderer.setShowLegend(true);
        View mChartView = ChartFactory.getLineChartView(this, mDataset, mRenderer);



        LinearLayout layout = (LinearLayout)findViewById(R.id.chart1) ;
        layout.addView(mChartView);
       // setContentView(mChartView);
    }


    protected void setChartSetting(XYMultipleSeriesRenderer renderer, String title, String xTitle,
                                   String yTitle, double xMin, double xMax, double yMin,double yMax){
        renderer.setChartTitle(title);
        renderer.setChartTitleTextSize(48);
        renderer.setXTitle(xTitle);
        renderer.setYTitle(yTitle);
        renderer.setLabelsTextSize(36);
        renderer.setXAxisMin(xMin);
        renderer.setXAxisMax(xMax);
        renderer.setYAxisMin(yMin);
        renderer.setYAxisMax(yMax);
        renderer.setShowGrid(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
