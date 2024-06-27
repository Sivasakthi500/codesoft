import java.util.*;
class Question
{
    String question;
    String[] options;
    int crtAnswer;
    public Question (String question,String[] options,int crtAnswer)
    {
        this.question =question;
        this.options =options;
        this.crtAnswer = crtAnswer;
    }
    public boolean Correct(int answer)
    {
        return answer == crtAnswer;
    }
}
class QuizApplication
{
    private List<Question> questions;
    private int score;
    private List<Boolean>results;
    public QuizApplication(List<Question>questions)
    {
        this.questions =questions;
        this.score=0;
        this.results =new ArrayList<>();
    }
    public void start()
    {
        Scanner input= new Scanner(System.in);
        for(Question question:questions)
        {
            System.out.println(question.question);
            for(int i=0;i<question.options.length;i++)
            {
                System.out.println((i+1)+":" + question.options[i]);
            }
            Timer timer =new Timer();
            TimerTask task = new TimerTask()
            {
                public void run()
                {
                    System.out.println("\n time up!");
                    synchronized(input)
                    {
                        input.notify();
                    }
                }
            };
            timer.schedule(task,10000);
            synchronized(input)
            {
                try{
                    int answer=input.nextInt();
                    if (question.Correct(answer -1))
                    {
                        score++;
                        results.add(true);
                    }
                    else
                    {
                        results.add(false);
                    }
                   }
                        catch (InputMismatchException e)
                        {
                        System.out.println("Invalid input . moving to the next question");
                        results.add(false);
                        input.next();
                    }
                
                }
                timer.cancel();
            }
            input.close();
            displayResult();

        }
        private void displayResult()
        {
            System.out.println("\n quiz over! ");
            System.out.println("your score:"+score+"/" + questions.size());
            System.out.println("summary of correct/Incorrect answer:");
            for(int i =0;i<results.size();i++)
            {
                System.out.println("Question"+(i+1) +";" +(results.get(i)?"correct":"Incorrect"));

            }
        }
        public static void main(String[] args)
        {
            List<Question>questions = new ArrayList<>();
            questions.add(new Question("what is the  multiple of 5*4?", new String[]{"15","20","48","30"},1));
            questions.add(new Question("what is the capital of india?", new String[]{"Gujarat","Goa","Bihar","New Delhi"},3));
            questions.add(new Question("how  many states in india?", new String[]{"28","29","38","25"},0));
            QuizApplication quiz =new QuizApplication(questions);
            quiz.start();
            }
    }
    
