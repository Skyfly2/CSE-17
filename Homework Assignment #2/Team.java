/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework #2
 * Program: Team
 */
public class Team{
    public String locationName;
    public String teamName;
    public int [] weeksPlayed = new int[17];
    public String[] dateList = new String[17];

    /**
     * Creates a new team with a given location, name, and list of dates which they play games on
     * @param locationName This is the name of the location they play
     *                     Should be a city or state
     * @param teamName     This is the nickname for a team
     * @param dateList     An array of dates to represent a schedule
     */
    Team(String locationName, String teamName, String dateList[]){
        this.locationName = locationName;
        this.teamName = teamName;
        this.dateList = dateList;

        //Make sure weekPlayed() is run
        weekPlayed();
    }

    /**
     * Creates a new team with a given location and list of dates which they play games on
     * @param locationName This is the name of the location they play
     *                     Should be a city or state
     *
     * @param dateList     An array of dates to represent a schedule
     */
    Team(String locationName, String[] dateList){
        this(locationName, "N/A", dateList);
    }

    /**
     * Creates a new team with a list of dates which they play games on
     * @param dateList     An array of dates to represent a schedule
     */
    Team(String[] dateList){
        this("N/A", "N/A", dateList);
    }
    
    /**
     * Populate an array with indicators as to whether or not a team plays on specific weeks
     * In each week, a 1 is entered if the team does play, and a 0 if the team does not
     * @return the array with these figures
     */
    public int[] weekPlayed(){
        //Loop through the datelist of the team
        for(int c = 0; c < dateList.length; c++){
            if(dateList[c].equals("00/00")){
                //Mark bye weeks as 0
                weeksPlayed[c] = 0;
            }
            else{
                //Mark weeks being played as 1
                weeksPlayed[c] = 1;
            }
        }
        return weeksPlayed;
    }

    /**
     * Determines the week in a season that the team does not play
     * @return the week that the team does not play
     */
    public int byWeek(){
        int byWeek = -1;
        //Loop through the datelist of the team
        for(int c = 0; c < dateList.length; c++){
            if(dateList[c].equals("00/00")){
                //find the integer value of the bye week
                byWeek = c+1;
                break;
            }
        }
        return byWeek;
    }
    
    /**
     * Estimates the incoming revenue of a team from ticket sales on a particular week
     * @param week Provides the week of the sales
     * @param team provides the team which will be selling the tickets
     * @param ticketPrice Provides the cost of the ticket sales will be multiplied by
     * @param numSeats Provides the number of seats in the stadium
     * @param percent Provides the percentage of seats that will be sold, works as a multiplier for sales
     * @return The total amount of money that the sale brings in
     */
    public static double estimateSales(int week, Team team, double ticketPrice, int numSeats, double percent){
        double totalMoney = 0;
        //If the date at the selected week is not a bye week, estimate sales
        if(!team.dateList[week - 1].equals("00/00")){
            totalMoney = (numSeats * percent) * ticketPrice;
        }

        return totalMoney;
    }
    
    /**
     * Checks to see if 2 different teams both play on a specific date
     * @param teams[] Provides the teams that will have their schedules compared
     * @param date Provides the date to check if the teams play on
     * @return true if the two teams play on the specified date, false if they do not
     */
    public static boolean checkSchedule(Team[] teams, String date){
        //Loop through the datelist of the teams
        for(int c = 0; c < teams[0].dateList.length; c++){
            if((teams[0].dateList[c].equals(date)) && (teams[1].dateList[c].equals(date))) {
                //If both teams play on a certain date return true
                return true;
            }
        }
        //If the teams don't play on the same date, return false
        return false;
    }
    
