package com.example.blackbank_semestralni_prace;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class BbccFragment extends Fragment {

    TextView time, click;
    ImageView btn_click;
    Button btn_start;
    CheckBox check_time;
    CountDownTimer timer;

    int t = 60;
    int c = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_bbcc, container, false);

        time = (TextView) myView.findViewById(R.id.time);
        click = (TextView) myView.findViewById(R.id.click);
        btn_click = (ImageView) myView.findViewById(R.id.btn_click);
        btn_start = (Button) myView.findViewById(R.id.btn_start);
        check_time = (CheckBox) myView.findViewById(R.id.check_time);

        btn_start.setEnabled(true);
        btn_click.setEnabled(false);
        check_time.setChecked(true);

        check_time.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (check_time.isChecked()) {

                    time.setText("TIME  :   ⏳");
                    click.setText("DLUH :   😭");
                    btn_start.setEnabled(true);
                    btn_click.setEnabled(false);

                    timer = new CountDownTimer(60000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            t--;
                            time.setText("TIME  :   " + t);
                        }

                        @Override
                        public void onFinish() {
                            btn_start.setEnabled(true);
                            btn_click.setEnabled(false);
                            check_time.setEnabled(true);
                            time.setText("TIME  :   ⏳");
                            Toast.makeText(myView.getContext(),"\uD83D\uDE28 Celkem visíš BLACK BANK: " + c + " Kč ☺" + " Exekutor už je na cestě!", Toast.LENGTH_LONG).show();
                        }
                    };

                    btn_click.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            c += 10;
                            click.setText("DLUH :   " + c);

                            if (c == 500) {
                                Toast.makeText(myView.getContext(),"Makej, Makej, ať dluh roste \uD83E\uDD11 " + c + " Kč strháváme z TVÉHO účtu", Toast.LENGTH_LONG).show();
                            }
                            if (c == 1000) {
                                Toast.makeText(myView.getContext(),"Už dlužíš BLACK BANK: " + c + " Kč ☺ KLIKEEEJ! \uD83E\uDD2F", Toast.LENGTH_LONG).show();
                            }
                            if (c == 1500) {
                                Toast.makeText(myView.getContext(),"Money, Money, Money \uD83D\uDCB2 " + c + " Kč ☺ Pokračuj!", Toast.LENGTH_LONG).show();
                            }
                            if (c == 2000) {
                                Toast.makeText(myView.getContext(),"Black Bank děkuje za penízky \uD83E\uDD23 " + c + " Kč", Toast.LENGTH_LONG).show();
                            }
                            if (c == 3000) {
                                Toast.makeText(myView.getContext(),"Jsi v tom za " + c + " Kč za 1 minutu! \uD83D\uDE08", Toast.LENGTH_LONG).show();
                            }

                            if (v.getId()==R.id.btn_click) {
                                Animation a = AnimationUtils.loadAnimation(myView.getContext(), R.anim.money_animation);
                                v.startAnimation(a);
                            }
                        }
                    });

                    btn_start.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            timer.start();
                            btn_start.setEnabled(false);
                            btn_click.setEnabled(true);
                            check_time.setEnabled(false);
                            c = 0;
                            t = 60;
                            time.setText("TIME  :   ");
                            click.setText("DLUH :   " + c);
                        }
                    });
                }
                else {
                    time.setText("TIME  :   ❌");
                    click.setText("DLUH :   😭");
                    btn_click.setEnabled(false);

                    btn_click.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            c += 10;
                            click.setText("DLUH :   " + c);

                            if (c == 500) {
                                Toast.makeText(myView.getContext(),"Nechceš radši půjčku? \uD83E\uDD11 " + c + " Kč strháváme z TVÉHO účtu", Toast.LENGTH_LONG).show();
                            }
                            if (c == 1000) {
                                Toast.makeText(myView.getContext(),"Už dlužíš BLACK BANK: " + c + " Kč ☺ Pokračuj!", Toast.LENGTH_LONG).show();
                            }
                            if (c == 2500) {
                                Toast.makeText(myView.getContext(),"Black Bank děkuje za penízky \uD83E\uDD23 " + c + " Kč", Toast.LENGTH_LONG).show();
                            }
                            if (c == 5000) {
                                Toast.makeText(myView.getContext(),"Jsi v tom za " + c + " Kč. Jen tak dál! \uD83D\uDE0F", Toast.LENGTH_LONG).show();
                            }
                            if (c == 10000) {
                                Toast.makeText(myView.getContext(),"Jsi v mínusu \uD83D\uDE32 " + c + " Kč", Toast.LENGTH_LONG).show();
                            }
                            if (c == 50000) {
                                Toast.makeText(myView.getContext(),"Jsi po uši v dluzích \uD83E\uDD22 Dlužíš BLACK BANK: " + c + " Kč", Toast.LENGTH_LONG).show();
                            }

                            if (v.getId()==R.id.btn_click) {
                                Animation a = AnimationUtils.loadAnimation(myView.getContext(), R.anim.money_animation);
                                v.startAnimation(a);
                            }
                        }
                    });

                    btn_start.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            btn_start.setEnabled(false);
                            btn_click.setEnabled(true);
                            c = 0;
                            time.setText("TIME  :   ❌");
                            click.setText("DLUH :   " + c);
                        }
                    });
                }
            }
        });

        return myView;
    }
}