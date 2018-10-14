package com.github.Muhammad.Elgendi.Jefferson;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);
        int response = 0;
        String str ="";
        ArrayList<ArrayList<String>> disk = new ArrayList<>();
        ArrayList<ArrayList<String>> cashedDisk = new ArrayList<>();
        System.out.println("Jefferson disk simulation" );
        while (response == 0 || response == 1 || response == 2 || response ==3 || response ==4  || response ==5){
            System.out.println("Choose from the following options : " );
            System.out.println("1) Read a new text  " );
            System.out.println("2) Create a new disk  " );
            System.out.println("3) Print the disk in vertical mode " );
            System.out.println("4) Rearrange the rows of disk regarding the text " );
            System.out.println("5) Reset the disk " );
            System.out.println("SomeThing else) Exit " );
            System.out.println("Enter your choice number : " );
            response = Integer.valueOf(scanner.nextLine());
            switch(response){
                case  2 :{
                    cashedDisk =  createDisk(str.length());
                    disk = cashedDisk;
                  }
                break;
                case 3 :{
                    for (ArrayList<String> row: disk) {
                        System.out.println( row );
                    }
                }
                break;
                case 1 :{
                    System.out.println("Enter the Plain Text or the Cipher text : " );
                    str = scanner.nextLine().toUpperCase();
                }
                break;
                case 4 :{
                    disk = createRearrangedDisk(str,disk);
                }
                break;
                case 5 :{
                    disk = cashedDisk;
                }
                break;
                default:
                    response = 10;

            }


        }
    }

    public static ArrayList<ArrayList<String>> createDisk(int size){

        List<String> letters = Arrays.asList( "A", "B", "C", "D", "E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" );
        ArrayList<ArrayList<String>> disk = new ArrayList<>();
        for (int i=0;i<size;i++){
            ArrayList<String> newArrangementLetters = new ArrayList<>(letters);
            Collections.shuffle( newArrangementLetters );
            disk.add(i,newArrangementLetters);
        }
        return disk;
    }

    public static ArrayList<String> reArrange(ArrayList<String> array,String str){
        ArrayList<String> toReturn = new ArrayList<>();
        int index = array.indexOf(str);
        int i= index;
        int counter = 0;
        while (i<array.size() && array.size()-1 >= counter){
            toReturn.add(counter,array.get(i));
            i++;
            counter++;
            if(i==array.size()){
                i=0;
            }
        }
        return toReturn;
    }

    public static ArrayList<ArrayList<String>> createRearrangedDisk(String str,ArrayList<ArrayList<String>> disk){
        ArrayList<ArrayList<String>> newDisk = new ArrayList<>();
        for(int i =0;i<str.length();i++){
           newDisk.add(i,reArrange(disk.get(i),String.valueOf(str.charAt(i))));
        }
        return newDisk;
    }


}