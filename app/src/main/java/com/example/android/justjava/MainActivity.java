/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    String TAG = "Value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        /*display(quantity);
        displayPrice(quantity*5);*/
        int price = calculatePrice();
        CheckBox whippedCream = findViewById(R.id.whipped_cream);
        CheckBox chocolate = findViewById(R.id.chocolate);
        EditText name_object = findViewById(R.id.name_text);
        String name = name_object.getText().toString();
        String priceMessage = createOrderSummary(price, whippedCream, chocolate, name);
        displayMessage(priceMessage);
    }

    public void increment(View view) {
        quantity += 1;
        display(quantity);
    }

    public void decrement(View view) {
        quantity -= 1;
        display(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
   /* private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }


    /**
     * @param finalPrice price of the order
     * @param name name of buyer
     */
    private String createOrderSummary(int finalPrice, CheckBox whippedCream, CheckBox chocolate, String name) {
        String numCoffees = "Quantity: " + quantity;
        String totalPrice = "Total: $" + finalPrice;
        String appreciation = "tanks u!";

        Log.i(TAG, "This is the value: " + name);


        //whippedCream.isChecked()
        String finalMessage = name + "\n" + "Add whipped cream? " + whippedCream.isChecked() + "\n" + "Add Chocolate? " + chocolate.isChecked() + "\n" + numCoffees + "\n" + totalPrice + "\n" + appreciation;
        return finalMessage;
    }
}