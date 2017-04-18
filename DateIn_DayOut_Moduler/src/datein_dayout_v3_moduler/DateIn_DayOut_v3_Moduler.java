/*
This programme does the same thing as "DateIn_DayOut"...
But here, with the Moduler style I've tried reduce the size & complexity of code required in this programme...
And will focus on logic... 

All the calculation in this code has done using a reference date as 24/03/2017 : Friday
Wanna change the reference date to 01/01/2017, it will be easier....

Note: Here, variable "days" is refered to sunday, monday, tuesday etc...
so, the variable dayswillchange and dayswillchange_2 refers to the change in days, from the reference day (friday)...
*/
package datein_dayout_v3_moduler;
import java.io.*;

public class DateIn_DayOut_v3_Moduler 
{
    
    int date, month, year;
    int days = 0;
    int i;
    int dayswillchange = 0;             
    int differenceofdays = 0;           
    int dayswillchange_2 = 0;           
        
    /*Friday will be the first day here because of the reference our date*/
    String[] nameofdays = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};    
    
    public void dayswillchange_in_sameyear(int date, int month, int year)
    {
        if(month >= 5 && month <= 7)
        {
            //7
            for(i=4; i<month; i++)
            {
                if(i%2 == 0)            //condition for EVEN
                {
                    days = days + 30;
                }
                else                    // ODD
                {
                    days = days + 31;
                }
            }
            days = days + date + 7;
        }
        
        else if(month > 7 && month <= 12)
        {
            //129
            for(i=8; i<month; i++)
            {
                if(i%2 == 0)
                {
                    days = days + 31;
                }
                else
                {
                    days = days + 30;
                }
            }
            days = days + date + 129;
        }
        
        else if(month == 1)
        {
            days = (31 - date) + 28 + 24;
        }
        
        else if(month == 2)
        {
            days = (28 - date) + 24;
        }
        
        else if(month == 3)
        {
            days = 31 - date; 
        }
        
        else if(month == 4)
        {
            days = date + 7;
        }
        
        dayswillchange = (days % 7);
                       
        System.out.println("The Date you've entered is on "+nameofdays[dayswillchange]+" in 2017");
    }
    
    public int dayswillchange_differentYear(int year, int dayswillchange)
    {
        if(year > 2017)
        {
            for(i=2018; i<=year; i++)           //because 2017 is not a leap year 
            {
                if(i%4 == 0 && i%400 != 0)      //condition for leap year
                {
                    differenceofdays = differenceofdays + 366; 
                }
                
                else
                {
                    differenceofdays = differenceofdays + 365;
                }            
            }
            
            dayswillchange_2 = (differenceofdays % 7) + dayswillchange;
        }
        
        else if(year < 2017)
        {
            for(i=year; i<2017; i++)                  //because 2017 is not a leap year 
            {
                if(i%4 == 0 && i%400 != 0)             //condition for leap year
                {
                    differenceofdays = differenceofdays + 366; 
                }
                
                else
                {
                    differenceofdays = differenceofdays + 365;
                }            
            }
            
            dayswillchange_2 = dayswillchange - (differenceofdays % 7);
        }
        
        return dayswillchange_2;
    }
    
    public void dayswillchangeMOREthan6(int dayswillchange_2, int year)
    {
        if(dayswillchange_2 > 6)           //it is obvious that if year is 2017 then dayswillchange_2 will not exceed the value of 6...
        {                    
            System.out.println("The Date you've entered is on "+nameofdays[(dayswillchange_2 - 7)]);
        }
        
        else if(dayswillchange_2 <= 6 && year != 2017)          //so it will not executed if year is 2017
        {
            System.out.println("The Date you've entered is on "+nameofdays[dayswillchange_2]);
        }
    }
    
    public void dayswillchangeNegative(int dayswillchange_2)        //it will be executed only if dayswillchange_2 is negative
    {
        System.out.println("The Date you've entered is on "+nameofdays[(dayswillchange_2 + 6)]);
    }    
    
    public static void main(String[] args) throws IOException 
    {
        
        int date, month, year;
        int days = 0;                       //here, variable days is refered to sunday, monday, tuesday etc...
        int i;
        int dayswillchange = 0;             //dayswillchange will store the value of changed days in 2017...
        int differenceofdays = 0;           //it will count days for each year...
        int dayswillchange_2 = 0;           //it will store the value of changed days of same date but different year
        
        /*Friday will be the first day here because of the reference our date*/
        String[] nameofdays = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        
        DataInputStream input = new DataInputStream(System.in);     //object of DIS
        
        System.out.println("Please Enter the Date, Month & Year (Press enter after every input)");
        date = Integer.parseInt(input.readLine());
        month = Integer.parseInt(input.readLine());
        year = Integer.parseInt(input.readLine());
        
        DateIn_DayOut_v3_Moduler object1 = new DateIn_DayOut_v3_Moduler();        //object of class
        
        object1.dayswillchange_in_sameyear(date, month, year);
                
        /*Now if and only if the year is different then next part will be of code will be Executed*/
        
        dayswillchange_2 = object1.dayswillchange_differentYear(year, dayswillchange);      
                        
        /*but what will happen if change of days will be more than 6?
          Because out array has only 6 indexes...*/
        
        if(dayswillchange_2 >= 0)
        {
            object1.dayswillchangeMOREthan6(dayswillchange_2, year);
        }
        
        else if(dayswillchange_2 < 0)
        {
            object1.dayswillchangeNegative(dayswillchange_2);
        }       
                
    }
    
}
        
/*    
This programme still needs some changes
1. year < 2017 problem
2. date input exception
*/