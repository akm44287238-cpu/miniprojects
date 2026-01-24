public class Calculator {


    public String doCalculations(String num1, String op , String num2 ){

        double n1=Double.parseDouble(num1);
        double n2=Double.parseDouble(num2);
        char opr = op.charAt(0);
        if(opr=='+')  return String.valueOf(Math.round((n1+n2)*100.0)/100.0);
        else if(opr=='-')  return String.valueOf(Math.round((n1-n2)*100.0)/100.0);
        else if(opr=='*')  return String.valueOf(Math.round((n1*n2)*100.0)/100.0);
        else{
            if(n2==0) return "∞";
            else return String.valueOf(Math.round((n1/n2)*100.0)/100.0);
        }
    }
}
