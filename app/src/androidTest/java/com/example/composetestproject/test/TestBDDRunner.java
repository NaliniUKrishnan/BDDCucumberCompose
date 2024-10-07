package com.example.composetestproject.test;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.composetestproject.MyApplication;

import org.junit.runner.RunWith;

import java.io.File;

import io.cucumber.android.runner.CucumberAndroidJUnitRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "features",
        plugin = {"json"},
        monochrome = true,
        glue = "com.example.composetestproject",
        tags = "@smoke,@regression,~@ignore")

public class TestBDDRunner extends CucumberAndroidJUnitRunner {

    @Override
    public void onCreate(final Bundle bundle) {
        bundle.putString("plugin", getPluginConfigurationString()); // we programmatically create the plugin configuration
        //it crashes on Android R without it
        new File(getAbsoluteFilesPath()).mkdirs();
        super.onCreate(bundle);
    }

    /**
     * Since we want to checkout the external storage directory programmatically, we create the plugin configuration
     * here, instead of the {@link CucumberOptions} annotation.
     *
     * @return the plugin string for the configuration, which contains XML, HTML and JSON paths
     */
    private String getPluginConfigurationString() {
        String cucumber = "cucumber";
        String separator = "-";
        return "junit:" + getCucumberXml(cucumber) + separator +
                "html:" + getCucumberHtml(cucumber);
    }

    private String getCucumberHtml(String cucumber) {
        Log.i("getCucumberHtml", getAbsoluteFilesPath() + "/" + cucumber + ".html");
        return getAbsoluteFilesPath() + "/" + cucumber + ".html";
    }

    private String getCucumberXml(String cucumber) {
        Log.i("getCucumberXml", getAbsoluteFilesPath() + "/" + cucumber + ".xml");

        return getAbsoluteFilesPath() + "/" + cucumber + ".xml";
    }

    /**
     * The path which is used for the report files.
     *
     * @return the absolute path for the report files
     */
    private String getAbsoluteFilesPath() {

        File directory = getTargetContext().getExternalFilesDir(null);
        return new File(directory, "reports").getAbsolutePath();
    }

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return super.newApplication(cl, MyApplication.class.getName(), context);
    }
}
