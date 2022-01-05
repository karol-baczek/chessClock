package com.example.chessclock;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    Button button1;
    Button button2;
    Button button4;
    Button button5;
    private boolean isPaused1 = false;
    private boolean isCanceled = false;
    private boolean isPaused2 = false;
    private long timeRemaining1 = 0;
    private long timeRemaining2 = 0;
    int x = 0;
    int y = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setEnabled(true);
                button5.setEnabled(false);
                isPaused1 = true;
                isPaused2 = true;
            }
        });






        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button5.setEnabled(true);
                isPaused2 = true;
                isPaused1 = true;
                isCanceled = false;

                textView1 = findViewById(R.id.textView1);
                textView1.setText("00:10:00");

                textView2 = findViewById(R.id.textView2);
                textView2.setText("00:10:00");

                x=0;
                y=0;

            }
        });


        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button4.setEnabled(false);
                button5.setEnabled(true);



                if(x==0){
                    isPaused2 = true;
                    isPaused1 = false;

                    CountDownTimer timer;
                    long millisInFuture = 600000;
                    long countDownInterval = 1000;


                    textView1 = findViewById(R.id.textView1);
                    timer = new CountDownTimer(millisInFuture,countDownInterval) {
                        public void onTick(long millisUntilFinished1) {
                            if (isPaused1 || isCanceled) {
                                cancel();
                            }
                            else {
                                NumberFormat f = new DecimalFormat("00");
                                long hour = (millisUntilFinished1 / 3600000) % 24;
                                long min = (millisUntilFinished1 / 60000) % 60;
                                long sec = (millisUntilFinished1 / 1000) % 60;
                                textView1.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
                                timeRemaining1 = millisUntilFinished1;
                            }
                        }


                        public void onFinish() {
                            textView1.setText("00:00:00");
                        }
                    }.start();


                    x++;
                }
                else if(x==1){
                    isPaused1 = true;
                    isPaused2= false;
                    CountDownTimer timer;
                    long millisInFuture = 600000;
                    long countDownInterval = 1000;

                    textView2 = findViewById(R.id.textView2);
                    timer = new CountDownTimer(millisInFuture, countDownInterval) {
                        public void onTick(long millisUntilFinished2) {
                            if (isPaused2 || isCanceled) {
                                cancel();
                            }
                            else {
                                NumberFormat f = new DecimalFormat("00");
                                long hour = (millisUntilFinished2 / 3600000) % 24;
                                long min = (millisUntilFinished2 / 60000) % 60;
                                long sec = (millisUntilFinished2 / 1000) % 60;
                                textView2.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
                                timeRemaining2 = millisUntilFinished2;
                            }
                        }


                        public void onFinish() {
                            textView2.setText("00:00:00");
                        }
                    }.start();

                    x++;
                    y=2;

                }
                else if(x==2) {
                    isPaused2 = false;
                    isPaused1 = true;

                    long millisInFuture1 = timeRemaining1;
                    long millisInFuture2 = timeRemaining2;
                    long countDownInterval = 1000;

                    textView1 = findViewById(R.id.textView1);
                    new CountDownTimer(millisInFuture1, countDownInterval) {
                        public void onTick(long millisUntilFinished1) {
                            if (isPaused1 || isCanceled) {
                                cancel();
                            } else {
                                NumberFormat f = new DecimalFormat("00");
                                long hour = (millisUntilFinished1 / 3600000) % 24;
                                long min = (millisUntilFinished1 / 60000) % 60;
                                long sec = (millisUntilFinished1 / 1000) % 60;
                                textView1.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
                                timeRemaining1 = millisUntilFinished1;
                            }
                        }


                        public void onFinish() {
                            textView1.setText("00:00:00");
                        }
                    }.start();


                    textView2 = findViewById(R.id.textView2);
                    new CountDownTimer(millisInFuture2, countDownInterval) {
                        public void onTick(long millisUntilFinished2) {
                            if (isPaused2 || isCanceled) {
                                cancel();
                            } else {
                                NumberFormat f = new DecimalFormat("00");
                                long hour = (millisUntilFinished2 / 3600000) % 24;
                                long min = (millisUntilFinished2 / 60000) % 60;
                                long sec = (millisUntilFinished2 / 1000) % 60;
                                textView2.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
                                timeRemaining2 = millisUntilFinished2;
                            }
                        }


                        public void onFinish() {
                            textView2.setText("00:00:00");
                        }
                    }.start();
                }

            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button4.setEnabled(false);
                button5.setEnabled(true);



                if(y==0){
                    isPaused1 = true;
                    isPaused2= false;
                    CountDownTimer timer;
                    long millisInFuture = 600000;
                    long countDownInterval = 1000;

                    textView2 = findViewById(R.id.textView2);
                    timer = new CountDownTimer(millisInFuture, countDownInterval) {
                        public void onTick(long millisUntilFinished2) {
                            if (isPaused2 || isCanceled) {
                                cancel();
                            }
                            else {
                                NumberFormat f = new DecimalFormat("00");
                                long hour = (millisUntilFinished2 / 3600000) % 24;
                                long min = (millisUntilFinished2 / 60000) % 60;
                                long sec = (millisUntilFinished2 / 1000) % 60;
                                textView2.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
                                timeRemaining2 = millisUntilFinished2;
                            }
                        }


                        public void onFinish() {
                            textView2.setText("00:00:00");
                        }
                    }.start();

                    y++;
                }else if(y==1){
                    isPaused1 = true;
                    isPaused2= false;
                    CountDownTimer timer;
                    long millisInFuture = 600000;
                    long countDownInterval = 1000;

                    textView2 = findViewById(R.id.textView2);
                    timer = new CountDownTimer(millisInFuture, countDownInterval) {
                        public void onTick(long millisUntilFinished2) {
                            if (isPaused2 || isCanceled) {
                                cancel();
                            }
                            else {
                                NumberFormat f = new DecimalFormat("00");
                                long hour = (millisUntilFinished2 / 3600000) % 24;
                                long min = (millisUntilFinished2 / 60000) % 60;
                                long sec = (millisUntilFinished2 / 1000) % 60;
                                textView2.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
                                timeRemaining2 = millisUntilFinished2;
                            }
                        }


                        public void onFinish() {
                            textView2.setText("00:00:00");
                        }
                    }.start();

                    y++;
                    x=2;
                }
                else if(y==2) {
                    isPaused1 = false;
                    isPaused2= true;

                    long millisInFuture1 = timeRemaining1;
                    long millisInFuture2 = timeRemaining2;
                    long countDownInterval = 1000;

                    textView1 = findViewById(R.id.textView1);
                    new CountDownTimer(millisInFuture1, countDownInterval) {
                        public void onTick(long millisUntilFinished1) {
                            if (isPaused1 || isCanceled) {
                                cancel();
                            } else {
                                NumberFormat f = new DecimalFormat("00");
                                long hour = (millisUntilFinished1 / 3600000) % 24;
                                long min = (millisUntilFinished1 / 60000) % 60;
                                long sec = (millisUntilFinished1 / 1000) % 60;
                                textView1.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
                                timeRemaining1 = millisUntilFinished1;
                            }
                        }


                        public void onFinish() {
                            textView1.setText("00:00:00");
                        }
                    }.start();


                    textView2 = findViewById(R.id.textView2);
                    new CountDownTimer(millisInFuture2, countDownInterval) {
                        public void onTick(long millisUntilFinished2) {
                            if (isPaused2 || isCanceled) {
                                cancel();
                            } else {
                                NumberFormat f = new DecimalFormat("00");
                                long hour = (millisUntilFinished2 / 3600000) % 24;
                                long min = (millisUntilFinished2 / 60000) % 60;
                                long sec = (millisUntilFinished2 / 1000) % 60;
                                textView2.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
                                timeRemaining2 = millisUntilFinished2;
                            }
                        }


                        public void onFinish() {
                            textView2.setText("00:00:00");
                        }
                    }.start();


                }

            }
        });
    }
}







