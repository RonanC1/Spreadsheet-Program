/*
 *		Student: Ronan Conneely
 *		Student number: 18169899
 *		Course: Higher Diploma in Software Development
 *
 *		This is a class that creates a list of fixed size and manipulates the data using the methods.
 */

package com.Lectures;


public class spreadSheet{
    private String[] sheetArray;
    private int nextAvailablePosition;
    private int currentPosition;

    public spreadSheet()//constructor for new array of size
    {
        sheetArray = new String[256];
        nextAvailablePosition = 3;
        currentPosition = 2;
        for(i = 0; i < nextAvailablePosition; i++)//Creates firsts three sheets
        {
            sheetArray[i] = sheet();
        }
    }

    public spreadSheet(int size)//constructor for new array of size
    {
        if(size > 256)
        {
            size = 256;
            System.out.println("Sorry, the max list size is 256. A list capable of holding 256 sheets has been created for you.\n");
        }

        if(size < 3)
        {
            size = 3;
            System.out.println("Sorry, the minimum starting list size is 3. A list of 3 sheets has been created for you.\n");
        }


        sheetArray = new String[size];
        nextAvailablePosition = 3;
        currentPosition = 2;
        for(i = 0; i < nextAvailablePosition; i++)
        {
            sheetArray[i] = sheet();
        }
    }

    private String sheet = "";
    private int sheetNumber;
    public String sheet()//creates new sheetN
    {
        sheet = "Sheet" + Integer.toString(sheetNumber+1);
        sheetNumber++;
        return sheet;
    }

    private int i;
    public boolean add()//adds a new entry into the sheet name list, unless it already contains 256 entries.
    {
        if(nextAvailablePosition == sheetArray.length)//if the next available position is equal to the size of the array
        {
            System.out.println("Sorry, the list is full. No more sheets can be created.");
            return false;
        }
        sheetArray[nextAvailablePosition] = sheet();
        nextAvailablePosition++;//increment next available position
        currentPosition++;//increments last element counter
        return true;
    }

    private int count;
    private String empty = "";
    public int length()//returns number of items in list
    {
        return nextAvailablePosition;
    }

    public void display()//displays all names in list on screen
    {
        for(int i = 0; i < nextAvailablePosition; i++)
        {
            System.out.printf("Index %d: %s\n", i, sheetArray[i]);
        }
    }

    public String sheetName(int index)//returns name of sheet at given index
    {
        if(index < nextAvailablePosition && index >= 0)//checks if in range
        {
            return sheetArray[index];
        }

        else
        {
            return null;
        }
    }

    public int index(String sheetName)//returns index position of name passed
    {
        for(i = 0; i < nextAvailablePosition; i++)//searches the array
        {
            if(sheetArray[i].toUpperCase().equals(sheetName.toUpperCase()))//compares in uppercase to make case differences redundent
            {
                return i;
            }
        }
        return -1;
    }

    public int size()//returns the size of the whole array
    {
        return sheetArray.length;
    }



    public int rename(String currentName, String newName)
    {
        if(currentName.equals(null) || newName.equals(null)|| currentName.equals("") || newName.equals(""))//checks there are no nulls or empty strings
        {
            return -1;
        }

        for(i = 0; i < nextAvailablePosition; i++)//checks for name first
        {
            if(sheetArray[i].toUpperCase().equals(newName.toUpperCase()))//if they are equal, return -1
            {
                System.out.printf("Sorry, that name already exists :(\n");
                return -1;
            }
        }

        sheetArray[index(currentName)] = newName;
        return index(newName);
    }


    private int j;
    public int remove(String sheetName)//removes a sheet name from the list.
    {
        if(nextAvailablePosition == 1)
        {
            System.out.printf("You cannot remove the sheet as you must have one sheet in the list at all times\n");
            return -1;
        }

        if(sheetArray[index(sheetName)].toUpperCase().equals(sheetName.toUpperCase()))//if there is a match
        {
            for(j = index(sheetName); j < currentPosition; j++)//starts at index of string passed
            {
                sheetArray[j] = sheetArray[j+1];//position above j is inserted into j
            }
            currentPosition -= 1;
            nextAvailablePosition -=1;//moves down the counter position
            return j;//If the remove successful the method returns the index position of sheet removed.
        }
        return -1;//Otherwise it returns -1.
    }

    private String removed = "";
    public String remove(int index) //uses an index as input to remove
    {
        if(index >= 0 || index <= 255){
            removed = sheetName(index);
            remove(sheetName(index));
            return removed;
        }
        return null;
    }

    private int insertInto;
    public int move(String from, String to, boolean before)//allows sheet name to be moved to one position to another
    {
        if(from.toUpperCase().equals(to.toUpperCase()))//if they are equal return -1
        {
            return index(from);
        }

        if(index(from) == -1 || index(to) == -1)//check both exist
        {
            return -1;
        }

        if(nextAvailablePosition == 1)//if there's only one sheet left
        {
            return index(from);
        }
        remove(from);//remove string which will move all else down

        insertInto = index(to);//if true, gets index of String to and stores it in insertInto
        if(before == false)//if false, gets index+1 of String to and stores it in insertInto
        {
            insertInto = index(to)+1;
        }
        //inserts string into position
        for(j = currentPosition; j >= insertInto; j--)//j = the index before the last index
        {
            sheetArray[j+1] = sheetArray[j];//moves element at index j into the last element. On next repetition, moves j into where j was last time
        }
        sheetArray[insertInto] = from;//find new position//insert into new position
        nextAvailablePosition++;//counteracts remove nextAvailablePosition--;
        currentPosition++;
        return j;
    }

    private int moved = 0;
    public String move(int from, int to, boolean before)//uses indices instead of names
    {
        if(sheetName(from) == null || sheetName(to) == null || sheetName(from).equals("") || sheetName(to).equals("null"))//checks if string passed is null or empty
        {
            return null;
        }

        moved = move(sheetName(from), sheetName(to), before);//calls move method and uses sheetName method to pass strings
        return sheetName(moved);

    }

    private int numHolder = 0;
    public int moveToEnd(String from)//moves string at index to end of list
    {
        numHolder = move(from, sheetName(currentPosition), false);//calls move function and assigns return value to variable. Passes from, the name of the last string in the array
        return numHolder;//return of move method

    }

    public String moveToEnd(int from)//moves sheet from current position to end of list
    {

        if(sheetName(from) == null || from >= nextAvailablePosition || from < 0)//checks if from position exists and is in the range
        {
            System.out.printf("Sorry, the index position '%d' specified does not exist\n", from);
            return null;
        }
        move(sheetName(from), sheetName(currentPosition), false);//calls move function. Takes in String at position from, the very last String at current position, and false to move after last string
        return sheetName(from);
    }
}