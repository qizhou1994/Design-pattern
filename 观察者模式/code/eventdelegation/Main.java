package code.eventdelegation;

/**
 * Created by qizhou on 19-1-22.
 */

public class Main {

    public static void main(String[] args){
        Boss hu1 = new Boss();



        StockObserver stockObserver = new StockObserver("股票1",hu1);
        NBAObsver nbaObsver = new NBAObsver("NBA",hu1);

        hu1.setEventHandler(new EventHandler());

        hu1.addEventListener(stockObserver,
                "closeStockMarket",null);

        hu1.addEventListener(nbaObsver,
                "closeStockMarket",null);



        hu1.subjectState = "呼呼呼呼呼";

        hu1.notifySubject();
    }
}
