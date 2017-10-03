package abo.pro;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.util.HashMap;


public class SearchEngine {


        JTextField textField = new JTextField();

        JFrame window = new JFrame();

        JButton radioOne = new JButton("Please specify a measuring time");


        Object myObject = new Object();

        private void handleRadioOne() {
            myObject.toString();

        }

        public SearchEngine() {


            radioOne.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    FileReader fr = null;
                    try {
                        fr = new FileReader("C:\\Users\\Desktop\\SearchEngine\\src\\main\\java\\abo\\pro\\weather.json");
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    JSONParser jp = new JSONParser();
                    JSONObject jo = null;
                    try {
                        jo = (JSONObject) jp.parse(fr);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    JSONArray kk = (JSONArray) jo.get("measurements");

                    HashMap<String, Value> values = new HashMap<>();
                    String yy  =   textField.getText();

                    for (Object json : kk) {

                        JSONObject jj = (JSONObject) json;
                        String p = jj.get("time").toString().trim();

                        Value w = new Value();
                        w.setT(Double.valueOf(jj.get("temp").toString().trim()));
                        w.setW(Double.valueOf(jj.get("wind").toString().trim()));
                        w.setH(Double.valueOf(jj.get("humid").toString().trim()));
                        values.put(p, w);

                    }

                    Value oo = values.get(yy);
                    oo.print(yy);


                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            handleRadioOne();
                        }
                    });
                }
            });



            textField.setPreferredSize( new Dimension( 1000, 24 ) );
            textField.setBounds(10,10,200,40);


            window.setLayout(new BorderLayout());

            window.add(textField);
            window.add(radioOne, BorderLayout.SOUTH);

            window.pack();
            window.setVisible(true);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setLocationRelativeTo(null);


        }

    }

