package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.calculator.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    double firstNum;
    double secondNum;
    boolean click = false;
    int n;
    ArrayList<Button> opers = new ArrayList<>();
    ArrayList<Button> nums = new ArrayList<>();
    String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       /* binding.screen.setVisibility(View.GONE);*/

        binding.buttOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.screen.setVisibility(View.GONE);
            }
        });

        binding.buttOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.screen.setVisibility(View.VISIBLE);
                binding.screen.setText("0");
            }
        });


        nums.add(binding.butt0);
        nums.add(binding.butt1);
        nums.add(binding.butt2);
        nums.add(binding.butt3);
        nums.add(binding.butt4);
        nums.add(binding.butt5);
        nums.add(binding.butt6);
        nums.add(binding.butt7);
        nums.add(binding.butt8);
        nums.add(binding.butt9);

        for(Button b : nums){
            b.setOnClickListener(view ->{
                if(!binding.screen.getText().toString().equals("0")){
                    binding.screen.setText(binding.screen.getText().toString()+b.getText().toString());
                }
                else{
                    binding.screen.setText(b.getText().toString());
                }
            });
        }

        opers.add(binding.buttDivide);
        opers.add(binding.buttMul);
        opers.add(binding.buttSub);
        opers.add(binding.buttAdd);

        for(Button b : opers){
            b.setOnClickListener(view ->{
                    firstNum = Double.parseDouble(binding.screen.getText().toString());
                    operation = b.getText().toString();
                    binding.screen.setText(binding.screen.getText().toString()+b.getText().toString());
                    n = binding.screen.getText().toString().length();
            });
        }

        binding.buttDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num  =binding.screen.getText().toString();
                if(num.length()>1){
                    binding.screen.setText(num.substring(0,num.length()-1));
                }
                else if(num.length()==1 && !num.equals("0")){
                    binding.screen.setText("0");
                }
            }
        });

        binding.buttAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.screen.setText("0");
            }
        });

        binding.buttDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!binding.screen.getText().toString().contains(".")){
                    binding.screen.setText(binding.screen.getText().toString()+".");
                }
            }
        });

        binding.buttEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = true;
                String curr = (binding.screen.getText().toString());
                secondNum = Double.parseDouble(curr.substring(n));

                double result;
                switch (operation){
                    case "/":
                        result=firstNum/secondNum;
                        break;

                    case "*":
                        result = firstNum*secondNum;
                        break;

                    case "+":
                        result = firstNum+secondNum;
                        break;

                    case "-":
                        result=firstNum-secondNum;
                        break;
                    default:
                        result =firstNum+secondNum;
                }
                binding.screen.setText(String.valueOf(result));
                firstNum=result;
            }
        });
 }

 public void button(){
     for(Button b : opers){
         b.setOnClickListener(view ->{
             firstNum = Double.parseDouble(binding.screen.getText().toString());
             operation = b.getText().toString();
             binding.screen.setText("0");
             /*binding.screen.setText(binding.screen.getText().toString()+b.getText().toString());*/
         });
     }
 }

}