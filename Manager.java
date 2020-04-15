package sample;

/**
 * This is the Manager class, a subclass of staff.
 * @author Emily Wells.
 * @version 1.0.
 */

public class Manager extends Staff{

    /**
     * This is the constructor for a manager object.
     * @param userID_
     * @param firstName_
     * @param lastName_
     */
    public Manager(final int userID_, final String firstName_, final String lastName_, final String staffType_){
        super(userID_, firstName_, lastName_, staffType_);
    }

    /**
     * This function allows a manager to create a new staff profile and it is added to the database.
     * @param userID_
     * @param firstName_
     * @param lastName_
     */
    public void setStaffProfile(int userID_, String firstName_, String lastName_, String staffType_){
        Staff newMember = new Staff(userID_, firstName_, lastName_, staffType_);
        //TO DO create SQL code to append  staff member to the database
    }

    /**
     * This function allows the manager to edit a staff profile and it is adjusted in the database.
     * @param userID_
     * @param firstName_
     * @param lastName_
     */
    public void editStaffProfile(final int userID_, final String firstName_, final String lastName_){
        //TO DO edit in database, SQL coding needed
    }

    /**
     * This function allows a manager to delete a user profile from the database.
     * @param userID
     */
    private void deleteProfile(int userID){
        //TO DO edit in database, SQL coding needed
    }

    /**
     * This function allows a manager to generate a reoprt for the specified data and time period.
     * @param sDate_
     * @param eDate_
     * @return
     */
    //TO DO un comment the functions that are called from 'reports' once reports is completed
    //manager can request reports
    private String requestReport(final int sDate_, final int eDate_){
        Report period = new Report(sDate_, eDate_);
        return "Most active customer: " /*+ mostActiveCustomer(period) */+ " Most popular item: " /*+ mostPopularItem(period)*/;

        //TO DO complete the rest with SQL code, and remove void
    }

    /**
     * This function allows a manager to generate a reoprt for the specified date period.
     * @param sDate_
     * @param eDate_
     * @return
     */
    //manager can request reports
    private String requestReport(final int sDate_, final int eDate_, final int sTime_, final int eTime_){
        Report period = new Report(sDate_, eDate_, sTime_, eTime_);
        return "Most active customer: " /*+ mostActiveCustomer(period) */+ " Most popular item: " /*+ mostPopularItem(period)*/;
        //TO DO complete the rest with SQL code, and remove void
    }
}

