import java.util.Random;
import java.util.Scanner;
public class NumberGame
{
 public static void main(String[] args)
 {
  Scanner input = new Scanner(System.in);
  Random rand = new Random();
  boolean playagain = true;
  int score = 0;
  int round = 0;
  
  while(playagain)
  {
   round++;
   int attempts = 0;
   final int max_attempts = 8;
   int numberToguess = rand.nextInt(100)+1;
   boolean has_guessed_correctly=false;

   System.out.println("round"+round+":");
   while(attempts < max_attempts && ! has_guessed_correctly)
   {
    attempts++;
    System.out.println("Attempt:"+attempts);
    System.out.println("Enter your guess:");
    int userguess = input.nextInt();
    
    if(userguess == numberToguess)
    {
     System.out.println("your Guess is correct !.");
     has_guessed_correctly = true;
    }
    else if(userguess > numberToguess)
    {
     System.out.println("Is too high.");
    }
    else
     {
      System.out.println("Is too low");
      }
     }
      if( ! has_guessed_correctly)
       {
        System.out.println("you have used all attempts.");
       }
       score += has_guessed_correctly ? (max_attempts - attempts + 1):0;
       System.out.println("would you like to play another round ?(y/n):");
       playagain = input.next().equalsIgnoreCase("y"); 
       }
       System.out.println("Game over. your total score is:"+score);
       input.close();
      }
    }        