    /**
     * Prints a table of the ticket sales based on the number of seats and percentage of seats sold for a particular week
     * @param teams[] Provides the teams with which the sales will be printed
     * @param ticketPrice provides the price of the tickets to multiply sales by
     * @param numSeats Provides the number of seats in the stadium
     * @param week Provides the week the sale is occurring
     */
    public static void printSales(Team[] teams, double ticketPrice, int numSeats, int week){
        //Print display format
        System.out.println("Seats\tPercent\tSales");
        System.out.println("_____\t_______\t_____");
        int numGames = 0;
        double sales = 0;

        //Data operation if an array of length 3 is input
        if(teams.length == 3){
            //Convert array to combination arrays to check the dates played bewteen the teams
            Team teams1and2[] = new Team[2];
            teams1and2[0] = teams[0];
            teams1and2[1] = teams[1];

            Team teams1and3[] = new Team[2];
            teams1and3[0] = teams[0];
            teams1and3[1] = teams[2];

            Team teams2and3[] = new Team[2];
            teams2and3[0] = teams[1];
            teams2and3[1] = teams[2];
            if((teams[0].byWeek() == week) && (teams[1].byWeek() == week) && (teams[2].byWeek() == week)){
                //No games if all teams have bye weeks
                numGames = 0;
            }
            else if(((checkSchedule(teams1and2, teams1and2[0].dateList[week-1]) && checkSchedule(teams1and3, teams1and3[0].dateList[week-1])) && teams[0].byWeek() != week) || ((teams[0].byWeek() == week) && (teams[1].byWeek() == week)) || ((teams[0].byWeek() == week) && (teams[2].byWeek() == week)) || ((teams[1].byWeek() == week) && (teams[2].byWeek() == week))) {
                //Multiplier of 1 if all teams play the same day or only one team plays
                numGames = 1;
            }
            else if((!checkSchedule(teams1and2, teams1and2[0].dateList[week-1]) && !checkSchedule(teams1and3, teams1and3[0].dateList[week-1]) && !checkSchedule(teams2and3, teams2and3[0].dateList[week-1])) && ((teams[0].byWeek() != week) && (teams[1].byWeek() != week) && (teams[2].byWeek() != week))){
                //Multiplier of 3 if all teams play on different dates and it isn't a bye week for any of them
                numGames = 3;
            }
            else{
                //Multiplier of 2 in any other case
                numGames = 2;
            }

        }

        //Data operation if an array of length 2 is input
        if(teams.length == 2){
            if((teams[0].byWeek() == week) && (teams[1].byWeek() == week)){
                //If both teams have a bye week, no games
                numGames = 0;
            }
            else if((teams[0].byWeek() == week) || (teams[1].byWeek() == week) || checkSchedule(teams, teams[0].dateList[week-1])){
                //Multiplier of 1 if the teams play each other or if one has a bye week
                numGames = 1;
            }
            else{
                //Multiplier of 2 in any other case
                numGames = 2;
            }
        }

        //Data operation if an array of length 1 is input
        if(teams.length == 1){
            if(teams[0].byWeek() == week){
                //No games if the team has a bye week
                numGames = 0;
            }
            else{
                //Multiplier of 1 in any other case
                numGames = 1;
            }
        }

        //Run specific operation depending on the multiplier
        switch(numGames){
            case 0:
            //Loop through the different percentages. No sales since no games
            for(double percent = 0.70; percent <= 1.001; percent = percent + .05){
                System.out.println(numSeats + "\t" + String.format("%.1f", (percent * 100)) + "%\t$" + String.format("%.2f", sales)); 
            }
            break;
            case 1:
            //Loop through the percentages (percent <= 1.001 because computer rounding error was cutting off the last calculation otherwise)
            for(double percent = 0.70; percent <= 1.001; percent = percent + .05){
                //Because potentially not all teams play, find one that does to use as input for the estimateSales function
                if(teams[0].byWeek() != week){
                    sales = estimateSales(week, teams[0], ticketPrice, numSeats, percent);
                }
                else if(teams[1].byWeek() != week){
                    sales = estimateSales(week, teams[1], ticketPrice, numSeats, percent);
                }
                else{
                    sales = estimateSales(week, teams[2], ticketPrice, numSeats, percent);
                }
                //Print result
                System.out.println(numSeats + "\t" + String.format("%.1f", (percent * 100)) + "%\t$" + String.format("%.2f", sales)); 
            }
            break;
            case 2:
            //Loop through the percentages (percent <= 1.001 because computer rounding error was cutting off the last calculation otherwise)
            for(double percent = 0.70; percent <= 1.001; percent = percent + .05){
                //Because potentially not all teams play, find one that does to use as input for the estimateSales function
                if(teams[0].byWeek() != week){
                    sales = 2 * estimateSales(week, teams[0], ticketPrice, numSeats, percent);
                }
                else if(teams[1].byWeek() != week){
                    sales = 2 * estimateSales(week, teams[1], ticketPrice, numSeats, percent);
                }
                else{
                    sales = 2 * estimateSales(week, teams[2], ticketPrice, numSeats, percent);
                }
                //Print Result
                System.out.println(numSeats + "\t" + String.format("%.1f", (percent * 100)) + "%\t$" + String.format("%.2f", sales));  
            }
            break;
            case 3:
            //Loop through the percentages (percent <= 1.001 because computer rounding error was cutting off the last calculation otherwise)
            for(double percent = 0.70; percent <= 1.001; percent = percent + .05){
                //All teams play, can just input any of them
                sales = 3 * estimateSales(week, teams[0], ticketPrice, numSeats, percent);
                //Print result
                System.out.println(numSeats + "\t" + String.format("%.1f", (percent * 100)) + "%\t$" + String.format("%.2f", sales));  
            }
            break;
        }
    }
}
