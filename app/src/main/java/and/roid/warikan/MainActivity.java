package and.roid.warikan;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText totalCost = this.findViewById(R.id.total_Cost);
        EditText peopleCount = this.findViewById(R.id.people_Count);
        RadioGroup calcOption = this.findViewById(R.id.calc_options);

        Button calcButton = this.findViewById(R.id.calculate_button);
        TextView calcResult = this.findViewById(R.id.calc_result);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(totalCost.getText())) {
                    Toast.makeText(getApplicationContext(), "支払総額を入力してください", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(peopleCount.getText())) {
                    Toast.makeText(getApplicationContext(), "人数を入力してください", Toast.LENGTH_SHORT).show();
                    return;
                }
                double dblTotalCost = Integer.parseInt(totalCost.getText().toString());
                double dblPeopleCount = Integer.parseInt(peopleCount.getText().toString());
                double dblCalcResult = dblTotalCost / dblPeopleCount;
                int intCalcResult;
//                Toast.makeText(getApplicationContext(), "" + calcOption.getCheckedRadioButtonId(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), "" + (dblCalcResult), Toast.LENGTH_SHORT).show();
                if(calcOption.getCheckedRadioButtonId() == R.id.option_up){
//                    Toast.makeText(getApplicationContext(), "option_up" + (dblTotalCost / dblPeopleCount), Toast.LENGTH_SHORT).show();
                    intCalcResult = (int)Math.ceil(dblCalcResult);
                } else {
//                    Toast.makeText(getApplicationContext(), "option_down" , Toast.LENGTH_SHORT).show();
                    intCalcResult = (int)Math.floor(dblCalcResult);
                }
                calcResult.setText("" + intCalcResult);
//                Toast.makeText(getApplicationContext(), "On Click!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}