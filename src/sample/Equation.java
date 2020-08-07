package sample;

import java.util.ArrayList;

public class Equation {
    public static int arithmetic(String expression){
        ArrayList<Integer> operand=new ArrayList<>();
        ArrayList<Character> operator=new ArrayList<>();
        int start=-1,result=0;

        for(int i=0;i<expression.length();i++){
            char cur=expression.charAt(i);

            if(cur==' '){
                continue;
            }else if(cur=='('){
                operator.add(cur);
                start=i;
            }else if(Character.isDigit(cur)){
                while(i<expression.length()&&Character.isDigit(expression.charAt(i))){
                    i++;
                }
                operand.add(Integer.valueOf(expression.substring(start+1,i)));
                start=i;
                i--;
            }else if(cur==')'){
                while(!operator.isEmpty()&&operator.get(operator.size()-1)!='('){
                    result=applyOpr(operand.get(operand.size()-2),operand.get(operand.size()-1),operator.get(operator.size()-1));
                    operand.remove(operand.size()-1);
                    operand.remove(operand.size()-1);
                    operator.remove(operator.size()-1);
                    operand.add(result);
                }
                start+=1;

                if(!operator.isEmpty()){
                    operator.remove(operator.size()-1);
                }
            }else{
                while(!operator.isEmpty()&&precedence(operator.get(operator.size()-1))>=precedence(cur)){
                    result=applyOpr(operand.get(operand.size()-2),operand.get(operand.size()-1),operator.get(operator.size()-1));
                    operand.remove(operand.size()-1);
                    operand.remove(operand.size()-1);
                    operator.remove(operator.size()-1);
                    operand.add(result);
                }
                operator.add(cur);
            }
        }

        while(!operator.isEmpty()){
            result=applyOpr(operand.get(operand.size()-2),operand.get(operand.size()-1),operator.get(operator.size()-1));
            operand.remove(operand.size()-1);
            operand.remove(operand.size()-1);
            operator.remove(operator.size()-1);
            operand.add(result);
        }


        return result;
    }
    public static int precedence(char opr){
        if(opr=='+'||opr=='-'){
            return 1;
        }else if(opr=='*'||opr=='/'){
            return 2;
        }else if(opr=='^'){
            return 3;
        }
        return 0;
    }
    public static int applyOpr(int a,int b,char opr){
        switch(opr){
            case '+':return a+b;
            case '-':return a-b;
            case '*':return a*b;
            case '/':return a/b;
            case '^':return (int)Math.pow(a,b);
        }
        return Integer.MIN_VALUE;
    }
}
