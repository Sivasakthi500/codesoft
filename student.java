import java.util.Scanner;
public class student
{
 public static void main(String[] args)
{
 Scanner input = new Scanner(System.in);
 System.out.print("enter the number of subject:");
 int numsub = input.nextInt();
 int[] marks = new int[numsub];
 for (int i=0;i<numsub;i++)
 {
  System.out.print("enter marks for subject "+(i+1)+":");
  marks[i]=input.nextInt();
 }
  int totalmarks = calculateTotalMarks(marks);
  double averagepercentage = calculateAveragePercentage(totalmarks,numsub);
  char grade = assignGrade(averagepercentage);
  displayResult(totalmarks,averagepercentage,grade);
  
  input.close();
 }
  public static int calculateTotalMarks(int[] marks)
{
  int total =0;
  for(int mark:marks)
{
 total+= mark;
}
 return total;
 }
  public static double calculateAveragePercentage(int totalmarks, int numsub)
  {
   return(double) totalmarks / numsub;
  }
   public static char assignGrade(double averagePercentage)
    {
     if (averagePercentage >= 90)
      {
       return 'A';
      }
      else if (averagePercentage >=80)
      {
       return 'B';
      }
      else if(averagePercentage >=70)
      {
       return 'c';
      }
      else if(averagePercentage >=60)
      {
       return 'D';
      }
      else
      {
       return 'F';
      }
     } 
      public static void displayResult(int totalmarks,double averagepercentage, char grade)
      {
       System.out.println("Total marks:" +totalmarks);
       System.out.println("Average percentage:" +averagepercentage);
       System.out.println("Grade:" +grade);  
       }
      }
  
   