package org.example.checkout;

import java.util.Map;

public interface IPaymentMethod {

    void enterPaymentInformation(Map<String, String> paymentDetails);

    void setContinueButtons(Buttons buttons);
}
