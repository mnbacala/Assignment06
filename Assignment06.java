package assignment06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Martin
 */
public class Assignment06 {

    Stack pathStack;
//int[] visitedCities = new int[];
    int[][] adjacency;
    int CITI;//number of cities
    int closestCity;
    
    boolean minFlag;
   
    
    
    public Assignment06(int N) {
        CITI = N;
        
        
        int[] visitedCities= new int[CITI];
        adjacency = new int[N][N];
        visitedCities[0] = 0;
        pathStack.push(visitedCities[0]);
        closestCity = 0;
        minFlag = false;
       System.out.println("Starting city is : " + visitedCities[0]);
    }//Lab04

    public void populateMatrix() throws FileNotFoundException {
        File f = new File("tsp12.txt");
        //try {
            Scanner input = new Scanner(f);
            int value, i, j;
            for (i = 0; i < CITI && input.hasNext(); i++) {
                for (j = i; j < CITI && input.hasNext(); j++) {
                    if (i == j) {
                        adjacency[i][j] = 0;
                    } else {
                        value = input.nextInt();
                        //System.out.println(value);
                        adjacency[i][j] = value;
                        adjacency[j][i] = value;
                    }//else
                              

                }//for
               
            }//for
            //System.out.println(adjacency[0][1]);
        //}//try
        //catch (IOException e) {
           // e.printStackTrace();
        //}//catch
        //System.out.println(adjacency[3][3]);
    }//populateMatrix
    public void display(){


    }
        public void tsp(){
        int[] visitedCities= new int[CITI];
        adjacency = new int[CITI][CITI];
        visitedCities[0] = 0;
        pathStack.push(visitedCities[0]);
        closestCity = 0;
        minFlag = false;
        pathStack.push(1);
        
        
        Object element = 0;
        int i = 0;
        closestCity = 0;
        int min = Integer.MAX_VALUE;
        boolean minFlag = false;
        System.out.print(1 + "\t");
 
        while (!pathStack.isEmpty())
        {
            element = pathStack.peek();
            System.out.println((String)element);
            i = 1;
            min = Integer.MAX_VALUE;
            
            for (int j = 0; j <= visitedCities; j++) {//forJ
                if (adjacency[element][i] > 1 && visitedCities[i] == 0)
                {
                    if (min > adjacency[element][i])
                    {
                        min = adjacency[element][i];
                        closestCity = i;
                        minFlag = true;
                    }
                }
                i++;
            }//forJ
            if (minFlag)
            {
                visitedCities[closestCity] = 1;
                pathStack.push(closestCity);
                System.out.print(closestCity + "\t");
                minFlag = false;
                continue;
            }
            pathStack.pop();
        }
    }       

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Assignment06 a = new Assignment06(12);
        a.populateMatrix();
        a.tsp();
    }

}
