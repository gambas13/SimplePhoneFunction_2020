package calculator;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Calc extends calcMethod{
	Scanner sc=new Scanner(System.in);
	public Calc() {
		tokens=new ArrayList<>(10);
		postTokens=new ArrayList<>(10);
		postfix=" ";
	}
	protected int Ranking(String s) {
		if(s.equals("*")||s.equals("/"))
			return 1;
		else if(s.equals("+")||s.equals("-"))
			return 2;
		else
			return 3;
	}
	public void getCalc() {
		calc=sc.nextLine();
	}
	public void makePostFix() {
		int n=0;
		for(int i=0;i<calc.length();i++) {
			if(calc.charAt(i)==' ') {
				tokens.add(calc.substring(n,i));
				n=i+1;
			}
			else
				continue;
		}
		tokens.add(calc.substring(n,calc.length()));
		Stack<String> op =new Stack<>();
		for(int i=0;i<tokens.size();i++) {
			if(tokens.get(i).equals("("))
				op.push(tokens.get(i));
			else if(tokens.get(i).equals(")")) {
				while(!(op.peek().equals(("(")))){
					postfix=postfix.concat(op.peek());
					postfix=postfix.concat(" ");
					op.pop();
				}
				op.pop();
			}
			else if(tokens.get(i).equals("*")||tokens.get(i).equals("/")) {
				if(op.empty()||op.peek().equals("("))
					op.push(tokens.get(i));
				else {
					while(!op.empty()&&!(op.peek().equals(("(")))){
						if(Ranking(op.peek())<=1){
							postfix=postfix.concat(op.peek());
							postfix=postfix.concat(" ");
							op.pop();
						}
						else
							break;
					}
					op.push(tokens.get(i));
				}
			}
			else if(tokens.get(i).equals("+")||tokens.get(i).equals("-")) {
				if(op.empty()||op.peek().equals("("))
					op.push(tokens.get(i));
				else {
					while(!op.empty()&&!(op.peek().equals("("))) {
						if(Ranking(op.peek())<=2) {
							postfix=postfix.concat(op.peek());
							postfix=postfix.concat(" ");
							op.pop();
						}
						else
							break;
					}
					op.push(tokens.get(i));
				}
			}
			else {
				postfix=postfix.concat(tokens.get(i));
				postfix=postfix.concat(" ");
			}
		}
		while(!op.empty()) {
			if(op.peek().equals("(")||op.peek().equals(")"))
				op.pop();
			else {
				postfix=postfix.concat(op.peek());
				postfix=postfix.concat(" ");
				op.pop();
			}
		}
		if(postfix.charAt(0)==' ')
			postfix.substring(0,1);
		return;
	}
	public int evaluation() {
		int m = 0;
		for (int i = 0; i < postfix.length(); i++) {
			if (postfix.charAt(i) == ' ') {
				postTokens.add(postfix.substring(m, i));
				m = i + 1;
			}
		}//postTokens에 공백 기준으로 후위식 저장
		postTokens.add(postfix.substring(m,postfix.length()));
		Stack<Integer> num=new Stack<>();//수식의 숫자를 저장하기 위한 stack
		for(int i=0;i<postTokens.size();i++){
			if (postTokens.get(i).equals("*") || postTokens.get(i).equals("/") || postTokens.get(i).equals("+") || postTokens.get(i).equals("-")) {
				int a = num.peek();
				num.pop();
				int b = num.peek();
				num.pop();
				if (postTokens.get(i).equals("*"))
					num.push(a * b);
				else if (postTokens.get(i).equals("/")) {
					if (a == 0) {
						return 0;
					}
					num.push(b / a);
				}
				else if (postTokens.get(i).equals("+"))
					num.push(a + b);
				else if (postTokens.get(i).equals("-"))
					num.push(b - a);
			}
			else if(postTokens.get(i).equals(""))
					continue;
			else {//숫자인 경우에는 int형으로 바꾸어서 num stack에 저장
				num.push(Integer.parseInt(postTokens.get(i)));
			}
		}
		value=num.peek();//최종결과만이 stack에 남아있으므로 num.Top()
		return value;
	}
}

