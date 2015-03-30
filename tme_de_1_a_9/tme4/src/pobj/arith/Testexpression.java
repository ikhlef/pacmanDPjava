package pobj.arith;

public class Testexpression {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--------------teste de la classe EnvEval---------");
		EnvEval e = new EnvEval(10);
		System.out.println(e.toString());
		e.setVariable(3, 4);
		System.out.println(e.toString());
		System.out.println("");
		
		System.out.println("------------------teste de la classe constante --------------");
		Constante cst = new Constante(10);
		double a =cst.eval(e);
		System.out.println("la valeur de la constante est :"+a);
		System.out.println(cst.tostring());
		System.out.println("");
		
		System.out.println("------------------teste de la classe Variable ------------");
		Variable var = new Variable(3);
		double dou =var.eval(e);
		System.out.println("la valeur de la variable "+var.toString()+" est : "+dou);
		System.out.println("");
		
		System.out.println ("---------------teste de la classe OperateurBinaire------------------------------------");
		Operator a1 = Operator.PLUS;
		Expression e1 = var;
		Expression e2 = var;
		Expression expr1 = new OperateurBinaire(a1, e1,e2);
		System.out.println("expression : " + expr1.toString());
		double valeur =expr1.eval(e);
		System.out.println("le resultat de l'expresion est : " + valeur);
		System.out.println("");
		
		System.out.println ("------------teste de la classe Expressionfactory ------");
		System.out.print("exemple d'un environnement aleatoire : ");
		EnvEval env1 = Expressionfactory.createRandomEnvironment();
		System.out.println(env1);
		System.out.println(" ");
		System.out.println("****************************************************");
		System.out.println("evoluer une expression binaire simple :");
		EnvEval en1 = new EnvEval(2);
		en1.setVariable(0,5);
		Expression ex1 = new Variable(0);
		en1.setVariable(1,15);
		Expression ex2 = new Variable(1);
		Expression opra1 =Expressionfactory.createOperateurbinaire(Operator.PLUS, ex1, ex2);
		System.out.print(opra1.toString()+ " = "+ opra1.eval(en1));
		System.out.println(" ");
		
		System.out.println("****************************************************");
		System.out.println("evoluer une expression binaire avec profondeur :");
		
		Expression exprofondeur=Expressionfactory.createRandomExpression(8);
		EnvEval envprofondeur = Expressionfactory.createRandomEnvironment();
		System.out.println(envprofondeur);
		System.out.println(exprofondeur.toString() + " = " + exprofondeur.eval(envprofondeur));
		
		
	}
}