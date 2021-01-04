package calculator;

import java.util.ArrayList;

public abstract class calcMethod{
	ArrayList<String> tokens;
	ArrayList<String> postTokens;
	int value;
	String postfix;
	String calc;
	abstract protected void makePostFix();
	abstract protected int evaluation();
	abstract protected int Ranking(String s);	
}
