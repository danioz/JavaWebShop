package org.example.checkout;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PaymentOptionFactory {

    private static final Map<String, Function<WebDriver, IPaymentMethod>> MAP = new HashMap<>();

    private static final Function<WebDriver, IPaymentMethod> CC = CreditCard::new;
    private static final Function<WebDriver, IPaymentMethod> COD = CashOnDelivery::new;
    private static final Function<WebDriver, IPaymentMethod> PO = PurchaseOrder::new;
    private static final Function<WebDriver, IPaymentMethod> CH = Check::new;

    static {
        MAP.put("CC", CC);
        MAP.put("COD", COD);
        MAP.put("PO", PO);
        MAP.put("CH", CH);
    }

    public static IPaymentMethod get(String option, WebDriver driver) {
        return MAP.get(option).apply(driver);
    }

}
