package com.ais.demomsword;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.deepoove.poi.XWPFTemplate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            XWPFTemplate template = XWPFTemplate.compile("~/testqoi.docx").render(new HashMap<String, Object>() {{
                put("qqq", "Poi-tl iii");
            }});
            FileOutputStream out = null;
            out = new FileOutputStream("out_template.docx");
            template.write(out);
            out.flush();
            out.close();
            template.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


//
//        Map<String, Object> dataMap = new HashMap<String, Object>();
//        dataMap.put("qqq", "\"BDD6EE\" w:themeFill=\"accent1\" w:themeFillTint=\"66\"");
//
//        MDoc mdoc = new MDoc();
//        try {
//            mdoc.createDoc(dataMap, "/outFile.doc");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        Log.d("", "ssss");
//        System.out.println("模板生成成功");

    }
}
