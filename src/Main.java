import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException{
        System.out.println("1.-----------------");
        Scanner input = new Scanner(System.in);
       // System.out.print(isPalindrome(input));
        System.out.println();
        System.out.println("2.---------------------");
     //   System.out.print(reverseWord(input));
        System.out.println("3.---------------");
        //System.out.print(socialCheck(input));
        accountBalance();
    }
// Question 1
    public static boolean isPalindrome(Scanner input){
        boolean isTrue = false;
        String word = input.nextLine().toLowerCase();
        StringBuilder sb = new StringBuilder(word);
        String reverse = sb.reverse().toString().toLowerCase();

    if(word.equals(reverse)){
        return isTrue = true;
    }else{
        return isTrue= false;
    }
    }
//Question 2
    public static String reverseWord(Scanner input){
        System.out.println("Enter a word :");
        String word = input.nextLine();
        String [] str = word.split("");
        String[] arr = new String[str.length];
        for(int i = str.length-1; i>= 0; i-- ){
            arr[i]=str[str.length-i-1];
        }
        return String.join("",arr);
        }

//Question 3
    public static boolean socialCheck(Scanner input){
        System.out.print("Enter your social security number with dashes :");
        boolean ifValid = false;
        String temp = "###-##-####";
        String[] str = input.nextLine().split("-");
        for(int i = 0; i<str.length; i++){
            str[i]= str[i].replaceAll("[0-9]","#");
        }
        String newSocial = String.join("-",str);
        if(newSocial.equals(temp)){
            System.out.println(newSocial+" is a valid social security number\n");
            return ifValid=true;
        }else{
            System.out.println(newSocial+" is not a valid social security number\n");
            return ifValid;
        }

    }
//Question 4
    public static void accountBalance() throws IOException {
        File file = new File("in.csv");
        File newFile = new File("out.csv");
        PrintWriter writer = new PrintWriter(newFile);
        Scanner scanner = new Scanner(file);
        ArrayList<Integer>ids= new ArrayList<>();
        ArrayList<Double> balances = new ArrayList<>();
        ArrayList<String>firstNames = new ArrayList<>();
        ArrayList<String>lastNames = new ArrayList<>();
        String str = "";
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] values = line.split(",");
            firstNames.add(values[1]);
            lastNames.add(values[2]);
            int id = Integer.parseInt(values[0]);
            double balance = Double.parseDouble(values[3]);
            balances.add(balance);
            ids.add(id);

        }
        scanner.close();

        int highBalance = highestBalance(balances);
        int lowBalance= lowestBalance(balances);
        writer.println("The customer with the highest balance is: \nID: "+ ids.get(highBalance)+"\nFirst Name: "+firstNames.get(highBalance)+"\nLast Name :"+lastNames.get(highBalance)+"\nAccount Balance:  "+ balances.get(highBalance)+ "\n \n");
       writer.println("The customer with the lowest balance is: \nID: "+ ids.get(lowBalance)+"\nFirst Name: "+firstNames.get(lowBalance)+"\nLast Name :"+lastNames.get(lowBalance)+"\nAccount Balance:  "+ balances.get(lowBalance)+ "\n \n");
    writer.close();
    int searchInd = search(lastNames);

        System.out.println("The customer with the lowest balance is: \nID: "+ ids.get(searchInd)+"\nFirst Name: "+firstNames.get(searchInd)+"\nLast Name :"+lastNames.get(searchInd)+"\nAccount Balance:  "+ balances.get(searchInd)+ "\n \n");

    };


    public static int highestBalance(ArrayList<Double>balances){
        int index = 0;
        double high = balances.get(0);
        for(int i = 1; i<balances.size();i++){
            if(balances.get(i)>high){
                high = balances.get(i);
                index = i;
            }
        }
        return index;
    }

    public static int lowestBalance(ArrayList<Double>balances){
        int index = 0;
        double low = balances.get(0);
        for(int i = 1; i<balances.size();i++){
            if(balances.get(i)<low){
                low = balances.get(i);
                index = i;
            }
        }
        return index;
    }

    public static int search(ArrayList<String>lastNames){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String search = input.nextLine();
        int index= 0;
        for(int i =0; i<lastNames.size(); i++){
           if(search.equals(lastNames.get(i)) ){
               index = i;
           }
        }
        return index;
    }

    }

