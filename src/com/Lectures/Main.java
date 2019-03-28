/*
 *		Student: Ronan Conneely
 *		Student number: 18169899
 *		Course: Higher Diploma in Software Development
 */

package com.Lectures;

public class Main {

    public static void main(String[] args)
    {
        int i = 0;

        spreadSheet listOne = new spreadSheet();
        System.out.printf("Currently there are %d sheets in the list\n", listOne.length());
        listOne.display();
        System.out.printf("\n");
        System.out.printf("Let's fill the list to capacity\n");
        for(i = listOne.length(); i < listOne.size(); i++)
        {
            listOne.add();
        }

        System.out.printf("The elements at index 0, 127 and 255 are %s, %s and %s\n", listOne.sheetName(0), listOne.sheetName(127), listOne.sheetName(255));
        System.out.printf("Let's try add another sheet.\n");
        listOne.add();
        System.out.printf("\n");

        System.out.printf("Let's try create a bigger list of size 257.\n");
        spreadSheet listTwo = new spreadSheet(257);
        listTwo.display();
        System.out.printf("\n");
        System.out.printf("And a smaller list?\n");
        spreadSheet listThree = new spreadSheet(2);
        listTwo.display();

        System.out.printf("\n");
        System.out.printf("Let's just create a new list of size 20 and fill it to capacity.\n");
        spreadSheet listFour = new spreadSheet(20);
        for(i = listFour.length(); i < listFour.size(); i++)
        {
            listFour.add();
        }
        System.out.printf("There is now %d sheets in the list.\n", listFour.length());
        System.out.printf("The name of the sheet at index 0, 5 and 10 are; %s, %s, %s.\nThey will now be renamed as Hello, there, Dermo\n", listFour.sheetName(0),listFour.sheetName(5), listFour.sheetName(10));
        listFour.rename(listFour.sheetName(0), "Hello");
        listFour.rename(listFour.sheetName(5), "there");
        listFour.rename(listFour.sheetName(10), "Dermo");
        System.out.printf("\n");
        listFour.display();
        System.out.printf("\n");

        System.out.printf("Great, we renamed so sheets, but they should be next to each other\n");
        listFour.move("Hello","Dermo",true);
        listFour.move("there","Hello",false);
        System.out.printf("\n");
        listFour.display();
        System.out.printf("\n");

        System.out.printf("Looks good! Why don't we move the three strings to the beginning of the list instead\nNow our first three sheets should be named Hello there Dermo\n");
        listFour.move(listFour.index("Hello"), 0,true);
        listFour.move(listFour.index("Dermo"), 0,false);
        listFour.move(listFour.index("there"),listFour.index("Dermo"),true);
        System.out.printf("\n");
        listFour.display();
        System.out.printf("\n");
        System.out.printf("Let's get rid of sheets 10 - 20 and add in 10 new ones. The first three sheets will also be moved to the end\n");
        for(i = listFour.length()-1; i > 9; i--)
        {
            listFour.remove(i);
        }
        for(i = listFour.length()-1; i < listFour.size()-1; i++)
        {
            listFour.add();
        }
        listFour.moveToEnd("Hello");
        listFour.moveToEnd("there");
        listFour.moveToEnd(0);
        listFour.display();
        System.out.printf("\n");
        System.out.printf("Lets get rid of all sheets that don't follow the naming convention.\n");
        System.out.printf("\n");
        listFour.remove("HeLlo");
        listFour.remove("THERE");
        listFour.remove("dermO");
        listFour.display();
        System.out.printf("\n");
        System.out.printf("Finally, lets get rid of all sheets.\n");
        System.out.printf("\n");
        for(i = listFour.length()-1; i >= 0; i--)
        {
            listFour.remove(i);
        }
        listFour.display();
        System.out.printf("\n");
        listFour.toString();

    }
}
