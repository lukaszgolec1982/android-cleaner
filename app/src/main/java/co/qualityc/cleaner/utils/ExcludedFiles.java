package co.qualityc.cleaner.utils;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;

import co.qualityc.cleaner.R;

/**
 * Created by lukgol on 23.08.14.
 */
public class ExcludedFiles {
    private ArrayList<String> excludedFiles = new ArrayList<String>();
    private String xmlFileName;
    private Context context;
    private ArrayList<String> parseXml() {
        String[] array;
        array = context.getResources().getStringArray(R.array.excluded_array);

        if(array == null) {
            excludedFiles.clear();
            return excludedFiles;
        }

        excludedFiles = new ArrayList<String>(Arrays.asList(array));

        return excludedFiles;
    }

    public boolean isExcluded(String name) {
        boolean ret = false;
        for(String str : excludedFiles) {
            if(name.contains(str)) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    public void setXmlFileName(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }
    public void setContext(Context context) {
        this.context = context;
    }
    public ArrayList<String> getExcludedFiles() {
        return excludedFiles;
    }

    public String toString() {
        String out = null;
        for(String str : excludedFiles) {
            out += str + " ";
        }
        return out;
    }

    public static class Builder {
        private String xmlFileName;
        private Context context;
        public ExcludedFiles build() {
            ExcludedFiles excluded = new ExcludedFiles();
            excluded.setXmlFileName(this.xmlFileName);
            excluded.setContext(context);
            excluded.parseXml();

            return excluded;
        }
        public Builder setXmlFileName(String fileName) {
            xmlFileName = fileName;
            return this;
        }
        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }
    }
}
