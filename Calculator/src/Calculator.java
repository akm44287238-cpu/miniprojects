public class Calculator {

    private int result;

    public String doCalculations(String input){
        int check=0;
        int n=0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='+' || input.charAt(i)=='-' || input.charAt(i)=='*' || input.charAt(i)=='/'){
                n=i;
                check++;
                if(i==input.length()-1 || i==0){
                    return "Invalid Input";
                }
            }
        }
        if(check!=1){
            return "Invalid Input";
        }

        int num1=Integer.parseInt(input.substring(0,n));
        int num2=Integer.parseInt(input.substring(n+1));
        char op = input.charAt(n);
        if(op=='+')  return String.valueOf(num1+num2);
        else if(op=='-')  return String.valueOf(num1-num2);
        else if(op=='*')  return String.valueOf(num1*num2);
        else{
            if(num2==0) return "Invalid Input";
            else return String.valueOf(num1/num2);
        }
    }
}
