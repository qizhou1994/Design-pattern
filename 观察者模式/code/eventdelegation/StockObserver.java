package code.eventdelegation;


/**
 * Created by qizhou on 19-1-22.
 */

public class StockObserver {


    private String name;


    private IEvent event;

    public StockObserver(String name ,IEvent event){
        this.name = name;
        this.event = event;
    }


    //关闭股票行情
    public void closeStockMarket(){
        System.out.println(name+" 关闭行情 ");
    }

}
