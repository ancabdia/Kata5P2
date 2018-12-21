/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import model.*;


public class MailHistogramBuilder {
    public static Histogram<String> build(List<Mail> mail) {
        Histogram<String> histogr= new Histogram<String>();
        for (Mail mail1 : mail) {
            histogr.increment(mail1.getCorreo());
        }
        return histogr;
}
}
