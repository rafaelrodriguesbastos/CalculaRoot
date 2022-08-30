package com.example.calcularoot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button btCalcular;
    EditText edtOper1, edtOper2;
    Spinner spinOperador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtOper1 = findViewById(R.id.edtOperando1);
        edtOper2 = findViewById(R.id.edtOperando2);
        spinOperador = findViewById(R.id.spinOperador);
        btCalcular = findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float oper1, oper2, resultado;
                String operador;

                oper1 = Float.valueOf(edtOper1.getText().toString());
                oper2 = Float.valueOf(edtOper2.getText().toString());

                operador = spinOperador.getSelectedItem().toString();

                switch (operador) {
                    case "+":
                        resultado = oper1 + oper2;
                        break;
                    case "-":
                        resultado = oper1 - oper2;
                        break;
                    case "*":
                        resultado = oper1 * oper2;
                        break;
                    case "/":
                        resultado = oper1 / oper2;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + operador);
                }

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Mensagem");
                alertDialog.setMessage("O resultado é " + resultado.toString());
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();


            }
        });
    }
}