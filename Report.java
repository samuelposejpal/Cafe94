package sample;

/**
 * This class represents the construction of reports time/date period.
 * @author Emily Wells
 * @version 1.0
 */

public class Report {
    // The instance variables:
    /*private final int period;*/
    private final int sDate;
    private final int eDate;
    private final int eTime;
    private final int sTime;

    /**
     * This creates a report period for a specified data and time.
     * @param sDate_
     * @param eDate_
     * @param sTime_
     * @param eTime_
     */
    // The constructor for date AND time (setting the data):
    public Report(final int sDate_, final int eDate_, final int sTime_, final int eTime_) {
        /*this.period = 0;*/
        sDate = sDate_;
        eDate = eDate_;
        sTime = sTime_;
        eTime = eTime_;
    }

    /**
     * This creates a report period for a specified date.
     * @param sDate_
     * @param eDate_
     */
    //constructor for just date.
    public Report(final int sDate_, final int eDate_) {
        /*this.period = 0;*/
        this.sTime = 0;
        this.eTime = 0;
        sDate = sDate_;
        eDate = eDate_;
    }

	  /*/ The methods: TO DO this is to be coded in SQL for retrieval from Database
	  public mostPopularItem(Reports period){
	  }
	  public busiestPeriod(Reports period){
	  }
	  public int mostActiveCustomer(Reports period) {
	  }*/
}
