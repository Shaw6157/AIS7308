package com.ais.standardcalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //music part
    SoundPool soundPool;
    int soundNum, soundOpr, streamId;

    //view part
    Button btn1, btn2, btn3, btn4,
            btn5, btn6, btn7, btn8,
            btn9, btn0, btnC, btnCE,
            btnPlu, btnMin, btnMul, btnDiv,
            btnEqu, btnPM, btnBS, btnDot;
    TextView tvhis, tvres;

    //value part
    float gv_num = 0;
    float gv_res = 0;
    String str_num, str_his, str_temp;
    String stropr_last = "=";
    boolean isLastOpr = true;
    boolean hasDot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initSound();
    }

    public void initView() {
        tvhis = findMyV(R.id.tv_history);
        tvres = findMyV(R.id.tv_result);

        btn0 = findMyV(R.id.btn1);
        btn1 = findMyV(R.id.btn1);
        btn2 = findMyV(R.id.btn1);
        btn3 = findMyV(R.id.btn1);
        btn4 = findMyV(R.id.btn1);

        btn5 = findMyV(R.id.btn1);
        btn6 = findMyV(R.id.btn1);
        btn7 = findMyV(R.id.btn1);
        btn8 = findMyV(R.id.btn1);
        btn9 = findMyV(R.id.btn1);

        btnPlu = findMyV(R.id.btnPlu);
        btnMin = findMyV(R.id.btnMin);
        btnMul = findMyV(R.id.btnMul);
        btnDiv = findMyV(R.id.btnDiv);
        btnEqu = findMyV(R.id.btnEqu);

        btnPM  = findMyV(R.id.btnPM);   //plus and minus
        btnBS  = findMyV(R.id.btnBS);   //backspace
        btnCE  = findMyV(R.id.btnCE);   //clear
        btnDot = findMyV(R.id.btnDot);  //dot
    }

    @SuppressLint("NewApi")
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundNum = soundPool.load(this, R.raw.koural, 1);
        soundOpr = soundPool.load(this, R.raw.coin, 1);
        soundOpr = soundPool.load(this, R.raw.koural, 1);
    }

    public void btnClick (View v){
        str_his = tvhis.getText() + "";
        str_num = tvres.getText() + "";

        switch (v.getId()) {
            case R.id.btn0:
                clickNum("0");
                break;
            case R.id.btn1:
                clickNum("1");
                break;
            case R.id.btn2:
                clickNum("2");
                break;
            case R.id.btn3:
                clickNum("3");
                break;
            case R.id.btn4:
                clickNum("4");
                break;
            case R.id.btn5:
                clickNum("5");
                break;
            case R.id.btn6:
                clickNum("6");
                break;
            case R.id.btn7:
                clickNum("7");
                break;
            case R.id.btn8:
                clickNum("8");
                break;
            case R.id.btn9:
                clickNum("9");
                break;
            case R.id.btnPlu:
                clickOpr("+");
                break;
            case R.id.btnMin:
                clickOpr("-");
                break;
            case R.id.btnMul:
                clickOpr("*");
                break;
            case R.id.btnDiv:
                clickOpr("/");
                break;
            case R.id.btnEqu:
                clickOpr("=");
                break;
            case R.id.btnCE:
                clickCE();
                break;
            case R.id.btnBS:
                clickNum("BS");
                break;
            case R.id.btnPM:
                clickNum("PM");
                break;
            case R.id.btnDot:
                clickNum(".");
                break;
            default:
                Log.d("what click: ", " " + v.getId());
                break;
        }
        tvhis.setText(str_his);
        tvres.setText(toInt(str_num));
    }

    private void clickNum(String p_num) {
        playClick(soundNum);

//        Log.d("ccc gvnum : ", " " + gv_num + "   gvres: " + gv_res);
//        Log.d("cc strnum : ", " " + str_num + "   str his: " + str_his);

        switch (p_num) {
            case ".":
                if (!hasDot) {
                    if (isLastOpr) {
                        str_num = "0.";
                        gv_num = 0;
                    } else {
                        str_num += p_num;
                    }
                    hasDot = true;
                    isLastOpr = false;
                }
                return;
            case "BS":
                if ((str_num != null) && str_num.length() == 1){
                    str_num = "0";
                } else {
                    str_num = str_num.substring(0, str_num.length() - 1);
                }
                break;
            case "PM":
                if (("0.0".equals(str_num)) || ("0".equals(str_num))) {
                    break;
                }
                if (str_num.startsWith("-")){
                    str_num = str_num.substring(1, str_num.length());
                } else {
                    str_num = "-" + str_num;
                }
                break;
            default:
                Log.d("333 : ", " " + str_num + "   result: " + str_his);
                if (isLastOpr) {
                    str_num = p_num;
                } else {
                    str_num = ("0".equals(str_num) || "E".equals(str_num)) ? p_num : str_num + p_num;
                }
        }

        gv_num = Float.parseFloat(str_num);
        isLastOpr = false;

    }

    private void clickOpr(String p_opr) {
        playClick(soundOpr);
        if ("E".equals(str_num)) {
            return;
        }

        // press two operations
        if (isLastOpr && (!"=".equals(p_opr)) && (!"=".equals(stropr_last))) {

            String lv_strint = toInt("" + gv_num);
            str_his = ("0.0".equals(str_num) ? "0" : str_his + lv_strint).substring(0, str_his.length() - 1) + p_opr;

            stropr_last = p_opr;
            isLastOpr = true;
            hasDot = false;
            return;
        }

        if ("=".equals(stropr_last)) {
            gv_res = gv_num;
        } else if ("+".equals(stropr_last)) {
            gv_res = gv_res + gv_num;
        } else if ("-".equals(stropr_last)) {
            gv_res = gv_res - gv_num;
        } else if ("*".equals(stropr_last)) {
            gv_res = gv_res * gv_num;
        } else if ("/".equals(stropr_last)) {
            if (gv_num == 0) {
                clickCE();
                str_num = "E";
                Toast.makeText(this, "Oops, denominator cannot be 0 !", Toast.LENGTH_SHORT).show();
                return;
            }
            gv_res = gv_res / gv_num;

        } else {

        }

        if ("=".equals(p_opr)) {
            if (isLastOpr) {

            }
            str_his = "";
            gv_num = gv_res;
        } else {
            String lv_strint = toInt("" + gv_num);
            str_his = "0.0".equals(str_num) ? "0" : str_his + lv_strint + p_opr;
        }

        str_num = gv_res + "";
        stropr_last = p_opr;
        isLastOpr = true;
        hasDot = false;
    }

    public void clickAbout (View v) {
        Intent intentAbout = new Intent(this, AboutActivity.class);
        startActivity(intentAbout);
    }

    private String toInt (String p_str) {
        return p_str.endsWith(".0") ? p_str.substring(0, p_str.length() - 2) : p_str;
    }

    private void clickCE() {
        playClick(soundOpr);
        gv_num = 0;
        gv_res = 0;
        str_his = "";
        str_num = "0";
        stropr_last = "=";
        hasDot = false;
        isLastOpr = true;
    }

    private void playClick(int musicID) {
        streamId= soundPool.play(musicID, 1,1,1,0,2);
        // soundPool.stop(streamId);
    }

    protected <T extends View> T findMyV(int id) {
        return (T) findViewById(id);
    }

}
