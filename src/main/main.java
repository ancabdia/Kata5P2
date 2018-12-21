package main;

import java.io.IOException;
import java.util.List;
import model.*;
import view.*;

public class main {
    private List<Mail> mailList;
    private Histogram<String> histogram;
   
    public static void main(String[] args) throws IOException {
      main kata4=new main();
      kata4.execute();
      MailListReaderBD.getInstance().read();
    }
    
    void execute() throws IOException {
        input();
        process();
        output();
    }
    
    void input() throws IOException {
        String fileName="email.txt";
        //mailList= MailListReader.read(fileName);
        mailList = MailListReaderBD.getInstance().read();
    }
    
    void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
}    
}
